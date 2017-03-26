package Library;

import A_Main.AudioPlayer;
import A_Super.Button;
import A_Super.Furniture;

public class Lib2_Button extends Button {
    private final Lib2_Fireplace FRPLC_REF;
    private final Lib3_Statue STAT_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_Button(Furniture frplc, Furniture stat) {
        super();
        this.description = "You look closely at the small stone button scorched " +
                           "from the heat of the fire. It's definitely a button.";
        this.FRPLC_REF = (Lib2_Fireplace) frplc;
        this.STAT_REF = (Lib3_Statue) stat;
    }
/*----------------------------------------------------------------------------*/   
    @Override public String interact(String key) {
        return this.event(key);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        if (FRPLC_REF.isLit()) {
            AudioPlayer.playEffect(39, 0.3);
            return "Ouch! There is fire in the way!";  
        }
        else {
            AudioPlayer.playEffect(11);
            return STAT_REF.lightLeft();
        }
    }
/*----------------------------------------------------------------------------*/
}
