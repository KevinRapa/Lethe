package Super;

public class Wall extends Furniture{
    
    public Wall(String NAME, String dsc) {
        super(NAME);
        this.searchable = false;
        this.description = dsc;
        this.searchDialog = "The walls here are solid and couldn't hide anything.";
        this.addNameKeys("wall", "walls");
    }
}