package Gallery;

import Main.Player;
import Super.Item;
import Super.Furniture;

public class Gal1_Drgn extends Furniture {
    private boolean isOn;
    private final Gal_1E_Stat REF;
    private char beam;
    private String mode;
    private boolean leftEye, rightEye;
            
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Drgn(Furniture stat, Item... items) {
        super();
        this.searchDialog = "The only place to search is the dragon's mouth.";
        this.REF = (Gal_1E_Stat) stat;
        this.leftEye = false;
        this.rightEye = false;
        this.isOn = true;
        this.beam = 'y';
        this.mode = "A yellow beam";
        this.addNameKeys("snake-like dragon", "dragon");
        this.addUseKeys("red focus", "blue focus", "yellow focus", "dark focus");
        this.inv = new Drgn_Inv(this, items);
        
        Stat_Inv temp = (Stat_Inv) stat.getInv();
        temp.addDrgnREF(this); // Shouldn't cause problems.        
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        this.description = "The room's most prominent piece is this detailed\n"
                         + "dark green dragon statue. It looks original to east\n"
                         + "Asia. Its serpent-like body twists around and it stares\n"
                         + "menacingly ";
        
        if (this.leftEye && ! this.rightEye) {
            this.description += "at the statue in the central chamber.\n"
                              + "Its left eye glows brightly from an unknown source.";
        }
        if (! this.leftEye && this.rightEye) {
            this.description += "at the statue in the central chamber.\n"
                              + "Its right eye glows brightly from an unknown source.";
        }
        if (this.leftEye && this.rightEye) {
            this.description = "with its two eyes lit. A light from within\n"
                             + "the dragon shines brightly through its mouth.";
        }
        if (! this.leftEye && ! this.rightEye) {
            this.description += "with cold eyes at the statue in the\n"
                              + "central chamber.";
        }
        return this.description; 
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
        if (! dark) {        
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
    public String switchRight() {
        String rep;
        this.rightEye = ! this.rightEye;
        
        if (this.rightEye)
            rep = "The dragon's right eye lights up.";
        else
            rep = "The glow in the dragon's right eye fades.";
        
        if (this.rightEye && this.leftEye)
            rep += "\n" + this.turnOn();
        else if (this.isOn)
            rep += "\n" + this.turnOff();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    public String switchLeft() {
        String rep;
        this.leftEye = ! this.leftEye;
        
        if (this.leftEye)
            rep = "The dragon's left eye begins to glow.";
        else
            rep = "The glow in the dragon's left eye fades.";
        
        if (this.rightEye && this.leftEye)
            rep += "\n" + this.turnOn();
        else if (this.isOn)
            rep += "\n" + this.turnOff();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    private String turnOn() {
        this.isOn = true;       
        
        String rep2 = REF.activate(this.beam, this);
        return this.mode + " emits from the dragon's mouth.\n" + rep2;
    }
/*----------------------------------------------------------------------------*/    
    private String turnOff() {
        this.isOn = false;       
        
        return "The light in the dragon's mouth shuts off.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You place the " + item + " into the dragon's mouth.";
        Player.getINV().give(item, this.inv);
        
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

