package Kitchen;

import Super.Static_Wndw;

public class Kitc_Wndw extends Static_Wndw{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Kitc_Wndw(String NAME) {
        super(NAME);
        this.interactDialog = "This window is just a slit in the wall. It has no moving\n"
                    + "parts.";
        this.description = "Looking through the foot-wide slit in the wall, you\n" +
                           "can see only the distant landscape of shoreline, trees,\n" +
                           "and mountains on the horizon.";
    }
/*----------------------------------------------------------------------------*/
}