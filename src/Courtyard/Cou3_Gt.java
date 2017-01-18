package Courtyard;

import A_Main.NameConstants;
import A_Super.Furniture;
/**
 * The castle's front gate.
 * 
 * @author Kevin Rapa
 */
public class Cou3_Gt extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou3_Gt() {
        super();
        this.searchable = false;
        this.useDialog = "Not even with your exceptional stamina could you drill a hole through this gate with that.";
        this.description = "The monstrous two-story solid oak gate traps you\n"
                         + "inside.";
        this.actDialog = "It's huge. Even if it were unlocked, you wouldn't be able\n"
                    + "to budge it alone.";
        
        this.addUseKeys(NameConstants.HAND_DRILL);
        this.addActKeys("open", "use");
        this.addNameKeys("(?:monstrous )?(?:two-story )?(?:solid )?(?:oak )?(?:main |front )?gate");
    }
/*----------------------------------------------------------------------------*/
}
