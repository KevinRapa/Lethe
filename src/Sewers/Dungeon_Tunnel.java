package Sewers;

import A_Main.Player;
import A_Super.Room;
/**
 * Hallway in which the monster walks. 
 * Whenever the player enters this room, the monster checks if it is in the
 * same room as the player. If so, the player is captured.
 * 
 * @author Kevin Rapa
 */
abstract public class Dungeon_Tunnel extends Room {
// ============================================================================    
    public Dungeon_Tunnel(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String triggeredEvent() {
        // More stuff will go here.
        return "You are " + Player.getPos() + ".";
    }
// ============================================================================
}