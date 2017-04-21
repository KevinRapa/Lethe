package Observatory;

import A_Super.WallArt;
/**
 * @author Kevin Rapa
 */
public class Obs2_Painting extends WallArt {
    //-------------------------------------------------------------------------
    public Obs2_Painting () {
        super();
        this.description = "The small, thick-framed painting depicts a ship "
                         + "sailing during a storm on thrashing waves.";
        this.addNameKeys("(?:thick-framed )?painting");
    }
    //-------------------------------------------------------------------------  
}


