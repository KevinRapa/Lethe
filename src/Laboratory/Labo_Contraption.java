package Laboratory;

import static A_Main.Names.BEAKER;
import static A_Main.Names.FLORENCE_FLASK;
import A_Super.Furniture;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Labo_Contraption extends Furniture implements Moveable {
    // ========================================================================
    public Labo_Contraption () {
        super();

        this.description = "The large contraption seems to be composed of two parts. "
                         + "The left half has a bunsen burner under a rack for a flask. "
                         + "Above it is an inch-wide glass tube bridging over. The "
                         + "right half consists of the glass tube emptying out over a "
                         + "drain in the counter. There's a switch connected to a stopcock on the tube.";
        this.actDialog = "You have no idea what to do. Maybe there's something in here to help.";
        this.searchDialog = "This giant thing is alien to you, yet nothing seems "
                          + "out of the ordinary.";
        this.useDialog = this.actDialog;

        this.addNameKeys("(?:complicated )?(?:alchemical )?contraption");
        this.addActKeys("use");
        this.addUseKeys(BEAKER, FLORENCE_FLASK);
    }
    // ======================================================================== 
    @Override public String moveIt() {
        return "The contraption looks pretty fragile. You think it best to leave it where it is.";
    }
    // ========================================================================
}


