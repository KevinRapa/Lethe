package Gallery;

import A_Super.Carpet;
/**
 * @author Kevin Rapa
 */
public class Gal4_Carpet extends Carpet {

    //-------------------------------------------------------------------------
    public Gal4_Carpet () {
        super();
        
        this.searchDialog = "You walk along the balcony, scanning the carpet for "
                          + "irregularities and lifting it every now and then. "
                          + "You can't seem to find anything of interest.";
        this.description = "An luxurious looking rug, as are the rest in this "
                         + "castle. Woven into the rug along the edges "
                         + "are fine golden meandering designs.";

        this.addNameKeys("(?:royal )?(?:blue )?carpet(?: runner)");
    }
    //-------------------------------------------------------------------------    
}


