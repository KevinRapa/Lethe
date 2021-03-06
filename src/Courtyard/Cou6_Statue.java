package Courtyard;

import A_Main.Inventory;
import static A_Main.Names.STATUE_HEAD;
import static A_Main.Names.STATUE_TORSO;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Statue;
/**
 * @author Kevin Rapa
 */
public class Cou6_Statue extends Statue {
    private final int COU_FLOOR_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6_Statue(Furniture couF) {
        super();
        
        this.COU_FLOOR_ID = couF.getID();
        this.useDialog = "You balance the % the best you can on the pair of legs, "
                       + "but can only watch helplessly as it falls back off onto "
                       + "the ground.";
        this.description = "The statue is just a waist with legs. Part of it "
                         + "lies on the ground. It once depicted a male figure.";
        this.actDialog = "The statue is rough and weathered- cracked all over "
                       + "from the variable weather it has endured for likely a while.";
        
        this.addUseKeys(STATUE_HEAD, STATUE_TORSO);
        this.addNameKeys("crumbling statue", "(?:pair of )?legs", "waist");
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        Inventory i = Player.getPos().getFurnRef(COU_FLOOR_ID).getInv();
        
        Player.getInv().give(item, i);
        
        return this.useDialog.replaceFirst("%", item.toString());
    }
//-----------------------------------------------------------------------------
}
