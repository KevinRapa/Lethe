package A_Super;
        
import static A_Main.NameConstants.ITEM;
import java.io.Serializable;
/**
 * Represents an object that can be stored in an inventory.
 * 
 * Items are generally simple objects instantiated directly in the main class.
 * Many items are significant in that they are tied with certain furniture that
 * are used by the item defined in <code>USEKEYS</code>. 
 * 
 * Items may be combinable, in that they have a non-zero <code>THRESHOLD</code>,
 * <code>FORMS</code> and <code>PRODUCT</code>. Items with these matching values
 * are a <strong>set</strong> and thus may be combined to form a new item.
 * 
 * @see A_Super.Furniture#USEKEYS
 * @author Kevin Rapa
 */
public class Item implements Serializable, Comparable<Item> {
    protected final String NAME;    // The item's name.
    protected final Item FORMS;     // Item given to player after a combine.
    protected final int THRESHOLD;  // Number of items in the combine set;
    protected String type = ITEM;   // Useful to certain inventories.    
    protected String description;   // Displayed when item is inspected.
    protected String useDialog;     // Displayed when items with Id 1 are used.
    protected int useID;            // 1: used on itself | 2: enters sub-prompt
    protected final int SCORE;      // However many points this is worth.
    protected static final String USE_DEFAULT = "You will need to be more specific.";
//******************************************************************************
// <editor-fold desc="CONSTRUCTORS">
// In order to avoid creating an excessive number of classes, and due to the
// simplicity of items, multiple constructers for items are defined.
//******************************************************************************             
    public Item(String name, int score) {
        NAME = name;
        FORMS = null;   
        useID = 2;
        this.SCORE = score;
        THRESHOLD = 0; // Does not combine
        useDialog = USE_DEFAULT;
    }   
    // ========================================================================       
    public Item(String name, String desc, int score) {
        this(name, score);
        description = desc;
    }
    // ========================================================================
    public Item(String name, String desc, String use, int score) {
        this(name, desc, score);
        useDialog = use;
        useID = 1;
    }    
    // ========================================================================
    public Item(String name, Item forms, int thresh, int score) {
        useDialog = USE_DEFAULT;
        useID = 2;
        this.SCORE = score;
        NAME = name; 
        FORMS = forms;  
        THRESHOLD = thresh;
    }
    // ========================================================================
    public Item(String name, String desc, Item forms, int thresh, int score) {
        this(name, forms, thresh, score);
        description = desc;
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************    
    @Override public String toString() {               
        return this.NAME; 
    }        
/*----------------------------------------------------------------------------*/        
    /**
     * Returns what type of item this is.
     * Items can have difference types that determine how they are used.
     * For example, phylacteries cannot be put down.
     * Keys have types corresponding to the ID of the room they unlock.
     * @return This item's type.
     */
    public String getType() {
        return this.type; 
    }    
/*----------------------------------------------------------------------------*/
    public String getDesc() {
        return this.description; 
    }    
/*----------------------------------------------------------------------------*/
    public Item forms() {
        return this.FORMS; 
    }
/*----------------------------------------------------------------------------*/
    public int getUseID() {
        return this.useID; 
    }      
/*----------------------------------------------------------------------------*/
    public int getThreshold() {
        return this.THRESHOLD; 
    }
/*----------------------------------------------------------------------------*/
    public int getScore() {
        return this.SCORE;
    }
/*----------------------------------------------------------------------------*/
    /**
     * This method is called when an item with useID 1 is used by the player.
     * @return A string that prints when this item is used.
     */
    public String useEvent() {
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public int compareTo(Item item) {
        return this.toString().compareTo(item.toString());
    } 
//******************************************************************************        
// </editor-fold>
//******************************************************************************

    
    
}
