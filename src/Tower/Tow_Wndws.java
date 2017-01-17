package Tower;

import A_Super.Window;
/**
 * @author Kevin Rapa
 */
public class Tow_Wndws extends Window {
    // ========================================================================
    public Tow_Wndws () {
        super();

        this.descOpen = this.descClosed = "From the wide paned windows, you can\n"
                + "see far over and beyond the castle. The forest is much bigger\n"
                + "than you imagined, and you now come to realize that the amount\n"
                + "of effort to trek here would had been far more than the amount\n"
                + "you would ever naturally commit.";

        this.addNameKeys("(?:wide )?(?:paned )?windows?");
    }
    // ========================================================================    
}


