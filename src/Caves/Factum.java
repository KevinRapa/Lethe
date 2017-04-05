package Caves;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Item;
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
                Player.teleport(); break;
        }
        return (Player.getPosId().equals(Id.HADS)) ? 
                "The player is dissatisfied with their fate and makes a daring "
                + "escape, foiling the devil itself in an instant." : this.useDialog;
    }
    // =========================================================================
}


