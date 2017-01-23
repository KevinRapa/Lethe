package Library;

import A_Super.WallArt;
/**
 * @author Kevin Rapa
 */
public class Lib3_Painting extends WallArt {
    // ========================================================================
    public Lib3_Painting () {
        super();

        this.description = "A large portrait of a man hangs above the south\n"
                         + "bookshelf. It is decorated with a thick, expensive\n"
                         + "looking frame. The man is dressed in black robes,\n"
                         + "shiny leather shoes, and holds a silver scepter.\n"
                         + "He resembles the man from the portrait in the study...";
        this.actDialog = "The painting is too high up to do that.";
        this.searchDialog = this.actDialog;

        this.addNameKeys("(?:huge |large )?(?:painting|portrait)");
    }
    // ========================================================================     
}


