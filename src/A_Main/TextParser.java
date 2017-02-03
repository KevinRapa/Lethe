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
    private final static LinkedList<Command> COMMAND_QUEUE = 
        new LinkedList<>();

    private static final String // Delimiters
        INSTRUCTIVE_PATTERN =   " with | using ",
        CONJUNCTION_PATTERN =   " and(?: then| also)? | then(?: also)? ",
        DONT_HAVE_IT = "You aren't carrying that.";
    
    private static final String NOTHING = "", SPACE = " ";
    
    private static final Command DEFAULT_COMMAND = 
            new Command("What does that mean?");
    
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
    public static void processText(String input) {
        // Removes articles 'a', 'an', 'the'. Removes the pronoun 'some'.
        String noArticles = ARTICLE.matcher(input).replaceAll(NOTHING);
        
        if (SUICIDE.matcher(input).matches()) 
            GUI.out("You haven't reached that point yet!!");

        else if (SHOUT.matcher(input).matches())
            GUI.out(WORD_THEN_SPACE.matcher(input)
                    .replaceFirst(NOTHING).concat("!"));
        
        else if (DESTROY.matcher(input).matches())
            GUI.out("Yes, you're frustrated, hungry, and angry, but don't be so reckless!");

        else {
            for (Command c : splitCommands(noArticles))
                COMMAND_QUEUE.offer(c);

            performNextCommand();
        }
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
            if (! PREPOSITION.matcher(word).matches())
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
        String[] statements = sentence.split(CONJUNCTION_PATTERN);
        Command[] commands = new Command[statements.length];
        
        for (int i = 0; i < commands.length; i++) {
            if (ITEM_COMMAND.matcher(statements[i]).matches()) 
                commands[i] = getItemCmd(statements[i].split(" on "));
            
            else if (STORE_COMMAND.matcher(statements[i]).matches())
                commands[i] = getStoreCmd(STORE_THEN_SPACE.matcher(statements[i])
                                    .replaceAll(NOTHING)
                                    .split(" (?:in|on)(?:to)? | under(?:neath)? | next to | beside "));
            else 
                commands[i] = getCmdActionFirst(stripPrepositions(statements[i])
                                    .split(INSTRUCTIVE_PATTERN));
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
        Verb verb = new Verb(ALL_AFTER_SPACE.matcher(actionObject)
                                            .replaceAll(NOTHING));
        
        DirectObject dirObj = new DirectObject(actionObject
                .trim().replaceFirst("[a-z]+\\s", NOTHING)); // All but the first word.
        
        switch(s.length) {
            case 2:
                return new Command(new Instrument(s[1]), dirObj);
            case 1:
                return new Command(verb, dirObj);
            default:
                return DEFAULT_COMMAND;
        }
    }
    // ========================================================================
    /**
     * Assembles a command where the player stores an item.
     */
    private static Command getStoreCmd(String[] s) {
        String object = s[0];
        Instrument inst;
        
        if (SLOT_NUMBER.matcher(object).matches()) {
            int i = Integer.parseInt(object) - 1;
            
            if (i >= 0 && i < Player.getInv().size())
                inst = new Instrument(Player.getInv().get(i).toString());
            else
                inst = new Instrument("thing there.");
        }
        else 
            inst = new Instrument(object);

        switch(s.length) {
            case 2:
                return new Command(Verb.PUT_VERB, inst, new DirectObject(s[1]));
            case 1:
                return new Command("You need to specify something to put that in!");
            default:
                return DEFAULT_COMMAND;
        }
    }
    // ========================================================================
    /**
     * Assembles a command where the player uses an item.
     */
    private static Command getItemCmd(String[] s) {
        String verbObject = stripPrepositions(s[0]);
        
        Verb use = new Verb(
                ALL_AFTER_SPACE.matcher(verbObject)
                        .replaceFirst(NOTHING));
        
        String object = 
                WORD_THEN_SPACE.matcher(verbObject)
                        .replaceFirst(NOTHING);
        
        Instrument inst;
        
        if (SLOT_NUMBER.matcher(object).matches()) {
            int i = Integer.parseInt(object) - 1;
            
            if (i >= 0 && i < Player.getInv().size())
                inst = new Instrument(Player.getInv().get(i).toString());
            else
                inst = new Instrument("thing there."); // Becomes 'You don't have a thing there.'
        }
        else 
            inst = new Instrument(object);
        
        switch(s.length) {
            case 1:
                return new Command(use, inst);
            case 2:
                return new Command(inst, new DirectObject(s[1]));
            default:
                return DEFAULT_COMMAND;
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
        // <editor-fold desc="constructors">
        public Command(Verb v, DirectObject o) {
            VALUE = v.toString() + SPACE + o.toString();
            System.out.println("Creating verb -> object command: " + VALUE);
            ACTION = (() -> Player.evaluateAction(v.toString(), o.toString()));
        }
        // --------------------------------------------------------------------
        public Command(Instrument i, DirectObject o) {
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
        public Command(Verb v, Instrument i, DirectObject o) {
            VALUE = v.toString() + SPACE + i.toString() + SPACE + o.toString();
            System.out.println("Creating store command: " + VALUE);
            ACTION = (() -> execute(v, i, o));
        }
        // --------------------------------------------------------------------
        public Command(String s) {
            VALUE = s;
            ACTION = (() -> GUI.out(s));
        }
        // </editor-fold>
        // ====================================================================
        
        
        // ====================================================================
        // <editor-fold desc="execute methods">
        /**
         * Uses the item i on the furniture o.
         */
        private void execute(Instrument i, DirectObject o) {
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
            
            if (Player.hasItemResembling(i.toString())) {
                System.out.println(i);
                A_Super.Item item = Player.getInv().get(i.toString());
                String type = item.getType();
                
                if (verb.equals("use"))
                    GUI.out(item.useEvent());
                
                else if (INSPECT_PATTERN.matcher(verb).matches())
                    GUI.out(item.getDesc());
                
                else if (verb.equals("read")) {
                    if (type.equals(READABLE))
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
                    else
                        System.err.println("Error: no floor in room.");
                }
                else if (verb.equals("drink")) {
                    if (type.equals(INGREDIENT) || type.equals(LIQUID))
                        if (item.toString().equals(PHASE_DOOR_POTION))
                            GUI.out(item.useEvent());
                        else if (item.toString().equals(BUCKET_OF_WATER))
                            GUI.out("Ah, refreshing!!");
                        else if (item.toString().matches("molten.*"))
                            GUI.out("No possible way you're doing something that stupid!");
                        else
                            GUI.out("You reluctantly take a small sip. 'Yugh! Bitter and disgusting!'");
                    else
                        GUI.out("That is not something you can drink...");
                }
                else if (verb.equals("eat") || verb.equals("consume"))
                    GUI.out("That... REALLY does not seem edible...");
            }
            else if (Player.getPos().hasFurniture(i.toString()) || 
                     INDEFINITE_PRONOUN.matcher(i.toString()).matches()) {
                Player.evaluateAction(v.toString(), i.toString());
            }
            else
                GUI.out(DONT_HAVE_IT);
        }
        // --------------------------------------------------------------------
        /**
         * Stores the item i into the furniture o.
         * Verb parameter is always 'put'. It's there to disambiguate it from
         * execute(Instrument i, DirectObject o) constructor.
         */
        private void execute(Verb v, Instrument i, DirectObject o) {
            if (Player.hasItemResembling(i.toString())) {
                A_Super.Item item = Player.getInv().get(i.toString());
                
                if (Player.getPos().hasFurniture(o.toString())) {
                    A_Super.Furniture furn = Player.getFurnRef(o.toString());
                    
                    if (furn.isSearchable()) {
                        Player.evalStore(furn, item);
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
            return (String)VALUE;
        }
    }
    // ========================================================================
    private static class Verb extends Word {
        public final static Verb PUT_VERB = new Verb("put");
        
        public Verb(String verb) {
            super(verb);
        }
    }
    // ========================================================================
    private static class DirectObject extends Word {
        public DirectObject(String object) {
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
