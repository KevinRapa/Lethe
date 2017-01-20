package Gallery;

import A_Main.GUI;
import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.NameConstants;
/**
 * One of four elements of the light machine puzzle in the gallery.
 * Foci must be added to this in the correct order while the statue is holding
 * the funny orb in order to raise the statue to the next level.
 * 
 * @see Gallery.Gal2_Statue
 * @author Kevin Rapa
 */
public class Gal1_Dragon extends Gal_LightMachine {
    private final Gal2_Statue GAL2_STAT_REF;
    private final boolean[] EYES = {false, false};
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Dragon(Furniture stat, Item... items) {
        super();
        this.searchDialog = "The only place to search is the dragon's mouth.";
        this.turnOffDialog = "The light in the dragon's mouth shuts off.";
        this.description = "The room's most prominent piece is this detailed\n"
                         + "dark green dragon statue. It looks original to east\n"
                         + "Asia. Its serpent-like body twists around and it stares\n"
                         + "menacingly ";
        this.GAL2_STAT_REF = (Gal2_Statue) stat;
        addNameKeys("snake-like dragon(?: statue)?", "(?:dragon|statue)");
        this.inv = new Drgn_Inv(items);    
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (this.isOn) 
            return description.concat("with its two eyes lit. A light from within\n"
                                    + "the dragon shines brightly through its mouth.");
        else if (EYES[0] && ! EYES[1]) 
            return description.concat("at the statue in the central chamber.\n"
                                    + "Its left eye glows brightly from an unknown source.");
        else if (! EYES[0] && EYES[1]) 
            return description.concat("at the statue in the central chamber.\n"
                                    + "Its right eye glows brightly from an unknown source.");
        else
            return description.concat("with cold eyes at the statue in the central chamber.");
    }
/*----------------------------------------------------------------------------*/    
    public String switchEye(int i) {
        // 0 is left, 1 is right
        EYES[i] = ! EYES[i];
        String eye = (i == 0) ? "left" : "right";
        
        String rep = EYES[i] ? "The dragon's " + eye + " eye lights up. " :
                               "The glow in the dragon's " + eye + " eye fades. ";
        
        if (EYES[0] && EYES[1])
            return rep.concat(this.turnOn());
        else if (isOn)
            return rep.concat(this.turnOff());
        else
            return rep;
    }
/*----------------------------------------------------------------------------*/    
    @Override protected String turnOn() {
        this.determineColor();
        this.isOn = true;       
        return mode + " emits from the dragon's mouth. " + GAL2_STAT_REF.activate(beam);
    }
/*----------------------------------------------------------------------------*/
    @Override protected void resetStatue() {
        this.GAL2_STAT_REF.reset();
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
            if (item.getType().equals(NameConstants.FOCUS)) {
                this.CONTENTS.add(item);
                
                if (Gal1_Dragon.this.isOn)
                    this.trigger();
                else
                    GUI.out("You place the " + item + " into the dragon's mouth.");
                
                return true;
            }
            else {
                GUI.out("The " + item + " doesn't look like it belongs there.");
                return false;
            }
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            
            if (Gal1_Dragon.this.isOn)
                this.trigger();
        }
        /*--------------------------------------------------------------------*/
        private void trigger() {
            determineColor();
            GUI.out(mode + " emits from the dragon's mouth. " + GAL2_STAT_REF.activate(beam));
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/ 
}

