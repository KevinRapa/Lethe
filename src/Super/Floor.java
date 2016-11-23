package Super;

public class Floor extends Furniture{

/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Floor(String name, String dsc, Item ... items) {
            super(name, items);
            this.description = dsc;
            this.searchDialog = "You crouch down and scan the " + this.NAME + ".";
            this.addNameKeys("floor", "ground", "walkway");
    }
/*----------------------------------------------------------------------------*/
}
