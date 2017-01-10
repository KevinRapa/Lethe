package Parlor;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import Library.Shoes;

public class Par1_EnchtTbl extends Furniture {
    private final Item REF_ENCH_BTTL, REF_SALTS, REF_MANDRAKE, REF_SPRUCE, 
                       REF_BTTL, REF_FTHR, REF_ATHR, REF_SHS;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par1_EnchtTbl(Item enchtBttl, Item salts, Item spruce, Item mandrake, 
                         Item bttl, Item fthr, Item athr, Item shs, Item... items) {
        super(items);
        
        this.REF_ENCH_BTTL = enchtBttl;     this.REF_SHS = shs;
        this.REF_MANDRAKE = mandrake;       this.REF_SALTS = salts; 
        this.REF_FTHR = fthr;               this.REF_BTTL = bttl; 
        this.REF_SPRUCE = spruce;           this.REF_ATHR = athr; 
        
        this.actDialog = "You pound your hands on the table.";
        this.searchDialog = "You look on the table.";
        this.description = "The black pentagonal table bears many carvings of strange\n"
                         + "runes and writing that seem to glow from the fire. Two"
                         + "circular runes decorate either side of the table.";
        
        this.addUseKeys(".+"); // Accepts any item to be put on it.
        this.addNameKeys("enchanting table", "table");
        this.addActKeys("pound, hit, activate, enchant");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().matches(Player.getShoes()))
            Player.setShoes("");
            
        Player.getInv().give(item, this.inv);
        
        return "You place the " + item + " on the table.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {          
        switch (this.enchant()) {
            case 1:
                return actDialog.concat(" As you do, a loud bang startles you and a bright flash blinds you momentarily. You look away,\n"
                                      + "and as you turn back, you see that the four ingredients have vanished. The bottle, bearing a\n"
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
        
        if (inv.contains(this.REF_BTTL) && 
            inv.contains(this.REF_SALTS) && 
            inv.contains(this.REF_MANDRAKE) && 
            inv.contains(this.REF_SPRUCE) && 
            inv.size() == 4) 
        {
            inv.remove(REF_SALTS);
            inv.remove(REF_SPRUCE);
            inv.remove(REF_BTTL);
            inv.remove(REF_MANDRAKE);
            inv.add(REF_ENCH_BTTL);
            return 1;
        }
        else if(inv.contains(this.REF_SHS) && 
                inv.contains(this.REF_FTHR) && 
                inv.contains(this.REF_ATHR) && 
                inv.size() == 3) 
        {
            inv.remove(REF_FTHR);
            inv.remove(REF_ATHR);
            inv.remove(REF_SHS);
            inv.add(new Shoes("shrouded shoes", "The pair of slippers carry almost no weight to them.", 
                              "You slip on the shoes. They are perhaps the most comfortable pair you've ever worn."));
            return 2;
        }
        else
            return 0;
    }
/*----------------------------------------------------------------------------*/
}
