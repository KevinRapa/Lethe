package Observatory;

import A_Super.Static_Wndw;

public class Obs_Wndw extends Static_Wndw {
    public Obs_Wndw() {
        super();
        this.description = "Through the huge window, you can see a cliff far to the\n"
                         + "south rolling into the western fog. Farther away, you can\n"
                         + "see a lighthouse at the cliff's edge overlooking the sea.";
        this.actDialog = "This window has no moving parts.";
        this.addNameKeys("paned window", "three story window");
    }
}

