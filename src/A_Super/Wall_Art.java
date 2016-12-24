package A_Super;
/**
 * Represents any type of wall art, e.g. paintings, tapestries.
 * @author Kevin Rapa
 */
public class Wall_Art extends Furniture {

    // ========================================================================
    public Wall_Art () {
        super();
        this.searchable = false;
        
        this.actDialog = "You lift it only to reveal a blank wall.";
        this.searchDialog = this.actDialog;
        
        this.addActKeys("move", "lift", "take", "slide", "remove", "admire");
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


