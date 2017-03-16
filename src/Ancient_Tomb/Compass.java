package Ancient_Tomb;

import A_Main.Player;
import A_Super.Item;
/**
 * This compass displays the player's coordinates in the castle using a
 * Cartesian system.
 * 
 * This item is used to locate the iridescent jewel in the catacombs.
 * 
 * @see Ancient_Tomb.Ant_NPC
 * @author Kevin Rapa
 */
public class Compass extends Item {
    // =========================================================================
    public Compass(String name) {
        super(name, 100);
        this.useID = 1;
        this.description = "You can't quite figure out what it is. It's a small\n"
                         + "metal box with a bit of heft. A polished rock of\n"
                         + "quartz has been fit into its center indentation, acting\n"
                         + "as a window of sorts. On the top and bottom of the box\n"
                         + "are copper plates.";
        this.useDialog = "You grasp the box firmly with your fingers and palm\n"
                       + "covering the plates. In a short while, 3 digits:\t\t[";
    }
    // =========================================================================
    /**
     * Displays the player's coordinates in the GUI output window.
     * The coordinates are Cartesian, with the 1st floor being z = 0 and
     * the top row of rooms in the map array being y = 6.
     * @return coordinates of the player.
     */
    @Override public String useEvent() {
        int[] c = Player.getPos().getCoords();
        int z = Math.abs(c[0] - 6) - 3;
        int y = Math.abs(c[1] - 7);
        
        return this.useDialog.concat(c[2] + ", " + y + ", " + z + 
                                     "]\t\tmaterialize in the quartz window.");
    }
    // =========================================================================
}
