package Chapel_Stairs;

import Super.Furniture;

public class Chs1_Stat extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Chs1_Stat(String NAME) {
        super();
        this.searchable = false;
        this.description = "The female statue wears a face of sorrow and stares\n"
                         + "directly at you. As you sway from side to side, it's\n"
                         + "almost as if her eyes follow you.";
        this.interactDialog = "That's not a very Christian thing to do...";
        this.addNameKeys("statue", "female statue");
        this.addActKeys("touch", "grab", "feel");
    }
/*----------------------------------------------------------------------------*/
}

