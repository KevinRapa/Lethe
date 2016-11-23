/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parlor;

import Super.Furniture;
import Super.Item;
import Core.Inventory;
import Super.Room;

public class Par1_EnchtTbl extends Furniture {
    private final Inventory REFPLYR;
    private final Item REF, REFSALTS, REFMANDRAKE, REFSPRUCE, REFBTTL;
    private boolean hasSpruce, hasMandrake, hasFireSalts, hasBottle;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Par1_EnchtTbl(String NAME, Inventory plyrInv, Item enchtBttl, Item salts, 
                         Item spruce, Item mandrake, Item bttl, Item ... items) {
        super(NAME, items);
        this.REFPLYR = plyrInv;
        this.REF = enchtBttl;
        this.REFMANDRAKE = mandrake; this.REFSALTS = salts;
        this.REFBTTL = bttl; this.REFSPRUCE = spruce;
        
        this.hasFireSalts = false; this.hasMandrake = false; this.hasSpruce = false;
        
        this.interactDialog = "You pound your hands on the table.";
        this.searchDialog = "You look on the table.";
        this.description = "The black pentagonal table bears many carvings of strange\n"
                         + "runes and writing that seem to glow from the fire. Two"
                         + "circular runes decorate either side of the table.";
        
        this.addUseKeys("mandrake root", "fire salts", "spruce extract");
        this.addNameKeys("enchanting table", "table");
        this.addActKeys("pound, hit, activate, enchant");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.REFPLYR.getInv().remove(item);
        this.inv.add(item);
        this.check();
        
        return "You place the " + item + " on the table.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        
        this.check();
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(Room[][][] map, String key) {          
        String rep = this.interactDialog;
        
        if (this.enchant())
            rep += " As you do, a loud bang startles you and a bright flash blinds you momentarily. You look away,\n"
                 + "and as you turn back, you see that the three ingredients have vanished. The bottle, bearing a\n"
                 + "certain magical aura, sits alone at the table's center.";
        else
            rep += " To your disappointment, the table only jostles a small amount\n"
                    + "from the force. Perhaps you aren't the wizard you thought you were.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private void check() {
        this.hasFireSalts = this.inv.getInv().contains(this.REFSALTS);
        this.hasSpruce = this.inv.getInv().contains(this.REFSPRUCE);
        this.hasMandrake = this.inv.getInv().contains(this.REFMANDRAKE);
        this.hasBottle = this.inv.getInv().contains(this.REFBTTL);
    }
/*----------------------------------------------------------------------------*/
    private boolean enchant() {
        
        if (this.hasBottle && this.hasFireSalts && this.hasMandrake && this.hasSpruce) {
            this.inv.remove(REFSALTS);
            this.inv.remove(REFSPRUCE);
            this.inv.remove(REFBTTL);
            this.inv.remove(REFMANDRAKE);
            this.inv.add(REF);
            return true;
        }
        return false;
    }
/*----------------------------------------------------------------------------*/
}
