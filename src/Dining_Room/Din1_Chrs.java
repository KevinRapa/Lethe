package Dining_Room;

import Super.Furniture;

public class Din1_Chrs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Din1_Chrs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The chairs are boxy with lavender upholstery. The\n"
                         + "hickory wood is meticulously carved. 'They can\n"
                         + "carve a chair worth twice my life, but not one I\n"
                         + "could sit in for more than five minutes!'";
        this.searchDialog = "You look underneath, but find nothing.";
        this.interactDialog = "You pick out a chair to sit in and stare out the window\n"
                            + "on the east end. For a moment, you feel free of worry.";
        this.addActKeys("sit", "use", "relax");
        this.addNameKeys("chairs", "chair");
    }
/*----------------------------------------------------------------------------*/
}
