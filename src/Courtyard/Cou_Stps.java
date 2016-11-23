package Courtyard;

import Super.Furniture;

public class Cou_Stps extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou_Stps(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The long set of crumbling steps climb to a front\n"
                         + "balcony before the castle's great front doors.";
        this.searchDialog = "You find nothing.";
        this.interactDialog = "You can't while at the side of the stairs";
        this.addActKeys("climb", "use");
        this.addNameKeys("steps", "stairs", "staircase");
    }
/*----------------------------------------------------------------------------*/
}
