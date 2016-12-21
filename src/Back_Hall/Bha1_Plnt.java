package Back_Hall;

import Super.Furniture;
import Super.Item;

public class Bha1_Plnt extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Plnt(Item ... items) {
        super(items);
        this.searchable = false;
        this.description = "The plant doesn't seem to be in good shape. Though\n"
                         + "drooping a bit, it is still alive.";
        this.searchDialog = "You don't feel like getting dirt on your hands.";
        this.interactDialog = "You will need a bucket of water to do that.";
        this.useDialog = "You pour a bit of the water out and water the plant.\n"
                       + "You're sure the plant appreciated that.";
        this.addNameKeys("plant", "potted plants", "potted plant", "plants");
        this.addActKeys("water");
        this.addUseKeys("bucket of water");
    }
/*----------------------------------------------------------------------------*/
}
