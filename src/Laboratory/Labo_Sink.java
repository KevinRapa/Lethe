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
    private final Furniture WATER_REF;
    boolean isOn;
    //-------------------------------------------------------------------------
    public Labo_Sink (Item vial, Item beaker, Item bucket, Furniture water) {
        super();

        this.isOn = false;
        this.BUCKET_REF = bucket;
        this.VIAL_REF = vial;
        this.BEAKER_REF = beaker; 
        this.WATER_REF = water;
        
        this.description = "It's a square metal sink for dumping liquids and hand washing.";
        this.actDialog = "What a smart idea! You quickly wash your hands before carrying on.";
        this.searchDialog = "It's a dirty metal sink, and has lost most, if any shine it ever had.";
        this.useDialog = "You pour it down the drain.";

        this.addNameKeys("(?:square )?(?:metal )?(?:sink|faucet)");
        this.addUseKeys("(?:super )*+(?:chilled )?[\\w\\d]++ \\d{1,2}mL", 
                        BUCKET_OF_WATER, SPRUCE_EXTRACT, HOLY_WATER,
                        POTION_OF_SCIENCE, PHASE_DOOR_POTION, BOTTLE_OF_WINE,
                        BOTTLE_OF_VINEGAR);
        this.addActKeys("use", "wash", "turn", "run", "activate");
    }
    //-------------------------------------------------------------------------     
    @Override public String useEvent(Item item) {
        String s = item.toString();
        
        if (s.equals(BOTTLE_OF_VINEGAR) || s.equals(PHASE_DOOR_POTION) 
                || s.equals(BOTTLE_OF_WINE))
        {
            return "That would be such a waste!";
        }
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
                Player.getInv().add(VIAL_REF);
            
            return this.useDialog;
        }
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("use") || key.equals("wash")) {
            return this.isOn ? this.actDialog : "The sink is off though!";
        }
        else {
            this.isOn = ! this.isOn;
            
            if (this.isOn) {
                Player.getPos().addFurniture(WATER_REF);
                return "The sink is now running.";
            }
            else {
                Player.getPos().removeFurniture(WATER_REF.getID());
                return "The sink is now off.";
            }
        }
    }
    //-------------------------------------------------------------------------
}


