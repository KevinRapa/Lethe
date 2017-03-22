package A_Super;

import static A_Main.Names.HAND_TORCH;
import static A_Main.Names.WEAPON;

/**
 * @author Kevin Rapa
 */
public class BurningBowl extends Furniture implements Gettable {
    // ========================================================================
    public BurningBowl () {
        super();

        this.searchDialog = "Whatever important item might have been there has\n"
                          + "likely burned away at this point.";
        this.useDialog = this.actDialog = "Jabbing a burning bowl isn't a very good idea.";

        this.addNameKeys("(?:hanging )?(?:steel )?bowl(?: of fire)?", 
                "(?:hanging )?(?:steel )?burning bowl", "fire", "light");
        
        this.addUseKeys(".+");
        this.addActKeys(GETPATTERN);
        this.addActKeys(JOSTLEPATTERN, "jab", "poke");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON))
            return this.useDialog;
        else if (item.toString().equals(HAND_TORCH))
            return "The torch is already lit, despite having been in your pocket for so long.";
        else
            return "What good would that serve?";
    }
    // ========================================================================    
    @Override public String interact(String key) {
        if (key.equals("jab") || key.equals("poke") || key.matches(JOSTLEPATTERN))
            return this.actDialog;
        else 
            return getIt();
    }
    // ========================================================================    
}


