package Chapel;

import A_Super.Candelabra;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cha1_Candelabra extends Candelabra {
    //-------------------------------------------------------------------------
    public Cha1_Candelabra (Item candle) {
        super(candle);
        
        this.description = "The silver standing candelabras burn calmly and quietly.";

        this.addNameKeys("(?:silver )?(?:standing )?(?:lit )?candelabras?");
    }
    //------------------------------------------------------------------------- 
}


