package Library;

import Super.Book;

public class Lib_Bbl extends Book {
    private final String pg1, pg2, pg3;

/* CONSTRUCTOR ---------------------------------------------------------------*/      
    public Lib_Bbl(String name) {
        super(name, 3);
        
        pg1 = "The Book of Genesis is the first chapter in the Old Testament of\n" +
              "the Christian Bible. This book narrates the creation of the world\n" +
              "along with the first man and woman by God.\n\n\n" +
              
              "[1:1] In the beginning when God created the heavens and the earth,\n" +
              "[1:2] the earth was a formless void and darkness covered the face \n" +
              "      of the deep, while a wind from God swept over the face of the \n" +
              "      waters.\n" +
              "[1:3] Then God said, \"Let there be light\"; and there was light.\n" +
              "[1:4] And God saw that the light was good; and God separated the \n" +
              "      light from the darkness.\n" +
              "[1:5] God called the light Day, and the darkness he called Night. \n" +
              "      And there was evening and there was morning, the first day.\n" +
              "[1:6] And God said, \"Let there be a dome in the midst of the waters, \n" +
              "      and let it separate the waters from the waters.\"\n" +
              "[1:7] So God made the dome and separated the waters that were under \n" +
              "      the dome from the waters that were above the dome. And it was so.\n" +
              "[1:8] God called the dome Sky. And there was evening and there was \n" +
              "      morning, the second day.\n" +
              "[1:9] And God said, \"Let the waters under the sky be gathered together \n" +
              "      into one place, and let the dry land appear.\" And it was so.\n" +
              "[1:10] God called the dry land Earth, and the waters that were gathered \n" +
              "       together he called Seas. And God saw that it was good.";
        
        pg2 = "[1:11] Then God said, \"Let the earth put forth vegetation: plants \n" +
              "       yielding seed, and fruit trees of every kind on earth that bear \n" +
              "       fruit with the seed in it.\" And it was so.\n" +
              "[1:12] The earth brought forth vegetation: plants yielding seed of every \n" +
              "       kind, and trees of every kind bearing fruit with the seed in it. \n" +
              "       And God saw that it was good.\n" +
              "[1:13] And there was evening and there was morning, the third day.\n" +
              "[1:14] And God said, \"Let there be lights in the dome of the sky to \n" +
              "       separate the day from the night; and let them be for signs and \n" +
              "       for seasons and for days and years,\n" +
              "[1:15] and let them be lights in the dome of the sky to give light upon \n" +
              "       the earth.\" And it was so.\n" +
              "[1:16] God made the two great lights - the greater light to rule the day \n" +
              "       and the lesser light to rule the night - and the stars.\n" +
              "[1:17] God set them in the dome of the sky to give light upon the earth,\n" +
              "[1:18] to rule over the day and over the night, and to separate the light \n" +
              "       from the darkness. And God saw that it was good.\n" +
              "[1:19] And there was evening and there was morning, the fourth day.\n" +
              "[1:20] And God said, \"Let the waters bring forth swarms of living \n" +
              "       creatures, and let birds fly above the earth across the dome of \n" +
              "       the sky.\"";
        
        pg3 = "[1:21] So God created the great sea monsters and every living creature that \n" +
              "       moves, of every kind, with which the waters swarm, and every winged \n" +
              "       bird of every kind. And God saw that it was good.\n" +
              "[1:22] God blessed them, saying, \"Be fruitful and multiply and fill the \n" +
              "       waters in the seas, and let birds multiply on the earth.\"\n" +
              "[1:23] And there was evening and there was morning, the fifth day.\n" +
              "[1:24] And God said, \"Let the earth bring forth living creatures of every \n" +
              "       kind: cattle and creeping things and wild animals of the earth of \n" +
              "       every kind.\" And it was so.\n" +
              "[1:25] God made the wild animals of the earth of every kind, and the cattle \n" +
              "       of every kind, and everything that creeps upon the ground of every \n" +
              "       kind. And God saw that it was good.\n" +
              "[1:26] Then God said, \"Let us make humankind in our image, according to our \n" +
              "       likeness; and let them have dominion over the fish of the sea, and \n" +
              "       over the birds of the air, and over the cattle, and over all the wild \n" +
              "       animals of the earth, and over every creeping thing that creeps upon \n" +
              "       the earth.\"\n" +
              "[1:27] So God created humankind in his image, in the image of God he created \n" +
              "       them; male and female he created them.\n" +
              "[1:28] God blessed them, and God said to them, \"Be fruitful and multiply, \n" +
              "       and fill the earth and subdue it; and have dominion over the fish of \n" +
              "       the sea and over the birds of the air and over every living thing \n" +
              "       that moves upon the earth.\"\n" +
              "[1:29] God said, \"See, I have given you every plant yielding seed that is \n" +
              "       upon the face of all the earth, and every tree with seed in its \n" +
              "       fruit; you shall have them for food.\n" +
              "[1:30] And to every beast of the earth, and to every bird of the air, and \n" +
              "       to everything that creeps on the earth, everything that has the \n" +
              "       breath of life, I have given every green plant for food.\" And it \n" +
              "       was so.\n" +
              "[1:31] God saw everything that he had made, and indeed, it was very good. \n" +
              "       And there was evening and there was morning, the sixth day.\n" +
              "\n" +
              "... Wait. You didn't come to this castle just to read, did you?";
        
        this.pageList[0] = this.pg1;
        this.pageList[1] = this.pg2;
        this.pageList[2] = this.pg3;
    }
/*----------------------------------------------------------------------------*/
}
