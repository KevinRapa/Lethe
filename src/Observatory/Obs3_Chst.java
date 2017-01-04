package Observatory;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
/**
 * @author Kevin Rapa
 */
public class Obs3_Chst extends Furniture implements Container {
    // ========================================================================
    public Obs3_Chst(Item... items) {
        super(items);
        this.description = "It's a wooden chest. 'Looks like the kind with\n"
                         + "treasure in it,' you think to yourself.";
        this.searchDialog = "To your surprise, the chest is unlocked. You open it.";

        this.addNameKeys("(?:wooden )?chest");
    }
    // ========================================================================   
}


