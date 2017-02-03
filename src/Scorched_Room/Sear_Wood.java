package Scorched_Room;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
        
public class Sear_Wood extends Furniture implements Gettable {
    private final Item WOOD_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Wood(Item wood) {
        super();

        this.WOOD_REF = wood;
        
        this.description = "Bits of burnt wood are littered everywhere.";
        this.searchDialog = "It's all just burnt wood.";
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:bits of )?(?:burnt )?wood");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (Player.getInv().add(WOOD_REF))
            return "You take a chunk of wood.";
        else
            return "You already have some dirty charred wood.";
    }
/*----------------------------------------------------------------------------*/
}
