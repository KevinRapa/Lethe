package Iron_Hall;

import Super.Furniture;

public class Iha1_Hnd extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Hnd(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The gauntlet is gripping a polearm tightly.";
        this.searchDialog = this.description;
        this.interactDialog = "You try to pry the gauntlet open, but its grip\n"
                            + "is simply too tight.";
        this.addActKeys("pry", "open");
        this.addNameKeys("gauntlet", "hand");
    }
/*----------------------------------------------------------------------------*/
}