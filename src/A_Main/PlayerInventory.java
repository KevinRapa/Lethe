package A_Main;

import static A_Main.Names.LOOT_SACK;
import A_Super.Item;
import Foyer.LootSack;
import java.util.Comparator;
/**
 * Adds combine methods and sorting abilities which aren't used by furniture.
 * The PlayerInventory may not contain duplicates.
 * Adds get(String itemName) method for use by the TextParser.
 * 
 * @author Kevin Rapa
 */
public class PlayerInventory extends Inventory {
    private static final int MAX_SIZE = 10;
    //-------------------------------------------------------------------------
    public PlayerInventory(Item ... items) {
        super(items);
    }
    //-------------------------------------------------------------------------
    public boolean isFull() {
        return CONTENTS.size() >= MAX_SIZE;
    }
    //-------------------------------------------------------------------------
    /**
     * Adds an item to the inventory, unless the inventory is full.
     * @param item An item to add to this inventory's contents.
     * @return If the add was successful. 
     */
    @Override public boolean add(Item item) {
        if (! isFull()) {
            this.CONTENTS.add(item);

            if (item.getType().equals(LOOT_SACK)) {
                // Shouldn't throw anything, unless 
                // there's another item given LOOT_SACK type.
                try { 
                    LootSack sack = (LootSack)item;
                    Player.updateScore(sack.getWorth());
                }
                catch (ClassCastException e) {
                    System.err.println(e.getMessage());
                }
            }
            return true;
        }
        else {
            GUI.out("You are already carrying too much!");
            return false;
        }
    }
    //-------------------------------------------------------------------------
    @Override public void remove(Item removeThis) {
        super.remove(removeThis);
        
        if (removeThis.getType().equals(LOOT_SACK)) {
            Player.updateScore(0);
        }
    }
    //-------------------------------------------------------------------------
    /**
     * Removes all items from this inventory of the given type.
     * @param type The type of item to remove.
     */
    public void removeType(String type) { 
        this.CONTENTS.removeIf(item -> item.getType().matches(type));
    }
    //-------------------------------------------------------------------------
    /**
     * Removes combined items from this inventory and adds the object formed to this.
     * @param itemList A list of combinable items to be removed.
     * @param gift The item which the combinable items combined into.
     * @return Notifies the player what he or she received.
     */
    public String combine(Item[] itemList, Item gift) {
        for (Item i : itemList) {
            this.CONTENTS.remove(i); 
        }
        
        this.CONTENTS.add(gift);
        AudioPlayer.playEffect(29);
        Player.setLastInteract_Item(gift.toString());
        
        return "You created: " + gift + ".";
    }
    //-------------------------------------------------------------------------
    public void sortInventory() {
        Player.incrementMoves();
        this.CONTENTS.sort(Inventory_Sorter.SORTER);
        Player.printInv();
    }
    //-------------------------------------------------------------------------
    // Returns the number of phylacteries the player is carrying.
    public int countPhylacteries() {
        int result = 0;
        
        for (Item i : CONTENTS) 
            if (i.getScore() == 2000 || i.getScore() == 3000)
                result++;
        
        return result;
    }
    //-------------------------------------------------------------------------
    /**
     * For sorting the items in the player's inventory.
     * A singleton class.
     * @param <T> Item 
     */
    private static class Inventory_Sorter<T extends Comparable<T>> 
            implements Comparator<T> 
    {
        private static final Inventory_Sorter<Item> 
                SORTER = new Inventory_Sorter<>();
        // --------------------------------------------------------------------
        private Inventory_Sorter() {}
        // --------------------------------------------------------------------
        @Override public int compare(T item1, T item2) {
            return item1.compareTo(item2);
        }
    }
}
