package Parlor;

import A_Super.Furniture;

public class Par2_Bwl extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Par2_Bwl() {
            super();
            this.searchable = false;
            this.addUseKeys("polearm");
            this.addNameKeys("(?:hanging )?(?:steel )?bowl");

            this.description = "It's a steel bowl of fire hanging from the ceiling\n"
                             + "by a chain. A draft from the outside causes it to\n"
                             + "swing gently.";
            this.searchDialog = "It's on fire, so there's probably nothing in there.";
            this.useDialog = "You don't think that jabbing a burning bowl is a\n"
                           + "very good idea.";
    }
/*----------------------------------------------------------------------------*/    
}
