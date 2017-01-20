package Chapel_Stairs;

import A_Super.StaticWndw;
/**
 * @author Kevin Rapa
 */
public class Chs_Windows extends StaticWndw {
/*----------------------------------------------------------------------------*/
    public Chs_Windows(String NAME) {
        super();
        this.escapeDialog = "You could probably use your weight to break through... but aren't too keen on the idea.";
        this.actDialog = "These stained glass windows aren't designed that way.";
        this.description = "The stained glass windows line the outer wall of the\n"
                         + "tower and follow the white spiral stairs. The moonlight\n"
                         + "penetrates their many colors and projects a dim array of\n"
                         + "hues against the inner tower wall.";
        this.addNameKeys("stained glass windows?");
    }
/*----------------------------------------------------------------------------*/
}
