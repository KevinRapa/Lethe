package Dining_Room;

import A_Super.Furniture;

public class Din1_Clmns extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Clmns() {
        super();
        this.searchable = false;
        this.description = "The row of six doric columns bows out following the\n"
                         + "curve of the balcony's edge. They are all clean white\n"
                         + "marble.";
        this.actDialog = "These columns don't need extra help holding up the balcony.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("columns", "column");
    }
/*----------------------------------------------------------------------------*/
}