package A_Main;

import java.util.regex.Pattern;
/**
 * Stores pattern constants for use by Player and TextParser
 * 
 * @author Kevin Rapa
 */
public final class Patterns {
    // ========================================================================
    public static final Pattern
        YES = Pattern.compile("y|yes"),    
        NO = Pattern.compile("n|no"),
        WORD = Pattern.compile("[a-z]+"),
            
        // Patterns used by the player.
        KEYCOMMAND = Pattern.compile("[heckiwsadm]"),
        PHRASE = Pattern.compile("[a-z]+\\s[a-z0-9 ,'.-]+"),
        DIRECTION = Pattern.compile("(?:(move|walk|go|run|climb|) ?)(?:north|forward|south|east|right|west|left|(?:down|back|up)(?:wards?)?)"),
        GREETING = Pattern.compile("hi|hello|hey|sup"),
        NORTH = Pattern.compile("north|forward"),
        SOUTH = Pattern.compile("south|back(?:wards?)?"),
        EAST = Pattern.compile("east|right"),
        WEST = Pattern.compile("west|left"),
        UP = Pattern.compile("up(?:wards?)?"),
        INDEF_PRONOUN = Pattern.compile("it|them"),
        CHECK = Pattern.compile("c|check|examine|look|view|inspect|watch"),
        SEARCH = Pattern.compile("search|e|s"),
        GENERIC_FURNITURE = Pattern.compile("furniture|furnishings|stuff|things?"),
        TAKE = Pattern.compile("t|take"),
        STORE = Pattern.compile("s|store"),
        KEY = Pattern.compile("[A-Z]{3}[A-Z1-9]|OU62"), // Exception for oubliette key
        EXPLETIVE = Pattern.compile(".*(?:fuck|shit|cunt|dick|damn|bitch|vittu|perkele|paska).*"),
        INV_CHOICES = Pattern.compile("[1-4]"),
        MOVEMENT = Pattern.compile("go|walk|run"),
        CATACOMB_ENTRANCE = Pattern.compile("CS35|CT34"),
            
        // Patterns used by Furniture
        BOOK_TITLE = Pattern.compile(", .*"),
        TOW1_SPHERE = Pattern.compile("\\s(?=Wide)"),
        RUG_LIFT = Pattern.compile("lift|raise"),
        TITRANT = Pattern.compile("[\\w\\d]+ \\d{1,2}mL"),
        NO_TELEPORT = Pattern.compile("LIB[45]|ESC\\d|INTR"),
        DYE_PATTERN = Pattern.compile("(?:red|blue|yellow) dye"),
        ONE_TO_FOUR = Pattern.compile("[1234]"),
            
        // Patterns used by Dungeon_Monster
        NO_SOUND_AREA = Pattern.compile("TOR|CRY|ESC|DKC|CAS"),
        CISTERN_AREA = Pattern.compile("OUB|AAR|CIS"),
        TUNNEL_AREA = Pattern.compile("SEW|PRI|INT"),
        NO_SEE_AREA_E = Pattern.compile("SEW[0-5P]|PRIS|INTR"),
        NO_SEE_AREA_W = Pattern.compile("CIS\\d|OUB1|AARC"),
        SAFE_AREA = Pattern.compile("PRIS|OUB1|AARC"),
            
        // Patterns used by AudioPlayer    
        CAVES_CATACOMB = Pattern.compile("C[TV]\\d{2}"),
    
        // Patterns used by TextParser
        INSPECT_PATTERN = Pattern.compile("look(?: at)?|inspect|examine|check(?: out)?"),
        USE_PATTERN = Pattern.compile("use|read|drop|wear|remove|eat|drink|throw|lean|tie"),
        ITEM_COMMAND = Pattern.compile("(?:" + USE_PATTERN + "|" + INSPECT_PATTERN + ") [a-z0-9: ,'-]+"),
        SUICIDE = Pattern.compile("commit suicide|kill (?:your)?self"),
        DESTROY = Pattern.compile("(?:destroy|obliterate|wreak havoc|throw) .+"),
        STORE_COMMAND = Pattern.compile("(?:put|store|pour|dump) [a-z0-9: ,'-]+"),
        STORE_THEN_SPACE = Pattern.compile("(?:put|store|pour|dump) "),
        PREPOSITION = Pattern.compile("up|down|(?:in|on)(?:to)?|out|off|over|of|through|against|from|around|to|at|under(?:neath)?"),
        SLOT_NUMBER = Pattern.compile("[0-9]+"),
        ARTICLE = Pattern.compile("\\bthe |\\.|\\ban? |\\bsome "),
        WORD_THEN_SPACE = Pattern.compile("\\w+ "),
        SPACE_THEN_EVERYTHING = Pattern.compile("\\s.+"),
            
        // Patterns used by GUI
        THREE_PLUS_LETTER_WORD = Pattern.compile("(?:[a-z -]{3,})+"),
        FIRST_WORD = Pattern.compile("[a-z -]+ "),
        VALID_COMMAND = Pattern.compile("[a-z ,'-]{2,}(?: [1-9]+)?|(?:[ts] \\d{1,2})"),
        DIGIT = Pattern.compile("\\d"),
        NEWLINE = Pattern.compile("\n"),
    
        // Patterns used by Help
        CONTROL_CHOICE = Pattern.compile("[1-9]c"),
        PLAYER_CHOICE = Pattern.compile("[1-3]p"),
        CASTLE_CHOICE = Pattern.compile("[1-6]a");
    // ========================================================================
}
