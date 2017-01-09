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
        
        else if (Player.hasItem("phase door potion")) {
            this.initiateDialog();
        }
        
        return "You are " + Player.getPos() + ".";
    }
// ============================================================================
    private void initiateDialog() {
        GUI.menOut("\nPress enter...");
        GUI.invOut("");
        
        GUI.out("As you exit the laboratory, you are startled to see a hideous, decrepit\n"
              + "bald male standing among the shadows in the center of the attic.\n"
              + "You freeze, unable to move. Several seconds pass...");
        GUI.promptOut();
        
        GUI.out("   ...");
        GUI.promptOut();
        
        GUI.out("\"I have been following you...\"");
        GUI.promptOut();
        
        GUI.out("Several more seconds pass. Before you can realize, you are"
              + "unconcious...\n");
        GUI.promptOut();
        
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        Player.getInv().contents().clear();
        Player.getKeys().contents().clear();
        
        Player.setOccupies(4, 6, 3);
        GUI.toMainMenu();
        GUI.invOut("You are carrying:\n" + Player.getInv());
    }
// ============================================================================
}