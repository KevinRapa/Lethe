package West_Antechamber;

import A_Super.Furniture;

public class Want_Torches extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Torches() {
        super();

        this.description = "They're tall, standing torches. They are burning\n"
                         + "quite audibly and furiously.";
        this.searchDialog = "You can't seem to find anything.";
        this.actDialog = "This is not a hand torch.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("(?:standing )?torch(?:es)?");
    }
/*----------------------------------------------------------------------------*/
}
