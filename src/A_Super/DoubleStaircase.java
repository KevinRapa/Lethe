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
        String ans;
        
        GUI.menOut("\nThere are two flights here.\n       <'u'> Go up\n       <'d'> Go down");
        
        do {
            ans = GUI.promptOut();
        } while (! ans.matches("[ud]|up|down"));
        
        Direction dir = ans.matches("up|u") ? Direction.UP : Direction.DOWN; // Z coordinate modifier.
                
        Player.move(dir);
        playEffect();  
        
        return "You climb " + dir + " the stairs.";    
    }
    // ========================================================================      
}


