package Iron_Hall;

import Super.Furniture;

public class Iha2_Bwl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Iha2_Bwl(String NAME) {
            super(NAME);
            this.searchable = false;
            this.addUseKeys("polearm");
            this.addNameKeys("bowl", "steel bowl", "hanging bowl", "burning bowl");

            this.description = "It's a steel bowl of fire hanging from the ceiling\n"
                             + "by a chain. It burns steadily, lighting your end of\n"
                             + "the hallway. A draft from the outside causes it to\n"
                             + "swing gently.";
            this.searchDialog = "It's on fire, so there's probably nothing in there.";
            this.useDialog = "You don't think that jabbing a burning bowl is a\n"
                           + "very good idea.";
    }
/*----------------------------------------------------------------------------*/    
}
