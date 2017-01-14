package Strange_Pool;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Sewp_Tnnl extends Furniture {

    // ========================================================================
    public Sewp_Tnnl () {
        super();
        this.searchable = false;
        
        this.description = "To the north is a short way to a large open tunnel\n"
                         + "extending to the west and east.";
        this.searchDialog = "You will need to go over there to do that.";
        
        this.addNameKeys("tunnel");
    }
    // ========================================================================  
}


