package Dungeon_Stairs;

import A_Super.Room;
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
}
