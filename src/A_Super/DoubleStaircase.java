package A_Super;

import A_Main.GUI;
import A_Main.Menus;
import A_Main.Player;
/**
 * Some rooms have two sets of stairs or a switchback staircase.
 * Allow the player to interact with either one and avoid problems of ambiguity.
 * 
 * @author Kevin Rapa
 */
abstract public class DoubleStaircase extends Staircase {
    // ========================================================================
    public DoubleStaircase () {
        super(Direction.DOWN); //Direction is UNUSED in Double stairs
    }
    // ========================================================================   
    @Override public String interact(String key) {     
        String ans = GUI.askChoice(Menus.DOUBLE_ST, "[ud]|up|down|");

        if (Player.isNonEmptyString(ans)) {
            Direction dir = ans.matches("up|u") ? 
                    Direction.UP : Direction.DOWN; // Z coordinate modifier.

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
        Player.move(dir);
        return "You climb " + dir + " the stairs.";
    }
    // ========================================================================      
}


