package A_Super;

import A_Main.AudioPlayer;

/**
 * Defines generic attributes of a statue.
 * @author Kevin Rapa
 */
abstract public class Statue extends Furniture {
    protected String moveDialog;
    //-------------------------------------------------------------------------
    public Statue() {
        super();
        
        this.moveDialog = "With a burst of almost super-human adrenaline, you "
                        + "passionately thrust yourself into the statue, moving "
                        + "it a small distance. You discover nothing interesting.";
        this.actDialog = "You brush your hand against the statue and marvel at its detail.";
        this.searchDialog = "You look around the statue but find nothing of interest.";

        this.addNameKeys("statues?");
        this.addActKeys("speak|talk|converse|chat|greet|listen");
        this.addActKeys(MOVEPATTERN, FEELPATTERN, "admire");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN)) {
            AudioPlayer.playEffect(41);
            return this.moveDialog;
        }
        else if (key.equals("admire"))
            return "The statue's smooth and chiseled features trap your gaze "
                 + "in mesmerisation. Its delicate curves.. ehhh whatever it's "
                 + "a rock someone banged with a hammer and chisel a bunch of times. "
                 + "Woodworking! Now that's a refined art.";
        else if (key.matches(FEELPATTERN))
            return this.actDialog;
        else
            return "\"Hello? Doth thou hast knowledge of an escape? Per chance "
                 + "be you the owner? Hello?\" You redundantly make your inquiry, "
                 + "but the statue stands motionless, nonchalant, and with a mark of disinterest.";
    }
    //------------------------------------------------------------------------- 
}


