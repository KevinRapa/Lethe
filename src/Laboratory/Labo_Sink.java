package Laboratory;

import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Sink extends Furniture {
    private final Item VIAL_REF, BEAKER_REF, BUCKET_REF;
    //-------------------------------------------------------------------------
    public Labo_Sink (Item vial, Item beaker, Item bucket) {
        super();

        this.BUCKET_REF = bucket;
        this.VIAL_REF = vial;
        this.BEAKER_REF = beaker; 
        
        this.description = "It's a square metal sink for dumping liquids and hand washing.";
        this.actDialog = "What a smart idea! You quickly wash your hands before carrying on.";
        this.searchDialog = "It's a dirty metal sink, and has lost most, if any shine it ever had.";
        this.useDialog = "You pour it down the drain.";

        this.addNameKeys("(?:square )?(?:metal )?sink");
        this.addUseKeys("(?:chilled )?[\\w\\d]+ \\d{1,2}mL", 
                        BUCKET_OF_WATER,
                        SPRUCE_EXTRACT,
                        HOLY_WATER,
                        POTION_OF_SCIENCE,
                        PHASE_DOOR_POTION,
                        BOTTLE_OF_WINE,
                        BOTTLE_OF_VINEGAR);
        this.addActKeys("use", "wash");
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        String s = item.toString();
        
        if (s.equals(BOTTLE_OF_VINEGAR) || s.equals(PHASE_DOOR_POTION) || s.equals(BOTTLE_OF_WINE))
            return "That would be such a waste!";
        else if (s.equals(BUCKET_OF_WATER)) {
            Player.getInv().remove(item);
            Player.getInv().add(BUCKET_REF);
            return this.useDialog;
        }
        else {
            Player.getInv().remove(item);
            
            if (item.toString().equals(POTION_OF_SCIENCE))
                Player.getInv().add(BEAKER_REF);
            else
                // Forces vial in in case player already holds it
                Player.getInv().forceAdd(VIAL_REF);
            
            return this.useDialog;
        }
    }
    //-------------------------------------------------------------------------     
}


