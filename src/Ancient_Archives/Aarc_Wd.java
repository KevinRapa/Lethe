package Ancient_Archives;
/**
 * @author Kevin Rapa
 */
public class Aarc_Wd extends Aarc_Furniture {
    // ========================================================================
    public Aarc_Wd () {
        super();
        this.searchable = false;
        
        this.description = "Most of the wooden rubble resembles old bookshelves,\n"
                         + "although you also uncover what appears to be an old\n"
                         + "drawered desk.";
        this.searchDialog = this.description;
       
        this.addNameKeys("(?:piles of )?wood(?:en)?(?: rubble)?");
    }
    // ========================================================================   
}


