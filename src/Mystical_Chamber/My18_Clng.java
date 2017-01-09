package Mystical_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class My18_Clng extends Furniture {

    // ========================================================================
    public My18_Clng () {
        super();
        this.searchable = false;
        
        this.description = "It's a domed sandstone ceiling, only about 2 feet above your head.";

        this.addNameKeys("(?:domed )?(?:sandstone )?ceiling");
    }
    // ========================================================================  
}


