package Workshop;

import static A_Main.NameConstants.*;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Wrk_CstngTbl extends Furniture {
    private final Furniture REFBRL, REFSCK, REFCBNT;
    private final Item SHEET_REF, RED_LENS_REF, BLUE_LENS_REF, YELLOW_LENS_REF, 
                       SAND_REF, RED_DYE_REF, BLUE_DYE_REF, YELLOW_DYE_REF, POTASH_REF;
    private boolean hasTemplate;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_CstngTbl(Furniture brl, Furniture sck, Item rdLns, Item snd, 
                        Item rdDy, Item blDy, Item yllwDy, Item ptsh, Furniture cbnt) {
        super();
        this.REFBRL = brl; this.REFSCK = sck; this.REFCBNT = cbnt; // Furniture refs to restock
        
        this.SHEET_REF = new Item("glass sheet", "Wait... this isn't right. Weren't you supposed to make a lens?");
        this.BLUE_LENS_REF = new Item("blue lens", "You made a blue lens. Good job, but was this the right color?",
                                           "Wait... was this the color you were supposed to make?");
        this.YELLOW_LENS_REF = new Item("yellow lens", "You made a yellow lens. Good job, but was this the right color?", 
                                             "Wait... was this the color you were supposed to make?");
        
        this.RED_LENS_REF = rdLns; // Lenses to give player
        
        this.RED_DYE_REF = rdDy; this.BLUE_DYE_REF = blDy; this.YELLOW_DYE_REF = yllwDy; // Dyes to restock
        this.POTASH_REF = ptsh; this.SAND_REF = snd; // Sand and potash to restock
        
        this.hasTemplate = false;
        this.searchable = false;
        this.description = "It's a tall metal casting table for casting metal.";
        this.addUseKeys(LENS_TEMPLATE, MOLTEN_RED_GLASS, MOLTEN_YELLOW_GLASS, MOLTEN_BLUE_GLASS);
        this.addNameKeys("table", "casting table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep, name = item.toString();
        
        if (item.toString().equals(LENS_TEMPLATE)) {
            this.hasTemplate = true;
            Player.getInv().remove(item);
            rep = "You fit the template onto the table's surface.";
        }
        else {
            Player.getInv().remove(item);
            
            if (this.hasTemplate) {   
                String color;
                if (name.equals(MOLTEN_RED_GLASS)) {
                    Player.getInv().add(this.RED_LENS_REF); // Give player red lens.
                    color = "red";
                }
                else if (name.equals(MOLTEN_BLUE_GLASS)) {
                    Player.getInv().add(this.BLUE_LENS_REF); // Give player blue lens.
                    this.REFSCK.getInv().add(this.SAND_REF); // Restock sand.
                    this.REFBRL.getInv().add(this.BLUE_DYE_REF); // Restock dye.
                    this.REFCBNT.getInv().add(this.POTASH_REF); // Restock potash.
                    color = "blue";
                }
                else {  
                    Player.getInv().add(this.YELLOW_LENS_REF); // Give player yellow lens.
                    this.REFSCK.getInv().add(this.SAND_REF); // Restock sand.
                    this.REFBRL.getInv().add(this.YELLOW_DYE_REF); // Restock dye.
                    this.REFCBNT.getInv().add(this.POTASH_REF); // Restock potash.
                    color = "yellow";
                }
                rep = "You pour the molten glass into the mold. In no time\n"
                    + "at all, the glass dries into a fresh new " + color + " lens!\n"
                    + "You take the lens. This is what you needed, right?";    
            }
            else {
                Player.getInv().add(this.SHEET_REF);
                this.REFSCK.getInv().add(this.SAND_REF);
                this.REFCBNT.getInv().add(this.POTASH_REF);
                
                if (name.equals("red glass"))                     
                    this.REFBRL.getInv().add(this.RED_DYE_REF);
                
                else if (name.equals("blue glass")) 
                    this.REFBRL.getInv().add(this.BLUE_DYE_REF);
                
                else if (name.equals("yellow glass")) 
                    this.REFBRL.getInv().add(this.YELLOW_DYE_REF);
                
                rep = "You pour the molten glass onto the casting table.\n" +
                      "As the glass dries, you scratch your head. Didn't\n"
                    + "the instructions say to use a template? You take the\n"
                    + "solidified glass sheet from the casting table.";
            }
        }        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.hasTemplate)
            return "The tall metal casting table has a template fitted to it.";
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/
}
