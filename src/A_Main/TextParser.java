package A_Main;

import java.util.LinkedList;
/**
 * This processes more complex sentences into statements containing verbs,
 * items, and furniture.
 * 
 * @author Kevin Rapa
 */
public class TextParser {
    private final static LinkedList<Command> COMMAND_QUEUE = new LinkedList<>();
    
    private static final String[] PREPOSITIONS = 
        {"up", "down", "(?:in|on)(?:to)?", "out", "of", "through", "against", "around", "to", "at"};
    
    private static final String INSTRUCTIVE_PATTERN = " with | using ",
                                INSPECT_PATTERN = "look(?: at)?|inspect|examine|check (?: out)?",
                                CONJUNCTION_PATTERN = " and(?: then| also)? | then(?: also)? ",
                                MOVEMENT_PATTERN = "(?:go|move|walk|run|crawl) "
                                + "(?:north|forward|south|east|right|west|left|"
                                + "(?:down|back|up)(?:wards?)?)";
    
    private static final Command DEFAULT_COMMAND = new Command("What does that mean?");
    
    // <editor-fold desc="Queue methods">
    public static boolean moreCommands() {
        return (! COMMAND_QUEUE.isEmpty());
    }
    // ========================================================================
    public static void performNextCommand() {
        
        COMMAND_QUEUE.poll().perform();
    }
    // </editor-fold>
    
    // ========================================================================
    /**
     * Strips the articles from the sentence, splits it into commands and
     * enqueue's them.
     * @param input Player input resembling a phrase or sentence.
     */
    public static void processText(String input) {
        String noArticles = input.replaceAll("\\bthe |\\.", "");
        
        if (input.matches("commit suicide|kill (?:your)?self")) {
            GUI.out("You haven't reached that point yet!!");
            return;
        }
        else if (input.matches("(?:say|speak|yell|shout) .+")) {
            GUI.out(input.replaceAll("\\w+ ", "").concat("!"));
            return;
        }
        
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
    private static String discardPrepositions(String input) {
        StringBuilder builder = new StringBuilder();
        
        for (String word : input.split(" ")) {
            if (! isPreposition(word))
                builder.append(word).append(" ");
        }
        return builder.toString().trim();
    }
    // ========================================================================
    private static boolean isPreposition(String s) {
        for (String p : PREPOSITIONS)
            if (s.matches(p))
                return true;
        
        return false;
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
            if (statements[i].matches(MOVEMENT_PATTERN)) 
                commands[i] = new Command(new Verb("go"), 
                        new DirectObject(statements[i].replaceFirst("\\w+ ", "")));
            
            else if (statements[i].matches("(?:use|read|" + INSPECT_PATTERN + ") [a-z0-9: ,'-]+")) 
                commands[i] = getInstrumentalCommand(statements[i].split(" on "));
            
            else if (statements[i].matches("(?:put|store) [a-z0-9: ,'-]+"))
                commands[i] = getStoreCommand(statements[i].replaceAll("(?:put|store) ", "")
                                        .split(" (?:in|on)(?:to)? | under(?:neath) | next to | beside "));
            else 
                commands[i] = getCommandActionFirst(discardPrepositions(statements[i])
                                        .split(INSTRUCTIVE_PATTERN));
        }
        return commands;
    }
    // ========================================================================
    
    
    // ========================================================================
    // <editor-fold desc="Command assemblers"> *******************************
    // ========================================================================
    /**
     * Assembles a command where the player interacts with furniture with
     * possibly an item.
     */
    private static Command getCommandActionFirst(String[] s) {
        String actionObject = s[0];
        Verb verb = new Verb(actionObject.replaceFirst("\\s.+", "")); // Selects first word.
        DirectObject dirObj = new DirectObject(actionObject.trim().replaceFirst("[a-z]+\\s", "")); // Selects all but the first word.
        
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
    private static Command getStoreCommand(String[] s) {
        String object = s[0];
        Instrument inst;
        
        if (object.matches("[0-9]+")) {
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
                return new Command(new Verb("put"), inst, new DirectObject(s[1]));
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
    private static Command getInstrumentalCommand(String[] s) {
        String verbObject = discardPrepositions(s[0]);
        Verb use = new Verb(verbObject.replaceFirst("\\s.+", ""));
        String object = verbObject.replaceFirst("\\w+ ", "");
        Instrument inst;
        
        if (object.matches("[0-9]+")) {
            int i = Integer.parseInt(object) - 1;
            
            if (i >= 0 && i < Player.getInv().size())
                inst = new Instrument(Player.getInv().get(i).toString());
            else
                inst = new Instrument("thing there.");
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
    // ========================================================================
    // </editor-fold> *******************************************************
    // ========================================================================
    
    
    // ========================================================================
    // <editor-fold desc="Command class"> *************************************
    // ========================================================================
    private static class Command {
        private final Runnable ACTION;
        private final String VALUE;
        // ====================================================================
        // <editor-fold desc="constructors">
        public Command(Verb v, DirectObject o) {
            VALUE = v.toString() + " " + o.toString();
            System.out.println("Creating verb -> object command: " + VALUE);
            ACTION = (() -> Player.evaluateAction(v.toString(), o.toString()));
        }
        // --------------------------------------------------------------------
        public Command(Instrument i, DirectObject o) {
            VALUE = i.toString() + " " + o.toString();
            System.out.println("Creating item -> object command: " + VALUE);
            ACTION = (() -> execute(i, o));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i) {
            VALUE = v.toString() + " " + i.toString();
            System.out.println("Creating use item command: " + VALUE);
            ACTION = (() -> execute(v, i));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i, DirectObject o) {
            VALUE = v.toString() + " " + i.toString() + " " + o.toString();
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
                GUI.out("You don't know what to do.");
        }
        // --------------------------------------------------------------------
        /**
         * Uses the item i.
         */
        private void execute(Verb v, Instrument i) {
            String verb = v.toString();
            
            if (Player.hasItemResembling(i.toString())) {
                A_Super.Item item = Player.getInv().get(i.toString());
                
                if (verb.equals("use") || (verb.equals("read") && item instanceof A_Super.Note))
                    GUI.out(item.useEvent());
                else if (verb.matches(INSPECT_PATTERN))
                    GUI.out(item.getDesc());
                else
                    GUI.out("You can't read that.");
            }
            else
                GUI.out("You don't have a " + i);
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
                GUI.out("You don't have a " + i);
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
    // ========================================================================
    // </editor-fold> ************************************************************
    // ========================================================================
    
    
    // ========================================================================
    // <editor-fold desc="Word Classes"> **************************************
    // ========================================================================
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
    // ========================================================================
    // </editor-fold> *************************************************************
    // ========================================================================
}
