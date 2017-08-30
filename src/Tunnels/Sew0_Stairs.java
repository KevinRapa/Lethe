package Tunnels;

import A_Main.Id;
import A_Super.Direction;
import A_Super.Staircase;
/**
 * @author Kevin Rapa
 */
public class Sew0_Stairs extends Staircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Sew0_Stairs () {
        super(Direction.UP, Id.DST1, 15);
        this.description = "It's a mossy, spiraling brick staircase with no railings. "
                         + "The stairs sit right at the tunnel's end and lead "
                         + "upwards.";
    }
//-----------------------------------------------------------------------------
}


