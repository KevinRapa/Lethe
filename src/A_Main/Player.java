package A_Main;

import static A_Main.NameConstants.*;
import static A_Main.Patterns.*; 
import A_Super.*;

import java.util.Scanner;           import java.util.ArrayList;
import java.util.HashMap;           import java.io.IOException;
import Tunnels.DungeonMonster;      import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.util.HashSet;

/**
 * Represents the player, the focal point of the game.
 * All player actions originate from the is class. The player has access
 * to its own location, and thereby each furniture and item in the location
 * too.
 * 
 * @author Kevin Rapa
 */
public final class Player {
    private static Room[][][] mapRef;           // Game map reference
    private static Inventory keys;              // Player inventory (for keys)
    private static PlayerInventory inv;         // Player inventory
    private static ArrayList<String> visited;   // Rooms the player has visited so far
    private static boolean end = false;         // Game ends when this is false
    private static int 
        pos[],      // Integer coordinates of the player in the map
        moves,      // How many valid moves the player has made
        score;      // Worth of items in the player's loot sack
    private static String 
        lastVisited,    // Id of the last room the player was in
        shoes;          // Name of the shoes the player wears

    private static final HashMap<String, Runnable> 
        MAIN_CMDS = new HashMap<>(),    // Maps commands from main prompt
        INV_CMDS = new HashMap<>();     // Maps commands from inventory
    private static final HashMap<String, String> 
        ODD_CMD_KEYS = new HashMap<>(); // Maps random commands
    private static final HashSet<String> 
        MAIN_CMD_SET = new HashSet<>(), // Commands from the main prompt
        INV_CMD_SET = new HashSet<>(),  // Commands from the inventory
        ODD_CMD_SET = new HashSet<>();  // Random commands
    
    private static final String 
        NOT_VALID_SLOT = "You don't seem to have an item there.";

