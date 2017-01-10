package A_Super;

public class Wall extends Furniture{
/*----------------------------------------------------------------------------*/    
    public Wall(String dsc) {
        super();
        this.searchable = false;
        this.description = dsc;
        this.actDialog = "What do expect to find? A porkchop?";
        this.searchDialog = "The walls here are solid and couldn't hide anything.";
        this.addActKeys("break");
        this.addNameKeys("walls?");
    }
/*----------------------------------------------------------------------------*/
}