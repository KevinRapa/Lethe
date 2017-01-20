package West_Antechamber;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Statue;

public class Want_Statue extends Statue {
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Want_Statue(Furniture lvr) {
        super();
        this.REF = lvr;
        this.description = "Inspecting each statue, you discover each to be\n" +
                           "depicting an Egyptian god. There's Anubis, god \n" +
                           "of the dead, Isis, goddess of magic, Thoth, god of\n" +
                           "wisdom, and Wadjet, goddess of protection. You\n" +
                           "notice what appears to be a lever attached to\n" +
                           "the base of one of them.";
        this.searchDialog = "They are plain statues. Upon closer inspection\n"
                          + "of one though, you find a lever hidden.";
        this.actDialog = "You feel a statue, but you are discomforted in thinking\n"
                            + "that somehow, the other statues may be watching you.";
        this.addNameKeys("statues");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (! Player.getRoomObj(Id.FOYW).hasFurniture(REF))
            Player.getRoomObj(Id.FOYW).addFurniture(REF);
        
        return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        if (! Player.getRoomObj(Id.FOYW).hasFurniture(REF))
            Player.getRoomObj(Id.FOYW).addFurniture(REF);
        
        return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/
}
