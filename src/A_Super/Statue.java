package A_Super;

/**
 * Defines generic attributes of a statue.
 * @author Kevin Rapa
 */
abstract public class Statue extends Furniture {
    // ========================================================================
    public Statue() {
        super();

        this.actDialog = "You feel the statue and marvel at its detail.";
        this.searchDialog = "You look around the statue but find nothing of interest.";

        this.addNameKeys("statue");
        this.addActKeys("touch", "feel", "grab");
    }
    // ========================================================================   
}


