package Closet;

import A_Super.Furniture;
import A_Super.Moveable;
/**
 * @author Kevin Rapa
 */
public class Gqua_Stool extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Stool() {
        super();
        this.description = "It's a puny three-legged stool.";
        this.actDialog = "You sit in the tiny stool, feeling even more "
                       + "insecure about your mass.";
        this.addNameKeys("(?:puny |tiny )?(?:three-legged )?stool");
        this.addActKeys(SITPATTERN);
    }
//-----------------------------------------------------------------------------
}
