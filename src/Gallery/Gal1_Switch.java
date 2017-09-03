package Gallery;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Lever;
/**
 * One of two object which turn on Gal1 Dragon
 * 
 * @see Gallery.Gal1_Dragon
 * @see Gallery.Gal1_Button
 * @author Kevin Rapa
 */        
public class Gal1_Switch extends Lever {
    private final int DRAGON_ID;    
    /* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Switch(Furniture stat) {
        super();
        this.description = "It's a large black lever on the floor";
        this.actDialog = "You pull the lever. ";
        this.DRAGON_ID = stat.getID(); 
        this.addNameKeys("(?:large )?(?:black )?lever");
    }
//-----------------------------------------------------------------------------    
    @Override public String event(String key) {
        Gal1_Dragon d = (Gal1_Dragon)Player.getRoomObj(Id.GAL1).getFurnRef(DRAGON_ID);
        return this.actDialog.concat(d.switchEye(1));
    }   
//-----------------------------------------------------------------------------    
}
