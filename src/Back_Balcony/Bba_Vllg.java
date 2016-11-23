package Back_Balcony;

import Super.Furniture;

public class Bba_Vllg extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Vllg(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "You gaze at its still silhouette and tiny flickering\n" +
                           "lights. You calmly reminisce about your life in that\n" +
                           "village, wondering if you will ever return.";
        this.searchDialog = "Don't be silly.";
        this.interactDialog = "Do you really think you can do that?";
        this.addActKeys("visit", "return", "go");
        this.addNameKeys("village", "town");
    }
/*----------------------------------------------------------------------------*/
}