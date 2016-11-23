package Foyer;

import Super.Furniture;
import Super.Item;

public class Foy1_Tbl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Foy1_Tbl(String NAME, Item ... items) {
        super(NAME, items);
        this.description = "It's a long mahogany table. A respectable wood among\n"
                         + "lumberjacks, it's a durable and workable species. You\n"
                         + "nod your head in appreciation.";
        this.interactDialog = "You nudge the table. It stands firmly in place, without even\n"
                    + "letting a creak. 'What a magnificent table!' you think to\n"
                    + "yourself. You give it another knock, and to your delight,\n"
                    + "another solid woody *knock* caresses your ear.";
        this.addActKeys("kick", "nudge", "hit");
        this.addNameKeys("table", "wood table", "long table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        String mode = this.doesThisHaveIt("short letter") ? "You quickly scan the table. A piece of paper lays\n"
                                                    + "plainly on its surface." :
                                                      "You quickly scan the table.";
        return mode;
    }
/*----------------------------------------------------------------------------*/
}
