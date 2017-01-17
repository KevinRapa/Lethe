package Attic;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import static A_Main.NameConstants.PHASE_DOOR_POTION;
import A_Main.Player;
import A_Super.Item;
import A_Super.Room;
/**
 * The attic contains boxes and cases which display randomly chosen items when
 * searched, however there is a hidden suitcase containing a needed lab coat.
 * 
 * The player is captured in ATT1 after creating the phase door potion.
 * 
 * @see Laboratory.Labo_CoatNt
 * @author Kevin Rapa
 */
public class Att1 extends Room {
    private boolean captured;
    private final Inventory REF_LICH_CHEST_INV;
// ============================================================================    
    public Att1(String name, String ID, Inventory lichChstInv) {
        super(name, ID);
        this.captured = false;
        this.REF_LICH_CHEST_INV = lichChstInv;
        this.description= "You stand on the north side of the Attic. Scattered\n" +
                          "around are piles of various boxes and suitcases collecting\n" +
                          "cobwebs and dust. The room extends back southwards. A bit \n" +
                          "of moonlight shines in through a vent in the ceiling. To your\n" +
                          "east is a door.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(Id.ATT1))
            GUI.out("You feel an unnerving presence here. You shutter and look\n"
                  + "around, but see nothing but dark.");
        
        else if (Player.hasItem(PHASE_DOOR_POTION) && ! this.captured) {
            this.captured = true;
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
        
        GUI.out("Several more seconds pass. Before you can realize, you are\n"
              + "unconcious...\n");
        GUI.promptOut();
        
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        for (Item i :Player. getInv())
            this.REF_LICH_CHEST_INV.add(i);
            
        Player.getInv().clear();
        
        Player.setOccupies(Id.INTR);
        Player.getRoomObj(Id.EOW1).lock();
        Player.printInv();
    }
// ============================================================================
}