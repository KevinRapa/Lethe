package Iron_Hall;

import Super.Item;
import Super.Key;
import Super.Furniture;

public class Iha1_Bwl extends Furniture {
    private final Furniture REF;
    private final Key REF2;
    private boolean jabbed;
    public Iha1_Bwl(String NAME, Furniture iha1F, Key wow2Key) {
            super(NAME);
            this.searchable = false;
            this.jabbed = false;
            this.addUseKeys("polearm");
            this.addNameKeys("bowl", "steel bowl", "hanging bowl");
            this.REF = iha1F;
            this.REF2 = wow2Key;
            this.description = "It's a steel bowl hanging from the ceiling by a\n"
                             + "chain. A draft from the outside causes it to swing\n"
                             + "gently. As it rocks, you hear it rattle a little.";
            this.searchDialog = "It's too high up to see if there's anything inside.";
            this.useDialog = "You give the hanging bowl a jab with the pole.\n"
                           + "A small piece of metal falls out onto the floor.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = this.useDialog;

        if (! this.jabbed) {
            REF.getInv().add(REF2);
            this.inv.remove(REF2); 
            this.jabbed = true;
        }
        else 
            rep = "You jab the bowl, but nothing falls out.";
        
        return rep;
    }

}
