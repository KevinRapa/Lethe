package Parlor;

import Super.Furniture;
import Super.Item;
import Main.Player;
import Super.Room;

public class Par1_EnchtTbl extends Furniture {
    private final Item REF_ENCH_BTTL, REF_SALTS, REF_MANDRAKE, REF_SPRUCE, REF_BTTL,
                       REF_FTHR, REF_ATHR, REF_SHS, REF_STLTHSHS;
    private boolean hasSpruce, hasMandrake, hasFireSalts, hasBottle, hasFthr, hasHly, hasShs;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par1_EnchtTbl(Item enchtBttl, Item salts, Item spruce, 
                         Item mandrake, Item bttl, Item fthr, Item athr, 
                         Item shs, Item stlthShs, Item... items) {
        super(items);
        
        this.REF_ENCH_BTTL = enchtBttl; // For giving player the enchanted bottle.
        this.REF_STLTHSHS = stlthShs; // For giving player the stealth getShoes.
        
        this.REF_MANDRAKE = mandrake; this.REF_SALTS = salts; this.REF_FTHR = fthr;
        this.REF_BTTL = bttl; this.REF_SPRUCE = spruce; this.REF_ATHR = athr; 
        this.REF_SHS = shs;
        
        hasFireSalts = hasMandrake = hasSpruce = hasFthr = hasHly = hasShs = 
        hasFthr = hasHly = hasShs = false; // Table starts with nothing but the glass bottle.
        
        hasBottle = true; // The bottle is already on the table.
        
        this.interactDialog = "You pound your hands on the table.";
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
            Player.switchShoes("");
            
        Player.getINV().give(item, this.inv);
        
        return "You place the " + item + " on the table.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {          
        String rep = this.interactDialog;
        this.check();
        
        switch (this.enchant()) {
            case 1:
                rep += " As you do, a loud bang startles you and a bright flash blinds you momentarily. You look away,\n"
                     + "and as you turn back, you see that the four ingredients have vanished. The bottle, bearing a\n"
                     + "certain magical aura, sits alone at the table's center.";
                break;
            case 2:
                rep += " As you do, a loud bang startles you and a bright flash blinds you momentarily. You look away,\n"
                     + "and as you turn back, you see that the three ingredients have vanished. A delicate pair of\n"
                     + "slippers shrouded in a fine dark mist take their place.";
                break;
            default:
                rep += " To your disappointment, the table only jostles a small amount\n"
                     + "from the force. Perhaps you aren't the wizard you thought you were.";
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private void check() {
        this.hasFireSalts = this.inv.getInv().contains(this.REF_SALTS);
        this.hasSpruce = this.inv.getInv().contains(this.REF_SPRUCE);
        this.hasMandrake = this.inv.getInv().contains(this.REF_MANDRAKE);
        this.hasBottle = this.inv.getInv().contains(this.REF_BTTL);
        
        this.hasFthr = this.inv.getInv().contains(this.REF_FTHR);
        this.hasHly = this.inv.getInv().contains(this.REF_ATHR);
        this.hasShs = this.inv.getInv().contains(this.REF_SHS);
    }
/*----------------------------------------------------------------------------*/
    private int enchant() {
        
        if (hasBottle && hasFireSalts && hasMandrake && hasSpruce && inv.getInv().size() == 4) {
            this.inv.remove(REF_SALTS);
            this.inv.remove(REF_SPRUCE);
            this.inv.remove(REF_BTTL);
            this.inv.remove(REF_MANDRAKE);
            this.inv.add(REF_ENCH_BTTL);
            return 1;
        }
        else if(hasShs && hasFthr && hasHly && inv.getInv().size() == 3) {
            this.inv.remove(REF_FTHR);
            this.inv.remove(REF_ATHR);
            this.inv.remove(REF_SHS);
            this.inv.add(REF_STLTHSHS);
            return 2;
        }
        return 0;
    }
/*----------------------------------------------------------------------------*/
}
