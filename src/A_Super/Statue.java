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
                        + "it a small amount. You discover nothing interesting.";
        this.actDialog = "You feel the statue and marvel at its detail.";
        this.searchDialog = "You look around the statue but find nothing of interest.";

        this.addNameKeys("statue");
        this.addActKeys(MOVEPATTERN);
        this.addActKeys("touch", "feel", "grab");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches(MOVEPATTERN)) {
            AudioPlayer.playEffect(41);
            return this.moveDialog;
        }
        else
            return this.actDialog;
    }
    // ======================================================================== 
}


