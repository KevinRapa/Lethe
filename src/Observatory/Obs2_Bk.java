package Observatory;

import A_Super.Book;
/**
 * @author Kevin Rapa
 */
public class Obs2_Bk extends Book {
    private final String pg1, pg2, pg3, pg4, pg5, pg6, pg7, pg8, pg9;
// CONSTRUCTOR ================================================================
    public Obs2_Bk(String name) {
        super(name, 9);
        
        pg1 = "Hermes, son of Zues, is known as the god of financial gain \n" +
              "and commerce. He is described as a messenger as well, having\n" +
              "known to guide souls to the underworld and afterlife. He is\n" +
              "one of the twelve olympians- a god of the Greek pantheon\n" +
              "(the set of principal dieties). He is romanized under the\n" +
              "name Mercury, and is commonly depicted wearing sandals\n" +
              "and/or a winged helmet.";
        
        pg2 = "Aphrodite, the goddess of beauty, is the daughter of Zeus and\n" +
              "Dione. A second myth on her origin tells her as having been\n" +
              "born of the sea when Kronos cut Uranus' genitals off and threw\n" +
              "them into the ocean. Her Roman equivalent is Venus. The famous\n" +
              "work \"The Birth of Venus\" depicts her standing on a sea-shell,\n" +
              "and did indeed familiarize her likeness with many.";
        
        pg3 = "Before the titans, the universe was still governed under law\n" +
              "by a few. Gaea was one such goddess. Known as the goddess of\n" +
              "fertility, she is considered the mother of everything, and\n" +
              "coexisted with Chaos and Eros during the creation of Earth.\n" +
              "Her Romanized name is Terra, a stem which to this date means\n" +
              "\"Earth\".";
        
        pg4 = "Ares, better known by the Roman name \"Mars\", is well known to\n" +
              "be the God of war, specifically the violent aspect. Though\n" +
              "one of the virtues of war is valor, Ares did not necessarily\n" +
              "embody this. Thus, he was looked upon partially by Greeks.\n" +
              "His likeness is characterized by soldier's garb, and it is\n" +
              "not uncommon to see him holding a spear and shield.";
        
        pg5 = "Zeus is perhaps the most famous Greek God, and understandably\n" +
              "so, for he served as the king of Gods on Mount Olympus. He was\n" +
              "profilific as well, having born over 25 offspring. In fact,\n" +
              "his promiscuity is a source of humor in Greek mythology. On such\n" +
              "story is that of Perseus' birth, child of Danae, whose birth\n" +
              "birth resulted from Zeus showering down into Danae's womb as a\n" +
              "shower of golden coins. Zeus is commonly seen holding a bolt\n" +
              "of lightning. His Roman equivalent is Jupiter.";
        
        pg6 = "Kronos or Cronus, known in the cosmos as Saturn, is the\n" +
              "youngest of the Greek titans. As myth tells, Kronos\n" +
              "castrated his father Uranus with a sickle, having been\n" +
              "persuaded by Gaea, whose children Uranus imprisoned.\n" +
              "However, though Kronos' children were freed, the monster\n" +
              "children Cyclopes and Hecatonchires were re-imprisoned.\n" +
              "Following this, Kronos served as king of the world with\n" +
              "Rhea for a period known as the \"Golden Age\".";
        
        pg7 = "Uranus is the only planet whose name is derived from a Greek\n" +
              "name. Otherwise, the planet would had been known as Caelus.\n" +
              "According to Hesiod, Uranus was the son of Gaea, yet mated\n" +
              "with her as well to create the twelve titans. He hated his\n" +
              "offspring, and imprisoned them in Tartarus. He was overthrown\n" +
              "and castrated by his son Kronos, having been persuaded to by\n" +
              "Gaea. His symbol is the staff.";
        
        pg8 = "Posiedon is the God of the sea and aquatic life. He is the\n" +
              "brother of Zeus and Hades. As myth tells, he was the creator\n" +
              "of the first horse, the product of an effort to create the\n" +
              "most beautiful animal in order to gain courtship with Demeter.\n" +
              "He is almost always depicted bearded and holding a trident. His\n" +
              "Roman equivalent is Neptune.";
        
        pg9 = "Helios is the sun God in Greek mythology. Born of the titans\n" +
              "Hyperion and Theia, Helios was know to ride a chariot pulled\n" +
              "by horses Aethon, Phlegon, Aeos, and Pyrios. His son Phaethon\n" +
              "set the Earth on fire after a failed attempt at piloting\n" +
              "the chariot. As the well-known myth tells, Phaethon wished\n" +
              "to drive the chariot after Helios promised to grant him\n" +
              "anything, as Phaethon was seeking a method to prove his\n" +
              "relation to the sun. His Roman name is Sol Invictus.";
        
        this.PAGE_LIST[0] = this.pg1;
        this.PAGE_LIST[1] = this.pg2;
        this.PAGE_LIST[2] = this.pg3;
        this.PAGE_LIST[3] = this.pg4;
        this.PAGE_LIST[4] = this.pg5;
        this.PAGE_LIST[5] = this.pg6;
        this.PAGE_LIST[6] = this.pg7;
        this.PAGE_LIST[7] = this.pg8;
        this.PAGE_LIST[8] = this.pg9;
    }
// ============================================================================
}

