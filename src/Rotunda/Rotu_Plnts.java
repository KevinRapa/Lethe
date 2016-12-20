package Rotunda;

import Super.Furniture;
import Super.Room;

public class Rotu_Plnts extends Furniture{
    private final Rotu_Fntn REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu_Plnts(Furniture fntn) {
        super();
        this.REF = (Rotu_Fntn)fntn;
        this.searchable = false;
        this.description = "The plants don't seem to be in good shape. They\n"
                         + "droop and some are crowded with weeds.";
        this.searchDialog = "You don't feel like getting dirt on your hands.";
        this.interactDialog = "Scooping up some of the brown water, you water the plants,\n"
                    + "hoping that maybe they'll spring back to life.";
        this.addNameKeys("plant", "potted plants", "potted plant", "plants");
        this.addActKeys("water");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {     
        String rep = this.interactDialog;
        if (REF.isDrained())
            rep = "There's no more water in this room.";
        return rep;
    }
/*----------------------------------------------------------------------------*/
}