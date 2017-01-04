package Gallery;

import A_Main.Player;
import A_Super.Furniture;
        
public class Gal1_Scrn extends Furniture {
    private boolean lifted;
    private final Gal1_Swtch REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Scrn (Furniture swtch) {
        super();
        this.searchable = false;
        this.lifted = false;
        this.REF = (Gal1_Swtch)swtch;
        this.description = "The four-paneled Japanese screen sits in the corner\n"
                         + "of the room. A panorama is hand-drawn on it. Its\n"
                         + "delicate black lines depict a mountain front landscape.";
        this.searchDialog = "The light shining through this screen forms an odd\n"
                          + "silhouette on its surface.";
        this.actDialog = "You slide the screen out of the way some, revealing a\n"
                    + "large black lever mounted to the floor.";       
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("screen", "japanese screen");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (! this.lifted) {
            this.lifted = true;
            Player.getRoomRef("GAL1").addFurniture(REF);
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