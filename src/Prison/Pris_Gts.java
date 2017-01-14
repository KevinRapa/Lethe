package Prison;

import A_Super.Furniture;
import A_Super.Openable;
/**
 * @author Kevin Rapa
 */
public class Pris_Gts extends Furniture implements Openable {

    // ========================================================================
    public Pris_Gts () {
        super();
        this.searchable = false;
        
        this.searchDialog = "The gate is locked.";
        this.description = "Each cell is locked with an iron gate.";

        this.addNameKeys("(?:iron )?gates?");
    }
    // ========================================================================    
}


