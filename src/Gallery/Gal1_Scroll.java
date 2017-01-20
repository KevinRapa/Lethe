package Gallery;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * Hides a button which is pushed to turn on the GAL1 dragon.
 * 
 * @see Gallery.Gal1_Button
 * @see Gallery.Gal1_Drgn
 * @author Kevin Rapa
 */
public class Gal1_Scroll extends Furniture {
    private boolean lifted;
    private final Gal1_Button BTTN_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Scroll (Furniture bttn) {
        super();
        this.searchable = false;
        this.lifted = false;
        this.BTTN_REF = (Gal1_Button)bttn;
        this.description = "The hanging scroll is ink drawn in black on an\n"
                         + "orange-stained parchment. It depicts a few scraggly\n"
                         + "trees in front of a mountain range. At the top,\n"
                         + "something is written in a foreign language. The\n"
                         + "light is hitting this piece strangely.";
        this.searchDialog = "There is something odd about the light hitting this\n"
                          + "scroll.";
        this.actDialog = "Upon lifting the scroll from the wall, you discover a\n"
                    + "hollow containing a dome-shaped button.";
        this.addActKeys(GETKEYS);
        this.addActKeys("move", "lift", "slide");
        this.addNameKeys("(?:hanging )?(?:chinese )?scroll");
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(String key) {     
            if (! this.lifted) {
                this.lifted = true;
                Player.getRoomObj(Id.GAL1).addFurniture(BTTN_REF);
                return this.actDialog;
            }            
            return "You have already discovered the button.";
    }
/*----------------------------------------------------------------------------*/
        public boolean isMoved() {
            return this.lifted;
        }
/*----------------------------------------------------------------------------*/        
}
