package A_Super;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Main;
import A_Main.Player;

/**
 * @author Kevin Rapa
 */
public class Endg extends Room {
    private final String earlyWinDesc;
// ============================================================================    
    public Endg(String name, String ID) {
        super(name, ID);
        
        this.description = 
            "You step out of the castle's front wall and into the forest. A\n" +
            "ray of sunlight finds the back of your neck, and you feel warmth.\n" +
            "At the same time, scattered light penetrates the forest canopy\n" +
            "and illuminates your path. You continue treading away from\n" +
            "the castle, but not too quickly, for you almost feel as though\n" +
            "you are being accompanied, but you are not afraid.";
        
        this.earlyWinDesc = 
            "By an magnificant unforeseen display of self\n" +
            "control, you turn your back to the ghastly\n" +
            "castle and backtrack along the path you came.\n" +
            "Your family is surely in worry and anxiously\n" +
            "awaits your return. Congratulations! You win\n" +
            "the game!";
    }
// ============================================================================
    @Override public String getDescription() {
        if (Player.getRoomObj(Id.COU4).isLocked())
            return this.earlyWinDesc;
        else
            return this.description;
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        return null;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        GUI.clearDialog();
        GUI.menOut("\n\nPress enter...");
        GUI.invOut("");
        GUI.promptOut();

        Main.exitGame();
        return null;
    }
// ============================================================================
}