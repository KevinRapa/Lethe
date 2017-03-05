package Lookout;

import A_Super.Railing;

public class Look_Railing extends Railing {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Railing() {
        super();
        
        this.description = "A wide, sturdy granite railing.";
        this.addNameKeys("(?:wide )?(?:sturdy )?(?:granite )?(?:balcony )?railing");
    }
/*----------------------------------------------------------------------------*/
}

