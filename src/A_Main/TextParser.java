package A_Main;

import static A_Main.Names.*;
import static A_Main.Patterns.*;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Note;
import Foyer.LootSack;
import java.util.LinkedList;
/**
 * This processes more complex sentences into statements containing verbs,
 * items, and furniture.
 * 
 * The command class below accepts verbs, furniture names, and item names as
 * constructor parameters and then creates a runnable object from them.
 * 
 * The command queue is loaded with a number of commands depending on the
 * number of conjunctions the player entered, then processed one at a time
 * before allowing the player to add input.
 * 
 * @author Kevin Rapa
 */
public class TextParser {
    private final static LinkedList<Command> COMMAND_QUEUE = new LinkedList<>();

    // Items to create when other items are thrown or broken.
    private static final Item 
        BROKEN_GLASS = new Item("broken shards", 
                "The pieces of glass sit uncomfortably in your pocket. "
              + "Of course, you certainly know what you're doing.", -50),
        RIPPED_SHREDS = new Note("ripped paper shreds", 
                "The gory mess of literature now exists crumpled up in your "
                        + "pocket. This is unintelligible.");
    
    private static final String
        DONT_HAVE_IT = "It doesn't look like you're carrying anything resembling that.";
    
    // List of standard commands that are likely to be made many times.
    private static final Command 
        DEFAULT_CMD =   new Command("What does that mean?"),
        EXPLETIVE_CMD = new Command("Mind yourself! You're a guest here!"),
        SUICIDE_CMD =   new Command(() -> Player.commitSuicide(), "SUICIDE"),
        GREETING_CMD =  new Command("What do you think this is? Zork?"),
        NO_SLOT_CMD =   new Command("Seems that you don't have an existing slot there."),
        AMBIGUOUS_CMD = new Command("You need to specify something to put that in!");
            
