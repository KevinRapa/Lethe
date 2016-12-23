package Iron_Hall;

import A_Super.Furniture;

public class Iha1_Hnd extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Hnd() {
        super();
        this.searchable = false;
        this.description = "The gauntlet is gripping a polearm tightly.";
        this.searchDialog = this.description;
        this.actDialog = "You try to pry the gauntlet open, but its grip\n"
                            + "is simply too tight.";
        this.addActKeys("pry", "open");
        this.addNameKeys("gauntlet", "hand");
    }
/*----------------------------------------------------------------------------*/
}