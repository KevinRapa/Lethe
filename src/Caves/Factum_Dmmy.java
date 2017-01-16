package Caves;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * The player must take this in the Deep Chamber to obtain the factum.
 * This removes itself from this room once interacted with.
 * 
 * @author Kevin Rapa
 */
public class Factum_Dmmy extends Furniture {
    private final Item FACTUM;
    // ========================================================================
    public Factum_Dmmy (Item factum) {
        super();
        this.searchable = false;
        
        this.FACTUM = factum;
        
        this.description = "Just take the factum and get out!";
        this.actDialog = "You fumble around and grab the artifact.";
        this.searchDialog = this.description;

        this.addNameKeys("factum", "the factum");
        this.addActKeys(GETKEYS);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Cave.distortDescription(1, this.description);
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return Cave.distortDescription(1, this.searchDialog);
    }
    // ========================================================================   
    @Override public String interact(String key) {
        Player.getInv().add(FACTUM);
        GUI.invOut("You are carrying:\n" + Player.getInv());
        Player.getPos().removeFurniture(this);
        return Cave.distortDescription(3, this.actDialog);
    }
    // ========================================================================         
}


