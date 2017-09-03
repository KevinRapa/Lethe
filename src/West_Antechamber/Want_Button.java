package West_Antechamber;

import A_Main.Id;
import A_Main.Player;
import A_Super.Button;
import A_Super.Furniture;
import Foyer.Foy2_Button;
/**
 * @author Kevin Rapa
 */
public class Want_Button extends Button {
    private final int FOY2_LVR_ID;
    //-------------------------------------------------------------------------
    public Want_Button (Furniture foy2Lever) {
        super();
        
        this.FOY2_LVR_ID = foy2Lever.getID();
        
        this.description = "There's a small black button on the wall next to "
                         + "the gate.";
        this.addNameKeys("(?:small )?(?:black )?button");
    }
    //-------------------------------------------------------------------------     
    @Override protected String event(String key) {
        return ((Foy2_Button)Player.getRoomObj(Id.FOY2)
                .getFurnRef(FOY2_LVR_ID)).event("");
    }
    //-------------------------------------------------------------------------  
}


