package Prison;

import static A_Main.NameConstants.SHINY_WATCH;
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
        
        this.description = "";
        this.actDialog = "\"Now that I have my watch, I do not have any more reason " +
                         "to stay. I suppose I will find peace somewhere else in " +
                         "a little while.\"";
        this.searchDialog = "The ghost looks to not have anything interesting.";

        this.addUseKeys(ANYTHING);
        this.addNameKeys("(?:sitting )?(?:ghost|figure|person)");
    }
    // ========================================================================  
    @Override public String useEvent(Item item) {
        if (! pleased) {        
            if (item.toString().equals(SHINY_WATCH) {
                Player.getInv().remove(item);
                this.converse3();
                return null;
            }
            else
                return "\"I'm pretty sure that isn't it. Don't worry, I have all the time in the world.\"";
        }
        else
            return "\"I appreciate the continued gifts, but I'm fine. Thank you.\"";
    }    
    // ========================================================================
    @Override public String interact(String key) {       
        if (! pleased) {
            if (this.firstTime)
                this.converse1();
            else
                this.converse2();
        }
        else
            GUI.out(actDialog);
    }
    // ========================================================================     
    @Override protected Void converse1() {
        firstTime = false;
        
        GUI.menOut("Press enter...");
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
        
        GUI.out("\"Ehhhh... ... No, I cannot remember what it is to tell " +
                "the truth. My mind is weakening on account of the water, " + 
                "but do not worry. I do not suffer here, for I do not " +
                "know the word's meaning any longer. All I know of myself " + 
                "is my name, Hypnos.\"");
        GUI.promptOut();
    }
    // ========================================================================     
    @Override protected Void converse2() {
        GUI.out("\"Did you find something that might be it? Hand it over and let me see...\"");
    }
    // ========================================================================     
    private void converse3() {
        GUI.menOut("Press enter...");
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
        
        GUI.out("\"... No I couldn't have just walked through the bars and " +
                "into Kampe's quarters. Ghosts do not work that way! Now " +
                "thank you, my friend.\"");
        GUI.promptOut();
        this.pleased = true;
    }
    // ========================================================================             
}


