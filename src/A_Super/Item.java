package A_Super;
        
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
public class Item implements Serializable {
    protected final String NAME;    // The item's name.
    protected final String FORMS;   // Name of item formed when combined.
    protected final Item PRODUCT;   // Item given to player after a combine.
    protected final int THRESHOLD;  // Number of items in the combine set;
    protected String type = "item"; // Useful to certain Inventories.    
    protected String description;   // Displayed when item is inspected.
    protected String useDialog;     // Displayed when items with Id 1 are used.
    protected int useID = 2;        // 1: used on itself | 2: enters sub-prompt  
//******************************************************************************
// <editor-fold desc="CONSTRUCTORS">
// In order to avoid creating an excessive number of classes, and due to the
// simplicity of items, multiple constructers for items are defined.
//******************************************************************************             
    /**
     * Default constructor.
     * For non-combinable items with their own class. Their descriptions
     * are too long to fit in the parameter list, or they are more complex.
     * @param name The name of this item.
     */
    public Item(String name) {
        NAME = name;
        FORMS = null;    PRODUCT = null;    THRESHOLD = 0; // Does not combine
    }   
    // ========================================================================       
    /**
     * Constructor for items with short descriptions.
     * @param name The name of this item.
     * @param desc A short description of the item.
     */
    public Item(String name, String desc) {
        NAME = name;
        description = desc;
        FORMS = null;    PRODUCT = null;    THRESHOLD = 0; // Does not combine
    }
    // ========================================================================
    /**
     * Constructor for decorative items with no purpose and do not enter a 
     * sub-prompt when used.
     * @param name The name of this item.
     * @param desc A short description of the item.
     * @param use A short string that prints when this item is used.
     */
    public Item(String name, String desc, String use) {
        NAME = name;
        description = desc;
        useDialog = use;
        useID = 1;
        FORMS = null;    PRODUCT = null;    THRESHOLD = 0; // Does not combine
    }    
    // ========================================================================
    /**
     * Constructor for combinable items with long descriptions.
     * Combinable items belong in a set, where each item in the set
     * has the same forms, formsStr, and thresh attributes.
     * @param name The name of this item.
     * @param forms The object reference to the item this combines into.
     * @param thresh The number of items in this one's set.
     */
    public Item(String name, Item forms, int thresh) {
        NAME = name;
        PRODUCT = forms;  THRESHOLD = thresh;  FORMS = forms.toString();
    }
    // ========================================================================
    /**
     * Constructor for combinable items with short descriptions.
     * Combinable items belong in a set, where each item in the set
     * has the same forms, formsStr, and threshold attributes.
     * @param name The name of this item.
     * @param desc A short description of this item.
     * @param forms The object reference to the item this combines into.
     * @param threshold The number of items in this one's set.
     */
    public Item(String name, String desc, Item forms, int threshold) {
        NAME = name;
        description = desc;
        PRODUCT = forms;    THRESHOLD = threshold;    FORMS = forms.toString();
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
    public String getForms() {
        return this.FORMS; 
    }      
/*----------------------------------------------------------------------------*/
    public Item getProduct() {
        return this.PRODUCT; 
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
    /**
     * This method is called when an item with useID 1 is used by the player.
     * @return A string that prints when this item is used.
     */
    public String useEvent() {
        return this.useDialog;
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************
}
