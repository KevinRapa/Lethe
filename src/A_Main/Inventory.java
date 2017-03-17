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
    public Inventory(Item ... items) {
        this.CONTENTS = new ArrayList<>(Arrays.asList(items));
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
    public boolean give(Item item, Inventory giveToThis) {
        if (giveToThis.add(item)) {
            this.remove(item);
            return true;
        }
        return false;
    }
    // ========================================================================
    /**
     * Displays a formatted string representation of this for the player.
     * The items in this are accompanied with a number which the player uses
     * to reference items in the inventory.
     * @return A string representation of this inventory's contents.
     */
    @Override public String toString() {
        if (! this.CONTENTS.isEmpty()) {
            StringBuilder builder = new StringBuilder(30);
            int slot = 1;
            
            for (Item i : this.CONTENTS) {
                String name = i.toString();
                String capitalized = name
                        .substring(0,1)
                        .toUpperCase()
                        .concat(name.substring(1));
                
                builder.append('<')
                       .append(slot++)
                       .append('>')
                       .append(' ')
                       .append(capitalized)
                       .append('\n');
            }
            return builder.toString();
        }
        else
            return "   nothing.";
    }
    // ========================================================================
    @Override public Iterator<Item> iterator() {
        return this.CONTENTS.iterator();
    }
    // ========================================================================
}
