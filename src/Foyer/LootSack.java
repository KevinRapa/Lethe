package Foyer;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.LOOT_SACK;
import static A_Main.Names.PHASE_DOOR_POTION;
import static A_Main.Names.PHYLACTERY;
import A_Main.Player;
import A_Super.Item;
import A_Super.Note;

/**
 * The loot sack is a special item with its own inventory. As the player
 * collects items, he or she may put them in the sack. This adds points
 * to the player's score as a secondary objective.
 * 
 * To access this item's inventory, it must be cast. Caution.
 * 
 * @author Kevin Rapa
 */
public class LootSack extends Item {
    private final Inventory INV;
    private int worth;
    
    public LootSack() {
        super(LOOT_SACK, "The simple twine sack is crafted with a rounded "
                + "bottom and a thick pullstring at the top.", null , 0);
        this.INV = new SackInventory();
        this.type = LOOT_SACK;
        this.worth = 0;
    }
    //---------------------------------------------------------------------
    @Override public String useEvent() {
        GUI.out("You open up the sack.");
        AudioPlayer.playEffect(1);
        Player.search(INV);
        return this.useDialog;
    }
    //---------------------------------------------------------------------
    /**
     * For use by the text parser only.
     */
    public Inventory getInv() {
        return this.INV;
    }
    //---------------------------------------------------------------------
    public int getWorth() {
        return worth;
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private class SackInventory extends Inventory {
        private final int MAX_SIZE = 20;
        
        public SackInventory() {
            super();
            this.CONTENTS.add(new Note("notice", 
                    "'Notice to staff: not a common utility sack. For loot ONLY!'"));
            this.CONTENTS.ensureCapacity(20);
        }
        //---------------------------------------------------------------------
        @Override public boolean add(Item item) {
            if (item.toString().equals(PHASE_DOOR_POTION)) {
                // Attic event must be able to remove the potion from the inventory.
                GUI.out("You CAN'T EVEN put such an important item in the sack.");
                return false;
            }
            
            if (this.CONTENTS.size() < MAX_SIZE) {
                worth += item.getScore();
                Player.updateScore(getWorth());
                this.CONTENTS.add(item);
                
                // The player may humorously put the sack inside itself.
                if (item.getType().equals(LOOT_SACK))
                    GUI.out("What paradoxical sin of nature are you trying to "
                          + "commit? You better take that back out before "
                          + "you break the universe.");
                else if (item.getType().equals(PHYLACTERY))
                    GUI.out("What sinful greed! Don't you realize we need to "
                          + "destroy those? The aether-dwellers look down "
                          + "shamefully upon you.");
                else {
                    GUI.out("You stuff the " + item + " inside the sack.");
                }
                return true;
            }
            else {
                GUI.out("You can't fit anything more inside!");
                return false;
            }
        }
        //---------------------------------------------------------------------
        @Override public void remove(Item removeThis) {
            worth -= removeThis.getScore();
            Player.updateScore(getWorth());
            this.CONTENTS.remove(removeThis);
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}
