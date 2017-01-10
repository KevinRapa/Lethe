package Laboratory;
/**
 * @author Kevin Rapa
 */
import A_Super.Room;

/*
    Player must have the lab coat on to use the equipment.
    Player must make a phase door potion.

    1. Use florence flask on distiller
    2. Connect hose to gas pipe and turn it on
    3. Open condensing tube
    3.5. Put bromine into barrel, let it chill for 30 seconds.
    4. Titrate and add exactly these 5 ingredients (Use dispensers and burette):
        chilled bromine, 10mL
        vinegar, 5mL
        aether, 15mL
        wine, 10mL
        carbonic acid, 35mL
    5. Use beaker on condenser
    6. Use striker on the bunsen burner
    7. Take the beaker.
*/

public class Labo extends Room {
// ============================================================================    
    public Labo(String name, String ID) {
        super(name, ID);
        this.description= "You find yourself in a laboratory hidden\n" +
                          "behind the attic in which many alchemical devices are\n" +
                          "around the room. At the far east wall are a\n" +
                          "line of opaque dispensers, probably filled with liquid.\n" +
                          "On a counter to the north is a complicated alchemical\n" +
                          "contraption with many glass tubes. On the same counter\n" +
                          "to the left is a metal sink. In the center of the room\n" +
                          "is a tall burette standing on a table. To the south\n" +
                          "is a shelf filled with various chemistry tools, and to\n" +
                          "the right of it is a barrel. In the corner next to the\n" +
                          "contraption is a pipe running up the height of the room.";
    }
// ============================================================================
}