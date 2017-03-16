package Hades;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

/**
 * @author Kevin Rapa
 */
public class Hades extends Room {
// ============================================================================    
    public Hades(String name, String ID) {
        super(name, ID);
        this.description= "You are outside a large gateway, on which is inscribed " +
                          "\"Abandon every hope, all ye who enter here.\" " +
                          "The gate is open; through it you can see a desolation, "
                        + "with a pile of mangled corpses in one corner. Thousands "
                        + "of voices, lamenting some hideous fate, can be heard. " +
                          "The way through the gate is barred by evil spirits, "
                        + "who jeer at your attempts to pass.";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "Some invisible force prevents you from passing through the gate.";
        else
            return bumpIntoWall();
    }
// ============================================================================
    @Override public String triggeredEvent() {
        String result = this.calculateScore(Player.getScore());
        GUI.out("");
        
        return STD_RM_OUT;
    }
// ============================================================================
    private String calculateScore(int score) {
        String result = null;
        
        return result;
    }
// ============================================================================
}