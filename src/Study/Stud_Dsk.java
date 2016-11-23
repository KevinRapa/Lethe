package Study;

import Super.Furniture;
import Super.Item;
        
public class Stud_Dsk extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Dsk(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "A fancy desk with curved legs. Its glossy surface\n"
                         + "reflects the glow of the fireplace.\n";
        this.searchDialog = "You slide open the drawer and peer inside.";
        this.interactDialog = "You give the desk a small kick. Though creaky and\n" +
                      "old, it's a good desk. Perhaps if you weren't trapped\n" +
                      "here, you'd take it home with you.";
        this.addNameKeys("desk", "fancy desk");
    }
/*----------------------------------------------------------------------------*/
}
