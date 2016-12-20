package Secret_Archives;

import Super.Furniture;
        
public class Lib1_Lght extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Lght() {
        super();
        this.searchable = false;
        this.description = "The beam of light is emitting out the top of the\n"
                         + "artifact.";
        this.addNameKeys("light", "beam of");
    }
/*----------------------------------------------------------------------------*/
}
