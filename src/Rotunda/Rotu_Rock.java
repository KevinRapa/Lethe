package Rotunda;

import Super.Furniture;

public class Rotu_Rock extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Rock(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It looks like marble. But where could one possibly\n"
                         + "accumulate all this marble from?.";
        this.searchDialog = "You are a lumberjack, not a miner.";
        this.addNameKeys("rock", "polished rock");
    }
/*----------------------------------------------------------------------------*/
}
