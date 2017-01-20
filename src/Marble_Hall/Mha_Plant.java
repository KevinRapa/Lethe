package Marble_Hall;

import A_Super.Furniture;
import A_Super.Item;

public class Mha_Plant extends Furniture { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Plant(Item ... items) {
        super(items);
        this.actDialog = "There's no water in this room.";
        this.useDialog = "You pour a bit of water on the plant. It seems to have appreciated that.";
        this.description = "The potted plant is in good shape. It sits in a\n"
                         + "fancy white vase.";
        this.searchDialog = "You look in the pot.";
        this.addNameKeys("plant", "potted plant");
        this.addUseKeys("bucket of water");
        this.addActKeys("water");
    }
/*----------------------------------------------------------------------------*/
}
