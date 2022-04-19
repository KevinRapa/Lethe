package A_Super;

import A_Main.AudioPlayer;

/**
 * Defines generic attributes of a statue.
 * @author Kevin Rapa
 */
abstract public class Statue extends Furniture {
    private static final String MOVE_DIAL =
            "With a burst of almost super-human adrenaline, you "
            + "passionately thrust yourself into the statue, moving "
            + "it a small distance. You discover nothing interesting.";
    //-------------------------------------------------------------------------
    public Statue() {
        super();
        
        this.actDialog = "You brush your hand against the statue and marvel at its detail.";
        this.searchDialog = "You look around the statue but find nothing of interest.";

        this.addNameKeys("statues?");
        this.addActKeys("speak|talk|converse|chat|greet|listen");
        this.addActKeys(MOVEPATTERN, FEELPATTERN, GETPATTERN, "admire");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN)) {
            AudioPlayer.playEffect(41);
            return MOVE_DIAL;
        }
        else if (key.equals("admire"))
            return "The statue's smooth and chiseled features trap your gaze "
                 + "in mesmerisation.";
        else if (key.matches(FEELPATTERN))
            return this.actDialog;
        else if (key.matches(GETPATTERN))
            return "This is much too large to take.";
        else
            return "\"Hello? Doth thou hast knowledge of an escape? You make your inquiry, "
                 + "but the statue stands motionless, nonchalant, and with a mark of disinterest.";
    }
    //------------------------------------------------------------------------- 
}


