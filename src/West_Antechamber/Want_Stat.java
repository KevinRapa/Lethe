package West_Antechamber;

import Super.Furniture;
import Super.Room;

public class Want_Stat extends Furniture{
    private final Furniture REF;
    private final Room REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Stat(Furniture lvr, Room want) {
        super();
        this.REF = lvr;
        this.REF2 = want;
        this.searchable = false;
        this.description = "Inspecting each statue, you discover each to be\n" +
                           "depicting an Egyptian god. There's Anubis, god \n" +
                           "of the dead, Isis, goddess of magic, Thoth, god of\n" +
                           "wisdom, and Wadjet, goddess of protection. You\n" +
                           "notice what appears to be a lever attached to\n" +
                           "the base of one of them.";
        this.searchDialog = "They are plain statues. Upon closer inspection\n"
                          + "of one though, you find a lever hidden.";
        this.interactDialog = "You feel a statue, but you are discomforted in thinking\n"
                            + "that somehow, the other statues may be watching you.";
        this.addActKeys("touch", "feel", "grab");
        this.addNameKeys("statue", "statues");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        REF2.addFurniture(REF);
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        REF2.addFurniture(REF);
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
