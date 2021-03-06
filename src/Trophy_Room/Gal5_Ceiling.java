package Trophy_Room;

import A_Super.Furniture;

public class Gal5_Ceiling extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal5_Ceiling() {
        super();

        this.description = "The ceiling in this room is low and arched, and dips "
                         + "down in the middle to hold the chandelier.";
        this.actDialog = "You extend your arm and poke the ceiling.";
        this.addActKeys("touch", "poke");
        this.addNameKeys("ceiling");
    }
//-----------------------------------------------------------------------------  
}
