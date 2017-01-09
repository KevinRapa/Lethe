package Caves;

import A_Main.Player;
import A_Super.Item;
import A_Super.Room;
import java.util.Random;
/**
 * This item teleports the player to a room in the castle that the player has
 * visited.
 * 
 * @author Kevin Rapa
 */
public class Magic_Artifact extends Item {
    Random generator;
    // =========================================================================
    public Magic_Artifact(String name) {
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
        Room room;
        int X, Y, Z;

        do {    
            X = generator.nextInt(8) + 1;
            Y = generator.nextInt(6) + 1;
            Z = generator.nextInt(7);
            room = Player.getMapRef()[Z][Y][X];                
        } while (! Player.hasVisited(room.getID()));    

        Player.setOccupies(Z, Y, X);  
        
        return this.useDialog;
    }
    // =========================================================================
}


