package Library;

import A_Super.Furniture;

public class Lib_Scncs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Scncs() {
        super();
        this.searchable = false;
        this.description = "Copper metal sconces holding glass bulbs. They dimly\n" +
                           "light the wall with a flickering orange glow.";
        this.actDialog = "Ouch! That's hot!";
        this.addNameKeys("sconces", "sconce", "electric sconce", "electric sconces");
        this.addActKeys("grab", "hold", "touch");
    }
/*----------------------------------------------------------------------------*/
}

