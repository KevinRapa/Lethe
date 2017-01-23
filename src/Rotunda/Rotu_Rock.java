package Rotunda;

import A_Super.Furniture;

public class Rotu_Rock extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Rock() {
        super();

        this.description = "It looks like marble. But where could one possibly\n"
                         + "accumulate all this marble from?.";
        this.searchDialog = "You are a lumberjack, not a miner.";
        this.addNameKeys("(?:polished )?(?:rock|marble)");
    }
/*----------------------------------------------------------------------------*/
}
