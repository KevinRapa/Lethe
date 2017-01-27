package Foyer;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Foy_Banister extends Furniture {
    // ========================================================================
    public Foy_Banister () {
        super();

        this.description = "It's a fat tan granite railing.";
        this.actDialog = "You grab hold of it, but there's no fear of falling\n"
                       + "over, right?";
        
        this.addActKeys("hold", "grab");
        this.addNameKeys("banister", "railing");
    }
    // ========================================================================   
}


