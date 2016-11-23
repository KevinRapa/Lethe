package West_Antechamber;

import Super.Furniture;

public class Want_Rmp extends Furniture{
    
    public Want_Rmp(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "At the far end of the antechamber, a ramp slopes\n"
                         + "downward about six feet before terminating at a door.";
        this.searchDialog = "There's nothing there except dust.";
        this.addNameKeys("ramp");
    }
}
