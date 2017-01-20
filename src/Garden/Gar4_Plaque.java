package Garden;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar4_Plaque extends Furniture {
    private boolean isMoved;
    // ========================================================================
    public Gar4_Plaque () {
        super();
        this.searchable = false;
        this.isMoved = false;
        
        this.description = "The small plaque reads, \"In memorium of Oswald, who lived to create.\"";
        this.actDialog = "You move the plaque off to the side.";
        this.searchDialog = "You lift the plaque, but find only soil, and put it back down.";

        this.addNameKeys("(?:small )?plaque");
        this.addActKeys("read", "move", "slide", "lift");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return this.isMoved ? "You have already moved the plaque." : this.searchDialog;
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("read"))
            return this.description;
        else {
            if (! this.isMoved) {
                this.isMoved = true;
                return this.actDialog;
            }
            else
                return "You have already moved the plaque.";
        }
    }
    // ========================================================================  
    public boolean isMoved() {
        return this.isMoved;
    }
    // ========================================================================  
}


