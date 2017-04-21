package Back_Hall;

import A_Super.Note;
/**
 * Describes where the brass plates are.
 * 
 * Under the cushion in the Parlor.
 * On a shelf in the parlor.
 * Dig a hole with a shovel in Cou4 to find another.
 * Behind tapestry in dining room.
 * In trophy room cabinet.
 * Chest in observatory.
 * In back hall end table.
 * Under plaque in Garden.
 * 
 * @see Observatory.Obs1_Slots
 * @author Kevin Rapa
 */
public class Bha_Note extends Note {
    // CONSTRUCTOR ============================================================
    public Bha_Note(String name) {
        super(name);
        this.description = "Wherever you hide this, don't forget where! When the "
                         + "time comes to unbind yourself, you might need some "
                         + "help getting there. (1)Hidden before the sacred fire; "
                         + "(2)Parlor, in plain sight; (3)Beneath the Earth, before the "
                         + "callous multiflora; (4)Dining room, concealed by the blue chalice; "
                         + "(5)Safe with your treasures; (6)High above the Gods; (7)In this room; "
                         + "(8)Beneath the stars, veiled by the memory of Daedalus.";
    }
    //-------------------------------------------------------------------------
}
