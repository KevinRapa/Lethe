package Gallery;

import A_Super.Furniture;

public class Gal3_Peg extends Furniture {
    private final Furniture GAL3_TTM;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Peg(Furniture gal3Ttm) {
        super();
        this.GAL3_TTM = gal3Ttm;
        this.description = "The pegs stick out the sides of each segment.\n"
                         + "Interesting- there is a seam between the segments.";
        this.addActKeys("turn", MOVEPATTERN);
        this.addNameKeys("pegs?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        return GAL3_TTM.interact(key);
    }
/*----------------------------------------------------------------------------*/
}
