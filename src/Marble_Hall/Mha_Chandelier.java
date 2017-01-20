package Marble_Hall;

import A_Super.Furniture;

public class Mha_Chandelier extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Mha_Chandelier() {
        super();
        this.searchable = false;
        this.description = "The silver chandelier hangs many feet above you. Its\n" +
                           "intricacy gives it a classical feel, unlike the black\n" +
                           "iron one in the foyer. It holds many candles; at least\n" +
                           "twenty. 'Who keeps these lit?' You think to yourself.";
        this.searchDialog = "You are pretty sure you can't jump that high.";
        this.addNameKeys("(?:silver )?chandelier");
    }
/*----------------------------------------------------------------------------*/
}

