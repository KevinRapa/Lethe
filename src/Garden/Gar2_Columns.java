package Garden;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar2_Columns extends Furniture {
    // ========================================================================
    public Gar2_Columns () {
        super();
        this.searchable = false;
        
        this.description = "The four corinthian-style pillars hold up a circular\n"
                         + "stone rim, on which sits a paned glass dome.";

        this.addNameKeys("(?:stone |corinthian )?(?:column|pillar)s?");
    }
    // ========================================================================   
}


