package Caves;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Patterns.NO_TELEPORT_P;
import A_Main.Player;
import A_Super.Item;
import java.util.Random;
/**
 * This item teleports the player to a room in the castle that the player has
 * visited.
 * Used to access the Vault.
 * 
 * @see Vault.Vaue
 * @see Escape_Tunnel.Esc1
 * @author Kevin Rapa
 */
public class Factum extends Item {
    private transient Random generator;
    // =========================================================================
    public Factum(String name, int score) {
        super(name, score);
        this.useID = 1;
        this.type = "phylactery";
        this.description = "You find that you can't describe it very well. It's "
                         + "quite light and keeps folding in on itself- changing "
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
        Cave.stopClip();
        AudioPlayer.playEffect(49);
        
        switch (Player.getPosId()) {
            case Id.CHA2:
                Player.setOccupies(Id.VAUE); break;     
            case Id.VAUE:
                Player.setOccupies(Id.CHA2); break;
            default:
                int index;
                String roomId;
                generator = new Random();
                
                index = generator.nextInt(Player.getVisitedRooms().size());
                roomId = Player.getVisitedRooms().get(index);
                
                while (NO_TELEPORT_P.matcher(roomId).matches() || 
                       roomId.equals(Player.getPosId())) 
                {
                    index = generator.nextInt(Player.getVisitedRooms().size());
                    roomId = Player.getVisitedRooms().get(index);
                }
                Player.setOccupies(roomId);
                break;
        }
        return this.useDialog;
    }
    // =========================================================================
}


