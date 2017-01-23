package Dining_Room;

import A_Super.Furniture;

public class Din1_Moonlight extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Din1_Moonlight() {
        super();

        this.description = "The skies are clear and the full moon is bright\n"
                         + "tonight.";
        this.searchDialog = "Don't be ridiculous.";
        this.addNameKeys("moonlight");
    }
/*----------------------------------------------------------------------------*/
}
