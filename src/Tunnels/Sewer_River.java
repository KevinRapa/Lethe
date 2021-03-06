package Tunnels;

import A_Main.AudioPlayer;
import A_Main.Player;
import static A_Main.Names.METAL_BUCKET;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Defines general methods for the river in the tunnels.
 * @author Kevin Rapa
 */
public class Sewer_River extends SearchableFurniture implements Gettable {
    protected final Item WTR_BCKT;
    //-------------------------------------------------------------------------
    public Sewer_River (Item bckt, Item... items) {
        super(items);
        this.WTR_BCKT = bckt;
        
        this.description = "The river runs rapidly through a square channel on "
                         + "one side of the tunnel. The water looks cool and clear. "
                         + "This is possibly being used as a power source before "
                         + "reaching the ocean.";
        this.actDialog = "The water is treacherous and not worth the risk.";
        this.searchDialog = "You crouch down and scan the bottom of the river.";
        this.useDialog = "You scoop up some of the water into the bucket.";

        this.addNameKeys("(?:raging )?river(?: of water)?", "(?:flowing )?water", 
                "(?:square )?channel");
        this.addActKeys("swim", "jump", "drink", GETPATTERN, "hide");
        this.addUseKeys(METAL_BUCKET);
    }
    //------------------------------------------------------------------------- 
    @Override public String useEvent(Item item) {
        AudioPlayer.playEffect(42);
        Player.getInv().remove(item);
        Player.getInv().add(WTR_BCKT);
        
        return this.useDialog;
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return (this.inv.size() != 0) ? 
                this.description.concat(" You can see something lying at the bottom.") :
                this.description;
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("drink"))
            return "The water looks and smells clean enough. You crouch down and "
          + "take a swig, feeling refreshed.";
        else if (key.equals("swim") || key.equals("hide") || key.equals("jump"))
            return this.actDialog;
        else
            return getIt();
    } 
    //-------------------------------------------------------------------------   
    @Override public String getIt() {
        if (Player.hasItem(METAL_BUCKET))
            return this.useEvent(Player.getInv().get(METAL_BUCKET));
        else
            return "You'll need an empty bucket...";
    }
    //-------------------------------------------------------------------------
}


