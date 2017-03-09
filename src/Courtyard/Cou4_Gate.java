package Courtyard;

import A_Super.Furniture;
import A_Super.Heavy;
/**
 * The front gate of the castle, before it shuts behind the player.
 * @author Kevin Rapa
 */
public class Cou4_Gate extends Furniture implements Heavy {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou4_Gate() {
        super();

        this.description = "It's a monstrous two-story solid oak gate.";
        this.actDialog = "It's open already.";
        this.addActKeys("open", "use", "knock", "close", "shut");
        this.addNameKeys("(?:monstrous )?(?:two-story )?(?:solid )?(?:oak )?(?:main |front )?gate");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {              
        if (key.matches("close|shut"))
            return "It's way too big to close by hand!";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
