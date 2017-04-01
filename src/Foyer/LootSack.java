package Foyer;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Names;
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
        super(Names.LOOT_SACK, "An elegent black velvet sack with a rope "
                + "wrapped around the top. A reddish aura coats its surface.", 0);
        this.INV = new SackInventory();
        this.type = Names.LOOT_SACK;
        this.worth = 0;
    }
    //---------------------------------------------------------------------
    @Override public String useEvent() {
        AudioPlayer.playEffect(1);
        Player.search(INV);
        return this.useDialog;
    }
    //---------------------------------------------------------------------
    // For use by text parser only.
    public Inventory getInv() {
        return this.INV;
    }
    //---------------------------------------------------------------------
    // Returns the number of phylacteries in here.
    public int countPhylacteries() {
        int result = 0;
        
        for (Item i : this.INV) {
            if (i.getScore() == 1500 || i.getScore() == 2000)
                result++;
        }
        
        return result;
    }
    //---------------------------------------------------------------------
    // Returns the number of special treasures in here.
    public int countTreasures() {
        int result = 0;
        
        for (Item i : this.INV) {
            if (i.getScore() == 500 || i.getScore() == 1000)
                result++;
        }
        
        return result;
    }
    //---------------------------------------------------------------------
    public boolean isFull() {
        return ((SackInventory)INV).isFull();
    }
    //---------------------------------------------------------------------
    public int getWorth() {
        return worth;
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private class SackInventory extends Inventory {
        private final int MAX_SIZE = 16;
        
        public SackInventory() {
            super();
            this.CONTENTS.add(new Note("notice", 
                    "'Notice to staff: not a common utility sack. For loot ONLY!'"));
            this.CONTENTS.ensureCapacity(MAX_SIZE);
        }
        //---------------------------------------------------------------------
        public boolean isFull() {
            return this.CONTENTS.size() >= MAX_SIZE;
        }
        //---------------------------------------------------------------------
        @Override public boolean add(Item item) {
            if (item.toString().equals(Names.PHASE_DOOR_POTION)) {
                // Attic event must be able to remove the potion from the inventory.
                GUI.out("You CAN'T EVEN put such an important item in the sack.");
                return false;
            }
            
            if (this.CONTENTS.size() < MAX_SIZE) {
                worth += item.getScore();
                Player.updateScore(getWorth());
                this.CONTENTS.add(item);
                
                // The player may humorously put the sack inside itself.
                if (item.getType().equals(Names.LOOT_SACK))
                    GUI.out("What paradoxical sin of nature are you trying to "
                          + "commit? You better take that back out before "
                          + "you break the universe.");
                else if (item.getType().equals(Names.PHYLACTERY))
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
