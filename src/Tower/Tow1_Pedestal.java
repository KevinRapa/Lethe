package Tower;

import static A_Main.NameConstants.DAMPENING_STAFF;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * Contains the scepter phylactery- player must have the dampening staff to obtain
 * this.
 * 
 * @author Kevin Rapa
 */
public class Tow1_Pedestal extends Furniture {
    // ========================================================================
    public Tow1_Pedestal (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The pedestal is a solid gray stone platform with two\n"
                         + "brass extensions on the top.";
        this.searchDialog = "You try to approach the pedestal, but some sort of repelling force is preventing you.";
        this.useDialog = "You naively wave the staff in an arbitrary pattern. Nothing happens. \"Does this staff even do anything?\" You ask yourself.";

        this.addNameKeys("(?:solid )?(?:gray )?(?:stone )?(?:pedestal|platform)", 
                "(?:silver )?(?:glowing )?(?:object|scepter)", "(?:brass )?extensions?");
        this.addUseKeys(DAMPENING_STAFF);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.containsItem("glowing scepter") ?
            this.description.concat(" The extensions support a silver glowing object.") :
            this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        this.searchable = Player.hasItem(DAMPENING_STAFF);
        
        return this.searchable ? "You approach the pedestal" : this.searchDialog;
    }
    // ========================================================================    
}


