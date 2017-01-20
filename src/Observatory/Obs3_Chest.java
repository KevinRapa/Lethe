package Observatory;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Obs3_Chest extends Furniture implements Openable {
    // ========================================================================
    public Obs3_Chest(Item... items) {
        super(items);
        this.description = "It's a wooden chest. 'Looks like the kind with\n"
                         + "treasure in it,' you think to yourself.";
        this.searchDialog = "To your surprise, the chest is unlocked. You open it.";

        this.addNameKeys("(?:wooden )?chest");
    }
    // ========================================================================   
}


