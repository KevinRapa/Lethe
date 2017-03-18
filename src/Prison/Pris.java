package Prison;

import A_Super.Furniture;
import A_Super.Openable;
import A_Super.Room;
/**
 * Holds a clue for solving the valve puzzle, contains the oubliette key.
 * Oubliette key is not a necessary item.
 * Connects to Sew3, Torc, and Sew5.
 * 
 * @see Tunnels.Sew3
 * @see Tunnels.Sew5
 * @see Torture_Chamber.Torc
 * @author Kevin Rapa
 */
public class Pris extends Room {
// ============================================================================
    private final Furniture[] CELLS = {
        new Pris_Cll("1", "one", "You see a pair of wall shackles and a metal\n"
                   + "bucket on the floor."),
        new Pris_Cll("2", "two", "Sitting in this cell is a spooky blue ghost; "
                + "a scruffy bald male with a long beard and primitive clothing."),
        new Pris_Cll("3", "three", "This cell has the remains of a skeleton in it. It\n"
                   + "lacks anything below the pelvis, and one of its arms is\n"
                   + "shackled."),
        new Pris_Cll("4", "four", "This cell has nothing in it but a bucket and a\n"
                   + "few bones. There is a carving on the wall of the cell:"
                + "           __\n" +
                  "                        _///\n" +
                  "                      _///¯\n" +
                  "               _______///¯ \n" +
                  "                \\\\\\\\\\\\\\||  \n" +
                  "                  ¯¯¯¯¯|||    \n" +
                  "                     |||____ \n" +
                  "                    |||\\\\\\\\\\\n" +
                  "                     ¯¯¯¯¯¯¯"
        ),
        new Pris_Cll("5", "five", "You see a pair of wall shackles and a metal\n"
                   + "bucket on the floor."),
        new Pris_Cll("6", "six", "The back wall here has caved in somewhat\n"
                   + "and the cell has filled with dirt.")
    };
// ============================================================================    
    public Pris(String name, String ID) {
        super(name, ID);
        this.description= 
                "You are in a room with 6 prison cells lining the west and north.\n" +
                "Metal doors lead both west and east. A large wooden table sits\n" +
                "In the center of the room. Several scattered standing candelabras "
              + "give a low level of light, just enough to see an sitting figure "
              + "in cell 2. Against the north wall is a simple wooden cabinet.";
        this.addFurniture(CELLS);
    }
// ============================================================================    
    public String getCellDescription(int i) {
        return this.CELLS[i - 1].getDescription();
    }
// ============================================================================
// ****************************************************************************    
// ============================================================================
    private class Pris_Cll extends Furniture implements Openable {
        public Pris_Cll (String num, String numWord, String desc) {
            super();
            this.searchable = false;
            this.description = "The cell gate is locked. You walk up to the bars and\n"
                             + "look inside. " + desc;
            this.addNameKeys("(?:gated )?(?:prison )?cell (?:" + num + "|" + numWord + ")");
        }  
        // ====================================================================
        @Override public String getSearchDialog() {
            return this.getDescription();
        }
    }
// ============================================================================
// ****************************************************************************
// ============================================================================    
}