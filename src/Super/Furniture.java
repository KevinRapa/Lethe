package Super;

import Core.Inventory;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
/*
 * In this game, the better term for furniture is "room object" because other
 * objects such as floors, walls, doors, buttons, etc. are treated as furniture.
 * Furniture is ANY object that can be interacted with from the main prompt.
 */
public class Furniture implements Serializable {
    protected final String NAME; // The item's type. GENERIC (e.g. table, chair)
    protected Inventory inv; // The contents of the furniture.
    protected String description, // String printed when inspected.
                     searchDialog, // String printed when searched.
                     interactDialog, // String printed when interacted with.  
                     useDialog; // String printed when an item is used on this.
    protected boolean searchable; // Items can be added or taken from searchable furniture.  
    protected final ArrayList<String> USEKEYS, // List of items that will be used on this.
                                      ACTKEYS, // Lists of actions player may type to interact with this.
                                      NAMEKEYS; // List of names the player may type to interact with this.
    // ========================================================================
    /**
     * Constructor for furniture.
     * Many attributes are overwritten in furniture sub-classes.
     * @param NAME The name of this piece.
     * @param items A list of items that this furniture contains.
     */
    public Furniture (String NAME, Item ... items) {
        this.NAME = NAME;
        this.inv = new Inventory(items);
        this.searchable = true;
        this.NAMEKEYS = new ArrayList<>(); // Valid names of this furniture.
        this.USEKEYS = new ArrayList<>(); // Valid items that may be used on this furniture.
        this.ACTKEYS = new ArrayList<>(); // Valid actions that may be performed on this furniture.
        
        this.searchDialog = "There's nothing here.";
        this.useDialog = "Default";
    }
    // ========================================================================     
    /**
     * Used to check if this piece contains a certain item.
     * Invoked in a variety of instances, often when the items this piece
     * contains affects the description of this piece.
     * @param name The name of an item.
     * @return If this piece contains the item.
     */
    public boolean doesThisHaveIt(String name) {
        for (Item i : this.inv) {            
            String j = i.toString().replaceAll(", .*", "");
            if (j.matches(name)) {
                return true; }
        }
        return false;
    }
//******************************************************************************
// <editor-fold desc="GETTERS">
//****************************************************************************** 
    /**
     * @return The name of this piece.
     */
    @Override public String toString() {
        return this.NAME; 
    }
    // ========================================================================     
    /**
     * This method is called when furniture is inspected.
     * @return The description of this piece.
     */
    public String getDescription() {
        return this.description; 
    }
    // ========================================================================     
    /**
     * This method is used whenever furniture is searched.
     * The player may attempt a search on any furniture, but items cannot be
     * stored or taken from non-searchable furniture.
     * @return If this piece can be searched.
     */
    public boolean isSearchable() {
        return this.searchable;
    }
    // ========================================================================     
    /**
     * This method is used whenever furniture is searched.
     * @return A string that prints the event when this piece is searched.
     */
    public String getSearchDialog() {
        return this.searchDialog; 
    }
    // ========================================================================  
    /**
     * @return This piece's inventory.
     */
    public Inventory getInv() {
        return this.inv;
    }
    // ========================================================================     
    /**
     * This method returns all the names the player may use to interact with this.
     * @return The list of names the player may use to interact with this.
     */
    public ArrayList<String> getValidNames() {
        return this.NAMEKEYS;
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************

    
//******************************************************************************
// <editor-fold desc="ACTIVATING AND INTERACTING">
//****************************************************************************** 
    /**
     * Invoked when the player interacts with this piece using a correct action.
     * The map reference may be used in overwritten version of this method.
     * @param map A reference to the game map.
     * @param key The name of an action.
     * @return A string that prints when this piece is interacted with.
     */
    public String interact(Room[][][] map, String key) {              
        return this.interactDialog;
    }
    // ========================================================================     
    /**
     * This method is invoked when an item is used on this piece.
     * @param item The object reference to the item used on this.
     * @return String that prints when the item is used on this.
     */
    public String useEvent(Item item) {
        return this.useDialog;
    }
    // ========================================================================     
    /**
     * Determines if an action the player types will activate the <code>interact()</code> method.
     * @param key The name of an action.
     * @return If the action will trigger an event with this piece.
     */
    public boolean keyMatches(String key) {
        for (String i : this.ACTKEYS) {
            if (key.matches(i))
                return true;
        }
        return false;
    }    
    // ========================================================================     
    public boolean isUsedBy(String name) {
        for(String i : this.USEKEYS) {
            if (name.matches(i))
                return true;
        }
        return false;
    }
    // ========================================================================     
    /**
     * Adds a list of use keys to this furniture.
     * Invoked in the constructors of subclasses.
     * @param keys A list of use keys.
     */
    public final void addUseKeys(String ... keys) {
        this.USEKEYS.addAll(Arrays.asList(keys));
    }
    // ========================================================================     
    /**
     * Adds a list of name keys to this furniture.
     * Invoked in the constructors of subclasses.
     * @param keys A list of name keys.
     */
    public final void addNameKeys(String ... keys) {
        this.NAMEKEYS.addAll(Arrays.asList(keys));
    }
    // ========================================================================     
    /**
     * Adds a list of action keys to this furniture.
     * Invoked in the constructors of subclasses.
     * @param keys A list of action keys.
     */
    public final void addActKeys(String ... keys) {
        this.ACTKEYS.addAll(Arrays.asList(keys));
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************
}
