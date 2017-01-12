package Ancient_Tomb;

import A_Main.Player;
import A_Super.NonPlayerCharacter;
/**
 * An NPC that the player can talk to. Gives the player a tool to find the 
 * iridescent jewel.
 * 
 * @see Ancient_Tomb.Ct_Cmpss
 * @author Kevin Rapa
 */
public class Ant_NPC extends NonPlayerCharacter {
    private final String CONVERSE_REP2;
    // ========================================================================
    public Ant_NPC () {
        super();
        this.description = "The hideous dessicated figure is eyeless and frail. It just\n" +
                           "stands there in the corner of the room, pointing\n" +
                           "its face at you with its mouth hanging open. It\n" +
                           "is clothed in simple farmer's clothes and keeps\n" +
                           "one of its hands in its pocket. 'Is it alive?'\n" +
                           "You think to yourself.";
        this.actDialog =    "'I've gotten this far, what's the worst that could happen?',\n"
                          + "you think to yourself. You\n"
                          + "open your mouth to speak. As you do, the figure makes a\n" +
                            "loud moan. You jump, and every hair on your body stands.\n" +
                            "The figure reaches into its pocket and hands you a\n" +
                            "small boxey object. The figure makes another load moan\n"
                          + "and holds its hand out. You take the item. The figure\n" +
                            "makes a final loud moan and remains quiet.";
        
        this.searchDialog = "You never were much of a pickpocket.";
        
        this.CONVERSE_REP2 = "The figure just stands there, staring at you with\n"
                           + "its mouth hanging open.";

        this.addNameKeys("(?:frail )?(?:eyeless )?(?:dessicated )?(?:corpse|figure)");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (firstTime) {
            this.firstTime = false;
            return converse1();
        }
        else
            return converse2();
    }
    // ========================================================================   
    @Override protected<String> String converse1() {
        Player.getInv().add(new Ct_Cmpss("quartz device"));
        
        return (String)actDialog;
    }
    // ========================================================================   
    @Override protected<String> String converse2() {
        return (String)CONVERSE_REP2;
    }
    // ========================================================================   
}


