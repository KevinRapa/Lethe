package Ancient_Tomb;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
/**
 * @author Kevin Rapa
 */
public class Ant_Cskts extends Furniture implements Container {
    // ========================================================================
    public Ant_Cskts (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The various ramshackle coffins are pieced together\n"
                         + "with many nailed-together wooden planks.";
        this.searchDialog = "You are being watched... best not to do that.";

        this.addNameKeys("caskets", "wooden caskets");
    }
    // ========================================================================  
}


