package Tunnels;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Room;
/**
 * Hallway in which the monster walks. 
 * Whenever the player enters this room, the monster checks if it is in the
 * same room as the player. If so, the player is captured.
 * 
 * @author Kevin Rapa
 */
public class Dungeon_Tunnel extends Room {
    protected final static String 
            WATER_THAT_WAY = "Do you feel like going for a swim?";
    private final static Furniture MONSTER = new DungeonMonsterFurniture();
//-----------------------------------------------------------------------------    
    public Dungeon_Tunnel(String name, String ID) {
        super(name, ID);
        this.addFurniture(MONSTER);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (DungeonMonster.isInactive())
            DungeonMonster.startMovement();
            
        DungeonMonster.checkForPlayer();
        return Player.getPos().toString();
    }
//-----------------------------------------------------------------------------
}