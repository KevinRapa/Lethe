package Foyer;

import Super.Furniture;

public class Foy1_Strs extends Furniture{
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
        public Foy1_Strs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "A stone winding staircase hugs the curved wall\n"
                         + "on the far north side of the room.";
        this.searchDialog = "It's too far away to see anything.";
        this.interactDialog = "'There's no way I can walk up those from here,' you\n"
                    + "think to yourself. 'I will have to walk closer.'";
        this.addActKeys("use", "climb", "walk");
        this.addNameKeys("stairs", "staircase", "steps");
    }
/*----------------------------------------------------------------------------*/
}
