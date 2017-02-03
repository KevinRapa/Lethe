package West_Antechamber;

import A_Super.Furniture;

public class Want_Torches extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Torches() {
        super();

        this.description = "They're tall, standing torches. They are burning\n"
                         + "quite audibly and furiously.";
        this.actDialog = "These are not hand torches.";
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:standing )?torch(?:es)?");
    }
/*----------------------------------------------------------------------------*/
}
