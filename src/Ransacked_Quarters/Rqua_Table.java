package Ransacked_Quarters;

import A_Super.Moveable;
import A_Super.SearchableFurniture;
        
public class Rqua_Table extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rqua_Table () {
        super();

        this.description = "The plain wood end table lies on its side.";
        this.actDialog = "The table has been fooled around with enough. Best leave it alone...";
        this.searchDialog = "Nothing here. It's a bad place to hide something, "
                          + "as someone has already searched it.";
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:plain )?(?:wood(?:en)? )?(?:end )?table");
    }
//-----------------------------------------------------------------------------
}
