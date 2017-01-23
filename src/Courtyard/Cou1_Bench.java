package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou1_Bench extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Bench() {
        super();
        this.searchable = false;
        this.description = "The bench is blanketed in multiflora. Its backrest\n"
                         + "lies on the ground behind it.";
        this.searchDialog = "You aren't risking getting pricked by those thorns.";
        this.actDialog = this.searchDialog;
        this.addActKeys("sit", "relax", "lay");
        this.addNameKeys("(?:ruined )?(?:stone )?bench");
    }
/*----------------------------------------------------------------------------*/
}
