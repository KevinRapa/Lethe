package Gallery;

import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Player;

public class Gal6_Cnn extends Furniture {
    private boolean isOn;
    private final Gal_3E_Stat REF;
    private char beam;
    private String mode;
            
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Cnn(Furniture stat, Item... items) {
        super();
        this.searchDialog = "You search around the futuristic cannon.";
        this.actDialog = "You have no idea how this thing works.";
        this.description = "This thing looks complicated. It's black, and... it\n"
                         + "has some kind of big ball for a body. And it's metal.\n"
                         + "Yeah, you're sure that's metal. It has a long barrel\n"
                         + "coming out the front with slots in it and the whole\n"
                         + "thing is covered in lights and wires. Wait... there's\n"
                         + "an empty square compartment on top. What is that for?\n"
                         + "And there's a weird switch thing over here on the\n"
                         + "other side.";
        this.searchable = true;
        this.REF = (Gal_3E_Stat) stat;
        this.isOn = false;
        this.beam = 'c';
        this.mode = "A clear scattered light";
        this.addActKeys("fire", "shoot");
        this.addNameKeys("electronic canon", "electric canon", "canon");
        this.addUseKeys("red focus", "blue focus", "yellow focus", "dark focus", "box thingy");
        this.inv = new Cnn_Inv(this, items);       
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {    
        String rep = this.description; 
        
        if (this.doesThisHaveIt("metal box thingy with wires") && ! this.isOn) {
            rep = "The battery fits like a glove in that top compartment! But\n"
                + "why aren't the light all lighting up and bleeping?";
        }
        else if (this.isOn) {
            rep = "The cannon is blinking and making bleeping noises.\n"
                + "A ray of light shoots out the barrel too. It must be on!";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    public String triggerEvent(String item) {
        if (! item.matches("box thingy")) {
            boolean red = false; boolean blue = false; 
            boolean yellow = false; boolean dark = false;      
        
            for (Item i : this.inv) {
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
        else if (this.doesThisHaveIt("metal box thingy with wires"))
            return "The box fits nicely in the slot on top. It's a battery!";
        
        else if (! this.doesThisHaveIt("metal box thingy with wires") && this.isOn)
            return this.turnOff();
        
        return "";
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
            return mode + " shoots out the front of the cannon.\n" + REF.activate(this.beam, this); 
        }
    return "";    
    }
/*----------------------------------------------------------------------------*/    
    public String turnOn() {
        this.isOn = true;       
        
        String rep2 = REF.activate(this.beam, this);
        return "The lights on the cannon light up and start bleeping!\n"
                + this.mode + " emits from the barrel.\n" + rep2;
    }
/*----------------------------------------------------------------------------*/    
    public String turnOff() {
        this.isOn = false;       
        
        return "The lights on the cannon stop blinking.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().matches("box thingy"))
            this.useDialog = "You place the " + item + " in the compartment.";
        else
            this.useDialog = "The box fits nicely in the slot on top. It's a battery!";
        
        Player.getInv().give(item, this.inv);
        
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
