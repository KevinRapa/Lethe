package A_Main;

import java.util.HashMap;
import java.util.regex.Pattern;
import static A_Main.Patterns.*;
/**
 * This class comprises the help section of the game.
 * The Help is comprised of nested menus directing the player to different
 * help topics.
 * @author Kevin Rapa
 */
public final class Help {
    private static final HashMap<String, String> 
            HELP = new HashMap<>(), // Maps keys to topics
            TOPIC = new HashMap<>(); // Maps topics to explanations.
     
    private static final String[] HELP_KEYS = 
        {"prompt", "moving", "describing", "checking", "searching", "activating",
         "using", "combining", "inspecting", "notes", "inventory", "key ring", "phylacteries",
         "loot", "doors", "rooms", "furniture", "items", "keys", "phylacteries"};
    
    private static final String[] TOPIC_KEYS = 
        {"1c","2c","3c","4c","5c","6c","7c","8c","9c","10c",
         "1p","2p","3p","4p","1a","2a","3a","4a","5a","6a"};
     
    private static final String[] HELP_VALUES = {
        "When prompted for input, the format may appear in "
      + "angle brackets.            "
      + "<item> - Enter an item name.                    " +
        "<left> - Left arrow key.   " +
        "<'x'> - Enter what's quoted.                   " +
        "<#> - Enter a digit.       " +
        "< > - Enter nothing.       " +
        "<(?)> - An optional item or item slot.        " +   
        "<?/?/?> - A choice of ?.   "
      + "<'s' list> - 's' followed by a comma separated list.             "
      + "             Hot keys which you may find useful: Press "
      + "shift to swap the inventory and dialog panels. The left and right "
      + "arrow keys can be used to scroll up and down if scroll bars appear. "
      + "You may also use the up arrow key to browse previous input and the "
      + "down arrow key to clear the input panel. ", 
         
        "In this game, you may move in six directions; north, south, east, " +
        "west, up, and down. For your convenience, the shortcuts for the " +
        "first four of these are 'w', 's', 'd', and 'a'. After all, you may " +
        "find yourself fatigued after typing words for such a long time. " +
        "Your job right now is to explore, not write an essay! Of course, " +
        "my job is not to impose on your freedom.", 
         
        "Whenever you enter an area, the description for it is automatically " +
        "displayed. You will find this useful on a " +
        "continual basis, for this is a text-based game, so there are " +
        "more-or-less no pictures. You may interact with things you read " +
        "in the description, barring some indistinct nouns such as " +
        "\"atmosphere\", \"the room\", and \"east\". For your convenience, you " +
        "may enter \"map\" or \"m\" so view a modest image of your location " +
        "in order to get a quick feel for the directions you may move to.", 
         
        "You may examine things you enounter by entering an appropriate verb " +
        "(\"examine\", \"look at\", etc.) followed by the thing you wish to examine. " +
        "The shortcut for this is \"c\" for \"check\" (e.g. \"c the window\"). An "
      + "even shortercut for this is to just enter the name of it and nothing else! You " +
        "may find this command useful in order to reveal clues about hidden " +
        "objects as well as to add color to your imagination. You may examine items " +
        "in your inventory the same way, but remember that furniture in the room will be " +
        "prioritized first, so if there is both a sack in both the inventory and room, " +
        "the game will think you mean the sack in the room!", 
         
        "You can search by entering an appropriate verb " +
        "(\"search\", \"look in/around\", etc.) followed by the thing you wish " +
        "to search. You may use the shortcut key \"e\" at your leisure (e.g. \"e the table\"). If " +
        "the object can be searched, you will be taken to a sub-prompt for " +
        "exchanging items with the object's contents. Remember that even if " +
        "something cannot be searched, this doesn't imply that it doesn't " +
        "contain useful stuff! When trading items with furniture, use the " +
        "commands \"take\" or \"store\" (shortcut are \"t\" and \"s\") followed by " +
        "a list of items (e.g. \"take the pen, notepad, and 4\"). Enter \"loot\" to " + 
        "take as many things as possible. You may also inspect things before you pick " +
        "them up by entering the item's slot number.", 
         
        "The somewhat famous (in the right community) 1977 text-based " +
        "computer game \"Zork\" was known for its respectably sophisticated " +
        "text parser. This game attempts to accomplish the same, and thus " +
        "allows reasonable sentences to be entered for input in addition to " +
        "the simple commands like \"search desk\" and \"climb stairs\". You may " +
        "type things like \"go to the north\", \"look inside the cabinet\", and " +
        "even chain commands together like \"walk through the east door and " +
        "then search the table\". Take note that the game always thinks 'and' " +
        "leads to a second command, UNLESS you precede it with a comma " + 
        "(e.g. \"drop 2, 3, and 6\"). If you previously referenced an object or item, you " +
        "may use \"it\" or \"them\" instead of the name. For instance \"open the window " +
        "and then climb through it\" is valid. You may interact with items " +
        "in your inventory in the same way as an alternative to entering your " +
        "inventory. Just remember, you can interact with items only if you're " +
        "carrying them. A couple other things- entering just the name of furniture " +
        "and nothing else implies examining. Also, be respectful and avoid profanity, " +
        "for you are playing a high-class character in a sophisticated setting.",
         
        "You may use items directly from the " +
        "main prompt. For instance, \"break the door with the axe\" or " +
        "\"drop 1, 4, and 6\". When using items this way, you can enter in its name or the " +
        "slot it's in. Note that you don't need to enter in the WHOLE name. " +
        "For instance, if you are carrying a book called \"guide, \"Not Dying " +
        "for the Unlearned\", you may reference it by the name \"guide\". Be " +
        "careful though, since if you are carrying multiple guides, the first " +
        "one will be prioritized.", 
         
        "You can combine 2 or 3 objects into a new object if " +
        "they are combinable. Combining is done from the inventory. The syntax is two " +
        "or items or slots separated by commas. As a shortcut, you can " +
        "enter \"combine\" or even just \"combine <item,item(,item)>\" from the main " +
        "prompt. Be careful, typing \"combine the sword and handle\" from the main prompt doesn't work " +
        "because the game thinks anything after 'and' is a second command. However, " +
        "preceding 'and' with a comma would work: \"combine the sword, and handle\", " + 
        "or \"combine sword, handle\". Combining is done all at once. Thus, if a hilt, pommel, " +
        "and blade are combined to make a sword, do not try to combine 2 of " +
        "them and then the 3rd later; combine all 3 at the same time. Though when " +
        "following a recipe, sometimes it requires multiple combine actions " +
        "in order to finish the recipe. In other words, sometimes crafted " +
        "items are ingredients for other crafted items.", 
         
        "Items may be examined in the same way furniture are. Inspecting is " +
        "done from the inventory, however you may type \"examine <item>\" "
      + "or even just the item slot from the main prompt as long as you are "
      + "carrying the item. You may also substitute the item's slot number as "
      + "an alternative to its name. Take note that entering in the complete "
      + "name of the item is not always necessary. Inspecting can also be done "
      + "during a search if you want to look at an item before picking it up. "
      + "Inspecting can be useful for discovering hidden information about "
      + "items, and it may clue you into the next course of action.", 
         
        "As you progress, you may find yourself frequently dropping and " +
        "storing items. You may also wish to make notes of interesting " +
        "things you find and would like to remember for later. If you " +
        "possess both pen and a notepad to write on, you may write " +
        "momentos to yourself. Enter 'n' at the main prompt " +
        "to do this. Alternatively, you may do this from your inventory " +
        "by entering in choice '5'. As a quick reminder, you may drop items " +
        "by entering \"drop list\" from the main prompt.",
        
        "Access your inventory by entering \"i\" from the main prompt. " +
        "Your inventory's contents will be listed. From here, you may " +
        "inspect, use, and combine items. You may also sort your " +
        "inventory by entering \"sort\" from the inventory or from the " +
        "main prompt. Keep in mind that for anything you can do from the " +
        "inventory, you can also accomplish directly from the main prompt.", 
         
        "Access your key ring by entering 'k' from the main prompt. " +
        "The keys you are carrying will be listed. You cannot drop keys; " +
        "you just have them forever! If you take a key from a search, it " +
        "will automatically be added to your key ring.", 
         
        "Phylacteries are stored in your inventory. These are important! " +
        "By entering 'l' from the main prompt, you can see how many " + 
        "phylacteries you are carrying.",    
        
        "Whoever owns this castle must be quite powerful and wealthy, and " +
        "of course such hardship that you are being put through should " +
        "not go without compensation! If you have a loot sack, access it " +
        "by entering 'l' at the main prompt. Items you add to " +
        "it will increase or decrease your wealth. The loot sack also " +
        "offers valuable storage space in addition to your inventory too.",
         
        "Most rooms have at least one door, and thus you may act on them from the " +
        "main prompt using the name 'door'. However, you do not need to act on doors " +
        "in general movement. Your character moves through them automatically if " +
        "they are unlocked, unblocked, etc., by simply moving.", 
         
        "The castle is made of rooms separated by doors and walls. A room may " +
        "be one, two, or even more areas large! Inside and outside the room are " +
        "'objects', which are any nouns in the room's description. In " +
        "everyday life, we call these objects 'furniture' or 'stuff'. If " +
        "you wish to see a humble image of where you are, you may enter \"m\" " +
        "or \"map\" from the main prompt.", 
         
        "'Furniture' or more appropriately 'room objects' are any nouns in the room " +
        "description. This means you can interact with them from the main prompt.", 
         
        "Items are things that go into your inventory or key ring. You may take "
      + "them or store them in searches (excluding keys and phylacteries for "
      + "storing). You may use, combine, and inspect them from either your "
      + "inventory or the main prompt. There are a couple items which have "
      + "inventories themselves, for which case you may type 'open <item>' to search them.", 
         
        "Keys get added to your keyring automatically upon picking up, and you " +
        "may not rid yourself of them. Key are used to enter locked rooms and " +
        "unlock things like cabinets and chests. Take note that a key is not " +
        "necessarily needed to enter a locked room! In this game, you needn't " +
        "attempt to unlock a door if you have a key. This is done " +
        "automatically for you.", 
         
        "In Zork, your primary objective as an explorer was to collect " +
        "treasure. You may do the same here, but seeing as you are in " +
        "a more dire circumstance, you primary job is to collect " +
        "phylacteries (of which there are 5). As a secondary objective, " +
        "you can raise your score by adding valuable items to the " + 
        "loot sack (If you can find it!)."
    };
    
