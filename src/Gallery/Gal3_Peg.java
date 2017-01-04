package Gallery;

import A_Super.Furniture;

public class Gal3_Peg extends Furniture{
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Peg(Furniture gal3Ttm) {
        super();
        this.REF = gal3Ttm;
        this.searchable = false;
        this.description = "The pegs stick out the sides of each segment.\n"
                         + "Interesting- there is a seam between the segments.";
        this.addActKeys("push", "turn", "pull", "rotate", "spin", "move");
        this.addNameKeys("pegs?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        return REF.interact(key);
    }
/*----------------------------------------------------------------------------*/
}