    /*
        Maps various commands in the game to their actions 
        Adds the keys to a set which is consulted whenever 
        the player enters something.
    */
    static {
        MAIN_CMDS.put("h", () -> Help.helpSub());
        MAIN_CMDS.put("e", () -> searchSub());
        MAIN_CMDS.put("c", () -> examineSub());
        MAIN_CMDS.put("k", () -> viewKeyRing());
        MAIN_CMDS.put("i", () -> inventoryPrompt());
        MAIN_CMDS.put("w", () -> move(Direction.NORTH));
        MAIN_CMDS.put("s", () -> move(Direction.SOUTH));
        MAIN_CMDS.put("a", () -> move(Direction.WEST));
        MAIN_CMDS.put("d", () -> move(Direction.EAST));
        MAIN_CMDS.put("m", () -> Map.displayMap());
        MAIN_CMDS.put("n", () -> writePrompt());
        MAIN_CMDS.put("l", () -> openLootSack());
        MAIN_CMDS.put("q", () -> {end = true;});
        
        MAIN_CMDS.put("quit",      () -> {end = true;});
        MAIN_CMDS.put("zork",      () -> GUI.out("You must be mistaking me for someone else."));
        MAIN_CMDS.put("inspect",   () -> examineSub());
        MAIN_CMDS.put("examine",   () -> examineSub());
        MAIN_CMDS.put("keys",      () -> viewKeyRing());
        MAIN_CMDS.put("keyring",   () -> viewKeyRing());
        MAIN_CMDS.put("inventory", () -> inventoryPrompt());
        MAIN_CMDS.put("loot",      () -> openLootSack());
        MAIN_CMDS.put("search",    () -> searchSub());
        MAIN_CMDS.put("help",      () -> Help.helpSub());
        MAIN_CMDS.put("scream",    () -> GUI.out("AHHHHHGGGHHH!!!!!"));
        MAIN_CMDS.put("yell",      () -> GUI.out("AHHHHHGGGHHH!!!!!"));
        MAIN_CMDS.put("smell",     () -> GUI.out("Smells like a brisk autumn night in 1932."));
        MAIN_CMDS.put("win",       () -> GUI.out("Oh wait, that's it! You win! Congratulations. You may go home now."));
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
        MAIN_CMDS.put("northwest", () -> evaluateAction("go", "northwest"));
        MAIN_CMDS.put("northeast", () -> evaluateAction("go", "northeast"));
        MAIN_CMDS.put("southwest", () -> evaluateAction("go", "southwest"));
        MAIN_CMDS.put("southeast", () -> evaluateAction("go", "southeast"));
        
        MAIN_CMDS.put("xyzzy",     () -> {
            GUI.out("A hollow clown says, \"surprise!\""); 
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
        ODD_CMD_KEYS.put("eat", "That is quite an ambitious proposition.");
        ODD_CMD_KEYS.put("fight", "Did you have much to drink before you came?");
        ODD_CMD_KEYS.put("speak", "Did you have much to drink before you came?");
        ODD_CMD_KEYS.put("talk", "Did you have much to drink before you came?");
        ODD_CMD_KEYS.put("climb", "Let us act like civilized guests whilst we're here.");
        ODD_CMD_KEYS.put("jump", "Let us act like civilized guests whilst we're here.");
        ODD_CMD_KEYS.put("smell", "You press your nose up against it and inhale deeply.");
        ODD_CMD_KEYS.put("find", "You have already found it detective.");
        ODD_CMD_KEYS.put("count", "You didn't climb all the way up to this precipice to do math.");
        ODD_CMD_KEYS.put("burn", "Yes... burn it... burn it all down to the ground.");
        ODD_CMD_KEYS.put("write", "You are sure the owner wouldn't wanting you doing that.");
        ODD_CMD_KEYS.put("draw", "You are sure the owner wouldn't wanting you doing that.");
        ODD_CMD_KEYS.put("inflate", "Does this look like some kind of balloon to you?");
        ODD_CMD_KEYS.put("deflate", "Does this look like some kind of balloon to you?");
        ODD_CMD_KEYS.put("take", "A futile but worthy attempt.");
        ODD_CMD_KEYS.put("get", "A futile but worthy attempt.");
        
        ODD_CMD_SET.addAll(ODD_CMD_KEYS.keySet());
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
    public static boolean hasItem(String itemName) {
        return Player.inv.contents().stream().
                anyMatch(i -> i.toString().equalsIgnoreCase(itemName));
    }
    /*------------------------------------------------------------------------*/
    /**
     * Checks if the player has an item who's name contains the given word.
     * @param item A word the player types in to refer to an item in his or
     * her inventory.
     * @return if the player has an item who's name resembles item.
     */
    public static boolean hasItemResembling(String item) {
        if (Patterns.SINGLE_DIGIT_P.matcher(item).matches()) {
            // Player used a slot number and not a name
            int i = Integer.parseInt(item);
            return (i <= Player.inv.size());
        }
        else
            // Player typed in an item name
            return Player.inv.contents()
                    .stream()
                    .anyMatch(i -> i.toString()
                    .matches(NO_LETTER_BEFORE + item + NO_LETTER_AFTER));
    }
    // </editor-fold>
    
    // <editor-fold desc="Setters">
    /**
     * Sends the player to Hades.
     * A Zork reference.
     */
    public static void commitSuicide() {
        if (! getPosId().equals(Id.HADS)) {
            incrementMoves();
            
            GUI.out("You succumb to the surreal, yet all too reachable decision. "
                      + "Could this release you from your hopelessness?"); 
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
     * @param dest destination area.
     */
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
    /*------------------------------------------------------------------------*/
    public static void incrementMoves() {
        Player.moves++;
        GUI.updateMovesAndScore(Player.moves, Player.score);
    }
    /*------------------------------------------------------------------------*/
    public static void updateScore(int score) {
        Player.score = score;
        GUI.updateMovesAndScore(Player.moves, Player.score);
    }
    // </editor-fold>
    
    /**
     * Writes fields to a .data file to be read next time a game starts.
     * @param stream ObjectOutputStream to write the file.
     * @throws IOException 
     */
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
        GUI.out("It's about 10:00pm and a warm, humid breeze passes through the trees.\n" +
                "You have just arrived on foot to your destination, and\n" +
                "find it even more colossal than what you had\n" +
                "expected. It also appears curiously more vacant...");
        GUI.promptOut();    
        GUI.out("You slowly approach until inside the front gateway.\n" +
                "A thought briefly flashes in your mind before being\n" +
                "forgotten - what was your business here, again?");     
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

            if (MAIN_CMD_SET.contains(ans)) {// Simple command
                MAIN_CMDS.get(ans).run();
            }

            else if (isNonEmptyString(ans)) // More complicated command
                TextParser.processText(ans);
            
        } while (! end);
        
        return endGameCode();
    }  
    // ========================================================================   
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

            if (dir == Direction.UP || dir == Direction.DOWN)
                ; // Do nothing. Let the stairs play the noise.
            
            else if (dest.isLocked() && ! visited.contains(destId))
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
        Player.incrementMoves();
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
    private static void searchSub() {
        // Initiates dialog asking player for a Furniture to search.
        GUI.menOut(Menus.SEARCH_SUB);
        String searchThis = GUI.promptOut();
        
        if (isNonEmptyString(searchThis) && getPos().hasFurniture(searchThis)) {
            searchPrompt(getFurnRef(searchThis));
        }
        else if (IT_THEM_P.matcher(searchThis).matches() && 
                getPos().hasFurniture(searchThis = GUI.parsePreviousFurniture())) 
        {   // Player used "it" or "them" in place of a furniture name.
            searchPrompt(getFurnRef(searchThis));
        }
        else if (searchThis.equals(LOOT_SACK) || searchThis.equals("sack")) {
            Player.openLootSack();
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
    public static void searchPrompt(Furniture furniture) {
        GUI.out(furniture.getSearchDialog());
        
        if (furniture.isSearchable())
            search(furniture.getInv()); 
    } 
    // ========================================================================  
    /**
     * Subroutine for exchanging itemList between player and furniture inventories.
     * @param furnInv The furniture being searched.
     */
    public static void search(Inventory furnInv) {
        String cmdItm; 
        
        do {
            printInv(furnInv);
            GUI.menOut(Menus.TRADE_SUB);
            
            cmdItm = GUI.promptOut();
            
            if (cmdItm.equals("loot") || cmdItm.equals("l") || cmdItm.equals("take all")) {
                // Takes as many items as possible from the furniture.
                ArrayList<Item> l = new ArrayList<>();
                Player.incrementMoves();
                
                for (Item i : furnInv) {
                    // Finds everything in the inventory the player doesn't have.
                    if (l.size() <= (PlayerInventory.MAX_SIZE - inv.size()))
                        l.add(i);
                }
                for (Item i : l) {
                    // Adds them all to the player's inventory.
                    evalTake(furnInv, i);
                }
                GUI.out("You stuff as much as you can into your pockets.");
            }
            else {
                try (Scanner scan = new Scanner(cmdItm).useDelimiter("\\s+")) {
                    // Gets an item slot.
                    String action = scan.next();            
                    int slot = Integer.parseInt(scan.next());

                    // Evaluates the store or take action given the slot.
                    if (STORE_P.matcher(action).matches()) {
                        Item item = Player.inv.get(slot - 1);
                        evalStore(furnInv, item);                            
                    }            
                    else if (TAKE_P.matcher(action).matches()) {
                        Item item = furnInv.get(slot - 1);
                        evalTake(furnInv, item);
                    }
                    
                    Player.incrementMoves();
                    describeRoom();
                    printInv();
                }
                catch (java.lang.IndexOutOfBoundsException e) {
                    GUI.out(NOT_VALID_SLOT);
                }
                catch (java.util.NoSuchElementException 
                        | java.lang.NumberFormatException e) 
                {
                    if (isNonEmptyString(cmdItm))
                        GUI.out("Excuse me?"); 
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
    private static void evalTake(Inventory furnInv, Item take) {
        if (KEY_P.matcher(take.getType()).matches()) {
            // Matches a non-cave/catacomb room ID, which keys use as types.
            addToKeyRing(take, furnInv);
            AudioPlayer.playEffect(3);
            GUI.out("You put the " + take + " into your key ring.");
        }
        else {
            GUI.out("You take the " + take);
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
// <editor-fold defaultstate="collapsed" desc="ACTIVATING AND INSPECTING">  
//****************************************************************************** 
    /**
     * Processes a player's action on furniture.
     * Player may use 'it' or 'them' to reference the last entered furniture.
     * @param object the name of the furniture being acted upon.
     * @param verb the action the player is performing on the furniture.
     */
    public static void evaluateAction(String verb, String object) {
        // <editor-fold defaultstate="collapsed" desc="MOVE COMMAND">
        if (WALK_P.matcher(verb).matches()) {
            if (DIRECTION_P.matcher(object).matches())
                parseMovement(object);
            else if (INVALID_DIR_P.matcher(object).matches())
                GUI.out("Your humble life as a tradesman knows not how to move " + object + ".");
            else 
                GUI.out("You aren't sure which way that it.");
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="COMMAND ON FURNITURE">
        else if (getPos().hasFurniture(object)) {
            // In this case, a valid furniture exists to be interacted with.
            Furniture furn = getFurnRef(object);

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
            else if (SEARCH_P.matcher(verb).matches() || ((verb.equals("open") 
                    || verb.equals("empty")) && furn instanceof Openable)) {       
                searchPrompt(furn); // Player implied a search
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
                    GUI.out(ODD_CMD_KEYS.get(verb));
                else 
                    GUI.out("Doing that to the " + object + " seems unnecessary right now.");
            }
        }   
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="REFLEXIVE COMMANDS">
        else if (object.equals("self") || object.equals("yourself")) {
            if (CHECK_P.matcher(verb).matches()) {
                Player.incrementMoves();
                GUI.out("Yes, all your parts are still there, thank goodness."); 
            }
            else if (SEARCH_P.matcher(verb).matches()) {              
                GUI.out("Ummm... is this what you meant??");
                inventoryPrompt();
            }
            else if (MOVE_P.matcher(verb).matches()) {
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
            if (object.equals("sack") || object.equals(LOOT_SACK))
                Player.openLootSack(); 
            else if (object.equals(SHOE_BOX))
                getInv().get(SHOE_BOX).useEvent(); 
            else if (Player.hasItemResembling(object))
                GUI.out("You don't possess the education level to open the " + object + ".");
            else
                GUI.out("You aren't quite sure what to do about that.");
        }
        else if (verb.equals("speak") || verb.equals("say")) {
            // Player typed something like "<speak> <words>".
            GUI.out("You speak the words, but they only echo and fade.");
        }
        else if (GEN_FURNITURE_P.matcher(object).matches()) {
            // Player used a very vague term to interact with.
            GUI.out("Don't be lazy now. Enter in something specific.");
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
    /**
     * Finds furniture in the room that will move the player up or down.
     * @param dir Up or down direction.
     */
    private static void findStaircase(Direction dir) {
        for (Furniture f : Player.getPos().getFurnishings()) {
            if (f instanceof Staircase && ((Staircase)f).getDirection() == dir) {
                GUI.out(f.interact("climb"));
                return;
            }
            if (f instanceof DoubleStaircase) {
                GUI.out(f.interact(dir.toString()));
                return;
            }
            if (f instanceof Climbable) {
                GUI.out(f.interact("climb"));
                return;
            }
        }
        GUI.out("There's nothing here to take you that way.");
    }
    // ========================================================================
    /**
     * Prompts the player for furniture to examine.
     */
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
        
        if (getPos().hasFurniture(inspecting)) {
            // The furniture exists.
            Player.incrementMoves();
            GUI.out(Player.getFurnRef(inspecting).getDescription());
        }
        else if (GEN_FURNITURE_P.matcher(inspecting).matches())
            // The player typed something vague like 'furniture' or 'stuff'
            GUI.out("That's quite vague of you. Please be more specific.");
        
        else 
            GUI.out("There is no " + inspecting + " here that you can see.");
    }
    // ========================================================================
    private static void openLootSack() {
        if (Player.hasItem(LOOT_SACK))
            Player.getInv().get(LOOT_SACK).useEvent();
        else 
            GUI.out("You unfortunately do not have a giant sack of loot right now."); 
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
    /**
     * Brings up the main inventory prompt and asks the player to enter an option.
     */
    private static void inventoryPrompt() {
        printInv();
        AudioPlayer.playEffect(1);
        String ans;
        
        do {
            GUI.menOut(Menus.INV_MAIN);
            
            ans = GUI.promptOut();
            
            if (INV_CMD_SET.contains(ans))
                INV_CMDS.get(ans).run();
            
            else if (isNonEmptyString(ans))
                GUI.out("That was not a valid choice.");
            
        } while (isNonEmptyString(ans));
        
        GUI.clearDialog();
    }
    // ========================================================================  
    private static void inspectPrompt() {
        String ans;            
        
        do {
            // Prompts for furniture to inspect.
            GUI.menOut(Menus.INV_INSPECT);
            ans = GUI.promptOut();
            
            try {
                int slot = Integer.parseInt(ans);
                Item item = Player.inv.get(slot - 1);
                Player.incrementMoves();
                GUI.out(item.getDesc());  
            }
            catch (java.lang.NumberFormatException | java.lang.IndexOutOfBoundsException e) {
                if (isNonEmptyString(ans)) 
                    // Player typed too high a digit or a non-digit
                    GUI.out(NOT_VALID_SLOT);
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
        String choice;
        
        do {      
            choice = GUI.askChoice(Menus.INV_USE, DIGIT_OR_BLANK_P);

            try {
                int slot = Integer.parseInt(choice);
                Item item = Player.inv.get(slot - 1);
                int useID = item.getUseID();
                
                switch (useID) {
                    case 1: // Item only prints a dialog.
                        GUI.out(item.useEvent()); break;           
                    case 2: // Item is used on furniture.
                        GUI.menOut(Menus.INV_USEON);
                        evalUse(item, GUI.promptOut());
                }
            }
            catch (IndexOutOfBoundsException | NumberFormatException e) {
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
            Player.incrementMoves();

            if (target.useKeyMatches(item.toString())) {
                GUI.out(target.useEvent(item));
                describeRoom();
                printInv();
            }
            else {
                GUI.out("You jam the " + item + " into the " + furniture +
                        "\nas hard as you can, but nothing happens.");
            }
        }                      
        else if (isNonEmptyString(furniture)) 
            GUI.out("There is no " + furniture + " here that you can see."); 
        
        printInv();
    }
    // ======================================================================== 
    /**
     * Allow the player to write a note to itself. This can only be done if the
     * player has the notepad and a pen.
     */
    public static void writePrompt() {
        if (inv.size() >= PlayerInventory.MAX_SIZE) {
            GUI.out("You are carrying too much stuff to write a note.");
        }
        else if (! (Player.hasItem(PEN) && Player.hasItem(NOTEPAD))) {
            GUI.out("You will need a pen and notepad in order to write a note to yourself.");
        }
        else {
            GUI.menOut("\nWrite a title for\nyour note, or enter\n"
                       + "a slot number to\nwrite to an existing\nnote.");
            
            String title = GUI.promptOut();

            if (! isNonEmptyString(title)) 
                ; // Go back to main prompt
            else if (ANY_DIGIT_P.matcher(title).matches()) {
                int slot = Integer.parseInt(title);

                if (slot > 0 && slot <= inv.size()) {
                    Item n = inv.get(slot - 1);

                    if (n instanceof Note && ! (n instanceof Book)) {
                        Player.inv.remove(n);
                        Player.inv.contents().add(
                            new Note(n.toString(), n.getDesc() + ' ' + getNoteBody())
                        );
                        Player.incrementMoves();
                        printInv();
                    }
                    else 
                        GUI.out("That, sir, is not a note.");
                }
                else GUI.out(NOT_VALID_SLOT);
            }
            else {
                Player.inv.contents().add(
                    new Note("note - " + title + ':' + ' ', getNoteBody())
                );
                Player.incrementMoves();
                printInv();
            }
        }
    }
    // ========================================================================
    private static String getNoteBody() {
        GUI.menOut("Noted. Write down your momento now...");
        String body = GUI.promptOut();
        GUI.out("Note has been written.");
        return body;
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
                Player.incrementMoves();
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
        public final int POS[], SCORE, MOVES;
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
            this.SCORE = Player.score;
            this.MOVES = Player.moves;
        }
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}
