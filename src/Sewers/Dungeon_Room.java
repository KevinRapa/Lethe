package Sewers;

import A_Main.Player;
import A_Super.Room;

/**
 * @author Kevin Rapa
 */

abstract public class Dungeon_Room extends Room {
// ============================================================================    
    public Dungeon_Room(String name, String ID) {
        super(name, ID);
    }
// ============================================================================
    @Override public String triggeredEvent() {
        return "You are " + Player.getPos() + ".";
    }
// ============================================================================
}