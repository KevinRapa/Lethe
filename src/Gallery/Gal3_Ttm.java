package Gallery;

import A_Super.Item;
import A_Main.GUI;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Player;

public class Gal3_Ttm extends LghtMchn {
    private final Gal_2E_Stat GAL4STAT;
    private boolean headOne, headTwo, headThree, headFour;    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Ttm(Furniture stat, Item... items) {
        super();
        this.searchDialog = "The only place to search is the totem's open\n"
                          + "third mouth. ";
        this.actDialog = "You back away from the totem";
        this.turnOffDialog = "The lights in the totem's eyes and mouth fade.";
        this.searchable = false;
        this.GAL4STAT = (Gal_2E_Stat) stat;
        this.headOne = headTwo = headThree = headFour = false;
        this.beam = 'c';
        this.mode = "A clear scattered light";
        this.addActKeys("turn", "spin", "twist");
        this.addNameKeys("wood totem", "totem", "wooden totem");
        this.inv = new Ttm_Inv(items);       
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        return "The tall wooden totem stands back against the west\n"
             + "wall facing the central chamber. Its four stacked\n"
             + "segments are carved to resemble obscure faces.\n" + numBackwards() +
               "\nOn each side of the segments is a peg sticking out.";
    }
/*----------------------------------------------------------------------------*/ 
    private String numBackwards() {
        int numBackwards = 0;
        
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
                return "All of them face forward. From the third shines a light.";
            case 1:
                return "One of them faces back towards the wall.";
            case 2:
                return "Two of them face back towards the wall.";
            case 3:
                return "Three of them face back towards the wall.";
            default:
                return "All of them face back towards the wall.";
        }
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (! this.searchable)
            rep += "The head is facing towards the wall.";
        
        return rep; 
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {  
        String action, result = "";
        boolean solved = false;
        
        do {
            String four = this.headFour ?        "-[-_-]-  4" :      "-[   ]-  4";
            String three = this.headThree ? "\t   -[-o-]-  3" : "\t   -[   ]-  3";
            String two = this.headTwo ?     "\t   -[-_-]-  2" : "\t   -[   ]-  2";
            String one = this.headOne ?     "\t   -[-_-]-  1" : "\t   -[   ]-  1";
        
            GUI.out("           " + four + "       \t" + three + "\t\t" + 
                       two + "\t\t" + one + "\t\t\t\t\t\t" + result);
        
            GUI.menOut("<#> Turn head\n< > Back");           

            action = GUI.promptOut();
        
            if (action.matches("[1234]")) {
                int head = Integer.parseInt(action);
                this.turnHead(head);
                solved = this.allForward();
            }
            
            if (solved)
                result = this.turnOn();
            else if (isOn)
                result = this.turnOff();
            else
                result = "";
                       
        } while (! action.matches(""));
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    private boolean allForward() {
        return headOne && headTwo && headThree && headFour;
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
            default:
                this.headThree = ! this.headThree;
                this.headFour = ! this.headFour;
        }
        this.searchable = this.headThree;
    }
/*----------------------------------------------------------------------------*/     
    private String turnOn() {
        this.determineColor();
        this.isOn = true;       
        
        String rep2 = GAL4STAT.activate(this.beam, true);
        return "The totem's eyes begin to glow.\n"
                + this.mode + " emits from the totem's third mouth.\n" + rep2;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You place the " + item + " in the totem's mouth.";
        Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/     
    private class Ttm_Inv extends Inventory {   
        public Ttm_Inv(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) { 
            if (item.getType().matches("focus")) {
                this.CONTENTS.add(item);
                this.trigger();
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            this.trigger();
        }
        /*--------------------------------------------------------------------*/
        @Override public void give(Item item, Inventory giveToThis) {
            if (giveToThis.add(item))
                this.remove(item);   
        }
        /*--------------------------------------------------------------------*/
        private void trigger() {   
            determineColor();
            
            if (isOn)
                GUI.out(mode + " emits from the statue's mouth.\n" + GAL4STAT.activate(beam, true)); 
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/ 
}
