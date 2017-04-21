package Marble_Hall;

import A_Super.Furniture;
import A_Super.Moveable;

public class Mha_Chair extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Mha_Chair() {
        super();

        this.description = "The chair's frame is glorious rosewood. What you "
                         + "wouldn't give to chop down a towering Dalbergia. "
                         + "Its cushioning is a dark green diamond pattern "
                         + "which you don't care for.";
        this.searchDialog = "You look underneath but find nothing.";
        this.actDialog = "You sit down in the chair, noting its marvelous polish.";
        this.addNameKeys("(?:rosewood )?chairs?");
        this.addActKeys(SITPATTERN);
    }
//-----------------------------------------------------------------------------
}
