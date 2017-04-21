package Back_Balcony;

import A_Super.Furniture;

public class Bba_Sea extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Sea() {
        super();
        this.description = "Just an endless black expanse.";
        this.actDialog = "Well, if you were to jump down there, your problems would be gone in a way..";
        this.searchDialog = "If your friends jumped off a cliff, would you too?";
        this.addNameKeys("sea", "ocean", "waves");
        this.addActKeys("drink", "swim");
    }
//-----------------------------------------------------------------------------
}