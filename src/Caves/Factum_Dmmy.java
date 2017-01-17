package Caves;

import A_Main.Id;
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
    private final Item FACTUM_REF;
    // ========================================================================
    public Factum_Dmmy (Item factum) {
        super();
        this.searchable = false;
        
        this.FACTUM_REF = factum;
        
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
        Player.getInv().add(FACTUM_REF);
        Player.printInv();
        Player.getPos().removeFurniture(this);
        Player.getRoomObj(Id.EOW1).unlock();
        return Cave.distortDescription(3, this.actDialog);
    }
    // ========================================================================         
}


