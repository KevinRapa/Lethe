package Secret_Archives;

import Super.Furniture;
        
public class Lib1_Mrrr extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Mrrr(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The round mirror on the ceiling is angled such that\n"
                         + "the light reflects onto the desk. Ingenuous.";
        this.addNameKeys("mirror", "ceiling mirror");
    }
/*----------------------------------------------------------------------------*/
}
