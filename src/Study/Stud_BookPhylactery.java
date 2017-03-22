package Study;

import A_Main.Names;
import A_Super.Book;

public class Stud_BookPhylactery extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Stud_BookPhylactery(String name, int score) {
        super(name, 4);
        this.type = Names.PHYLACTERY;
        this.score = score;
        
        PAGE_LIST[0] = "- A Young Mind's Guide to Lichery -\n" +
                       "- by Melroth Gfrorgozh -";
        
        PAGE_LIST[1] = "Let this be a sequel to 'A Young Mind's Guide\n" +
                       "to Witchery.' It is expected that you have read\n" +
                       "this to serve as a foundation on which to build\n" +
                       "your skills in lichery. The craft of binding a\n" +
                       "soul to a physical object, a phylactery, is a\n" +
                       "form of witchcraft! Although lichs are commonly\n" +
                       "associated with the dead, lichery is by no means\n" +
                       "a form of necromancy. Before continuing, heed\n" +
                       "these warnings: first, the older the soul being\n" +
                       "bound, the weaker the soul will be. That means\n" +
                       "that the phylactery will begin to lose it's power\n" +
                       "sooner. Second, lichs are NOT immortal, however\n" +
                       "their life is extended tremendously. As your\n" +
                       "phylactery loses power, your soul deteriorates\n" +
                       "and so will you. Do not lust for immortality;\n" +
                       "unbind your soul when the time is right. This\n" +
                       "extends to the third warning- DO NOT lose\n" +
                       "your phylactery. If lost, you will be doomed\n" +
                       "to live eternally in a state of madness. Thus,\n" +
                       "the fewer phylacteries you create, the safer.\n" +
                       "Although more phylacteries means a longer-\n" +
                       "lasting bind.";
        
        PAGE_LIST[2] = "Before you begin, have your materials in order.\n" +
                       "You should have three to four tarkelies, an\n" +
                       "excess of karagaloos, five ounces of liquified\n" +
                       "feferium, and a mandrake root. First, distill\n" +
                       "the feferium and blend the root into a fine\n" +
                       "paste. Mix the mandrake paste into the distilled\n" +
                       "feferium, and then toss in a karagaloo or two\n" +
                       "and simmer for five minutes. The resulting \n" +
                       "mixture is called a psychordician- emulsion.\n" +
                       "Over a burner, heat the tarkelies and collect\n" +
                       "the evaporated vapor into the psychordician-\n" +
                       "emulsion flask to created the psychordician-\n" +
                       "emulsified- suspended- tarkelian- blend. Let\n" +
                       "the psychordician- emulsified- suspended- tarkelian-\n" +
                       "blend chill between 35 and 45 degrees fahrenheit\n" +
                       "for three days. At that time, ingestion of\n" +
                       "the psychordician- emulsified- suspended- tarkelian-\n" +
                       "blend will result in an endo- gastral- essence-\n" +
                       "autoextraction reaction, causing an involuntary\n" +
                       "oral expulsion of the psychordician- emulsified-\n" +
                       "suspended- tarkelian- gastroneuroautoexpelled- vapor.";
        
        PAGE_LIST[3] = "The resulting vapor should be collected in a vacuum\n" +
                       "containing your target object. The object will\n" +
                       "naturally absorb the vapor, and your phylactery will\n" +
                       "be complete. To care for your phylactery, it is\n" +
                       "important to keep it dry at room temperature. You\n" +
                       "will find that the life of both you and your\n" +
                       "phlyactery will be greatly extended a magnitude of\n" +
                       "centuries. The period varies somewhat with your age,\n" +
                       "the skill at which the procedure is done, and the\n" +
                       "object which you are bound to.";
    }
/*----------------------------------------------------------------------------*/
}
