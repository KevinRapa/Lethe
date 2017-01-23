package Courtyard;

import A_Super.Furniture;
/**
 * The front gate of the castle, before it shuts behind the player.
 * @author Kevin Rapa
 */
public class Cou4_Gate extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Gate() {
        super();

        this.description = "It's a monstrous two-story solid oak gate.";
        this.actDialog = "It's open already.";
        this.addActKeys("open", "use");
        this.addNameKeys("(?:monstrous )?(?:two-story )?(?:solid )?(?:oak )?(?:main |front )?gate");
    }
/*----------------------------------------------------------------------------*/
}
