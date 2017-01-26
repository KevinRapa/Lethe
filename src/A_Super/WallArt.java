package A_Super;
/**
 * Represents any type of wall art, e.g. paintings, tapestries.
 * @author Kevin Rapa
 */
abstract public class WallArt extends Furniture {
    // ========================================================================
    public WallArt () {
        super();

        this.actDialog = "You lift it only to reveal a blank wall.";
        this.searchDialog = this.actDialog;
        
        this.addActKeys(GETKEYS);
        this.addActKeys("move", "lift", "slide", "admire");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches("admire"))
            return "Yes, what a beautiful piece of artwork. You take a moment\n"
                 + "to soak in the creative essence. Yes...";
        else
            return this.actDialog;
    }
    // ========================================================================        
}


