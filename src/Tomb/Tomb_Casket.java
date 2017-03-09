package Tomb;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
abstract public class Tomb_Casket extends SearchableFurniture implements Openable, Moveable {
    // ========================================================================
    public Tomb_Casket (Item... items) {
        super(items);
        
        this.description = "The casket is just a decrepit wooden box with a\n"
                         + "couple hinges on one side. Its ominous, solemn presence\n"
                         + "in the forgotten chamber gives off a sinister vibe.";
        this.actDialog = "What a morbid thought... are you not cozy enough in this room?";
        
        this.addActKeys(SITPATTERN, "go");
        this.addNameKeys("(?:decrepit )?(?:standing )?(?:wooden )?(?:casket|box|tomb|coffin)");
    }
    // ========================================================================    
}


