package A_Super;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Menus;
import A_Main.Player;
import static A_Main.Patterns.UP_DOWN_P;
/**
 * Some rooms have two sets of stairs or a switchback staircase.
 * Allow the player to interact with either one and avoid problems of ambiguity.
 * 
 * @author Kevin Rapa
 */
abstract public class DoubleStaircase extends Staircase {
    protected final String DEST_2; // Up destination
    //-------------------------------------------------------------------------
    public DoubleStaircase (String dest, String dest2, int sound) {
        super(Direction.DOWN, dest, sound);
        this.DEST_2 = dest2;
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {
        if (key.equals("up") || key.equals("down")) {
            AudioPlayer.playEffect(SOUND); 
            Player.setOccupies(key.equals("up") ? DEST_2 : DEST);
            return "You climb " + key + " the stairs.";   
        }
        else {
            String ans = GUI.askChoice(Menus.DOUBLE_ST, UP_DOWN_P);

            if (Player.isNonEmptyString(ans)) {
                Direction dir = (ans.equals("up") || ans.equals("u")) ? 
                        Direction.UP : Direction.DOWN; // Z coordinate modifier.

                AudioPlayer.playEffect(SOUND); 
                Player.setOccupies(dir == Direction.UP ? DEST_2 : DEST);

                return "You climb " + dir + " the stairs.";   
            }
            else
                return NOTHING;
        }
    }
    //-------------------------------------------------------------------------         
}


