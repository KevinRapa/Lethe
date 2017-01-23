package Caves;

import A_Super.Furniture;
/**
 * The 'Source'
 * 
 * @author Kevin Rapa
 */
public class Cv_Well extends Furniture {
    // ========================================================================
    public Cv_Well () {
        super();

        this.actDialog = "That is definitely not a good idea!";
        this.description = "You peer down the well. It seems to go on for a couple\n"
                         + "hundred feet. A bright green glow emanates from far below.\n";
        this.searchDialog = this.description;

        this.addNameKeys("(?:ancient )?well");
        this.addActKeys("jump", "climb");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Cave.distortDescription(4, description);
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
    // ========================================================================       
    @Override public String interact(String key) {
        return Cave.distortDescription(4, actDialog);
    }
    // ========================================================================       
}


