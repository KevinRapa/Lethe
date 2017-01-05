package Front_Balcony;

import A_Super.Statue;

public class Entr_Stats extends Statue {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Entr_Stats() {
        super();
        this.description = "The six statues are all of ominous cloaked figures.\n"
                         + "These are in much better condition than the ones in\n"
                         + "the courtyard.";
        this.searchDialog = "You don't feel comfortable approaching any of these.";
        this.actDialog = this.searchDialog;
        this.addNameKeys("statues");
    }
/*----------------------------------------------------------------------------*/ 
}
