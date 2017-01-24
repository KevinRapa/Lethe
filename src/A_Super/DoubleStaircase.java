package A_Super;

import A_Main.GUI;
import A_Main.Player;
/**
 * Some rooms have two sets of stairs.
 * Allow the player to interact with either one and avoid problems of ambiguity.
 * 
 * @author Kevin Rapa
 */
public class DoubleStaircase extends Staircase {
    // ========================================================================
    public DoubleStaircase () {
        super(Direction.DOWN); //Direction is UNUSED in Double stairs
    }
    // ========================================================================   
    @Override public String interact(String key) {     
        String ans = GUI.askChoice("\nThere are two flights here.\n<'u'> Go up\n<'d'> Go down", "[ud]|up|down|");

        if (Player.isNonEmptyString(ans)) {
            Direction dir = ans.matches("up|u") ? Direction.UP : Direction.DOWN; // Z coordinate modifier.

            Player.move(dir);
            playEffect();  
        
            return "You climb " + dir + " the stairs.";   
        }
        else
            return null;
    }
    // ========================================================================      
    public String interact(Direction dir) {     
        playEffect();
        Player.move(DIR);
        return "You climb " + DIR + " the stairs.";
    }
    // ========================================================================      
}


