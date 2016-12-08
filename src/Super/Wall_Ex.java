package Super;

public class Wall_Ex extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wall_Ex(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "A fortress-like granite brick wall.";
        this.searchDialog = "The walls here are solid and couldn't hide anything.";
        this.addNameKeys("wall", "walls");
    }
/*----------------------------------------------------------------------------*/
}
