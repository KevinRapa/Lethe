package Vestibule;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Button;
import A_Super.Furniture;

public class Vest_Bttn extends Button {
    private final Vest_Frplc FRPLC_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Bttn(Furniture vesfrplc) {
        super();
        this.description = "You look closely at the small rock protrusion scorched\n" +
                           "from the heat of the fire. It's definitely a button.";
        this.FRPLC_REF = (Vest_Frplc)vesfrplc;
        this.addNameKeys("(?:small )?(?:rock )?protrusion");
    }
/*----------------------------------------------------------------------------*/   
    @Override public String interact(String key) {
        return this.event(key);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        if (FRPLC_REF.isLit())
            return "Ouch! There is fire in the way!";                    
        else {
            AudioPlayer.playEffect(11);
            AudioPlayer.playEffect(5);
            Player.getRoomObj(Id.FOY1).unlock();
            return "You push the button and hear a click behind you.";
        }             
    }
/*----------------------------------------------------------------------------*/
}
