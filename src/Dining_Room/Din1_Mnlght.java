package Dining_Room;

import Super.Furniture;

public class Din1_Mnlght extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Mnlght() {
        super();
        this.searchable = false;
        this.description = "The skies are clear and the full moon is bright\n"
                         + "tonight.";
        this.searchDialog = "Don't be ridiculous.";
        this.addNameKeys("moonlight");
    }
/*----------------------------------------------------------------------------*/
}
