package Front_Balcony;

import Super.Furniture;

public class Entr_Stats extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Entr_Stats(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The six statues are all of ominous cloaked figures.\n"
                         + "These are in much better condition than the ones in\n"
                         + "the courtyard.";
        this.searchDialog = "You don't feel comfortable approaching any of these.";
        this.interactDialog = this.searchDialog;
        this.addActKeys("grab", "touch", "hold");
        this.addNameKeys("statues", "statue");
    }
/*----------------------------------------------------------------------------*/ 
}
