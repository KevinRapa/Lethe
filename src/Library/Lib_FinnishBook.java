package Library;

import A_Super.Book;

public class Lib_FinnishBook extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_FinnishBook(String name) {
        super(name, 4);
        
        
        PAGE_LIST[0] = "A Brief Guide to Finnish -- " +
                       "Tomi " +
                       "Yhdeksänkymmentäseitsemänherkullistajäätelötötteröä ";
        
        PAGE_LIST[1] = "Tervetuloa, and welcome to the secret world of the  " +
                       "Finnish language! Let this volume be the ladder to  " +
                       "dip your feet in the waters of Finnish. Spoken by " +
                       "only roughly 5.5 million people, Finnish is quite " +
                       "different from its neighboring languages Swedish, " +
                       "Russian, and Norwegien. These are Indo-European, " +
                       "like English. Finnish is not, but of the Finno- " +
                       "Ugric language family, like Hungarian. Without " +
                       "delving into the dry details too deeply, Finnish " +
                       "may be thought of as a language of building blocks, " +
                       "its technical term being 'agglutinative'. From " +
                       "many smaller morphemes and bases, quite long words " +
                       "may be formed. In fact, here is where the common " +
                       "definition of 'word' breaks down. Where English " +
                       "may have one word- dog, for instance, Finnish has " +
                       "a couple thousand variations of this word. We begin " +
                       "by discussing the basics of what forms a nominal.";
        
        PAGE_LIST[2] = "A nominal (noun or adjective primarily) may be " +
                       "inflected from its base. For example, the Finnish " +
                       "word 'koira' meaning dog may take the form 'koiralla' " +
                       "meaning 'on the dog'. This is a word case, and there  " +
                       "are 15 of these to mean various simple prepositions.  " +
                       "To this, we may affix yet another ending- 'koirallasi'  " +
                       "meaning 'on your dog'. This new extension is a  " +
                       "possessive suffix. There are 5 of these. To this, we  " +
                        "may attach more particles. For example 'koirallasiko?' " +
                       "meaning 'on your dog?' and 'koirallasikinko?' meaning  " +
                       "'on your dog also?' Verbs are similar. Consider  " +
                       "the word 'käyttää' meaning 'to use'. Before  " +
                       "inflecting this word, we change it into its  " +
                       "inflectional stem 'käyttä-' From here, we may write  " +
                       "'käytän' meaning 'I use'. There are 6 personal  " +
                       "conjugations in Finnish. 4 moods can be used  " +
                       "to further change the meaning. 'käyttäisin' meaning  " +
                       "'I would use' and 'käyttänen' meaning 'I probably  " +
                       "use' (rare). Particles apply to verbs as well.  " +
                       "For example 'käyttäisinköhän?' meaning 'I wonder  " +
                       "if I should use?'";
        
        PAGE_LIST[3] = "Together, using these rules, sentences can be build. " +
                       "'Tyttäreni juoksi me talomme ympärillä' which means " +
                       "'Our daughter ran around our house'. Quite literally, " +
                       "'Daugher(my) ran our house(our) around(on). " +
                       "Notice also, no articles are used and the preposition " +
                       "occurs after the noun (postposition), which is common. " +
                       "If a sentence is negative, the negation word 'ei' is " +
                       "used, which conjugates for person. For example- " +
                       "'Tässä lasissa ei ole yhtään oluen pisaraakaan!' or " +
                       "'There is not even a drop of beer in this glass!' "
                     + "More literally, \"This(in) glass(in) not is even "
                     + "beer's drop(at all)!\" " +
                       "Lastly, to lay down a hard fact for the reader - " +
                       "Finlandia is not the Finnish word for Finland. " +
                       "In fact, Finnish does not natively use 'f', nor " +
                       "'b', 'c', 'q', 'w', 'x', or 'z'.";
    }
/*----------------------------------------------------------------------------*/
}

