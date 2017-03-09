package A_Super;

import A_Main.AudioPlayer;

/**
 * Objects marked as moveable will give dialog if the player types "move *this*'
 * @author Kevin Rapa
 */
public interface Moveable {
    default String moveIt() {
        AudioPlayer.playEffect(44);
        return "You manage to displace it a little, but nothing out of the ordinary is revealed.";
    }
}
