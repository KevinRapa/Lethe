package Courtyard;

import static A_Main.Names.SHOVEL;
import static A_Main.Names.CROWBAR;
import static A_Main.Names.HOE;
import A_Super.Furniture;
import A_Super.Gettable;
/**
 * @author Kevin Rapa
 */
public class Cou_Tiles extends Furniture implements Gettable {
    //-------------------------------------------------------------------------
    public Cou_Tiles () {
        super();

        this.description = "The array of square rock tiles wraps around the "
                         + "perimeter of the fountain. Many of them are "
                         + "weathered, uneven, and cracked";
        this.searchDialog = "The tiles are much too heavy to lift with your hands.";
        this.actDialog = this.searchDialog;
        this.useDialog = "You pry one of the tiles up, but all revealed is only "
                       + "a square dirt indentation in the ground. Tired, you "
                       + "drop the tile back into the hole to avoid tripping.";

        this.addNameKeys("(?:tiled )?walkway", "(?:square )?(?:rock )?tiles");
        this.addUseKeys(SHOVEL, CROWBAR, HOE);
        this.addActKeys("lift", MOVEPATTERN, GETPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.matches(GETPATTERN))
            return getIt();
        else
            return this.actDialog;
    }
    //-------------------------------------------------------------------------        
}


