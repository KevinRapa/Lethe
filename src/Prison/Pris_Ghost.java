package Prison;

import A_Main.GUI;
import A_Main.Menus;
import static A_Main.Names.SHINY_WATCH;
import A_Main.Player;
import A_Super.Item;
import A_Super.NonPlayerCharacter;
/**
 * @author Kevin Rapa
 */
public class Pris_Ghost extends NonPlayerCharacter {
    private boolean pleased;
    // ========================================================================
    public Pris_Ghost () {
        super();

        this.pleased = false;    
        
        this.description = "The apparition resembles a middle-aged bald male with a long beard. "
                         + "his eyes are blank, and he sits passively in the corner. He looks "
                         + "at you funny. \"Do you have a habit of staring?\" He asks.";
        this.actDialog = "\"Now that I have my watch, I do not have any more reason " +
                         "to stay. I suppose I will find peace somewhere else in " +
                         "a little while.\"";
        this.searchDialog = "The ghost looks to not have anything interesting.";

        this.addNameKeys("(?:spooky )?(?:sitting )?(?:blue )?(?:ghost|figure|person|apparition)", "him");
    }
    // ========================================================================  
    @Override public String useEvent(Item item) {
        if (item.toString().equals(SHINY_WATCH)) {
            Player.getInv().remove(item);
            return this.converse2();
        }
        else if (! pleased) { 
            if (firstTime)
                return "\"What is this? This isn't mine... I mean, I appreciate the gesture, but I'm looking for something else.\"";
            else
                return "\"I'm pretty sure that isn't it. Don't worry, I have all the time in the world.\"";
        }
        else
            return "\"I appreciate the continued gifts, but I'm fine. Thank you.\"";
    }    
    // ========================================================================
    @Override public String interact(String key) {   
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        else if (this.firstTime) 
            return this.converse1();
        else {
            if (! pleased)
                return "\"Did you find something that might be it? "
                        + "Hand it over and let me see...\"";
            else 
                return 
                "\"I do understand that the Treasure is hidden in the caves " +
                "beneath this castle. I have watched Eury travel through " +
                "here many times, into the crypt, frustrated. The Treasure " +
                "does not want to be here, and desires only to be close to " +
                "where it was created. You should find the treasure where " +
                "the stench of hell is the strongest.\"";
        }    
    }
    // ========================================================================     
    @Override protected String converse1() {
        firstTime = false;
        
        GUI.menOut(Menus.ENTER);
        GUI.out("\"... ... ... You aren't Kampe. You better tread " +
                "carefully, or Kampe will lock you up as he did " +
                "me. It is not a wise decision to be here, stranger. " +
                "If you are down here to find Eury's Treasure, then " +
                "you have not descended far enough.\"");
        GUI.promptOut();
        
        GUI.out("\"I was foolish enough to try. Kampe's only job is " +
                "to guard the Treasure by walking these tunnels, " +
                "although the location of the Treasure has been " +
                "forgotten, even to Kampe. Most everyone who lives " +
                "here has either left or slipped into a blissful " +
                "madness.\"");
        GUI.promptOut();
        
        GUI.out("\"This river here... you'd expect it to empty into " +
                "the surrounding sea. But it does not. This river " +
                "empties to a place much deeper, the place which " +
                "birthed the Treasure. If you seek it, I cannot help, " +
                "but you may find something in Kampe's quarters.\"");
        GUI.promptOut();
        
        
        GUI.out("\"In addition, Kampe took something from me. Ordinarily, " +
                "he would have locked my possessions in the cabinet next " +
                "to these cells. Be he took something special of mine, a " +
                "family heirloom, that I suspect is captive in his " +
                "quarters. Bring it to me, and I can offer more " +
                "information on the Treasure.\"");
        GUI.promptOut();
        
        return "\"Ehhhh... ... No, I cannot remember what it is to tell " +
               "the truth. My mind is weakening on account of the water, " + 
               "but do not worry. I do not suffer here, for I do not " +
               "know the word's meaning any longer. All I know of myself " + 
               "is my name, Hypnos.\"";
    }
    // ========================================================================     
    @Override protected String converse2() {
        this.pleased = true;
        
        GUI.menOut(Menus.ENTER);
        GUI.out("\"Ah yes! I do believe this is it, a valuable watch handed " +
                "down to me from my mother. I would never leave this place " +
                "without it. Thank you, sir of the woods, knower of the " +
                "species', speaker to the birds.\"");
        GUI.promptOut();
        
        GUI.out("\"I do understand that the Treasure is hidden in the caves " +
                "beneath this castle. I have watched Eury travel through " +
                "here many times, into the crypt, frustrated. The Treasure " +
                "does not want to be here, and desires only to be close to " +
                "where it was created. You should find the treasure where " +
                "the stench of hell is the strongest.\"");
        GUI.promptOut();
        
        GUI.out(actDialog);
        GUI.promptOut();

        return "\"... No I couldn't have just walked through the bars and " +
               "into Kampe's quarters. Ghosts do not work that way! Now " +
               "thank you, my friend.\"";
    }
    // ========================================================================                 
}


