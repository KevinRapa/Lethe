package Tool_Closet;

import Super.Furniture;

public class Gqua_Clng extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Clng(String NAME) {
        super();
        this.searchable = false;
        this.description = "It's a low arched cobblestone ceiling.";
        this.searchDialog = "There's nothing here.";
        this.addNameKeys("ceiling", "arched ceiling");
        this.addActKeys("touch", "poke");
    }
}
