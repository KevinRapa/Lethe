package Tower;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Tow1_Pdstl extends Furniture {
    // ========================================================================
    public Tow1_Pdstl (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The pedestal is a solid gray stone platform with two\n"
                         + "brass extensions on the top.";
        this.searchDialog = "You try to approach the pedestal, but some sort of repelling force is preventing you.";
        this.useDialog = "You naively wave the staff in an arbitrary pattern. Nothing happens. \"Does this staff even do anything?\" You ask yourself.";

        this.addNameKeys("(?:solid )?(?:gray )?(?:stone )?(?:pedestal|platform)", 
                "(?:silver )?(?:glowing )?(?:object|scepter)", "(?:brass )?extensions?");
        this.addUseKeys("dampening staff");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return this.containsItem("glowing scepter") ?
            this.description.concat(" The extensions support a silver glowing object.") :
            this.description;
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        this.searchable = Player.hasItem("dampening staff");
        
        return this.searchable ? "You approach the pedestal" : this.searchDialog;
    }
    // ========================================================================    
}


