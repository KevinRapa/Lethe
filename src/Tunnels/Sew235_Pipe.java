package Tunnels;

import static A_Main.Names.PIECE_OF_PIPE;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sew235_Pipe extends Furniture {
    //-------------------------------------------------------------------------
    public Sew235_Pipe (int room) {
        super();

        switch(room) {
            case 2:
                description = "The rusty metal pipe runs out the top of the console "
                            + "on the south wall, along the ceiling to the "
                            + "north side of the room, and along the length of "
                            + "the tunnel westward.";
                break;
            case 3:
                description = "The metal pipe is bracketed to the ceiling "
                            + "over the river below. It's very rusty from the "
                            + "apparent years of neglect.";
                break;
            case 5:
                description = "The rusty metal pipe runs around the bend along "
                            + "the ceiling and into the wall above the door to the west.";
                break;
        }

        this.searchDialog = "It doesn't seem to be hiding anything.";
        this.useDialog = "There's nothing missing from the pipe in this area!";

        this.addNameKeys("(?:large )?(?:rusty )?(?:metal )?pip(?:e|ing)");
        this.addUseKeys(PIECE_OF_PIPE);
    }
    //------------------------------------------------------------------------- 
}


