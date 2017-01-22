package Attic;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Room;
/**
 * The attic contains boxes and cases which display randomly chosen items when
 * searched, however there is a hidden suitcase containing a needed lab coat.
 * 
 * The player is captured in ATT1 after creating the phase door potion.
 * 
 * @see Laboratory.Labo_CoatNote
 * @author Kevin Rapa
 */
public class Att2 extends Room {
// ============================================================================    
    public Att2(String name, String ID) {
        super(name, ID);
        this.description= "You have made your way up to the castle attic. Scattered\n" +
                          "around are piles of various boxes and suitcases collecting\n" +
                          "cobwebs and dust. The room extends northwards with a door\n" +
                          "on the far east side of the room. A bit of moonlight\n" +
                          "shines in through a couple vents in the ceiling.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(Id.ATT2)) {
            AudioPlayer.playEffect(52);
            GUI.out("You feel an unnerving presence here. You shutter and look\n"
                  + "around, but see only darkness.");
        }
        
        return this.STD_RM_OUT;
    }
// ============================================================================
}