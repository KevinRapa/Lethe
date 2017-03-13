package A_Main;

import static A_Main.NameConstants.*;
import static A_Main.Patterns.*;
import A_Super.Furniture;
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

    private static final String
        NOTHING = "", 
        SPACE = " ",
        DONT_HAVE_IT = "You aren't carrying that.";
    
    // List of standard commands that are likely to be made many times.
    private static final Command 
            DEFAULT_CMD =   new Command("What does that mean?"),
            EXPLETIVE_CMD = new Command("Mind yourself! You're a guest here!"),
            SUICIDE_CMD =   new Command("You haven't reached that point yet!!"),
            DESTROY_CMD =   new Command("Yes, you're frustrated, hungry, and angry, but don't be so reckless!"),
            GREETING_CMD =  new Command("What do you think this is? Zork?"),
            NO_SLOT_CMD =   new Command("Seems that you don't have an existing slot there."),
            AMBIGUOUS_CMD = new Command("You need to specify something to put that in!");
            
    //*************************************************************************
    // <editor-fold desc="Queue methods">
    //*************************************************************************
    public static boolean moreCommands() {
        return (! COMMAND_QUEUE.isEmpty());
    }
    // ========================================================================
    public static void performNextCommand() {
        COMMAND_QUEUE.poll().perform();
    }
    //*************************************************************************
    // </editor-fold>
    //*************************************************************************
    
    
    //*************************************************************************
    // <editor-fold desc="Text parser">
    //*************************************************************************
    /**
     * Removes articles 'a', 'an', 'the', and the pronoun 'some' from the input,
     * and then queue's up all the commands chained together by conjunctions.
     * @param input An input string by the player
     */
    public static void processText(String input) {
        String noArticles = ARTICLE_P.matcher(input).replaceAll(NOTHING);

        for (Command c : splitCommands(noArticles))
            COMMAND_QUEUE.offer(c);
        
        performNextCommand();
    }
    // ========================================================================
    /**
     * Removes prepositions, which won't effect the meaning in this context.
     * @param input An article-less string of input.
     * @return The sentence stripped of prepositions.
     */
    private static String stripPrepositions(String input) {
        StringBuilder builder = new StringBuilder();
        
        for (String word : input.split(SPACE)) {
            if (! PREPOS_P.matcher(word).matches())
                builder.append(word).append(SPACE);
        }
        return builder.toString().trim();
    }
    // ========================================================================
    /**
     * Splits the sentence using a conjunction as a delimiter into statements,
     * then populates a list of commands.
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
                                .replaceFirst(NOTHING)));
            }
            else if (SUICIDE_P.matcher(statements[i]).matches()) {
                commands[i] = SUICIDE_CMD;
            }
            else if (DESTROY_P.matcher(statements[i]).matches()) {
                commands[i] = DESTROY_CMD;
            }
            else if (COMBINE_P.matcher(statements[i]).matches()) {
                String s = statements[i]; // Variable for lambda must be final.
                commands[i] = new Command(() -> Player.combineSub(s));
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
                                    .replaceAll(NOTHING)));
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
    // <editor-fold desc="Command assemblers">
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
                                            .replaceAll(NOTHING));
        
        DirectObj dirObj = new DirectObj(FIRST_WORD_P
                .matcher(actionObject.trim())
                .replaceFirst(NOTHING)); // Remove the first word.
        
        switch(s.length) {
            case 2:
                return new Command(new Instrument(s[1]), dirObj);
            case 1:
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
            object = object.replaceAll(" down", NOTHING);
        }
        
        if (NUMBER_P.matcher(object).matches()) {
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
                // Player used the item on furniture.
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
     * If s is size 2, then the second string is presumably a furniture name.
     */
    private static Command getItemCmd(String[] s) {
        String verbObject = stripPrepositions(s[0]);
        
        Verb use = new Verb( // Get just the first word.
                SPACE_THEN_ALL_P.matcher(verbObject).replaceFirst(NOTHING)
        );
        
        String item = // Everything but the first word.
                WORD_SPACE_P.matcher(verbObject).replaceFirst(NOTHING); 
        
        Instrument inst;
        
        if (NUMBER_P.matcher(item).matches()) {
            int i = Integer.parseInt(item) - 1;
            
            if (i >= 0 && i < Player.getInv().size()) {
                inst = new Instrument(Player.getInv().get(i).toString());
            }
            else
                return NO_SLOT_CMD;
        }
        else 
            inst = new Instrument(item);
        
        switch(s.length) {
            case 1:
                return new Command(use, inst);
            case 2:
                return new Command(inst, new DirectObj(s[1]));
            default:
                return DEFAULT_CMD;
        }
    }
    //*************************************************************************
    // </editor-fold>
    //*************************************************************************
    
    
    //*************************************************************************
    // <editor-fold desc="Command class">
    //*************************************************************************
    private static class Command {
        private final Runnable ACTION;
        private final String VALUE;
        // ====================================================================
        // <editor-fold defaultstate="collapsed" desc="constructors">
        public Command(Verb v, DirectObj o) {
            VALUE = v.toString() + SPACE + o.toString();
            System.out.println("Creating verb -> object command: " + VALUE);
            ACTION = (() -> Player.evaluateAction(v.toString(), o.toString()));
        }
        // --------------------------------------------------------------------
        public Command(Instrument i, DirectObj o) {
            VALUE = i.toString() + SPACE + o.toString();
            System.out.println("Creating item -> object command: " + VALUE);
            ACTION = (() -> execute(i, o));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i) {
            VALUE = v.toString() + SPACE + i.toString();
            System.out.println("Creating use item command: " + VALUE);
            ACTION = (() -> execute(v, i));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i, DirectObj o) {
            VALUE = v.toString() + SPACE + i.toString() + SPACE + o.toString();
            System.out.println("Creating store command: " + VALUE);
            ACTION = (() -> execute(v, i, o));
        }
        // --------------------------------------------------------------------
        public Command(String s) {
            VALUE = s;
            System.out.println("Creating print command -> \"" + s + "\".");
            ACTION = (() -> GUI.out(s));
        }
        // --------------------------------------------------------------------
        public Command(Runnable b) {
            VALUE = b.toString();
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
        private void execute(Instrument i, DirectObj o) {
            if (Player.hasItemResembling(i.toString()))
                Player.evalUse(Player.getInv().get(i.toString()), o.toString());
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
        private void execute(Verb v, Instrument i) {
            String verb = v.toString();
            
            if (Player.hasItem(i.toString())) {
                A_Super.Item item = Player.getInv().get(i.toString());
                String type = item.getType();

                if (verb.equals("use"))
                    GUI.out(item.useEvent());
                
                else if (INSPECT_P.matcher(verb).matches())
                    GUI.out(item.getDesc());
                
                else if (verb.equals("read")) {
                    if (type.equals(READABLE) 
                            || item.toString().equals(BOOK_PHYL)) // Phylactery type. Not readable
                        GUI.out(item.useEvent());
                    else
                        GUI.out("That isn't something you can read...");
                }
                else if (verb.equals("wear")) {
                    if (type.equals(SHOES) || type.equals(CLOTHING))
                        GUI.out(item.useEvent());
                    else
                        GUI.out("That isn't something you can wear...");
                }
                else if (verb.equals("drop") || verb.equals("remove")) {
                    if (verb.equals("remove") && item.getType().equals(SHOES)) {
                        if (Player.getShoes().equals(NOTHING))
                            GUI.out("You aren't wearing any shoes.");
                        else
                            GUI.out(item.useEvent());
                    }
                    else if (Player.getPos().hasFurniture("floor")) {
                        Furniture floor = Player.getFurnRef("floor");
                        if (floor.isSearchable()) {
                            Player.evalStore(floor, item);
                            Player.printInv();
                        }
                        else
                            GUI.out("It's not a good idea to drop that here.");
                    }
                    else {
                        GUI.out("It's not a good idea to drop that here.");
                    }
                }
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
                else if (verb.equals("eat") || verb.equals("consume")) {
                    if (item.toString().equals(GLOWING_FRUIT))
                        GUI.out("You know, that might destroy the phylactery, which you need to do, AND you're quite hungry...\n"
                              + "but conversely it quite possibly may drive you into hopeless insanity, so let's not do that.");
                    else
                        GUI.out("That... REALLY does not seem edible...");
                }
                else
                    GUI.out("You will need to be more specific.");
            }
            else if (Player.getPos().hasFurniture(i.toString()) || 
                     IT_THEM_P.matcher(i.toString()).matches()) {
                Player.evaluateAction(v.toString(), i.toString());
            }
            else
                GUI.out(DONT_HAVE_IT);
        }
        // --------------------------------------------------------------------
        /**
         * Stores the item i into the furniture o.
         * Can be of the form "put *item* down" to drop an item.
         * Verb parameter is always 'put'. It's there to disambiguate it from
         * execute(Instrument i, DirectObject o) constructor.
         */
        private void execute(Verb v, Instrument i, DirectObj o) {
            if (Player.hasItemResembling(i.toString())) {
                A_Super.Item item = Player.getInv().get(i.toString());
                
                if (Player.getPos().hasFurniture(o.toString())) {
                    A_Super.Furniture furn = Player.getFurnRef(o.toString());
                    
                    // Stores the furniture
                    if (furn.isSearchable()) {
                        Player.evalStore(furn, item);
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
                else
                    GUI.out("There is no " + o + " here.");
            }
            else
                GUI.out(DONT_HAVE_IT);
        }
        // </editor-fold>
        // ====================================================================
        
        
        // ====================================================================
        public void perform() {
            this.ACTION.run();
        }
        // ====================================================================
        @Override public String toString() {
            return VALUE;
        }
    }
    //*************************************************************************
    // </editor-fold> 
    //*************************************************************************
    
    
    //*************************************************************************
    // <editor-fold desc="Word Classes"> 
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
                PUT_VERB = new Verb("put"),
                GO_VERB = new Verb("go");
        
        public Verb(String verb) {
            super(verb);
        }
    }
    // ========================================================================
    private static class DirectObj extends Word {
        public final static DirectObj FLOOR_OBJECT = new DirectObj("floor");
        
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
