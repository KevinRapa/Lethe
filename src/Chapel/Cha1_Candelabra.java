package Chapel;

import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cha1_Candelabra extends Furniture {
    // ========================================================================
    public Cha1_Candelabra () {
        super();
        this.searchable = false;
        
        this.description = "The silver standing candelabras burn calmly and quietly.";
        this.useDialog = "They are already lit...";

        this.addNameKeys("(?:silver )?(?:standing )?(?:lit )?candelabras?");
        this.addUseKeys(HAND_TORCH);
    }
    // ======================================================================== 
}


