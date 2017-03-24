package A_Main;

import java.util.regex.Pattern;
/**
 * Stores pattern constants for use by Player and TextParser.
 * No indenting since patterns are long!
 * 
 * @author Kevin Rapa
 */
public final class Patterns {
    
public static final Pattern 
            
//*****************************************************************************
// <editor-fold desc="PATTERNS USED BY PLAYER">  
        
// USED IN MOVE <DIRECTION> COMMANDS        
WALK_P = Pattern.compile("go|walk|run"),
// Used to identify the direction the player wants to move.
// "down" is not present since it's the last checkd condition.        
NORTH_P = Pattern.compile("north|forward"),
SOUTH_P = Pattern.compile("south|back(?:wards?)?"),
EAST_P = Pattern.compile("east|right"),
WEST_P = Pattern.compile("west|left"),
UP_P = Pattern.compile("up(?:wards?)?"),
        
// Indefinite reference (e.g. "Examine the pen and then throw IT")
IT_THEM_P = Pattern.compile("it|them"),
        
// If the player is vague in a command, using words like these, game lets the player know        
GEN_FURNITURE_P = Pattern.compile("furniture|furnishings|stuff|things?"),
     
// USED IN SEARCHES
SEARCH_P = Pattern.compile("search|e|s"),    
LOOT_ACTION_P = Pattern.compile("loot|l|take (?:all|everything)"),  // Player wants everything  
TAKE_P = Pattern.compile("t|take|get"),     // Player wants to take an item
STORE_P = Pattern.compile("s|store|put"),   // Player wants to store an item
        
// Matches a key so that they can be put in keyring when picked up
// Exception is made for OU62 key, since it's in catacombs breaks the rule
// That the first 3 letters are used to identify the area it's in.
KEY_P = Pattern.compile("[A-Z]{3}[A-Z1-9]|OU62"), 

// USED TO MATCH DIFFERENT KINDS OF COMMON ACTIONS
DESTROY_P = Pattern.compile("destroy|break|shatter|obliterate|throw"),        
MOVE_P = Pattern.compile("move|slide|displace|push|pull|spin|rotate"),
CHECK_P = Pattern.compile("c|check|examine|look|view|inspect|watch"),
        
// The only time a metal door sound is played in the catacombs is the boundary
// between CT34 and CS35. This patterns finds the boundary.
CS35_CT34_P = Pattern.compile("CS35|CT34"),

SAVE_QUIT_RESET_P = Pattern.compile("[sqr]"),   // Used when player quits game
        
// Protects from numberFormatException by restricting to 4 digits at most.
// Matches empty strings also. Used in a menu that prompts for a digit.        
DIGIT_OR_BLANK_P = Pattern.compile("\\d{1,4}|"), 
        
// Matches an ordinal direction. Works in Zork, doesn't work here!!
INVALID_DIR_P = Pattern.compile("(?:north|south)(?:east|west)"),

// A list delimited by a comma or 'and', or possibly a comma followed by 'and'.
LIST_P = Pattern.compile("(?:\\s*,(\\s*and\\s*)?\\s*)|(?:\\s+and\\s+)"),
        
// </editor-fold>
//*****************************************************************************

//*****************************************************************************
// <editor-fold desc="PATTERNS USED BY TEXT PARSER">   
        
// These five are the most specific cases and are checked first.
EXPLETIVE_P = Pattern.compile("fuck|shit|cunt|dick|damn|bitch|vittu|perkele|paska"),
DIRECTION_P = Pattern.compile("(?:(move|walk|go|run|climb|) ?)(?:north|forward|south|east|right|west|left|(?:down|back|up)(?:wards?)?)"),
SUICIDE_P = Pattern.compile("(?:commit )?suicide|(?:kill|hang) (?:your)?self(?: (?:with|using).+)?"),
COMBINE_P = Pattern.compile("combine\\s+.+"), // Anything beginning with 'combine' is a combine command       
ZORK_P = Pattern.compile("hi|hello|hey|sup|brief|superbrief|verbose|diagnose"),
       
// Matching to this likely means the player is trying to store something.        
STORE_CMD_P = Pattern.compile("(?:put|store|pour|dump|give) [a-z0-9: ,'-]+"), 
        
// Looking normally implies examining, unless followed by these prepositions.
SEARCH_MANNER_P = Pattern.compile("look (?:on|in(?:side)?|under|around)"),
 
// Likely means player is inspecting an item.
// 'look' has negative lookahead here in order to disambiguate it from searching
// furniture, which may use these prepositions (e.g. "look ON the table")
INSPECT_P = Pattern.compile("look(?! (?:on|in(?:side)?|under|around))|inspect|examine|check"),
        
// SPECIFIC TO ITEM USE COMMANDS
USE_P = Pattern.compile("use|read|drop|wear|remove|eat|drink|throw|destroy|break|lean|tie|rip|tear"),
USE_ITEM_CMD_P = Pattern.compile("(?:" + USE_P + "|" + INSPECT_P + ") [a-z0-9: ,'-]+"),
USE_MANNER_P = Pattern.compile(" (on|against|to|at) "), // Separates item from furniture.
         
// Once a store command is matched, these words are fine to remove.
STORE_SPACE_P = Pattern.compile("(?:put|store|pour|dump|give) "),

// These prepositions are removed at some point, as their meanings are mostly unimportant
PREPOS_P = Pattern.compile("up|down|(?:in|on)(?:to)?|out|off|over|of|through|against|from|around|to|at|under(?:neath)?"),
        
PREPOS_THEN_WORD = Pattern.compile("(?:" + PREPOS_P.toString() + ").+"),
        
// Protects from numberFormatException by restricting to 4 digits at most.        
ANY_DIGIT_P = Pattern.compile("\\d{1,4}"), 
        
// These words are meaningless and removed right away. Periods are included 
// as well as the pronoun 'some' (e.g. "take SOME grass").
ARTICLE_P = Pattern.compile("\\bthe |\\.|\\ban? |\\bsome "),
        
// Used to remove the first word in a sentence.
WORD_SPACE_P = Pattern.compile("\\w+ "), 
// Used to remove everything but the first word in a sentence.        
SPACE_THEN_ALL_P = Pattern.compile("\\s.+"),

// Implies a search, if sentence resembles "put <item> DOWN"
// Sentences resembling "go down" or "move down" have been checked at this point        
DROP_P = Pattern.compile(".+ down"),

// Splits an item from the object it's used on (e.g. cut rope WITH the sword)
INSTRUCTIVE_P = Pattern.compile(" with | using "),  
        
// Splits player input into commands if the player chained them together.
// The negative look behind is to help disambiguate from combine commands
// (e.g. "combine <>, <>, AND, <>" and "go left AND drop the sponge")        
CONJUNC_P = Pattern.compile(" (?<!, ?)and(?: then| also)? | then(?: also)? "),

// In a store command, this pattern splits items from the furniture they are
// to be stored in.
STORE_AREA_P = Pattern.compile(" (?:(?:in|on)(?:to)?|under(?:neath)?|(?:next )?to|beside|over) "),

// Used to get just the first word in s sentence, but NOT with punctuation.
FIRST_WORD_P = Pattern.compile("[a-z]+\\s"),
        
// </editor-fold>
//*****************************************************************************

        
//*****************************************************************************
// <editor-fold desc="PATTERNS USED BY FURNITRUE">   
        
// All of these are used in menus of furniture        
ONE_TO_HUNDRED_P = Pattern.compile("[1-9][0-9]?|100|"),
VAUE_DOOR_COORDS_P = Pattern.compile("(?:[1-4]\\s*,\\s*[1-4])|"),
ROMAN_NUMERAL_P = Pattern.compile("[1-9]|v?i{1,3}|i[vx]|v|"),
ONE_TO_NINE = Pattern.compile("[1-9]"),
OBS_SLOTS_A_TO_I = Pattern.compile("[a-i]|"),
OBS_STATS_ONE_TO_EIGHT = Pattern.compile("[0-8]|"),
LABO_BURET_ONE_OR_TWO = Pattern.compile("[12]|"),
ONE_TO_SIX = Pattern.compile("[1-6]"),
GAL_TOTEM_ONE_TO_FOUR = Pattern.compile("[1-4]|"),        
UP_DOWN_P = Pattern.compile("[ud]|up|down|"),
YES_NO_P = Pattern.compile("[yn]|yes|no|"),
        
// Used to delete tower description on tower room description once the lich is dead.        
TOW1_SPHERE_P = Pattern.compile("\\s(?=Wide)"),
        
// Represents a chemical in the alchemy puzzle.
CHEMICAL_P = Pattern.compile("[\\w\\d]+ \\d{1,2}mL"),
        
// Not safe to teleport the player to these areas.
// LIB4 and LIB5: bad if player teleports to these without leather shoes.
// ESC: bad if player teleports to these without a torch.
// INTR: bad if player teleports here without it being reset by monster.        
NO_TELEPORT_P = Pattern.compile("LIB[45]|ESC\\d|INTR"),
        
// Represents a dye item in the lens-making puzzle.
DYES_P = Pattern.compile("(?:red|blue|yellow) dye"),

        
// </editor-fold>
//*****************************************************************************
        

//*****************************************************************************
// <editor-fold desc="OTHER PATTERNS">  
        
// USED BY THE DUNGEON MONSTER  
// Match rooms where player can never see monster and sounds are never played.
FAR_ROOMS_P = Pattern.compile("CRY1|CRY2|DKCH|INTR"),
NO_SOUND_AREA = Pattern.compile("TOR|CRY|ESC|DKC|CAS"),
// Match the two halves of sub-level 1 (cistern and tunnels)
CISTERN_AREA = Pattern.compile("OUB|AAR|CIS"),
TUNNEL_AREA = Pattern.compile("SEW|PRI|INT"), 
// Player can't see the monster from the areas in each pattern, IF the
// player is in an area matched by the other pattern.
NO_SEE_AREA_E = Pattern.compile("SEW[0-5P]|PRIS|INTR"),
NO_SEE_AREA_W = Pattern.compile("CIS\\d|OUB1|AARC"),  
// Player is notified to be 'safe' when in these areas
SAFE_AREA = Pattern.compile("PRIS|OUB1|AARC"), 

        
// PATTERNS USED BY AUDIOPLAYER   
// Used in tandem with the below pattern.        
CAVES_CAT_P = Pattern.compile("C[TV]\\d{2}"),
// Removes digits from cave and catacomb IDs so that all map to same track.
SINGLE_DIGIT_P = Pattern.compile("\\d"),    
        
        
// PATTERN USED BY GUI
NEWLINE = Pattern.compile("\n"),    // All newlines are replaced by spaces

        
// PATTERNS USED BY HELP
CONTROL_CHOICE = Pattern.compile("[1-9]c|10c"),
PLAYER_CHOICE = Pattern.compile("[1-3]p"),
CASTLE_CHOICE = Pattern.compile("[1-6]a");

// </editor-fold>
//*****************************************************************************
}
