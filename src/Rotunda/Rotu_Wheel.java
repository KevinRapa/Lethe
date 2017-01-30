package Rotunda;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * Rotates the rotunda when turned.
 * Found in the fountain
 * 
 * @see Rotunda.Rotu_Fountain
 * @author Kevin Rapa
 */
public class Rotu_Wheel extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Wheel() {
        super();

        this.searchDialog = "Nope, nothing. But there are interesting seams\n"
                          + "above and below the wheel.";
        this.description = "Looking closely at the wheel, you spot a seam\n"
                         + "separating it from the main structure of the\n"
                         + "fountain.";
        this.actDialog = "As you turn the wheel, your balance shifts and you hear a loud\n"
                       + "rumble. The room appears to have shifted.";
        this.addNameKeys("(?:stone )?wheel");
        this.addActKeys("turn", "rotate", "spin", "twist");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        ((Rotu)Player.getRoomObj(Id.ROTU)).rotate();
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
