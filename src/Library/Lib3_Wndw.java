package Library;

import Super.Window;

public class Lib3_Wndw extends Window {
/* CONSTRUCTOR ---------------------------------------------------------------*/         
    public Lib3_Wndw(String NAME) {
        super(NAME);
        this.isOpen = false;
        this.descClosed = "Through the small stone window, you can see your\n"
                        + "village in the great distance. A light fog rolls\n"
                        + "through the air.";
        this.descOpen = "Through the small stone window, you can see your\n"
                      + "village in the great distance. A light fog rolls\n"
                      + "through the air. In flows a small breeze.";
    }
/*----------------------------------------------------------------------------*/    
}
