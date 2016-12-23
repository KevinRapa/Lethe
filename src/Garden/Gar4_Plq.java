package Garden;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Gar4_Plq extends Furniture {
    private boolean isMoved;
    // ========================================================================
    public Gar4_Plq (Item... items) {
        super(items);
        this.searchable = false;
        this.isMoved = false;
        
        this.description = "The small plaque reads, \"In memorium of Oswald, who lived to create.\"";
        this.actDialog = "You move the plaque off to the side.";
        this.searchDialog = "You look under the plaque to find just soil.";

        this.addNameKeys("plaque");
        this.addActKeys("read", "move", "slide", "lift");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.isMoved ? "You have already moved the plaque." : this.searchDialog;
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.matches("read"))
            return this.description;
        else {
            if (! this.isMoved) {
                this.isMoved = true;
                return this.actDialog;
            }
            else
                return "You have already moved the plaque";
        }
    }
    // ========================================================================  
    public boolean isMoved() {
        return this.isMoved;
    }
    // ========================================================================  
}


