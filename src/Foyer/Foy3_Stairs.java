package Foyer;

import A_Main.Id;
import A_Super.DoubleStaircase;

public class Foy3_Stairs extends DoubleStaircase {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Foy3_Stairs() {
        super(Id.FOY2, Id.FOY4, 15);
        this.description = "From the second floor switchback, the stairs lead "
                         + "to a top floor landing.";
        this.searchDialog = "In searching the stairs, you find it as clean and "
                          + "bare as the rest of this room.";  
    }
//-----------------------------------------------------------------------------  
}