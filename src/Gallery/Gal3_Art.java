package Gallery;

import Super.Furniture;

public class Gal3_Art extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Art() {
        super();
        this.searchable = false;
        this.description = "The small statuette stands on a pedestal in the room's\n"
                         + "center. It resembles a ravenous humanoid with lifeless\n"
                         + "eyes. Next to it, a small label reads: \"Yombe\".";
        this.addNameKeys("statuette", "zambian statuette");
/*----------------------------------------------------------------------------*/
    }
}
