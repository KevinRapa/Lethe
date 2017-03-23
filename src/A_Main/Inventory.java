package A_Main;

import static A_Main.Names.NO_LETTER_AFTER;
import static A_Main.Names.NO_LETTER_BEFORE;
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
    public static final Item NULL_ITEM = // Represents an item wasn't found.
            new Item("null item", "Hello, I'm a null item.", 0);
    // CONSTRUCTOR ============================================================   
    public Inventory(Item ... items) {
        this.CONTENTS = new ArrayList<>(Arrays.asList(items));
    }
    // ========================================================================
    public Item get(int index) {
        return CONTENTS.get(index);
    }
    // ========================================================================
    // Tries to find an item with the name. Returns a null item for a failure.
    public Item get(String itemName) {
        if (Patterns.ANY_DIGIT_P.matcher(itemName).matches()) {
            int i = Integer.parseInt(itemName); // Player used a slot number.
            if (i <= this.size() && i > 0)
                return this.CONTENTS.get(i - 1);
        }
        else {
            for (Item i : this.contents()) // First checks for an exact match.
                if (i.toString().equals(itemName))
                    return i;
            
            for (Item i : this.contents()) // Checks for a close match.
                if (i.toString().matches(NO_LETTER_BEFORE + itemName + NO_LETTER_AFTER))
                    return i;
        }
        System.err.println("Warning: NULL_ITEM returned at <inventory>.get()");
        return NULL_ITEM; // Item wasn't found. Always check for this!!
    }
    // ========================================================================
    public boolean contains(Item item) {
        return CONTENTS.contains(item);
    }
    // ========================================================================
    public boolean isEmpty() {
        return CONTENTS.isEmpty();
    }
    // ========================================================================
    // Checks if this inv contains an item who's name matches argument.
    public boolean containsItemResembling(String item) {
        if (Patterns.ANY_DIGIT_P.matcher(item).matches()) {
            // Player used a slot number
            int i = Integer.parseInt(item);
            return (i <= CONTENTS.size());
        }
        else // Player typed in an item name
            return CONTENTS
                    .stream()
                    .anyMatch(i -> i.toString()
                    .matches(NO_LETTER_BEFORE + item + NO_LETTER_AFTER));
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
     * Removes an item from this inventory and gives it to another.
     * @param item The item to give.
     * @param giveToThis The inventory to add the item to.
     * @return It the add was successful
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
