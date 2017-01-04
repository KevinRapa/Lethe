package Library;

import A_Super.Furniture;

public class Lib_BkShlf extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib_BkShlf() {
        super();
        this.searchable = false;
        this.description = "There are a lot of bookshelves in here. Specify\n"
                         + "with just the label at the top.";
        this.searchDialog = this.description;
        this.actDialog = this.description;
        this.addNameKeys("(?:book)?shel(?:f|ves)");
        this.addActKeys("push", "move", "rotate", "pull", "slide", "spin");
    }
/*----------------------------------------------------------------------------*/
}