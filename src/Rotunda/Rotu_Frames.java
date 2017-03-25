package Rotunda;

import A_Super.Furniture;
import A_Super.Unmoveable;

public class Rotu_Frames extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Frames() {
        super();

        this.description = "They are arched, door-shaped, and seem as if they\n"
                         + "form the entry of some kind of hidden magical passage.";
        this.searchDialog = "These frames seem as though they hide something, but\n"
                          + "after inspecting every inch, you can only confirm\n"
                          + "they are plain carvings.";
        this.actDialog = "You feel as though if you do that, you will get a face-full of rock.";
        
        this.addActKeys("go|walk|run");
        this.addNameKeys("(?:arched )?frames?", "carvings?");
    }
/*----------------------------------------------------------------------------*/
}