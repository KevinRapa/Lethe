package Garden;

import A_Super.Column;
/**
 * @author Kevin Rapa
 */
public class Gar2_Columns extends Column {
    // ========================================================================
    public Gar2_Columns () {
        super();

        this.description = "The four Corinthian-style pillars hold up a circular "
                         + "stone rim, on which sits a paned glass dome.";

        this.addNameKeys("(?:stone |corinthian )?(?:column|pillar)s?");
    }
    // ========================================================================   
}


