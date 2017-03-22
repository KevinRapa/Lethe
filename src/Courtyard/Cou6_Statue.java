package Courtyard;

import A_Main.Inventory;
import static A_Main.Names.STATUE_HEAD;
import static A_Main.Names.STATUE_TORSO;
import A_Main.Player;
import A_Super.Item;
import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Cou6_Statue extends Statue {
    private final Inventory COU_FLOOR_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6_Statue(Inventory couF) {
        super();
        
        this.COU_FLOOR_REF = couF;
        this.useDialog = "You balance the % the best you can on the pair of legs, "
                       + "but can only watch helplessly as it falls back off onto "
                       + "the ground.";
        this.description = "The statue is just a waist with legs. Part of it\n"
                         + "lies on the ground. It once depicted a male figure.";
        this.actDialog = "The statue is rough and weathered- cracked all over\n"
                       + "from the variable weather it has endured for likely a while.";
        
        this.addUseKeys(STATUE_HEAD, STATUE_TORSO);
        this.addNameKeys("crumbling statue", "(?:pair of )?legs", "waist");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, COU_FLOOR_REF);
        
        return this.useDialog.replaceFirst("%w"
                + "", item.toString());
    }
/*----------------------------------------------------------------------------*/
}
