package Dining_Room;

import A_Super.Furniture;

public class Din1_Chairs extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Chairs() {
        super();

        this.description = "The chairs are boxy with lavender upholstery. The\n"
                         + "hickory wood is meticulously carved. 'They can\n"
                         + "carve a chair worth twice my life, but not one I\n"
                         + "could sit in for more than five minutes!'";
        this.searchDialog = "You look underneath, but find nothing.";
        this.actDialog = "You pick out a chair to sit in and stare out the window\n"
                       + "on the east end. For a moment, you feel free of worry.";
        
        this.addActKeys(SITPATTERN);
        this.addNameKeys("chairs?");
    }
/*----------------------------------------------------------------------------*/
}
