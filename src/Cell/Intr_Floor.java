package Cell;

import A_Main.NameConstants;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.Weapon;
import Tunnels.Dungeon_Floor;
import java.util.Arrays;
/**
 * The metal bar needed to open the grate is located here.
 * This furniture resets itself if the player is captured by the monster.
 * @author Kevin Rapa
 */
public class Intr_Floor extends Dungeon_Floor implements Resetable {
    private final Item METAL_BIT_REF = new Item("metal bit", "It's a small scrap of metal. You have no idea what it's for."),
                       SCREW_REF = new Item("screw", "A small metal screw."),
                       METAL_BAR_REF = new Weapon(NameConstants.METAL_BAR, "A sturdy metal bar about 2 feet long. Possibly broken off from the gears."),
                       WOOD_CHUNK_REF = new Item("soggy wood chunk", "It's a rotted, wet chunk of wood.");
    
    private final Item[] ITEM_RESETS = {
        METAL_BIT_REF, SCREW_REF, METAL_BIT_REF, METAL_BAR_REF, 
        WOOD_CHUNK_REF, SCREW_REF, WOOD_CHUNK_REF
    };
    // ========================================================================
    public Intr_Floor () {
        super();
        
        this.description = "The wet cobblestone floor is littered with many bits of metal and machine parts.";
        this.inv.contents().addAll(Arrays.asList(ITEM_RESETS));
        this.addNameKeys("(?:wet )?(?:cobblestone )?floor");
    }
    // ========================================================================   
    @Override public void reset() {
        this.inv.clear();
        for (Item i : this.ITEM_RESETS)
            this.inv.add(i);
    }
    // ========================================================================   
}

