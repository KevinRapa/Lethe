package Caves;

import A_Main.Id;
import A_Main.Player;
import A_Super.Item;
import A_Super.Room;
import java.util.Random;
/**
 * This item teleports the player to a room in the castle that the player has
 * visited.
 * 
 * @see Escape_Tunnel.Esc1
 * @author Kevin Rapa
 */
public class Factum extends Item {
    Random generator;
    // =========================================================================
    public Factum(String name) {
        super(name);
        this.useID = 1;
        this.type = "phylactery";
        this.generator = new Random();
        this.description = "You find that you can't describe it very well. It's\n"
                         + "quite light and keeps folding in on itself- changing\n"
                         + "shape. You can't recognize the color either. Almost ultraviolet.";
        this.useDialog = "You've just moved. You aren't quite sure how you did that.";
    }
    // =========================================================================
    /**
     * Displays the player's coordinates in the GUI output window.
     * The coordinates are Cartesian, with the 1st floor being z = 0 and
     * the top row of rooms in the map array being y = 6.
     * @return coordinates of the player.
     */
    @Override public String useEvent() {
        switch (Player.getPosId()) {
            case Id.CHA2:
                Player.setOccupies(Id.VAUE); break;     
            case Id.VAUE:
                Player.setOccupies(Id.CHA2); break;
            default:
                Room room;
                int x, y, z;
                do {
                    x = generator.nextInt(8) + 1;
                    y = generator.nextInt(6) + 1;
                    z = generator.nextInt(7);
                    room = Player.getRoomObj(z,y,x);
                } while (! Player.hasVisited(room.getID()) || room.getID().matches("ESC\\d"));
                Player.setOccupies(z, y, x); 
        }
        return this.useDialog;
    }
    // =========================================================================
}


