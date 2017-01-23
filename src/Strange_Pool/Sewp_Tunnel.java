package Strange_Pool;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sewp_Tunnel extends Furniture {
    // ========================================================================
    public Sewp_Tunnel () {
        super();

        this.description = "To the north is a short way to a large open tunnel\n"
                         + "running to the west and east.";
        this.searchDialog = "You will need to go over there to do that.";
        
        this.addNameKeys("(?:large )?(?:open )?tunnel");
    }
    // ========================================================================  
}


