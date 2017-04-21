package Cellar;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cel6_Lights extends Furniture {

    //-------------------------------------------------------------------------
    public Cel6_Lights () {
        super();
        
        this.description = "You cannot gauge their distance from you. A rough "
                + "guess would be about 100 feet. They flicker, and appear "
                + "to rest on a wall.";
        this.actDialog = searchDialog = 
                useDialog = "They are unreachable from here.";

        this.addNameKeys("lights?");
        this.addActKeys(GETPATTERN);
    }
    //-------------------------------------------------------------------------   
}