    //*************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Text parser">
    //*************************************************************************
    /**
     * Removes articles 'a', 'an', 'the', and the pronoun 'some' from the input,
     * and then queue's up all the commands chained together by conjunctions.
     * @param input An input string by the player
     */
    public static void processText(String input) {
        String noArticles = ARTICLE_P.matcher(input).replaceAll("");

        for (Command c : splitCommands(noArticles))
            COMMAND_QUEUE.offer(c);
        
        while (! COMMAND_QUEUE.isEmpty())
            COMMAND_QUEUE.poll().perform();
    }
    // ========================================================================
    /**
     * Removes prepositions, which won't effect the meaning in this context.
     * @param input An article-less string of input.
     * @return The sentence stripped of prepositions.
     */
    private static String stripPrepositions(String input) {
        StringBuilder builder = new StringBuilder();
        
        for (String word : input.split(" ")) {
            if (! PREPOS_P.matcher(word).matches())
                builder.append(word).append(" ");
        }
        return builder.toString().trim();
    }
    // ========================================================================
    /**
     * Splits the sentence using a conjunction as a delimiter into statements,
     * then populates a list of commands.
     * This does conflict with listing items using 'and' in combining.
     * @param sentence a sentence with the articles removed.
     * @return a list of commands to execute.
     */
    private static Command[] splitCommands(String sentence) {
        // Splits a chain of commands into individual commands.
        String[] statements = CONJUNC_P.split(sentence);
        Command[] commands = new Command[statements.length];
        
        for (int i = 0; i < commands.length; i++) {   
            //-----------------------------------------------------------------
            // First six conditions handle simpler commands.
            if (EXPLETIVE_P.matcher(sentence).find()) // Zork-inspired
                commands[i] = EXPLETIVE_CMD;    
            
            else if (DIRECTION_P.matcher(statements[i]).matches()) {
                commands[i] = new Command(Verb.GO_VERB, 
                        new DirectObj(FIRST_WORD_P
                                .matcher(statements[i])
                                .replaceFirst("")));
            }
            else if (SUICIDE_P.matcher(statements[i]).matches()) {
                commands[i] = SUICIDE_CMD;
            }
            else if (COMBINE_P.matcher(statements[i]).matches()) {
                String s = statements[i]; // Variable for lambda must be final.
                commands[i] = new Command(() -> 
                        Player.combineSub(s.replaceFirst("combine\\s+", "")), "COMBINE");
            }
            else if (ZORK_P.matcher(statements[i]).matches()) { // Zork-inspired
                commands[i] = GREETING_CMD;
            }
            //-----------------------------------------------------------------
            // These handle more comlicated input strings.
            else if (USE_ITEM_CMD_P.matcher(statements[i]).matches()) {
                    commands[i] = getItemCmd(USE_MANNER_P.split(statements[i]));
            }
            else if (STORE_CMD_P.matcher(statements[i]).matches()) {
                commands[i] = getStoreCmd(STORE_AREA_P.split(
                        STORE_SPACE_P.matcher(statements[i])
                                    .replaceAll("")));
            }
            else {
                if (SEARCH_MANNER_P.matcher(statements[i]).find()) {
                    // Replaces "look (in|on|around|under) with just 'search'"
                    statements[i] = SEARCH_MANNER_P.matcher(statements[i])
                            .replaceAll("search");
                }
                
                commands[i] = getCmdActionFirst(INSTRUCTIVE_P.
                        split(stripPrepositions(statements[i]))
                );
            }
            //-----------------------------------------------------------------
        }
        return commands;
    }
    //*************************************************************************
    // </editor-fold>
    //*************************************************************************
    
    
    //*************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Command assemblers">
    //*************************************************************************
    /**
     * Assembles a command where the player interacts with furniture with
     * possibly an item.
     * If s is size 2, then second string is presumably an item.
     */
    private static Command getCmdActionFirst(String[] s) {
        String actionObject = s[0];
        
        // Get just the first word
        Verb verb = new Verb(SPACE_THEN_ALL_P.matcher(actionObject)
                                            .replaceAll(""));
        
        // Everything but the first word.
        String object = FIRST_WORD_P
                        .matcher(actionObject.trim())
                        .replaceFirst("");
        
        DirectObj dirObj = new DirectObj(object);
        
        switch(s.length) {
            case 2:
                if (ANY_DIGIT_P.matcher(s[1]).matches()) {
                    // Player typed a slot number and not an item name.
                    int i = Integer.parseInt(s[1]) - 1;

                    if (i >= 0 && i < Player.getInv().size())
                        return new Command(
                                new Instrument(Player.getInv().get(i).toString()), 
                                dirObj
                        );
                    else
                        return NO_SLOT_CMD;
                }
                else 
                    return new Command(new Instrument(s[1]), dirObj);
            case 1:
                if (verb.VALUE.equals(dirObj.VALUE))
                    // If they're equal, the player entered a single word.
                    return new Command(Verb.SEARCH_VERB, dirObj);
                else
                    return new Command(verb, dirObj);
            default:
                return DEFAULT_CMD;
        }
    }
    // ========================================================================
    /**
     * Assembles a command where the player stores an item.
     * If the furniture turns out to not be searchable, the item is used
     * on it instead in order to resolve ambiguity. If s is size 2, then
     * the second string is presumably the name of furniture.
     */
    private static Command getStoreCmd(String[] s) {
        String object = s[0];
        Instrument inst;
        DirectObj obj = null;
        
        if (DROP_P.matcher(object).matches()) {
            // Player typed "put <item> down"
            obj = DirectObj.FLOOR_OBJECT;
            object = object.replaceAll(" down", "");
        }
        
        if (ANY_DIGIT_P.matcher(object).matches()) {
            // Player typed a slot number and not an item name.
            int i = Integer.parseInt(object) - 1;
            
            if (i >= 0 && i < Player.getInv().size())
                inst = new Instrument(Player.getInv().get(i).toString());
            else
                return NO_SLOT_CMD;
        }
        else 
            inst = new Instrument(object);
        
        switch(s.length) {
            case 2:
                return new Command(Verb.PUT_VERB, inst, new DirectObj(s[1]));
            case 1:
                return (obj == null) ?
                    AMBIGUOUS_CMD :
                    new Command(Verb.PUT_VERB, inst, obj);
            default:
                return DEFAULT_CMD;
        }
    }
    // ========================================================================
    /**
     * Assembles a command where the player uses an item, possibly on a
     * piece of furniture.
     * Has been recently modified to accept throwing an breaking commands.
     * If s is size 2, then the second string is presumably a furniture name.
     */
    private static Command getItemCmd(String[] s) {
        String verbObject = stripPrepositions(s[0]);
        
        Verb use = new Verb( // Get just the first word.
                SPACE_THEN_ALL_P.matcher(verbObject).replaceFirst("")
        );
        
        String item = // Everything but the first word.
                WORD_SPACE_P.matcher(verbObject).replaceFirst(""); 
        
        Instrument inst;
        
        if (ANY_DIGIT_P.matcher(item).matches()) {
            // Player used an item slot instead of an item name
            int i = Integer.parseInt(item) - 1;
            
            if (i >= 0 && i < Player.getInv().size()) {
                inst = new Instrument(Player.getInv().get(i).toString());
            }
            else
                return NO_SLOT_CMD;
        }
        else if (INSTRUCTIVE_P.matcher(item).find()) {
            // Player typed a phrase including "<furniture> with/using <item>
            String[] furnItem = INSTRUCTIVE_P.split(item);
            
            return new Command(new Instrument(furnItem[1]), 
                               new DirectObj(furnItem[0]));
        }
        else
            inst = new Instrument(item);
        
        
        switch(s.length) {
            case 1:
                return new Command(use, inst);
            case 2:
                if (! (use.VALUE.equals("throw") || 
                       use.VALUE.equals("break") || 
                       use.VALUE.equals("destroy"))
                    )
                    return new Command(inst, new DirectObj(s[1]));
                else
                    return new Command(use, inst);
            default:
                return DEFAULT_CMD;
        }
    }
    //*************************************************************************
    // </editor-fold>
    //*************************************************************************
    
    
    //*************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Command class">
    //*************************************************************************
    private static class Command {
        private final Runnable ACTION;
        private final String VALUE;
        // ====================================================================
        // <editor-fold defaultstate="collapsed" desc="constructors">
        public Command(Verb v, DirectObj o) {
            VALUE = "VERB: " + v.toString() + "\tOBJECT: " + o.toString();
            System.out.println("Creating action -> furniture command: " + VALUE);

            ACTION = (() -> Player.evaluateAction(v.toString(), o.toString()));
        }
        // --------------------------------------------------------------------
        public Command(Instrument i, DirectObj o) {
            VALUE = "ITEM: " + i.toString() + "\tOBJECT: " + o.toString();
            System.out.println("Creating item -> furniture command: " + VALUE);
            ACTION = (() -> execute(i, o));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i) {
            VALUE = "VERB: " + v.toString() + "\tITEM: " + i.toString();
            System.out.println("Creating use item command: " + VALUE);
            ACTION = (() -> execute(v, i));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i, DirectObj o) {
            VALUE = "VERB: " + v.toString() + "\tITEM: " + i.toString() + "\tOBJECT: " + o.toString();
            System.out.println("Creating store item command: " + VALUE);
            ACTION = (() -> execute(v, i, o));
        }
        // --------------------------------------------------------------------
        public Command(String s) {
            VALUE = s;
            System.out.println("Creating print command -> \"" + s + "\".");
            ACTION = (() -> GUI.out(s));
        }
        // --------------------------------------------------------------------
        public Command(Runnable b, String desc) {
            VALUE = desc;
            System.out.println("Creating player method command -> " + VALUE);
            ACTION = b;
        }
        // </editor-fold>
        // ====================================================================
        
        
        // ====================================================================
        // <editor-fold defaultstate="collapsed" desc="execute methods">
        /**
         * Uses the item i on the furniture o.
         */
        private static void execute(Instrument i, DirectObj o) {
            String itemName = Player.tryIndefRef_Item(i.toString());
            
            if (Player.hasItemResembling(itemName)) {
                Player.setLastInteract_Item(itemName);
                Player.evalUse(Player.getInv().get(itemName), o.toString());
            }
            else
                GUI.out(DONT_HAVE_IT);
        }
        // --------------------------------------------------------------------
        /**
         * Uses the item i in the specified way (v).
         * Long chain of if statements in order to accept a variety of input!
         * If player isn't carrying the item, checks if it's actually furniture
         * the player typed. If it is, acts on it instead (Mainly for inspect/
         * examine commands.
         */
        private static void execute(Verb v, Instrument i) {
            String verb = v.toString(),
                   instrument = Player.tryIndefRef_Item(i.toString());
            
            if (Player.hasItemResembling(instrument)) {
                Player.setLastInteract_Item(instrument);
                A_Super.Item item = Player.getInv().get(instrument);
                String type = item.getType();

                if (verb.equals("use"))
                    GUI.out(item.useEvent());
                //-------------------------------------------------------------
                else if (INSPECT_P.matcher(verb).matches())
                    GUI.out(item.getDesc());
                //-------------------------------------------------------------
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: READ">
                else if (verb.equals("read")) {
                    if (type.equals(READABLE) 
                            || item.toString().equals(BOOK_PHYL)) // Phylactery type. Not readable
                        GUI.out(item.useEvent());
                    else
                        GUI.out("That isn't something you can read...");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: WEAR">
                else if (verb.equals("wear")) {
                    if (type.equals(SHOES) || type.equals(CLOTHING))
                        GUI.out(item.useEvent());
                    else
                        GUI.out("That isn't something you can wear...");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: DROP">
                else if (verb.equals("drop") || verb.equals("remove")) {
                    if (verb.equals("remove") && item.getType().equals(SHOES)) {
                        if (Player.getShoes().equals(""))
                            GUI.out("You aren't wearing any shoes.");
                        else
                            GUI.out(item.useEvent());
                    }
                    else if (Player.getPos().hasFurniture("floor")) {
                        Furniture floor = Player.getFurnRef("floor");
                        if (floor.isSearchable()) {
                            Player.evalStore(floor.getInv(), item);
                            GUI.out("It's dropped.");
                        }
                        else
                            GUI.out("It's not a good idea to drop that here.");
                    }
                    else {
                        GUI.out("It's not a good idea to drop that here.");
                    }
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: THROW">
                else if (verb.equals("throw")) {
                    Player.getInv().remove(item);
                    Furniture floor = Player.getFurnRef("floor");

                    if (floor == null) {
                        GUI.out("A quick ingenious thought convinces the player to "
                              + "throw the " + item + ". The item lands in "
                              + "an unknown location, lost to the aether.");
                    }
                    else if (type.equals(BREAKABLE)) {
                        floor.getInv().add(new Item("destroyed " + item, 
                                "The " + item + " is now broken and certainly useless.", -50));

                        GUI.out("After some quick thinking, you passionately "
                              + "launch the " + item + " as an olympic discus "
                              + "thrower would. The item lands on the floor.");
                    }
                    else if (type.equals(LIQUID) || type.equals(INGREDIENT) 
                            || type.equals(FOCUS)) 
                    {
                        if (! item.toString().equals(BUCKET_OF_WATER)) {
                            floor.getInv().add(BROKEN_GLASS);
                            GUI.out("A cunning decision is made. The player "
                                  + "throws the " + item + ". The item lands "
                                  + "on the floor. A glassy shatter swarms your "
                                  + "ear and fills you with rue.");
                        }
                        else {
                            floor.getInv().add(item);
                            GUI.out("Be careful with that. You wouldn't want "
                                  + "to get the floor all soaked and risk "
                                  + "dying of a clumsy step.");
                        }
                    }
                    else if (type.equals(PHYLACTERY)) {
                        floor.getInv().add(item);
                        GUI.out("You naively launch the " + item + " across the\n"
                              + "room in hopes of destroying the cursed item. The "
                              + item + " lands unscathed on the floor.");
                    }
                    else {
                        floor.getInv().add(item);
                        GUI.out("After some quick thinking, you passionately "
                              + "launch the " + item + " as an olympic discus "
                              + "thrower would. The item lands on the floor.");
                    }
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: BREAK">
                else if (verb.equals("destroy") || verb.equals("break")) {
                    if (type.equals(BREAKABLE)) {
                        Player.getInv().remove(item);
                        Player.getInv().add(new Item("destroyed " + item, 
                                "The " + item + " is now broken and certainly useless.", -50));
                        GUI.out("An acute sense of frustration causes you to crush it in your hand.");
                    }
                    else if ((type.equals(LIQUID) && ! item.toString().equals(BUCKET_OF_WATER)) 
                            || type.equals(FOCUS) || type.equals(INGREDIENT)) 
                    {
                        Player.getInv().remove(item);
                        Player.getInv().add(BROKEN_GLASS);
                        GUI.out("An acute sense of frustration causes you to "
                              + "crush the feeble glass in your hand.");
                    }
                    else if (type.equals(READABLE)) {
                        Player.getInv().remove(item);
                        Player.getInv().add(RIPPED_SHREDS);
                        GUI.out("A cunning idea forms. You rip up the paper "
                              + "to shreds and stuff it back into your pocket.");
                    }
                    else if (type.equals(PHYLACTERY)) {
                        GUI.out("You try with all your might to destroy the "
                            + item + ", but fail to leave even a fingerprint.");
                    }
                    else {
                        GUI.out("You lack the strength to do that.");
                    }
                }
                // </editor-fold>
                    
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: RIP">
                else if (verb.equals("rip") || verb.equals("tear")) {
                    if (type.equals(READABLE)) {
                        Player.getInv().remove(item);
                        Player.getInv().add(RIPPED_SHREDS);
                        GUI.out("A cunning idea forms. You rip up the paper wantonly and stuff it back into your pocket.");
                    }
                    else
                        GUI.out("That is not something you could rip up.");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: DRINK">
                else if (verb.equals("drink")) {
                    if (type.equals(INGREDIENT) || type.equals(LIQUID)) {
                        if (item.toString().equals(PHASE_DOOR_POTION))
                            GUI.out(item.useEvent());
                        else if (item.toString().equals(BUCKET_OF_WATER))
                            GUI.out("Ah, refreshing!!");
                        else if (item.toString().equals(ACETONE) || item.toString().matches("molten.*"))
                            GUI.out("No possible way you're doing something that stupid!");
                        else
                            GUI.out("You reluctantly take a small sip. 'Yugh! Bitter and disgusting!'");
                    }
                    else
                        GUI.out("That is not something you can drink...");
                }
                // </editor-fold>
                
                // <editor-fold defaultstate="collapsed" desc="VERB TYPE: EAT">
                else if (verb.equals("eat") || verb.equals("consume")) {
                    if (item.toString().equals(GLOWING_FRUIT)) {
                        GUI.out("The fruit's glow and tasteful aroma entice you irresistibly. "
                              + "You bite down and find the fruit as hard as a rock. "
                              + "A sharp pain comes and you pull the fruit away.");
                    }
                    else
                        GUI.out("The " + item + " seems most inedible...");
                }
                // </editor-fold>
                //-------------------------------------------------------------
                else
                    GUI.out("You will need to be more specific.");
            }
            else 
                Player.evaluateAction(verb, i.toString());

            Player.printInv();
        }
        // --------------------------------------------------------------------
        /**
         * Stores the item i into the furniture o.
         * Can be of the form "put *item* down" to drop an item.
         * Verb parameter is always 'put'. It's there to disambiguate it from
         * execute(Instrument i, DirectObject o) constructor.
         */
        private static void execute(Verb v, Instrument i, DirectObj o) {
            String itemName = Player.tryIndefRef_Item(i.toString());
            
            if (Player.hasItemResembling(itemName)) {
                String furniture = Player.tryIndefRef_Furn(o.toString());
                Item item = Player.getInv().get(itemName);
                Player.setLastInteract_Item(itemName);

                if (Player.getPos().hasFurniture(furniture)) {
                    Furniture furn = Player.getFurnRef(furniture);
                    Player.setLastInteract_Furn(furniture);
                    
                    // Stores the furniture
                    if (furn.isSearchable()) {
                        Player.evalStore(furn.getInv(), item);
                        Player.printInv();
                    }
                    // Not searchable, but perhaps it's meant to be used by the item still.
                    // e.g. the Labo distiller used by the florence flask.
                    else if (furn.useKeyMatches(item.toString())) {
                        GUI.out(furn.useEvent(item));
                        Player.printInv();
                    }
                    else 
                        GUI.out("You can't store that in there.");        
                }
                else if (furniture.equals(LOOT_SACK) || furniture.equals("sack")) {
                    // If the player wants to put something in the loot sack.
                    if (Player.hasItem(LOOT_SACK)) {
                        try {
                            LootSack sack = (LootSack)Player.getInv().get(LOOT_SACK);
                            Player.evalStore(sack.getInv(), item);
                            Player.printInv();

                            if (item.toString().equals(LOOT_SACK))
                                GUI.out("You stuff the sack inside itself and pull the string. "
                                      + "All of the sudden, the sack is gone. You stand there, "
                                      + "empty-handed, and confused.");
                        }
                        catch (ClassCastException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    else
                        GUI.out("There is no " + furniture + " here.");
                }
                else
                    GUI.out("There is no " + furniture + " here.");
            }
            else
                GUI.out(DONT_HAVE_IT);
        }
        // </editor-fold>
        // ====================================================================
        
        public void perform() {
            this.ACTION.run();
        }
    }
    //*************************************************************************
    // </editor-fold> 
    //*************************************************************************
    
    
    //*************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Word classes"> 
    //
    // Represent items, actions, and furniture mentioned in player input.
    // Different word subclasses exist to differentiate Command constructors.
    //*************************************************************************
    abstract private static class Word {
        protected final String VALUE;
        // -------------------------
        public Word(String word) {
            this.VALUE = word;
        }
        // -------------------------
        @Override public String toString() {
            return VALUE;
        }
    }
    // ========================================================================
    private static class Verb extends Word {
        public final static Verb 
            PUT_VERB = new Verb("put"),         // Default verb for storing
            GO_VERB = new Verb("go"),           // Default verb for moving
            SEARCH_VERB = new Verb("search");   // Default verb for searching
        
        public Verb(String verb) {
            super(verb);
        }
    }
    // ========================================================================
    private static class DirectObj extends Word {
        public final static DirectObj 
            FLOOR_OBJECT = new DirectObj("floor");  // For drop commands
        
        public DirectObj(String object) {
            super(object);
        }
    }
    // ========================================================================
    private static class Instrument extends Word {
        public Instrument(String instrument) {
            super(instrument);
        }
    }
    //*************************************************************************
    // </editor-fold>
    //*************************************************************************
}
