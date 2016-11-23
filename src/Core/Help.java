package Core;

import java.util.HashMap;
/**
 * This class comprises the help section of the game.
 * The Help is comprised of nested menus directing the player to different
 * help topics.
 * @author Mantis Toboggan
 */
public class Help {
    
    private static final HashMap<String, String> HELP = new HashMap<>(); // Maps keys to topics
    private static final HashMap<String, String> TOPIC = new HashMap<>(); // Maps topics to explanations.
/*----------------------------------------------------------------------------*/     
    private static final String[] HELP_KEYS = 
        
        {"prompt", "moving", "describing", "checking", "searching", "activating",
         "using", "combining", "inspecting", "inventory", "key ring", "phylacteries",
         "doors", "rooms", "furniture", "items", "keys", "phylacteries"};
        
/*----------------------------------------------------------------------------*/    
    private static final String[] TOPIC_KEYS = 
    
        {"1c","2c","3c","4c","5c","6c","7c","8c","9c",
         "1p","2p","3p","1a","2a","3a","4a","5a","6a"};
    
/*----------------------------------------------------------------------------*/     
    private static final String[] HELP_VALUES = 
    
        {"-3- Enter '3' to do this.\n" +
         "-item- Enter an item to do this.\n." +
         "-'xyz'- Enter exactly what's quoted to do this.\n" +
         "- - Enter nothing to back out.\n\n.", 
         
         "In this game, you may move four directions; north, south, east, and west.\n"
       + "The keys for this are 'w', 's', 'a', and 'd'. Really, who wants to type\n"
       + "in 'north' every time they want to move?", 
         
         "When you enter a room, especially for the first time, you may want to read\n"
       + "a description of it because this is a text-based game, so there are more or\n"
       + "less no pictures. Dang! The room description is displayed automatically\n"
       + "upon entering the room.\n"
       + "In each room's description, you will find necessary information about the\n"
       + "objects in the room and what you may interact with. You many interact with any noun in the description (search, interact,\n"
       + "and check). As an exception, the room itself mentioned in the room description may not be \n"
       + "interacted with.\n", 
         
        "Checking is a main action, and is performed from the main prompt. The key for\n" +
        "checking is 'c' for check. You may check any one- or two-word noun in the room \n" +
        "description, and the action will describe that object for you. Unlike describing,\n" +
        "you mostly cannot interact with nouns in the 'check' description, unless it is\n" +
        "intuitively obvious (e.g. a button, lever, wheel is revealed). Otherwise, I would\n" +
        "have to recursively make objects down to the atomic level. As just mentioned, \n" +
        "checking is important, as it can reveal clues about hidden objects and other\n" +
        "things, as well as add color to what's in your head.\n", 
         
        "Searching is a main action, and is performed from the main prompt. The key for\n" +
        "searching is 'e'. It's just easy to reach. You may search any\n" +
        "noun in the room description, and your character will search the object. If the\n" +
        "object is searchable, you will be taken to the search sub-prompt. In addition,\n" +
        "any items the object contains will be listed. Remember, an object may contain\n" +
        "useful stuff, but you will not always be able to take it right away!\n" +
        "\n" +
        "The search sub-prompt will ask if you want to take or store items. To do this,\n" +
        "type 'take' or 'store' followed by a space, and then the item's slot.\n" +
        "You may always press just enter to back up to the main prompt.\n", 
         
        "Interacting is a main action, and is performed from the main prompt. The key for\n" +
        "interacting is 'x' for execute. You may interact with any noun in the room\n"
      + "description, and your character will interact with the object.\n" +
        "Interacting means your character is doing something to/with the object, like\n" +
        "'pull', 'sit', etc.\n" +
        "From here, you will be taken to the interact sub-prompt." +
        "You may type 'search <object>' to search the object if you wish,\n" +
        "and 'view/look/watch/inspect <object>' to check the object.\n",
         
        "Using is an inventory action, and is performed from the inventory ('i'). To\n" +
        "use an item, press '2' from the inventory menu, and you will be asked to\n" +
        "type an item to use. Type the item's slot as it appears in your inventory and press\n"
      + "'enter'. An item could be used on objects, itself, or \n" +
        "not be useful at all! If it is to be used on an object in the room, you will \n" +
        "be asked to type in the object before pressing 'enter'.\n", 
         
        "Combining is an inventory action, and is performed from the inventory ('i'). To\n" +
        "combine items, press '3' from the inventory menu, and you will be asked to type\n" +
        "items to combine. Type in the item slot numbers, separated by a comma and space, and press\n" +
        "enter. You\n" +
        "must type AT LEAST 2 items to combine, and NO MORE than 3. A set of combinable\n" +
        "items are combined at once. For example, if a hilt, pommel, and blade are combined\n" +
        "to make a sword, do not try to combine 2 of them and then the 3rd later; combine \n" +
        "all 3 at the same time.\n", 
         
        "Inspecting is an inventory action, and is performed from the inventory ('i'). To\n" +
        "inspect an item, press '1' from the inventory menu, and you will be asked to type\n" +
        "an item to inspect. Type in the items slot number and press enter.\n" +
        "Inspecting is the simplest inventory action. Upon inspecting, you will be given\n" +
        "a description of the item. This can be important, as it may reveal information\n" +
        "about what the item does.\n", 
         
        "Access your inventory by pressing 'i' from the main prompt and pressing 'enter'.\n" +
        "Your inventory's contents will be listed. From here, you may perform the\n" +
        "inventory actions 'inspect', 'use', and 'combine'. Press just enter to back\n" +
        "out to the main prompt.\n", 
         
        "Access your key ring by pressing 'k' from the main prompt and pressing 'enter'.\n" +
        "The keys you are carrying will be listed. You cannot drop keys, you just have\n" +
        "them forever! If you take a key from a search, it will automatically be added\n" +
        "to your key ring.\n", 
         
        "Phylacteries are stored in your inventory. These are important! You cannot\n" +
        "store or drop them. That is all.\n",    
         
        "Every room has at least one door, and thus, you may act on them from the \n" +
        "main prompt using the name 'door'. However, you do not need to act on doors\n" +
        "in general movement. Your character moves through them automatically, if\n" +
        "they are unlocked, unblocked, etc.\n", 
         
        "The castle is made of rooms separated by doors and walls. A room may be one area big, two, or\n" +
        "even more! Inside and outside the room are 'objects', which are any nouns in the\n" +
        "room's description.", 
         
        "'Furniture' or more appropriately 'room objects' are any nouns in the room \n" +
        "description. This means you can interact with them from the main prompt by\n" +
        "a 'search', 'check', or 'interact'.", 
         
        "Items are things that go into your inventory or key ring. You may take them or store\n" +
        "them in searches (excluding keys and phylacteries for storing). You may use, combine,\n" +
        "and inspect them from your inventory.", 
         
         "Keys get added to your key ring, and you may not get rid of them. They permit you to\n"
       + "enter rooms, as one would expect. Remember, you may need to do something other than\n"
       + "obtain a key to enter a room!\n", 
         
         "Hmmm... Who know what these are for...\n"};
   
        
/* CONSTRUCTOR ---------------------------------------------------------------*/       
    /**
     * Puts together the two dictionaries.
     */
    public static void constructHelp() {
        int index = 0;
        
        for (String helpKey : HELP_KEYS) {
            HELP.put(helpKey, HELP_VALUES[index]);               
            index++;
        }
        index = 0;
        
        for (String topicKey : TOPIC_KEYS) {
            TOPIC.put(topicKey, HELP_KEYS[index]); 
            index++; 
        }
    }
/*----------------------------------------------------------------------------*/
    private static String get_help(String topic) {
        return HELP.get(topic); 
    }
/*******************************************************************************
--------------------------------------------------------------------------------
*******************************************************************************/
    /**
     * A structure of nested menus organizing game topics.
     */
    public static void helpSub() {        
        String choice;
        
        do {
            GUI.menOut("What would you like help on?\n" +
                       "-1- Controls\n-2- Your player\n" +
                       "-3- The castle\n");
            choice = GUI.promptOut();
            GUI.out("");
        /*--------------------------------------------------------------------*/            
            if (choice.matches("1")) {
                do {
                    GUI.menOut("-1- The prompt -2- Moving\n-3- Describing " +
                               "-4- Checking\n-5- Searching  -6- Interacting\n" +
                               "-7- Using      -8- Combining\n-9- Inspecting");

                    choice = GUI.promptOut() + "c";

                    if (choice.matches("^[1-9]c$"))
                        // Must match a single digit 1-9 + c
                        GUI.out(get_help(TOPIC.get(choice)));  
                } while (! choice.matches("c"));          
            }
        /*--------------------------------------------------------------------*/          
            if (choice.matches("2")) {                
                do {
                    GUI.menOut("-1- Your inventory\n-2- Your key ring\n" +
                               "-3- Your phylacteries");

                    choice = GUI.promptOut() + "p";
                    
                    if (choice.matches("^[1-3]p$"))
                        // Must match a single digit 1-3 + p
                        GUI.out(get_help(TOPIC.get(choice)));
                } while (! choice.matches("p"));    
            }
        /*--------------------------------------------------------------------*/      
            if (choice.matches("3")) {                
                do {
                    GUI.menOut("-1- Doors -2- Rooms -3- Furniture\n" +
                                  "-4- Items -5- Keys  -6- Phylacteries\n");

                    choice = GUI.promptOut() + "a";
                    
                    if (choice.matches("^[1-6]a$"))
                        //Must match a single digit 1-6 + a
                        GUI.out(get_help(TOPIC.get(choice)));
                } while (! choice.matches("a"));
            }
        /*--------------------------------------------------------------------*/      
        } while (! choice.matches(""));   
        
        GUI.clearMenu();
        GUI.clearDialog();
    }
/*******************************************************************************
--------------------------------------------------------------------------------
*******************************************************************************/    
}
