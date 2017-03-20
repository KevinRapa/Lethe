package Courtyard;

import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cou2_Bushes extends Courtyard_Growth implements Gettable {
    private final Item BERRY_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou2_Bushes(Item berry) {
        super();

        this.BERRY_REF = berry;
        
        this.description = "They're unkept thorny bushes growing red berries, and probably the only\n"
                         + "pretty things in this yard.";
        this.searchDialog = "You pick through the bushes and get stuck by a thorn.";
        this.actDialog = "That would probably hurt!";
        this.cutDialog = "Is the bush not tidy enough for you?";
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:unkept )?(?:thorny )?bush(?:es)?", "(?:bright )?(?:red )?berr(?:ies|y)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(GETPATTERN))
            return getIt();
        else
            return super.interact(key);
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (Player.getInv().add(BERRY_REF))
            return "You pick a bright red berry off the bush.";
        else 
            return NOTHING;
    }
/*----------------------------------------------------------------------------*/
}
