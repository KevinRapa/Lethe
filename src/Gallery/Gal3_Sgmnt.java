package Gallery;

import Super.Furniture;
import Super.Room;

public class Gal3_Sgmnt extends Furniture{
    private final Furniture REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Sgmnt(Furniture gal3Ttm) {
        super();
        this.REF = gal3Ttm;
        this.searchable = false;
        this.searchDialog = "The segments aren't hiding any items. But you\n"
                          + "notice a seam between each.";
        this.description = "The faces on each segment are surreal and spooky.\n "
                         + "Seams separate the four of them slightly.";
        this.addActKeys("turn", "pull", "rotate", "spin", "move");
        this.addNameKeys("segment", "segments");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {
        String rep = REF.interact(map, key);
        
        return rep;
    }
}
