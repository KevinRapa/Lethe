package West_Outer_Wall;

import Super.Furniture;

public class Wow2_Hole extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Hole() {
        super();
        this.searchable = false;
        this.description = "You peek through the hole. The room is next door is\n"
                         + "ash-filled and burned up completely! What happened\n"
                         + "here?";
        this.searchDialog = "The hole is but empty space. You have nothing to\n"
                          + "search.";
        this.addNameKeys("hole");
    }    
//*----------------------------------------------------------------------------*/
}
