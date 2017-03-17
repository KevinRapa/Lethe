package Scorched_Room;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
        
public class Sear_Ash extends Furniture implements Gettable {
    private final Item ASH_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Sear_Ash(Item ash) {
        super();

        this.ASH_REF = ash;
        
        this.description = "The ash is scattered all over the floor.";
        this.searchDialog = "Nothing here but more ash.";
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("ash(?:es)?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (Player.getInv().add(ASH_REF))
            return "You take some ash.";
        else
            return null;
    }
/*----------------------------------------------------------------------------*/
}