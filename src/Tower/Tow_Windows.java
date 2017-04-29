package Tower;

import A_Super.Window;
/**
 * @author Kevin Rapa
 */
public class Tow_Windows extends Window {
    //-------------------------------------------------------------------------
    public Tow_Windows () {
        super();

        this.descOpen = this.descClosed = "From the wide paned windows, you can "
                + "see far over and beyond the castle. The forest is much bigger "
                + "than you imagined, and the amount "
                + "of effort to trek here was far more than the amount "
                + "you would ever naturally commit.";

        this.addNameKeys("(?:wide )?(?:paned )?windows?");
    }
    //-------------------------------------------------------------------------    
}


