package Super;

public class Button extends Furniture {
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Button(String NAME) {
        super(NAME);
        this.searchable = false;
        this.searchDialog = "There's a sword here! No not really, just a button.";
        this.addActKeys("push", "hit", "activate");
        this.addNameKeys("button"); 
    }
/*----------------------------------------------------------------------------*/   
}
