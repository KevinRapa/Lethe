package Library;

import A_Super.Button;
import A_Super.Furniture;

public class Lib2_Bttn extends Button {
    private final Lib2_Frplc FRPLC_REF;
    private final Lib3_Stat STAT_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_Bttn(Furniture frplc, Furniture stat) {
        super();
        this.description = "You look closely at the small stone button scorched\n" +
                           "from the heat of the fire. It's definitely a button.";
        this.FRPLC_REF = (Lib2_Frplc) frplc;
        this.STAT_REF = (Lib3_Stat) stat;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        if (FRPLC_REF.isLit())
            actDialog = "Ouch! There is fire in the way!";               
        else
            actDialog = STAT_REF.lightLeft();
                     
        return actDialog;
    }
/*----------------------------------------------------------------------------*/
}
