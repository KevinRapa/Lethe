package Back_Balcony;

import Super.Furniture;

public class Bba_Sea extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Sea(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "Just an endless watery expanse.";
        this.searchDialog = "If your friends jumped off a cliff, would you too?";
        this.addNameKeys("sea", "ocean");
    }
/*----------------------------------------------------------------------------*/
}