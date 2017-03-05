package Courtyard;

import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cou8_Nest extends SearchableFurniture implements Gettable {

    // ========================================================================
    public Cou8_Nest (Item... items) {
        super(items);
        
        this.description = "It's a small raven's nest perched precariously on\n"
                         + "a nearby branch. The nest is currently empty of birds,\n"
                         + "and only contains bits of debris.";
        this.searchDialog = "You look inside the nest.";
        this.actDialog = "What a humorous thing to try to do.";

        this.addNameKeys("(?:raven's )?nest", "(?:raven|bird's) nest");
        this.addActKeys(SITPATTERN, GETPATTERN);
    }
    // ======================================================================== 
    @Override public String interact(String key) {
        return (key.matches(GETPATTERN)) ? getIt() : actDialog;
    }
    // ======================================================================== 
    @Override public String getIt() {
        return "That belongs to a raven. You don't have it in your conscience to take that.";
    }
    // ======================================================================== 
}


