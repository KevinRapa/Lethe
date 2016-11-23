package Marble_Hall;

import Super.Furniture;

public class Mha_Plnt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Plnt(String NAME) {
        super(NAME);
        this.searchable = false;
        this.interactDialog = "There's no water in this room.";
        this.description = "The potted plant is in good shape. It sits in a\n"
                         + "fancy white vase.";
        this.searchDialog = "You don't feel like getting dirt on your hands.";
        this.addNameKeys("plant", "potted plant");
        this.addActKeys("water");
    }
/*----------------------------------------------------------------------------*/
}
