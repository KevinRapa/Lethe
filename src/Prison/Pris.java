package Prison;

import A_Super.Furniture;
import A_Super.Openable;
import A_Super.Room;
/**
 * Holds a clue for solving the valve puzzle, contains the oubliette key.
 * Oubliette key is not a necessary item.
 * 
 * @author Kevin Rapa
 */
public class Pris extends Room {
    private final Furniture[] CELLS = {
        new Pris_Cll("1", "one", "You see a pair of wall shackles and a metal\n"
                   + "bucket on the floor."),
        new Pris_Cll("2", "two", "This cell has a skeleton in\n"
                   + "it. It sits in the corner with its two hands in the wall shackles."),
        new Pris_Cll("3", "three", "This cell has the remains of a skeleton in it.\n It\n"
                   + "lacks anything below the pelvis, and one of its arms is in a\n"
                   + "wall shackle."),
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
        new Pris_Cll("6", "six", "The back wall in this cell has caved in somewhat,\n"
                   + "and the cell has filled with dirt.")
    };
// ============================================================================    
    public Pris(String name, String ID) {
        super(name, ID);
        this.description= "You are in a prison of sorts. Lining the west and south\n" +
                          "of the room are several cells with simple barred gates.\n" +
                          "In the center of the room is a large wooden table. Several\n" +
                          "scattered standing candelabras light the chamber. Against\n" +
                          "the north wall is a simple wooden cabinet. On both the west\n"
                        + "and east walls are metal doors.";
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