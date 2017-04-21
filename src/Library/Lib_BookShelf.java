package Library;

import A_Super.Furniture;

public class Lib_BookShelf extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_BookShelf() {
        super();

        this.description = "There are a couple of bookshelves in here. You will "
                         + "need to be a bit more specific.";
        this.searchDialog = this.description;
        this.actDialog = this.description;
        this.addNameKeys("(?:book)?shel(?:f|ves)");
        this.addActKeys(MOVEPATTERN);
    }
//-----------------------------------------------------------------------------
}