package Garden;

import A_Super.Item;
import static A_Main.Id.GCHS;
import static A_Main.Names.CROWBAR;
import static A_Main.Names.HAND_DRILL;
import A_Super.LockedContainer;
/**
 * @author Kevin Rapa
 */
public class Gar3_Chest extends LockedContainer {
    //-------------------------------------------------------------------------
    public Gar3_Chest(Item... items) {
        super(GCHS, items);
        
        this.actDialog = "It takes a small bit of force, but the rusty key manages to open the chest.";
        this.description = "It's a wooden chest for the holding of gardening implements and "
                + "other nonsense. This one has a rather large keyhole.";
        this.searchDialog = "To your dismay, the chest has been locked previously.";
        this.useDialog = "An ingenious idea. The player manages to break the lock using the drill "
                       + "with a swift jab into the keyhole.";

        this.addUseKeys(HAND_DRILL, CROWBAR);
        this.addNameKeys("(?:wooden )?(?:utility )?chest", "lock");
    }
    //-------------------------------------------------------------------------  
    @Override public String useEvent(Item item) {
        if (searchable)
            return "The chest has already been unlocked.";
        
        this.searchable = true;
        
        if (item.toString().equals(HAND_DRILL))
            return this.useDialog;
        else 
            return "The crowbar offers enough leverage to "
                    + "pry the lid open, yielding glorious access.";
    }
    //-------------------------------------------------------------------------
}


