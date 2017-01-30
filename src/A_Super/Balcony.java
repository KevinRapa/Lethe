package A_Super;
/**
 * @author Kevin Rapa
 */
public class Balcony extends Furniture {
    // ========================================================================
    public Balcony () {
        super();

        this.actDialog = "That doesn't seem like a safe thing to do...";
        this.searchDialog = "The entire balcony? One thing at a time please.";

        this.addNameKeys("(?:balcony )?railing");
        this.addActKeys("lean", "jump", "hold", "grab");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("lean"))
            return this.actDialog;
        else if (key.equals("jump"))
            return "Are we flirting with death now?";
        else 
            return "You grab the balcony railing, but surely you'd never fall over by accident.";
    }
    // ========================================================================         
}


