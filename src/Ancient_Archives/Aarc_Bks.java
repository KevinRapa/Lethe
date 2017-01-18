package Ancient_Archives;

import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Aarc_Bks extends Aarc_Furniture {
    // ========================================================================
    public Aarc_Bks (Item... items) {
        super(items);
        
        this.description = "Much of the wooden rubble here, once bookshelves,\n"
                         + "have toppled over leaving piles of books everywhere. The books\n"
                         + "have pretty much all succumbed to water damage.";
        this.actDialog = "There are a lot of books here... And the ones you can see are ruined.";
        this.searchDialog = "You pick through the piles of books.";

        this.addNameKeys("books");
        this.addActKeys("read");
    }
    // ========================================================================   
}


