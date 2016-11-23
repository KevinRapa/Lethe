package Study;

import Super.Furniture;

public class Stud_Cch extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Cch(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "A purple gothic-era couch. It looks way more fancy\n"
                         + "than comfortable.";
        this.searchDialog = "You look underneath, but find nothing.";
        this.interactDialog = "You relax on the couch for a moment, staring at the\n"
                    + "portrait resembling Bob Gunton. It looks a bit crooked.";
        this.addActKeys("sit", "relax", "lay");
        this.addNameKeys("couch", "sofa");
    }
/*----------------------------------------------------------------------------*/
}
