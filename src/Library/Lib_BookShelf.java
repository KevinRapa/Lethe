package Library;

import A_Super.Furniture;

public class Lib_BookShelf extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_BookShelf() {
        super();

        this.description = "There are a couple of bookshelves in here. Specify\n"
                         + "with just the label at the top or a direction.";
        this.searchDialog = this.description;
        this.actDialog = this.description;
        this.addNameKeys("(?:book)?shel(?:f|ves)");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}