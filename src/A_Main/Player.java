package A_Main;

import static A_Main.NameConstants.*;
import static A_Main.Patterns.*; 
import A_Super.*;

import java.util.Scanner;           import java.util.ArrayList;
import java.util.HashMap;           import java.io.IOException;
import Tunnels.DungeonMonster;      import java.io.Serializable;
import java.io.ObjectOutputStream;  import java.util.HashSet;
import java.util.Iterator;
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
    private static Inventory keys;
    private static PlayerInventory inv;
    private static ArrayList<String> visited;
    private static String lastVisited, shoes;
    private static final HashMap<String, Runnable> CMDS = new HashMap<>(); 
    private static final HashSet<String> CMDSET = new HashSet<>(); 
    private static final String NOT_VALID_SLOT = "Enter a valid slot number.";
    
    static {
        CMDS.put("h", () -> Help.helpSub());
        CMDS.put("e", () -> searchSub());
        CMDS.put("c", () -> examineSub());
        CMDS.put("k", () -> viewKeyRing());
        CMDS.put("i", () -> inventoryPrompt());
        CMDS.put("w", () -> move(Direction.NORTH));
        CMDS.put("s", () -> move(Direction.SOUTH));
        CMDS.put("a", () -> move(Direction.WEST));
        CMDS.put("d", () -> move(Direction.EAST));
        CMDS.put("m", () -> Map.displayMap());
        CMDS.put("n", () -> writeNote());
        
        CMDS.put("inspect",   () -> examineSub());
        CMDS.put("examine",   () -> examineSub());
        CMDS.put("keys",      () -> viewKeyRing());
        CMDS.put("keyring",   () -> viewKeyRing());
        CMDS.put("inventory", () -> inventoryPrompt());
        CMDS.put("search",    () -> searchSub());
        CMDS.put("help",      () -> Help.helpSub());
        CMDS.put("save",      () ->  { Main.saveGame(); GUI.out("Game saved"); });
        CMDS.put("combine",   () -> combineSub());
        CMDS.put("jump",      () -> GUI.out("You jump a short height into the air. Well, that was fun."));
        CMDS.put("sort",      () -> getInv().sortInventory());
        CMDS.put("map",       () -> Map.displayMap());
        CMDS.put("note",      () -> writeNote());
        CMDS.put("write",     () -> writeNote());
        
        CMDSET.addAll(CMDS.keySet());
    }
    
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="ACCESSORS AND OUTPUT">  
//******************************************************************************
    // <editor-fold desc="Accessors">
    /**
     * Converts a string of a piece of furniture to its object equivalent.
     * This should never return null. Furniture is checked for existence
     * before calling this method.
     * @param name The name of a piece of furniture in your location.
     * @return The furniture objects with the name.
     */
    public static Furniture getFurnRef(String name) {
        for(Furniture furn : getPos().getFurnishings()) {
            if (furn.nameKeyMatches(name))
                return furn;           
        }
        return null;
    }
    /*------------------------------------------------------------------------*/   
    public static String getLastVisited() {
        return Player.lastVisited;
    }
    /*------------------------------------------------------------------------*/ 
    public static PlayerInventory getInv() {
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
    public static String getPosId() {
        return Player.getPos().getID();
    }
    /*------------------------------------------------------------------------*/
    public static Room getRoomObj(String ID) {
        int[] c = RoomGraph.getCoords(ID);
        return mapRef[c[0]][c[1]][c[2]];
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
    public static int floor() {
        return pos[0];
    }
    /*------------------------------------------------------------------------*/
    /**
     * Checks that you have a specific item, ignores case.
     * @param item The item in question.
     * @return If you have the item.
     */
    public static boolean hasItem(String item) {
        return Player.inv.contents().stream().
                anyMatch(i -> i.toString().equalsIgnoreCase(item));
    }
    /*------------------------------------------------------------------------*/
    /**
     * Checks if the player has an item who's name contains the given word.
     * @param item A word the player types in to refer to an item in his or
     * her inventory.
     * @return if the player has an item who's name resembles item.
     */
    public static boolean hasItemResembling(String item) {
        if (Patterns.DIGIT.matcher(item).matches()) {
            // Player used a slot number and not a name
            int i = Integer.parseInt(item);
            return (i <= Player.inv.size());
        }
        else
            // Player typed in an item name
            return Player.inv.contents().stream().
                anyMatch(i -> i.toString().matches(NO_LETTER_BEFORE + item + NO_LETTER_AFTER));
    }
    // </editor-fold>
    
    // <editor-fold desc="Setters">
    public static void setOccupies(String dest) {
        Player.lastVisited = getPosId();
        Player.pos = Player.getRoomObj(dest).getCoords();
        Map.updateMap();
        
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
    
    // <editor-fold desc="Save Player Attributes">
    public static void savePlayerAttributes(ObjectOutputStream stream) 
            throws IOException 
    {
        stream.writeObject(new PlayerAttributes());
    }
    // </editor-fold>
//******************************************************************************    
// </editor-fold>  
//******************************************************************************


//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="START GAME"> 
//******************************************************************************
    public static void loadAttributes(Object attr) throws ClassCastException {
        PlayerAttributes attributes = (PlayerAttributes)attr;
        
        Player.mapRef = attributes.MAP;
        Player.inv = attributes.INV;
        Player.keys = attributes.KEYS;
        Player.pos = attributes.POS;
        Player.visited = attributes.VISITED;
        Player.lastVisited = attributes.LSTVISITED;
        Player.shoes = attributes.SHOES;

        if (pos[0] == 4 && pos[2] < 7) // Starts monster if player is in the 
            DungeonMonster.startMovement(); // tunnel area.
    }
    // ========================================================================  
    /**
     * Creates new attributes that the player starts a new game with.
     * @param coords Coordinates the player begins the game at.
     */
    public static void setNewAttributes(int ... coords) {
        Player.mapRef = Map.createMap();
        Player.inv = new PlayerInventory();
        Player.keys = new Inventory();
        Player.visited = new ArrayList<>();
        Player.pos = coords;
        Player.lastVisited = "";
        Player.shoes = "";
    }
    // ========================================================================  
    /**
     * This dialog prints at the start of a new game.
     */
    public static boolean startDialog() {
        AudioPlayer.playTrack(Id.ENDG);
        
        GUI.menOut("\n\nPress enter...");
        GUI.out("It's 10:00pm, the night is clear and warm.\n" +
                "You have just arrived on foot to your destination, and\n" +
                "find it even more colossal than what you had\n" +
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
     */
    public static boolean mainPrompt() {
        AudioPlayer.playTrack(getPosId());

        printInv();
        
        GUI.roomOut(getPos().triggeredEvent());
        describeRoom();
        
        String ans;
        
        while (true) {
            while (TextParser.moreCommands()) 
                // Ensures all chained-together commands are executed.
                TextParser.performNextCommand();
            
            GUI.toMainMenu();
            ans = GUI.promptOut();

            if (CMDSET.contains(ans)) 
                CMDS.get(ans).run();

            else if(ans.equals("quit") || ans.equals("q"))
                break;
            
            else if (isNonEmptyString(ans)) // Interacting
                TextParser.processText(ans);
        }
        
        return endGame();
    }  
    // ========================================================================   
    private static boolean endGame() {
        String ans = GUI.askChoice(Menus.SAVE_QUIT, "[sqr]");
        
        if (ans.equals("s")) {
            Main.saveGame();
            return false;
        }
        else 
            return ans.equals("r");
    }
    // ======================================================================== 
    public static boolean isNonEmptyString(String playerInput) {
        return (! playerInput.equals(""));
    }
//******************************************************************************        
// </editor-fold> 
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="MOVEMENT AND ROOMS">    
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
     * The movement algorithm for moving the player.
     * Two rooms are considered not to have a door between them if the first
     * three characters of their IDs are identical. An exception is made for 
     * caves and catacombs, which have no doors. Stairs and ladders move the
     * player up and down, and no sound is played here for them.
     * 
     * @param dir A cardinal direction.
     */
    public static void move(Direction dir) {  
        Room dest = mapRef[pos[0] + dir.Z][pos[1] + dir.Y][pos[2] + dir.X];
        
        if (! getPos().isAdjacent(dest.getID()))
            // There's a non-door barrier in the way
            GUI.out(getPos().getBarrier(dir));
              
        else if (dest.isThisLocked() && ! hasKey(dest.getID())) {
            // Destination is locked and player doesn't have a key.
            AudioPlayer.playEffect(4);
            GUI.out("The door here is locked."); 
        }
        else { 
            // Moves the player, determines the noise to play.
            GUI.clearDialog();
            lastVisited = getPosId();
            Player.pos = dest.getCoords();
            String destId = dest.getID();
            Map.updateMap();

            if (dir == Direction.UP || dir == Direction.DOWN)
                ; // Do nothing. Let the stairs play the noise.
            
            else if (dest.isThisLocked() && ! visited.contains(destId))
                AudioPlayer.playEffect(13); // Plays unlock sound.
            
            else if (Player.pos[0] < 5  && // If you're not in catacombs or caves.
                     ! Id.areaName(destId).matches(Id.areaName(lastVisited))) 
            {
                if (Player.pos[0] == 4 || CS35_CT34_P.matcher(destId).matches())
                    // Checks if player is in dungeon area- metal door sound.
                    AudioPlayer.playEffect(24);  
                else
                    AudioPlayer.playEffect(9); // Wooden door sound. 
            }

            else if (Player.pos[0] >= 5  &&
                    ! destId.substring(0,2).matches(lastVisited.substring(0,2)))
                // Plays wooden door sound in catacombs.
                AudioPlayer.playEffect(9); 
            
            else
                AudioPlayer.playEffect(0); // Plays footsteps. No door there
            
            describeRoom();
            GUI.roomOut(dest.triggeredEvent());
            
            if (! hasVisited(destId)) 
                visited.add(destId);  
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
// <editor-fold defaultstate="collapsed" desc="KEYS">      
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
// <editor-fold defaultstate="collapsed" desc="SEARCHING">   
//******************************************************************************    
    private static void searchSub() {
        // Initiates dialog asking player for a Furniture to search.
        GUI.menOut(Menus.SEARCH_SUB);
        String searchThis = GUI.promptOut();
        
        if (isNonEmptyString(searchThis) && getPos().hasFurniture(searchThis)) {
            search(getFurnRef(searchThis));
        }
        else if (IT_THEM_P.matcher(searchThis).matches() && 
                getPos().hasFurniture(searchThis = GUI.parsePreviousFurniture())) 
        {   // Player used "it" or "them" in place of a furniture name.
            search(getFurnRef(searchThis));
        }
        else if (GEN_FURNITURE_P.matcher(searchThis).matches()) {
            GUI.out("There are too many things in the room. Specify your intention.");
        }
        else if (isNonEmptyString(searchThis)) {
            GUI.out("There is no " + searchThis + " here."); 
        }
        else ; // Go back to main menu
    }    
    // ========================================================================  
    /**
     * Subroutine entered after a searchable furniture is searched.
     * Serves to block access from trading itemList with non searchable furniture.
     * @param furniture The furniture being searched.
     */
    public static void search(Furniture furniture) {
        GUI.out(furniture.getSearchDialog());
        
        if (furniture.isSearchable())
            searchPrompt(furniture); 
    } 
    // ========================================================================  
    /**
     * Subroutine for exchanging itemList between player and furniture inventories.
     * @param furniture The furniture being searched.
     */
    private static void searchPrompt(Furniture furniture) {
        String cmdItm; 
        
        do {
            printInv(furniture.getInv());
            GUI.menOut(Menus.TRADE_SUB);
            
            cmdItm = GUI.promptOut();
            
            if (cmdItm.equals("loot") || cmdItm.equals("l")) {
                ArrayList<Item> l = new ArrayList<>();
                
                for (Item i : furniture.getInv()) {
                    if (! Player.inv.contains(i))
                        l.add(i);
                }
                for (Item i : l) {
                    evalTake(furniture, i);
                }
                GUI.out("You stuff as much as you can into your pockets.");
            }
            else {
                try (Scanner collectToken = 
                        new Scanner(cmdItm).useDelimiter("\\s+")) 
                {
                    String action = collectToken.next();            
                    int slot = Integer.parseInt(collectToken.next());

                    if (STORE_P.matcher(action).matches()) {
                        Item item = Player.inv.get(slot - 1);
                        evalStore(furniture, item);                            
                    }            
                    else if (TAKE_P.matcher(action).matches()) {
                        Item item = furniture.getInv().get(slot - 1);
                        evalTake(furniture, item);
                    }
                    describeRoom();
                    printInv();
                }
                catch (java.lang.IndexOutOfBoundsException e) {
                    GUI.out("There's no item in that slot.");
                }
                catch (java.util.NoSuchElementException 
                        | java.lang.NumberFormatException e) 
                {
                    if (isNonEmptyString(cmdItm))
                        GUI.out("Type an action and the slot number."); 
                }
            }
        } while (isNonEmptyString(cmdItm));
        
        printInv();
    }
    // ========================================================================  
    /**
     * Evaluates the player's take action.
     * @param furniture The furniture from which to take an item.
     * @param take The item being taken.
     */
    private static void evalTake(Furniture furniture, Item take) {
        if (KEY_P.matcher(take.getType()).matches()) {
            // Matches a non-cave/catacomb room ID, which keys use as types.
            addToKeyRing(take, furniture);
            AudioPlayer.playEffect(3);
            GUI.out("You put the " + take + " into your key ring.");
        }
        else {
            GUI.out("You take the " + take);
            furniture.getInv().give(take, Player.inv);                 
        }   
    }
    // ========================================================================  
    /**
     * Evaluates the player's store action.
     * @param furniture The furniture in which the item is being stored.
     * @param store The item being stored.
     */
    public static void evalStore(Furniture furniture, Item store) {
        if (store.getType().equals("phylactery"))
            GUI.out("The " + store + " looks too important to get rid of.");

        else {
            GUI.out("You store the " + store);
            Player.inv.give(store , furniture.getInv()); 
            
            if (store.toString().equals(Player.shoes))
                Player.shoes = ""; // If player stores the shoes currently wearing.
        }
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold defaultstate="collapsed" desc="ACTIVATING AND INSPECTING">  
//****************************************************************************** 
    /**
     * Processes a player's action on furniture.
     * Player may use 'it' or 'them' to reference the last entered furniture.
     * @param object the name of the furniture being acted upon.
     * @param action the action the player is performing on the furniture.
     */
    public static void evaluateAction(String action, String object) {
        if (WALK_P.matcher(action).matches() && 
            DIRECTION_P.matcher(object).matches()) 
        {
            // Player typed something resemling "walk <direction>"
            // The direction in this case is pretending to be furniture.
            parseMovement(object);
        }
        else if (getPos().hasFurniture(object) || 
                (IT_THEM_P.matcher(object).matches() && 
                getPos().hasFurniture(object = GUI.parsePreviousFurniture()))) 
            // In this case, a valid furniture exists to be interacted with.
        {    
            Furniture target = getFurnRef(object);

            if (target.actKeyMatches(action)) {
                // Player typed an action specific to a furniture type.
                GUI.out(target.interact(action)); 
                describeRoom();
                printInv();
            }
            else if (CHECK_P.matcher(action).matches()) {
                // Player typed something resembling "examine <furniture>"
                GUI.out(target.getDescription()); 
            }
            else if (SEARCH_P.matcher(action).matches() || 
                    (action.equals("open") && target instanceof Openable)) 
            {              
                // Player typed something implying a search on furniture
                search(target);
            }
            else if (MOVE_P.matcher(action).matches() 
                    && target instanceof Moveable) 
            {
                // Player typed something resembling "move <furniture>"
                GUI.out(((Moveable)target).moveIt());
            }
            else
                GUI.out("That seems unnecessary.");
        }   
        
        else if (GEN_FURNITURE_P.matcher(object).matches())
            // Player used a very vague term to interact with.
            GUI.out("Be more specific.");
        
        else // Something invalid was entered in!
            GUI.out("There is no " + object + 
                    " here that you can see. Or perhaps we are being lazy and\n"
                  + "attempting to pick up items without searching something first?"); 
    }
    // ========================================================================  
    private static void parseMovement(String dir) {
        if (NORTH_P.matcher(dir).find())
            Player.move(Direction.NORTH);
        
        else if (SOUTH_P.matcher(dir).find())
            Player.move(Direction.SOUTH);
        
        else if (EAST_P.matcher(dir).find())
            Player.move(Direction.EAST);
        
        else if (WEST_P.matcher(dir).find())
            Player.move(Direction.WEST);
        
        else if (UP_P.matcher(dir).find()) {
            findStaircase(Direction.UP);
        }
        else {
            findStaircase(Direction.DOWN);
        }
    }
    // ========================================================================  
    private static void findStaircase(Direction dir) {
        Iterator<Furniture> iter = Player.getPos().getFurnishings().iterator();
        
        while (iter.hasNext()) {
            Furniture current = iter.next();

            if (current instanceof A_Super.DoubleStaircase) {
                GUI.out(((A_Super.DoubleStaircase)current).interact(dir));
                return;
            }
            if (current instanceof A_Super.Staircase 
                && ((A_Super.Staircase)current).getDir() == dir) {
                GUI.out(current.interact("climb"));
                return;
            }
            if (current instanceof Climbable) {
                GUI.out(current.interact("climb"));
                return;
            }
        }
        GUI.out("There's nothing here to take you that way.");
    }
    // ========================================================================  
    private static void examineSub() {
        GUI.menOut(Menus.EXAMINE_SUB);
        
        String checkThis = GUI.promptOut();
        
        if (isNonEmptyString(checkThis))
            examine(checkThis);
    }
    // ========================================================================
    /**
     * Processes player input to inspect an object.
     * Player may use 'it' or 'them' to reference the last entered furniture.
     * @param inspecting object name the player wants to inspect.
     */
    private static void examine(String inspecting) {
        if (IT_THEM_P.matcher(inspecting).matches()) // Indefinite reference.
            inspecting = GUI.parsePreviousFurniture();
        
        if (getPos().hasFurniture(inspecting))
            GUI.out(Player.getFurnRef(inspecting).getDescription());
        
        else if (GEN_FURNITURE_P.matcher(inspecting).matches())
            GUI.out("Be more specific.");
        
        else 
            GUI.out("There is no " + inspecting + " here.");
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
   
//******************************************************************************    
// <editor-fold defaultstate="collapsed" desc="INVENTORY ACTIONS">      
//******************************************************************************    
    public static void printInv() {
        GUI.invOut("You are carrying:\n" + Player.inv);
    }
    // ========================================================================  
    private static void printInv(Inventory furnInv) {
        GUI.invOut("You find:\n" + furnInv + "\nYou are carrying:\n" + Player.inv);
    }
    // ========================================================================  
    private static void inventoryPrompt() {
        printInv();
        AudioPlayer.playEffect(1);
        String ans;
        
        do {
            GUI.menOut(Menus.INV_MAIN);
            
            ans = GUI.promptOut();
            
            if (INV_CHOICE_P.matcher(ans).matches()) {
                switch(Integer.parseInt(ans)) {
                    case 1:
                        inspectPrompt(); break;
                    case 2:
                        usePrompt(); break;
                    case 3:
                        combineSub(); break;
                    case 4:
                        getInv().sortInventory(); break;
                    default:
                        writeNote();
                }
            } 
            else if (isNonEmptyString(ans))
                GUI.out("Enter a valid choice.");
            
        } while (isNonEmptyString(ans));
        
        GUI.clearDialog();
    }
    // ========================================================================  
    private static void inspectPrompt() {
        String ans;            
        
        do {
            GUI.menOut(Menus.INV_INSPECT);
            ans = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(ans);
                Item item = Player.inv.get(slot - 1);
                GUI.out(item.getDesc());  
            }
            catch (java.lang.NumberFormatException | java.lang.IndexOutOfBoundsException e) {
                if (isNonEmptyString(ans)) 
                    GUI.out(NOT_VALID_SLOT);
            }
        } while (isNonEmptyString(ans));
        
        GUI.clearDialog();
    }
    // ========================================================================  
    private static void usePrompt() {
        String choice;
        
        do {      
            GUI.menOut(Menus.INV_USE);
            choice = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(choice);
                Item item = Player.inv.get(slot - 1);
                int useID = item.getUseID();
                switch (useID) {
                    case 1:
                        GUI.out(item.useEvent()); 
                        break;           
                    case 2:
                        GUI.menOut(Menus.INV_USEON);
                        evalUse(item, GUI.promptOut());
                }
            }
            catch (java.lang.NumberFormatException | java.lang.IndexOutOfBoundsException e) {
                if (isNonEmptyString(choice))
                    GUI.out(NOT_VALID_SLOT);
            }  
        } while (isNonEmptyString(choice));
    }
    // ========================================================================  
    /**
     * Subroutine entered into when an item is used from the player's inventory.
     * @param furniture Furniture the item is being used on.
     * @param item The item being used
     */
    public static void evalUse(Item item, String furniture) {
        if (getPos().hasFurniture(furniture)) {                 
            Furniture target = getFurnRef(furniture);

            if (target.useKeyMatches(item.toString())) {
                GUI.out(target.useEvent(item));
                describeRoom();
                printInv();
            }
            else
                GUI.out("You jam the " + item + " into the " + furniture +
                        "\nas hard as you can, but nothing happens.");
        }                      
        else if (isNonEmptyString(furniture)) 
            GUI.out("There is no " + furniture + " here."); 
        
        printInv();
    }
    // ======================================================================== 
    /**
     * Allow the player to write a note to itself. This can only be done if the
     * player has the notepad and a pen.
     */
    public static void writeNote() {
        if (! Player.hasItem(PEN)) 
            GUI.out("You will need a pen in order to write a note to yourself.");
        else if (! Player.hasItem(NOTEPAD)) 
            GUI.out("You will need some paper in order to write a note to yourself.");
        else {
            GUI.menOut("\nWrite a title "
                     + "\nfor your note: ");
            String title = GUI.promptOut();
            
            while (! isNonEmptyString(title)) {
                GUI.menOut("\nI beg your "
                         + "\npardon? Write "
                         + "\na valid title:");
                title = GUI.promptOut();
            }
            
            GUI.menOut("Noted. Write down\n"
                     + "your momento now...");
            
            String body = GUI.promptOut();
            
            GUI.out("Note has been written.");
            
            Player.inv.contents().add(new Note(
                    "note - " + title + ':' + ' ', body)
            );
            
            printInv();
        }
    }
    // ========================================================================  
    // <editor-fold desc="COMBINE SUBROUTINES">
    /**
     * Prompts the player for a list of items, verifies it and moves to evalCombine().
     * A list is valid if it contains exactly 2 or 3 valid item in the
     * player's inventory.
     */
    private static void combineSub() {
        String combineThese;
        Scanner tokens;
        GUI.menOut(Menus.INV_COMBINE);
        
        do {
            combineThese = GUI.promptOut();
            tokens = new Scanner(combineThese).useDelimiter("\\s*,\\s*");

            if (isNonEmptyString(combineThese)) {
                validateList(getTokenList(tokens));
            }
            
            tokens.close();  
        } while (isNonEmptyString(combineThese));        
    }
    // ======================================================================== 
    /**
     * Does the same as combineSub() but with a starting string as input.
     * For use from the main prompt.
     */
    public static void combineSub(String input) {
        String items = input.replaceFirst("combine\\s+", "");
        
        try (Scanner tokens = new Scanner(items).useDelimiter("\\s*,\\s*")) {
            validateList(getTokenList(tokens));
        }
    }
    // ======================================================================== 
    /**
     * Validates the correctness of a list of items to combine generated by the
     * player.
     * @param list a variable-length list of items.
     */
    private static void validateList(Item[] list) {
        if (list.length == 2 || list.length == 3)
            evalCombine(list);
        else switch (list.length) {
            case 0:
                GUI.out(NOT_VALID_SLOT); 
                break;
            case 1:
                GUI.out("You take a moment to ponder how to combine an item with itself."); 
                break;
            default:
                GUI.out("You possess the skill to combine only 2 or 3 items at a time.");
        }    
    }
    // ======================================================================== 
    /**
     * Receives a valid list of 2 or 3 items for a combine attempt and
     * verifies that it is a correct combine set.
     * @param list a list of 2 or 3 items.
     */
    private static void evalCombine(Item[] list) {
        if (allCombineToSame(list)) { 
            if (list[0].getThreshold() == list.length) {
                GUI.out(Player.inv.combine(list, list[0].forms())); 
                printInv();
            }
            else // 2 objects are correct, but 1 is missing.
                GUI.out("You need something else for this to work."); 
        }
        else
            switch (list.length) {
                case 2: // Player entered 2 items that don't combine.
                    GUI.out("You push them together as hard as you can,\n" +
                            "but it does nothing."); 
                    break;
                case 3: // Player entered 3 items, some of which may combine.
                    GUI.out("You are pretty sure all these don't go together."); 
            } 
    }
    // ========================================================================  
    /**
     * Returns a list of items that the player is trying to combine and catches
     * errors in the player's syntax.
     * @param tokenizer A scanner holding the list of player entries
     * @return A list of items the player wants to combine.
     */
    private static Item[] getTokenList(Scanner tokenizer) {
        ArrayList<Item> itemList = new ArrayList<>(3);
        
        try {
            while (tokenizer.hasNext()) {                                                                            
                int slot = Integer.parseInt(tokenizer.next());
                Item item = Player.inv.get(slot - 1);
                
                if (! itemList.contains(item)) // Prevents adding duplicates.
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
     * Checks that all the items in the list combine into the same object.
     * @param itemList A list of items
     * @return If the items combine into the same object.
     */
    private static boolean allCombineToSame(Item[] itemList) {
        Item forms = itemList[0].forms();
        String combinesTo;
        
        if (forms == null)
            return false;
        else
            combinesTo = forms.toString();

        for (Item i : itemList) {
            if (i.forms() == null || 
                    ! i.forms().toString().equals(combinesTo))
                return false;
        } 
        return true;
    }   
    // </editor-fold>
    // ======================================================================== 
    
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold defaultstate="collapsed" desc="PLAYER ATTRIBUTES CLASS">  
//******************************************************************************
    /**
     * This class holds all the attributes of the player to be serialized out to a file.
     * When a game starts, if save game data exists, the serialized instance of this
     * is read in and used as a template to form the player.
     * 
     * @author Kevin Rapa
     */
    private static final class PlayerAttributes implements Serializable {
        public final Room[][][] MAP;
        public final int[] POS;
        public final Inventory KEYS; 
        public final PlayerInventory INV; 
        public final ArrayList<String> VISITED; 
        public final String LSTVISITED, SHOES; 
    // ========================================================================
        public PlayerAttributes() {
            this.MAP = Player.mapRef;
            this.POS = Player.pos;
            this.INV = Player.inv;
            this.KEYS = Player.keys;
            this.LSTVISITED = Player.lastVisited;
            this.SHOES = Player.shoes;
            this.VISITED = Player.visited;
        }
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}
