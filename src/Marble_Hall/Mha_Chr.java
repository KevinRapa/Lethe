package Marble_Hall;

import Super.Furniture;

public class Mha_Chr extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Chr(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "The chair's frame is glorious rosewood. What you\n"
                         + "wouldn't give to chop down a towering Dalbergia.\n"
                         + "Its cushioning is a dark green diamond pattern\n"
                         + "which you don't care for.";
        this.searchDialog = "You look underneath but find nothing.";
        this.interactDialog = "You sit down in the chair, noting its marvelous polish.";
        this.addNameKeys("chair", "chairs");
        this.addActKeys("sit", "relax", "use");
    }
/*----------------------------------------------------------------------------*/
}
