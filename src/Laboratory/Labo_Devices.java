package Laboratory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Labo_Devices extends Furniture {
    //-------------------------------------------------------------------------
    public Labo_Devices () {
        super();

        this.description = "You are overwhelmed with science. You have never been "
                         + "in a laboratory before. All you see are many colors, "
                         + "valves and pipes.";
        this.actDialog = "You have no idea what to do.";
        this.searchDialog = this.useDialog = this.actDialog;

        this.addNameKeys("(?:alchemical )?devices?");
        this.addUseKeys(ANYTHING);
        this.addActKeys(ANYTHING);
    }
    //-------------------------------------------------------------------------  
}


