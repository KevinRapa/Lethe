package Laboratory;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Labo_Snk extends Furniture {
    private final Item TUBE_REF;
    // ========================================================================
    public Labo_Snk (Item testTube) {
        super();
        this.searchable = false;
        this.TUBE_REF = testTube;
        this.description = "It's a plain square metal sink for chemical disposal and hand washing.";
        this.actDialog = "What a smart idea! You quickly wash your hands before going to science.";
        this.searchDialog = "It's just a plain metal sink.";
        this.useDialog = "You pour the chemical down the drain.";

        this.addNameKeys("(?:plain )?(?:square )?(?:metal )?sink");
        this.addUseKeys("bromine, \\d{1,2}mL", 
                        "chilled bromine, \\d{1,2}mL",
                        "aether, \\d{1,2}mL", 
                        "vinegar, \\d{1,2}mL",
                        "wine, \\d{1,2}mL", 
                        "carbonic acid, \\d{1,2}mL", 
                        "hydroflouric acid, \\d{1,2}mL",
                        "phenolphthalein, \\d{1,2}mL", 
                        "chilled bromine, \\d{1,2}mL", 
                        "sodium chloride, \\d{1,2}mL",
                        "potion of science",
                        "phase door potion",
                        "bottle of wine",
                        "bottle of vinegar");
        this.addActKeys("use", "wash");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.toString().matches("vinegar|wine|phase door potion"))
            return "That would be such a waste!";
        else {
            Player.getInv().remove(item);
            Player.getInv().add(TUBE_REF);
            return this.actDialog;
        }
    }
    // ========================================================================     
}


