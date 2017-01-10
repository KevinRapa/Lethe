package Laboratory;

import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Dvcs extends Furniture {

    // ========================================================================
    public Labo_Dvcs (Item... items) {
        super(items);
        this.searchable = false;
        
        this.description = "You are overwhelmed with science. You have never been\n"
                         + "in a laboratory before. All you see are many colors,\n"
                         + "valves and pipes.";
        this.actDialog = "You have no idea what to do.";
        this.searchDialog = this.useDialog = this.actDialog;

        this.addNameKeys("(?:alchemical )?devices?");
        this.addUseKeys(".+");
        this.addActKeys(".+");
    }
    // ========================================================================  
}


