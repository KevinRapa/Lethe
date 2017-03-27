package A_Main;

import static A_Main.Names.*;
import static A_Main.Patterns.*; 
import A_Super.*;
import Foyer.LootSack;

import java.util.Scanner;           import java.util.ArrayList;
import java.util.HashMap;           import java.io.IOException;
import Tunnels.DungeonMonster;      import java.io.Serializable;
import java.io.ObjectOutputStream;  import java.util.HashSet;
import java.util.LinkedList;
/**
 * Represents the player, the focal point of the game.
 * All player actions originate from this class. The player has access
 * to its own location, and thereby each furniture and item in the location
 * too.
 * 
 * The text parser and player attributes class are nested inside this class
 * because of their close relationship with Player.
 * 
 * @author Kevin Rapa
 */
public final class Player {
    private static Room[][][] mapRef;         // Game map reference
    private static Inventory keys;            // Player inventory (for keys)
    private static PlayerInventory inv;       // Player inventory
    private static ArrayList<String> visited; // Rooms the player has visited so far
    private static boolean notEnd = true;     // Game ends when this is false
    private static int 
        pos[], // Integer coordinates of the player in the map
        moves, // How many valid moves the player has made
        score; // Worth of items in the player's loot sack
    
    private static String 
        lastVisited,        // Id of the last room the player was in
        shoes,              // Name of the shoes the player wears
        lastItem = "",      // Last item the player interacted with
        lastFurniture = ""; // Last furniture the player interacted with.

    private static final HashMap<String, Runnable> 
        MAIN_CMDS = new HashMap<>(),    // Maps commands from main prompt
        INV_CMDS = new HashMap<>(),     // Maps commands from inventory
        ODD_CMD_KEYS = new HashMap<>(); // Maps random commands
    
    private static final HashSet<String> 
        MAIN_CMD_SET = new HashSet<>(), // Commands from the main prompt
        INV_CMD_SET = new HashSet<>(),  // Commands from the inventory
        ODD_CMD_SET = new HashSet<>();  // Random commands
    
    private static final String 
        ERRONEOUS_INPUT = "I think I may have misunderstood you on something...",
        VERSION = "This is Lethe / Author: Kevin Rapa / Written on Netbeans 8.1 "
                + "/ Sounds obtained from freesound.org / Last modified: 3/24/2017",
        DENIAL_MSGS[] = {
            "That is quite an ambitious proposition.", "A valiant attempt.", 
            "Did you have much to drink before you came?", "A novel concept!",
            "An ingenious idea from one of your education.",
            "The player is thwarted in the ridiculous attempt."};

