package West_Antechamber;

import Super.Furniture;

public class Want_Pllrs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Pllrs() {
        super();
        this.searchable = false;
        this.description = "They're grooved, sandstone pillars. They seem\n"
                         + "to exist mostly for decoration.";
        this.searchDialog = "Nothing on these pillars...";
        this.interactDialog = "These pillars don't need extra help holding up the ceiling.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("pillars", "pillar", "columns", "column");
    }
/*----------------------------------------------------------------------------*/
}
