package Marble_Hall;

import A_Super.Furniture;

public class Mha_Chandelier extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha_Chandelier() {
        super();

        this.description = "The silver chandelier hangs many feet above you. Its " +
                           "intricacy gives it a classical feel, unlike the black " +
                           "iron one in the foyer. It holds many candles; at least " +
                           "twenty. 'Who keeps these lit?' You think to yourself.";
        this.searchDialog = "You are pretty sure you can't jump that high.";
        this.actDialog = "How would you even get up there to do that??";
        
        this.addActKeys("hang", "swing");
        this.addNameKeys("(?:silver )?(?:chandelier|light)");
    }
//-----------------------------------------------------------------------------
}

