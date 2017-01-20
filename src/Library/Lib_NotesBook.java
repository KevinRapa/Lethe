package Library;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Lib_NotesBook extends Book {
// CONSTRUCTOR ================================================================
    public Lib_NotesBook(String name) {
        super(name, 4);

        PAGE_LIST[0] = "\"Note to self- a Book On Note Therapy\"";
        PAGE_LIST[1] = "With the constant burden of responsibility today-\n" +
                       "milking the cow, witch reporting, bringing out your\n" +
                       "dead- many of us feel as though we are forgetting\n" +
                       "something all the time in this modern way of life.\n" +
                       "Constantly now it seems the courier visits the\n" +
                       "village to deliver more news. The amount of\n" +
                       "information traded today is incredible. However,\n" +
                       "think of those letters and documents the courier\n" +
                       "carries. He doesn't remember what's on them, that's\n" +
                       "what the paper is for!";
        
        PAGE_LIST[2] = "The village oaf can write on parchment with\n" +
                       "ink and understand their own words. To the commoner,\n" +
                       "writing notes to oneself may be a source of\n" +
                       "embarrassment. \"Who in their own mind need they\n" +
                       "write to? They have their own brain, correct?\"\n" +
                       "Writing momentos to one's self may seem akin to\n" +
                       "something disturbing like self-conversation.\n" +
                       "Think, however, how much less information would\n" +
                       "be bouncing wantonly in your head if you allowed\n" +
                       "the paper to hold it for you?";
        
        PAGE_LIST[3] = "If you feel forgetful, in a casual dementia, or\n" +
                       "even short of IQ, I encourage you leave notes\n" +
                       "around for yourself. You may then find your\n" +
                       "mind easing from the removal of the weight\n" +
                       "of remembering.";
    }
// ============================================================================
}

