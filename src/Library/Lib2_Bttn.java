package Library;

import Super.Button;
import Super.Room;
import Super.Furniture;

public class Lib2_Bttn extends Button {
    private final Lib2_Frplc REF;
    private final Lib3_Stat REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_Bttn(String NAME, Furniture frplc, Furniture stat) {
        super(NAME);
        this.description = "You look closely at the small stone button scorched\n" +
                           "from the heat of the fire. It's definitely a button.";
        this.REF = (Lib2_Frplc) frplc;
        this.REF2 = (Lib3_Stat) stat;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        if (REF.isLit()) {
            interactDialog = "Ouch! There is fire in the way!";}                    
        else
            interactDialog = REF2.lightLeft();
                     
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
}
