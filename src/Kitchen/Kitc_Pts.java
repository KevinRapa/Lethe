package Kitchen;

import Super.Furniture;

public class Kitc_Pts extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Kitc_Pts() {
        super();
        this.searchable = false;
        this.description = "A bunch of old copper pots and pans hang from the\n"
                         + "ceiling";
        this.searchDialog = "You are too short to reach!";
        this.addNameKeys("pot", "pots");
    }
/*----------------------------------------------------------------------------*/
}
