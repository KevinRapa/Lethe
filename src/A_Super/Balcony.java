package A_Super;
/**
 * @author Kevin Rapa
 */
public class Balcony extends Furniture implements Unmoveable {
    // ========================================================================
    public Balcony () {
        super();

        this.actDialog = "That doesn't seem like a safe thing to do...";
        this.searchDialog = "The entire balcony? One thing at a time please.";

        this.addNameKeys("(?:balcony )?railing", "balcony");
        this.addActKeys("lean", "jump", "vault", HOLDPATTERN);
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("lean"))
            return this.actDialog;
        else if (key.equals("jump") || key.equals("vault"))
            return "Are we flirting with death now?";
        else 
            return "You grab the balcony railing, but surely you'd never fall over by accident.";
    }
    // ========================================================================         
}


