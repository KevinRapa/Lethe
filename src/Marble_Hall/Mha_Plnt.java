package Marble_Hall;

import A_Super.Furniture;

public class Mha_Plnt extends Furniture { 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Plnt() {
        super();
        this.searchable = false;
        this.actDialog = "There's no water in this room.";
        this.useDialog = "You pour a bit of water on the plant. It seems to have appreciated that.";
        this.description = "The potted plant is in good shape. It sits in a\n"
                         + "fancy white vase.";
        this.searchDialog = "You don't feel like getting dirt on your hands.";
        this.addNameKeys("plant", "potted plant");
        this.addUseKeys("bucket of water");
        this.addActKeys("water");
    }
/*----------------------------------------------------------------------------*/
}
