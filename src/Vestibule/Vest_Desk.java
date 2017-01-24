package Vestibule;

import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Vest_Desk extends SearchableFurniture implements Openable{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Desk(Item... items) {
        super(items);
        this.description = "A tenuous wooden desk, resting flush against a\n" +
                           "a dark corner. It collects dust from a lack of use.\n" +
                           "On it rests a strange, neglected glass orb.\n" +
                           "A single drawer is visible under its surface.";
        this.searchDialog = "You slide open the drawer and peer inside.";
        this.actDialog = "You give the desk a small kick. Though creaky and\n" +
                         "old, it's a good desk. Perhaps if you weren't trapped\n" +
                         "here, you'd take it home with you.";
        this.addNameKeys("(?:tenuous |dusty )?(?:wooden )?desk");
        this.addActKeys("kick");
    }
/*----------------------------------------------------------------------------*/
}
