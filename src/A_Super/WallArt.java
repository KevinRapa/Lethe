package A_Super;

import static A_Main.Names.*;

/**
 * Represents any type of wall art, e.g. paintings, tapestries.
 * @author Kevin Rapa
 */
abstract public class WallArt extends Furniture {
    //-------------------------------------------------------------------------
    public WallArt () {
        super();

        this.actDialog = "You lift it only to reveal a blank wall.";
        this.searchDialog = this.actDialog;
        this.useDialog = "You can't bring yourself to destroy such an expensive object.";
        
        this.addActKeys(GETPATTERN);
        this.addActKeys("move", "lift", "slide", "admire");
        this.addUseKeys(HAND_TORCH, ACETONE, CANDLE, 
                BOTTLE_OF_VINEGAR, BOTTLE_OF_WINE);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("admire"))
            return "Yes, what a beautiful piece of artwork. You take a moment "
                 + "to soak in the creative essence. Yes...";
        else
            return this.actDialog;
    }
    //-------------------------------------------------------------------------        
}


