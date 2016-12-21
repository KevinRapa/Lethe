package Workshop;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class Wrk_CstngTbl extends Furniture {
    private final Furniture REFBRL, REFSCK, REFCBNT;
    private final Item REFSHT, REFRL, REFBL, REFYL, REFSND, REFRD, REFBD, REFYD, REFPTSH;
    private boolean hasTemplate;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Wrk_CstngTbl(Furniture brl, Furniture sck, Item glssSht, Item rdLns, 
                        Item blLns, Item yllwLns, Item snd, Item rdDy, Item blDy, 
                        Item yllwDy, Item ptsh, Furniture cbnt) {
        super();
        this.REFBRL = brl; this.REFSCK = sck; this.REFCBNT = cbnt; // Furniture refs to restock
        this.REFSHT = glssSht;
        this.REFRL = rdLns; this.REFBL = blLns; this.REFYL = yllwLns; // Lenses to give player
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
        String rep;
        
        if (item.toString().matches("lens template")) {
            this.hasTemplate = true;
            Player.getINV().remove(item);
            rep = "You fit the template onto the table's surface.";
        }
        else {
            Player.getINV().remove(item);
            
            if (this.hasTemplate) {   
                String color;
                if (item.toString().matches("molten red glass")) {
                    Player.getINV().add(this.REFRL); // Give player red lens.
                    color = "red";
                }
                else if (item.toString().matches("molten blue glass")) {
                    Player.getINV().add(this.REFBL); // Give player blue lens.
                    this.REFSCK.getInv().add(this.REFSND); // Restock sand.
                    this.REFBRL.getInv().add(this.REFBD); // Restock dye.
                    this.REFCBNT.getInv().add(this.REFPTSH); // Restock potash.
                    color = "blue";
                }
                else {  
                    Player.getINV().add(this.REFYL); // Give player yellow lens.
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
                Player.getINV().add(this.REFSHT);
                this.REFSCK.getInv().add(this.REFSND);
                this.REFCBNT.getInv().add(this.REFPTSH);
                
                if (item.toString().matches("red glass"))                     
                    this.REFBRL.getInv().add(this.REFRD);
                
                else if (item.toString().matches("blue glass")) 
                    this.REFBRL.getInv().add(this.REFBD);
                
                else if (item.toString().matches("yellow glass")) 
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
        String rep = this.description;
        
        if (this.hasTemplate)
            rep = "The tall metal casting table has a template fitted to it.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
