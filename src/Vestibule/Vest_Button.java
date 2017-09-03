package Vestibule;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Button;
import A_Super.Furniture;

public class Vest_Button extends Button {
    private final int FRPLC_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Button(Furniture vesfrplc) {
        super();
        this.description = "You look closely at the small rock protrusion scorched " +
                           "from the heat of the fire. It's definitely a button.";
        this.FRPLC_ID = vesfrplc.getID();
        this.addNameKeys("(?:small )?(?:rock )?(?:protrusion|button)");
    }
//-----------------------------------------------------------------------------   
    @Override public String interact(String key) {
        return this.event(key);
    }
//-----------------------------------------------------------------------------    
    @Override public String event(String key) {
        Vest_Fireplace frplc = (Vest_Fireplace)Player.getPos().getFurnRef(FRPLC_ID);
        
        if (frplc.isLit()) {
            AudioPlayer.playEffect(39, 0.3);
            return "Ouch! There is fire in the way!";   
        }
        else {
            AudioPlayer.playEffect(11);
            AudioPlayer.playEffect(5);
            Player.getRoomObj(Id.FOY1).setLocked(false);
            return "You push the button and hear a click behind you.";
        }             
    }
//-----------------------------------------------------------------------------
}
