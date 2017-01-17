package Torture_Chamber;

import A_Main.Id;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.Room;
/**
 * This furniture holds the metal ladder needed to place the metal pipe in 
 * SEW4.
 * 
 * TORC also has a dummy furniture can Torc_Ladder which may be interacted with
 * to get the ladder as well.
 * 
 * @see Sewers.Sew4_Pp
 * @author Kevin Rapa
 */
public class Torc_Swhrses extends Furniture implements Resetable {
    private final Item METAL_LADDER = new Metal_Ladder("metal ladder");
    private final Furniture TORC_LDDR = new Torc_Lddr();;
    // ========================================================================
    public Torc_Swhrses (Room torc, Item... items) {
        super();
        
        this.inv = new Sawhorse_Inventory(METAL_LADDER);
        
        torc.addFurniture(TORC_LDDR);
        
        this.description = "The two sawhorses are spread apart about 8 feet.";
        this.searchDialog = "The sawhorses are holding up a ladder-like metal device.";
        this.useDialog = "You place the metal ladder back on the sawhorses.";

        this.addNameKeys("(?:two )?sawhorses?");
        this.addUseKeys("metal ladder");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.hasLadder() ? this.description.concat(" They are holding up\n"
                + "a device resembling two parallel 10-foot long metal poles attached\n"
                + "together via many shorter perpendicular metal poles.") :
                this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return hasLadder() ? this.searchDialog :
                "You check around the sawhorses.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        this.inv.add(item);
        Player.getRoomObj(Id.TORC).addFurniture(TORC_LDDR);
        return this.useDialog;
    }
    // ========================================================================     
    @Override public void reset() {
        if (Player.hasItem("metal ladder")) {
            this.inv.add(METAL_LADDER);
            Player.getInv().remove(METAL_LADDER);
            Player.getRoomObj(Id.TORC).addFurniture(TORC_LDDR);
        }
    }
    // ========================================================================     
    private boolean hasLadder() {
        return containsItem("metal ladder");
    }
    // ========================================================================     
    // ************************************************************************
    // ========================================================================  
    public class Sawhorse_Inventory extends Inventory {
        public Sawhorse_Inventory(Item ... items) {
            super(items);
        }
        // ====================================================================
        @Override public void remove(Item removeThis) {      
            this.CONTENTS.remove(removeThis);
            if (removeThis.equals(METAL_LADDER)) 
                Player.getRoomObj(Id.TORC).removeFurniture(TORC_LDDR);
        }
        // ====================================================================  
        @Override public boolean add(Item item) {
            this.CONTENTS.add(item);
            if (item.equals(METAL_LADDER)) 
                    Player.getRoomObj(Id.TORC).addFurniture(TORC_LDDR);
            return true;
        }
    }
    // ========================================================================     
    // ************************************************************************
    // ======================================================================== 
    private class Torc_Lddr extends Furniture {
        // ====================================================================
        public Torc_Lddr () {
            super();

            this.searchable = false;

            this.description = "The ladder-like object sits horizontally across the sawhorses.";
            this.actDialog = "You take the metal device off from the sawhorses.";
            
            this.addNameKeys("(?:metal )?ladder", "two parallel 10-foot long metal poles attached "
                           + "together via many shorter perpendicular metal poles");
            this.addActKeys(GETKEYS);
        }
        // ==================================================================== 
        @Override public String interact(String key) {              
            Player.getPos().removeFurniture(this);
            Torc_Swhrses.this.getInv().give(METAL_LADDER, Player.getInv());
            return this.actDialog;
        } 
    }
    // ========================================================================     
    // ************************************************************************
    // ======================================================================== 
}


