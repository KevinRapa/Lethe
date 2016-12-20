package Super;

public class Floor extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Floor(String dsc, Item... items) {
            super(items);
            this.description = dsc;
            this.searchDialog = "You crouch down and scan the ground.";
            this.addNameKeys("floor", "ground", "walkway");
    }
/*----------------------------------------------------------------------------*/
}
