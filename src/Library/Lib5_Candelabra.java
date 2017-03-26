package Library;

import A_Super.Candelabra;
import A_Super.Item;

public class Lib5_Candelabra extends Candelabra {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib5_Candelabra(Item candle) {
        super(candle);

        this.description = "The intricate iron candelabra sits in the corner "
                         + "holding 5 candles.";
        this.addNameKeys("(?:intricate )?(?:iron )?(?:standing )?candelabra");
    }
/*----------------------------------------------------------------------------*/
}

