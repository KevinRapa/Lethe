package Parlor;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Par_BkMndrk extends Book {
// CONSTRUCTOR ================================================================
    public Par_BkMndrk(String name) {
        super(name, 4);
        
        PAGE_LIST[0] = "\"The Care of Mandragora\"";
        
        PAGE_LIST[1] = "Mandragora, modernized as mandrake, is a genus of root. In stories\n"
                     + "these are described as sentient creatures remembling roots that are\n"
                     + "grown, though this is fictional. Mandrakes are delicate and prefer\n"
                     + "to be grown by themselves in a single pot filled with fertile soil.\n"
                     + "Any medium pot should suffice though. Mandrakes prefer well-drained soil,\n"
                     + "so watering is only necessary every few days.";
        
        PAGE_LIST[2] = "To begin growing your\n"
                     + "mandrake, simply mix together some soil, sand, and fertilizer.\n"
                     + "The sand is important to keep the mixture aerated. Fill a pot with\n"
                     + "the mixture, leaving about an inch of clearance. Then, rest the juvenile mandragora in the pot just\n"
                     + "under the surface. From there, all that's needed is some initial\n"
                     + "watering, and the rain will do the rest. Just make sure to leave it\n"
                     + "outside. Within a month, your mandragora should be fully mature.\n"
                     + "Mandragora are known to have a very pleasant taste when cooked.\n"
                     + "Mandragora are also used in certian alchemical and enchanting recipes,\n"
                     + "but that is beyond the scope of this book.";
        
        PAGE_LIST[3] = "This page is blank except for a single line- \"-Experiment more\n"
                     + "with holy water. Faster than regular watering.\"";
    }
// ============================================================================
}

