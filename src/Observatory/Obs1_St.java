package Observatory;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Obs1_St extends Furniture {

    // ========================================================================
    public Obs1_St (Item... items) {
        super(items);
        this.description = "The victorian-era red leather seat curves slightly to\n"
                         + "match the wall's curvature. It looks stiff.";
        this.actDialog = "You rest a moment on the seat, gazing out the window at\n"
                       + "the distant lighthouse, wondering if anyone sees you.";
        this.searchDialog = "You look under the seat.";

        this.addNameKeys("(?:victorian-era )?(?:stiff )?(?:red )?(?:leather )?seat");
        this.addActKeys("sit", "lay", "relax", "rest", "sleep");
    }
    // ========================================================================   
}


