package Core;

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
    private Room occupies; // Room object you are in.
    private final Inventory INV, KEYS; // Your inventory and keyring.
    private final ArrayList<String> VISITED; // List of rooms you have visited.
    private String lastVisited; // The last room you visited.
    //========================================================================== 
    /**
     * Constructs the player object.
     * Gives player a new inventory, key ring, and a new VISITED array.
     */
    public Player() {
        this.INV = new Inventory();
        this.KEYS = new Inventory();
        this.VISITED = new ArrayList();
        this.VISITED.add("COU4"); // Default starting location.
    }    
//******************************************************************************
// <editor-fold desc="GETTERS AND SETTERS">  
//******************************************************************************
    /**
     * @return The text that prints upon entering a room.
     */
    @Override public String toString() {
        return "You are in the " + this.occupies.toString() + "."; 
    }
    /*------------------------------------------------------------------------*/
    /**
     * @param room The room in which to place the player.
     */
    public void setOccupies(Room room) {
        this.occupies = room;
        
        if (! this.hasVisited(room.getID())) 
            this.VISITED.add(room.getID()); 
    }
    /*------------------------------------------------------------------------*/
    /**
     * Converts a string of a piece of furniture to its object equivalent.
     * @param name The name of a piece of furniture in your location.
     * @return The furniture objects with the name.
     */
    public Furniture getFurnitureObject(String name) {
        for(Furniture i : this.occupies.getFurnishings()) {
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
    public String getLastVisited() {
        return this.lastVisited;
    }
    /*------------------------------------------------------------------------*/ 
    /**
     * @return The player's inventory.
     */
    public Inventory getINV() {
        return this.INV;
    }
    /*------------------------------------------------------------------------*/
    /**
     * @return The player's key ring.
     */
    public Inventory getKEYS() {
        return this.KEYS;
    }
    /*------------------------------------------------------------------------*/
    /**
     * @return The room you are in. 
     */
    public Room getOcc() {
        return this.occupies;
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************


//******************************************************************************
// <editor-fold desc="START GAME"> 
//******************************************************************************
    /**
     * This dialog prints at the start of a new game.
     * @param map The map is used by the player as a reference.
     */
    public void startDialog(Room[][][] map) {
        GUI.out("It's 10:00pm, the night is clear and warm.\n" +
                "You have just arrived on foot to your destination, and\n" +
                "its even more colossal than what you had\n" +
                "expected. It also appears curiously more vacant...\n"
              + "Press enter...");
        
        GUI.promptOut();
                
        GUI.out("You slowly approach until between the front gateway.\n" +
                "A thought briefly flashes in your mind before being\n" +
                "forgotten - what was your business here, again?...\n"
              + "Press enter...");
        
        GUI.promptOut();
        GUI.clearDialog();
        
        this.mainPrompt(map);
    }
    // ========================================================================   
    /**
     * The main prompt for controlling the player's moves.
     * @param map The map is used by the player as a reference.
     */
    public void mainPrompt(Room[][][] map) {
        HashMap<Character, Runnable> cmd = new HashMap();
        String ans;

        cmd.put('h', () -> Help.helpSub());
        cmd.put('e', () -> this.searchSub());
        cmd.put('c', () -> this.checkOutSub());
        cmd.put('x', () -> this.activateSub(map));
        cmd.put('k', () -> this.viewKeyRing());
        cmd.put('i', () -> this.viewInventory());

        GUI.roomOut(this.occupies.triggeredEvent(map));
        this.describeRoom();
        GUI.clearMenu();
        
        do {
            ans = GUI.promptOut();

            if (ans.matches("[wsad]")) // For movement
                this.move(ans.charAt(0), map);
            
            else if (ans.matches("[hecxki]")) // For all other actions.
                cmd.get(ans.charAt(0)).run();

        } while (! ans.matches("quit"));
        
        GUI.menOut("Your game will be saved.\nPress enter to quit.");
        GUI.promptOut();
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
    public boolean hasVisited(String roomID) {
        return this.VISITED.contains(roomID);
    }
    // ========================================================================  
    /**
     * The movement algorithm for moving the player north, south, east, and west.
     * @param dir A direction input from the keyboard - 'w', 's', 'a', or 'd'.
     * @param map A reference for moving the player.
     */
    private void move(char dir, Room[][][] map) {  
        int b = 0, a = 0; // Position modifiers.
        
        switch (dir) {
        // Sets the values of position modifiers b, a.
        case 'w': b = -1; a = 0; break;
        case 's': b = 1; a = 0; break;
        case 'd': b = 0; a = 1; break;
        case 'a': b = 0; a = -1;
        }
        int[] i = this.occupies.getCoords();
        Room destination = map[i[0]][i[1] + b][i[2] + a];
        
        if (! this.occupies.isAdjacent(destination.getID()))
            // Checks if there's no wall in the way.
            GUI.out(this.occupies.getBarrier(dir)); 
              
        else if (destination.isThisLocked() && ! this.hasKey(destination.getID())) 
            // Checks if both the room is locked and you don't have the key.
            GUI.out("The door here is locked."); 
   
        else {
            GUI.clearDialog();
            this.lastVisited = this.occupies.getID(); // Sets your last visited room to be your current room.
            this.occupies = destination;  // The actual movement.
            this.describeRoom();
            GUI.roomOut(this.occupies.triggeredEvent(map)); // Event triggers.
            
            if (! this.hasVisited(this.occupies.getID())) 
                this.VISITED.add(this.occupies.getID());  
        } 
    }
    // ========================================================================  
    public void describeRoom() {
        GUI.descOut(this.occupies.getDescription());
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
    private void addToKeyRing(Item key, Furniture furniture) {
        furniture.getInv().give(key, this.KEYS);
    }
    // ========================================================================  
    private void viewKeyRing() {
        GUI.invOut("Keys:\n" + this.KEYS.toString()); 
    }
    // ========================================================================  
    /**
     * Used to check if the player may enter a particular locked room.
     * @param keyID The ID of a key, corresponding to a room ID.
     * @return If you have the key.
     */
    public boolean hasKey(String keyID) {
        for (Item key : this.KEYS) {              
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
    private void searchSub() {
        // Initiates dialog asking player for a Furniture to search.
        GUI.menOut("-object- Search\n     - - Back\n");
        String searchThis = GUI.promptOut();
        
        if (! searchThis.matches("") && this.occupies.hasFurniture(searchThis))
            this.search(this.getFurnitureObject(searchThis));  
        
        else if (! searchThis.matches(""))
                GUI.out("There is no " + searchThis + " here."); 
        
        GUI.clearMenu();
        GUI.invOut("You are carrying:\n" + this.INV);
    }    
    // ========================================================================  
    /**
     * Subroutine initiated after a searchable furniture is searched.
     * @param furniture The furniture being searched.
     */
    private void search(Furniture furniture) {
        // This prints a list of items that the furniture parameter contains.
        // Initiates subroutine for trading items between inventories.
        GUI.out(furniture.getSearchDialog());
        
        if (furniture.isSearchable()) {
            GUI.invOut("You find:\n" + furniture.getInv() + 
                          "\nYou are carrying:\n" + this.INV);
            this.searchPrompt(furniture); 
        }
    } 
    // ========================================================================  
    /**
     * Subroutine allowing the exchange of items between the player's inventory 
     * and the furniture.
     * @param furniture The furniture being searched.
     */
    private void searchPrompt(Furniture furniture) {
        String cmdItm, action; 
        int slot;
        Item item;
            
        do {
            GUI.menOut("-'store' item- Store...\n-'take' item- Take...\n- - Back\"");
            
            cmdItm = GUI.promptOut();
            
            try (Scanner collectToken = new Scanner(cmdItm).useDelimiter("\\s+")) {
                action = collectToken.next();            
                slot = Integer.parseInt(collectToken.next());
                
                if (action.matches("store")) {
                    item = this.INV.getInv().get(slot - 1);
                    this.storeSub(furniture, item);                            
                }            
                else if (action.matches("take")) {
                    item = furniture.getInv().getInv().get(slot - 1);
                    this.takeSub(furniture, item);
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
    private void takeSub(Furniture furniture, Item take) {
        if (! (this.INV.getInv().contains(take) || this.INV.atCapactity())) {
            // Checks that you don't already have it.
            if (take.getType().matches("[A-Z]{3}[A-Z1-9]")) {
                this.addToKeyRing(take, furniture); // It's a key.
                GUI.out("You put the " + take + " in your key ring.");
            }
            else {
                GUI.out("You take the " + take);
                furniture.getInv().give(take, this.INV);                 
            }   
        }
        else if (this.INV.atCapactity())
            GUI.out("You are carrying too much!");
        
        else if (this.INV.getInv().contains(take))
            GUI.out("You already have one of those."); 
        
        GUI.invOut("You find:\n" + furniture.getInv() + 
                      "\nYou are carrying:\n" + this.INV);
    }
    // ========================================================================  
    /**
     * Evaluates the player's store action.
     * @param furniture The furniture in which the item is being stored.
     * @param store The item being stored.
     */
    private void storeSub(Furniture furniture, Item store) {
        if (store.getType().matches("phylactery"))
            GUI.out("The " + store + " looks too important to get rid of.");

        else {
            GUI.out("You store the " + store);
            this.INV.give(store , furniture.getInv()); 
        }
        GUI.invOut("You find:\n" + furniture.getInv() + 
                   "\nYou are carrying:\n" + this.INV);
    }
    // ========================================================================  
    /**
     * Checks that you have a specific item.
     * @param item The item in question.
     * @return If you have the item.
     */
    public boolean doYouHaveIt(String item) {
        for (Item i : this.INV) {
            if (i.toString().matches(item))
                return true;
        }
        return false;
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
    private void activateSub(Room[][][] map) {
        Furniture target;
        String action, object;
               
        GUI.menOut("-action object- Interact...\n- - Back\n");
        
        String actObj = GUI.promptOut(); 
        
        if (! actObj.matches("")) {
            try (Scanner collectToken = new Scanner(actObj).useDelimiter("\\s+")) {
                action = collectToken.next();            
                object = collectToken.next(); 
                
                while (collectToken.hasNext()) // If item is 2+ words long.
                    object = object.concat(" " + collectToken.next());
                    
                if (this.occupies.hasFurniture(object)) {                             
                    target = this.getFurnitureObject(object);

                    if (action.matches("look|view|inspect")) 
                        GUI.out(target.getDescription()); 
                                      
                    else if (action.matches("search"))                    
                        this.search(target); 
                    
                    else if (target.keyMatches(action)) {
                        GUI.out(target.interact(map, action)); 
                        this.describeRoom();
                    }
                    else
                        GUI.out("That seems unnecessary.");
                }                
                else
                    GUI.out("There is no " + object + " in this room."); 
            }
            catch (java.util.NoSuchElementException e) {
                    GUI.out("Type an action and an object.");
                    this.activateSub(map); 
            } 
        }
        GUI.clearMenu();
    }
    // ========================================================================  
    private void checkOutSub() {
        GUI.menOut("-object- Look at...\n- - Back\n");
        
        String checkThis = GUI.promptOut();
        
        if (! checkThis.matches("")) {
            if (this.occupies.hasFurniture(checkThis)) { // Checks that furniture is in the room.
                Furniture inspecting = getFurnitureObject(checkThis);
                GUI.out(inspecting.getDescription()); // Initiates inspection.
            }
            else
                GUI.out("There is no " + checkThis + " here.");
        }
        GUI.clearMenu();
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold desc="INVENTORY ACTIONS">      
//******************************************************************************    
    private void viewInventory() {
        // Prints objects in your inventory, if any.
        GUI.invOut("You are carrying:\n" + this.INV);
        this.inventorySub(); 
        GUI.clearMenu();
    }
    // ========================================================================  
    private void inventorySub() {
        HashMap<Character, Runnable> cmd = new HashMap();
        String ans;
        
        cmd.put('1', () -> this.inspectSub());
        cmd.put('2', () -> this.useSub());
        cmd.put('3', () -> this.combineSub());
        
        do {
            GUI.menOut("-1- Inspect item\n-2- Use item\n" + 
                          "-3- Combine items\n- -Back");
            
            ans = GUI.promptOut();
            
            if (ans.matches("[1-3]")) {
                cmd.get(ans.charAt(0)).run();
                GUI.invOut("You are carrying:\n" + this.INV.toString());
            } 
        } while (! ans.matches(""));
    }
    // ========================================================================  
    private void inspectSub() {
        String ans;            
        
        do {
            GUI.menOut("-item- Inspect...\n- - Back");
            ans = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(ans);
                Item item = this.INV.getInv().get(slot - 1);
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
    private void useSub() {
        String choice;
        
        do { 
            GUI.menOut("-item- Use...\n- - Back");
            choice = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(choice);
                Item item = this.INV.getInv().get(slot - 1);
                int useID = item.getUseID();
                this.useSwitch(useID, item);
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
    private void useSwitch(int useID, Item item) {
        Furniture target; 
        
        switch (useID) {
            
        case 1:
            GUI.out(item.useEvent()); break;           
        case 2:
            GUI.menOut("-object- Use on...\n- - Back");

            String ans = GUI.promptOut();

            if (this.occupies.hasFurniture(ans)) {                 
                target = this.getFurnitureObject(ans);

                if (target.isUsedBy(item.toString())) {
                    GUI.out(target.useEvent(item));
                    this.describeRoom();
                }
                else
                    GUI.out("You jam the " + item + " into the " + ans +
                               "\nas hard as you can, but nothing happens.");
            }                      
            else if (! ans.matches(""))
                GUI.out("There is no " + ans + " here.");                    
        }
        GUI.invOut("You are carrying:\n" + this.INV);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="INVENTORY (COMBINING)">     
//******************************************************************************    
    private void combineSub() {
        String combineThese;
        Scanner collectToken;
        GUI.menOut("-item,item,(item)- Combine...\n- - Back");
        
        do {
            combineThese = GUI.promptOut();
            collectToken = new Scanner(combineThese).useDelimiter("\\s*,\\s*");
            Item[] list = this.getTokenList(collectToken);
            
            if (! (combineThese.matches("") || list.length == 0)) {
                if (list[0].getThreshold() == list.length && this.areAllCombinable(list)) {
                    GUI.out(this.INV.combine(list, list[0].getProduct())); 
                    GUI.invOut("You are carrying:\n" + this.INV);
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
    private Item[] getTokenList(Scanner tokenizer) {
        ArrayList<Item> tokens = new ArrayList(); // This holds combined items. 
        
        try {
            while (tokenizer.hasNext()) {                                                                            
                int slot = Integer.parseInt(tokenizer.next()); // The assignment of the next token.
                Item item = this.INV.getInv().get(slot - 1);
                
                if (! tokens.contains(item) && item != null)
                    tokens.add(item); // Adds the item to the list. Ignores duplicates.
                else
                    GUI.out("You entered an extra " + item);
            }
        }
        catch (java.lang.NumberFormatException | 
               java.lang.IndexOutOfBoundsException e) {}
        
        return tokens.toArray(new Item[tokens.size()]);
    }
    // ========================================================================  
    /**
     * Checks that all the items in the list combine into the same object.
     * @param tokens A list of items
     * @return If the items combine into the same object.
     */
    private boolean areAllCombinable(Item[] tokens) {
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


