package Vestibule;

import A_Super.Furniture;
import A_Super.Moveable;

public class Vest_Chair extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Chair() {
        super();

        this.description = "An ornate red velvet chair. Although a woodworker by " +
                           "trade, you have never been keen on upholstery.";
        this.searchDialog = "You look underneath, but find nothing.";
        this.actDialog = "You sit down in the chair, but not for long, " +
                      "for the chair is hard and uncomfortable.";
        this.addNameKeys("chairs?");
        this.addActKeys(SITPATTERN);
    }
//-----------------------------------------------------------------------------
}
