package Library;

import A_Super.Book;

public class Lib_FinnishBook extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_FinnishBook(String name) {
        super(name, 4);
        
        
        PAGE_LIST[0] = "A Brief Guide to Finnish --\n" +
                       "Tomi\n" +
                       "Yhdeksänkymmentäseitsemänherkullistajäätelötötteröä\n";
        
        PAGE_LIST[1] = "Tervetuloa, and welcome to the secret world of the \n" +
                       "Finnish language! Let this volume be the ladder to \n" +
                       "dip your feet in the waters of Finnish. Spoken by\n" +
                       "only roughly 5.5 million people, Finnish is quite\n" +
                       "different from its neighboring languages Swedish,\n" +
                       "Russian, and Norwegien. These are Indo-European,\n" +
                       "like English. Finnish is not, but of the Finno-\n" +
                       "Ugric language family, like Hungarian. Without\n" +
                       "delving into the dry details too deeply, Finnish\n" +
                       "may be thought of as a language of building blocks,\n" +
                       "its technical term being 'agglutinative'. From\n" +
                       "many smaller morphemes and bases, quite long words\n" +
                       "may be formed. In fact, here is where the common\n" +
                       "definition of 'word' breaks down. Where English\n" +
                       "may have one word- dog, for instance, Finnish has\n" +
                       "a couple thousand variations of this word. We begin\n" +
                       "by discussing the basics of what forms a nominal.";
        
        PAGE_LIST[2] = "A nominal (noun or adjective primarily) may be\n" +
                       "inflected from its base. For example, the Finnish\n" +
                       "word 'koira' meaning dog may take the form 'koiralla'\n" +
                       "meaning 'on the dog'. This is a word case, and there \n" +
                       "are 15 of these to mean various simple prepositions. \n" +
                       "To this, we may affix yet another ending- 'koirallasi' \n" +
                       "meaning 'on your dog'. This new extension is a \n" +
                       "possessive suffix. There are 5 of these. To this, we \n" +
                        "may attach more particles. For example 'koirallasiko?'\n" +
                       "meaning 'on your dog?' and 'koirallasikinko?' meaning \n" +
                       "'on your dog also?' Verbs are similar. Consider \n" +
                       "the word 'käyttää' meaning 'to use'. Before \n" +
                       "inflecting this word, we change it into its \n" +
                       "inflectional stem 'käyttä-' From here, we may write \n" +
                       "'käytän' meaning 'I use'. There are 6 personal \n" +
                       "conjugations in Finnish. 4 moods can be used \n" +
                       "to further change the meaning. 'käyttäisin' meaning \n" +
                       "'I would use' and 'käyttänen' meaning 'I probably \n" +
                       "use' (rare). Particles apply to verbs as well. \n" +
                       "For example 'käyttäisinköhän?' meaning 'I wonder \n" +
                       "if I should use?'";
        
        PAGE_LIST[3] = "Together, using these rules, sentences can be build.\n" +
                       "'Tyttäreni juoksi me talomme ympärillä' which means\n" +
                       "'Our daughter ran around our house'. Quite literally,\n" +
                       "'Daugher(my) ran our house(our) around(on).\n" +
                       "Notice also, no articles are used and the preposition\n" +
                       "occurs after the noun (postposition), which is common.\n" +
                       "If a sentence is negative, the negation word 'ei' is\n" +
                       "used, which conjugates for person. For example-\n" +
                       "'Tässä lasissa ei ole yhtään oluen pisaraakaan!' or\n" +
                       "'There is not even a drop of beer in this glass!'\n"
                     + "More literally, \"This(in) glass(in) not is even\n"
                     + "beer's drop(at all)!\"\n" +
                       "Lastly, to lay down a hard fact for the reader -\n" +
                       "Finlandia is not the Finnish word for Finland.\n" +
                       "In fact, Finnish does not natively use 'f', nor\n" +
                       "'b', 'c', 'q', 'w', 'x', or 'z'.";
    }
/*----------------------------------------------------------------------------*/
}