    // <editor-fold defaultstate="collapsed" desc="MAPPINGS">
    // Maps various commands in the game to their actions.
    // Adds the keys to a set which is consulted whenever 
    // the player enters something.
    static {
        MAIN_CMDS.put("h", () -> Help.helpSub());
        MAIN_CMDS.put("k", () -> viewKeyRing());
        MAIN_CMDS.put("i", () -> inventoryPrompt());
        MAIN_CMDS.put("w", () -> move(Direction.NORTH));
        MAIN_CMDS.put("s", () -> move(Direction.SOUTH));
        MAIN_CMDS.put("a", () -> move(Direction.WEST));
        MAIN_CMDS.put("d", () -> move(Direction.EAST));
        MAIN_CMDS.put("m", () -> Map.displayMap());
        MAIN_CMDS.put("n", () -> writePrompt());
        MAIN_CMDS.put("l", () -> openLootSack());
        MAIN_CMDS.put("q", () -> {notEnd = false;});
        MAIN_CMDS.put("nw", () -> evaluateAction("go", "northwest"));
        MAIN_CMDS.put("ne", () -> evaluateAction("go", "northeast"));
        MAIN_CMDS.put("sw", () -> evaluateAction("go", "southwest"));
        MAIN_CMDS.put("se", () -> evaluateAction("go", "southeast"));

        MAIN_CMDS.put("close",     () -> Map.hideMap());
        MAIN_CMDS.put("quit",      () -> {notEnd = false;});
        MAIN_CMDS.put("version",   () -> GUI.out(VERSION));
        MAIN_CMDS.put("lethe",     () -> GUI.out("Hello, dear."));
        MAIN_CMDS.put("zork",      () -> GUI.out("You must be mistaking me for someone else."));
        MAIN_CMDS.put("keys",      () -> viewKeyRing());
        MAIN_CMDS.put("keyring",   () -> viewKeyRing());
        MAIN_CMDS.put("inventory", () -> inventoryPrompt());
        MAIN_CMDS.put("loot",      () -> openLootSack());
        MAIN_CMDS.put("help",      () -> Help.helpSub());
        MAIN_CMDS.put("scream",    () -> GUI.out("AHHHHHGGGHHH!!!!!"));
        MAIN_CMDS.put("yell",      () -> GUI.out("AHHHHHGGGHHH!!!!!"));
        MAIN_CMDS.put("smell",     () -> GUI.out("Smells like a brisk autumn night in 1932."));
        MAIN_CMDS.put("win",       () -> GUI.out("Oh wait, that's it! You win! Congratulations! You may go home now."));
        MAIN_CMDS.put("combine",   () -> combineSub());
        MAIN_CMDS.put("jump",      () -> GUI.out("You jump a short height into the air. Well, that was fun."));
        MAIN_CMDS.put("sort",      () -> getInv().sortInventory());
        MAIN_CMDS.put("map",       () -> Map.displayMap());
        MAIN_CMDS.put("note",      () -> writePrompt());
        MAIN_CMDS.put("write",     () -> writePrompt());
        MAIN_CMDS.put("wait",      () -> GUI.out("You stand and do nothing."));
        MAIN_CMDS.put("stand",     () -> GUI.out("You stand and do nothing."));
        MAIN_CMDS.put("sit down",  () -> GUI.out("You sit and rest a moment."));
        MAIN_CMDS.put("sit",       () -> GUI.out("You sit and rest a moment."));
        MAIN_CMDS.put("move",      () -> evaluateAction("move", "self"));
        MAIN_CMDS.put("walk",      () -> evaluateAction("move", "self"));
        MAIN_CMDS.put("go",        () -> evaluateAction("move", "self"));
        MAIN_CMDS.put("northwest", () -> evaluateAction("go", "northwest"));
        MAIN_CMDS.put("northeast", () -> evaluateAction("go", "northeast"));
        MAIN_CMDS.put("southwest", () -> evaluateAction("go", "southwest"));
        MAIN_CMDS.put("southeast", () -> evaluateAction("go", "southeast"));
        
        MAIN_CMDS.put("xyzzy",     () -> {
            GUI.out("A hollow clown says surprise."); 
            GUI.randomizeColors();
        });
        MAIN_CMDS.put("save",      () -> { 
            Main.saveGame(); 
            GUI.out("Game saved"); 
        });
        
        MAIN_CMD_SET.addAll(MAIN_CMDS.keySet());
        //---------------------------------------------------------------------
        INV_CMDS.put("1", () -> inspectPrompt());
        INV_CMDS.put("2", () -> usePrompt());
        INV_CMDS.put("3", () -> combineSub());
        INV_CMDS.put("4", () -> getInv().sortInventory());
        INV_CMDS.put("5", () -> writePrompt());
        
        INV_CMD_SET.addAll(INV_CMDS.keySet());
        //---------------------------------------------------------------------

        ODD_CMD_KEYS.put("climb",   () -> GUI.out("Let us act like civilized guests whilst we're here."));
        ODD_CMD_KEYS.put("jump",    () -> GUI.out("Let us act like civilized guests whilst we're here."));
        ODD_CMD_KEYS.put("smell",   () -> GUI.out("You press your nose up against it and inhale deeply."));
        ODD_CMD_KEYS.put("find",    () -> GUI.out("You have already found it detective."));
        ODD_CMD_KEYS.put("count",   () -> GUI.out("You didn't climb all the way up to this precipice to do math."));
        ODD_CMD_KEYS.put("burn",    () -> GUI.out("Yes... burn it... burn it all down to the ground."));
        ODD_CMD_KEYS.put("write",   () -> GUI.out("You are sure the owner wouldn't wanting you doing that."));
        ODD_CMD_KEYS.put("draw",    () -> GUI.out("You are sure the owner wouldn't wanting you doing that."));
        ODD_CMD_KEYS.put("inflate", () -> GUI.out("Does this look like some kind of balloon to you?"));
        ODD_CMD_KEYS.put("deflate", () -> GUI.out("Does this look like some kind of balloon to you?"));
        ODD_CMD_KEYS.put("take",    () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("get",     () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("eat",     () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("fight",   () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("speak",   () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("talk",    () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("lift",    () -> getRandomDenialMsg());
        ODD_CMD_KEYS.put("pick",    () -> getRandomDenialMsg());
        
        ODD_CMD_SET.addAll(ODD_CMD_KEYS.keySet());
    }
    // </editor-fold>
    
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="ACCESSORS AND OUTPUT">  
//******************************************************************************
    // <editor-fold desc="Accessors">
    /**
     * Converts a string of a piece of furniture to its object equivalent.
     * Furniture is checked for existence before calling this method.
     * @param name The name of a piece of furniture in your location.
     * @return The furniture object with the name.
     */
    public static Furniture getFurnRef(String name) {
        for(Furniture furn : getPos().getFurnishings()) {
            if (furn.nameKeyMatches(name))
                return furn;           
        }
        return null;
    }
    /*------------------------------------------------------------------------*/
    private static void getRandomDenialMsg() {
        int i = (int)Math.abs(System.currentTimeMillis()) % DENIAL_MSGS.length;
        GUI.out(Player.DENIAL_MSGS[i]);
    }
    /*------------------------------------------------------------------------*/
    public static String getLastVisited() { return lastVisited; }
    /*------------------------------------------------------------------------*/ 
    public static PlayerInventory getInv() { return inv; }
    /*------------------------------------------------------------------------*/
    public static Inventory getKeys() { return keys; }
    /*------------------------------------------------------------------------*/
    public static Room getPos() { return mapRef[pos[0]][pos[1]][pos[2]]; }
    /*------------------------------------------------------------------------*/
    public static String getPosId() { return getPos().getID(); }
    /*------------------------------------------------------------------------*/
    public static Room getRoomObj(String ID) {
        int[] c = RoomGraph.getCoords(ID);
        return mapRef[c[0]][c[1]][c[2]];
    }
    /*------------------------------------------------------------------------*/
    public static ArrayList<String> getVisitedRooms() { return visited; }
    /*------------------------------------------------------------------------*/
    public static String getShoes() { return Player.shoes; }
    /*------------------------------------------------------------------------*/
    public static int getCurrentFloor() { return pos[0]; }
    /*------------------------------------------------------------------------*/
    public static int getScore() { return score; }
    /*------------------------------------------------------------------------*/
    // If the argument equals "it/them" returns the last referenced furniture.
    public static String tryIndefRef_Furn(String indef) {
        return (IT_THEM_P.matcher(indef).matches()) ? lastFurniture : indef;
    }
    /*------------------------------------------------------------------------*/
    // If the argument equals "it/them" returns the last referenced item.
    public static String tryIndefRef_Item(String indef) {
        return (IT_THEM_P.matcher(indef).matches()) ? Player.lastItem : indef;
    }
    /*------------------------------------------------------------------------*/
    public static boolean hasItem(String itemName) {
        return Player.inv.contents().stream().
                anyMatch(i -> i.toString().equalsIgnoreCase(itemName));
    }
    /*------------------------------------------------------------------------*/
    /**
     * Checks if the player has an item who's name contains the given word.
     * @param itemName A word the player types in to refer to an item in his 
     * or her inventory.
     * @return if the player has an item who's name resembles item.
     */
    public static boolean hasItemResembling(String itemName) {
        return Player.inv.containsItemResembling(itemName);
    }
    // </editor-fold>
    
    // <editor-fold desc="Setters">
    // Sends the player to Hades. A zork reference.
    public static void commitSuicide() {
        if (! getPosId().equals(Id.HADS)) {
            incrementMoves();
            
            GUI.out("You succumb to the surreal, yet all too reachable "
                  + "decision. Could this release you from your hopelessness?"); 
            GUI.menOut(Menus.ENTER);
            GUI.promptOut();

            inv.clear();
            keys.clear();
            setOccupies(Id.HADS);
            printInv();
        }
        else
            GUI.out("You can't do even that.");
    }
    /*------------------------------------------------------------------------*/
    /**
     * 'Teleports' the player to another room.
     * @param id destination area.
     */
    public static void setOccupies(String id) {
        Player.lastVisited = getPosId();
        Player.pos = Player.getRoomObj(id).getCoords();
        Map.updateMap();
        
        describeRoom();
        GUI.roomOut(Player.getPos().triggeredEvent());
        
        if (! Player.hasVisited(getPosId())) 
            Player.visited.add(getPosId()); 
    }
    /*------------------------------------------------------------------------*/
    public static void setLastInteract_Furn(String furnName) {
        Player.lastFurniture = furnName;
    }
    /*------------------------------------------------------------------------*/
    public static void setLastInteract_Item(String itemName) {
        Player.lastItem = itemName;
    }
    /*------------------------------------------------------------------------*/
    public static void setShoes(String shoes) {
        Player.shoes = shoes;
    }
    /*------------------------------------------------------------------------*/
    public static void incrementMoves() {
        GUI.updateMovesAndScore(++Player.moves, Player.score);
    }
    /*------------------------------------------------------------------------*/
    public static void updateScore(int score) {
        GUI.updateMovesAndScore(Player.moves, Player.score = score);
    }
    // </editor-fold>
    
    // Writes fields to a .data file to be read next time a game starts.
    public static void savePlayerAttributes(ObjectOutputStream stream) 
            throws IOException 
    {
        stream.writeObject(new PlayerAttributes());
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************


//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="START GAME"> 
//******************************************************************************
    /**
     * Sets this class's fields to the saved player attributes.
     * @param attr PlayerAttributes object
     * @throws ClassCastException 
     */
    public static void loadAttributes(Object attr) throws ClassCastException {
        PlayerAttributes attributes = (PlayerAttributes)attr;
        
        Player.mapRef = attributes.MAP;
        Player.inv = attributes.INV;
        Player.keys = attributes.KEYS;
        Player.pos = attributes.POS;
        Player.visited = attributes.VISITED;
        Player.lastVisited = attributes.LSTVISITED;
        Player.shoes = attributes.SHOES;
        Player.score = attributes.SCORE;
        Player.moves = attributes.MOVES;
        GUI.updateMovesAndScore(Player.moves, Player.score);

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
        Player.moves = score = 0;
        Player.shoes = "";
        GUI.updateMovesAndScore(0, 0);
    }
    // ========================================================================  
    /**
     * This dialog prints at the start of a new game.
     * @return at end of game, if the player wishes to erase save data.
     */
    public static boolean startDialog() {
        AudioPlayer.playTrack(Id.ENDG);
        
        GUI.menOut(Menus.ENTER);
        GUI.out("It's about 10:00pm and a warm, humid breeze passes through the trees. " +
                "You have just arrived on foot to your destination, and " +
                "find it even more colossal than what you had " +
                "expected. It also appears curiously more vacant...");
        GUI.promptOut();    
        GUI.out("You slowly approach until inside the front gateway. " +
                "A thought briefly flashes in your mind before being " +
                "forgotten - what was your business here, again?");     
        GUI.promptOut();
        GUI.out(VERSION);     
        GUI.promptOut();
        GUI.clearDialog();
        
        return mainPrompt();
    }
    // ========================================================================   
    /**
     * The main prompt for controlling the player's moves.
     * @return at end of game, if the player wishes to erase save data.
     */
    public static boolean mainPrompt() {
        AudioPlayer.playTrack(getPosId());
        printInv();
        GUI.roomOut(getPos().triggeredEvent());
        describeRoom();
        
        String ans;

        do {
            GUI.toMainMenu();
            ans = GUI.promptOut();

            if (MAIN_CMD_SET.contains(ans)) // Simple command
                MAIN_CMDS.get(ans).run();
            
            else if (isNonEmptyString(ans)) // More complicated command
                TextParser.processText(ans);
            
        } while (notEnd);
        
        return endGameCode();
    }  
    // ========================================================================   
    // Returns true if game is to be erased.
    private static boolean endGameCode() {
        String ans = GUI.askChoice(Menus.SAVE_QUIT, SAVE_QUIT_RESET_P);
        
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
    // ======================================================================== 
    public static boolean answeredYes(String playerChoice) {
        return playerChoice.equals("yes") || playerChoice.equals("y");
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
     * Moves the player in the specified direction.
     * Two rooms are considered not to have a door between them if the first
     * three characters of their IDs are identical. An exception is made for 
     * caves and catacombs, which have no doors. Stairs and climbables move the
     * player up and down. Nothing else should.
     * @param dir A cardinal direction.
     */
    public static void move(Direction dir) {  
        Room dest = mapRef[pos[0] + dir.Z][pos[1] + dir.Y][pos[2] + dir.X];
        Player.incrementMoves();
        
        if (! getPos().isAdjacent(dest.getID()))
            // There's a non-door barrier in the way
            GUI.out(getPos().getBarrier(dir));
              
        else if (dest.isLocked() && ! hasKey(dest.getID())) {
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

            if (dir == Direction.UP || dir == Direction.DOWN) {
                // Do nothing. Let the stairs play the noise.
            }
            else if (dest.isLocked() && ! visited.contains(destId)) {
                AudioPlayer.playEffect(13); // Plays unlock sound.
            }
            else if (Player.pos[0] < 5  && // If you're not in catacombs or caves.
                     ! Id.areaName(destId).equals(Id.areaName(lastVisited))) 
            {
                if (Player.pos[0] == 4 || CS35_CT34_P.matcher(destId).matches())
                    // Checks if player is in dungeon area- metal door sound.
                    AudioPlayer.playEffect(24);  
                else
                    AudioPlayer.playEffect(9); // Wooden door sound. 
            }
            else if (Player.pos[0] >= 5  &&
                    ! destId.substring(0,2).matches(lastVisited.substring(0,2)))
            {
                AudioPlayer.playEffect(9); // Wood door sound in catacombs.
            }
            else {
                AudioPlayer.playEffect(0); // Footsteps. No door there
            }
            
            describeRoom();
            GUI.roomOut(dest.triggeredEvent());
            
            if (! hasVisited(destId)) 
                visited.add(destId);  
        }
    }
    // ========================================================================  
    /**
     * Plays a room's music and displays its description.
     */
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
    private static void addToKeyRing(Item key, Inventory furnInv) {
        furnInv.give(key, Player.keys);
    }
    // ========================================================================  
    private static void viewKeyRing() {
        AudioPlayer.playEffect(3);
        GUI.invOut("Keys:" + NL + Player.keys.toString()); 
    }
    // ========================================================================  
    /**
     * Used to check if the player may enter a particular locked room.
     * @param keyID The ID of a key, corresponding to a room ID.
     * @return If you have the key.
     */
    public static boolean hasKey(String keyID) {
        for (Item key : Player.keys) {              
            if (key.getType().equals(keyID))
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
    /**
     * Prints the furniture search dialog and initiates search if searchable.
     * @param furn The furniture being searched.
     */
    public static void trySearch(Furniture furn) {
        GUI.out(furn.getSearchDialog());
        
        if (furn.isSearchable())
            search(furn.getInv()); 
    } 
    // ========================================================================  
    /**
     * Subroutine for exchanging itemList between player and furniture inventories.
     * @param furnInv The furniture being searched.
     */
    public static void search(Inventory furnInv) {
        String command; 

        do {
            printInv(furnInv);
            GUI.menOut(Menus.TRADE_SUB);
            
            command = GUI.promptOut();
            
            if (LOOT_ACTION_P.matcher(command).matches()) {
                // Takes as many items as possible from the furniture.
                Player.incrementMoves();
                
                while (! furnInv.isEmpty() && ! Player.inv.isFull())
                    // Adds them all to player inventory.
                    evalTake(furnInv, furnInv.get(0)); 
                
                GUI.out("You ravenously stuff your pockets.");
            }
            else if (isNonEmptyString(command)) {
                Scanner scan = new Scanner(command).useDelimiter("\\s+");
                String action = scan.next(); 
                
                if (! scan.hasNext()) {
                    // If player enters just a digit, means "examine <slot>"
                    if (ANY_DIGIT_P.matcher(action).matches()) {
                        Item item = furnInv.get(action);
                        
                        if (item.equals(Inventory.NULL_ITEM))
                            GUI.out("There's nothing there.");
                        else
                            GUI.out(item.getDesc());
                    }
                    else // Notifies that a list wasn't entered.
                        GUI.out("Did you... forget to enter something there?");
                        
                    continue;
                }
                    
                String itemList = scan.nextLine();
                
                if (CHECK_P.matcher(action).matches()) 
                {
                    Item[] i = getItemList(itemList, furnInv);
                    Player.incrementMoves();
                    
                    if (i.length > 1)
                        GUI.out("Whoa now, one thing at a time please.");
                    else if (i.length == 0)
                        GUI.out("You're going to need to enter something in...");
                    else if (i[0].equals(Inventory.NULL_ITEM))
                        GUI.out("I couldn't find that in there...");
                    else {
                        if (i[0] instanceof Readable)
                            AudioPlayer.playEffect(2);
                        
                        GUI.out(i[0].getDesc());
                    }
                }
                else if (STORE_P.matcher(action).matches()) 
                    tradeAll(Player.inv, itemList, false);
                else if (TAKE_P.matcher(action).matches()) 
                    tradeAll(furnInv, itemList, true);
                else
                    GUI.out("A thousand pardons... what was that "
                            + "first thing you typed??");

                scan.close();
                describeRoom();
            }
            printInv();
        } while (isNonEmptyString(command));
    }
    // ========================================================================
    // Performs a take or store operation on every item in the list with the inventory.
    private static void tradeAll(Inventory inv, String list, boolean take) {
        Player.incrementMoves();
                    
        for (Item i : getItemList(list, inv))
            if (! i.equals(Inventory.NULL_ITEM) && inv.contains(i))
                if (take)
                    evalTake(inv, i); // Item exists
                else
                    evalStore(inv, i);
            else
                GUI.out(ERRONEOUS_INPUT);
    }
    // ========================================================================
    /**
     * Takes a list of names, returns a list of items found in the inventory.
     * Items that weren't found are replaced by a NULL_ITEM.
     * Example 1: "take the book, the parchment, and the pen"
     * Example 2: "take 1, 2, and 3"
     */
    private static Item[] getItemList(String itemList, Inventory inv) {
        if (! Player.isNonEmptyString(itemList)) 
            return new Item[0]; // Player entered nothing.
            
        // Trims articles off and excess space.
        String trimmed = ARTICLE_P.matcher(itemList)
                .replaceAll("")
                .trim()
                .replaceAll("\\s{2,}", " ");

        if (IT_THEM_P.matcher(trimmed).matches() && inv.size() == 1) {
            // If "it/them" used, and has one item, only option is first item.
            return new Item[] {inv.get(0)};
        }

        String[] itemArray = LIST_P.split(trimmed);
        ArrayList<Item> resultArray = new ArrayList<>(itemArray.length);

        for (String itemName : itemArray) {
            // Populate the list with items
            itemName = Player.tryIndefRef_Item(itemName.trim()); // Resolves 'it'
            
            Item item = inv.get(itemName); // Gets NULL_ITEM if not found.
            
            if (! resultArray.contains(item)) // Prevents adding duplicates
                resultArray.add(item);
        }

        return resultArray.toArray(new Item[resultArray.size()]); 
    }
    // ========================================================================  
    /**
     * Evaluates the player's take action.
     * @param furniture The furniture from which to take an item.
     * @param take The item being taken.
     */
    private static void evalTake(Inventory furnInv, Item take) {
        if (KEY_P.matcher(take.getType()).matches()) {
            // Matches a non-cave/catacomb room ID, which keys use as types.
            addToKeyRing(take, furnInv);
            AudioPlayer.playEffect(3);
            GUI.out("You put the " + take + " into your key ring.");
        }
        else {
            GUI.out("You take the " + take);
            Player.setLastInteract_Item(take.toString());
            furnInv.give(take, Player.inv);                 
        }   
    }
    // ========================================================================  
    /**
     * Evaluates the player's store action.
     * @param furnInv The inventory in which the item is being stored.
     * @param store The item being stored.
     */
    public static void evalStore(Inventory furnInv, Item store) {
        GUI.out("You store the " + store);
        Player.inv.give(store , furnInv); 

        if (store.toString().equals(Player.shoes))
            Player.shoes = ""; // If player stores the shoes currently wearing.
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************    
// <editor-fold defaultstate="collapsed" desc="INTERACTING FROM MAIN PROMPT">  
//****************************************************************************** 
    /**
     * Processes a player's action on furniture.
     * @param furnName the name of the furniture being acted upon.
     * @param verb the action the player is performing on the furniture.
     */
    private static void evaluateAction(String verb, String furnName) {
        String object = Player.tryIndefRef_Furn(furnName);
        
        // <editor-fold defaultstate="collapsed" desc="MOVE COMMAND">
        if (WALK_P.matcher(verb).matches()) {
            if (DIRECTION_P.matcher(object).matches())
                parseMovement(object);
            else if (INVALID_DIR_P.matcher(object).matches())
                GUI.out("Your humble life as a tradesman knows not how to move " + object + ".");
            else 
                GUI.out("You aren't even sure which way that is.");
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="COMMAND ON FURNITURE">
        else if (getPos().hasFurniture(object)) {
            // Furniture exists to be interacted with.
            Furniture furn = getFurnRef(object);
            setLastInteract_Furn(object);

            if (furn.actKeyMatches(verb)) {
                // Player typed an action specific to a furniture type.
                Player.incrementMoves();
                GUI.out(furn.interact(verb)); 
                describeRoom();
                printInv();
            }
            else if (CHECK_P.matcher(verb).matches()) {
                // Player typed something resembling "examine <furniture>"
                Player.incrementMoves();
                GUI.out(furn.getDescription()); 
            }
            else if (SEARCH_P.matcher(verb).matches() 
                    || ((verb.equals("open") || verb.equals("empty")) 
                            && furn instanceof Openable)) 
            {       
                trySearch(furn); // Player implied a search
            }
            else {
                Player.incrementMoves();
                
                if (MOVE_P.matcher(verb).matches() && furn instanceof Moveable) { 
                    // Player typed something resembling "move <furniture>"
                    GUI.out(((Moveable)furn).moveIt());
                }
                else if (DESTROY_P.matcher(verb).matches()) {
                    // Player typed something like "get <furniture>" but isn't gettable.
                    GUI.out("Yes, you're frustrated and hungry, but abstain from the wrathful thoughts.");
                }
                else if (ODD_CMD_SET.contains(verb))
                    // Standard output stirngs for wierd input.
                    ODD_CMD_KEYS.get(verb).run();
                else 
                    GUI.out("Doing that to the " + object + " seems unnecessary right now.");
            }
        }   
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="REFLEXIVE COMMANDS">
        else if (object.equals("self") || object.equals("yourself")) {
            // Player performing action on itself. Mostly superficial.
            if (CHECK_P.matcher(verb).matches()) {
                Player.incrementMoves();
                GUI.out("Yes, all your parts are still there, thank goodness."); 
            }
            else if (SEARCH_P.matcher(verb).matches()) {              
                GUI.out("Ummm... is this what you meant??");
                inventoryPrompt();
            }
            else if (MOVE_P.matcher(verb).matches()) {
                // Moves player in a random direction
                Direction[] dirList = 
                {Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.NORTH};
                Direction dir = dirList[Math.abs((int)System.currentTimeMillis()) % 4];
                move(dir);
                GUI.out("Alrighty, how does " + dir + " sound?");
            }
            else if (TAKE_P.matcher(verb).matches()) {
                Player.incrementMoves();
                GUI.out("Indeed, how romantic!");
            }
            else if (DESTROY_P.matcher(verb).matches()) {
                Player.commitSuicide();
            }
            else
                GUI.out("Your binary isn't designed to do that.");
        }
        // </editor-fold>
        
        else if (SEARCH_P.matcher(verb).matches() || verb.matches("open|empty")) {
            // Player wants to open an item
            object = Player.tryIndefRef_Item(furnName);
            Item i = inv.get(object);
            
            if (i.toString().equals(LOOT_SACK)) {
                // Loot sack is found in the foyer.
                openLootSack(); 
                setLastInteract_Item(LOOT_SACK);
            }
            else if (i.toString().equals(SHOE_BOX)) {
                // Loot sack is found in Kampe's quarters.
                i.useEvent(); 
                setLastInteract_Item(SHOE_BOX);
            }
            else if (Player.hasItemResembling(object))
                GUI.out("You fumble with the " + object + 
                        " but nothing useful is accomplished.");
            else
                GUI.out("You aren't quite sure what to do about that.");
        }
        else if (verb.equals("speak") || verb.equals("say")) {
            // Player typed something like "<speak> <words>".
            GUI.out("\"" + furnName + 
                    "!\" You speak the words, but they only echo and fade.");
        }
        else if (GEN_FURNITURE_P.matcher(object).matches()) {
            // Player used a very vague term to interact with.
            GUI.out("Don't be lazy now. Specify please.");
        }
        else  
            // Something invalid was entered in!
            GUI.out("There is no " + object + " here that you can see. Or are "
                  + "we perhaps being lazy and attempting to pick up items that "
                  + "aren't mentioned in the room description?"); 
    }
    // ========================================================================  
    /**
     * Moves the player according to an input string.
     * @param dir String resembling a direction the player wants to move in.
     */
    private static void parseMovement(String dir) {
        if (NORTH_P.matcher(dir).find())
            Player.move(Direction.NORTH);
        else if (SOUTH_P.matcher(dir).find())
            Player.move(Direction.SOUTH);
        else if (EAST_P.matcher(dir).find())
            Player.move(Direction.EAST);
        else if (WEST_P.matcher(dir).find())
            Player.move(Direction.WEST);
        else if (UP_P.matcher(dir).find()) 
            findStaircase(Direction.UP);
        else 
            findStaircase(Direction.DOWN);
    }
    // ========================================================================  
    // Finds furniture in the room that will move the player up or down.
    private static void findStaircase(Direction dir) {
        for (Furniture f : Player.getPos().getFurnishings()) {
            if (f instanceof DoubleStaircase) {
                GUI.out(f.interact(dir.toString()));
                return;
            }
            if (f instanceof Staircase && ((Staircase)f).getDirection() == dir) {
                GUI.out(f.interact("climb"));
                return;
            }
            if (f instanceof Climbable) {
                GUI.out(f.interact("climb"));
                return;
            }
        }
        GUI.out("There's nothing here to take you " + dir + ".");
    }
    // ========================================================================
    // Searches the loot sack if the player is carrying it.
    // Also prints score, a message, and the number of phylacteries collected.
    // Inventories check for phylacteries and treasures based on there value!
    private static void openLootSack() {
        int pi = inv.countPhylacteries();
        
        if (Player.hasItem(LOOT_SACK)) {
            LootSack s = (LootSack)inv.get(LOOT_SACK);
            int t = s.countTreasures();
            int ps = s.countPhylacteries();
            int p = pi + ps;
            String message;
            
            // Displays player score
            if (score >= 13500)
                message = "Your wealth is beyond the dreams of avarice and "
                        + "will earn you a divine seat in the afterlife.";
            else if (score >= 11500)
                message = "Your wealth is legendary and would bring a tear to Plutus' eye.";
            else if (score >= 10000)
                message = "Your wealth is nearly insurmountable and would "
                        + "stun all humans and Gods alike.";
            else if (score >= 8500)
                message = "Your wealth is nearly insurmountable and would "
                        + "stun all men and women alike.";
            else if (score >= 7000)
                message = "You have amassed a grand fortune which will certainly, should you "
                        + "return, grant you any Earthly desire.";
            else if (score >= 5500)
                message = "You have amassed a grand fortune which would earn you the respect "
                        + "of all kings, queens, popes, and the like.";
            else if (score >= 4500)
                message = "Your riches would earn you the respect of all kings.";
            else if (score >= 3500)
                message = "Your taste is luxury is formidible.";
            else if (score >= 2500)
                message = "You're skilled in the hunt for treasure, though "
                        + "you have so much more room to grow.";
            else if (score >= 1500)
                message = "Your riches will earn you the respect of many.";
            else if (score >= 1000)
                message = "Your eye for wealth is strong. You will likely have much "
                        + "to pawn off, should you return.";
            else if (score >= 500)
                message = "You abide by your manly ethics to work hard and provide "
                        + "for your family. Although, the thought of wealth visits you frequently.";
            else if (score >= 250)
                message = "You are rich in character, a true fortune to be respected. "
                        + "Material possession are secondary, of course.";
            else if (score >= 0)
                message = "You have a humble spirit, and long not for possessions. "
                        + "Your only wish, of course, is only to return home.";
            else
                message = "You have eccentric, perplexing tastes. But so long "
                        + "as hope of returning home lingers, you spirit remains strong.";
            

            // If the player has looted phylacteries.
            if (ps > 0)
                message += " However, you have lost the desire to escape, "
                        + "and wish only to bask eternally in your riches.";
            
            GUI.out("Your score is " + score + ". You have looted " + t + 
                    " out of 10 legendary treasures and " + p + 
                    " out of 5 phylacteries so far. " + message);
            
            s.useEvent();
        }
        else 
            GUI.out("You have collected " + pi + " out of 5 phylacteries, and "
                    + "you unfortunately do not have a giant sack of loot right now."); 
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
   
//******************************************************************************    
// <editor-fold defaultstate="collapsed" desc="INVENTORY ACTIONS">      
//******************************************************************************    
    public static void printInv() {
        GUI.invOut("You are carrying:" + NL + Player.inv);
    }
    // ========================================================================  
    private static void printInv(Inventory furnInv) {
        GUI.invOut("You find:" + NL + furnInv + NL + "You are carrying:" + NL + Player.inv);
    }
    // ========================================================================  
    /**
     * Brings up the inventory prompt and asks the player to enter an option.
     */
    private static void inventoryPrompt() {
        printInv();
        AudioPlayer.playEffect(1);
        String ans;
        
        do {
            GUI.menOut(Menus.INV_MAIN);
            
            ans = GUI.promptOut();  // Asks for option 1-5
            
            if (INV_CMD_SET.contains(ans))
                INV_CMDS.get(ans).run();
            
            else if (isNonEmptyString(ans))
                GUI.out(ERRONEOUS_INPUT);
            
        } while (isNonEmptyString(ans));
        
        GUI.clearDialog();
    }
    // ========================================================================  
    private static void inspectPrompt() {
        String ans;            
        
        do {
            // Prompts for furniture to inspect.
            GUI.menOut(Menus.INV_INSPECT);
            ans = ARTICLE_P.matcher(GUI.promptOut()).replaceAll("");

            if (Player.isNonEmptyString(ans)) {
                // Erases all articles before getting item.
                ans = Player.tryIndefRef_Item(ans);
                Item item = Player.inv.get(ans);

                if (item.equals(Inventory.NULL_ITEM)) {
                    GUI.out(ERRONEOUS_INPUT);
                    continue;
                }

                Player.setLastInteract_Item(item.toString());
                Player.incrementMoves();
                GUI.out(item.getDesc());  
            }
        } while (isNonEmptyString(ans));
        
        GUI.clearDialog();
    }
    // ======================================================================== 
    /**
     * Prompts player for an item to use and then performs appropriate
     * action.
     */
    private static void usePrompt() {
        String ans;
        
        do {      
            GUI.menOut(Menus.INV_USE);
            ans = ARTICLE_P.matcher(GUI.promptOut()).replaceAll("");

            if (Player.isNonEmptyString(ans)) {
                ans = Player.tryIndefRef_Item(ans);
                Item item = Player.inv.get(ans);

                if (item.equals(Inventory.NULL_ITEM)) {
                    // No item found. Notifies player, repeats loop.
                    GUI.out(ERRONEOUS_INPUT);
                    continue;
                }

                Player.setLastInteract_Item(item.toString());
                
                if (item.getUseID() == 1) // Item only prints a dialog.
                    GUI.out(item.useEvent());          
                else { // Enters a use-on prompt
                    GUI.menOut(Menus.INV_USEON);
                    evalUse(item, GUI.promptOut());
                }
            }
        } while (isNonEmptyString(ans));
    }
    // ========================================================================  
    /**
     * Subroutine entered into when an item is used from the player's inventory.
     * It is generally quicker to use items on objects from the main prompt.
     * @param furniture Furniture the item is being used on.
     * @param item The item being used
     */
    private static void evalUse(Item item, String furniture) {
        furniture = Player.tryIndefRef_Furn(furniture);
        
        if (getPos().hasFurniture(furniture)) {
            Player.setLastInteract_Furn(furniture);
            Furniture target = getFurnRef(furniture);
            Player.incrementMoves();

            if (target.useKeyMatches(item.toString())) {
                GUI.out(target.useEvent(item));
                describeRoom();
                printInv();
            }
            else {
                GUI.out("You jam the " + item + " into the " + furniture +
                        " as hard as you can with no exciting results.");
            }
        }                      
        else if (isNonEmptyString(furniture)) 
            GUI.out("A sharp squint around the room reveals no " 
                    + furniture + " at all."); 
        
        printInv();
    }
    // ======================================================================== 
    /**
     * Allow the player to write a note to itself. This can only be done if the
     * player has the notepad and a pen.
     */
    private static void writePrompt() {
        if (! (Player.hasItem(PEN) && Player.hasItem(NOTEPAD))) {
            GUI.out("You will need a pen and notepad in "
                    + "order to write a note to yourself.");
            return;
        }
        
        GUI.menOut(NL + "Write a title for" + NL + "your note, or enter" + NL
                   + "a slot number to" + NL + "write to an existing" + NL + "note.");

        String title = GUI.promptOut();

        if (! isNonEmptyString(title)) 
            ; // Go back to main prompt
        else if (ANY_DIGIT_P.matcher(title).matches()) {
            // Player is appending to existing note.
            Item n = inv.get(title);

            if (! n.equals(Inventory.NULL_ITEM)) {
                if (n instanceof Note && ! (n instanceof Book)) {
                    // Player may write on notes but not books.
                    Item newNote = new Note(n.toString(), 
                            n.getDesc() + ' ' + getNoteBody());
                    
                    Player.inv.remove(n);
                    Player.inv.contents().add(newNote);
                    Player.setLastInteract_Item(newNote.toString());
                    Player.incrementMoves();
                    printInv();
                }
                else 
                    GUI.out("That isn't a note if I've ever seen one.");
            }
            else GUI.out(ERRONEOUS_INPUT);
        }
        else if (! Player.inv.isFull()) {
            // Player is making a new note.
            Item newNote = 
                    new Note("note - " + title + ':' + ' ', getNoteBody());
            
            Player.inv.add(newNote);
            Player.setLastInteract_Item(newNote.toString());
            Player.incrementMoves();
            printInv();
        }
        else
            GUI.out("You're carrying too much stuff to write a new note!");
    }
    // ========================================================================
    /**
     * Gets string input from player to write to a note.
     * Since promptOut automatically makes everything lowercase, this has to
     * undo that.
     * @return A capitalized string.
     */
    private static String getNoteBody() {
        GUI.menOut("Ok. Write down your momento now...");
        char[] body = GUI.promptOut().toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean capitalize = false;
        
        for (char c : body) {
            if (c == '.') {
                // Capitalize the next lowercase letter.
                capitalize = true;
                builder.append(c);
            }
            else if (! (capitalize && Character.isLetter(c)))
                builder.append(c);
            else {
                // It's a lowercase letter.
                capitalize = false;
                builder.append(Character.toUpperCase(c));
            }
        }
        
        GUI.out("Note has been written.");
        return builder.toString();
    }
    // ========================================================================
    // <editor-fold desc="COMBINE SUBROUTINES">
    /**
     * Prompts the player for an item list, verifies it, moves to evalCombine().
     * A list is valid if it contains exactly 2 or 3 existing items in the
     * player's inventory.
     */
    private static void combineSub() {
        String combineThese;
        GUI.menOut(Menus.INV_COMBINE);
        
        do {
            combineThese = GUI.promptOut(); // Prompts for list of items.

            if (isNonEmptyString(combineThese)) {
                Player.incrementMoves();
                
                // Converts the item names into array of Item objects.
                Item[] itemList = getItemList(combineThese, inv);
        
                if (validateList(itemList))
                    // Tries to combine them if the list is valid.
                    evalCombine(itemList);
            }
        } while (isNonEmptyString(combineThese));        
    }
    // ======================================================================== 
    // Does the same as combineSub() but with a starting string as input.
    // For use by the text parser.
    private static void combineSub(String input) {
        Item[] itemList = getItemList(input, inv);
        
        if (validateList(itemList))
            evalCombine(itemList);
    }
    // ======================================================================== 
    /**
     * Validates the correctness of a list of items to combine generated by the
     * player, prints an error message if false.
     * @param list a variable-length list of items.
     * @return if an attempt at combining can be performed on the list.
     */
    private static boolean validateList(Item[] list) {
        for (Item i : list) // Checks for null items
            if (i.equals(Inventory.NULL_ITEM)) {
                GUI.out(ERRONEOUS_INPUT); 
                return false;
            }
        
        // Checks if correct length
        switch (list.length) {
            case 2: case 3:
                return true; 
            case 0:
                GUI.out(ERRONEOUS_INPUT);
                return false;
            case 1:
                GUI.out("You take a moment to ponder how "
                        + "to combine an item with itself.");
                return false;
            default:
                GUI.out("You possess only the dexterity "
                        + "to combine 2 or 3 items.");
                return false;
        }
    }
    // ======================================================================== 
    /**
     * Tries to combine a list of 2 or 3 items.
     * @param list a list of 2 or 3 items.
     */
    private static void evalCombine(Item[] list) {
        if (allCombineToSame(list)) { 
            if (list[0].getThreshold() == list.length) {
                GUI.out(Player.inv.combine(list, list[0].forms())); 
                printInv();
            }
            else // 2 objects are correct, but 1 is missing or incorrect.
                GUI.out("You need something else for this to work."); 
        }
        else if (list.length == 2)
            GUI.out("You push them together as hard as you can, " +
                            "but it does nothing."); 
        else // length is 3
            GUI.out("You are pretty sure all these don't go together."); 
    }
    // ========================================================================  
    /**
     * Checks that all the items in the list combine into the same object.
     * @param itemList A list of items
     * @return If the items combine into the same object.
     */
    private static boolean allCombineToSame(Item[] itemList) {
        Item forms = itemList[0].forms();

        if (forms == null) // First does not combine to anything.
            return false;

        String combinesTo = forms.toString();

        for (Item i : itemList) {
            // Checks that they all combine to same as first item.
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
    public final int POS[], SCORE, MOVES;
    public final Inventory KEYS; 
    public final PlayerInventory INV; 
    public final ArrayList<String> VISITED; 
    public final String LSTVISITED, SHOES; 

    public PlayerAttributes() {
        this.MAP = Player.mapRef;
        this.POS = Player.pos;
        this.INV = Player.inv;
        this.KEYS = Player.keys;
        this.LSTVISITED = Player.lastVisited;
        this.SHOES = Player.shoes;
        this.VISITED = Player.visited;
        this.SCORE = Player.score;
        this.MOVES = Player.moves;
    }
}
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    

//******************************************************************************    
// <editor-fold defaultstate="collapsed" desc="TEXT PARSER">  
/**
* This processes more complex sentences into statements containing verbs,
* items, and furniture.
* 
* The text parser needs access to Player methods, so their relationship is
* close. This class is only used by player, which is why this is a private
* nested class.
* 
* Sentences are split into commands, and then each is broken down into 
* key words. The key words are used to create command objects which are
* queued up and executed in order.
* 
* @author Kevin Rapa
*******************************************************************************/
private static class TextParser {
    private final static LinkedList<Command> COMMAND_QUEUE = new LinkedList<>();

    // Items to create when other items are thrown or broken.
    private static final Item 
        BROKEN_GLASS = new Item("broken shards", 
                "The pieces of glass sit uncomfortably in your pocket. "
              + "Of course, you certainly know what you're doing.", -50),
        RIPPED_SHREDS = new Note("ripped paper shreds", 
                "The gory mess of literature now exists crumpled up in your "
                        + "pocket. This is unintelligible."),
        BURNED_REMNANTS = new Item("burned remnants", 
                "It's just a handful of ashes and burnt paper. "
                        + "Completely useless... OR IS IT???", -5);

    private static final String
        DONT_HAVE_IT = "It doesn't look like you're carrying anything resembling that.";

    // List of commands that don't depend on state.
    private static final Command 
        DEFAULT_CMD =   new Command("What does that mean?"),
        EXPLETIVE_CMD = new Command("Mind yourself! You're a guest here!"),
        SUICIDE_CMD =   new Command(() -> Player.commitSuicide(), "SUICIDE"),
        GREETING_CMD =  new Command("What do you think this is? Zork?"),
        AMBIGUOUS_CMD = new Command("You need to specify something to put that in!"),
        NO_SLOT_COMMAND = new Command("You don't have anything in your inventory there.");

    //**************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Text parser">
    //**************************************************************************
    /**
     * Removes articles 'a', 'an', 'the', and the pronoun 'some' from the input,
     * and then queues up all the commands chained together by conjunctions.
     * @param input An input string by the player
     */
    public static void processText(String input) {
        String noArticles = ARTICLE_P.matcher(input).replaceAll("");

        for (Command c : splitCommands(noArticles))
            COMMAND_QUEUE.offer(c);

        while (! COMMAND_QUEUE.isEmpty())
            COMMAND_QUEUE.poll().perform();
    }
    // ========================================================================
    /**
     * Removes prepositions, which won't effect the meaning in most contexts.
     * @param input A string of input with articles stripped.
     * @return The sentence stripped of prepositions.
     */
    private static String stripPrepositions(String input) {
        StringBuilder builder = new StringBuilder();

        for (String word : input.split(" ")) {
            if (! PREPOS_P.matcher(word).matches())
                builder.append(word).append(" ");
        }
        return builder.toString().trim();
    }
    // ========================================================================
    /**
     * Splits the sentence using a conjunction as a delimiter into statements,
     * then populates a list of commands.
     * This does conflict with listing items using 'and' in combining, since
     * the text parser believes anything following 'and' is another command,
     * UNLESS the word and follows a comma.
     * @param sentence a sentence with the articles removed.
     * @return a list of commands to execute.
     */
    private static Command[] splitCommands(String sentence) {
        // Splits a chain of commands into individual commands.
        String[] statements = CONJUNC_P.split(sentence);
        Command[] commands = new Command[statements.length];

        for (int i = 0; i < commands.length; i++) {   
            //-----------------------------------------------------------------
            // First six conditions handle simpler commands.
            if (EXPLETIVE_P.matcher(sentence).find()) // Zork-inspired
                commands[i] = EXPLETIVE_CMD;    
            else if (ANY_DIGIT_P.matcher(statements[i]).matches()) {
                // Player typed a digit. Interpreted as "examine <item slot>"
                Item item = Player.getInv().get(statements[i]);

                if (item.equals(Inventory.NULL_ITEM))
                    commands[i] = NO_SLOT_COMMAND;
                else
                    commands[i] = new Command(() -> GUI.out(item.getDesc()), "INSPECT");
            }
            else if (DIRECTION_P.matcher(statements[i]).matches()) {
                // Sentence resembles a movement command.
                commands[i] = new Command(Verb.GO_VERB, 
                        new DirectObj(FIRST_WORD_P
                                .matcher(statements[i])
                                .replaceFirst("")));
            }
            else if (SUICIDE_P.matcher(statements[i]).matches()) {
                // Sentence resembles a suicidal command.
                commands[i] = SUICIDE_CMD;
            }
            else if (COMBINE_P.matcher(statements[i]).matches()) {
                // Sentence resembles 'combine' <list of items>
                // Using 'and' in the list doesn't work unless after a comma
                String s = statements[i];
                commands[i] = new Command(() -> 
                        Player.combineSub(s.replaceFirst("combine\\s+", "")), "COMBINE");
            }
            else if (ZORK_P.matcher(statements[i]).matches()) { 
                // Player said hello
                commands[i] = GREETING_CMD;
            }
            //-----------------------------------------------------------------
            // These handle more comlicated input strings.
            else if (USE_ITEM_CMD_P.matcher(statements[i]).matches()) {
                    commands[i] = getItemCmd(USE_MANNER_P.split(statements[i]));
            }
            else if (STORE_CMD_P.matcher(statements[i]).matches()) {
                // Command resembles "drop <item>" or "put <item> in <objec>
                commands[i] = getStoreCmd(STORE_AREA_P.split(
                        STORE_SPACE_P.matcher(statements[i])
                                    .replaceAll("")));
            }
            else {
                if (SEARCH_MANNER_P.matcher(statements[i]).find()) {
                    // Replaces "look (in|on|around|under) with just 'search'"
                    statements[i] = SEARCH_MANNER_P.matcher(statements[i])
                            .replaceAll("search");
                }

                commands[i] = getCmdActionFirst(INSTRUCTIVE_P.
                        split(stripPrepositions(statements[i]))
                );
            }
            //-----------------------------------------------------------------
        }
        return commands;
    }
    //**************************************************************************
    // </editor-fold>
    //**************************************************************************


    //**************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Command assemblers">
    //**************************************************************************
    /**
     * Assembles a command where the player interacts with furniture with
     * possibly an item.
     * If s is size 2, then second string is presumably an item.
     */
    private static Command getCmdActionFirst(String[] s) {
        String actionObject = s[0];

        // Get just the first word
        Verb verb = new Verb(SPACE_THEN_ALL_P.matcher(actionObject)
                                            .replaceAll(""));

        // Everything but the first word.
        String object = FIRST_WORD_P
                        .matcher(actionObject.trim())
                        .replaceFirst("");

        DirectObj dirObj = new DirectObj(object);

        switch(s.length) {
            case 2:
                return new Command(new Instrument(s[1]), dirObj);
            case 1:
                if (verb.VALUE.equals(dirObj.VALUE))
                    // If they're equal, the player entered a single word.
                    // This is interpreted arbitrarily as a search.
                    return new Command(Verb.SEARCH_VERB, dirObj);
                else
                    return new Command(verb, dirObj);
            default:
                return DEFAULT_CMD;
        }
    }
    // ========================================================================
    /**
     * Assembles a command where the player stores an item.
     * If the furniture turns out to not be searchable, the item is used
     * on it instead in order to resolve ambiguity. If s is size 2, then
     * the second string is presumably the name of furniture.
     */
    private static Command getStoreCmd(String[] s) {
        String object = s[0];
        Instrument inst;
        DirectObj obj = null;

        if (DROP_P.matcher(object).matches()) {
            // Player typed "put <item> down"
            obj = DirectObj.FLOOR_OBJECT;
            object = object.replaceAll(" down", "");
        }

        inst = new Instrument(object);

        switch(s.length) {
            case 2:
                return new Command(Verb.PUT_VERB, inst, new DirectObj(s[1]));
            case 1:
                // If obj is null, player typed "store <item>", but not where.
                return (obj == null) ?
                    AMBIGUOUS_CMD : new Command(Verb.PUT_VERB, inst, obj);
            default:
                return DEFAULT_CMD;
        }
    }
    // ========================================================================
    /**
     * Assembles a command where the player uses an item, possibly on a
     * piece of furniture.
     * If the verb is 'drop', then the store command takes care of the rest.
     * If s is size 2, then the second string is presumably a furniture name.
     */
    private static Command getItemCmd(String[] s) {
        String verbObject = stripPrepositions(s[0]);
        Instrument inst;

        // Get just the first word.
        Verb use = new Verb(SPACE_THEN_ALL_P.matcher(verbObject).replaceFirst(""));

        // Everything but the first word.
        String item = WORD_SPACE_P.matcher(verbObject).replaceFirst(""); 

        if (use.VALUE.equals("drop") || use.VALUE.equals("remove")) {
            // If player types "drop <items>" then it's a store command instead!
            // Sentence looked like <use> <item>, but it's actually closer in
            // meaning to 'store' <item> 'in floor'. 
            return new Command(Verb.PUT_VERB, new Instrument(item), 
                    DirectObj.FLOOR_OBJECT);
        }
        else if (INSTRUCTIVE_P.matcher(item).find()) {
            // Player typed a phrase including "<furniture> with/using <item>
            String[] furnItem = INSTRUCTIVE_P.split(item);

            return new Command(new Instrument(furnItem[1]), 
                               new DirectObj(furnItem[0]));
        }
        else {
            inst = new Instrument(item);

            switch(s.length) {
                case 1:
                    return new Command(use, inst);
                case 2:
                    if (! (use.VALUE.equals("throw") || use.VALUE.equals("break") || 
                           use.VALUE.equals("destroy")))
                        return new Command(inst, new DirectObj(s[1]));
                    else
                        return new Command(use, inst);
                default:
                    return DEFAULT_CMD;
            }
        }
    }
    //**************************************************************************
    // </editor-fold>
    //**************************************************************************


    //**************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Command class">
    //
    // Keywords from player commands are packaged into Command objects. Different
    // orders and types of words construct different commands which are
    // associated with different methods that are run when the execute method
    // is invoked. Commands are enqueued and then executed in order.
    //**************************************************************************
    private static class Command {
        private final Runnable ACTION;
        private final String VALUE;
        // ====================================================================
        // <editor-fold defaultstate="collapsed" desc="constructors">
        public Command(Verb v, DirectObj o) {
            VALUE = "VERB: " + v.toString() + "\tOBJECT: " + o.toString();
            System.out.println("Creating action -> furniture command: " + VALUE);

            ACTION = (() -> Player.evaluateAction(v.toString(), o.toString()));
        }
        // --------------------------------------------------------------------
        public Command(Instrument i, DirectObj o) {
            VALUE = "ITEM: " + i.toString() + "\tOBJECT: " + o.toString();
            System.out.println("Creating item -> furniture command: " + VALUE);
            ACTION = (() -> execute(i, o));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i) {
            VALUE = "VERB: " + v.toString() + "\tITEM: " + i.toString();
            System.out.println("Creating use item command: " + VALUE);
            ACTION = (() -> execute(v, i));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i, DirectObj o) {
            VALUE = "VERB: " + v.toString() + "\tITEM: " + i.toString() + "\tOBJECT: " + o.toString();
            System.out.println("Creating store item command: " + VALUE);
            ACTION = (() -> execute(v, i, o));
        }
        // --------------------------------------------------------------------
        public Command(String s) {
            VALUE = s;
            System.out.println("Creating print command -> \"" + s + "\".");
            ACTION = (() -> GUI.out(s));
        }
        // --------------------------------------------------------------------
        public Command(Runnable b, String desc) {
            VALUE = desc;
            System.out.println("Creating player method command -> " + VALUE);
            ACTION = b;
        }
        // </editor-fold>
        // ====================================================================


        // ====================================================================
        // <editor-fold defaultstate="collapsed" desc="execute methods">
        /**
         * Uses the item i on the furniture o.
         */
        private static void execute(Instrument i, DirectObj o) {
            String itemName = Player.tryIndefRef_Item(i.toString());

            if (Player.hasItemResembling(itemName)) {
                Player.setLastInteract_Item(itemName);
                Player.evalUse(Player.getInv().get(itemName), o.toString());
            }
            else
                GUI.out(DONT_HAVE_IT);
        }
        // --------------------------------------------------------------------
        /**
         * Uses the item i in the specified way (v).
         * Long chain of if statements in order to accept a variety of input!
         * If player isn't carrying the item, checks if it's actually furniture
         * the player typed. If it is, acts on it instead (Mainly for inspect/
         * examine commands.
         */
        private static void execute(Verb v, Instrument i) {
            String verb = v.toString(),
                   instrument = Player.tryIndefRef_Item(i.toString());

            if (Player.hasItemResembling(instrument)) {
                Player.setLastInteract_Item(instrument);
                Player.incrementMoves();
                
                Item item = Player.getInv().get(instrument);
                String name = item.toString();
                String type = item.getType();

                if (verb.equals("use"))
                    GUI.out(item.useEvent());
                //-------------------------------------------------------------
                else if (INSPECT_P.matcher(verb).matches())
                    GUI.out(item.getDesc());
                //-------------------------------------------------------------
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: READ">
                else if (verb.equals("read")) {
                    if (type.equals(READABLE) || name.equals(BOOK_PHYL)) 
                        GUI.out(item.useEvent()); // Phylactery type. Not readable
                    else
                        GUI.out("That isn't something you can read...");
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: FILL">
                else if (verb.equals("fill")) {
                    if (name.equals(METAL_BUCKET))
                        Player.evaluateAction("get", "water");
                    else if (name.equals(BUCKET_OF_WATER))
                        GUI.out("That particular bucket is already full of water!");
                    else if (name.equals(TEST_TUBE) || name.equals(EMPTY_VIAL))
                        GUI.out("Whoa now, that's scientific equipment. The only way to properly fill that is with a burette.");
                    else
                        GUI.out("That isn't something you should be filling with water.");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: WEAR">
                else if (verb.equals("wear")) {
                    if (type.equals(SHOES) || type.equals(CLOTHING))
                        GUI.out(item.useEvent());
                    else
                        GUI.out("That isn't something you can wear...");
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: THROW">
                else if (verb.equals("throw")) {
                    Player.getInv().remove(item);
                    Furniture floor = Player.getFurnRef("floor");

                    if (floor == null) {
                        GUI.out("A quick ingenious thought convinces the player to "
                              + "throw the " + item + ". The item lands in "
                              + "an unknown location, lost to the aether.");
                    }
                    else if (type.equals(BREAKABLE)) {
                        floor.getInv().add(new Item("destroyed " + item, 
                                "The " + item + " is now broken and certainly useless.", -50));

                        GUI.out("After some quick thinking, you passionately "
                              + "launch the " + item + " as an olympic discus "
                              + "thrower would. The item lands on the floor.");
                    }
                    else if (type.equals(LIQUID) || type.equals(INGREDIENT) 
                            || type.equals(FOCUS)) 
                    {
                        if (! name.equals(BUCKET_OF_WATER)) {
                            floor.getInv().add(BROKEN_GLASS);
                            GUI.out("A cunning decision is made. The player "
                                  + "throws the " + item + ". The item lands "
                                  + "on the floor. A glassy shatter swarms your "
                                  + "ear and fills you with rue.");
                        }
                        else {
                            floor.getInv().add(item);
                            GUI.out("Be careful with that. You wouldn't want "
                                  + "to get the floor all soaked and risk "
                                  + "dying of a clumsy step.");
                        }
                    }
                    else if (type.equals(PHYLACTERY)) {
                        floor.getInv().add(item);
                        GUI.out("You naively launch the " + item + " across the "
                              + "room in hopes of destroying the cursed item. The "
                              + item + " lands unscathed on the floor.");
                    }
                    else {
                        floor.getInv().add(item);
                        GUI.out("After some quick thinking, you passionately "
                              + "launch the " + item + " as an olympic discus "
                              + "thrower would. The item lands on the floor.");
                    }
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: BREAK">
                else if (verb.equals("destroy") || verb.equals("break")) {
                    if (type.equals(BREAKABLE)) {
                        Player.getInv().remove(item);
                        Player.getInv().add(new Item("destroyed " + item, 
                                "The " + item + " is now broken and certainly useless.", -50));
                        GUI.out("An acute sense of frustration causes you to crush it in your hand.");
                    }
                    else if ((type.equals(LIQUID) && ! name.equals(BUCKET_OF_WATER)) 
                            || type.equals(FOCUS) || type.equals(INGREDIENT)) 
                    {
                        Player.getInv().remove(item);
                        Player.getInv().add(BROKEN_GLASS);
                        GUI.out("An acute sense of frustration causes you to "
                              + "crush the feeble glass in your hand.");
                    }
                    else if (type.equals(READABLE)) {
                        Player.getInv().remove(item);
                        Player.getInv().add(RIPPED_SHREDS);
                        GUI.out("A cunning idea forms. You rip up the paper "
                              + "to shreds and stuff it back into your pocket.");
                    }
                    else if (type.equals(PHYLACTERY)) {
                        GUI.out("You try with all your might to destroy the "
                            + item + ", but fail to leave even a fingerprint.");
                    }
                    else {
                        GUI.out("You lack the strength to do that.");
                    }
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: RIP">
                else if (verb.equals("rip") || verb.equals("tear")) {
                    if (type.equals(READABLE)) {
                        Player.getInv().remove(item);
                        Player.getInv().add(RIPPED_SHREDS);
                        GUI.out("A cunning idea forms. You rip up the paper "
                                + "wantonly and stuff it back into your pocket.");
                    }
                    else
                        GUI.out("That is not something you could rip up.");
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: DRINK">
                else if (verb.equals("drink")) {
                    if (type.equals(INGREDIENT) || type.equals(LIQUID)) {
                        if (name.equals(PHASE_DOOR_POTION))
                            GUI.out(item.useEvent());
                        else if (name.equals(BUCKET_OF_WATER))
                            GUI.out("Ah, refreshing!!");
                        else if (name.equals(ACETONE) || name.matches("molten.*"))
                            GUI.out("No possible way you're doing something that stupid!");
                        else
                            GUI.out("You reluctantly take a small sip. 'Yugh! Bitter and disgusting!'");
                    }
                    else
                        GUI.out("That is not something you can drink...");
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: EAT">
                else if (verb.equals("eat") || verb.equals("consume")) {
                    if (name.equals(GLOWING_FRUIT)) {
                        GUI.out("The fruit's glow and tasteful aroma entice you irresistibly. "
                              + "You bite down and find the fruit as hard as a rock. "
                              + "A sharp pain comes and you pull the fruit away.");
                    }
                    else
                        GUI.out("The " + item + " seems most inedible...");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: BURN">
                else if (verb.equals("burn")) {
                    if (type.equals(READABLE) || name.equals(NOTEPAD)) {
                        if (Player.hasItem(HAND_TORCH)) {
                            Player.getInv().remove(item);
                            Player.getInv().add(BURNED_REMNANTS);
                            GUI.out("The disturbed player decides a promising "
                                    + "course of action and burns it to a crisp.");
                        }
                        else
                            GUI.out("Thank heavens you don't have a hand torch "
                                    + "to commit such an anarchic act.");
                    }
                    else
                        GUI.out("That isn't something you can burn so easily.");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: SWING">
                else if (verb.equals("swing") || verb.equals("wave")) {
                    if (type.equals(WEAPON))
                            GUI.out("You be careful with that. Wouldn't want to poke your eye out.");
                    else if (name.equals(HAND_TORCH))
                        GUI.out("What a spectacular display of pyro acrobatics. "
                                + "If only someone were here to witness.");
                    else
                        GUI.out("Waving that around won't accomplish anything useful.");
                }
                // </editor-fold>
                //-------------------------------------------------------------
                else
                    GUI.out("Sorry, that really wasn't specific enough for me.");
            }
            else 
                Player.evaluateAction(verb, i.toString());

            Player.printInv();
        }
        // --------------------------------------------------------------------
        /**
         * Stores the item list i into the furniture o.
         * Can be of the form "put *item* down" or "drop *item*" to drop an item.
         * Drop commands are actually first processed as a use item command.
         * Verb parameter is always 'put'. It's there to disambiguate it from
         * execute(Instrument i, DirectObject o) constructor.
         */
        private static void execute(Verb v, Instrument i, DirectObj o) {
            String furniture = Player.tryIndefRef_Furn(o.toString());

            if (Player.getPos().hasFurniture(furniture)) {
                // Checks that the furniture exists
                Item[] list = Player.getItemList(i.toString(), Player.getInv());
                Furniture furn = Player.getFurnRef(furniture);
                Player.setLastInteract_Furn(furniture);
                Player.incrementMoves();
                int j;

                for (j = 0; j < list.length; j++) {
                    // Loops through the list and stores each
                    if (isNullItem(list, j)) break;

                    Player.setLastInteract_Item(list[j].toString());

                    if (furn.isSearchable()) {
                        // Stores the current item in the item list.
                        Player.evalStore(furn.getInv(), list[j]);
                        Player.printInv();
                    }
                    else if (furn.useKeyMatches(list[j].toString())) {
                        // Not searchable, but perhaps it's meant to be used 
                        // by the item still.
                        // e.g. the Labo distiller used by the florence flask.
                        GUI.out(furn.useEvent(list[j]));
                        Player.printInv();
                        break;
                    }
                    else {
                        GUI.out("You can't store anything in there."); 
                        break;
                    }
                }

                if (furn.isSearchable() && list.length > 1 && j == list.length)
                    // Only prints if no error was entered.
                    GUI.out("You store them all.");
            }
            else if ((furniture.equals(LOOT_SACK) || furniture.equals("sack")) 
                    && Player.hasItem(LOOT_SACK)) 
            {
                // If the player wants to put something in the loot sack.
                // This case is essentially the same as above.
                Item[] list = Player.getItemList(i.toString(), Player.getInv());
                LootSack sack = (LootSack)Player.getInv().get(LOOT_SACK);
                Player.incrementMoves();
                int j;

                for (j = 0; j < list.length; j++) {
                    if (isNullItem(list, j)) break;

                    Player.evalStore(sack.getInv(), list[j]);
                    Player.printInv();

                    if (list[j].toString().equals(LOOT_SACK) && ! sack.isFull()) {
                        // Player can put the sack inside the sack, because why not.
                        GUI.out("You stuff the sack inside itself and pull the string. "
                              + "All of the sudden, the sack is gone. You stand there, "
                              + "empty-handed, and confused.");
                        break;
                    }
                }

                if (list.length > 1 && j == list.length)
                       GUI.out("You store them all in the sack.");
            }
            else
                GUI.out("There is no " + furniture + " here.");
        }
        // </editor-fold>
        // ====================================================================
        private static boolean isNullItem(Item[] list, int j) {
            if (list[j].equals(Inventory.NULL_ITEM)) {
                if (j == 0)
                    GUI.out("You may have just entered something wrong...");
                else
                    GUI.out("Well, I understood " + list[j-1] + 
                            " but that next thing I didn't get.");
                return true;
            }
            return false;
        }
        // ====================================================================

        public void perform() {
            this.ACTION.run();
        }
    }
    //**************************************************************************
    // </editor-fold> 
    //**************************************************************************


    //**************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Word classes"> 
    //
    // Represent items, actions, and furniture mentioned in player input.
    // Different word subclasses exist to differentiate Command constructors.
    //**************************************************************************
    abstract private static class Word {
        protected final String VALUE;
        // -------------------------
        public Word(String word) {
            this.VALUE = word;
        }
        // -------------------------
        @Override public String toString() {
            return VALUE;
        }
    }
    // ========================================================================
    private static class Verb extends Word {
        public final static Verb 
            PUT_VERB = new Verb("put"),         // Default verb for storing
            GO_VERB = new Verb("go"),           // Default verb for moving
            SEARCH_VERB = new Verb("search");   // Default verb for searching

        public Verb(String verb) {
            super(verb);
        }
    }
    // ========================================================================
    private static class DirectObj extends Word {
        public final static DirectObj 
            FLOOR_OBJECT = new DirectObj("floor");  // For drop commands

        public DirectObj(String object) {
            super(object);
        }
    }
    // ========================================================================
    private static class Instrument extends Word {
        public Instrument(String instrument) {
            super(instrument);
        }
    }
    //**************************************************************************
    // </editor-fold>
    //**************************************************************************
}
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}