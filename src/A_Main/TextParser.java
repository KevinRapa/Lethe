package A_Main;

import java.util.LinkedList;
/**
 * @author Kevin Rapa
 */
public class TextParser {
    private static final String[] PREPOSITIONS = 
        {"up", "down", "(?:in|on)(?:to)?", "out", "of", "through", "against", "around", "to"};
    
    private static final String INSTRUCTIVE_PATTERN = " with | using ",
            
                                CONJUNCTION_PATTERN = " and(?: then| also)? | then(?: also)? ",
            
                                MOVEMENT_PATTERN = "(?:go|move|walk|run|crawl) "
                                + "(?:north|forward|south|east|right|west|left|"
                                + "(?:down|back|up)(?:wards?)?)";
    
    private final static LinkedList<Command> COMMAND_QUEUE = new LinkedList<>();
    // ========================================================================
    /**
     * Strips the articles from the sentence, splits it into commands and
     * enqueue's them.
     * @param input Player input resembling a phrase or sentence.
     */
    public static void processText(String input) {
        String noArticles = input.replaceAll("\\bthe |\\.", "");
        
        for (Command c : splitCommands(noArticles))
            if (c != null)
               COMMAND_QUEUE.offer(c);

       performNextCommand();
    }
    // ========================================================================
    public static boolean moreCommands() {
        return (! COMMAND_QUEUE.isEmpty());
    }
    // ========================================================================
    public static void performNextCommand() {
        COMMAND_QUEUE.poll().perform();
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
        String[] commands = sentence.split(CONJUNCTION_PATTERN);
        Command[] result = new Command[commands.length];
        
        for (int i = 0; i < result.length; i++) {
            if (commands[i].matches(MOVEMENT_PATTERN)) {
                result[i] = new Command(
                        new Verb("go"), 
                        new DirectObject(commands[i].replaceFirst("\\w+ ", ""))
                );
            }
            else if (commands[i].matches("(?:use|read) [a-z0-9: ,'-]+")) {
                result[i] = getInstrumentalCommand(
                                commands[i].split(" on "));
            }
            else {
                result[i] = getCommandActionFirst(
                                discardPrepositions(commands[i])
                                        .split(INSTRUCTIVE_PATTERN)
                );
            }
        }
        
        return result;
    }
    // ========================================================================
    /**
     * Takes a string arrays and forms a command from it.
     * If the array is length 2, then index 1 is presumably an item.
     * @param s A string array of length 1 or 2.
     * @return 
     */
    private static Command getCommandActionFirst(String[] s) {
        Command command = null;
        String actionObject = s[0];
        Verb verb = new Verb(actionObject.replaceFirst("\\s.+", "")); // Selects first word.
        DirectObject dirObj = new DirectObject(actionObject.trim().replaceFirst("[a-z]+\\s", "")); // Selects all but the first word.
        
        switch(s.length) {
            case 2:
                Instrument inst = new Instrument(s[1]);
                command = new Command(inst, dirObj);
                break;
            case 1:
                command = new Command(verb, dirObj);
                break;
        }
        return command;
    }
    // ========================================================================
    /**
     * Takes a statement resembling "[use] `something` on `something` and creates
     * a command (The `use` has been removed at this point).
     * @param s A string array. If the length is 2, the second string is
     *          presumably an item.
     * @return A command.
     */
    private static Command getInstrumentalCommand(String[] s) {
        Command command = null;
        Verb use = new Verb(s[0].replaceFirst("\\s.+", ""));
        String object = s[0].replaceFirst("\\w+ ", "");
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
                command = new Command(use, inst);
                break;
            case 2:
                command = new Command(inst, new DirectObject(s[1]));
                break;
        }
        
        return command;
    }
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
            System.out.println("Creating command: " + VALUE);
            ACTION = (() -> Player.evaluateAction(v.toString(), o.toString()));
        }
        // --------------------------------------------------------------------
        public Command(Instrument i, DirectObject o) {
            VALUE = i.toString() + " " + o.toString();
            System.out.println("Creating command: " + VALUE);
            ACTION = (() -> execute(i,o));
        }
        // --------------------------------------------------------------------
        public Command(Verb v, Instrument i) {
            VALUE = v.toString() + " " + i.toString();
            System.out.println("Creating command: " + VALUE);
            ACTION = (() -> execute(v,i));
        }
        // </editor-fold>
        // ====================================================================
        private void execute(Instrument i, DirectObject o) {
            if (Player.hasItem(i.toString()))
                Player.evalUse(Player.getInv().get(i.toString()), o.toString());
            else
                GUI.out("You don't know what to do.");
        }
        // --------------------------------------------------------------------
        private void execute(Verb v, Instrument i) {
            String verb = v.toString();
            
            if (Player.hasItem(i.toString())) {
                A_Super.Item item = Player.getInv().get(i.toString());
                
                if (verb.equals("use") || item instanceof A_Super.Note)
                    GUI.out(item.useEvent());
                else
                    GUI.out("You can't read that.");
            }
            else
                GUI.out("You don't have a " + i);
        }
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
    // </editor-fold> *********************************************************
    // ========================================================================
    
    
    // ========================================================================
    // <editor-fold desc="Word Classes"> **************************************
    // ========================================================================
    private class Word {
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
    // </editor-fold> *********************************************************
    // ========================================================================
}
