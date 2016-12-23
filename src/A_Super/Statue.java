package A_Super;

/**
 * @author Kevin Rapa
 */
abstract public class Statue extends Furniture {

    // ========================================================================
    public Statue(Item ... items) {
        super(items);
        this.searchable = false;
        
        this.actDialog = "You feel the statue and marvel at its detail.";
        this.searchDialog = "You look around the statue but find nothing of interest.";

        this.addNameKeys("statue");
        this.addActKeys("touch", "feel", "grab");
    }
    // ========================================================================   
}


