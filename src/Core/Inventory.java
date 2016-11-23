package Core;

import Super.Item;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
/**
 * @author Kevin Rapa
 */
public class Inventory implements Iterable<Item>, Serializable {
    protected final ArrayList<Item> CONT; // This inventory's contents.
    // CONSTRUCTOR ============================================================   
    public Inventory (Item ... items) {
        this.CONT = new ArrayList();
        this.CONT.addAll(Arrays.asList(items));
    }
    // ========================================================================
    /**
     * Adds an item to the inventory.
     * @param item An item to add to this inventory's contents.
     * @return If the add was successful. Some inventories have restrictions.
     */
    public boolean add(Item item) {
        this.CONT.add(item);
        
        return true;
    }
    // ========================================================================
    /**
     * Removes an item from this inventory's contents.
     * @param removeThis An item to remove from this inventory's contents.
     */
    public void remove(Item removeThis) {      
        this.CONT.remove(removeThis);
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
        // Returns a list of items in the inventory.
        String rep = "";
        int position = 1;
        
        if (! this.CONT.isEmpty()) {
            for (Item i : this.CONT) {
                String capital = Character.toUpperCase(i.toString().charAt(0)) 
                               + i.toString().substring(1);
                rep += ("-" + position + "- " + capital + "\n");

                position++;
            }
        }
        return rep;
    }
    // ========================================================================
    /**
     * @return This inventory's contents as an array list.
     */
    public ArrayList<Item> getInv() {
        return this.CONT;
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
        
        return "You created a " + gift + ".";
    }
    // ========================================================================
    /**
     * Checks if the inventory is full.
     * @return If this inventory's capacity has been reached.
     */
    public boolean atCapactity() {
        return this.CONT.size() > 19;
    }
    // ========================================================================
    /**
     * Returns an iterator to iterate over this.CONTS
     * @return an iterator to iterate over this.CONTS
     */
    @Override public Iterator iterator() {
        return this.CONT.iterator();
    }
    // ========================================================================
}
