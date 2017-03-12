package A_Main;

import A_Super.Item;
import java.util.Comparator;
/**
 * Adds combine methods and sorting abilities which aren't used by furniture.
 * The PlayerInventory may not contain duplicates.
 * Adds get(String itemName) method for use by the TextParser.
 * 
 * @author Kevin Rapa
 */
public class PlayerInventory extends Inventory {
    private final Item NULL_ITEM = 
            new Item("null item", "Whoops! Looks like there's a bug in the game, "
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
        
        this.CONTENTS.add(gift);
        AudioPlayer.playEffect(29);
        
        return "You created: " + gift + ".";
    }
    // ========================================================================
    public Item get(String itemName) {
        // Shouldn't return null item, inventory is pre-checked for item.
        if (Patterns.NUMBER_P.matcher(itemName).matches()) {
            int i = Integer.parseInt(itemName); // Player used a slot number
            if (i <= this.size())
                return this.CONTENTS.get(i - 1);
        }
        else {
            for (Item i : this.contents())
                if (i.toString().matches(".*\\b(?i:"+ itemName + ")\\b.*"))
                    return i;
        }
        
        System.err.println("Error: returned null item at PlayerInventory.get(String itemName)");
        return NULL_ITEM;
    }
    // ========================================================================
    public void sortInventory() {
        this.CONTENTS.sort(Inventory_Sorter.getSorter());
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private static class Inventory_Sorter<Item extends Comparable<Item>> 
            implements Comparator<Item> 
    {
        private static final Inventory_Sorter SORTER = new Inventory_Sorter();
        // --------------------------------------------------------------------
        private Inventory_Sorter() {/* Singleton class. */}
        // --------------------------------------------------------------------
        public static Inventory_Sorter getSorter() {
            return SORTER;
        }
        // --------------------------------------------------------------------
        @Override public int compare(Item item1, Item item2) {
            return item1.compareTo(item2);
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}
