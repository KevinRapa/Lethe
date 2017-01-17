package Workshop;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Wrk_CstngTbl extends Furniture {
    private final Furniture REFBRL, REFSCK, REFCBNT;
    private final Item REFSHT, REFRL, REFBL, REFYL, REFSND, REFRD, REFBD, REFYD, REFPTSH;
    private boolean hasTemplate;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_CstngTbl(Furniture brl, Furniture sck, Item rdLns, Item snd, 
                        Item rdDy, Item blDy, Item yllwDy, Item ptsh, Furniture cbnt) {
        super();
        this.REFBRL = brl; this.REFSCK = sck; this.REFCBNT = cbnt; // Furniture refs to restock
        
        this.REFSHT = new Item("glass sheet", "Wait... this isn't right. Weren't you supposed to make a lens?");
        this.REFBL = new Item("blue lens", "You made a blue lens. Good job, but was this the right color?",
                                           "Wait... was this the color you were supposed to make?");
        this.REFYL = new Item("yellow lens", "You made a yellow lens. Good job, but was this the right color?", 
                                             "Wait... was this the color you were supposed to make?");
        
        this.REFRL = rdLns; // Lenses to give player
        
        this.REFRD = rdDy; this.REFBD = blDy; this.REFYD = yllwDy; // Dyes to restock
        this.REFPTSH = ptsh; this.REFSND = snd; // Sand and potash to restock
        
        this.hasTemplate = false;
        this.searchable = false;
        this.description = "It's a tall metal casting table for casting metal.";
        this.addUseKeys("lens template", "molten red glass", "molten yellow glass", "molten blue glass");
        this.addNameKeys("table", "casting table");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep, name = item.toString();
        
        if (item.toString().equals("lens template")) {
            this.hasTemplate = true;
            Player.getInv().remove(item);
            rep = "You fit the template onto the table's surface.";
        }
        else {
            Player.getInv().remove(item);
            
            if (this.hasTemplate) {   
                String color;
                if (name.equals("molten red glass")) {
                    Player.getInv().add(this.REFRL); // Give player red lens.
                    color = "red";
                }
                else if (name.equals("molten blue glass")) {
                    Player.getInv().add(this.REFBL); // Give player blue lens.
                    this.REFSCK.getInv().add(this.REFSND); // Restock sand.
                    this.REFBRL.getInv().add(this.REFBD); // Restock dye.
                    this.REFCBNT.getInv().add(this.REFPTSH); // Restock potash.
                    color = "blue";
                }
                else {  
                    Player.getInv().add(this.REFYL); // Give player yellow lens.
                    this.REFSCK.getInv().add(this.REFSND); // Restock sand.
                    this.REFBRL.getInv().add(this.REFYD); // Restock dye.
                    this.REFCBNT.getInv().add(this.REFPTSH); // Restock potash.
                    color = "yellow";
                }
                rep = "You pour the molten glass into the mold. In no time\n"
                    + "at all, the glass dries into a fresh new " + color + " lens!\n"
                    + "You take the lens. This is what you needed, right?";    
            }
            else {
                Player.getInv().add(this.REFSHT);
                this.REFSCK.getInv().add(this.REFSND);
                this.REFCBNT.getInv().add(this.REFPTSH);
                
                if (name.equals("red glass"))                     
                    this.REFBRL.getInv().add(this.REFRD);
                
                else if (name.equals("blue glass")) 
                    this.REFBRL.getInv().add(this.REFBD);
                
                else if (name.equals("yellow glass")) 
                    this.REFBRL.getInv().add(this.REFYD);
                
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
