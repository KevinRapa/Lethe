package A_Super;

import A_Main.AudioPlayer;

/**
 * Defines generic attributes of a statue.
 * @author Kevin Rapa
 */
abstract public class Statue extends Furniture {
    protected String moveDialog;
    // ========================================================================
    public Statue() {
        super();
        
        this.moveDialog = "With a burst of almost super-human adrenaline, you\n"
                        + "passionately thrust yourself into the statue, moving\n"
                        + "it a small distance. You discover nothing interesting.";
        this.actDialog = "You feel the statue and marvel at its detail.";
        this.searchDialog = "You look around the statue but find nothing of interest.";

        this.addNameKeys("statues?");
        this.addActKeys("speak|talk|converse|chat|greet|listen");
        this.addActKeys(MOVEPATTERN);
        this.addActKeys(FEELPATTERN);
        this.addActKeys("admire");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN)) {
            AudioPlayer.playEffect(41);
            return this.moveDialog;
        }
        else if (key.equals("admire"))
            return "The statue's smooth and chiseled features trap your gaze\n"
                 + "in mesmerisation. Its delicate curves.. ehhh whatever it's\n"
                 + "a rock someone banged with a hammer and chisel a bunch of times.\n"
                 + "Woodworking! Now that's a refined art.";
        else if (key.matches(FEELPATTERN))
            return this.actDialog;
        else
            return "\"Hello? Doth thou hast knowledge of an escape? Per chance\n"
                 + "be you the owner? Hello?\" You redundantly make your inquiry,\n"
                 + "but the statue stands motionless, nonchalant, and with a mark of disinterest.";
    }
    // ======================================================================== 
}


