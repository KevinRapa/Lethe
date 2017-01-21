package Dungeon_Stairs;

import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
import Tunnels.DungeonMonster;
/**
 * The only walkable way to dungeon.
 * The player cannot use these stairs unless the SEW0 has been entered.
 * ATT1 responsible for sending player to the lower level the first time.
 * 
 * @see Attic.Att1
 * @author Kevin Rapa
 */
public class Dst1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Dst1(String name, String ID) {
        super(name, ID);
        description= "You step into a tiny dark chamber of cobblestone. Only a\n" +
                     "single hanging lantern lights the ceiling. In the center\n" +
                     "of the room, a set of spiral stairs winds downwards into\n" +
                     "darkness. The air in here is heavy and turgid, and you\n" +
                     "hear only a deep whirring. A sharp incurring sense of\n" +
                     "dread overcomes you.";
    }
/*----------------------------------------------------------------------------*/
    /**
     * Turns the monster around when player climbs the stairs in SEW0.
     * Allows player to escape the creature if cornered in SEW0.
     * @see Tunnels.DungeonMonster
     */
    @Override public String triggeredEvent() {      
        if (! DungeonMonster.isInactive() && 
                Player.getLastVisited().equals(Id.SEW0))
            DungeonMonster.turnMonsterAround();
        
        return STD_RM_OUT;
    }
/*----------------------------------------------------------------------------*/    
}
