package Parlor;

import A_Super.Book;
/**
 * Explains how to create a mandragora, needed to create the enchanted bottle.
 * 
 * @see Parlor.Par1_Door
 * @see Parlor.Par1_FirePlace
 * @author Kevin Rapa
 */
public class Par_MandrakeBook extends Book {
// CONSTRUCTOR ================================================================
    public Par_MandrakeBook(String name) {
        super(name, 4);
        
        PAGE_LIST[0] = "\"The Care of Mandragora\"";
        
        PAGE_LIST[1] = "Mandragora, modernized as mandrake, is a genus of root. In stories "
                     + "these are described as sentient creatures remembling roots that are "
                     + "grown, though this is fictional. Mandrakes are delicate and prefer "
                     + "to be grown by themselves in a single pot filled with fertile soil. "
                     + "Any medium pot should suffice though. Mandrakes prefer well-drained soil, "
                     + "so watering is only necessary every few days.";
        
        PAGE_LIST[2] = "To begin growing your "
                     + "mandrake, simply mix together some soil, sand, and fertilizer. "
                     + "The sand is important to keep the mixture aerated. Fill a pot with "
                     + "the mixture, leaving about an inch of clearance. Then, rest the juvenile mandragora in the pot just "
                     + "under the surface. From there, all that's needed is some initial "
                     + "watering, and the rain will do the rest. Just make sure to leave it "
                     + "outside. Within a month, your mandragora should be fully mature. "
                     + "Mandragora are known to have a very pleasant taste when cooked. "
                     + "Mandragora are also used in certain alchemical and enchanting recipes, "
                     + "but that is beyond the scope of this book.";
        
        PAGE_LIST[3] = "This page is blank except for a single line- \"-Experiment more "
                     + "with holy water. Faster than regular watering.\"";
    }
//-----------------------------------------------------------------------------
}

