package Gallery;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Room;
        
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
        Room gal1 = Player.getMapRef()[3][2][6];
        String rep = "You have already moved the screen.";
            
        if (! this.lifted) {
            rep = this.actDialog;
            this.lifted = true;
            gal1.addFurniture(REF);
        }            
        return rep;
    }
/*----------------------------------------------------------------------------*/
        public boolean isMoved() {
            return this.lifted;
        }
/*----------------------------------------------------------------------------*/
}