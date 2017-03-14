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
        // Patterns used by Player
        MOVE_P = Pattern.compile("move|slide|displace|push|pull|spin|rotate"),
        DIRECTION_P = Pattern.compile("(?:(move|walk|go|run|climb|) ?)"
                                    + "(?:north|forward|south|east|right|west|left|"
                                    + "(?:down|back|up)(?:wards?)?)"),
        NORTH_P = Pattern.compile("north|forward"),
        SOUTH_P = Pattern.compile("south|back(?:wards?)?"),
        EAST_P = Pattern.compile("east|right"),
        WEST_P = Pattern.compile("west|left"),
        UP_P = Pattern.compile("up(?:wards?)?"),
        IT_THEM_P = Pattern.compile("it|them"),
        CHECK_P = Pattern.compile("c|check|examine|look|view|inspect|watch"),
        SEARCH_P = Pattern.compile("search|e|s"),
        GEN_FURNITURE_P = Pattern.compile("furniture|furnishings|stuff|things?"),
        TAKE_P = Pattern.compile("t|take|get"),
        STORE_P = Pattern.compile("s|store|put"),
        KEY_P = Pattern.compile("[A-Z]{3}[A-Z1-9]|OU62"), // Exception for oubliette key
        WALK_P = Pattern.compile("go|walk|run"),
        CS35_CT34_P = Pattern.compile("CS35|CT34"),
        SAVE_QUIT_RESET_P = Pattern.compile("[sqr]"),
        DIGIT_OR_BLANK_P = Pattern.compile("\\d+|"),
            
        // Patterns used by TextParser    
        ZORK_P = Pattern.compile("hi|hello|hey|sup|brief|superbrief|verbose|diagnose"),
        COMBINE_P = Pattern.compile("combine\\s+(?:\\d+\\s*,\\s*)*\\d+"),
        EXPLETIVE_P = Pattern.compile("fuck|shit|cunt|dick|damn|bitch|vittu|perkele|paska"),
        SEARCH_MANNER_P = Pattern.compile("look (?:on|in(?:side)?|under|around)"),
        INSPECT_P = Pattern.compile("look(?! (?:on|in(?:side)?|under|around))|inspect|examine|check"),
        USE_P = Pattern.compile("use|read|drop|wear|remove|eat|drink|throw|destroy|break|lean|tie"),
        USE_ITEM_CMD_P = Pattern.compile("(?:" + USE_P + "|" + INSPECT_P + ") [a-z0-9: ,'-]+"),
        SUICIDE_P = Pattern.compile("(?:commit )?suicide|(?:kill|hang) (?:your)?self(?: (?:with|using).+)?"),
        DESTROY_P = Pattern.compile("destroy|break|shatter|obliterate|throw"),
        STORE_CMD_P = Pattern.compile("(?:put|store|pour|dump|give) [a-z0-9: ,'-]+"),
        STORE_SPACE_P = Pattern.compile("(?:put|store|pour|dump|give) "),
        PREPOS_P = Pattern.compile("up|down|(?:in|on)(?:to)?|out|off|over|of|through"
                                 + "|against|from|around|to|at|under(?:neath)?"),
        PREPOS_THEN_WORD = Pattern.compile("(?:" + PREPOS_P.toString() + ").+"),
        ANY_DIGIT_P = Pattern.compile("[0-9]+"),
        ARTICLE_P = Pattern.compile("\\bthe |\\.|\\ban? |\\bsome "),
        WORD_SPACE_P = Pattern.compile("\\w+ "),
        SPACE_THEN_ALL_P = Pattern.compile("\\s.+"),
        DROP_P = Pattern.compile(".+ down"),
        CONJUNC_P = Pattern.compile(" and(?: then| also)? | then(?: also)? "),
        STORE_AREA_P = Pattern.compile(" (?:(?:in|on)(?:to)?|under(?:neath)?|(?:next )?to|beside|over) "),
        USE_MANNER_P = Pattern.compile(" (on|against|to|at) "),
        INSTRUCTIVE_P = Pattern.compile(" with | using "),
        FIRST_WORD_P = Pattern.compile("[a-z]+\\s"),
            
        // Patterns used by Furniture
        ONE_TO_HUNDRED_P = Pattern.compile("[1-9][0-9]?|100|"),
        UP_DOWN_P = Pattern.compile("[ud]|up|down|"),
        YES_NO_P = Pattern.compile("[yn]|yes|no|"),
        BOOK_TITLE_P = Pattern.compile(", .*"),
        TOW1_SPHERE_P = Pattern.compile("\\s(?=Wide)"),
        LIFT_P = Pattern.compile("lift|raise"),
        CHEMICAL_P = Pattern.compile("[\\w\\d]+ \\d{1,2}mL"),
        NO_TELEPORT_P = Pattern.compile("LIB[45]|ESC\\d|INTR|TBAL"),
        DYES_P = Pattern.compile("(?:red|blue|yellow) dye"),
        VAUE_DOOR_COORDS_P = Pattern.compile("(?:[1-4]\\s*,\\s*[1-4])|"),
        ROMAN_NUMERAL_P = Pattern.compile("[1-9]|v?i{1,3}|i[vx]|v|"),
        ONE_TO_NINE = Pattern.compile("[1-9]"),
        OBS_SLOTS_A_TO_I = Pattern.compile("[a-i]|"),
        OBS_STATS_ONE_TO_EIGHT = Pattern.compile("[0-8]|"),
        LABO_BURET_ONE_OR_TWO = Pattern.compile("[12]|"),
        ONE_TO_SIX = Pattern.compile("[1-6]"),
        GAL_TOTEM_ONE_TO_FOUR = Pattern.compile("[1-4]|"),
            
        // Patterns used by Dungeon_Monster
        FAR_ROOMS_P = Pattern.compile("CRY1|CRY2|DKCH|INTR"),
        NO_SOUND_AREA = Pattern.compile("TOR|CRY|ESC|DKC|CAS"),
        CISTERN_AREA = Pattern.compile("OUB|AAR|CIS"),
        TUNNEL_AREA = Pattern.compile("SEW|PRI|INT"),
        NO_SEE_AREA_E = Pattern.compile("SEW[0-5P]|PRIS|INTR"),
        NO_SEE_AREA_W = Pattern.compile("CIS\\d|OUB1|AARC"),
        SAFE_AREA = Pattern.compile("PRIS|OUB1|AARC"),
            
        // Patterns used by AudioPlayer    
        CAVES_CAT_P = Pattern.compile("C[TV]\\d{2}"),
        
        // Patterns used by GUI
        THREE_PLUS_CHAR_WORD = Pattern.compile("(?:[a-z -]{3,})+"),
        FURNITURE_SPACE_P = Pattern.compile("[a-z -]+ "),
        SINGLE_DIGIT_P = Pattern.compile("\\d"),
        NEWLINE = Pattern.compile("\n"),
    
        // Patterns used by Help
        CONTROL_CHOICE = Pattern.compile("[1-9]c|10c"),
        PLAYER_CHOICE = Pattern.compile("[1-3]p"),
        CASTLE_CHOICE = Pattern.compile("[1-6]a");
    // ========================================================================
}
