package Back_Hall;

import static A_Main.NameConstants.BUCKET_OF_WATER;
import A_Super.Furniture;
import A_Super.Item;

public class Bha1_Plnt extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bha1_Plnt(Item ... items) {
        super(items);
        this.searchable = false;
        this.description = "The plant doesn't seem to be in good shape. Though\n"
                         + "drooping a bit, it is still alive.";
        this.searchDialog = "You don't feel like getting dirt on your hands.";
        this.actDialog = "You will need a bucket of water to do that.";
        this.useDialog = "You pour a bit of the water out and water the plant.\n"
                       + "You're sure the plant appreciated that.";
        this.addNameKeys("(?:potted )?plants?");
        this.addActKeys("water");
        this.addUseKeys(BUCKET_OF_WATER);
    }
/*----------------------------------------------------------------------------*/
}
