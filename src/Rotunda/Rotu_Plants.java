package Rotunda;

import A_Super.Furniture;

public class Rotu_Plants extends Furniture{
    private final Rotu_Fountain REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Plants(Furniture fntn) {
        super();
        this.REF = (Rotu_Fountain)fntn;
        this.searchable = false;
        this.description = "The plants don't seem to be in good shape. They\n"
                         + "droop and some are crowded with weeds.";
        this.searchDialog = "You don't feel like getting dirt on your hands.";
        this.actDialog = "Scooping up some of the brown water, you water the plants,\n"
                    + "hoping that maybe they'll spring back to life.";
        this.addNameKeys("(?:potted )?plants?");
        this.addActKeys("water");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (REF.isDrained())
            return "There's no more water in this room.";
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}