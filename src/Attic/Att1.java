package Attic;
/**
 * @author Kevin Rapa
 */
import A_Main.GUI;
import A_Main.Player;
import A_Super.Room;

public class Att1 extends Room {
// ============================================================================    
    public Att1(String name, String ID) {
        super(name, ID);
        this.description= "You stand on the north side of the Attic. Scattered\n" +
                          "around are piles of various boxes and suitcases collecting\n" +
                          "cobwebs and dust. The room extends back southwards. A bit \n" +
                          "of moonlight shines in through a vent in the ceiling. To your\n" +
                          "east is a door.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited("ATT1"))
            GUI.out("You feel an unnerving presence here. You shutter and look\n"
                  + "around, but see nothing but dark.");
        
        return "You are " + this + ".";
    }
// ============================================================================
}