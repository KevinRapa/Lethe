package Gallery;

import Super.Furniture;
import Super.Room;
        
public class Gal1_Scr extends Furniture {
    private boolean lifted;
    private final Gal1_Bttn REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Scr (String NAME, Furniture bttn) {
        super(NAME);
        this.searchable = false;
        this.lifted = false;
        this.REF = (Gal1_Bttn)bttn;
        this.description = "The hanging scroll is ink drawn in black on an\n"
                         + "orange-stained parchment. It depicts a few scraggly\n"
                         + "trees in front of a mountain range. At the top,\n"
                         + "something is written in a foreign language. The\n"
                         + "light is hitting this piece strangely.";
        this.searchDialog = "There is something odd about the light hitting this\n"
                          + "scroll.";
        this.interactDialog = "Upon lifting the scroll from the wall, you discover a\n"
                    + "hollow containing a dome-shaped button.";
        this.addActKeys("move", "take", "lift", "slide", "remove");
        this.addNameKeys("scroll", "chinese scroll");
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(Room[][][] map, String key) {     
            Room gal1 = map[3][2][6];
            String rep = "You have already discovered the button.";
            
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
