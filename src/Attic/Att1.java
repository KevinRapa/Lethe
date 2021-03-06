package Attic;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import A_Main.Menus;
import static A_Main.Names.PHASE_DOOR_POTION;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Room;
import Tunnels.DungeonMonster;

/**
 * The player is captured in ATT1 after creating the phase door potion.
 * 
 * @author Kevin Rapa
 */
public class Att1 extends Room {
    private final int PRIS_CBNT_ID;
//-----------------------------------------------------------------------------    
    public Att1(String name, String ID, Furniture prisCbnt) {
        super(name, ID);

        this.PRIS_CBNT_ID = prisCbnt.getID();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (Player.hasItem(PHASE_DOOR_POTION) && ! Player.hasVisited(Id.INTR)) {
            Inventory inv = Player.getInv();
            Inventory cbntInv = Player.getRoomObj(Id.PRIS)
                    .getFurnRef(PRIS_CBNT_ID).getInv();
            
            this.dialog();
            
            for (Item i : inv) 
                if (! i.toString().equals(PHASE_DOOR_POTION)) {
                   cbntInv.add(i);
                }
            
            inv.clear();
            Player.updateScore(0);
            Player.setShoes("");
            
            Player.setOccupies(Id.INTR);
            Player.getRoomObj(Id.EOW1).setLocked(true);
            DungeonMonster.startMovement();
            AudioPlayer.playEffect(8, 0.8);
            Player.printInv();
            return "";
        }
        return NAME;
    }
//-----------------------------------------------------------------------------
    private void dialog() {
        GUI.menOut(Menus.ENTER);
        GUI.clearDesc();
        GUI.invOut("");
        
        GUI.out("As you exit the laboratory, you are startled to see a hideous, decrepit "
              + "bald male wearing black robes standing among the shadows in the center of the attic. "
              + "You freeze, unable to move. Several seconds pass...");
        GUI.promptOut();
        
        GUI.out("   ...");
        GUI.promptOut();
        
        GUI.out("Several more seconds pass. Before you can realize, you are "
              + "unconscious...");
        GUI.promptOut();
        
        GUI.out("   ... ... ...");
        GUI.promptOut();
    }
//-----------------------------------------------------------------------------
}