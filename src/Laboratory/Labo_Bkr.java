package Laboratory;

import static A_Main.NameConstants.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @see Laboratory.Labo for solution
 * @author Kevin Rapa
 */
public class Labo_Bkr extends Furniture {
    
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
    public Labo_Bkr (Item beakerItem) {
        super();
        this.searchable = false;
        
        this.mode = Potion.EMPTY;
        
        this.BEAKER_REF = beakerItem;
        this.PHASE_POTION = new Item(PHASE_DOOR_POTION, "It's a smoky brown liquid. You pray that this potion does what the tome said...",
                                     "You don't know the duration. Better get out to the front gate before drinking this!!");
        this.GENERIC_POTION = new Item(POTION_OF_SCIENCE, "This doesn't look how the manual described... It looks potion-ey, better throw it out though.");
        
        this.description = "The beaker contains ";
        this.actDialog = "You take the beaker off of the contraption.";

        this.addNameKeys(BEAKER);
        this.addActKeys(GETKEYS);
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
            
            return this.actDialog;
        }
    }
    // ======================================================================== 
    public void setMode(int mode) {
        if (this.mode != Potion.EMPTY)
            this.mode = Potion.GEN_POTION;
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


