package A_Super;

import A_Main.GUI;
import java.io.File;

/**
 * @author Kevin Rapa
 */
public class Endg extends Room {
// ============================================================================    
    public Endg(String name, String ID) {
        super(name, ID);
        this.description= "You step out of the castle's front wall and into the forest. A\n" +
                          "ray of sunlight finds the back of your neck, and you feel warmth.\n" +
                          "At the same time, scattered light penetrates the forest canopy\n" +
                          "and illuminates your path. You continue treading away from\n" +
                          "the castle, but not too quickly, for you almost feel as though\n" +
                          "you are being accompanied, but you are not afraid.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return null;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        GUI.clearDialog();
        GUI.invOut("");
        
        if ((new File(System.getProperty("user.dir"), "Game.data")).delete())
            System.out.println("Files deleted.");
        else
            System.out.println("Files to delete not found.");
        
        while(true)
            GUI.promptOut(); // Final point in the game. Player must exit manually.
                             // Deletes game data.
    }
// ============================================================================
}