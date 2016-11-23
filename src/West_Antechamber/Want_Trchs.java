package West_Antechamber;

import Super.Furniture;

public class Want_Trchs extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Trchs(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "They're tall, standing torches. They are burning\n"
                         + "quite audibly and furiously.";
        this.searchDialog = "You can't seem to find anything.";
        this.interactDialog = "This is not a hand torch.";
        this.addActKeys("grab", "hold");
        this.addNameKeys("torches", "torch", "standing torch");
    }
/*----------------------------------------------------------------------------*/
}
