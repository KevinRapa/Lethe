package Dining_Room;

import A_Super.Column;

public class Din1_Columns extends Column {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Columns() {
        super();

        this.description = "The row of six Doric columns bows out following the "
                         + "curve of the balcony's edge. They are all clean white "
                         + "marble.";
        
        this.addNameKeys("(?:doric )?columns?");
    }
//-----------------------------------------------------------------------------
}