package Tunnels;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sew15_Gate extends Furniture {
    //-------------------------------------------------------------------------
    public Sew15_Gate () {
        super();

        this.description = "Passed the iron gate, you can see the tunnel leading " +
                           "further down into darkness. The iron bars extend down " +
                           "into the water where they form a grate of sorts, you " +
                           "suppose to prevent things from... escaping unwantedly.";
        this.actDialog = "You can't get the gate open. It's locked.";
        this.searchDialog = "They're just iron bars.";

        this.addNameKeys("(?:iron )?(?:barred )?(?:gate|grate)");
        this.addActKeys("open", "close");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.equals("open"))
            return this.actDialog;
        else
            return "The gate is already closed...";
    }
    //-------------------------------------------------------------------------     
}


