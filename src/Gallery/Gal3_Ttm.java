package Gallery;

import Super.Item;
import Core.GUI;
import Super.Furniture;
import Core.Inventory;
import Super.Room;

public class Gal3_Ttm extends Furniture{
    private boolean isOn;
    private final Gal_2E_Stat REF;
    private final Inventory REF2;
    private char beam;
    private String mode;
    private boolean headOne, headTwo, headThree, headFour;
            
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Ttm(String NAME, Furniture stat, Inventory inv, Item ... items) {
        super(NAME);
        this.searchDialog = "The only place to search is the totem's open\n"
                          + "third mouth. ";
        this.interactDialog = "You back away from the totem";
        this.searchable = false;
        this.REF = (Gal_2E_Stat) stat;
        this.REF2 = inv;
        this.headOne = false;
        this.headTwo = false;
        this.headThree = false;
        this.headFour = false;
        this.isOn = false;
        this.beam = 'c';
        this.mode = "A clear scattered light";
        this.addActKeys("turn", "spin", "twist");
        this.addNameKeys("wood totem", "totem", "wooden totem");
        this.addUseKeys("red focus", "blue focus", "yellow focus", "dark focus");
        this.inv = new Ttm_Inv(this, items);       
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        int numBackwards = 0;
        String rep = null;
        
        if (! this.headOne)
            numBackwards++;
        if (! this.headTwo)
            numBackwards++;
        if (! this.headThree)
            numBackwards++;
        if (! this.headFour)
            numBackwards++;
        
        switch(numBackwards) {
            case 0:
                rep = "All of them face forward. From the third shines a light.";
                break;
            case 1:
                rep = "One of them faces back towards the wall.";
                break;
            case 2:
                rep = "Two of them face back towards the wall.";
                break;
            case 3:
                rep = "Three of them face back towards the wall.";
                break;
            case 4:
                rep = "All of them face back towards the wall.";
        }
       
        this.description = "The tall wooden totem stands back against the west\n"
                         + "wall facing the central chamber. Its four stacked\n"
                         + "segments are carved to resemble obscure faces.\n" + rep +
                           "\nOn each side of the segments is a peg sticking out.";
        
        return this.description; 
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (! this.searchable)
            rep += "The head is facing towards the wall.";
        
        return rep; 
    }
/*----------------------------------------------------------------------------*/
    public String triggerEvent() {
        boolean red = false; boolean blue = false; 
        boolean yellow = false; boolean dark = false;      
        
        for (Item i : this.inv.getInv()) {
            if (i.toString().matches("red focus"))
                red = true;
            if (i.toString().matches("blue focus"))
                blue = true;
            if (i.toString().matches("yellow focus"))
                yellow = true;
            if (i.toString().matches("dark focus"))
                dark = true;
        }        
        return this.determineColor(red, blue, yellow, dark);
    }
/*----------------------------------------------------------------------------*/
    private String determineColor(boolean red, boolean blue, boolean yellow, boolean dark) {
        if (dark == false) {        
            if (red && ! blue && ! yellow) {
                this.beam = 'r'; this.mode = "A red beam"; 
            }
            else if (! red && blue && ! yellow) {
                this.beam = 'b'; this.mode = "A blue beam"; 
            }
            else if (! red && ! blue && yellow) {
                this.beam = 'y'; this.mode = "A yellow beam"; 
            }
            else if (red && blue && ! yellow) {
                this.beam = 'p'; this.mode = "A purple beam"; 
            }
            else if (! red && blue && yellow) {
                this.beam = 'g'; this.mode = "A green beam"; 
            }
            else if (red && ! blue && yellow) {
                this.beam = 'o'; this.mode = "An orange beam"; 
            }
            else if (red && blue && yellow) {                  
                this.beam = 'w'; this.mode = "A white beam"; 
            }
            else if (! red && ! blue && ! yellow) {
                this.beam = 'c'; this.mode = "A clear scattered light"; 
            }
        }
        else {
            if (red && ! blue && ! yellow) {
                this.beam = 'R'; this.mode = "A dark red beam"; 
            }
            else if (! red && blue && ! yellow) {
                this.beam = 'B'; this.mode = "A dark blue beam"; 
            }
            else if (! red && ! blue && yellow) {
                this.beam = 'Y'; this.mode = "A dark yellow beam"; 
            }
            else if (red && blue && ! yellow) {
                this.beam = 'P'; this.mode = "A dark purple beam"; 
            }
            else if (! red && blue && yellow) {
                this.beam = 'G'; this.mode = "A dark green beam"; 
            }
            else if (red && ! blue && yellow) {
                this.beam = 'O'; this.mode = "A dark orange beam"; 
            }
            else if (red && blue && yellow) {                  
                this.beam = 'D'; this.mode = "A dark beam"; 
            }
            else if (! red && ! blue && ! yellow) {
                this.beam = 'W'; this.mode = "Barely any light"; 
            }       
        }            
        if (this.isOn) {
            return mode + " emits from the statues mouth.\n" + REF.activate(this.beam, this); 
        }
        return "";
    }
/*----------------------------------------------------------------------------*/    
    @Override  public String interact(Room[][][] map, String key) {  
        String action;
        boolean solved = false;
        
        do {
            String four = this.headFour ?        "-[-_-]-  4" :      "-[   ]-  4";
            String three = this.headThree ? "\t   -[-o-]-  3" : "\t   -[   ]-  3";
            String two = this.headTwo ?     "\t   -[-_-]-  2" : "\t   -[   ]-  2";
            String one = this.headOne ?     "\t   -[-_-]-  1" : "\t   -[   ]-  1";
        
            GUI.out("           " + four + "       \t" + three + "\t\t" + 
                       two + "\t\t" + one);
        
            GUI.menOut("-1, 2, 3, 4- Turn head\n- - Back");           

            action = GUI.promptOut();
        
            if (action.matches("[1234]")) {
                int head = Integer.parseInt(action);
                this.turnHead(head);
                solved = this.allForward();
            }
            
            if (solved)
                GUI.out(this.turnOn());
            else if (! solved && this.isOn)
                GUI.out(this.turnOff());
                       
        } while (! action.matches(""));
        
        return this.interactDialog;
    }
/*----------------------------------------------------------------------------*/
    private boolean allForward() {
        boolean solved = false;
        
        if (this.headOne && this.headTwo && this.headThree && this.headFour)
            solved = true;
        
        return solved;
    }
/*----------------------------------------------------------------------------*/
    private void turnHead(int head) {
        switch(head) {
            case 1:
                this.headOne = ! this.headOne;
                this.headFour = ! this.headFour;
                break;
            case 2:
                this.headTwo = ! this.headTwo;
                this.headThree = ! this.headThree;
                this.headFour = ! this.headFour;
                break;
            case 3:
                this.headOne = ! this.headOne;
                this.headThree = ! this.headThree;
                this.headFour = ! this.headFour;
                break;
            case 4:
                this.headThree = ! this.headThree;
                this.headFour = ! this.headFour;
                break;
        }
        this.searchable = this.headThree;
    }
/*----------------------------------------------------------------------------*/     
    private String turnOn() {
        this.isOn = true;       
        
        String rep2 = REF.activate(this.beam, this);
        return "The totem's eyes begin to glow.\n"
                + this.mode + " emits from the totem's third mouth.\n" + rep2;
    }
/*----------------------------------------------------------------------------*/    
    private String turnOff() {
        this.isOn = false;       
        
        return "The lights in the totem's eyes and mouth fade.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You place the " + item + " in the totem's mouth.";
        REF2.give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    public boolean isOn() {
        return this.isOn;
    }
/*----------------------------------------------------------------------------*/
    public char getBeam() {
        return this.beam;
    }
/*----------------------------------------------------------------------------*/
}
