package Secret_Stairs;

import A_Super.Static_Wndw;
/**
 * @author Kevin Rapa
 */
public class Sst_Wndw extends Static_Wndw {
/*----------------------------------------------------------------------------*/
    public Sst_Wndw() {
        super();
        this.description = "The circular vented window lets in a small amount of\n"
                         + "light.";
        this.actDialog = "You can't reach the window from here.";
        this.addNameKeys("light", "(?:circular )?(?:vented )?window");
    }
/*----------------------------------------------------------------------------*/
}



