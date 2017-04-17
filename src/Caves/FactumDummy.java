package Caves;

import A_Main.Id;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * The player must take this in the Deep Chamber to obtain the factum.
 * This removes itself from this room once interacted with.
 * 
 * @author Kevin Rapa
 */
public class FactumDummy extends SearchableFurniture implements Gettable {
    private final Item FACTUM_REF;
    // ========================================================================
    public FactumDummy (Item factum) {
        super(factum);
        
        this.FACTUM_REF = factum;
        
        this.description = "Just take the factum and get out!";
        this.actDialog = "You fumble around and grab the artifact.";
        this.searchDialog = this.description;

        this.addNameKeys(ANYTHING);
        this.addActKeys(ANYTHING);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Cave.distortDescription(5, this.description);
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return Cave.distortDescription(1, this.searchDialog);
    }
    // ========================================================================   
    @Override public String interact(String key) {
        Player.getInv().forceAdd(FACTUM_REF); // Forces itself in.
        Player.printInv();
        Player.getPos().removeFurniture(this);
        Player.getRoomObj(Id.EOW1).unlock();
        return Cave.distortDescription(3, this.actDialog);
    }
    // ========================================================================         
}


