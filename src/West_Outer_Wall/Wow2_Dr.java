package West_Outer_Wall;

import Super.Door;

public class Wow2_Dr extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Wow2_Dr () {
        super();
        this.description = "To your east, you inspect the door. It's in horrible\n"
                         + "condition. It's boarded shut, and numerous gashes and\n"
                         + "splinters cover it. A hole in the door is big enough\n"
                         + "to see through.";
        this.interactDialog = "Not even someone as burly as yourself could pull these\n"
                            + "boards off.";
    }
}