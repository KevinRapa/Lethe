package Courtyard;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Cou1_Bnch extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou1_Bnch() {
        super();
        this.searchable = false;
        this.description = "The bench is blanketed in multiflora. Its backrest\n"
                         + "lies on the ground behind it.";
        this.searchDialog = "You aren't risking getting pricked by those thorns.";
        this.actDialog = "You aren't risking getting pricked by those thorns.";
        this.addActKeys("sit", "relax", "lay");
        this.addNameKeys("(?:ruined )?(?:stone )?bench");
    }
/*----------------------------------------------------------------------------*/
}
