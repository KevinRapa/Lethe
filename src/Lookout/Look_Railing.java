package Lookout;

import A_Super.Furniture;

public class Look_Railing extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Railing() {
        super();
        
        this.description = "A wide, sturdy granite railing.";
        this.searchDialog = "You search around the railing.";
        this.actDialog = "You grab the railing, but there's no fear of falling over, right?";
        this.addNameKeys("(?:wide )?(?:sturdy )?(?:granite )?(?:balcony )?railing");
        this.addActKeys("use", "grab", "hold");
    }
/*----------------------------------------------------------------------------*/
}

