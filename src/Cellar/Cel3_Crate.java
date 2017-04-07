package Cellar;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Cel3_Crate extends SearchableFurniture 
        implements Gettable, Moveable 
{
    // ========================================================================
    public Cel3_Crate (Item... items) {
        super(items);
        
        this.searchable = false;
        
        this.description = 
                "The large wooden crate is about 3 feet on all sides "
                + "and appears reinforced. Several nails all over the crate "
                + "seal the lid shut.";
        this.actDialog = "You have nothing effective to pry it with.";
        this.searchDialog = "You peer inside the pried open crate.";
        this.useDialog = "That seems like an interesting idea, considering "
                + "the crate is open already.";

        this.addNameKeys("(?:large )?(?:wooden )?crate", "nails?", "screws?");
        this.addUseKeys(ANYTHING);
        this.addActKeys("pry", "open", "break", GETPATTERN, JOSTLEPATTERN);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.searchable ? 
                "The wooden crate has been opened by the astute player." :
                this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.searchable ? 
                this.searchDialog : 
                "The wooden crate is sealed shut and offers no view inside.";
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("pry")) {
            if (Player.hasItem(CROWBAR)) {
                Item crowbar = Player.getInv().get(CROWBAR);
                return this.useEvent(crowbar);
            } 
            else  
                return this.actDialog;
        }
        else if (key.equals("open"))
            return "Yes, that would be good to do, but you do not even have the "
                    + "strength to do that by hand.";
        else if (key.equals("break"))
            return "Doing that by hand would be quite painful and regretable.";
        else if (key.equals(GETPATTERN))
            return getIt();
        else {
            AudioPlayer.playEffect(40);
            return "You kick the crate out of frustration, but what "
                    + "does not destroy the crate only makes it stronger.";
        }
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        String name = item.toString();
        
        if (name.equals(CROWBAR) || name.equals(SCREWDRIVER)) {
            if (searchable) 
                return this.useDialog;
            else {
                this.searchable = true;
                
                if (name.equals(SCREWDRIVER))
                    AudioPlayer.playEffect(33);
                
                return name.equals(CROWBAR) ? 
                        "The crate snaps open under the leverage of the superior crowbar." : 
                        "The screwdriver is super-effective against the rogue screws. ";
            }
        }
        else if (name.equals(HAND_TORCH))
            return "The room's humidity prevents you from burning the crate open.";
        else if (name.equals(HAMMER))
            return searchable ? 
                    this.useDialog :
                    "What appeared to be nails holding the crate shut are, to the player's dismay, "
                  + "heavy-duty screws. They cannot be pried with a common hammer.";
        else if (name.equals(BOTTLE_OF_VINEGAR))
            return "How ingenious, attempting to dissolve the crate with acid. Unbeknownst "
                    + "to the player, acetic acid is weak and could not dissolve even a "
                    + "marshmallow.";
        else if (name.equals(GLUE_BOTTLE))
            return "Gluing the crate together? Isn't that the opposite of what we're "
                    + "trying to accomplish here?";
        else if (name.equals(MONKEY_WRENCH) || name.equals(METAL_BAR)) {
            AudioPlayer.playEffect(40);
            return this.searchable ? this.useDialog :
                    "The small blunt object is not powerful enough to break into "
                    + "the crate.";
        }
        else if (item.getType().equals(WEAPON))
            return this.searchable ? this.useDialog :
                    "You succeed in only making small gashes and slices in the "
                    + "powerful crate.";
        else
            return DEFAULT_USE;
    }
    // ========================================================================     
}


