package A_Main;

import A_Super.Room;
import A_Super.Item;
import A_Super.Container;
import A_Super.Furniture;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author Kevin Rapa
 */
public class Player {
    private static Room[][][] mapRef;
    private static int[] occ; // Room object you are in.
    private static Inventory inv, keys; // Your inventory and keyring.
    private static ArrayList<String> visited; // List of rooms you have visited.
    private static String lastVisited; // The last room you visited.
    private static String shoes; // Some puzzles are solved by wearing certain shoes.
    
    // Main game controls
    private final static HashMap<Character, Runnable> CMD = new HashMap(); static {{
        CMD.put('h', () -> Help.helpSub());
        CMD.put('e', () -> searchSub());
        CMD.put('c', () -> checkOutSub());
        CMD.put('x', () -> activateSub());
        CMD.put('k', () -> viewKeyRing());
        CMD.put('i', () -> viewInventory());
    }}

//******************************************************************************
// <editor-fold desc="GETTERS AND SETTERS">  
//******************************************************************************
    public static void setOccupies(int ... coordinates) {
        Player.occ = coordinates;
        
        if (! Player.hasVisited(getOcc().getID())) 
            Player.visited.add(getOcc().getID()); 
    }
    /*------------------------------------------------------------------------*/
    /**
     * Converts a string of a piece of furniture to its object equivalent.
     * @param name The name of a piece of furniture in your location.
     * @return The furniture objects with the name.
     */
    public static Furniture getFurnRef(String name) {
        for(Furniture i : getOcc().getFurnishings()) {
            if (i.getValidNames().stream().anyMatch(j -> name.matches(j)))
                return i;           
        }
        return null;
    }
    /*------------------------------------------------------------------------*/   
    /**
     * This method is used for certain triggered events.
     * @return The ID of the last room you were in.
     */
    public static String getLastVisited() {
        return Player.lastVisited;
    }
    /*------------------------------------------------------------------------*/ 
    /**
     * @return The player's inventory.
     */
    public static Inventory getInv() {
        return Player.inv;
    }
    /*------------------------------------------------------------------------*/
    /**
     * @return The player's key ring.
     */
    public static Inventory getKeys() {
        return Player.keys;
    }
    /*------------------------------------------------------------------------*/
    public static Room getOcc() {
        return Player.mapRef[occ[0]][occ[1]][occ[2]];
    }
    /*------------------------------------------------------------------------*/
    public static Room[][][] getMapRef() {
        return mapRef;
    }
    /*------------------------------------------------------------------------*/
    public static ArrayList<String> getVisitedRooms() {
        return visited;
    }
    /*------------------------------------------------------------------------*/
    public static String getShoes() {
        return Player.shoes;
    }
    /*------------------------------------------------------------------------*/
    public static void setShoes(String shoes) {
        Player.shoes = shoes;
    }
    /*------------------------------------------------------------------------*/
    /**
     * Sets saved game attributes
     * @param inv The player's inventory.
     * @param keys The player's key ring.
     * @param visited List of rooms the player visited.
     * @param lastVisited Last room the player visited.
     * @param shoesWearing Type of shoes the player is wearing.
     * @param occ Coordinates of the player's location.
     * @param map Reference to the game map.
     */
    public static void loadAttributes(Inventory inv, Inventory keys, ArrayList<String> visited, 
                                      String lastVisited, String shoesWearing, int[] occ, Room[][][] map) {
        Player.mapRef = map;
        Player.inv = inv;
        Player.keys = keys;
        Player.occ = occ;
        Player.visited = visited;
        Player.lastVisited = lastVisited;
        Player.shoes = shoesWearing;
    }
    /*------------------------------------------------------------------------*/
    /**
     * Creates new attributes that the player starts a new game with.
     * @param coords Coordinates the player begins the game at.
     */
    public static void setNewAttributes(int ... coords) {
        Player.mapRef = Salamaa.createMap();
        Player.inv = new Inventory();
        Player.keys = new Inventory();
        Player.visited = new ArrayList() {{ add("COU4"); }};
        Player.occ = coords;
        Player.lastVisited = "";
        Player.shoes = "";
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************


//******************************************************************************
// <editor-fold desc="START GAME"> 
//******************************************************************************
    /**
     * This dialog prints at the start of a new game.
     * @return Integer representing player choice to save, erase data, or just quit.
     */
    public static int startDialog() {
        AudioPlayer.playTrack(Player.getOcc().getID());
        
        GUI.menOut("\n\nPress enter...");
        GUI.out("It's 10:00pm, the night is clear and warm.\n" +
                "You have just arrived on foot to your destination, and\n" +
                "its even more colossal than what you had\n" +
                "expected. It also appears curiously more vacant...");
        
        GUI.promptOut();
                
        GUI.out("You slowly approach until between the front gateway.\n" +
                "A thought briefly flashes in your mind before being\n" +
                "forgotten - what was your business here, again?...");
        
        GUI.promptOut();
        GUI.clearDialog();
        
        return mainPrompt();
    }
    // ========================================================================   
    /**
     * The main prompt for controlling the player's moves.
     * @return Integer representing player choice to save, erase data, or just quit.
     */
    public static int mainPrompt() {
        AudioPlayer.playTrack(getOcc().getID());
        GUI.invOut("You are carrying:\n" + Player.inv);
        String ans;
        
        GUI.roomOut(getOcc().triggeredEvent());
        describeRoom();
        GUI.clearMenu();
        
        do {
            ans = GUI.promptOut();

            if (ans.matches("[wsad]")) // For movement
                move(ans.charAt(0));
            
            else if (ans.matches("[hecxki]")) { // For all other actions.
                if (ans.matches("[hecx]")) 
                    AudioPlayer.playEffect(17); // Plays select noise
                
                CMD.get(ans.charAt(0)).run(); // Performs the action.
            }
        } while (! ans.matches("quit"));
        
        GUI.menOut("<'s'> Save and quit\n<'q'> Quit\n<'r'> Reset game and quit.");
        ans = GUI.promptOut();
        
        while (! ans.matches("[sqr]")) {
            GUI.menOut("Please enter 's', 'q', or 'r'.\n<'s'> Save and quit\n"
                     + "<'q'> Quit\n<'r'> Reset game and quit.");
            ans = GUI.promptOut();
        }
        return ans.matches("s") ? 1 : 
               ans.matches("q") ? 3 : 2;
    }  
//******************************************************************************        
// </editor-fold> 
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="MOVEMENT AND ROOMS">    
//******************************************************************************    
    /**
     * For some events that trigger the first time the player enters a room, etc.
     * @param roomID The ID of a particular room.
     * @return If you have visited the given room before.
     */
    public static boolean hasVisited(String roomID) {
        return Player.visited.contains(roomID);
    }
    // ========================================================================  
    /**
     * The movement algorithm for moving the player north, south, east, and west.
     * Two rooms are considered not to a have a door between them is the first
     * three characters of their ID are identical. An exception is made for 
     * caves and catacombs, which have no doors.
     * 
     * @param dir A direction itemList from the keyboard - 'w', 's', 'a', or 'd'.
     * @param map A reference for moving the player.
     */
    private static void move(char dir) {  
        int b = 0, a = 0; // Position modifiers.
        
        switch (dir) {
            case 'w': b = -1; a = 0; break;
            case 's': b = 1; a = 0; break;
            case 'd': b = 0; a = 1; break;
            case 'a': b = 0; a = -1;
        }
        
        int[] i = getOcc().getCoords();
        Room destination = mapRef[i[0]][i[1] + b][i[2] + a];
        
        if (! getOcc().isAdjacent(destination.getID()))
            GUI.out(getOcc().getBarrier(dir)); // There's a wall in the way.
              
        else if (destination.isThisLocked() && ! hasKey(destination.getID())) {
            AudioPlayer.playEffect(4);
            GUI.out("The door here is locked."); 
        }
        else {
            GUI.clearDialog();
            lastVisited = getOcc().getID();
            occ = destination.getCoords();
            GUI.roomOut(getOcc().triggeredEvent());
            
            if (getOcc().isThisLocked() && ! visited.contains(getOcc().getID()))
                AudioPlayer.playEffect(13); // Plays unlock sound.
            else if (! getOcc().getID().matches("C[AV]..") && 
                     ! getOcc().getID().substring(0,3).matches(lastVisited.substring(0,3)))
                     // Checks that you aren't in the catacombs or caves
                     // Checks that rooms have a door between them.
                AudioPlayer.playEffect(9); // Plays open door sound. 
            else
                AudioPlayer.playEffect(0); // Plays footsteps.
            
            describeRoom();
            
            if (! hasVisited(getOcc().getID())) 
                visited.add(getOcc().getID());  
        } 
    }
    // ========================================================================  
    public static void describeRoom() {
        AudioPlayer.playTrack(Player.getOcc().getID());
        GUI.descOut(Player.getOcc().getDescription());
    }
//******************************************************************************
// </editor-fold>
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="KEYS">      
//******************************************************************************    
    /**
     * Adds a key to your key ring.
     * @param key A key to add to your key ring.
     * @param furniture The furniture from which to take the key.
     */
    private static void addToKeyRing(Item key, Furniture furniture) {
        furniture.getInv().give(key, Player.keys);
    }
    // ========================================================================  
    private static void viewKeyRing() {
        AudioPlayer.playEffect(3);
        GUI.invOut("Keys:\n" + Player.keys.toString()); 
    }
    // ========================================================================  
    /**
     * Used to check if the player may enter a particular locked room.
     * @param keyID The ID of a key, corresponding to a room ID.
     * @return If you have the key.
     */
    public static boolean hasKey(String keyID) {
        for (Item key : Player.keys) {              
            if (key.getType().matches(keyID))
                return true;
        }
        return false;
    }   
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
 
    
//******************************************************************************
// <editor-fold desc="SEARCHING">   
//******************************************************************************    
    private static void searchSub() {
        // Initiates dialog asking player for a Furniture to search.
        GUI.menOut("\n\n<object> Search\n    < > Back\n");
        String searchThis = GUI.promptOut();
        
        if (! searchThis.matches("") && getOcc().hasFurniture(searchThis))
            search(getFurnRef(searchThis));  
        
        else if (! searchThis.matches(""))
                GUI.out("There is no " + searchThis + " here."); 
        
        GUI.clearMenu();
        GUI.invOut("You are carrying:\n" + Player.inv);
    }    
    // ========================================================================  
    /**
     * Subroutine entered after a searchable furniture is searched.
     * Serves to block access from trading itemList with non searchable furniture.
     * @param furniture The furniture being searched.
     */
    private static void search(Furniture furniture) {
        GUI.out(furniture.getSearchDialog());
        
        if (furniture.isSearchable()) {
            GUI.invOut("You find:\n" + furniture.getInv() + 
                          "\nYou are carrying:\n" + Player.inv);
            searchPrompt(furniture); 
        }
    } 
    // ========================================================================  
    /**
     * Subroutine for exchanging itemList between player and furniture inventories.
     * @param furniture The furniture being searched.
     */
    private static void searchPrompt(Furniture furniture) {
        String cmdItm, action; 
        int slot;
        Item item;
            
        do {
            GUI.menOut("\n<'s' #> Store...\n<'t' #> Take...\n< > Back\"");
            
            cmdItm = GUI.promptOut();
            
            try (Scanner collectToken = new Scanner(cmdItm).useDelimiter("\\s+")) {
                action = collectToken.next();            
                slot = Integer.parseInt(collectToken.next());
                
                if (action.matches("s|store")) {
                    item = Player.inv.get(slot - 1);
                    evalStore(furniture, item);                            
                }            
                else if (action.matches("t|take")) {
                    item = furniture.getInv().get(slot - 1);
                    evalTake(furniture, item);
                }
            }
            catch (java.lang.IndexOutOfBoundsException e) {
                GUI.out("There's no item in that slot.");
            }
            catch (java.util.NoSuchElementException | java.lang.NumberFormatException e) {
                if (! cmdItm.matches(""))
                    GUI.out("Type an action and the slot number."); 
            }
        } while (! cmdItm.matches(""));
    }
    // ========================================================================  
    /**
     * Evaluates the player's take action.
     * @param furniture The furniture from which to take an item.
     * @param take The item being taken.
     */
    private static void evalTake(Furniture furniture, Item take) {
        if (! (Player.inv.contains(take) || Player.inv.isFull())) {
            // Checks that you don't already have it.
            if (take.getType().matches("[A-Z]{3}[A-Z1-9]")) {
                addToKeyRing(take, furniture); // It's a key.
                AudioPlayer.playEffect(3);
                GUI.out("You put the " + take + " in your key ring.");
            }
            else {
                GUI.out("You take the " + take);
                furniture.getInv().give(take, Player.inv);                 
            }   
        }
        else if (Player.inv.isFull())
            GUI.out("You are carrying too much!");
        
        else if (Player.inv.contains(take))
            GUI.out("You already have one of those."); 
        
        GUI.invOut("You find:\n" + furniture.getInv() + 
                      "\nYou are carrying:\n" + Player.inv);
    }
    // ========================================================================  
    /**
     * Evaluates the player's store action.
     * @param furniture The furniture in which the item is being stored.
     * @param store The item being stored.
     */
    private static void evalStore(Furniture furniture, Item store) {
        if (store.getType().matches("phylactery"))
            GUI.out("The " + store + " looks too important to get rid of.");

        else {
            GUI.out("You store the " + store);
            Player.inv.give(store , furniture.getInv()); 
            
            if (store.toString().matches(shoes))
                Player.shoes = "";
        }
        
        GUI.invOut("You find:\n" + furniture.getInv() + 
                   "\nYou are carrying:\n" + Player.inv);
    }
    // ========================================================================  
    /**
     * Checks that you have a specific item.
     * @param item The item in question.
     * @return If you have the item.
     */
    public static boolean doYouHaveIt(String item) {
        return Player.inv.contents().stream().
                anyMatch(i -> i.toString().matches(item));
    }
    // ========================================================================   
    /**
     * Returns an item object reference in your inventory with the name.
     * @param itemName The item's name.
     * @return the object reference.
     */
    public static Item getItem(String itemName) {
        Item rep = null;
        
        for (Item i : Player.inv) {
            if (i.toString().matches(itemName))
                rep = i;
        }
        return rep;
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold desc="ACTIVATING AND CHECKING OUT">  
//****************************************************************************** 
    /**
     * Subroutine entered when furniture is interacted with.
     * @param map A reference to the game's map.
     */
    private static void activateSub() {
        String action, object, actObj;
               
        GUI.menOut("\n\n<action object> Interact...\n\t < > Back\n");
        
        do {
            actObj = GUI.promptOut();
            
            try (Scanner collectToken = new Scanner(actObj).useDelimiter("\\s+")) {
                action = collectToken.next();            
                object = collectToken.next(); 
                
                while (collectToken.hasNext()) // If item is 2+ words long.
                    object += (" " + collectToken.next());
                    
                evaluateAction(object, action);
                actObj = "";
            }
            catch (java.util.NoSuchElementException e) {
                if (actObj.matches(""))
                    GUI.out("Type an action and an object.");
            } 
        } while (! actObj.matches(""));
        
        GUI.clearMenu();
    }
    // ========================================================================  
    private static void checkOutSub() {
        GUI.menOut("\n\n<object> Look at...\n< > Back\n");
        
        String checkThis = GUI.promptOut();
        
        if (! checkThis.matches("")) {
            if (getOcc().hasFurniture(checkThis)) { // Checks that furniture is in the room.
                Furniture inspecting = getFurnRef(checkThis);
                GUI.out(inspecting.getDescription()); // Initiates inspection.
            }
            else
                GUI.out("There is no " + checkThis + " here.");
        }
        GUI.clearMenu();
    }
    // ======================================================================== 
    /**
     * Processes a player's action on furniture.
     * @param object the name of the furniture being acted upon.
     * @param action the action the player is performing on the furniture.
     * @param map a reference to the game map.
     */
    private static void evaluateAction(String object, String action) {
        Furniture target;
        
        if (getOcc().hasFurniture(object)) {                             
            target = getFurnRef(object);

            if (action.matches("look|view|inspect")) 
                GUI.out(target.getDescription()); 

            else if (action.matches("search") || 
                    (action.matches("open") && target instanceof Container))                    
                search(target); 

            else if (target.keyMatches(action)) {
                GUI.out(target.interact(action)); 
                describeRoom();
            }
            else
                GUI.out("That seems unnecessary.");
        }                
        else
            GUI.out("There is no " + object + " here."); 
        
        GUI.invOut("You are carrying:\n" + Player.inv);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold desc="INVENTORY ACTIONS">      
//******************************************************************************    
    private static void viewInventory() {
        // Prints objects in your inventory, if any.
        GUI.invOut("You are carrying:\n" + Player.inv);
        inventorySub(); 
        GUI.clearMenu();
    }
    // ========================================================================  
    private static void inventorySub() {
        AudioPlayer.playEffect(1);
        String ans;
        
        do {
            GUI.menOut("\n<'1'> Inspect item\n<'2'> Use item\n" + 
                          "<'3'> Combine items\n< > Back");
            
            ans = GUI.promptOut();
            
            if (ans.matches("[1-3]")) {
                AudioPlayer.playEffect(17);
                
                switch(Integer.parseInt(ans)) {
                    case 1:
                        inspectSub(); 
                        break;
                    case 2:
                        useSub(); 
                        break;
                    default:
                        combineSub();
                }
                GUI.invOut("You are carrying:\n" + Player.inv.toString());
            } 
        } while (! ans.matches(""));
    }
    // ========================================================================  
    private static void inspectSub() {
        String ans;            
        
        do {
            GUI.menOut("<#> Inspect...\n< > Back");
            ans = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(ans);
                Item item = Player.inv.get(slot - 1);
                GUI.out(item.getDesc());  
            }
            catch (java.lang.NumberFormatException | java.lang.IndexOutOfBoundsException e) {
                if (! ans.matches(""))
                    GUI.out("Type in a valid slot number.");
            }
        } while (! ans.matches(""));
        
        GUI.clearDialog();
    }
    // ========================================================================  
    private static void useSub() {
        String choice;
        
        do { 
            GUI.menOut("<#> Use...\n< > Back");
            choice = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(choice);
                Item item = Player.inv.get(slot - 1);
                int useID = item.getUseID();
                useSwitch(useID, item);
            }
            catch (java.lang.NumberFormatException | java.lang.IndexOutOfBoundsException e) {
                if (! choice.matches(""))
                    GUI.out("Type in a valid slot number.");
            }  
        } while (! choice.matches(""));
    }
    // ========================================================================  
    /**
     * Subroutine entered into when an item is used from the player's inventory.
     * @param useID Represents if the item is used on itself or something else.
     * @param item The item being used
     */
    private static void useSwitch(int useID, Item item) {
        Furniture target; 
        
        switch (useID) {
            
        case 1:
            GUI.out(item.useEvent()); break;           
        case 2:
            GUI.menOut("<object> Use on...\n< > Back");

            String ans = GUI.promptOut();

            if (getOcc().hasFurniture(ans)) {                 
                target = getFurnRef(ans);

                if (target.isUsedBy(item.toString())) {
                    GUI.out(target.useEvent(item));
                    describeRoom();
                }
                else
                    GUI.out("You jam the " + item + " into the " + ans +
                               "\nas hard as you can, but nothing happens.");
            }                      
            else if (! ans.matches(""))
                GUI.out("There is no " + ans + " here.");                    
        }
        GUI.invOut("You are carrying:\n" + Player.inv);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="INVENTORY (COMBINING)">     
//******************************************************************************    
    /**
     * Prompts the player for a list of itemList, verifies it and moves to evalCombine().
     * A list is valid if it contains exactly 2 or 3 valid item in the
     * player's inventory.
     */
    private static void combineSub() {
        String combineThese;
        Scanner tokens;
        GUI.menOut("<#,#,(#)> Combine...\n< > Back");
        
        do {
            combineThese = GUI.promptOut();
            tokens = new Scanner(combineThese).useDelimiter("\\s*,\\s*");

            Item[] list = getTokenList(tokens);
            
            if (! combineThese.matches("")) {
                if (list.length == 2 || list.length == 3)
                    evalCombine(list);
                else switch (list.length) {
                    case 0:
                        GUI.out("Enter a valid slot number."); break;
                    case 1:
                        GUI.out("You must enter 2 or 3 items."); break;
                    default:
                        GUI.out("You entered too many items.");
                }
            }
            tokens.close();  
        } while (! combineThese.matches(""));        
    }
    // ======================================================================== 
    /**
     * Receives a valid list of 2 or 3 itemList for a combine attempt and
 verifies that it is a correct combine set.
     * @param list a list of 2 or 3 itemList.
     */
    private static void evalCombine(Item[] list) {
        if (areAllCombinable(list)) {
            if (list[0].getThreshold() == list.length) {
                // Verifies that the player entered the proper amount of itemList.
                GUI.out(Player.inv.combine(list, list[0].getProduct())); 
                GUI.invOut("You are carrying:\n" + Player.inv);
            }
            else 
                // 2 objects are correct, but 1 is missing.
                GUI.out("You need something else for this to work."); 
        }
        else switch (list.length) {
            case 2:
                // Player entered 2 itemList that don't combine.
                GUI.out("You push them together as hard as you can,\n" +
                        "but it does nothing."); 
                break;
            case 3:
                // Player entered 3 itemList, some of which may combine.
                GUI.out("You are pretty sure all these don't go together."); 
        } 
    }
    // ========================================================================  
    /**
     * Returns a list of itemList that the player is trying to combine and catches
 errors in the player's syntax.
     * @param tokenizer A scanner holding the list of player entries
     * @return A list of itemList the player wants to combine.
     */
    private static Item[] getTokenList(Scanner tokenizer) {
        ArrayList<Item> itemList = new ArrayList();
        
        try {
            while (tokenizer.hasNext()) {                                                                            
                int slot = Integer.parseInt(tokenizer.next());
                Item item = Player.inv.get(slot - 1);
                
                if (! itemList.contains(item))
                    // Prevents adding duplicate itemList.
                    itemList.add(item);
            }
        }
        catch (NumberFormatException | IndexOutOfBoundsException e) {
            return new Item[0]; // List isn't valid.
        }
        return itemList.toArray(new Item[itemList.size()]);
    }
    // ========================================================================  
    /**
     * Checks that all the itemList in the list combine into the same object.
     * @param itemList A list of itemList
     * @return If the itemList combine into the same object.
     */
    private static boolean areAllCombinable(Item[] itemList) {
        String combinesTo = itemList[0].getForms();

        for (Item i : itemList) {
            if (i.getForms().matches("nothing") || ! i.getForms().matches(combinesTo))
                return false;
        } 
        return true;
    }   
//******************************************************************************    
// </editor-fold>  
//******************************************************************************   
}


