package A_Super;

import A_Main.GUI;
import A_Main.Player;
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
        this.TORCH = new Item("hand torch", "It's a burning piece of wood. Stay it from your beard!");
        this.inv = new Hldr_Inv(TORCH);
        
        this.description = "Sitting in a steel holder is a burning wall torch\n"
                         + "giving off an orange glow.";
        this.searchDialog = "You look in the mounted steel holder.";
        this.actDialog = "You slide the torch out of its holder and take it.";
        this.useDialog = "You slide the torch into the steel holder.";
        
        this.addActKeys(GETKEYS);
        this.addNameKeys("(?:wall )?torch(?:es)?", "(?:steel )?holders?");
        this.addUseKeys("hand torch");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        String rep = this.actDialog;
        
        if (this.containsItem("hand torch")) {
            this.inv.give(TORCH, Player.getInv());
            GUI.invOut("You are carrying:\n" + Player.getInv());
        }
        else
            rep = "The holder is empty you bumbling oaf.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item item) {
        if (this.containsItem("hand torch"))
            return "The holder already bears a torch you bumbling oaf.";
        else
            Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! this.containsItem("hand torch"))
            return "The mounted steel holder is empty.";
            
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        return this.getDescription();
    }
/*----------------------------------------------------------------------------*/
}