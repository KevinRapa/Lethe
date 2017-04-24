package Cistern;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Menus;
import static A_Main.Names.WOODEN_OAR;
import A_Main.Player;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cis2_Boat extends SearchableFurniture {

    //-------------------------------------------------------------------------
    public Cis2_Boat (Item... items) {
        super(items);
        
        this.description = "The slender wooden canoe floats in the disgusting "
                + "water, docked right near the ledge.";
        this.actDialog = "You are now inside the canoe.";
        this.searchDialog = "You look inside the canoe.";
        this.useDialog = "You paddle in silence for many minutes in the dark. "
                + "Somehow, without any guidance, you see a stone platform emerge "
                + "from the darkness ahead, and the canoe gently docks by it.";

        this.addNameKeys("(?:slender )?(?:wooden )?(?:canoe|boat)");
        this.addUseKeys(WOODEN_OAR);
        this.addActKeys("ride|paddle|launch|get", "climb|enter|go", "leave");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("leave"))
            return "You aren't even in the canoe.";
        else if (Player.hasItem(WOODEN_OAR))
            return this.transport();
        else
            return "You really have nothing proper to paddle with.";
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        return this.transport();
    }
    //-------------------------------------------------------------------------  
    // Transports the player between areas of the cistern.
    private String transport() {
        if (Player.getPosId().equals(Id.CIS2))
            Player.setOccupies(Id.CIS5);
        else
            Player.setOccupies(Id.CIS2);
        
        AudioPlayer.playEffect(42);
        GUI.menOut(Menus.ENTER);
        GUI.descOut(this.useDialog);
        GUI.clearDialog();
        GUI.promptOut();
        Player.describeRoom();
        
        return NOTHING;
    }
    //-------------------------------------------------------------------------     
}


