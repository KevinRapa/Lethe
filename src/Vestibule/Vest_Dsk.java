package Vestibule;

import Super.Furniture;
import Super.Item;
        
public class Vest_Dsk extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Dsk(Item... items) {
        super(items);
        this.description = "A tenuous wooden desk, resting flush against a\n" +
                           "a dark corner. It collects dust from a lack of use.\n" +
                           "A single drawer is visible under its surface.";
        this.searchDialog = "You slide open the drawer and peer inside.";
        this.interactDialog = "You give the desk a small kick. Though creaky and\n" +
                      "old, it's a good desk. Perhaps if you weren't trapped\n" +
                      "here, you'd take it home with you.";
        this.addNameKeys("desk");
        this.addActKeys("kick");
    }
/*----------------------------------------------------------------------------*/
}
