package Tunnels;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * Provides a description of the tunnel for the player.
 * @author Kevin Rapa
 */
public class Sew_Tunnel extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Sew_Tunnel () {
        super();

        this.description = "This underground tunnel is warm and humid. The tunnel " +
                           "is about 20 feet wide and has an arched ceiling about " +
                           "20 feet above. A river flows down its length along one " +
                           "wall. The tunnel is lit with many torches nailed to the "
                         + "walls.";
        this.searchDialog = "The tunnel is too large to do that.";

        this.addNameKeys("(?:warm )?(?:humid )?(?:underground )?tunnel", "(?:tunnel )?ceiling");
    }
    //------------------------------------------------------------------------- 
}


