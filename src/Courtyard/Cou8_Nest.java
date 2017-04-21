package Courtyard;

import A_Super.Gettable;
import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cou8_Nest extends SearchableFurniture implements Gettable {

    //-------------------------------------------------------------------------
    public Cou8_Nest (Item... items) {
        super(items);
        
        this.description = "It's a small empty raven's nest perched precariously on "
                         + "a nearby branch. The nest is composed of many misshapen "
                         + "twigs and brambles sticking out every which way. The nest "
                         + "contains a few pieces of debris, but no eggs.";
        this.searchDialog = "You look inside the nest.";
        this.actDialog = "What a humorous thing to think to type in.";

        this.addNameKeys("(?:raven's )?nest", "(?:raven|bird's) nest");
        this.addActKeys(SITPATTERN, GETPATTERN);
    }
    //------------------------------------------------------------------------- 
    @Override public String interact(String key) {
        return (key.matches(GETPATTERN)) ? 
                getIt("That belongs to a raven. You don't have it in your conscience to take that.") 
                : actDialog;
    }
    //------------------------------------------------------------------------- 
}


