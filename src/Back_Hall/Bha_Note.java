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
        this.description = "Wherever you hide this, don't forget where! When the\n"
                         + "time comes to unbind yourself, you might need some\n"
                         + "help getting there. (1)Harp; (2)Parlor, you know where; (3)Under\n"
                         + "the courtyard; (4)Dining room, behind the blue chalice;\n"
                         + "(5)Trophy room, (6)Observatory, you know where; (7)In this room;\n"
                         + "(8)Garden, remember Oswald?";
    }
    // ========================================================================
}
