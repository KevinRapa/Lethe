package Attic;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import static A_Main.NameConstants.PHASE_DOOR_POTION;
import A_Main.Player;
import A_Super.Item;
import A_Super.Room;
import Tunnels.DungeonMonster;
/**
 * The attic contains boxes and cases which display randomly chosen items when
 * searched, however there is a hidden suitcase containing a needed lab coat.
 * 
 * The player is captured in ATT1 after creating the phase door potion.
 * 
 * @see Laboratory.Labo_CoatNote
 * @author Kevin Rapa
 */
public class Att1 extends Room {
    private boolean captured;
    private final Inventory PRIS_CBNT_INV_REF;
// ============================================================================    
    public Att1(String name, String ID, Inventory prisCbntInv) {
        super(name, ID);
        this.captured = false;
        this.PRIS_CBNT_INV_REF = prisCbntInv;
        this.description= 
                "You stand on the north side of the Attic. Scattered\n" +
                "around are piles of various boxes and suitcases collecting\n" +
                "cobwebs. The room extends back southwards. A bit\n" +
                "of moonlight shines in through a vent in the ceiling. To your\n" +
                "east is a door.";
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (Player.hasItem(PHASE_DOOR_POTION) && ! this.captured) {
            Inventory inv = Player.getInv();
            
            this.captured = true;
            this.dialog();
            
            for (Item i : inv) 
                if (! i.toString().equals(PHASE_DOOR_POTION))
                    this.PRIS_CBNT_INV_REF.add(i);
            
            inv.clear();
            Player.updateScore(0);
            Player.setShoes("");
            
            Player.setOccupies(Id.INTR);
            Player.getRoomObj(Id.EOW1).lock();
            DungeonMonster.startMovement();
            AudioPlayer.playEffect(8, 0.8);
            Player.printInv();
            return null;
        }
        return STD_RM_OUT;
    }
// ============================================================================
    private void dialog() {
        GUI.menOut("\nPress enter...");
        GUI.clearDesc();
        GUI.invOut("");
        
        GUI.out("As you exit the laboratory, you are startled to see a hideous, decrepit\n"
              + "bald male wearing black robes standing among the shadows in the center of the attic.\n"
              + "You freeze, unable to move. Several seconds pass...");
        GUI.promptOut();
        
        GUI.out("   ...");
        GUI.promptOut();
        
        GUI.out("Several more seconds pass. Before you can realize, you are\n"
              + "unconscious...");
        GUI.promptOut();
        
        GUI.out("   ... ... ...");
        GUI.promptOut();
    }
// ============================================================================
}