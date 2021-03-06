package Workshop;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import static A_Main.Names.*;
import A_Super.Item;
import A_Main.Player;
import A_Super.BreakableItem;
import A_Super.Furniture;
import A_Super.Moveable;
import A_Super.SearchableFurniture;
/**
 * Used to create lenses and glass sheets.
 * Player must use the lens template on this plus molten red glass to 
 * make the red lens.
 * 
 * @author Kevin Rapa
 */
public class Wrk_CastingTable extends SearchableFurniture implements Moveable {
    private final int BRL_ID, SCK_ID, CBNT_ID;
    
    private final Item SHEET_REF, RED_LENS_REF, BLUE_LENS_REF, YELLOW_LENS_REF, 
            SAND_REF, RED_DYE_REF, BLUE_DYE_REF, YELLOW_DYE_REF, POTASH_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_CastingTable(Furniture brl, Furniture sck, Item rdLns, Item snd, 
                        Item rdDy, Item blDy, Item yllwDy, Item ptsh, Furniture cbnt) {
        super();
        
        this.inv = new TableInventory();
        
        // Inventory references to restock
        this.BRL_ID = brl.getID();     
        this.SCK_ID = sck.getID();     
        this.CBNT_ID = cbnt.getID(); 
        
        // Lens to give player
        this.SHEET_REF = new BreakableItem(GLASS_SHEET, 
                "Wait... this isn't right. Weren't you trying to make a lens?", 0);
        this.BLUE_LENS_REF = new BreakableItem(BLUE_LENS, 
                "You made a clear blue lens.", 20);
        this.YELLOW_LENS_REF = new BreakableItem(YELLOW_LENS, 
                "You made a clear yellow lens.", 20);
        this.RED_LENS_REF = rdLns; 
        
        // Dyes to restock
        this.RED_DYE_REF = rdDy;   
        this.BLUE_DYE_REF = blDy;  
        this.YELLOW_DYE_REF = yllwDy; 
        
        // Sand and potash to restock
        this.POTASH_REF = ptsh;     
        this.SAND_REF = snd; 

        this.searchDialog = "You search the plain metal table.";
        this.description = "It's a tall metal casting table for shaping solids from molten liquids.";
        
        this.addUseKeys(LENS_TEMPLATE, MOLTEN_RED_GLASS, MOLTEN_YELLOW_GLASS, MOLTEN_BLUE_GLASS);
        this.addNameKeys("(?:tall )?(?:metal )?(?:casting )?table");
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        String name = item.toString();
        
        if (name.equals(LENS_TEMPLATE)) {
            Player.getInv().give(item, this.inv);
            return "You fit the template onto the table's surface.";
        }
        else {
            Player.getInv().remove(item);
            
            Inventory sackInv = Player.getRoomObj(Id.CLOS).getFurnRef(SCK_ID).getInv();
            Inventory cbntInv = Player.getRoomObj(Id.WORK).getFurnRef(CBNT_ID).getInv();
            Inventory brlInv = Player.getRoomObj(Id.WORK).getFurnRef(BRL_ID).getInv();
            
            if (this.containsItem(LENS_TEMPLATE)) {   
                String color;
                
                switch (name) {
                    case MOLTEN_RED_GLASS:
                        this.inv.add(RED_LENS_REF); // Give player red lens.
                        color = "red";
                        break;
                    case MOLTEN_BLUE_GLASS:
                        this.inv.add(BLUE_LENS_REF); // Give player blue lens.
                        sackInv.add(SAND_REF); // Restock sand.
                        brlInv.add(BLUE_DYE_REF); // Restock dye.
                        cbntInv.add(POTASH_REF); // Restock potash.
                        color = "blue";
                        break;
                    default:
                        this.inv.add(YELLOW_LENS_REF); // Give player yellow lens.
                        sackInv.add(SAND_REF); // Restock sand.
                        brlInv.add(YELLOW_DYE_REF); // Restock dye.
                        cbntInv.add(POTASH_REF); // Restock potash.
                        color = "yellow";
                        break;
                }
                return "You pour the molten glass into the mold. In no time "
                     + "at all, the glass dries into a fresh new " + color + 
                        " lens! This is what you needed, right?";    
            }
            else {
                this.inv.add(SHEET_REF);
                sackInv.add(SAND_REF);
                cbntInv.add(POTASH_REF);
                
                switch (name) {
                    case MOLTEN_RED_GLASS:
                        brlInv.add(RED_DYE_REF);
                        break;
                    case MOLTEN_BLUE_GLASS:
                        brlInv.add(BLUE_DYE_REF);
                        break;
                    default:
                        brlInv.add(YELLOW_DYE_REF);
                        break;
                }
                return "You pour the molten glass onto the casting table. " +
                       "As the glass dries, you scratch your head. The square "
                        + "table has curiously yielded a non-round sheet of glass.";
            }
        }        
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (this.containsItem(LENS_TEMPLATE))
            return "The tall metal casting table has a template fitted to it.";
        else
            return this.description;
    }
//-----------------------------------------------------------------------------
/******************************************************************************/
//-----------------------------------------------------------------------------
    private class TableInventory extends Inventory {  
    // CONSTRUCTOR -------------------------------------------------------------      
        public TableInventory() {
            super();
        }
    //-------------------------------------------------------------------------
        @Override public boolean add(Item item) { 
            String n = item.toString();
            
            if (n.equals(RED_LENS) || n.equals(YELLOW_LENS) || 
                    n.equals(BLUE_LENS) || n.equals(GLASS_SHEET)) 
            {
                this.CONTENTS.add(item);
                return true;
            }
            else if (!(n.equals(MOLTEN_RED_GLASS) || n.equals(MOLTEN_BLUE_GLASS) || 
                  n.equals(MOLTEN_YELLOW_GLASS) || n.equals(LENS_TEMPLATE))) 
            {
                if (item.getType().equals(LIQUID))
                    GUI.out("Interesting... but that probably isn't going to form anything useful.");
                else
                    GUI.out("You're fairly sure the professionals don't put things like that onto casting tables.");
                
                return false;
            }
            else if (n.equals(LENS_TEMPLATE)) {
                this.CONTENTS.add(item);
                GUI.out("You fit the lens template onto the table.");
                return true;
            }
            else {
                GUI.out(useEvent(item));
                return true;
            }
        }
    }
//-----------------------------------------------------------------------------
/******************************************************************************/
//-----------------------------------------------------------------------------
}
