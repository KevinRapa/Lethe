package Observatory;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Obs1_Seat extends SearchableFurniture implements Moveable {
    // ========================================================================
    public Obs1_Seat (Item... items) {
        super(items);
        this.description = "The Victorian-era red leather seat curves slightly to\n"
                         + "match the wall's curvature. It looks stiff.";
        this.actDialog = "You rest a moment on the seat, gazing out the window at\n"
                       + "the distant lighthouse, wondering if anyone sees you.";
        this.searchDialog = "You look under the seat.";

        this.addNameKeys("(?:victorian-era )?(?:stiff )?(?:red )?(?:leather )?seat");
        this.addActKeys(SITPATTERN);
    }
    // ========================================================================   
}


