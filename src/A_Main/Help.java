package A_Main;

import static A_Main.Names.SEP;
import java.util.HashMap;
import java.io.*;
import java.util.regex.Pattern;
import static A_Main.Patterns.*;

/**
 * This class comprises the help section of the game.
 * The Help is comprised of nested menus directing the player to different
 * help topics.
 * @author Kevin Rapa
 */
public final class Help {
    private static final HashMap<String, String> 
            HELP = new HashMap<>(), // Maps keys to topics
            TOPIC = new HashMap<>(); // Maps topics to explanations.
     
    private static final String[] HELP_KEYS = {
        "prompt", "moving", "describing", "checking", "searching", "activating",
        "using", "combining", "inspecting", "notes", "inventory", "key ring", "phylacteries",
        "loot", "doors", "rooms", "furniture", "items", "keys", "phylacteries"
    };
    
    private static final String[] TOPIC_KEYS = {
        "1c","2c","3c","4c","5c","6c","7c","8c","9c","10c",
        "1p","2p","3p","4p","1a","2a","3a","4a","5a","6a"
    };
    
    static {
        for (String helpKey : HELP_KEYS) {
            HELP.put(helpKey, "data" + SEP + "help" + SEP + helpKey + ".txt");      
        }
        
        int index = 0;
        
        for (String topicKey : TOPIC_KEYS) {
            TOPIC.put(topicKey, HELP_KEYS[index++]); 
        }
    }
//-----------------------------------------------------------------------------
    /**
     * A structure of nested menus organizing game topics.
     */
    public static void helpSub() {        
        String choice;
        AudioPlayer.playEffect(2);
        
        do {
            GUI.menOut(Menus.HELP_MAIN);
            choice = GUI.promptOut();

            if (choice.equals("1")) {
                innerLoop(Menus.HELP_SUB1, CONTROL_CHOICE, "c");          
            }
            else if (choice.equals("2")) {  
                innerLoop(Menus.HELP_SUB2, PLAYER_CHOICE, "p");  
            }
            else if (choice.equals("3")) {   
                innerLoop(Menus.HELP_SUB3, CASTLE_CHOICE, "a");
            }
        } while (! choice.isEmpty());   
        
        GUI.clearDialog();
        GUI.toMainMenu();
        GUI.clearDialog();
    }
    //-------------------------------------------------------------------------
    private static void innerLoop(String menu, Pattern p, String code) {
        String choice;
        AudioPlayer.playEffect(2);
        
        do {
            GUI.menOut(menu);
            choice = GUI.promptOut().concat(code);

            if (p.matcher(choice).matches()) {
                AudioPlayer.playEffect(2);
                String path = HELP.get(TOPIC.get(choice));
                StringBuilder b = new StringBuilder();
              
                try (BufferedReader r = new BufferedReader(
                        new FileReader(new File(path)))) 
                {
                    String s;
                    
                    while ((s = r.readLine()) != null) {
                        b.append(s);
                    }
                } catch (IOException ex) {
                    b.append(ex.getMessage());
                }
                
                GUI.out(b.toString());
            }
        } while (! choice.equals(code));
    }
    //-------------------------------------------------------------------------
}
