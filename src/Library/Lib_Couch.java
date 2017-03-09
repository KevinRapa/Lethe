package Library;

import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Lib_Couch extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_Couch() {
        super();

        this.description = "A red gothic-era couch. It looks way more fancy\n"
                         + "than comfortable. Its frame is a glorious rosewood.";
        this.searchDialog = "You look underneath the couch.";
        this.actDialog = "You relax on the couch for a moment. You feel like your\n"
                    + "IQ has just risen a couple points.";
        this.addNameKeys("(?:red )?(?:gothic-era )?(?:couch|sofa)");
        this.addActKeys(SITPATTERN);
    }
/*----------------------------------------------------------------------------*/
}