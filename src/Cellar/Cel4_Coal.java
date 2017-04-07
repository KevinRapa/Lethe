package Cellar;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import A_Main.Names;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cel4_Coal extends Furniture implements Gettable, Unmoveable {
    private final Item COAL_REF;
    // ========================================================================
    public Cel4_Coal (Item coal) {
        super();
        
        this.COAL_REF = coal;
        
        this.description = "It's a simple mound of coal.";
        this.actDialog = "How most imprudent. Besides, you have nothing to set it ablaze.";
        this.searchDialog = "Searching the coal mound reveals only coal.";
        this.useDialog = "That is not prudent.";

        this.addNameKeys("(?:coal )?mound", "coal");
        this.addUseKeys(SHOVEL, TROWEL, HAND_TORCH);
        this.addActKeys(GETPATTERN, "burn", SHOVEL, "dig");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("burn"))
            return Player.hasItem(Names.HAND_TORCH) ? 
                    this.useDialog : this.actDialog;
        else if (key.equals(SHOVEL) || key.equals("dig")) {
            if (Player.hasItem(SHOVEL) || Player.hasItem(TROWEL)) {
                Item i = Player.getInv().get(SHOVEL);
                
                if (i.equals(Inventory.NULL_ITEM))
                    i = Player.getInv().get(TROWEL);
                
                return useEvent(i);
            }
            else
                return "You have nothing to dig the coal with. Of course, you "
                        + "could simple take one.";
        }
        else
            return getIt();
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(SHOVEL) 
                || item.toString().equals(TROWEL)) {
            AudioPlayer.playEffect(34);
            return getIt();
        }
        else
            return this.useDialog;
    }
    // ========================================================================   
    @Override public String getIt() {
        return (Player.getInv().add(COAL_REF)) ?
             "You take a piece of coal." : NOTHING;
    }
    // ========================================================================   
}


