package Gallery;

import Super.Furniture;
import Super.Room;
        
public class Gal1_Scrn extends Furniture {
    private boolean lifted;
    private final Gal1_Swtch REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Scrn (String NAME, Furniture swtch) {
        super(NAME);
        this.searchable = false;
        this.lifted = false;
        this.REF = (Gal1_Swtch)swtch;
        this.description = "The four-paneled Japanese screen sits in the corner\n"
                         + "of the room. A panorama is hand-drawn on it. Its\n"
                         + "delicate black lines depict a mountain front landscape.";
        this.searchDialog = "The light shining through this screen forms an odd\n"
                          + "silhouette on its surface.";
        this.interactDialog = "You slide the screen out of the way some, revealing a\n"
                    + "large black lever mounted to the floor.";       
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("screen", "japanese screen");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        Room gal1 = map[3][2][6];
        String rep = "You have already moved the screen.";
            
        if (! this.lifted) {
            rep = this.interactDialog;
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