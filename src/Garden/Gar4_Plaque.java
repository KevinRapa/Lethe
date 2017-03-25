package Garden;

import A_Main.AudioPlayer;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gar4_Plaque extends Furniture {
    private boolean isMoved;
    // ========================================================================
    public Gar4_Plaque () {
        super();
        this.isMoved = false;
        
        this.description = "The small plaque reads, \"In memory of Daedalus, who lived to create.\"";
        this.actDialog = "You move the plaque off to the side.";
        this.searchDialog = "You lift the plaque and find only soil. You put it back down to the side.";

        this.addNameKeys("(?:small )?plaque");
        this.addActKeys(MOVEPATTERN, "lift", "read");
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        String result = this.isMoved ? 
                "You have already moved the plaque." : this.searchDialog;
        this.isMoved = true;
        return result;
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("read"))
            return this.description;
        else {
            if (! this.isMoved) {
                AudioPlayer.playEffect(51);
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


