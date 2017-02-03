package Workshop;

import A_Main.Inventory;
import static A_Main.NameConstants.*;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
/**
 * Used to create lenses and glass sheets.
 * Player must use the lens template on this plus molten red glass to 
 * make the red lens.
 * 
 * @author Kevin Rapa
 */
public class Wrk_CastingTable extends Furniture {
    private final Inventory BRL_INV, SCK_INV, CBNT_INV;
    private final Item SHEET_REF, RED_LENS_REF, BLUE_LENS_REF, YELLOW_LENS_REF, 
                       SAND_REF, RED_DYE_REF, BLUE_DYE_REF, YELLOW_DYE_REF, POTASH_REF;
    private boolean hasTemplate;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_CastingTable(Inventory brl, Inventory sck, Item rdLns, Item snd, 
                        Item rdDy, Item blDy, Item yllwDy, Item ptsh, Inventory cbnt) {
        super();
        this.BRL_INV = brl; // Inventory references to restock
        this.SCK_INV = sck; 
        this.CBNT_INV = cbnt; 
        
        this.SHEET_REF = 
                new Item("glass sheet", "Wait... this isn't right. Weren't you supposed to make a lens?");
        this.BLUE_LENS_REF = 
                new Item("blue lens", "You made a blue lens. Good job, but was this the right color?",
                         "Wait... was this the color you were supposed to make?");
        this.YELLOW_LENS_REF = 
                new Item("yellow lens", "You made a yellow lens. Good job, but was this the right color?", 
                         "Wait... was this the color you were supposed to make?");
        
        this.RED_LENS_REF = rdLns; // Lenses to give player
        
        this.RED_DYE_REF = rdDy; 
        this.BLUE_DYE_REF = blDy; 
        this.YELLOW_DYE_REF = yllwDy; // Dyes to restock
        
        this.POTASH_REF = ptsh; 
        this.SAND_REF = snd; // Sand and potash to restock
        
        this.hasTemplate = false;
        this.searchDialog = "There's nothing... no drawers or anything here. Just a plain metal table.";
        this.description = "It's a tall metal casting table for casting metal.";
        this.addUseKeys(LENS_TEMPLATE, MOLTEN_RED_GLASS, MOLTEN_YELLOW_GLASS, MOLTEN_BLUE_GLASS);
        this.addNameKeys("(?:casting )?table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String name = item.toString();
        
        if (item.toString().equals(LENS_TEMPLATE)) {
            this.hasTemplate = true;
            Player.getInv().remove(item);
            return "You fit the template onto the table's surface.";
        }
        else {
            Player.getInv().remove(item);
            
            if (this.hasTemplate) {   
                String color;
                
                switch (name) {
                    case MOLTEN_RED_GLASS:
                        Player.getInv().add(RED_LENS_REF); // Give player red lens.
                        color = "red";
                        break;
                    case MOLTEN_BLUE_GLASS:
                        Player.getInv().add(BLUE_LENS_REF); // Give player blue lens.
                        this.SCK_INV.add(SAND_REF); // Restock sand.
                        this.BRL_INV.add(BLUE_DYE_REF); // Restock dye.
                        this.CBNT_INV.add(POTASH_REF); // Restock potash.
                        color = "blue";
                        break;
                    default:
                        Player.getInv().add(YELLOW_LENS_REF); // Give player yellow lens.
                        this.SCK_INV.add(SAND_REF); // Restock sand.
                        this.BRL_INV.add(YELLOW_DYE_REF); // Restock dye.
                        this.CBNT_INV.add(POTASH_REF); // Restock potash.
                        color = "yellow";
                        break;
                }
                return "You pour the molten glass into the mold. In no time\n"
                     + "at all, the glass dries into a fresh new " + color + " lens!\n"
                     + "You take the lens. This is what you needed, right?";    
            }
            else {
                Player.getInv().add(SHEET_REF);
                this.SCK_INV.add(SAND_REF);
                this.CBNT_INV.add(POTASH_REF);
                
                switch (name) {
                    case MOLTEN_RED_GLASS:
                        this.BRL_INV.add(RED_DYE_REF);
                        break;
                    case MOLTEN_BLUE_GLASS:
                        this.BRL_INV.add(BLUE_DYE_REF);
                        break;
                    default:
                        this.BRL_INV.add(YELLOW_DYE_REF);
                        break;
                }
                return "You pour the molten glass onto the casting table.\n" +
                       "As the glass dries, you scratch your head. Didn't\n"
                     + "the instructions say to use a template? You take the\n"
                     + "solidified glass sheet from the casting table.";
            }
        }        
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.hasTemplate)
            return "The tall metal casting table has a template fitted to it.";
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}
