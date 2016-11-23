package Library;

import Super.Furniture;

public class Lib_Scncs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Scncs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "Copper metal sconces holding glass bulbs. They dimly\n" +
                           "light the wall with a flickering orange glow.";
        this.interactDialog = "Ouch! That's hot!";
        this.addNameKeys("sconces", "sconce", "electric sconce", "electric sconces");
        this.addActKeys("grab", "hold", "touch");
    }
/*----------------------------------------------------------------------------*/
}

