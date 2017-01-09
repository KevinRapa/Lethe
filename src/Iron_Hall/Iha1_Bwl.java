package Iron_Hall;

import A_Super.Item;
import A_Super.Key;
import A_Super.Furniture;

public class Iha1_Bwl extends Furniture {
/*----------------------------------------------------------------------------*/
    private final Furniture FLOOR_REF;
    private final Key WOWKEY_REF;
    private boolean jabbed;
    public Iha1_Bwl(Furniture iha1F, Key wow2Key) {
            super();
            this.searchable = false;
            this.jabbed = false;
            this.addUseKeys("polearm");
            this.addNameKeys("(?:hanging )?(?:burning )?(?:steel )?bowl(?: of fire)?");
            this.FLOOR_REF = iha1F;
            this.WOWKEY_REF = wow2Key;
            this.description = "It's a steel bowl hanging from the ceiling by a\n"
                             + "chain. A draft from the outside causes it to swing\n"
                             + "gently. As it rocks, you hear it rattle a little.";
            this.searchDialog = "It's too high up to see if there's anything inside.";
            this.useDialog = "You give the hanging bowl a jab with the pole.\n"
                           + "A small piece of metal falls out onto the floor.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (! this.jabbed) {
            this.inv.give(WOWKEY_REF, FLOOR_REF.getInv()); 
            this.jabbed = true;
            return this.useDialog;
        }
        else 
            return "You jab the bowl, but nothing falls out.";
    }
/*----------------------------------------------------------------------------*/
}
