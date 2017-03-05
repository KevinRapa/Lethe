package Vestibule;

import A_Super.Furniture;

public class Vest_Chair extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Chair() {
        super();

        this.description = "An ornate red velvet chair. Being a woodworker by\n" +
                           "trade, you have never been keen on upholstery.";
        this.searchDialog = "You look underneath, but find nothing.";
        this.actDialog = "You sit down in the chair, but not for long,\n" +
                      "for the chair is hard and uncomfortable.";
        this.addNameKeys("chairs?");
        this.addActKeys(SITPATTERN);
    }
/*----------------------------------------------------------------------------*/
}
