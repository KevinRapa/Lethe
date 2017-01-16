package Soul_Chamber;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Soul_Pl extends Furniture {
    // ========================================================================
    public Soul_Pl () {
        super();
        this.searchable = false;
        
        this.description = "The pool of aether swirls with white... stuff, and\n"
                         + "gently bubbles infrequently. The blue liquid inside\n"
                         + "is opaque, but can't be more than a couple feet deep.";
        this.actDialog = "You leap into the pool and die. The end. No, not really.";
        this.searchDialog = "You just find a bunch of aether.";

        this.addNameKeys("pool", "pool of aether", "aether pool");
        this.addActKeys("swim");
    }
    // ========================================================================     
}


