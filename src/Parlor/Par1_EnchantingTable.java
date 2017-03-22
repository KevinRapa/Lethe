package Parlor;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Super.Item;
import A_Main.Player;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
import Library.Shoes;
/**
 * Used to make the shrouded shoes to traverse the back hall and the
 * enchanted bottle to access the back hall.
 * Recipes are scattered around the parlor. Player must visit previous areas
 * of the castle to collect the ingredients.
 * 
 * @see Parlor.Par1_Door
 * @see Back_Hall.Bha2
 * @see Parlor.Par1_FirePlace
 * @see Parlor.Par_EnchantingBook
 * @see Parlor.Par_ShoeRecipe
 * @see Parlor.Par_BottleRecipe
 * @author Kevin Rapa
 */
public class Par1_EnchantingTable extends SearchableFurniture implements Moveable {
    private final Item REF_ENCH_BTTL;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par1_EnchantingTable(Item enchtBttl, Item... items) {
        super(items);
        
        this.REF_ENCH_BTTL = enchtBttl; 
        
        this.actDialog = "You pound your hands on the table.";
        this.useDialog = "You place it on the table.";
        this.searchDialog = "You look on the table.";
        this.description = "The black pentagonal table bears many carvings of strange\n"
                         + "runes and writing that seem to glow from the fire. Two\n"
                         + "circular runes decorate either side of the table.";
        
        this.addUseKeys(ANYTHING); // Accepts any item to be put on it.
        this.addNameKeys("enchanting table", "table");
        this.addActKeys("pound", "hit", "activate", "enchant");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals("phylactery"))
            return "You probably shouldn't get rid of that.";
        
        if (item.toString().matches(Player.getShoes()))
            Player.setShoes(NOTHING);
            
        Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {          
        switch (this.enchant()) {
            case 1:
                return actDialog.concat(" As you do, a loud bang startles you and a bright flash blinds you momentarily. You look away.\n"
                                      + "As you turn back, you see that three of the four ingredients have vanished. The bottle, bearing a\n"
                                      + "certain magical aura, sits alone at the table's center.");
            case 2:
                return actDialog.concat(" As you do, a loud bang startles you and a bright flash blinds you momentarily. You look away,\n"
                                      + "and as you turn back, you see that the three ingredients have vanished. A delicate pair of\n"
                                      + "slippers shrouded in a fine dark mist take their place.");
            default:
                return actDialog.concat(" To your disappointment, the table only jostles a small amount\n"
                                      + "from the force. Perhaps you aren't the wizard you thought you were.");
        }
    }
/*----------------------------------------------------------------------------*/
    private int enchant() {
        
        if (inv.size() == 4 && containsItem(FIRE_SALTS) && 
            containsItem(MANDRAGORA) && containsItem(SPRUCE_EXTRACT) && 
            containsItem(GLASS_BOTTLE)) 
        {
            this.inv.clear();
            AudioPlayer.playEffect(32);
            AudioPlayer.playEffect(29);
            inv.add(REF_ENCH_BTTL);
            return 1;
        }
        else if(inv.size() == 3 && containsItem(RAVEN_FEATHER) && 
                containsItem(AETHER_VIAL) && containsItem(NIGHT_SLIPPERS))
        {
            this.inv.clear();
            AudioPlayer.playEffect(32);
            AudioPlayer.playEffect(29);
            inv.add(new Shoes(SHROUDED_SHOES, 
                    "The pair of slippers carry almost no weight to them. ", 
                    "You slip on the shoes. They are perhaps the most "
                  + "comfortable pair you've ever worn.", 100));
            return 2;
        }
        else
            AudioPlayer.playEffect(40);
            return 0;
    }
/*----------------------------------------------------------------------------*/
}
