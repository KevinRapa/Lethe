package Iron_Hall;

import A_Main.Id;
import A_Main.Player;
import A_Super.Lever;
import Rotunda.Rotu;
/**
 * @author Kevin Rapa
 */
public class Iha1_Lever extends Lever {
    //-------------------------------------------------------------------------
    public Iha1_Lever () {
        super();
        
        this.description = "Next to the door is a big iron lever.";
        this.searchDialog = "This is just a plain iron lever...";
        
        this.addNameKeys("(?:big )?(?:iron )?lever");
    }
    //------------------------------------------------------------------------- 
    @Override protected String event(String key) {
        ((Rotu)Player.getRoomObj(Id.ROTU)).rotate();
        return "you hear a loud rumble.";
    }
    //------------------------------------------------------------------------- 
}


