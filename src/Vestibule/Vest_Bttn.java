package Vestibule;

import Main.Player;
import Super.Button;
import Super.Room;
import Super.Furniture;

public class Vest_Bttn extends Button {
    private final Vest_Frplc REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Bttn(Furniture vesfrplc) {
        super();
        this.description = "You look closely at the small rock protrusion scorched\n" +
                           "from the heat of the fire. It's definitely a button.";
        this.REF = (Vest_Frplc)vesfrplc;
        this.addNameKeys("protrusion", "rock protrusion");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String event(String key) {
        Room foy1 = Player.getMapRef()[3][3][5];
        
        if (REF.isLit())
            interactDialog = "Ouch! There is fire in the way!";                    
        else {
            foy1.unlock();
            interactDialog = "You push the button and hear a click behind you.";
        }             
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
}
