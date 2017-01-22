package Gallery;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * Hides a lever which must be pulled to turn on the GAL1 Dragon.
 * 
 * @see Gallery.Gal1_Dragon
 * @see Gallery.Gal1_Switch
 * @author Kevin Rapa
 */       
public class Gal1_Screen extends Furniture {
    private boolean lifted;
    private final Gal1_Switch REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Screen (Furniture swtch) {
        super();
        this.searchable = false;
        this.lifted = false;
        this.REF = (Gal1_Switch)swtch;
        this.description = "The four-paneled Japanese screen sits in the corner\n"
                         + "of the room. A panorama is hand-drawn on it. Its\n"
                         + "delicate black lines depict a mountain front landscape.";
        this.searchDialog = "The light shining through this screen forms an odd\n"
                          + "silhouette on its surface.";
        this.actDialog = "You slide the screen out of the way some, revealing a\n"
                    + "large black lever mounted to the floor.";  
        this.addActKeys(GETKEYS);
        this.addActKeys("move", "lift", "slide");
        this.addNameKeys("screen", "japanese screen");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (! this.lifted) {
            this.lifted = true;
            AudioPlayer.playEffect(41);
            Player.getRoomObj(Id.GAL1).addFurniture(REF);
            return this.actDialog;
        }            
        return "You have already moved the screen.";
    }
/*----------------------------------------------------------------------------*/
    public boolean isMoved() {
        return this.lifted;
    }
/*----------------------------------------------------------------------------*/
}