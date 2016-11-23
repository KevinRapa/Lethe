package Gallery;

import Super.Furniture;

public class Gal4_Lft extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal4_Lft(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "At the third floor level on the west side of the\n"
                         + "central chamber, you see an adjoining room\n"
                         + "overlooking the whole gallery.";
        this.searchDialog = "The loft is way up there!";
        this.addNameKeys("loft");
    }
/*----------------------------------------------------------------------------*/
}
