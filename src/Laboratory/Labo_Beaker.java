package Laboratory;

import static A_Main.NameConstants.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Liquid;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Beaker extends Furniture {
    
    private enum Potion {
        EMPTY("nothing."), 
        GEN_POTION("A mystery liquid."), 
        PHASE_DOOR("the phase door potion.");
        // ==================================
        private final String NAME;
        // ==================================
        Potion(String name) {
            this.NAME = name;
        }
        // ==================================
        @Override public String toString() {
            return NAME;
        } 
        // ==================================
    }

    private Potion mode;
    private final Item BEAKER_REF, PHASE_POTION, GENERIC_POTION;
    // ========================================================================
    public Labo_Beaker (Item beakerItem) {
        super();

        this.mode = Potion.EMPTY;
        
        this.BEAKER_REF = beakerItem;
        this.PHASE_POTION = new Liquid(PHASE_DOOR_POTION, "It's a smoky brown liquid. You pray that this potion does what the recipe said...",
                                     "You don't know the duration. Better get out to the front gate before drinking this!!");
        this.GENERIC_POTION = new Liquid(POTION_OF_SCIENCE, "This doesn't look how the manual described... It looks potion-ey, better throw it out though.");
        
        this.description = "The beaker contains ";
        this.useDialog = "That's not it's proper function right now!";
        this.actDialog = "You take the beaker off of the contraption.";

        this.addUseKeys("\\w+ \\d{1,2}mL");
        this.addNameKeys(BEAKER);
        this.addActKeys(GETPATTERN);
        this.addActKeys("drink");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.description.concat(mode.toString());
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("drink")) {
            return "You can't do that while it's still on the table!";
        }
        else {
            Player.getPos().removeFurniture(this);
            
            switch (mode) {
                case EMPTY:
                    Player.getInv().add(BEAKER_REF);
                    break;
                case GEN_POTION:
                    Player.getInv().add(GENERIC_POTION);
                    break;
                case PHASE_DOOR:
                    Player.getInv().add(PHASE_POTION);
            }
            
            this.mode = Potion.EMPTY;
            
            return this.actDialog;
        }
    }
    // ======================================================================== 
    public void setMode(int mode) {
        if (this.mode != Potion.EMPTY) {
            this.mode = Potion.GEN_POTION;
        }
        else    
            switch(mode) {
                case 0:
                    this.mode = Potion.GEN_POTION;
                    break;
                default:
                    this.mode = Potion.PHASE_DOOR;
            }
    }
    // ======================================================================== 
}


