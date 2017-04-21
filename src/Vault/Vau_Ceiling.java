package Vault;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Vau_Ceiling extends Furniture {
    //-------------------------------------------------------------------------
    public Vau_Ceiling () {
        super();

        this.description = "The ceiling is sandstone like the rest of the room. "
                         + "It arches only feet above your head and gradually "
                         + "slopes down on either side of you meeting the floor.";

        this.addNameKeys("(?:low )?(?:arched )?ceiling");
    }
    //-------------------------------------------------------------------------    
}


