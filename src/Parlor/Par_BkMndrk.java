package Parlor;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Par_BkMndrk extends Book {
    private final String pg1, pg2, pg3, pg4;
 
// CONSTRUCTOR ================================================================
    public Par_BkMndrk(String name) {
        super(name, 4);
        
        pg1 = "\"The Care of Mandragora\"";
        
        pg2 = "Mandragora, modernized as mandrake, is a genus of root. In stories\n"
            + "these are described as sentient creatures remembling roots that are\n"
            + "grown, though this is fictional. Mandrakes are delicate and prefer\n"
            + "to be grown by themselves in a single pot filled with fertile soil.\n"
            + "Any medium pot should suffice though. Mandrakes prefer well-drained soil,\n"
            + "so watering is only necessary every few days.";
        
        pg3 = "To begin growing your\n"
            + "mandrake, simply mix together some soil, sand, and fertilizer.\n"
            + "The sand is important to keep the mixture aerated. Fill a pot with\n"
            + "the mixture, leaving about an inch of clearance. Then, rest the juvenile mandragora in the pot just\n"
            + "under the surface. From there, all that's needed is some initial\n"
            + "watering, and the rain will do the rest. Just make sure to leave it\n"
            + "outside. Within a month, your mandragora should be fully mature.\n"
            + "Mandragora are known to have a very pleasant taste when cooked.\n"
            + "Mandragora are also used in certian alchemical and enchanting recipes,\n"
            + "but that is beyond the scope of this book.";
        
        pg4 = "This page is blank except for a single line- \"-Experiment more\n"
            + "with holy water. Faster than regular watering.";
        
        this.PAGE_LIST[0] = this.pg1;
        this.PAGE_LIST[1] = this.pg2;
        this.PAGE_LIST[2] = this.pg3;
        this.PAGE_LIST[3] = this.pg4;
    }
// ============================================================================
}

