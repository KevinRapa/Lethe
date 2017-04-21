package Tunnels;

import A_Main.AudioPlayer;
import A_Main.Player;
import static A_Main.Names.METAL_BUCKET;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * Defines general methods for the river in the tunnels.
 * @author Kevin Rapa
 */
public class Sewer_River extends SearchableFurniture {
    protected final Item WTR_BCKT;
    //-------------------------------------------------------------------------
    public Sewer_River (Item bckt, Item... items) {
        super(items);
        this.WTR_BCKT = bckt;
        
        this.description = "The river runs rapidly through a square channel on "
                         + "one side of the tunnel. The water looks cool and clear. "
                         + "Maybe it's being used as a power source here before emptying "
                         + "out into the ocean?";
        this.actDialog = "You aren't getting in there unless you absolutely have to.";
        this.searchDialog = "You crouch down and scan the bottom of the river.";
        this.useDialog = "You scoop up some of the water into the bucket.";

        this.addNameKeys("(?:raging )?river(?: of water)?", "(?:flowing )?water", 
                "(?:square )?channel");
        this.addActKeys("swim", "jump", "drink");
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
        return key.equals("drink") ?
            "The water looks and smells clean enough. You crouch down and "
          + "take a swig, feeling refreshed." : this.actDialog;
    } 
    //-------------------------------------------------------------------------   
}


