package Gallery;

import A_Main.AudioPlayer;
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
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Screen (Furniture swtch) {
        super();
        this.searchable = false;
        this.REF = swtch;
        this.description = "The four-paneled Japanese screen sits in the corner "
                         + "of the room. A panorama is hand-drawn on it. Its "
                         + "delicate black lines depict a mountain front landscape.";
        this.searchDialog = "The light shining through this screen forms an odd "
                          + "silhouette on its surface.";
        this.actDialog = "You slide the screen out of the way some, revealing a "
                    + "large black lever mounted to the floor.";  
        this.addActKeys(MOVEPATTERN, GETPATTERN);
        this.addNameKeys("(?:japanese )?screen");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {     
        if (! Player.getPos().hasFurniture(REF.getID())) {
            AudioPlayer.playEffect(41);
            Player.getPos().addFurniture(REF);
            return this.actDialog;
        }            
        return "You have already moved the screen.";
    }
//-----------------------------------------------------------------------------
}