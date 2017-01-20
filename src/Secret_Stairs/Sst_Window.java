package Secret_Stairs;

import A_Super.StaticWndw;
/**
 * @author Kevin Rapa
 */
public class Sst_Window extends StaticWndw {
/*----------------------------------------------------------------------------*/
    public Sst_Window() {
        super();
        this.description = "The circular vented window lets in a small amount of\n"
                         + "moonlight.";
        this.actDialog = "You can't reach the window from here.";
        this.addNameKeys("light", "(?:circular )?(?:vented )?window");
    }
/*----------------------------------------------------------------------------*/
}



