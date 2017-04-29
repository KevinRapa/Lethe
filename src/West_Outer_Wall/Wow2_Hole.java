package West_Outer_Wall;

import A_Super.Furniture;

public class Wow2_Hole extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Hole() {
        super();

        this.description = "You peek through the hole. The room next door is "
                         + "ash-filled and burnt to a crisp! In the far corner "
                         + "of the room, you see a ladder leading up.";
        this.searchDialog = "The hole is but empty space. You have nothing to "
                          + "search.";
        this.addNameKeys("hole");
    }    
///-----------------------------------------------------------------------------
}
