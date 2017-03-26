package West_Antechamber;

import A_Super.Furniture;

public class Want_Torches extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Torches() {
        super();

        this.description = "Tall tan obelisks standing in the corners of the room "
                         + "support metal baskets of burning wood chunks. They "
                         + "are burning quite audibly and furiously.";
        this.actDialog = "These are large standing torches, and much too heavy "
                       + "for you to just take and carry around. Find one on a "
                       + "wall somewhere.";
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:standing )?torch(?:es)?", "(?:metal )?baskets", 
                "(?:burning )?(?:wood(?:en)? )?chunks");
    }
/*----------------------------------------------------------------------------*/
}
