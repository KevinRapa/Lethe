package Cistern;

import A_Main.AudioPlayer;
import A_Main.Player;
import static A_Main.NameConstants.METAL_BUCKET;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cis_Water extends Furniture implements Gettable {
    protected final Item WTR_BCKT;
    // ========================================================================
    public Cis_Water (Item wtr) {
        super();
        
        this.WTR_BCKT = wtr;
        
        this.description = "The water is stagnant and fills the room with a putrid smell.\n"
                         + "A skin of algae coats nearly all of it.";
        this.actDialog = "This water is looks and smells terrible. You aren't doing that.";
        this.searchDialog = "You aren't searching that.";
        this.useDialog = "You pick some of the water up in the bucket.";

        this.addNameKeys("(?:stagnant )?(?:(?:large )?body of )?(?:putrid |disgusting |smelly |awful )?(?:stagnant )?water");
        this.addActKeys(GETKEYS);
        this.addActKeys("swim", "jump", "drink");
        this.addUseKeys(METAL_BUCKET);
    }
    // ======================================================================== 
    @Override public String useEvent(Item item) {
        AudioPlayer.playEffect(42);
        Player.getInv().remove(item);
        Player.getInv().add(WTR_BCKT);
        
        return this.useDialog;
    }
    // ========================================================================
    @Override public String interact(String key) {
        if (key.equals("swim") || key.equals("jump") || key.equals("dive"))
            return this.actDialog;
        else
            return getIt();
    }
    // ========================================================================
    @Override public String getIt() {
        if (Player.hasItem(METAL_BUCKET))
            return this.useEvent(Player.getInv().get(METAL_BUCKET));
        else
            return "You'll need an empty bucket...";
    }
    // ========================================================================
}


