package Back_Balcony;

import A_Super.Item;
import A_Super.SearchableFurniture;
/**
 * @author Kevin Rapa
 */
public class Bba_Bench extends SearchableFurniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Bench(Item... items) {
        super(items);
        this.description = "It's a stone bench with carvings of birds\n"
                         + "around the edge. ";
        this.searchDialog = "You look on the bench.";
        this.actDialog = "You sit down for a moment and let the salty\n"
                            + "breeze hit your face.";
        this.addActKeys("sit", "use", "relax");
        this.addNameKeys("(?:stone )?bench");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return this.containsItem("note from a visitor") ? 
                this.description + "A note is laying on its surface." : 
                this.description;
    }
/*----------------------------------------------------------------------------*/
}
