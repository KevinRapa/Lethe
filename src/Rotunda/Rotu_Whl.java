package Rotunda;

import Super.Furniture;
import Super.Room;

public class Rotu_Whl extends Furniture{
    private final Rotu REF;
    /* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Whl(String NAME, Room rotu) {
        super(NAME);
        this.searchable = false;
        this.searchDialog = "Nope, nothing. But there are interesting seams\n"
                          + "above and below the wheel.";
        this.description = "Looking closely at the wheel, you spot a seam\n"
                         + "separating it from the main structure of the\n"
                         + "fountain.";
        this.REF = (Rotu)rotu;
        this.addNameKeys("wheel", "stone wheel");
        this.addActKeys("turn", "rotate", "spin", "twist");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        REF.rotate();
        interactDialog = "As you turn the wheel, your balance shifts and you hear a loud\n"
               + "rumble. The room appears to have shifted.";
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
    
}
