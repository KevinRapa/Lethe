package Library;

import A_Super.Book;

public class Lib_Ill extends Book {
    private final String pg1, pg2, pg3;

/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_Ill(String name) {
        super(name, 3);
        
        pg1 = "The Iliad is an epic poem originally written in Homerian\n" +
              "Greek by the eponymous Homer. Set during the Trojan War,\n" +
              "it details the events of warfare during the fight between\n" +
              "King Agamemnon and the warrior Achilles and the siege of Troy.\n" +
              "\n" +
              "\n" +
              "Sing, O goddess, the anger of Achilles son of Peleus, that \n" +
              "brought countless ills upon the Achaeans. Many a brave soul \n" +
              "did it send hurrying down to Hades, and many a hero did it \n" +
              "yield a prey to dogs and vultures, for so were the counsels \n" +
              "of Jove fulfilled from the day on which the son of Atreus, \n" +
              "king of men, and great Achilles, first fell out with one \n" +
              "another. \n" +
              "\n" +
              "And which of the gods was it that set them on to quarrel? \n" +
              "It was the son of Jove and Leto; for he was angry with the \n" +
              "king and sent a pestilence upon the host to plague the \n" +
              "people, because the son of Atreus had dishonoured Chryses \n" +
              "his priest. Now Chryses had come to the ships of the \n" +
              "Achaeans to free his daughter, and had brought with him a \n" +
              "great ransom: moreover he bore in his hand the sceptre of \n" +
              "Apollo wreathed with a suppliant's wreath and he besought \n" +
              "the Achaeans, but most of all the two sons of Atreus, who \n" +
              "were their chiefs. ";
        
        pg2 = "\"Sons of Atreus,\" he cried, \"and all other Achaeans, may \n" +
              "the gods who dwell in Olympus grant you to sack the city \n" +
              "of Priam, and to reach your homes in safety; but free my \n" +
              "daughter, and accept a ransom for her, in reverence to \n" +
              "Apollo, son of Jove.\" \n" +
              "\n" +
              "On this the rest of the Achaeans with one voice were for \n" +
              "respecting the priest and taking the ransom that he offered; \n" +
              "but not so Agamemnon, who spoke fiercely to him and sent \n" +
              "him roughly away. \"Old man,\" said he, \"let me not find you \n" +
              "tarrying about our ships, nor yet coming hereafter. Your \n" +
              "sceptre of the god and your wreath shall profit you nothing. \n" +
              "I will not free her. She shall grow old in my house at Argos \n" +
              "far from her own home, busying herself with her loom and \n" +
              "visiting my couch; so go, and do not provoke me or it shall \n" +
              "be the worse for you.\" \n" +
              "\n" +
              "The old man feared him and obeyed. Not a word he spoke, but \n" +
              "went by the shore of the sounding sea and prayed apart to \n" +
              "King Apollo whom lovely Leto had borne. \"Hear me,\" he cried, \n" +
              "\"O god of the silver bow, that protectest Chryse and holy \n" +
              "Cilla and rulest Tenedos with thy might, hear me oh thou of \n" +
              "Sminthe. If I have ever decked your temple with garlands, or \n" +
              "burned your thigh-bones in fat of bulls or goats, grant my \n" +
              "prayer, and let your arrows avenge these my tears upon the \n" +
              "Danaans.\" ";
        
        pg3 = "Thus did he pray, and Apollo heard his prayer. He came down \n" +
              "furious from the summits of Olympus, with his bow and his \n" +
              "quiver upon his shoulder, and the arrows rattled on his back \n" +
              "with the rage that trembled within him. He sat himself down \n" +
              "away from the ships with a face as dark as night, and his \n" +
              "silver bow rang death as he shot his arrow in the midst of \n" +
              "them. First he smote their mules and their hounds, but \n" +
              "presently he aimed his shafts at the people themselves, \n" +
              "and all day long the pyres of the dead were burning. \n" +
              "\n" +
              "For nine whole days he shot his arrows among the people, but \n" +
              "upon the tenth day Achilles called them in assembly- moved \n" +
              "thereto by Juno, who saw the Achaeans in their death-throes \n" +
              "and had compassion upon them. Then, when they were got \n" +
              "together, he rose and spoke among them. \n" +
              "\n" +
              "\"Son of Atreus,\" said he, \"I deem that we should now turn \n" +
              "roving home if we would escape destruction, for we are being \n" +
              "cut down by war and pestilence at once. Let us ask some priest \n" +
              "or prophet, or some reader of dreams (for dreams, too, are of \n" +
              "Jove) who can tell us why Phoebus Apollo is so angry, and say \n" +
              "whether it is for some vow that we have broken, or hecatomb \n" +
              "that we have not offered, and whether he will accept the savour \n" +
              "of lambs and goats without blemish, so as to take away the \n" +
              "plague from us.\"" +
              "\n" +
              "... Wait. You didn't come to this castle just to read, did you?";
        
        this.pageList[0] = this.pg1;
        this.pageList[1] = this.pg2;
        this.pageList[2] = this.pg3;
    }
/*----------------------------------------------------------------------------*/
}
