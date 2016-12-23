package Parlor;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Par_BkEncht extends Book {
    private final String pg1, pg2, pg3, pg4;
 
// CONSTRUCTOR ================================================================
    public Par_BkEncht(String name) {
        super(name, 4);
        
        pg1 = "\"Enchanting for the Naive\" -- by Wendell Fancycape";
        
        pg2 = "Let me guess- you're already bored and ready to slam this book\n"
            + "shut. Believe me, you are just like every other student of\n"
            + "enchanting; naive, thinking you're exceptionally skilled.\n"
            + "Perhaps you are. But more than likely, you're not. Enchanting\n"
            + "is not a mere hobby, or even an art, but a science. Magic is no\n"
            + "such thing, for if it were, no one would understand it, and thus\n"
            + "this book would not exist. Enchanting is closer to cooking than\n"
            + "anything else... except perhaps baking, in that a strict recipe\n"
            + "should be followed. As a student, you will fail many times from\n"
            + "wrong or ill-prepared ingredients. Ninety-nine percent of the time,\n"
            + "your failures will be anti-climactic and dull. In the unlucky one\n"
            + "percent, you just might set fire to something or bend the fabric\n"
            + "of space itself. As such, I persuade you to read this book.";
        
        pg3 = "Most of all novice enchanting recipes require three or four\n"
            + "ingredients. One of these ingredients is the 'subject' of the\n"
            + "enchanting, or the primary ingredient. The rest are auxiliary,\n"
            + "which serve to modify the subject. It is important that the subject\n"
            + "be in the center of the table, with the auxiliary ingredients on\n"
            + "the perimeter of the binding ring. Most enchanting tables will\n"
            + "have a marker in the center, with a circle, about 2 feet wide,\n"
            + "surrounding it. In fact, the more perfect the circle, the better the\n"
            + "table. Many artisan enchanting tables have been inspected and graded\n"
            + "by this quality. To get straight to the matter at hand, the next\n"
            + "step is the binding...";
        
        pg4 = "The binding process is straightforward, but you must have a steady\n"
            + "mind at this point. The bind must be done in one motion, without\n"
            + "hesitation. You will be startled the first time. To execute the bind,\n"
            + "with all ingredients properly in place, pound the table with your fists\n"
            + "on the foci. The foci are etched circles on the front corners of the\n"
            + "table. Pound firmly; as hard as possible without jostling the table.\n"
            + "It is important that the ingredients not move. The enchant will be\n"
            + "accompanied by a lound bang and a puff of smoke. The smoke is added\n"
            + "to the table's mechanism as a special effect, and is actually\n"
            + "uneccessary for a proper bind. This is the only plague of the science\n"
            + "to date, for true enchanters do not yearn for superfluous effects.";
        
        this.pageList[0] = this.pg1;
        this.pageList[1] = this.pg2;
        this.pageList[2] = this.pg3;
        this.pageList[3] = this.pg4;
    }
// ============================================================================
}

