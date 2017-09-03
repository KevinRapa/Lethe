package Gallery;

import A_Main.Id;
import A_Main.Player;
import A_Super.Button;
import A_Super.Furniture;
/**
 * One of two object which turn on the GAL1 Dragon
 * 
 * @see Gallery.Gal1_Dragon
 * @see Gallery.Gal1_Switch
 * @author Kevin Rapa
 */
public class Gal1_Button extends Button {
    private final int DRAGON_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Button(Furniture stat) {
        super();
        this.actDialog = "You press the button. ";
        this.DRAGON_ID = stat.getID(); 
    }
//-----------------------------------------------------------------------------    
    @Override public String event(String key) {
        Gal1_Dragon d = (Gal1_Dragon)Player.getRoomObj(Id.GAL1).getFurnRef(DRAGON_ID);
        return this.actDialog.concat(d.switchEye(0));
    }   
//-----------------------------------------------------------------------------
}
