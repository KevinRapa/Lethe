package Forest;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class For_Forest extends Furniture {

    // ========================================================================
    public For_Forest () {
        super();
        
        this.description = "The woods are dark and spooky. What did you expect?";
        this.searchDialog = this.actDialog = "Rest assured there is absolutely "
                + "nothing there.";

        this.addNameKeys("forest", "woods");
        this.addActKeys("explore");
    }
    // ========================================================================    
}


