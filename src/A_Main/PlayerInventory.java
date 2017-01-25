package A_Main;

import A_Super.Item;
import java.util.Comparator;
/**
 * Adds combine methods and sorting abilities which aren't used by furniture.
 * Adds get(String itemName) method for use by the TextParser.
 * 
 * @author Kevin Rapa
 */
public class PlayerInventory extends Inventory {
    private final Item NULL_ITEM = 
            new Item("null item", "Oops! Looks like there's a bug in the game, "
                   + "this item will self-destruct in 5 seconds... Just kidding.");
    // ========================================================================
    public PlayerInventory(Item ... items) {
        super(items);
    }
    // ========================================================================
    /**
     * Adds an item to the inventory.
     * @param item An item to add to this inventory's contents.
     * @return If the add was successful. 
     */
    @Override public boolean add(Item item) {
        if (! CONTENTS.contains(item)) {
            this.CONTENTS.add(item);
            return true;
        }
        else {
            GUI.out("You already have that.");
            return false;
        }
    }
    // ========================================================================
    /**
     * Removes combined items from this inventory and adds the object formed to this.
     * @param itemList A list of combinable items to be removed.
     * @param gift The item which the combinable items combined into.
     * @return Notifies the player what he or she received.
     */
    public String combine(Item[] itemList, Item gift) {
        for (Item i : itemList)
            this.remove(i); 
        
        this.add(gift);
        AudioPlayer.playEffect(29);
        
        return "You created: " + gift + ".";
    }
    // ========================================================================
    public Item get(String itemName) {
        // Shouldn't return null item, inventory is pre-checked for item.
        for (Item i : this.contents())
            if (i.toString().matches(".*(?i:"+ itemName + ").*"))
                return i;
        
        System.err.println("Error: returned null item at PlayerInventory.get(String itemName)");
        return NULL_ITEM;
    }
    // ========================================================================
    public static Comparator<Item> getComparator() {
        return new Inventory_Sorter();
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private static class Inventory_Sorter<Item extends Comparable<Item>> 
            implements Comparator<Item> 
    {
        @Override public int compare(Item item1, Item item2) {
            return item1.compareTo(item2);
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}
