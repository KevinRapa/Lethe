package A_Main;

import A_Super.Room;
import A_Super.Item;
import A_Super.Direction;
import A_Super.Furniture;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import A_Super.Openable;
/**
 * Represents the player, the focal point of the game.
 * All player actions originate from the is class. The player has access
 * to its own location, and thereby each furniture and item in the location
 * too.
 * 
 * The player attributes (including the map) are wrapped in <code>PlayerAttributes</code>
 * and serialized to a file upon a save game. The attributes are set during
 * startup if save game data exists.
 * 
 * @see A_Main.PlayerAttributes
 * @author Kevin Rapa
 */
public final class Player {
    private static Room[][][] mapRef;
    private static int[] pos;
    private static Inventory inv, keys;
    private static ArrayList<String> visited;
    private static String lastVisited, shoes;
    private final static HashMap<Character, Runnable> CMD = new HashMap<>(); 
//******************************************************************************
// <editor-fold desc="GETTERS AND SETTERS">  
//******************************************************************************
    // <editor-fold desc="Getters">
    
    /**
     * Converts a string of a piece of furniture to its object equivalent.
     * @param name The name of a piece of furniture in your location.
     * @return The furniture objects with the name.
     */
    private static Furniture getFurnRef(String name) {
        for(Furniture i : getPos().getFurnishings()) {
            if (i.getValidNames().stream().anyMatch(j -> name.matches(j)))
                return i;           
        }
        return null; // Should never return null. Furniture is already checked for existence.
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
    public static Inventory getInv() {
        return Player.inv;
    }
    /*------------------------------------------------------------------------*/
    public static Inventory getKeys() {
        return Player.keys;
    }
    /*------------------------------------------------------------------------*/
    public static Room getPos() {
        return Player.mapRef[pos[0]][pos[1]][pos[2]];
    }
    /*------------------------------------------------------------------------*/
    /**
     * @return The ID of the room you are in.
     */
    public static String getPosId() {
        return Player.getPos().getID();
    }
    /*------------------------------------------------------------------------*/
    public static Room[][][] getMapRef() {
        return mapRef;
    }
    /*------------------------------------------------------------------------*/
    public static Room getRoomObj(String ID) {
        int[] c = RoomReferences.getCoords(ID);
        return mapRef[c[0]][c[1]][c[2]];
    }
    /*------------------------------------------------------------------------*/
    public static Room getRoomObj(int z, int y, int x) {
        return mapRef[z][y][x];
    }
    /*------------------------------------------------------------------------*/
    public static ArrayList<String> getVisitedRooms() {
        return visited;
    }
    /*------------------------------------------------------------------------*/
    public static String getShoes() {
        return Player.shoes;
    }
    
    // </editor-fold>
    
    // <editor-fold desc="Setters">
    
    public static void setOccupies(int z, int y, int x) {
        Player.lastVisited = getPosId();
        Player.pos[0] = z; Player.pos[1] = y; Player.pos[2] = x;
        
        describeRoom();
        GUI.roomOut(Player.getPos().triggeredEvent());
        
        if (! Player.hasVisited(getPosId())) 
            Player.visited.add(getPosId()); 
    }
    /*------------------------------------------------------------------------*/
    public static void setOccupies(String dest) {
        Player.lastVisited = getPosId();
        Player.pos = Player.getRoomObj(dest).getCoords();
        
        describeRoom();
        GUI.roomOut(Player.getPos().triggeredEvent());
        
        if (! Player.hasVisited(getPosId())) 
            Player.visited.add(getPosId()); 
    }
    /*------------------------------------------------------------------------*/
    public static void setShoes(String shoes) {
        Player.shoes = shoes;
    }
    
    // </editor-fold>
    
    /*------------------------------------------------------------------------*/
    /**
     * Checks that you have a specific item.
     * @param item The item in question.
     * @return If you have the item.
     */
    public static boolean hasItem(String item) {
        return Player.inv.contents().stream().
                anyMatch(i -> i.toString().matches(item));
    }
    /*------------------------------------------------------------------------*/
    
//******************************************************************************    
// </editor-fold>  
//******************************************************************************


//******************************************************************************
// <editor-fold desc="START GAME"> 
//******************************************************************************
    public static void loadAttributes(Inventory inv, Inventory keys, ArrayList<String> visited, 
                                      String lastVisited, String shoesWearing, int[] pos, Room[][][] map) {
        // Sets saved game attributes. See PlayerAttributes.java.
        Player.mapRef = map;
        Player.inv = inv;
        Player.keys = keys;
        Player.pos = pos;
        Player.visited = visited;
        Player.lastVisited = lastVisited;
        Player.shoes = shoesWearing;
    }
    // ========================================================================  
    /**
     * Creates new attributes that the player starts a new game with.
     * @param coords Coordinates the player begins the game at.
     */
    public static void setNewAttributes(int ... coords) {
        Player.mapRef = Main.createMap();
        Player.inv = new Inventory();
        Player.keys = new Inventory();
        Player.visited = new ArrayList();
        Player.pos = coords;
        Player.lastVisited = "";
        Player.shoes = "";
    }
    // ========================================================================  
    /**
     * This dialog prints at the start of a new game.
     * @return Integer representing player choice to save, erase data, or just quit.
     */
    public static int startDialog() {
        AudioPlayer.playTrack(Player.getPosId());
        
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
        
        GUI.menOut("Press the up arrow key\nat any time to go to\n"
                 + "your last action.\n\nPress enter...");
        GUI.promptOut();
        
        return mainPrompt();
    }
    // ========================================================================   
    /**
     * The main prompt for controlling the player's moves.
     * @return Integer representing player choice to save, erase data, or just quit.
     */
    public static int mainPrompt() {
        CMD.put('h', () -> Help.helpSub());
        CMD.put('e', () -> searchSub());
        CMD.put('c', () -> checkOutSub());
        CMD.put('k', () -> viewKeyRing());
        CMD.put('i', () -> inventoryPrompt());
        CMD.put('w', () -> move(Direction.NORTH));
        CMD.put('s', () -> move(Direction.SOUTH));
        CMD.put('a', () -> move(Direction.WEST));
        CMD.put('d', () -> move(Direction.EAST));
        String ans;
        
        AudioPlayer.playTrack(getPosId());
        GUI.invOut("You are carrying:\n" + Player.inv);
        
        GUI.roomOut(getPos().triggeredEvent());
        describeRoom();
        
        do {
            GUI.toMainMenu();
            ans = GUI.promptOut();

            if (ans.matches("[heckiwsad]")) 
                CMD.get(ans.charAt(0)).run();
            
            else if (ans.matches("[a-z]+\\s[a-z ]+")) // Interacting
                activateSub(ans);

        } while (! ans.equals("quit"));
        
        return endGame();
    }  
    // ========================================================================   
    private static int endGame() {
        GUI.menOut("\n<'s'> Save and quit\n<'q'> Quit\n<'r'> Reset game and quit.");
        String ans = GUI.promptOut();
        
        while (! ans.matches("[sqr]")) {
            GUI.menOut("\nPlease enter 's', 'q', or 'r'.\n<'s'> Save and quit\n"
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
     * Two rooms are considered not to have a door between them if the first
     * three characters of their IDs are identical. An exception is made for 
     * caves and catacombs, which have no doors.
     * 
     * @param dir A cardinal direction.
     */
    public static void move(Direction dir) {  
        int[] c = getPos().getCoords();
        Room destination = mapRef[c[0] + dir.Z][c[1] + dir.Y][c[2] + dir.X];
        
        if (! getPos().isAdjacent(destination.getID()))
            // There's a wall in the way.
            GUI.out(getPos().getBarrier(dir));
              
        else if (destination.isThisLocked() && ! hasKey(destination.getID())) {
            //Destination is locked and you don't have the key.
            AudioPlayer.playEffect(4); // Plays doorknob jiggle sound.
            GUI.out("The door here is locked."); 
        }
        else { 
            // You can move to the destination.
            GUI.clearDialog();
            lastVisited = getPosId();
            Player.pos = destination.getCoords();
            GUI.roomOut(getPos().triggeredEvent());

            if (getPos().isThisLocked() && ! visited.contains(getPosId()))
                AudioPlayer.playEffect(13); // Plays unlock sound.
            
            else if (getPos().getCoords()[0] < 5  && 
                     ! getPosId().substring(0,3).matches(lastVisited.substring(0,3))) {
                if (getPos().getCoords()[0] == 4 || getPosId().matches("CS35|CT34"))
                    AudioPlayer.playEffect(24); // Plays metal open door sound. 
                else
                    AudioPlayer.playEffect(9); // Plays wooden open door sound. 
            }
            
            else if (getPos().getCoords()[0] > 4  && 
                    ! getPosId().substring(0,2).matches(lastVisited.substring(0,2)))
                // Annoying. Catches the cases in catacombs and caves which are autogenerated.
                AudioPlayer.playEffect(9);
            
            else
                AudioPlayer.playEffect(0); // Plays footsteps.
            
            describeRoom();
            
            if (! hasVisited(getPosId())) 
                visited.add(getPosId());  
        } 
    }
    // ========================================================================  
    public static void describeRoom() {
        AudioPlayer.playTrack(getPosId());
        GUI.descOut(getPos().getDescription());
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
        
        if (! searchThis.matches("") && getPos().hasFurniture(searchThis))
            search(getFurnRef(searchThis));
        
        else if (searchThis.matches("it|them")) // Indefinite reference.
            if (Player.getPos().hasFurniture(searchThis = GUI.parsePreviousFurniture()))
                search(getFurnRef(searchThis));
        
        else if (searchThis.matches("furniture|furnishings"))
            GUI.out("You have to enter something specific.");
            
        else if (! searchThis.matches("")) 
            GUI.out("There is no " + searchThis + " here."); 

        GUI.invOut("You are carrying:\n" + Player.inv);
    }    
    // ========================================================================  
    /**
     * Subroutine entered after a searchable furniture is searched.
     * Serves to block access from trading itemList with non searchable furniture.
     * @param furniture The furniture being searched.
     */
    public static void search(Furniture furniture) {
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
        String cmdItm; 
        
        do {
            GUI.menOut("\n<'s' #> Store...\n<'t' #> Take...\n< > Back\"");
            
            cmdItm = GUI.promptOut();

            try (Scanner collectToken = new Scanner(cmdItm).useDelimiter("\\s+")) {
                String action = collectToken.next();            
                int slot = Integer.parseInt(collectToken.next());
                
                if (action.matches("s|store")) {
                    Item item = Player.inv.get(slot - 1);
                    evalStore(furniture, item);                            
                }            
                else if (action.matches("t|take")) {
                    Item item = furniture.getInv().get(slot - 1);
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
        
        describeRoom();
    }
    // ========================================================================  
    /**
     * Evaluates the player's take action.
     * @param furniture The furniture from which to take an item.
     * @param take The item being taken.
     */
    private static void evalTake(Furniture furniture, Item take) {
        if (! Player.inv.contains(take)) {
            if (take.getType().matches("[A-Z]{3}[A-Z1-9]")) {
                // Matches a non-cave/catacomb room ID, which keys use as types.
                addToKeyRing(take, furniture);
                AudioPlayer.playEffect(3);
                GUI.out("You put the " + take + " in your key ring.");
            }
            else {
                GUI.out("You take the " + take);
                furniture.getInv().give(take, Player.inv);                 
            }   
        }
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
        if (store.getType().equals("phylactery"))
            GUI.out("The " + store + " looks too important to get rid of.");

        else {
            GUI.out("You store the " + store);
            Player.inv.give(store , furniture.getInv()); 
            
            // If player stores the shoes he/she is wearing.
            if (store.toString().matches(shoes))
                Player.shoes = "";
        }
        
        GUI.invOut("You find:\n" + furniture.getInv() + 
                   "\nYou are carrying:\n" + Player.inv);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold desc="ACTIVATING AND INSPECTING">  
//****************************************************************************** 
    /**
     * Subroutine entered when furniture is interacted with.
     * @param actObj Two or more words; a verb followed by an object name
     */
    private static void activateSub(String actObj) {
        try (Scanner collectToken = new Scanner(actObj).useDelimiter("\\s+")) {
            String action = collectToken.next();            
            String object = collectToken.next(); 

            while (collectToken.hasNext()) // If item is 2+ words long.
                object += (" " + collectToken.next());

            evaluateAction(object, action);
        }
        catch (java.util.NoSuchElementException e) {
            GUI.out("Type an action and an object.");
        } 
    }
    // ======================================================================== 
    /**
     * Processes a player's action on furniture.
     * Player may use 'it' or 'them' to reference the last entered furniture.
     * @param object the name of the furniture being acted upon.
     * @param action the action the player is performing on the furniture.
     * @param map a reference to the game map.
     */
    private static void evaluateAction(String object, String action) {
        if (object.matches("it|them")) // Indefinite reference.
            object = GUI.parsePreviousFurniture();
        
        if (getPos().hasFurniture(object)) {                             
            Furniture target = getFurnRef(object);

            if (target.actKeyMatches(action)) {
                GUI.out(target.interact(action)); 
                describeRoom();
            }
            else if (action.matches("c|check|look|view|inspect|watch")) 
                GUI.out(target.getDescription()); 

            else if (action.matches("search|e|s") || 
                    (action.equals("open") && target instanceof Openable))                    
                search(target);
            
            else
                GUI.out("That seems unnecessary.");
        }   
        else 
            GUI.out("There is no " + object + " here."); 
        
        GUI.invOut("You are carrying:\n" + Player.inv);
    }
    // ========================================================================  
    private static void checkOutSub() {
        GUI.menOut("\n\n<object> Look at...\n< > Back\n");
        
        String checkThis = GUI.promptOut();
        
        if (! checkThis.matches(""))
            checkOut(checkThis);
    }
    // ========================================================================
    /**
     * Processes player input to inspect an object.
     * Player may use 'it' or 'them' to reference the last entered furniture.
     * @param inspecting object name the player wants to inspect.
     */
    private static void checkOut(String inspecting) {
        if (inspecting.matches("it|them")) // Indefinite reference.
            inspecting = GUI.parsePreviousFurniture();
        
        if (getPos().hasFurniture(inspecting))
            GUI.out(Player.getFurnRef(inspecting).getDescription());
        else 
            GUI.out("There is no " + inspecting + " here.");
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
   
//******************************************************************************    
// <editor-fold desc="INVENTORY ACTIONS">      
//******************************************************************************    
    private static void inventoryPrompt() {
        GUI.invOut("You are carrying:\n" + Player.inv);
        AudioPlayer.playEffect(1);
        String ans;
        
        do {
            GUI.menOut("\n<'1'> Inspect item"
                     + "\n<'2'> Use item" + 
                       "\n<'3'> Combine items"
                     + "\n    < > Back");
            
            ans = GUI.promptOut();
            
            if (ans.matches("[123]")) {
                switch(Integer.parseInt(ans)) {
                    case 1:
                        inspectPrompt(); break;
                    case 2:
                        usePrompt(); break;
                    default:
                        combineSub();
                }
                GUI.invOut("You are carrying:\n" + Player.inv);
            } 
            else if (! ans.matches(""))
                GUI.out("Enter a valid choice.");
            
        } while (! ans.matches(""));
        
        GUI.clearDialog();
    }
    // ========================================================================  
    private static void inspectPrompt() {
        String ans;            
        
        do {
            GUI.menOut("\n<#> Inspect...\n< > Back");
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
    private static void usePrompt() {
        String choice;
        
        do { 
            GUI.menOut("\n<#> Use...\n< > Back");
            choice = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(choice);
                Item item = Player.inv.get(slot - 1);
                int useID = item.getUseID();
                evalUse(useID, item);
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
    private static void evalUse(int useID, Item item) {
        switch (useID) {
            case 1:
                GUI.out(item.useEvent()); break;           
            case 2:
                GUI.menOut("\n<object> Use on...\n< > Back");

                String ans = GUI.promptOut();

                if (getPos().hasFurniture(ans)) {                 
                    Furniture target = getFurnRef(ans);

                    if (target.useKeyMatches(item.toString())) {
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
    // ========================================================================  
    /**
     * Prompts the player for a list of itemList, verifies it and moves to evalCombine().
     * A list is valid if it contains exactly 2 or 3 valid item in the
     * player's inventory.
     */
    private static void combineSub() {
        String combineThese;
        Scanner tokens;
        GUI.menOut("\n<#,#,(#)> Combine...\n< > Back");
        
        do {
            combineThese = GUI.promptOut();
            tokens = new Scanner(combineThese).useDelimiter("\\s*,\\s*");

            Item[] list = getTokenList(tokens);
            
            if (! combineThese.matches("")) {
                if (list.length == 2 || list.length == 3)
                    evalCombine(list);
                else {
                    switch (list.length) {
                        case 0:
                            GUI.out("Enter a valid slot number."); break;
                        case 1:
                            GUI.out("You must enter 2 or 3 items."); break;
                        default:
                            GUI.out("You entered too many items.");
                    }
                }    
            }
            tokens.close();  
        } while (! combineThese.matches(""));        
    }
    // ======================================================================== 
    /**
     * Receives a valid list of 2 or 3 itemList for a combine attempt and
     * verifies that it is a correct combine set.
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
        else {
            switch (list.length) {
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
    }
    // ========================================================================  
    /**
     * Returns a list of itemList that the player is trying to combine and catches
     * errors in the player's syntax.
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
            if (i.getForms().equals("nothing") || ! i.getForms().matches(combinesTo))
                return false;
        } 
        return true;
    }   
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}


