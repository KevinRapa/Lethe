package Rotunda;

import Main.Player;
import Super.Furniture;

public class Rotu_Whl extends Furniture{
    /* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Whl() {
        super();
        this.searchable = false;
        this.searchDialog = "Nope, nothing. But there are interesting seams\n"
                          + "above and below the wheel.";
        this.description = "Looking closely at the wheel, you spot a seam\n"
                         + "separating it from the main structure of the\n"
                         + "fountain.";
        this.addNameKeys("wheel", "stone wheel");
        this.addActKeys("turn", "rotate", "spin", "twist");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        ((Rotu)Player.getMapRef()[3][3][3]).rotate();
        interactDialog = "As you turn the wheel, your balance shifts and you hear a loud\n"
               + "rumble. The room appears to have shifted.";
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
    
}
