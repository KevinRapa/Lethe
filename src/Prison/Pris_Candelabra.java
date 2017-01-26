package Prison;

import A_Super.Candelabra;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Pris_Candelabra extends Candelabra {
    // ========================================================================
    public Pris_Candelabra (Item candle) {
        super(candle);
        
        this.description = "Scattered around the prison are several standing\n"
                         + "candelabras. Each one is rusted, the candles are\n"
                         + "heavily melted, and dried wax is seen dirtying\n"
                         + "every light. Still, the candles continue to burn.";

        this.addNameKeys("(?:rusted )?(?:standing )?(?:candelabras?|lights?)", 
                "(?:melt(?:ed|ing))?candles");
    }
    // ======================================================================== 
}


