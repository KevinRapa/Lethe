package Caves;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Furniture;
/**
 * The player must take this in the Deep Chamber to obtain the artifact.
 * This removes itself from this room once interacted with.
 * 
 * @author Kevin Rapa
 */
public class Artifact_Dummy extends Furniture {
    // ========================================================================
    public Artifact_Dummy () {
        super();
        this.searchable = false;
        
        this.description = "Just take the artifact and get out!";
        this.actDialog = "You fumble around and grab the artifact.";
        this.searchDialog = this.description;

        this.addNameKeys("artifact");
        this.addActKeys(GETKEYS);
    }
    // ======================================================================== 
    @Override public String getDescription() {
        return Cave.distortDescription(1, this.description);
    }
    // ========================================================================   
    @Override public String getSearchDialog() {
        return Cave.distortDescription(1, this.searchDialog);
    }
    // ========================================================================   
    @Override public String interact(String key) {
        Player.getInv().add(new Magic_Artifact("the artifact"));
        GUI.invOut("You are carrying:\n" + Player.getInv());
        Player.getPos().removeFurniture(this);
        return Cave.distortDescription(3, this.actDialog);
    }
    // ========================================================================         
}


