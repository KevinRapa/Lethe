package Laboratory;

import static A_Main.NameConstants.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Sink extends Furniture {
    private final Item TUBE_REF, BEAKER_REF;
    // ========================================================================
    public Labo_Sink (Item testTube, Item beaker) {
        super();
        this.searchable = false;
        
        this.TUBE_REF = testTube;
        this.BEAKER_REF = beaker; 
        
        this.description = "It's a plain square metal sink for chemical disposal and hand washing.";
        this.actDialog = "What a smart idea! You quickly wash your hands before going to science.";
        this.searchDialog = "It's just a plain metal sink.";
        this.useDialog = "You pour the chemical down the drain.";

        this.addNameKeys("(?:plain )?(?:square )?(?:metal )?sink");
        this.addUseKeys("Br \\d{1,2}mL", 
                        "chilled Br \\d{1,2}mL",
                        "ae \\d{1,2}mL", 
                        "vinegar \\d{1,2}mL",
                        "wine \\d{1,2}mL", 
                        "H2CO3 \\d{1,2}mL", 
                        "HF \\d{1,2}mL",
                        "C20H14O4 \\d{1,2}mL", 
                        "NaCl \\d{1,2}mL",
                        POTION_OF_SCIENCE,
                        PHASE_DOOR_POTION,
                        BOTTLE_OF_WINE,
                        BOTTLE_OF_VINEGAR);
        this.addActKeys("use", "wash");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().matches("vinegar|wine|phase door potion"))
            return "That would be such a waste!";
        else {
            Player.getInv().remove(item);
            
            if (item.toString().equals(POTION_OF_SCIENCE))
                Player.getInv().add(BEAKER_REF);
            else
                Player.getInv().add(TUBE_REF);
            
            return this.useDialog;
        }
    }
    // ========================================================================     
}


