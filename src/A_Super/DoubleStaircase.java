package A_Super;

import A_Main.GUI;
import A_Main.Menus;
import A_Main.Player;
import static A_Main.Patterns.UP_DOWN_P;
import static A_Super.Direction.DOWN;
import static A_Super.Direction.UP;
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
        if (key.equals(UP.toString()) || key.equals(DOWN.toString())) {
            boolean isUp = key.equals(UP.toString());
            playEffect();
            Player.move(isUp ? UP : DOWN);
            return "You climb " + (isUp ? UP : DOWN)  + " the stairs.";
        }
        
        String ans = GUI.askChoice(Menus.DOUBLE_ST, UP_DOWN_P);

        if (Player.isNonEmptyString(ans)) {
            Direction dir = (ans.equals("up") || ans.equals("u")) ? 
                    Direction.UP : Direction.DOWN; // Z coordinate modifier.

            Player.move(dir);
            playEffect();  
        
            return "You climb " + dir + " the stairs.";   
        }
        else
            return NOTHING;
    }
    // ========================================================================         
}


