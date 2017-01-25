package A_Main;

import A_Super.Item;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
/**
 * Maintains a list of items.
 * Both the player (keys) and furniture have these.
 * 
 * @see A_Main.Player
 * @see A_Super.Furniture
 * @author Kevin Rapa
 */
public class Inventory implements Iterable<Item>, Serializable {
    protected final ArrayList<Item> CONTENTS; // This inventory's contents.
    // CONSTRUCTOR ============================================================   
    public Inventory (Item ... items) {
        this.CONTENTS = new ArrayList<>();
        this.CONTENTS.addAll(Arrays.asList(items));
    }
    // ========================================================================
    public Item get(int index) {
        return CONTENTS.get(index);
    }
    // ========================================================================
    public boolean contains(Item item) {
        return CONTENTS.contains(item);
    }
    // ========================================================================
    public int size() {
        return CONTENTS.size();
    }
    // ========================================================================
    public void clear() {
        this.CONTENTS.clear();
    }
    // ========================================================================
    public ArrayList<Item> contents() {
        return this.CONTENTS;
    }
    // ========================================================================
    /**
     * Adds an item to the inventory.
     * @param item An item to add to this inventory's contents.
     * @return If the add was successful. 
     */
    public boolean add(Item item) {
        this.CONTENTS.add(item);
        
        return true; // Some inventories have restrictions.
    }
    // ========================================================================
    public void remove(Item removeThis) {      
        this.CONTENTS.remove(removeThis);
    }
    // ========================================================================
    /**
     * Removes all items from this inventory of the given type.
     * @param type The type of item to remove.
     */
    public void remove(String type) { 
        this.CONTENTS.removeIf(item -> item.getType().matches(type));
    }
    // ========================================================================
    /**
     * Removes an item from this inventory and gives to another.
     * @param item The item to give.
     * @param giveToThis The inventory to add the item to.
     */
    public void give(Item item, Inventory giveToThis) {
        // Exchanges an item between two inventories.
        if (giveToThis.add(item)) {
            this.remove(item);
        }
    }
    // ========================================================================
    /**
     * Displays a formatted string representation of this for the player.
     * The items in this are accompanied with a number which the player uses
     * to reference items in the inventory.
     * @return A string representation of this inventory's contents.
     */
    @Override public String toString() {
        String rep = "";
        int position = 1;
        
        if (! this.CONTENTS.isEmpty()) {
            for (Item i : this.CONTENTS) {
                String capital = Character.toUpperCase(i.toString().charAt(0)) 
                               + i.toString().substring(1);
                rep += ("<" + position + "> " + capital + "\n");

                position++;
            }
        }
        return rep.matches("") ? "   nothing." : rep;
    }
    // ========================================================================
    @Override public Iterator<Item> iterator() {
        return this.CONTENTS.iterator();
    }
    // ========================================================================
}
