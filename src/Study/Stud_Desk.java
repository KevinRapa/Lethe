package Study;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;

public class Stud_Desk extends SearchableFurniture implements Openable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Desk(Item... items) {
        super(items);
        this.description = "A fancy desk with curved legs. Its glossy surface\n"
                         + "reflects the glow of the fireplace.\n";
        this.searchDialog = "You slide open the drawer and peer inside.";
        this.actDialog = "You give the desk a small kick. Though creaky and\n" +
                      "old, it's a good desk. Perhaps if you weren't trapped\n" +
                      "here, you'd take it home with you.";
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("desk", "fancy desk");
    }
/*----------------------------------------------------------------------------*/
}
