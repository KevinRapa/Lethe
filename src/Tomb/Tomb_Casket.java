package Tomb;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Container;
/**
 * @author Kevin Rapa
 */
abstract public class Tomb_Casket extends Furniture implements Container {
    // ========================================================================
    public Tomb_Casket (Item... items) {
        super(items);
        
        this.description = "The casket is just a decrepit wooden box with a\n"
                         + "couple hinges on one side. Its ominous, solemn presence\n"
                         + "in the forgotten chamber gives off a sinister vibe.";

        this.addNameKeys("(?:decrepit )?(?:standing )?(?:wooden )?(?:casket|box|tomb|coffin");
    }
    // ========================================================================    
}


