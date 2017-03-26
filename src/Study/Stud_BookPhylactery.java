package Study;

import A_Main.Names;
import A_Super.Book;

public class Stud_BookPhylactery extends Book {
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Stud_BookPhylactery(String name, int score) {
        super(name, 4);
        this.type = Names.PHYLACTERY;
        this.score = score;
        
        PAGE_LIST[0] = "- A Young Mind's Guide to Lichery - " +
                       "- by Melroth Gfrorgozh -";
        
        PAGE_LIST[1] = "Let this be a sequel to 'A Young Mind's Guide " +
                       "to Witchery.' It is expected that you have read " +
                       "this to serve as a foundation on which to build " +
                       "your skills in lichery. The craft of binding a " +
                       "soul to a physical object, a phylactery, is a " +
                       "form of witchcraft! Although lichs are commonly " +
                       "associated with the dead, lichery is by no means " +
                       "a form of necromancy. Before continuing, heed " +
                       "these warnings: first, the older the soul being " +
                       "bound, the weaker the soul will be. That means " +
                       "that the phylactery will begin to lose it's power " +
                       "sooner. Second, lichs are NOT immortal, however " +
                       "their life is extended tremendously. As your " +
                       "phylactery loses power, your soul deteriorates " +
                       "and so will you. Do not lust for immortality; " +
                       "unbind your soul when the time is right. This " +
                       "extends to the third warning- DO NOT lose " +
                       "your phylactery. If lost, you will be doomed " +
                       "to live eternally in a state of madness. Thus, " +
                       "the fewer phylacteries you create, the safer. " +
                       "Although more phylacteries means a longer- " +
                       "lasting bind.";
        
        PAGE_LIST[2] = "Before you begin, have your materials in order. " +
                       "You should have three to four tarkelies, an " +
                       "excess of karagaloos, five ounces of liquified " +
                       "feferium, and a mandrake root. First, distill " +
                       "the feferium and blend the root into a fine " +
                       "paste. Mix the mandrake paste into the distilled " +
                       "feferium, and then toss in a karagaloo or two " +
                       "and simmer for five minutes. The resulting  " +
                       "mixture is called a psychordician- emulsion. " +
                       "Over a burner, heat the tarkelies and collect " +
                       "the evaporated vapor into the psychordician- " +
                       "emulsion flask to created the psychordician- " +
                       "emulsified- suspended- tarkelian- blend. Let " +
                       "the psychordician- emulsified- suspended- tarkelian- " +
                       "blend chill between 35 and 45 degrees fahrenheit " +
                       "for three days. At that time, ingestion of " +
                       "the psychordician- emulsified- suspended- tarkelian- " +
                       "blend will result in an endo- gastral- essence- " +
                       "autoextraction reaction, causing an involuntary " +
                       "oral expulsion of the psychordician- emulsified- " +
                       "suspended- tarkelian- gastroneuroautoexpelled- vapor.";
        
        PAGE_LIST[3] = "The resulting vapor should be collected in a vacuum " +
                       "containing your target object. The object will " +
                       "naturally absorb the vapor, and your phylactery will " +
                       "be complete. To care for your phylactery, it is " +
                       "important to keep it dry at room temperature. You " +
                       "will find that the life of both you and your " +
                       "phlyactery will be greatly extended a magnitude of " +
                       "centuries. The period varies somewhat with your age, " +
                       "the skill at which the procedure is done, and the " +
                       "object which you are bound to.";
    }
/*----------------------------------------------------------------------------*/
}
