package Laboratory;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Cntrptn extends Furniture {

    // ========================================================================
    public Labo_Cntrptn (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "The large contraption seems to be composed of two parts.\n"
                         + "The left half has a bunsen burner under a rack for a flask.\n"
                         + "Above it is an inch-wide glass tube bridging over. The\n"
                         + "right half consists of the glass tube emptying out over a\n"
                         + "drain in the counter. ";
        this.actDialog = "You have no idea what to do. Maybe there's something in here to help.";
        this.searchDialog = "This giant thing is alien to you, yet nothing seems\n"
                          + "out of the ordinary.";
        this.useDialog = this.actDialog;

        this.addNameKeys("(?:complicated )?(?:alchemical )?contraption", "glass tubes");
        this.addActKeys("use");
        this.addUseKeys("beaker", "florence flask");
    }
    // ======================================================================== 
}


