package Foyer;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Foy_Banister extends Furniture {
    // ========================================================================
    public Foy_Banister () {
        super();
        this.searchable = false;
        
        this.description = "It's a fat tan granite railing.";

        this.addNameKeys("banister|railing");
    }
    // ========================================================================   
}


