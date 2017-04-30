package Jade_Hall;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Jha_Lantern extends Furniture {
    //-------------------------------------------------------------------------
    public Jha_Lantern () {
        super();

        this.description = "The paper lantern hanging from the ceiling flickers "
                         + "and lights the room dimly.";
        this.searchDialog = "You can't reach it. Probably for the best. It is "
                          + "no doubt flammable to a deadly degree.";

        this.addNameKeys("(?:hanging )?lanterns?");
    }
    //-------------------------------------------------------------------------
}


