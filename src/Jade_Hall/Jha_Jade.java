package Jade_Hall;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Jha_Jade extends Furniture {
    // ========================================================================
    public Jha_Jade () {
        super();

        this.description = "The stone on the walls is smooth and polished. It's\n"
                         + "dark green with tenuous white veins seeping through it.";
        this.searchDialog = "It's just solid rock.";

        this.addNameKeys("jade", "stone", "marble");
    }
    // ========================================================================  
}


