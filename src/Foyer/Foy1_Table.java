package Foyer;

import A_Super.Item;
import A_Super.Moveable;
import A_Super.SearchableFurniture;

public class Foy1_Table extends SearchableFurniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy1_Table(Item... items) {
        super(items);
        
        this.description = "It's a long mahogany table. A respectable wood among "
                         + "lumberjacks, it's a durable and workable species. You "
                         + "nod your head in appreciation.";
        this.actDialog = "You nudge the table. It stands firmly in place, without even "
                       + "letting a creak. 'What a magnificent table!' you think to "
                       + "yourself. You give it another knock, and to your delight, "
                       + "another solid woody *knock* caresses your ear.";
        this.searchDialog = "You quickly scan the table."; 
        
        this.addActKeys(JOSTLEPATTERN);
        this.addNameKeys("(?:long )?(?:mahogany |wood(?:en)? )?table");
    }
//-----------------------------------------------------------------------------
}
