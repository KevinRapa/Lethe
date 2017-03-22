package Secret_Archives;

import static A_Main.Names.HAND_TORCH;
import A_Super.Furniture;

public class Lib1_Documents extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Documents() {
        super();

        this.description = "Various papers and scrolls litter the surfaces and\n"
                         + "shelves of the room.";
        this.actDialog = "It would take at least a year to read all of these!";
        this.searchDialog = "There are simply too many to search them all at once.";
        this.useDialog = "Yes... burn it... burn it all to the ground... ";
        
        this.addUseKeys(HAND_TORCH);
        this.addNameKeys("documents?", "scrolls?", "papers?");
        this.addActKeys("read");
    }
/*----------------------------------------------------------------------------*/
}
