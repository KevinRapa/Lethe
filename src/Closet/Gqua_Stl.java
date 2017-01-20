package Closet;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Gqua_Stl extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gqua_Stl() {
        super();
        this.searchable = false;
        this.description = "It's a puny three-legged stool.";
        this.searchDialog = "There's nothing here.";
        this.actDialog = "You sit in the tiny stool. It makes you feel even more\n"
                    + "insecure about your weight.";
        this.addNameKeys("(?:puny |tiny )?(?:three-legged )?stool");
        this.addActKeys("sit", "relax");
    }
/*----------------------------------------------------------------------------*/
}
