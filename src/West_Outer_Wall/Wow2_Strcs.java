package West_Outer_Wall;

import Super.Furniture;

public class Wow2_Strcs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Strcs() {
        super();
        this.searchable = false;
        this.description = "The remnants of the stairs lie crumbled all over the\n"
                         + "floor.";
        this.searchDialog = "There's nothing among all these rocks but more rocks.";
        this.interactDialog = "Don't be ridiculous. The stairs are crumbled down.";
        this.addNameKeys("staircase", "stairs", "steps");
        this.addActKeys("climb", "walk", "use");
    }
/*----------------------------------------------------------------------------*/        
}

