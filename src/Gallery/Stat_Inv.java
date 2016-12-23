package Gallery;

import A_Main.Inventory;
import A_Super.Item;
import A_Main.GUI;

public class Stat_Inv extends Inventory{
    private final Gal_1E_Stat REF;  
    private Gal1_Drgn REF2;  
    
    public Stat_Inv(Gal_1E_Stat stat, Item ... items) {
        super(items);
        this.REF = stat;
    }
/*----------------------------------------------------------------------------*/
    @Override public boolean add(Item item) {
        this.CONT.add(item);
        if (item.toString().matches("crystal orb"))
            GUI.out(REF.activate(REF2.getBeam(), REF2));
        
        return true;
    }
/*----------------------------------------------------------------------------*/
    public void addDrgnREF(Gal1_Drgn drgn) {
        this.REF2 = drgn;
    }
/*----------------------------------------------------------------------------*/
}