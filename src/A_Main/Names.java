package A_Main;
/**
 * Holds name constants for item types and item names.
 * Item types cannot be enumerations because keys use room Ids as types.
 * Generally any item used in more than one place is given a constant name
 * here.
 * 
 * @see A_Super.Key
 * @see A_Main.Id
 * @author Kevin Rapa
 */
public final class Names {
    // CONSTANTS FOR ITEM TYPE NAMES ==========================================
    public static final String 
        PHYLACTERY = "phylactery",  CARD = "card",
        FOCUS = "focus",            INGREDIENT = "ingredient",
        SHOES = "shoes",            PLATE = "plate",
        CLOTHING = "clothing",      READABLE = "readable",
        LIQUID = "liquid",          WEAPON = "weapon",
        ITEM = "item",              BREAKABLE = "breakable",

    // CONSTANTS FOR ITEM NAMES ===============================================
        METAL_BUCKET = "metal bucket",          EMPTY_VIAL = "empty vial",
        GLASS_BOTTLE = "glass bottle",          TEST_TUBE = "test tube",
        SACRED_FIRE = "sacred fire",            HAND_TORCH = "hand torch",
        BUCKET_OF_WATER = "bucket of water",    METAL_BAR = "metal bar",
        POLEARM = "polearm",                    METAL_LADDER = "metal ladder",
        DEAD_BATTERY = "battery thing",         RED_FOCUS = "red focus",
        BLUE_FOCUS = "blue focus",              YELLOW_FOCUS = "yellow focus",
        DARK_FOCUS = "dark focus",              CRYSTAL_ORB = "crystal orb",
        RUBY = "ruby",                          LEATHER_HOSE = "leather hose",
        FLORENCE_FLASK = "florence flask",      BEAKER = "beaker",
        RUBBER_HOSE = "rubber hose",            PIECE_OF_PIPE = "piece of pipe",
        SCYTHE = "scythe",                      IRIDESCENT_JEWEL = "iridescent jewel",
        STONE_DISK = "stone disk",              ANGEL_MEDALLION = "angel medallion",
        HORSE_MEDALLION = "horse medallion",    RED_DYE = "red dye",
        BLUE_DYE = "blue dye",                  YELLOW_DYE = "yellow dye",
        SAND = "sand",                          POTASH = "potash salts",
        LENS_TEMPLATE = "lens template",        MOLTEN_RED_GLASS = "molten red glass",
        MOLTEN_BLUE_GLASS = "molten blue glass",MOLTEN_YELLOW_GLASS = "molten yellow glass",
        SILVER_SPEAR = "silver spear",          LEATHER_SHOES = "leather shoes",
        NIGHT_SLIPPERS = "night slippers",      AETHER_VIAL = "aether vial",
        FIRE_SALTS = "fire salts",              SPRUCE_EXTRACT = "spruce extract",
        MANDRAGORA = "mandragora",              RAVEN_FEATHER = "raven feather",
        SHROUDED_SHOES = "shrouded shoes",      STRIKER = "striker",
        GLOWING_EMERALD = "glowing emerald",    HAND_DRILL = "hand drill",
        DAMPENING_STAFF = "dampening staff",    BOTTLE_OF_WINE = "bottle of wine",
        BOTTLE_OF_VINEGAR = "bottle of vinegar",POTION_OF_SCIENCE = "potion of science",
        PHASE_DOOR_POTION = "phase door potion",CLEANING_SOLUTION = "cleaning solution",
        AQUAMARINE = "aquamarine",              TROWEL = "trowel",
        SHOVEL = "shovel",                      CROWBAR = "crowbar",
        WARHAMMER = "warhammer",                HAMMER = "hammer",
        KEY_OF_ANCESTRY = "key of ancestry",    KEY_OF_INTELLECT = "key of intellect",
        KEY_OF_CONTINUITY = "key of continuity",POTTED_MANDRAGORA = "potted mandragora",
        FERTILIZED_SOIL = "fertilized soil",    POTTED_SOIL_AND_FERTILIZER = "potted soil and fertilizer",
        BATTERING_RAM = "battering ram",        LOOPED_ROPE = "looped rope",
        SOIL = "soil",                          FIXED_LADDER = "fixed ladder",
        HOLY_WATER = "holy water",              COPPER_POT = "copper pot",
        COPPER_PAN = "copper pan",              CANDLE = "candle",
        GLOWING_SCEPTER = "glowing scepter",    FACTUM = "the factum",
        FERTILIZER = "fertilizer",              SEED = "seed",
        GRASS = "grass",                        ROCK = "rock",
        ACETONE = "acetone",                    MOP = "mop",
        ASH = "ash",                            RED_BALL = "red ball",
        CUE_BALL = "cue ball",                  STONE_BLOCK = "stone block",
        HOE = "hoe",                            WHEEL_SPOKE = "wheel spoke",
        GLOWING_CHALICE = "glowing chalice",    BOOK_PHYL = "glowing book, 'A Young Mind's Guide to Lichery'",
        ENCHANTED_BOTTLE = "enchanted bottle",  GLOWING_FRUIT = "glowing pristine fruit",
        STEEL_WIRE = "steel wire",              SCREWDRIVER = "screwdriver",
        PEN = "pen",                            NOTEPAD = "notepad",
        WOOD_LOG = "wooden holed log",          LOOT_SACK = "loot sack",
        BRAIN = "jarred brain",                 ONYX_FRAGMENT = "onyx fragment",
        STATUE_TORSO = "statue torso",          STATUE_HEAD = "statue head",
        SHINY_WATCH = "shiny pocket watch",     WOODEN_OAR = "wooden oar",
        SHOE_BOX = "shoebox",                   RUBBER_GLOVES = "rubber gloves",
        WORK_BOOTS = "work boots",              CHARGED_BATTERY = "charged battery",
        GLUE_BOTTLE = "glue bottle",            STRADIVARIUS = "expensive violin",
        LARGE_DIAMOND = "large diamond",        GOLDEN_URN = "golden urn",
        JEWELED_KNIFE = "jewel-encrusted knife",JEWELED_KING = "jeweled king",
        JEWELED_QUEEN = "jeweled queen",        DIAMOND_RING = "platinum diamond ring",
        GOLDEN_FORK = "golden fork",            PHILOSOPHERS_STONE = "philosopher's stone",
            
        BIBLE = "biblical tome, 'The Book of Genesis'",
        ILIAD = "greek tome, 'The Iliad'",
        ODYSSEY = "epic tome, 'The Odyssey'",
        PARADISE_LOST = "divine tome, 'Paradise Lost'",
        DANTES_INFERNO = "infernal tome, 'Dante's Inferno'",
            
        // Used together in PlayerInventory.get and Player.hasItemResembling    
        NO_LETTER_BEFORE = ".*(?<![a-z])(?i:",  NO_LETTER_AFTER = ")(?![a-z]).*",    
    // PLATFORM DEPENDENT PROERTIES ===========================================
        W_DIR = System.getProperty("user.dir"),     // Current working directory.
        SEP = System.getProperty("file.separator");    
}
