package Library;

import Super.Furniture;

public class Lib_BkShlf extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_BkShlf(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "There are a lot of bookshelves in here. Specify\n"
                         + "with just the label at the top.";
        this.searchDialog = this.description;
        this.interactDialog = this.description;
        this.addNameKeys("bookshelf", "bookshelves", "shelf", "shelves");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}