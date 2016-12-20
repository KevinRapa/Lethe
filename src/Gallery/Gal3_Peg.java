package Gallery;

import Super.Furniture;
import Super.Room;

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
        this.addNameKeys("peg", "pegs");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        String rep = REF.interact(map, key);
        
        return rep;
    }
}
