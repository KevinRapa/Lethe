package Study;

import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Stud_Couch extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Couch() {
        super();

        this.description = "A purple gothic-era couch. It looks way more fancy "
                         + "than comfortable.";
        this.searchDialog = "You look underneath.";
        this.actDialog = "You relax on the couch for a moment, staring at the "
                       + "portrait resembling Bob Gunton. It looks a bit crooked.";
        this.addActKeys(SITPATTERN);
        this.addNameKeys("couch", "sofa");
    }
/*----------------------------------------------------------------------------*/
}
