package Ancient_Archives;

import A_Main.Player;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Books extends Aarc_Furniture implements Gettable {
    private final Item BOOK_REF;
    //-------------------------------------------------------------------------
    public Aarc_Books (Item book, Item... items) {
        super(items);
        
        this.BOOK_REF = book;
        
        this.description = "Much of the wooden rubble here, once bookshelves, "
                         + "have toppled over leaving piles of books everywhere. The books "
                         + "have pretty much all succumbed to water damage.";
        
        this.actDialog = "There are a lot of books here... And the ones you can see are destroyed.";
        this.searchDialog = "You pick through the piles of books.";

        this.addNameKeys("books?");
        this.addActKeys(GETPATTERN, "read");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {
        if (key.equals("read"))
            return this.actDialog;
        else
            return getIt();
    }
    //-------------------------------------------------------------------------   
    @Override public String getIt() {
        if (Player.getInv().add(BOOK_REF))
            return "You take one of the books, not giving much thought about it.";
        else
            return NOTHING;
    }
    //-------------------------------------------------------------------------   
}


