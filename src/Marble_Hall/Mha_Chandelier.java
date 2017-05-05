package Marble_Hall;

import A_Super.Chandelier;

public class Mha_Chandelier extends Chandelier {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha_Chandelier() {
        super();

        this.description = 
                "The silver chandelier hangs many feet above you. Its " +
                "intricacy gives it a classical feel, unlike the black " +
                "iron one in the foyer. It holds many candles; at least " +
                "twenty. 'Who keeps these lit?' You think to yourself.";
        
        this.addNameKeys("(?:silver )?(?:chandelier|light)");
    }
//-----------------------------------------------------------------------------
}

