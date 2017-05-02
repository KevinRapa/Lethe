package Forest;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class For_Trees extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public For_Trees () {
        super();
        
        this.description = "Glorious, majestic trees are scattered all over. "
                + "As much as you wish to coninually admire, you cannot draw "
                + "your attention from the castle back north.";
        this.actDialog = "There is nothing up there. There is just really nothing "
                + "up there.";
        this.searchDialog = "You find exactly nothing. Let us stroll back to the "
                + "the castle now.";

        this.addNameKeys("trees?");
        this.addActKeys("climb");
    }
    //-------------------------------------------------------------------------
}


