package Cellar;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cel6_Platform extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Cel6_Platform () {
        super();
        
        this.description = 
                "The mesh iron platform you stand on hangs from "
                + "four poles connected to the ceiling. Surrounding "
                + "you is just a black void except for the glow of "
                + "what appear to be torches far below.";
        this.actDialog = "That cannot possibly be a safe thing to do right now.";
        
        this.addActKeys("break|destroy", "jump");
        this.addNameKeys("(?:metal )?(?:iron )?(?:bars|railing|platform)");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {
        if (key.equals("jump"))
            return "What an adventurous way to commit suicide...";
        else
            return this.actDialog;
    }
    //-------------------------------------------------------------------------   
}


