package A_Super;

import static A_Main.Patterns.*;
import A_Main.Inventory;
import static A_Main.NameConstants.READABLE;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.regex.Pattern;
/**
 * In this game, the better term for furniture is "room object" because other
 * objects such as floors, walls, doors, buttons, etc. are treated as furniture.
 * <p>
 * Furniture is ANY object that can be interacted with from the main prompt.
 * Furniture may also be interacted with in the Inventory USE sub-prompt
 * </p> <p>
 * Furniture have inventories just like the player. Items may be traded between
 * searchable furniture and the player during a search.
 * </p> <p>
 * Furniture is referenced by the player by entering a string matching a string
 * in <code>NAMEKEYS</code>, which is generally a regex pattern.
 * </p> <p>
 * Any method in furniture that sends text through <code>GUI.out</code> or
 * <code>GUI.roomOut</code> can safely return <code>null</code> and no text,
 * including empty strings, will be displayed.
 * </p>
 * 
 * @see A_Main.Player#searchPrompt(A_Super.Furniture) 
 * @see A_Main.Player#usePrompt() 
 * @author Kevin Rapa
 */
abstract public class Furniture implements Serializable {
    protected static final String NOTHING = "";
    protected Inventory inv;
    protected String description,   // Printed when inspected.
                     searchDialog,  // Printed when searched.
                     actDialog,     // Printed when interacted with.  
                     useDialog;     // Printed when an item is used on this.
    protected boolean searchable;   // Items can be traded with searchable furniture.  
    protected final ArrayList<Pattern> USEKEYS, ACTKEYS, NAMEKEYS; 

    protected static final String 
            HOLDPATTERN = "grab|hold|touch",
            CLIMBPATTERN = "climb|scale|ascend|descend",
            GETPATTERN = "get|take|acquire|grab|scoop",      
            SITPATTERN = "sit|relax|lay|use|sleep",
            JOSTLEPATTERN = "kick|hit|jostle|nudge|bump|knock|bang",
            VALVEPATTERN = "turn|rotate|spin|twist|open|close",
            MOVEPATTERN = "move|slide|displace|push|pull|spin|rotate",
            FEELPATTERN = "feel|touch|poke",
            DEFAULT_USE = "What good would that do?",
            ANYTHING = ".+";
    // ========================================================================
    /**
     * Constructor for furniture.
     * Many attributes are overwritten in furniture sub-classes.
     */
    public Furniture () {
        this.searchable = false;
        this.NAMEKEYS = new ArrayList<>(5); // Valid names of this. Regular expression.
        this.USEKEYS = new ArrayList<>(5);  // Valid items that may be used on this.
        this.ACTKEYS = new ArrayList<>(6);  // Valid actions that may be performed on this.
        
        this.useDialog = DEFAULT_USE;
        this.searchDialog = "There's nothing hiding here.";
    }
    // ========================================================================     
    /**
     * Used to check if this piece contains a certain item.
     * Removes titles from books.
     * @param name The name of an item.
     * @return If this piece contains an item with the name.
     */
    public boolean containsItem(String name) {
        for (Item i : this.inv) {
            String j = i.toString();
            
            if (i.getType().equals(READABLE))
                j = BOOK_TITLE_P.matcher(j).replaceAll(NOTHING);
            
            if (j.equals(name)) {
                return true; }
        }
        return false;
    }
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************   
    public String getDescription() {
        return this.description; 
    }
    // ========================================================================  
    public String getSearchDialog() {
        return this.searchDialog; 
    }
    // ========================================================================  
    /**
     * This method is used whenever furniture is searched.
     * @return If items can be traded with this.
     */
    public boolean isSearchable() {
        return this.searchable;
    }
    // ========================================================================     
    public Inventory getInv() {
        return this.inv;
    }
    // ========================================================================     
    @Override public String toString() {
        return this.NAMEKEYS.get(0).toString();
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
     * @param key The name of an action.
     * @return A string that prints when this piece is interacted with.
     */
    public String interact(String key) {              
        return this.actDialog;
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
    public boolean actKeyMatches(String verb) {
        return this.ACTKEYS.stream()
                .anyMatch(i -> i.matcher(verb).matches());
    }    
    // ========================================================================     
    public boolean useKeyMatches(String itemName) {
        return this.USEKEYS.stream()
                .anyMatch(i -> i.matcher(itemName).matches());
    }
    // ========================================================================     
    public boolean nameKeyMatches(String furnitureName) {
        return this.NAMEKEYS.stream()
                .anyMatch(i -> i.matcher(furnitureName).matches());
    }
    // ======================================================================== 
    /**
     * Adds a list of use keys to this furniture.
     * @param keys A list of use keys.
     */
    public final void addUseKeys(String ... keys) {
        for (String key : keys)
            this.USEKEYS.add(Pattern.compile(key));
    }
    // ========================================================================     
    /**
     * Adds a list of name keys to this furniture.
     * @param keys A list of name keys.
     */
    public final void addNameKeys(String ... keys) {
        for (String key : keys)
            this.NAMEKEYS.add(Pattern.compile(key));
    }
    // ========================================================================     
    /**
     * Adds a list of action keys to this furniture.
     * @param keys A list of action keys.
     */
    public final void addActKeys(String ... keys) {
        for (String key : keys)
            this.ACTKEYS.add(Pattern.compile(key));
    }
//******************************************************************************        
// </editor-fold>
//******************************************************************************
}
