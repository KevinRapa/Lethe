package A_Main;

import java.util.HashMap;
import static A_Main.Patterns.*;
/**
 * This class comprises the help section of the game.
 * The Help is comprised of nested menus directing the player to different
 * help topics.
 * @author Kevin Rapa
 */
public class Help {
    private static final HashMap<String, String> 
            HELP = new HashMap<>(), // Maps keys to topics
            TOPIC = new HashMap<>(); // Maps topics to explanations.
/*----------------------------------------------------------------------------*/     
    private static final String[] HELP_KEYS = 
        {"prompt", "moving", "describing", "checking", "searching", "activating",
         "using", "combining", "inspecting", "notes", "inventory", "key ring", "phylacteries",
         "doors", "rooms", "furniture", "items", "keys", "phylacteries"};
/*----------------------------------------------------------------------------*/    
    private static final String[] TOPIC_KEYS = 
        {"1c","2c","3c","4c","5c","6c","7c","8c","9c","10c",
         "1p","2p","3p","1a","2a","3a","4a","5a","6a"};
/*----------------------------------------------------------------------------*/     
    private static final String[] HELP_VALUES = {
        "When prompted for input, the desired type of input will appear in "
      + "angle brackets.\t\t\t\t\t"
      + "Simple types of input ------ "
      + "<item> - Enter an item name.\n"
      + "<object> - Enter an object in the room.\t\t\t" +
        "<'x'> - Enter what's quoted.\t" +
        "<#> - Enter a digit.\t\t" +
        "< > - Enter nothing.\t\t\t\t\t"
      + "Compound input -------------\t" +
        "<(item)> - An optional item.\t" +   
        "<?,?,?> - Enter a list of ?, separated by commas.\t\t" +
        "<?/?/?> - Enter any one. "
      + "<action object> - Enter the name of an action followed by the name of an object.", 
         
        "In this game, you may move in four directions; north, south, east, " +
        "west, up, and down. For your convenience, the shortcuts for the " +
        "first four of these are 'w', 's', 'd', and 'a'. After all, you may " +
        "find yourself fatigued after typing words for such a long time. " +
        "Your job right now is to explore, not write an essay! Of course, " +
        "my job is not to impose on your freedom.", 
         
        "Whenever you enter an area, the description for it is automatically " +
        "displayed in the center panel. You will find this useful on a " +
        "continual basis, for this is a text-based game, so there are " +
        "more-or-less no pictures. You may interact with things you read " +
        "in the description, barring some indistinct nouns such as " +
        "\"atmosphere\", \"room\", and \"east\". For your convenience, you " +
        "may enter \"map\" or \"m\" so view a modest image of your location " +
        "in order to get a quick feel for the directions you may move " +
        "to from your current location.", 
         
        "You may examine things you enounter by entering an appropriate verb " +
        "(\"examine\", \"look at\", etc.) followed by the thing you wish to examine. " +
        "For your convenience, the shortcut for this is \"c\" for \"check\" (e.g. \"c window\"). You " +
        "may find this command useful in order to reveal clues about hidden " +
        "objects as well as to add color to your imagination.", 
         
        "Searching is one of the most useful commands you will use in order " +
        "to progress. You can search by entering an appropriate verb " +
        "(\"search\", \"look in/around\", etc.) followed by the thing you wish " +
        "to search. You may use the shortcut key \"e\" at your leisure (e.g. \"e table\"). If " +
        "the object can be searched, you will be taken to a sub-prompt for " +
        "exchanging items with the object's contents. Remember that even if " +
        "something cannot be searched, this doesn't imply that it doesn't " +
        "contain useful stuff! When trading items with furniture, use the " +
        "commands \"take\" or \"store\" (shortcut are \"t\" and \"s\") followed by " +
        "the inventory slot the item is in.", 
         
        "The somewhat famous (in the right community) early-eighties text-based " +
        "computer game \"Zork\" was known for its respectably sophisticated " +
        "text processor. This game attempts to accomplish the same, and thus " +
        "allows reasonable sentences to be entered for input in addition to " +
        "the simple commands like \"search desk\" and \"climb stairs\". Communicate " +
        "to this game as if your were casually speaking. For instance, you may " +
        "type things like \"walk to the north\", \"look inside the cabinet\", and " +
        "even chain commands together like \"walk through the east door and " +
        "then search the table\". If you previously referenced an object, you " +
        "may use \"it\" or \"them\" instead of the name. For instance \"look through " +
        "the window\" and then \"open it\" is valid. You may interact with items " +
        "in your inventory in the same way as an alternative to entering your " +
        "inventory. Just remember, you can interact with items only if your " +
        "are carrying them! And also, be respectful and avoid profanity, for " +
        "you are playing a high-class character in a sophisticated setting.",
         
        "Of course, you may use items that you are carrying. This is done from " +
        "the inventory, and most of the time, you will be asked what to use " +
        "the item on. As an alternative, you may use items directly from the " +
        "main prompt. For instance, \"break the door with the warhammer\" is " +
        "valid. When using items this way, you can enter in its name or the " +
        "slot it's in. Note that you don't need to enter in the WHOLE name. " +
        "For instance, if you are carrying a book called \"guide, \"Not Dying " +
        "for the Unlearned\", you may reference it by the name \"guide\". Be " +
        "careful though, since if you are carrying multiple guides, this may " +
        "not do what you expect.", 
         
        "Combining is a useful action you may need to do from time to time. " +
        "This is the act of entering in two or three objects to combine. If " +
        "they are combinable, they will be exchanged for a newly crafted " +
        "item. Combining is done from the inventory and the syntax is two " +
        "or three item slots separated by commas. As a shortcut, you can " +
        "enter \"combine\" or even just \"combine <#,#(,#)>\" from the main " +
        "prompt. Combining is done all at once. Thus, if a hilt, pommel, " +
        "and blade are combined to make a sword, do not try to combine 2 of " +
        "them and then the 3rd later; combine all 3 at the same time. When " +
        "following a recipe, sometimes it requires multiple combine actions " +
        "in order to finish the recipe. In other words, sometimes crafted " +
        "items are ingredients for other crafted items.", 
         
        "Items may be examined in the same way furniture are. Inspecting is " +
        "done from the inventory, however you may type \"examine <item>\" from " +
        "the main prompt as long as you are carrying the item. You may also " +
        "substitute the item's slot number as alternative to its name, and " +
        "take note that entering in the complete name of the item is not " +
        "always necessary. Inspecting can be useful for discovering hidden " +
        "information about items, and it may clue you into the next course " +
        "of action.", 
         
        "As you progress, you may find yourself frequently dropping and " +
        "storing items. You may also wish to make notes of interesting " +
        "things you find and would like to remember for later. If you " +
        "possess both pen and a notepad to write on, you may write " +
        "momentos to yourself. Enter 'note', 'n', or 'write' at the main prompt " +
        "to do this. Alternatively, you may do this from your inventory " +
        "by entering in choice '5'.",
        
        "Access your inventory by entering \"i\" from the main prompt. " +
        "Your inventory's contents will be listed. From here, you may " +
        "inspect, use, and combine items. You may also sort your " +
        "inventory by entering \"sort\" from the inventory or from the " +
        "main prompt.", 
         
        "Access your key ring by entering 'k' from the main prompt. " +
        "The keys you are carrying will be listed. You cannot drop keys; " +
        "you just have them forever! If you take a key from a search, it " +
        "will automatically be added to your key ring.", 
         
        "Phylacteries are stored in your inventory. These are important! " +
        "You cannot store or drop them. That is all.",    
         
        "Most rooms have at least one door, and thus you may act on them from the\n" +
        "main prompt using the name 'door'. However, you do not need to act on doors\n" +
        "in general movement. Your character moves through them automatically, if\n" +
        "they are unlocked, unblocked, etc.", 
         
        "The castle is made of rooms separated by doors and walls. A room may " +
        "be one, two, or even more areas large! Inside and outside the room are " +
        "'objects', which are any nouns in the room's description. In " +
        "everyday life, we call these objects 'furniture' or 'stuff'. If " +
        "you wish to see a humble image of where you are, you may enter \"m\" " +
        "or \"map\" from the main prompt.", 
         
        "'Furniture' or more appropriately 'room objects' are any nouns in the room\n" +
        "description. This means you can interact with them from the main prompt.", 
         
        "Items are things that go into your inventory or key ring. You may take "
      + "them or store them in searches (excluding keys and phylacteries for "
      + "storing). You may use, combine, and inspect them from either your "
      + "inventory or the main prompt.", 
         
        "Keys get added to your keyring automatically upon picking up, and you " +
        "may not rid yourself of them. Key are used to enter locked rooms and " +
        "unlock things like cabinets and chests. Take note that a key is not " +
        "necessarily needed to enter a locked room! In this game, you needn't " +
        "attempt to unlock the door to a room if you have a key. This is done " +
        "automatically for you.", 
         
        "In Zork, your primary objective as an explorer was to collect " +
        "treasure. You may do the same here, but seeing as you are in " +
        "a more dire circumstance, you primary job is to collect " +
        "phylacteries (of which there are 5). Perhaps you should speak " +
        "with the glass orb in the vestibule for more information on this."
    };
/* CONSTRUCTOR ---------------------------------------------------------------*/       
    /**
     * Puts together the two dictionaries.
     */
    public static void constructHelp() {
        int index = 0;
        
        for (String helpKey : HELP_KEYS) {
            HELP.put(helpKey, HELP_VALUES[index++]);      
        }
        index = 0;
        
        for (String topicKey : TOPIC_KEYS) {
            TOPIC.put(topicKey, HELP_KEYS[index++]); 
        }
    }
/*----------------------------------------------------------------------------*/
    private static String get_help(String topic) {
        return HELP.get(topic); 
    }
//******************************************************************************
// <editor-fold desc="SUB-MENUS">
//******************************************************************************
    /**
     * A structure of nested menus organizing game topics.
     */
    public static void helpSub() {        
        String choice;
        AudioPlayer.playEffect(2);
        
        do {
            GUI.menOut(Menus.HELP_MAIN);
            choice = GUI.promptOut();

        /*--------------------------------------------------------------------*/            
            if (choice.equals("1")) {
                AudioPlayer.playEffect(2);
                
                do {
                    GUI.menOut(Menus.HELP_SUB1);

                    choice = GUI.promptOut().concat("c");

                    if (CONTROL_CHOICE.matcher(choice).matches()) {
                        AudioPlayer.playEffect(2);
                        GUI.out(get_help(TOPIC.get(choice)));  
                    }
                } while (! choice.equals("c"));          
            }
        /*--------------------------------------------------------------------*/          
            else if (choice.equals("2")) {    
                AudioPlayer.playEffect(2);
                
                do {
                    GUI.menOut(Menus.HELP_SUB2);

                    choice = GUI.promptOut().concat("p");
                    
                    if (PLAYER_CHOICE.matcher(choice).matches()) {
                        AudioPlayer.playEffect(2);
                        GUI.out(get_help(TOPIC.get(choice)));
                    }
                    
                } while (! choice.equals("p"));    
            }
        /*--------------------------------------------------------------------*/      
            else if (choice.equals("3")) {    
                AudioPlayer.playEffect(2);
                
                do {
                    GUI.menOut(Menus.HELP_SUB3);

                    choice = GUI.promptOut().concat("a");
                    
                    if (CASTLE_CHOICE.matcher(choice).matches()) {
                        AudioPlayer.playEffect(2);
                        GUI.out(get_help(TOPIC.get(choice)));
                    }
                    
                } while (! choice.equals("a"));
            }
        /*--------------------------------------------------------------------*/      
        } while (! choice.equals(""));   
        
        GUI.clearDialog();
        GUI.toMainMenu();
        GUI.clearDialog();
    }
//******************************************************************************
// </editor-fold>
//******************************************************************************   
}
