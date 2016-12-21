package Main;

import Super.Room;
import Super.Item;
import Super.Furniture;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
/**
 * The player class is the center of the game.
 * Most importantly, the player has access to the room it's in, and by 
 * extension, the furniture and items in the room. 
 * 
 * @author Kevin Rapa
 */
public class Player implements Serializable {
    private static Room[][][] mapRef;
    private static int[] occ; // Room object you are in.
    private static Inventory inv, keys; // Your inventory and keyring.
    private static ArrayList<String> visited; // List of rooms you have visited.
    private static String lastVisited; // The last room you visited.
    private static String shoesWearing; // Name of the getShoes the player is wearing;
    
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
    /**
     * @param room The room in which to place the player.
     */
    public static void setOccupies(int ... coords) {
        Player.occ = coords;
        
        if (! Player.hasVisited(getOcc().getID())) 
            Player.visited.add(getOcc().getID()); 
    }
    /*------------------------------------------------------------------------*/
    /**
     * Converts a string of a piece of furniture to its object equivalent.
     * @param name The name of a piece of furniture in your location.
     * @return The furniture objects with the name.
     */
    public static Furniture getFurnitureObject(String name) {
        for(Furniture i : Player.getOcc().getFurnishings()) {
            if (i.getValidNames().contains(name))
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
    public static Inventory getINV() {
        return Player.inv;
    }
    /*------------------------------------------------------------------------*/
    /**
     * @return The player's key ring.
     */
    public static Inventory getKEYS() {
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
        return Player.shoesWearing;
    }
    /*------------------------------------------------------------------------*/
    public static void switchShoes(String shoes) {
        Player.shoesWearing = shoes;
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
        Player.shoesWearing = shoesWearing;
    }
    /*------------------------------------------------------------------------*/
    /**
     * Creates new attributes that the player starts a new game with.
     */
    public static void setNewAttributes() {
        Player.mapRef = Salamaa.createMap();
        Player.inv = Player.keys = new Inventory();
        Player.visited = new ArrayList() {{ add("COU4"); }};
        Player.occ = new int[3];
        occ[0] = /**/ 3; // Starting Z position.
        occ[1] = /**/ 4; // Starting Y position.
        occ[2] = /**/ 2; // Starting X position.
        Player.lastVisited = "";
        Player.shoesWearing = "";
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
        AudioPlayer.playTrack(Player.getOcc().getID());
        GUI.invOut("You are carrying:\n" + Player.inv);
        String ans;
        
        GUI.roomOut(Player.getOcc().triggeredEvent());
        describeRoom();
        GUI.clearMenu();
        
        do {
            ans = GUI.promptOut();

            if (ans.matches("[wsad]")) // For movement
                move(ans.charAt(0));
            
            else if (ans.matches("[hecxki]")) { // For all other actions.
                if (ans.matches("[hecx]")) // Plays select noise
                    AudioPlayer.playEffect(17);
                
                CMD.get(ans.charAt(0)).run();
            }
        } while (! ans.matches("quit"));
        
        GUI.menOut("Would you like to save?\n<'y'> Save and quit\n"
                 + "<'n'> Quit\n<'r'> Erase game and quit.");
        ans = GUI.promptOut();
        
        while (! ans.matches("[ynr]")) {
            GUI.menOut("Please enter 'y', 'n', or 'r'.\n<'y'> Save and quit\n"
                     + "<'n'> Quit\n<'r'> Erase game and quit.");
            ans = GUI.promptOut();
        }
        return ans.matches("y") ? 1 : 
               ans.matches("n") ? 2 : 3;
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
     * @param dir A direction input from the keyboard - 'w', 's', 'a', or 'd'.
     * @param map A reference for moving the player.
     */
    private static void move(char dir) {  
        int b = 0, a = 0; // Position modifiers.
        
        switch (dir) {
            // Sets the values of position modifiers b, a.
            case 'w': b = -1; a = 0; break;
            case 's': b = 1; a = 0; break;
            case 'd': b = 0; a = 1; break;
            case 'a': b = 0; a = -1;
        }
        
        int[] i = Player.getOcc().getCoords();
        Room destination = mapRef[i[0]][i[1] + b][i[2] + a];
        
        if (! Player.getOcc().isAdjacent(destination.getID()))
            GUI.out(Player.getOcc().getBarrier(dir)); // There's a wall in the way.
              
        else if (destination.isThisLocked() && ! hasKey(destination.getID())) {
            AudioPlayer.playEffect(4);
            GUI.out("The door here is locked."); 
        }
        else {
            GUI.clearDialog();
            Player.lastVisited = Player.getOcc().getID();
            Player.occ = destination.getCoords();
            GUI.roomOut(Player.getOcc().triggeredEvent());
            
            if (getOcc().isThisLocked() && ! Player.visited.contains(getOcc().getID()))
                AudioPlayer.playEffect(13); // Plays unlock sound.
            else if (! getOcc().getID().matches("C[AV]..") && 
                     ! getOcc().getID().substring(0,3).matches(lastVisited.substring(0,3)))
                     // Checks that you aren't in the catacombs or caves
                     // Checks that rooms have a door between them.
                AudioPlayer.playEffect(9); // Plays open door sound. 
            else
                AudioPlayer.playEffect(0); // Plays footsteps.
            
            describeRoom();
            
            if (! hasVisited(Player.getOcc().getID())) 
                Player.visited.add(Player.getOcc().getID());  
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
// <editor-fold desc="keys">      
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
        
        if (! searchThis.matches("") && Player.getOcc().hasFurniture(searchThis))
            search(getFurnitureObject(searchThis));  
        
        else if (! searchThis.matches(""))
                GUI.out("There is no " + searchThis + " here."); 
        
        GUI.clearMenu();
        GUI.invOut("You are carrying:\n" + Player.inv);
    }    
    // ========================================================================  
    /**
     * Subroutine initiated after a searchable furniture is searched.
     * Prints a list of items that the furniture parameter contains then
     * initiates subroutine for trading items between inventories.
     * 
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
     * Subroutine allowing the exchange of items between the player's inventory 
     * and the furniture.
     * @param furniture The furniture being searched.
     */
    private static void searchPrompt(Furniture furniture) {
        String cmdItm, action; 
        int slot;
        Item item;
            
        do {
            GUI.menOut("\n<'store' #> Store...\n<'take' #> Take...\n< > Back\"");
            
            cmdItm = GUI.promptOut();
            
            try (Scanner collectToken = new Scanner(cmdItm).useDelimiter("\\s+")) {
                action = collectToken.next();            
                slot = Integer.parseInt(collectToken.next());
                
                if (action.matches("store")) {
                    item = Player.inv.getInv().get(slot - 1);
                    storeSub(furniture, item);                            
                }            
                else if (action.matches("take")) {
                    item = furniture.getInv().getInv().get(slot - 1);
                    takeSub(furniture, item);
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
    private static void takeSub(Furniture furniture, Item take) {
        if (! (Player.inv.getInv().contains(take) || Player.inv.atCapactity())) {
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
        else if (Player.inv.atCapactity())
            GUI.out("You are carrying too much!");
        
        else if (Player.inv.getInv().contains(take))
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
    private static void storeSub(Furniture furniture, Item store) {
        if (store.getType().matches("phylactery"))
            GUI.out("The " + store + " looks too important to get rid of.");

        else {
            GUI.out("You store the " + store);
            Player.inv.give(store , furniture.getInv()); 
            
            if (store.toString().matches(shoesWearing))
                Player.shoesWearing = "";
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
        for (Item i : Player.inv) {
            if (i.toString().matches(item))
                return true;
        }
        return false;
    }
    // ========================================================================  
    /**
     * Returns an item object reference in your inventory with the name.
     * @param itemName The item's name.
     * @return the object reference.    // ========================================================================  
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
            if (Player.getOcc().hasFurniture(checkThis)) { // Checks that furniture is in the room.
                Furniture inspecting = getFurnitureObject(checkThis);
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
        
        if (Player.getOcc().hasFurniture(object)) {                             
            target = getFurnitureObject(object);

            if (action.matches("look|view|inspect")) 
                GUI.out(target.getDescription()); 

            else if (action.matches("search"))                    
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
                Item item = Player.inv.getInv().get(slot - 1);
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
                Item item = Player.inv.getInv().get(slot - 1);
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

            if (Player.getOcc().hasFurniture(ans)) {                 
                target = getFurnitureObject(ans);

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
    private static void combineSub() {
        String combineThese;
        Scanner collectToken;
        GUI.menOut("<#,#,(#)> Combine...\n< > Back");
        
        do {
            combineThese = GUI.promptOut();
            collectToken = new Scanner(combineThese).useDelimiter("\\s*,\\s*");

            Item[] list = getTokenList(collectToken);
            
            if (! combineThese.matches("") && list.length != 0) {
                if (list[0].getThreshold() == list.length && areAllCombinable(list)) {
                    GUI.out(Player.inv.combine(list, list[0].getProduct())); 
                    GUI.invOut("You are carrying:\n" + Player.inv);
                }
                else if (list.length <= 1) 
                    GUI.out("You must combine at least 2 items."); 
                
                else if (list[0].getThreshold() >= list.length)
                    // Prints if 2 objects are correct, but 1 is missing.
                    GUI.out("You need something else for this to work.");                                       
                         
                else
                    GUI.out("You push them together as hard as you can,\n" +
                               "but it does nothing.");        
            }
            else if (! combineThese.matches("") && list.length == 0)
                GUI.out("Enter a valid slot number.");
            
            collectToken.close();  
            
        } while (! combineThese.matches(""));        
    }
    // ========================================================================  
    /**
     * Returns a list of items that the player is trying to combine and catches
     * errors in the player's syntax.
     * @param tokenizer A scanner holding the list of player entries
     * @return A list of items the player wants to combine.
     */
    private static Item[] getTokenList(Scanner tokenizer) {
        ArrayList<Item> tokens = new ArrayList(); // This holds combined items. 
        
        try {
            while (tokenizer.hasNext()) {                                                                            
                int slot = Integer.parseInt(tokenizer.next()); // The assignment of the next token.
                Item item = Player.inv.getInv().get(slot - 1);
                
                if (! tokens.contains(item) && item != null)
                    tokens.add(item); // Adds the item to the list. Ignores duplicates.
                else
                    GUI.out("You entered an extra " + item);
            }
        }
        catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        return tokens.toArray(new Item[tokens.size()]);
    }
    // ========================================================================  
    /**
     * Checks that all the items in the list combine into the same object.
     * @param tokens A list of items
     * @return If the items combine into the same object.
     */
    private static boolean areAllCombinable(Item[] tokens) {
        String combinesTo = tokens[0].getForms();

        for (Item i : tokens) {
            if (i.getForms().matches("nothing") || 
                ! i.getForms().matches(combinesTo))
                return false;
        } 
        return true;
    }   
//******************************************************************************    
// </editor-fold>  
//******************************************************************************   
}


