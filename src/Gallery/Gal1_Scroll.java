package Gallery;

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
    private final Furniture BTTN_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1_Scroll (Furniture bttn) {
        super();

        this.BTTN_REF = bttn;
        this.description = "The hanging scroll is ink drawn in black on an "
                         + "orange-stained parchment. It depicts a few scraggly "
                         + "trees in front of a mountain range. At the top, "
                         + "something is written in a foreign language. The "
                         + "light is hitting this piece strangely.";
        this.searchDialog = "There is something odd about the light hitting this "
                          + "scroll.";
        this.actDialog = "Upon lifting the scroll from the wall, you discover a "
                    + "hollow containing a dome-shaped button.";
        this.addActKeys(MOVEPATTERN, GETPATTERN);
        this.addNameKeys("(?:hanging )?(?:chinese )?scroll");
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(String key) {     
            if (! Player.getPos().hasFurniture(BTTN_REF)) {
                Player.getPos().addFurniture(BTTN_REF);
                return this.actDialog;
            }      
            else 
                return "You have already moved it!";
    }
/*----------------------------------------------------------------------------*/
}
