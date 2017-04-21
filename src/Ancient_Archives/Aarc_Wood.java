package Ancient_Archives;

import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Wood extends Aarc_Furniture implements Gettable {
    private final Item WOOD_PIECE;
    //-------------------------------------------------------------------------
    public Aarc_Wood (Item wood) {
        super();
        
        this.WOOD_PIECE = wood;
        
        this.searchable = false;
        
        this.description = "Most of the wooden rubble resembles old bookshelves, "
                         + "although you also uncover what appears to be an old "
                         + "drawered desk.";
        this.searchDialog = this.description;
       
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:piles of )?wood(?:en)?(?: rubble)?", "(?:wood(?:en)? )?piles?");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        return getIt();
    }
    //-------------------------------------------------------------------------   
    @Override public String getIt() {
        if (Player.getInv().add(WOOD_PIECE))
            return "You take one of the books, not giving much thought about it.";
        else
            return NOTHING;
    }
    //-------------------------------------------------------------------------  
}


