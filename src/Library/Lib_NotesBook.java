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
        PAGE_LIST[1] = "With the constant burden of responsibility today- " +
                       "milking the cow, witch reporting, bringing out your " +
                       "dead- many of us feel as though we are forgetting " +
                       "something all the time in this modern way of life. " +
                       "Constantly now it seems the courier visits the " +
                       "village to deliver more news. The amount of " +
                       "information traded today is incredible. However, " +
                       "think of those letters and documents the courier " +
                       "carries. He doesn't remember what's on them, that's " +
                       "what the paper is for!";
        
        PAGE_LIST[2] = "The village oaf can write on parchment with " +
                       "ink and understand their own words. To the commoner, " +
                       "writing notes to oneself may be a source of " +
                       "embarrassment. \"Who in their own mind need they " +
                       "write to? They have their own brain, correct?\" " +
                       "Writing momentos to one's self may seem akin to " +
                       "something disturbing like self-conversation. " +
                       "Think, however, how much less information would " +
                       "be bouncing wantonly in your head if you allowed " +
                       "the paper to hold it for you?";
        
        PAGE_LIST[3] = "If you feel forgetful, in a casual dementia, or " +
                       "even short of IQ, I encourage you leave notes " +
                       "around for yourself. You may then find your " +
                       "mind easing from the removal of the weight " +
                       "of remembering.";
    }
//-----------------------------------------------------------------------------
}

