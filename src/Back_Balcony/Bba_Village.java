package Back_Balcony;

import A_Super.Furniture;

public class Bba_Village extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Village() {
        super();
        this.description = "You gaze at its still silhouette and tiny flickering " +
                           "lights. You calmly reminisce about your life in that " +
                           "village, wondering if you will ever return.";
        this.searchDialog = "Don't be silly.";
        this.actDialog = "Do you really think you can do that?";
        this.addActKeys("visit", "return", "go");
        this.addNameKeys("village", "town");
    }
//-----------------------------------------------------------------------------
}