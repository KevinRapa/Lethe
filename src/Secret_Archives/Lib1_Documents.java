package Secret_Archives;

import A_Super.Furniture;

public class Lib1_Documents extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Documents() {
        super();
        this.searchable = false;
        this.description = "Various papers and scrolls litter the surfaces and\n"
                         + "shelves of the room.";
        this.actDialog = "It would take at least a year to read all of these!";
        this.searchDialog = "There are simply too many to search them all.\n";
        this.addNameKeys("documents", "scrolls", "papers");
        this.addActKeys("read");
    }
/*----------------------------------------------------------------------------*/
}
