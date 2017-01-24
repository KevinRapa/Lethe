package A_Main;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Kevin Rapa
 */
public class TextParser {
    
    private static final String[] USELESS_WORDS = 
        {"up", "down", "(?:in|on)(?:to)?", "out", "of", "through", "against", "around", "to"};
    private static final String INSTRUCTIVE_PATTERN = "with|using";
    
    private final static LinkedList<Command> COMMAND_QUEUE = new LinkedList<>();
    // ========================================================================
    public static void processText(String input) {
        String noArticles = input.replaceAll("\\bthe ", "");
        
        for (Command c : splitCommands(noArticles))
            if (c != null)
               COMMAND_QUEUE.offer(c);

       // performNextCommand();
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
    private static String discardPrepositions(String input) {
        StringBuilder builder = new StringBuilder();
        
        for (String word : input.split(" ")) {
            if (! isUseless(word))
                builder.append(word).append(" ");
        }
        return builder.toString();
    }
    // ========================================================================
    private static boolean isUseless(String s) {
        for (String p : USELESS_WORDS)
            if (s.matches(p))
                return true;
        
        return false;
    }
    // ========================================================================
    /**
     * Splits the statement using a conjunction as a delimiter.
     * @param sentence a sentence with the articles removed.
     * @return a list of commands to execute.
     */
    private static Command[] splitCommands(String sentence) {
        String[] commands = sentence.split(" and(?: then | also )?| then(?: also )?");
        Command[] result = new Command[commands.length];
        
        for (int i = 0; i < result.length; i++) {
            if (commands[i].matches("(?:go|move|walk|run|crawl) (?:north|forward|south|east|right|west|left|(?:down|back|up)(?:wards?)?)")) {
                result[i] = new Command(
                        new Verb("go"), 
                        new DirectObject(commands[i].replaceAll("\\w+ ", ""))
                );
            }
            else if (commands[i].matches("use [a-z][a-z1-9: -]+")) {
                //result[i] = getCommandItemFirst(sentence.substring(4).split(" on "));
            }
            else {
                result[i] = getCommandActionFirst(
                        discardPrepositions(commands[i]).split(INSTRUCTIVE_PATTERN)
                );
            }
        }
        
        return result;
    }
    // ========================================================================
    private static Command getCommandActionFirst(String[] s) {
        Command command = null;
        String actionObject = s[0].trim();
        Verb verb = new Verb(actionObject.replaceFirst("\\s.+", ""));
        DirectObject dirObj = new DirectObject(actionObject.trim().replaceFirst("[a-z]+\\s", ""));
        
        switch(s.length) {
            case 2:
                Instrument inst = new Instrument(s[1].trim());
                command = new Command(inst, dirObj);
                break;
            case 1:
                command = new Command(verb, dirObj);
                break;
        }
        return command;
    }
    // ========================================================================
    private static Command getCommandItemFirst(String[] s) {
        System.out.println("Getting item first.");
        System.out.println("Array is: " + Arrays.toString(s));
        Command command = null;
        Verb use = new Verb("use");
        Instrument inst = new Instrument(s[0].trim());
        System.out.println("Inst is: " + inst);
        
        switch(s.length) {
            case 1:
                command = new Command(use, inst);
                break;
            case 2:
                command = new Command(inst, new DirectObject(s[1].trim()));
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
            VALUE = v.toString() + i.toString();
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
                if (verb.equals("use") || 
                        (verb.equals("read") && Player.getInv().get(i.toString()) instanceof A_Super.Note))
                    GUI.out(Player.getInv().get(i.toString()).useEvent());
                else if (verb.matches("eat|taste|swallow"))
                    GUI.out("You give it a lick. Disgusting!");
                else
                    GUI.out("What are you trying to do to it?");
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
