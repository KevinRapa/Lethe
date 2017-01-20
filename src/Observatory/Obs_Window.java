package Observatory;

import A_Super.StaticWndw;

public class Obs_Window extends StaticWndw {
/*----------------------------------------------------------------------------*/
    public Obs_Window() {
        super();
        this.escapeDialog = "You could probably use your weight to break through... but aren't too keen on the idea.";
        this.description = "Through the huge window, you can see a cliff far to the\n"
                         + "south rolling into the western fog. Farther away, you can\n"
                         + "see a lighthouse at the cliff's edge overlooking the sea.";
        this.addNameKeys("(?:three story )?(?:paned )?window");
    }
/*----------------------------------------------------------------------------*/
}

