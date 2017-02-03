package A_Main;

import java.util.regex.Pattern;
/**
 * Stores pattern constants for use by Player and TextParser
 * 
 * @author Kevin Rapa
 */
public final class Patterns {
    //=========================================================================
    public static final Pattern
        // Patterns used by the player.
        KEYCOMMAND = Pattern.compile("[heckiwsad]"),
        PHRASE = Pattern.compile("[a-z]+\\s[a-z0-9 ,'.-]+"),
        DIRECTION = Pattern.compile("(?:north|forward|south|east|right|west|left|(?:down|back|up)(?:wards?)?)"),
        GREETING = Pattern.compile("hi|hello|hey|sup"),
        NORTH = Pattern.compile("north|forward"),
        SOUTH = Pattern.compile("south|back(?:wards?)?"),
        EAST = Pattern.compile("east|right"),
        WEST = Pattern.compile("west|left"),
        UP = Pattern.compile("up(?:wards?)?"),
        INDEFINITE_PRONOUN = Pattern.compile("it|them"),
        CHECK = Pattern.compile("c|check|examine|look|view|inspect|watch"),
        SEARCH = Pattern.compile("search|e|s"),
        FURNITURE = Pattern.compile("furniture|furnishings|stuff|things?"),
        TAKE = Pattern.compile("t|take"),
        STORE = Pattern.compile("s|store"),
        KEY = Pattern.compile("[A-Z]{3}[A-Z1-9]"),
        INV_CHOICES = Pattern.compile("[1-4]"),
        MOVEMENT = Pattern.compile("go|walk|run"),
            
        // Patterns used by AudioPlayer    
        CAVES_CATACOMB = Pattern.compile("C[TV]\\d{2}"),
    
        // Patterns used by TextParser
        INSPECT_PATTERN = Pattern.compile("look(?: at)?|inspect|examine|check(?: out)?"),
        USE_PATTERN = Pattern.compile("use|read|drop|wear|remove|eat|drink|eat"),
        ITEM_COMMAND = Pattern.compile("(?:" + USE_PATTERN + "|" + INSPECT_PATTERN + ") [a-z0-9: ,'-]+"),
        SUICIDE = Pattern.compile("commit suicide|kill (?:your)?self"),
        SHOUT = Pattern.compile("(?:say|speak|yell|shout) .+"),
        DESTROY = Pattern.compile("(?:destroy|obliterate|wreak havoc) .+"),
        STORE_COMMAND = Pattern.compile("(?:put|store) [a-z0-9: ,'-]+"),
        STORE_THEN_SPACE = Pattern.compile("(?:put|store) "),
        PREPOSITION = Pattern.compile("up|down|(?:in|on)(?:to)?|out|of|through|against|around|to|at|under(?:neath)?"),
        SLOT_NUMBER = Pattern.compile("[0-9]+"),
        ARTICLE = Pattern.compile("\\bthe |\\.|\\ban? |\\bsome "),
        WORD_THEN_SPACE = Pattern.compile("\\w+ "),
        ALL_AFTER_SPACE = Pattern.compile("\\s.+"),
            
        // Patterns used by GUI
        THREE_PLUS_LETTER_WORD = Pattern.compile("(?:[a-z -]{3,})+"),
        FIRST_WORD = Pattern.compile("[a-z -]+ "),
        VAILD_COMMAND = Pattern.compile("[a-z ,'-]{2,}|(?:[ts] \\d{1,2})"),
    
        // Patterns used by Help
        CONTROL_CHOICE = Pattern.compile("[1-9]c"),
        PLAYER_CHOICE = Pattern.compile("[1-3]p"),
        CASTLE_CHOICE = Pattern.compile("[1-6]a");
    //=========================================================================
}
