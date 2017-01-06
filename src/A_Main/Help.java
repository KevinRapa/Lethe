package A_Main;

import java.util.HashMap;
/**
 * This class comprises the help section of the game.
 * The Help is comprised of nested menus directing the player to different
 * help topics.
 * @author Kevin Rapa
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
        {"When prompted for input, the desired type of input will appear in "
       + "angle brackets.\t\t\t\t\t"
       + "Simple types of input ------ \t"
       + "<item> - Enter an item name.\n"
       + "<object> - Enter an object in the room.\t\t\t" +
         "<'x'> - Enter what's quoted.\t" +
         "<#> - Enter a digit.\t\t" +
         "< > - Enter nothing.\t\t\t\t\t"
       + "Compound input -------------\t" +
         "<(item)> - An optional item.\t" +   
         "<?,?,?> - Enter a list of ?, separated by commas.\t\t" +
         "<?/?/?> - Enter any one of ?. "
       + "<action object> - Enter the name of an action followed by the name of an object.", 
         
         "In this game, you may move four directions; north, south, east, and west.\n"
       + "The keys for these are 'w', 's', 'a', and 'd'. Really, who wants to type\n"
       + "in 'north' every time they want to move?", 
         
         "When you enter a room, especially for the first time, you may want to read\n"
       + "a description of it because this is a text-based game, so there are\n"
       + "no pictures. The room description is displayed automatically\n"
       + "upon entering the room.\n"
       + "In each room's description, you will find necessary information about the\n"
       + "objects in the room and what you may interact with. You many interact with any noun in the description (search, interact,\n"
       + "and check). As an exception, the room itself and abstract nouns mentioned in the room description may not be\n"
       + "interacted with.\n", 
         
        "Checking is a main action, and is performed from the main prompt. The key for\n" +
        "checking is 'c' for check. You may check discrete objects mentioned in the room\n" +
        "description, and the action will describe that object for you. Unlike describing,\n" +
        "you mostly cannot interact with nouns in the 'check' description, unless it is\n" +
        "intuitively obvious (e.g. a button, lever, wheel is revealed). Otherwise, I would\n" +
        "have to recursively make more furniture down to the atomic level.\n" +
        "Checking is important, as it can reveal clues about hidden objects and other\n" +
        "things, as well as add color to what's in your head. You may also type <'c'/'check' object> to check something immediately without being asked.", 
         
        "Searching is a main action, and is performed from the main prompt. The key for\n" +
        "searching is 'e'. You may search any discrete objects mentioned\n" +
        "in the room description, and your character will search the object. If the\n" +
        "object is searchable, you will be taken to the search sub-prompt. In addition,\n" +
        "any items the object contains will be listed. Remember, an object may contain\n" +
        "useful stuff, but you will not always be able to take the stuff right away!\n" +
        "You may also type <'check'/'e' object> to search something immediately without being asked." +
        "The search sub-prompt will ask if you want to take or store items. To do this,\n" +
        "type 'take' or 'store' followed by a space, and then the item's slot.\n", 
         
        "Interacting is performed from the main prompt by entering an action followed by\n"
      + "the name of an object in the room. You may interact with discrete objects mentioned in the room\n"
      + "description, and your character will interact with it.\n" +
        "Interacting means your character is doing something to/with the object, like\n" +
        "'pull', 'sit', etc.\n" +
        "You may type <'search'/'e' object>' to search the object if you wish,\n" +
        "and 'check/view/look/watch/inspect <object>' to check the object. Also, you\n"
      + "may type <action 'it'/'them'> to reference the furniture you last performed\n"
      + "an action on. For example, if you search check a window, you may subsequently\n"
      + "type 'open it' to open the window.",
         
        "Using is an inventory action, and is performed from the inventory ('i'). To\n" +
        "use an item, press '2' from the inventory menu, and you will be asked to\n" +
        "type an item to use. Enter the item's slot as it appears in your inventory. "
       + "An item could be used on objects, itself, or\n" +
        "not be useful at all! If it is to be used on an object in the room, you will\n" +
        "be asked to enter in the object.\n", 
         
        "Combining is an inventory action, and is performed from the inventory ('i'). To\n" +
        "combine items, press '3' from the inventory menu, and you will be asked to enter\n" +
        "items to combine. Type in the item slot numbers, separated by a comma and space, and press\n" +
        "enter. You\n" +
        "must type exactly 2 or 3 items to combine. A set of combinable\n" +
        "items are combined at once. For example, if a hilt, pommel, and blade are combined\n" +
        "to make a sword, do not try to combine 2 of them and then the 3rd later; combine\n" +
        "all 3 at the same time.\n", 
         
        "Inspecting is an inventory action, and is performed from the inventory ('i'). To\n" +
        "inspect an item, press '1' from the inventory menu, and you will be asked to type\n" +
        "an item to inspect. Enter in the item's slot number.\n" +
        "Inspecting is the simplest inventory action. Upon inspecting, you will be given\n" +
        "a description of the item. This can be important, as it may reveal information\n" +
        "about what the item does.", 
         
        "Access your inventory by entering 'i' from the main prompt.\n" +
        "Your inventory's contents will be listed. From here, you may perform the\n" +
        "inventory actions 'inspect', 'use', and 'combine'. Press enter to back\n" +
        "out to the main prompt.", 
         
        "Access your key ring by pressing 'k' from the main prompt and pressing 'enter'.\n" +
        "The keys you are carrying will be listed. You cannot drop keys; you just have\n" +
        "them forever! If you take a key from a search, it will automatically be added\n" +
        "to your key ring.", 
         
        "Phylacteries are stored in your inventory. These are important! You cannot\n" +
        "store or drop them. That is all.",    
         
        "Most rooms have at least one door, and thus you may act on them from the\n" +
        "main prompt using the name 'door'. However, you do not need to act on doors\n" +
        "in general movement. Your character moves through them automatically, if\n" +
        "they are unlocked, unblocked, etc.", 
         
        "The castle is made of rooms separated by doors and walls. A room may be one area, two, or\n" +
        "even more! Inside and outside the room are 'objects', which are any nouns in the\n" +
        "room's description. In everyday life, we call these objects 'furniture' or 'stuff'.", 
         
        "'Furniture' or more appropriately 'room objects' are any nouns in the room\n" +
        "description. This means you can interact with them from the main prompt by\n" +
        "a 'search', 'check', or 'interact'.", 
         
        "Items are things that go into your inventory or key ring. You may take them or store\n" +
        "them in searches (excluding keys and phylacteries for storing). You may use, combine,\n" +
        "and inspect them from your inventory.", 
         
         "Keys get added to your key ring, and you may not get rid of them. They permit you to\n"
       + "enter rooms, as one would expect. Remember, you may need to do something other than\n"
       + "obtain a key to enter a room!", 
         
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
            GUI.menOut("What would you like help on?\n\n" +
                       "     <'1'> Controls\n     <'2'> Your player\n" +
                       "     <'3'> The castle\n");
            choice = GUI.promptOut();
            GUI.out("");
        /*--------------------------------------------------------------------*/            
            if (choice.matches("1")) {
                do {
                    GUI.menOut("<'1'> The prompt <'2'> Moving\n<'3'> Describing " +
                               "<'4'> Checking\n<'5'> Searching  <'6'> Interacting\n" +
                               "<'7'> Using      <'8'> Combining\n<'9'> Inspecting");

                    choice = GUI.promptOut() + "c";

                    if (choice.matches("^[1-9]c$")) 
                        GUI.out(get_help(TOPIC.get(choice)));  
                    
                } while (! choice.matches("c"));          
            }
        /*--------------------------------------------------------------------*/          
            if (choice.matches("2")) {    
                do {
                    GUI.menOut("\n<'1'> Your inventory\n"
                               + "<'2'> Your key ring\n" +
                                 "<'3'> Your phylacteries");

                    choice = GUI.promptOut() + "p";
                    
                    if (choice.matches("^[1-3]p$")) 
                        GUI.out(get_help(TOPIC.get(choice)));
                    
                } while (! choice.matches("p"));    
            }
        /*--------------------------------------------------------------------*/      
            if (choice.matches("3")) {    
                do {
                    GUI.menOut("\n<'1'> Doors\t<'2'> Rooms\n"
                               + "<'3'> Furniture\t<'4'> Items\n"
                               + "<'5'> Keys\t<'6'> Phylacteries");

                    choice = GUI.promptOut() + "a";
                    
                    if (choice.matches("^[1-6]a$")) 
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
