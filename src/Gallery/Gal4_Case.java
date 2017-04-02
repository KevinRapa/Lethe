package Gallery;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
import A_Super.Unmoveable;

/**
 * @author Kevin Rapa
 */
public class Gal4_Case extends SearchableFurniture 
        implements Openable, Unmoveable
{
    // ========================================================================
    public Gal4_Case (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = 
                "The mounted metal case is padlocked shut and currently protecting a "
              + "large painting of a woman posing to the left in a chair. She has long "
              + "brown hair and pale, perfect skin, as well as a slight grin. "
              + "Interesting, as you note that she also lacks eyebrows.";
        
        this.actDialog = "You jam every key you can into the lock, but nothing fits.";
        this.searchDialog = "The case is locked shut, and you cannot pry it open.";
        this.useDialog = "The glass front is clearly designed to keep dimwits like you out.";

        this.addNameKeys("(?:mounted )?(?:metal )?case", "painting");
        this.addUseKeys(ANYTHING);
        this.addActKeys("break", "unlock", "loot", "destroy");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.containsItem(MONA_LISA) ? 
                this.description : "The mounted case is empty.";
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return searchable ? "You open the case." : this.searchDialog;
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("break") || key.equals("destroy"))
            return "This case is strong.";
        else if (key.equals("unlock"))
            return searchable ? this.actDialog : "The lock is broken already!";
        else
            return "You would like to do that, wouldn't you.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().equals(WEAPON)) {
            AudioPlayer.playEffect(35);
            return this.useDialog;
        }
        else if (item.toString().equals(BOTTLE_OF_VINEGAR))
            return "Dissolving the case with vinegar is an amusing idea at most.";
        else
            return DEFAULT_USE;
    }
    // ======================================================================== 
    public void unlock() {
        this.searchable = true;
    }
    // ======================================================================== 
}


