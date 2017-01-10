package Attic;
/**
 * @author Kevin Rapa
 */
import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;

public class Att2 extends Room {
// ============================================================================    
    public Att2(String name, String ID) {
        super(name, ID);
        this.description= "You have made your way up to the castle attic. Scattered\n" +
                          "around are piles of various boxes and suitcases collecting\n" +
                          "cobwebs and dust. The room extends northward with a door\n" +
                          "on the far east side of the room. A bit of moonlight\n" +
                          "shines in through a couple vents in the ceiling.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited("ATT2"))
            GUI.out("You feel an unnerving presence here. You shutter and look\n"
                  + "around, but see nothing but dark.");
        
        return "You are " + Player.getPos() + ".";
    }
// ============================================================================
}