package Strange_Pool;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Sewp_Tunnel extends Furniture implements Unmoveable {
    //-------------------------------------------------------------------------
    public Sewp_Tunnel () {
        super();

        this.description = "To the north is a short way to a large open tunnel "
                         + "running to the west and east.";
        this.searchDialog = "You will need to go over there to do that.";
        
        this.addNameKeys("(?:large )?(?:open )?tunnel");
    }
    //-------------------------------------------------------------------------  
}


