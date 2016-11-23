package Gallery;

import Super.Furniture;

public class Gal3_Art3 extends Furniture {

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Art3(String NAME) {
        super(NAME);
        this.searchable = false;
        this.description = "It's a small terracotta statue. It depicts a sitting\n"
                         + "female with large lips, wide open eyes, and detailed\n"
                         + "hair. Next to it, a small label reads: \"Nok\".";
        this.addNameKeys("trinket", "nigerian trinket");
/*----------------------------------------------------------------------------*/
    }
}
