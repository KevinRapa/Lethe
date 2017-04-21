package Marble_Hall;

import A_Super.Window;

public class Mha3_Window extends Window {
/* CONSTRUCTOR ---------------------------------------------------------------*/         
    public Mha3_Window() {
        super();
        this.isOpen = true;
        this.escapeDialog = "That won't do any good. It leads right back out into the courtyard.";
        this.descClosed = "The window is tall and arched at the top. Through its "
                        + "many glass panes, you can see the south end of the "
                        + "courtyard. The ruined fountain with the soldier statue "
                        + "sits in the center.";
        this.descOpen = "The window is open and its two shutters open outwards. "
                      + "You can see the south end of the courtyard. The ruined "
                      + "fountain with the soldier statue sits in the center.";
    }
//-----------------------------------------------------------------------------    
}

