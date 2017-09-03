package Library;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Button;
import A_Super.Fireplace;
import A_Super.Furniture;

public class Lib4_Button extends Button {
    private final int FRPLC_ID, STAT_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib4_Button(Furniture frplc, Furniture stat) {
        super();
        this.description = "You look closely at the small stone button scorched " +
                           "from the heat of the fire. It's definitely a button.";
        this.FRPLC_ID = frplc.getID();
        this.STAT_ID = stat.getID();
    }
//-----------------------------------------------------------------------------   
    @Override public String interact(String key) {
        return this.event(key);
    }
//-----------------------------------------------------------------------------    
    @Override public String event(String key) {
        Fireplace f = (Fireplace)Player.getRoomObj(Id.LIB2).getFurnRef(FRPLC_ID);
        
        if (f.isLit()) {
            AudioPlayer.playEffect(39, 0.3);
            return "Ouch! There is fire in the way!"; 
        }
        else {
            Lib3_Statue s = (Lib3_Statue)Player.getRoomObj(Id.LIB3).getFurnRef(STAT_ID);
            AudioPlayer.playEffect(11);
            return s.lightRight();
        }
    }
//-----------------------------------------------------------------------------
}
