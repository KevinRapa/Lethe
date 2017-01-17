package Prison;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Pris_Cndlbr extends Furniture {
    // ========================================================================
    public Pris_Cndlbr () {
        super();
        this.searchable = false;
        
        this.description = "Scattered around the prison are several standing\n"
                         + "candelabras. Each one is rusted, the candles are\n"
                         + "heavily melted, and dried wax is seen dirtying\n"
                         + "every light. Still, the candles continue to burn.";
        this.actDialog = "The last thing you need right now is a burnt hand!";

        this.addNameKeys("(?:rusted )?(?:standing )?(?:candelabras?|lights?)", 
                "(?:melt(?:ed|ing))?candles");
        this.addActKeys("touch", "grab", "hold");
    }
    // ======================================================================== 
}


