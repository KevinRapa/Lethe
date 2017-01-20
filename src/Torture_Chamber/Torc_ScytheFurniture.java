package Torture_Chamber;

import A_Main.Id;
import A_Main.NameConstants;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
/**
 * @author Kevin Rapa
 */
public class Torc_ScytheFurniture extends Furniture implements Resetable {
    private final Item SCYTHE = new Item(NameConstants.SCYTHE, 
            "It's a large black scythe. The edge is quite sharp.");;
    // ========================================================================
    public Torc_ScytheFurniture (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "It's a sharp black scythe hanging sideways on the wall.\n"
                         + "Decoration... perhaps?";
        this.actDialog = "You reach up and take the scythe off the wall.";

        this.addNameKeys("(?:large )?scythe");
        this.addActKeys(GETKEYS);
    }
    // ========================================================================   
    @Override public String interact(String key) {      
        Player.getPos().removeFurniture(this);
        Player.getInv().add(SCYTHE);
        return this.actDialog;
    }
    // ========================================================================  
    /**
     * Replaces scythe if player has it.
     */
    @Override public void reset() {
        if (Player.hasItem(NameConstants.SCYTHE)) {
            Player.getInv().remove(SCYTHE);
            Player.getRoomObj(Id.TORC).addFurniture(this);
        }
    }
     // ========================================================================     
}


