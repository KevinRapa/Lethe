package Gallery;

import A_Super.Furniture;

public class Gal3_Segment extends Furniture{
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Segment(Furniture gal3Ttm) {
        super();
        this.REF = gal3Ttm;
        this.searchDialog = "The segments aren't hiding any items. You "
                          + "notice a seam between each.";
        this.description = "The faces on each segment are surreal and spooky. "
                         + "Seams separate the four of them slightly.";
        this.addActKeys(VALVEPATTERN, "pull", "move");
        this.addNameKeys("segments?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        return REF.interact(key);
    }
/*----------------------------------------------------------------------------*/
}
