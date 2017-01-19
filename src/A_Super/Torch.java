package A_Super;

import A_Main.Player;
import static A_Main.NameConstants.HAND_TORCH;
/**
 * Represents a wall-mounted torch that can be taken.
 * Torches are useful for a few things.
 * 
 * @see Laboratory.Labo_Dstllr
 * @see Catacombs.Catacomb
 * @see Caves.Cave
 * @see Kitchen.Kitc_Trch
 * @author Kevin Rapa
 */
public class Torch extends Furniture {
    protected final Item TORCH;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Torch() {
        super();
        this.TORCH = new Item(HAND_TORCH, "It's a burning piece of wood. Stay it from your beard!");
        this.inv = new Hldr_Inv(TORCH);
        
        this.description = "Sitting in a steel holder is a burning wall torch\n"
                         + "giving off an orange glow.";
        this.searchDialog = "You look in the mounted steel holder.";
        this.actDialog = "You slide the torch out of its holder and take it.";
        this.useDialog = "You slide the torch into the steel holder.";
        
        this.addActKeys(GETKEYS);
        this.addNameKeys("(?:wall )?torch(?:es)?", "(?:steel )?holders?");
        this.addUseKeys(HAND_TORCH);
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (this.containsItem(HAND_TORCH) && ! Player.hasItem(HAND_TORCH)) {
            this.inv.give(TORCH, Player.getInv());
            return this.actDialog;
        }
        else if (! this.containsItem(HAND_TORCH))
            return "The holder is empty you bumbling oaf.";
        else
            return "You are already carrying a torch.";
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        if (this.containsItem(HAND_TORCH))
            return "The holder already bears a torch you bumbling oaf.";
        else
            Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.containsItem(HAND_TORCH))
            return "The mounted steel holder is empty.";
            
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
/*----------------------------------------------------------------------------*/
}