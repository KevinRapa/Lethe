package Trophy_Room;

import A_Super.Chandelier;
        
public class Gal5_Chandelier extends Chandelier {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Chandelier() {
        super();

        this.description = "The chandelier holds only a few melted candles. It's "
                         + "covered in cobwebs. This light has not been lit "
                         + "for a while.";
        this.searchDialog = "The low-hanging chandelier is within reach, "
                + "but contains nothing interesting.";
        this.useDialog = "The candles are all too melted and old to light.";
    }
//-----------------------------------------------------------------------------
}
