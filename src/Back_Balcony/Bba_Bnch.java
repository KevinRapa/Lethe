package Back_Balcony;

import A_Super.Furniture;
import A_Super.Item;

public class Bba_Bnch extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Bnch(Item... items) {
        super(items);
        this.description = "It's a stone bench with carvings of birds\n"
                         + "around the edge. ";
        this.searchDialog = "You look on the bench.";
        this.actDialog = "You sit down for a moment and let the salty\n"
                            + "breeze hit your face.";
        this.addActKeys("sit", "use", "relax");
        this.addNameKeys("bench", "stone bench");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return this.doesThisHaveIt("note from a visitor") ? 
                this.description + "A note is laying on its surface." : 
                this.description;
    }
/*----------------------------------------------------------------------------*/
}
