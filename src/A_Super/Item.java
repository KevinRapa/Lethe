package A_Super;
        
import java.io.Serializable;

public class Item implements Serializable {
    protected final String NAME;// The item's name. Used to interact with item. 
    protected final String FORMS; // What certain items form when combined.
    protected final Item PRODUCT; // Item object given to player after successful combine.
    protected final int THRESHOLD; // Number of other items that combine with this one + 1;
    protected String type = "item";// Item type, used in the take() player method.    
    protected String description; // Item description. Used when item is inspected.
    protected String useDialog; // Prints when item with ID 1 is used.
    protected int useID = 2; // 1 - used on itself | 2 - enters a sub-prompt
//******************************************************************************
// <editor-fold desc="CONSTRUCTORS">
//******************************************************************************         
    // ========================================================================    
    /**
     * Default constructor.
     * For non-combinable items with their own class. Their descriptions
     * are too long to fit in the parameter list, or they are more complex.
     * @param name The name of this item.
     */
    public Item(String name) {
        this.NAME = name;
        this.FORMS = "nothing"; // Combinable items have a different string.
        this.PRODUCT = null;
        this.THRESHOLD = 0;
    }   
    // ========================================================================       
    /**
     * Constructor for items with short descriptions.
     * @param name The name of this item.
     * @param desc A short description of the item.
     */
    public Item(String name, String desc) {
        this.NAME = name;
        this.FORMS = "nothing";
        this.PRODUCT = null;
        this.THRESHOLD = 0;
        this.description = desc;
    }
    // ========================================================================
    /**
     * Constructor for decorative items with no purpose.
     * @param name The name of this item.
     * @param desc A short description of the item.
     * @param use A short string that prints when this item is used.
     */
    public Item(String name, String desc, String use) {
        this.NAME = name;
        this.FORMS = "nothing";
        this.PRODUCT = null;
        this.THRESHOLD = 0;
        this.description = desc;
        this.useDialog = use;
        this.useID = 1;
    }    
    // ========================================================================
    /**
     * Constructor for combinable items with long descriptions.
     * Combinable items belong in a set, where each item in the set
     * has the same forms, formsStr, and threshold attributes.
     * @param name The name of this item.
     * @param forms The object reference to the item this combines into.
     * @param formsStr The name of the item this combines into.
     * @param threshold The number of items in this one's set.
     */
    public Item(String name, Item forms, String formsStr, int threshold) {
        this.NAME = name;
        this.PRODUCT = forms;
        this.THRESHOLD = threshold;
        this.FORMS = formsStr;
    }
    // ========================================================================
    /**
     * Constructor for combinable items with short descriptions.
     * Combinable items belong in a set, where each item in the set
     * has the same forms, formsStr, and threshold attributes.
     * @param name The name of this item.
     * @param desc A short description of this item.
     * @param forms The object reference to the item this combines into.
     * @param formsStr The name of the item this combines into.
     * @param threshold The number of items in this one's set.
     */
    public Item(String name, String desc, Item forms, String formsStr, int threshold) {
        this.NAME = name;
        this.PRODUCT = forms;
        this.THRESHOLD = threshold;
        this.FORMS = formsStr;
        this.description = desc;
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************    
    /**
     * @return The name of this item.
     */
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
    /**
     * @return The name of the item this combines into.
     */
    public String getForms() {
        return this.FORMS; 
    }      
/*----------------------------------------------------------------------------*/
    /**
     * @return The object reference to the item this combines into.
     */
    public Item getProduct() {
        return this.PRODUCT; 
    }
/*----------------------------------------------------------------------------*/
    public int getUseID() {
        return this.useID; 
    }      
/*----------------------------------------------------------------------------*/
    /**
     * @return The number of items in this one's combine set.
     */
    public int getThreshold() {
        return this.THRESHOLD; 
    }
/*----------------------------------------------------------------------------*/
    /**
     * This method is called when an item with useID 1 is used by the player.
     * @return A string that prints when this item is used.
     */
    public String useEvent() {
        return this.useDialog; // Only used by items with useID 1.
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************
}