    static {
        int index = 0;
        
        for (String helpKey : HELP_KEYS) {
            HELP.put(helpKey, HELP_VALUES[index++]);      
        }
        index = 0;
        
        for (String topicKey : TOPIC_KEYS) {
            TOPIC.put(topicKey, HELP_KEYS[index++]); 
        }
    }
//-----------------------------------------------------------------------------
    /**
     * A structure of nested menus organizing game topics.
     */
    public static void helpSub() {        
        String choice;
        AudioPlayer.playEffect(2);
        
        do {
            GUI.menOut(Menus.HELP_MAIN);
            choice = GUI.promptOut();

            if (choice.equals("1")) {
                innerLoop(Menus.HELP_SUB1, CONTROL_CHOICE, "c");          
            }
            else if (choice.equals("2")) {  
                innerLoop(Menus.HELP_SUB2, PLAYER_CHOICE, "p");  
            }
            else if (choice.equals("3")) {   
                innerLoop(Menus.HELP_SUB3, CASTLE_CHOICE, "a");
            }
        } while (! choice.equals(""));   
        
        GUI.clearDialog();
        GUI.toMainMenu();
        GUI.clearDialog();
    }
    //-------------------------------------------------------------------------
    private static void innerLoop(String menu, Pattern p, String code) {
        String choice;
        AudioPlayer.playEffect(2);
        do {
            GUI.menOut(menu);

            choice = GUI.promptOut().concat(code);

            if (p.matcher(choice).matches()) {
                AudioPlayer.playEffect(2);
                GUI.out(HELP.get(TOPIC.get(choice)));
            }
        } while (! choice.equals(code));
    }
    //-------------------------------------------------------------------------
}
