package Foyer;

import A_Super.Chandelier;

public class Foy_Chandelier extends Chandelier {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy_Chandelier() {
        super();

        this.description = "It's a huge iron chandelier. Its forged iron frame "
                         + "curves intricately. It holds numerous candles; at "
                         + "least thirty. You are stunned by its majesty. At the "
                         + "same time, you ponder who has the time to maintain "
                         + "so many candles.";
        
        this.addNameKeys("(?:huge )?(?:iron )?(?:chandelier|light)");
    }
//-----------------------------------------------------------------------------
}
