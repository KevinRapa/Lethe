package Gallery;

import A_Main.GUI;
import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Player;

public class Gal1_Drgn extends LghtMchn {
    private final Gal_1E_Stat STAT_REF;
    private boolean leftOn, rightOn;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Drgn(Furniture stat, Item... items) {
        super();
        this.searchDialog = "The only place to search is the dragon's mouth.";
        this.turnOffDialog = "The light in the dragon's mouth shuts off.";
        this.description = "The room's most prominent piece is this detailed\n"
                         + "dark green dragon statue. It looks original to east\n"
                         + "Asia. Its serpent-like body twists around and it stares\n"
                         + "menacingly ";
        this.STAT_REF = (Gal_1E_Stat) stat;
        leftOn = rightOn = false;
        beam = 'y';
        mode = "A yellow beam";
        addNameKeys("dragon", "snake-like dragon", "statue", "dragon statue");
        this.inv = new Drgn_Inv(items);    
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (leftOn && ! rightOn) 
            return description.concat("at the statue in the central chamber.\n"
                                    + "Its left eye glows brightly from an unknown source.");
        
        else if (! leftOn && rightOn) 
            return description.concat("at the statue in the central chamber.\n"
                                    + "Its right eye glows brightly from an unknown source.");
        
        else if (leftOn && rightOn) 
            return description.concat("with its two eyes lit. A light from within\n"
                                    + "the dragon shines brightly through its mouth.");
        else
            return description.concat("with cold eyes at the statue in the central chamber.");
    }
/*----------------------------------------------------------------------------*/    
    public String switchRight() {
        rightOn = ! rightOn;
        
        String rep = rightOn ? "The dragon's right eye lights up." :
                               "The glow in the dragon's right eye fades. ";
        
        if (rightOn && leftOn)
            rep += this.turnOn();
        else if (isOn)
            rep += this.turnOff();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    public String switchLeft() {
        leftOn = ! leftOn;
        
        String rep = leftOn ? "The dragon's left eye begins to glow." :
                              "The glow in the dragon's left eye fades. ";
        
        if (rightOn && leftOn)
            rep += this.turnOn();
        else if (isOn)
            rep += this.turnOff();
        
        return rep;
    }
/*----------------------------------------------------------------------------*/    
    private String turnOn() {
        this.determineColor();
        this.isOn = true;       
        return mode + " emits from the dragon's mouth. " + STAT_REF.activate(beam, true);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You place the " + item + " into the dragon's mouth.";
        Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/    
    private class Drgn_Inv extends Inventory {   
        public Drgn_Inv(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) { 
            if (item.getType().matches("focus")) {
                this.CONT.add(item);
                this.trigger();
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {
            this.CONT.remove(removeThis);
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
                GUI.out(mode + " emits from the dragon's mouth. " + STAT_REF.activate(beam, true));
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/ 
}

