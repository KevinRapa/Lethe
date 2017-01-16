package Library;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
        
public class Lib2_Vyg extends Furniture {
    private final Furniture REF, REF2, REF3, REF4;
    private boolean moved;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib2_Vyg(Furniture wrfr, Furniture crtn, Furniture prdtn, Furniture bnshmnt, Item... items) {
        super(items);
        this.REF = wrfr;
        this.REF2 = crtn;
        this.REF3 = prdtn;
        this.REF4 = bnshmnt;
        this.moved = false;
        this.actDialog = "You push against the shelf, but it doesn't budge.";
        this.description = "The tall bookshelf bears a plaque on the top reading\n"
                         + "\"Voyage\". At its base on the right, you notice\n"
                         + "consistent arched scratches on the floor.";
        this.searchDialog = "You peruse its shelves.";
        this.addNameKeys("voyage", "voyage (?:book)?shelf");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {              
        String rep = this.actDialog;
        
        if (this.containsItem("epic tome") && REF.containsItem("greek tome") &&
            REF2.containsItem("biblical tome") && REF3.containsItem("infernal tome") &&
            REF4.containsItem("divine tome") && ! this.moved) {
            Lib2 lib2 = (Lib2)Player.getRoomObj(Id.LIB2);
            lib2.addAdjacent(Id.LIB1);
            lib2.moveShelf();
            this.moved = true;           
            rep = "You push against the shelf. To your wonder, the shelf slowly\n"
                + "swivels clockwise on its center axis, revealing a hidden room.";
        }
        return rep;          
    }
/*----------------------------------------------------------------------------*/   
}
