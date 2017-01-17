package Observatory;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Obs2_Lmp extends Furniture {
    // ========================================================================
    public Obs2_Lmp () {
        super();
        this.searchable = false;
        this.description = "The electric lamp looks like it's made of clay. It lights\n"
                         + "the chair's vicinity just enough in order to read\n"
                         + "comfortably.";
        this.addNameKeys("(?:electric )?(?:table )?(?:lamp|light)");
    }
    // ========================================================================     
}

