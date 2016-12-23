package Garden;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar2_BrknHs extends Furniture {

    // ========================================================================
    public Gar2_BrknHs () {
        super();
        this.searchable = false;
        
        this.description = "The old leather hose has broken it two... at just the\n"
                         + "right time.";
        this.actDialog = "It has broken. It has no purpose now.";

        this.addNameKeys("(?:broken )?(?:leather )?hose");
        this.addActKeys("untie", "climb");
    }
    // ========================================================================  
}


