package Cellar;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cel5_Furnace extends SearchableFurniture 
        implements Unmoveable, Gettable, Openable 
{
    private boolean lit;
    //-------------------------------------------------------------------------
    public Cel5_Furnace () {
        super();
        
        this.lit = false;
        this.description = "A ramshackle tin furnace. It is unlit. A tin pipe "
                + "feeds out the top and into the ceiling.";
        this.actDialog = "You have nothing to light the furnace with.";
        this.searchDialog = "You open up the furnace.";
        this.useDialog = "You stick the torch in and light it ablaze. The warmth is comforting.";

        this.addNameKeys("(?:ramshackle )?(?:cylindrical )?(?:metal |tin )?furnace");
        this.addUseKeys(HAND_TORCH, COAL, METAL_BUCKET, BUCKET_OF_WATER);
        this.addActKeys("light", GETPATTERN);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return lit ? this.description.replaceFirst("un", "") : this.description;
    }
    //-------------------------------------------------------------------------   
    @Override public String getSearchDialog() {
        this.searchable = ! this.lit;
        
        return searchable ? this.searchDialog : 
                "Best not do that while the furnace is lit.";
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("light")) {
            if (Player.hasItem(HAND_TORCH)) {
                Item torch = Player.getInv().get(HAND_TORCH);
                return this.useEvent(torch);
            }
            else
                return this.actDialog;
        }
        else
            return getIt();
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        String name = item.toString();
        
        if (name.equals(HAND_TORCH)) {
            if (lit)
                return "The furnace is lit already.";
            else if (this.containsItem(COAL)) {
                this.lit = true;
                return this.useDialog;
            }
            else
                return "The furnace is empty of coal.";
        }
        else if (name.equals(COAL)) {
            Player.getInv().give(item, this.inv);
            return "You toss the lump of coal in the furnace.";
        }
        else if (name.equals(BUCKET_OF_WATER)) {
            if (lit) {
                this.lit = false;
                AudioPlayer.playEffect(39, 0.3);
                return "You pour a bit of water on, extinguishing the fire.";
            }
            else
                return "The furnace isn't lit right now.";
        }
        else
            return "The player immediately realizes that the bucket is empty.";
    }
    //-------------------------------------------------------------------------     
}


