package Observatory;

import A_Super.Furniture;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Obs2_Lamp extends Furniture implements Moveable {
    // ========================================================================
    public Obs2_Lamp () {
        super();

        this.description = "The electric lamp looks like it's made of clay. It lights\n"
                         + "the chair's vicinity just enough in order to read\n"
                         + "comfortably.";
        this.addNameKeys("(?:electric )?(?:table )?(?:lamp|light)");
    }
    // ========================================================================     
}


