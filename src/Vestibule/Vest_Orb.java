package Vestibule;

import A_Main.GUI;
import A_Super.NonPlayerCharacter;
/**
 * @author Kevin Rapa
 */
public class Vest_Orb extends NonPlayerCharacter {
    // ========================================================================
    public Vest_Orb () {
        super();
        this.description = "It's a dusty glass orb on the desk in the corner.\n"
                         + "There's some sort of light coming from within. Did\n"
                         + "this thing speak to you? Suddenly, a voice speaks-\n"
                         + "\"Is staring at things a hobby of yours? Aren't you going to say anything to me?\"";
        this.actDialog = null;
        this.searchDialog = "You can't seem to find anything out of the ordinary. Suddenly, a voice speaks-\n"
                         + "\"Is staring at things a hobby of yours? Aren't you going to say anything to me?\"";

        this.addNameKeys("(?:dusty )?(?:glass )?orb");
    }
    // ======================================================================== 
    @Override public String interact(String key) {       
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        
        else if (this.firstTime)
            converse1();
        else
            converse2();
        
        return this.actDialog;
    }
    // ========================================================================     
    @Override protected <Void> Void converse1() {
        GUI.menOut("Press enter...");
        GUI.out("You open your mouth and utter a \"hello\".");
        GUI.promptOut();

        GUI.out("\"Yes, thank you for not freaking out like the rest of the 'guests'.\n"
              + "Each other person who decided to wander in here couldn't figure\n"
              + "out to come over here and talk to me. They just freaked out...\n"
              + "except for one... He was smart.\"");
        GUI.promptOut();
        
        GUI.out("\"Well, they were taken. I don't know where, and I never saw them\n"
              + "again. Many from all over came here. Just some thugs wanting\n"
              + "a little bit of adventure, thinking this place was abandoned.\"");
        GUI.promptOut();
        
        GUI.out("\"...You're telling me that you were invited? Do you remember\n"
              + "any invitation? Because if you had recieved one, you certainly\n"
              + "would never had accepted it. There's only one person living here\n"
              + "now, and he needs one thing- life. Or should I say, lives.\"");
        GUI.promptOut();
        
        GUI.out("\"Of course, I'm still here, for I am not a common individual,\n"
              + "but once a mage of this castle, and the brother to this castle's\n"
              + "only 'living' inhabitant.\"");
        GUI.promptOut();
        
        GUI.out("\"Oh sure! Perhaps centuries ago, phenomena we thought to be\n"
              + "magic turned out to be science later, but magic is real! Just\n"
              + "you wait. Ah, perhaps you must anyway.\"");
        GUI.promptOut();
        
        GUI.out("\"Oh, but anyway, my name is Rhadamanthus. I, too, am a victim\n"
              + "of the mad Eurynomos, my aforementioned brother. You see,\n"
              + "centuries ago, I and my two mage brothers\n"
              + "discovered a power source of magic deep under the castle which\n"
              + "we called 'The Source'. This magic was different! It was powerful,\n"
              + "but sinister.\"");
        GUI.promptOut();
        
        GUI.out("\"Long story short, the magic drove Eurynomos mad first. He\n"
              + "became obsessed with the power, and lichified himself. He\n"
              + "bound me and my brother Asterion to the castle. The Source\n"
              + "destroyed everybody else in the castle, and Eurynomos walks\n"
              + "alone now.\"");
        GUI.promptOut();
        
        GUI.out("\"Eurynomos is kept alive by 5 phylacteries, however he cannot\n"
              + "remember where they are, for he lives in a state of dementia\n"
              + "now. The phylacteries are deteriorating, but I believe he supplements\n"
              + "his life energy with that of others; the fools who enter here.\n"
              + "Find and destroy the phylacteries. Set us free from this place.\"");
        GUI.promptOut();
                
        return null;
    }
    // ========================================================================     
    @Override protected <Void> Void converse2() {
        GUI.out("Eurynomos is kept alive by 5 phylacteries, however he cannot\n"
              + "remember where they are, for he lives in a state of dementia\n"
              + "now. Find and destroy them. I'm sorry, I do not know what they\n"
              + "are either.");
        
        return null;
    }
    // ========================================================================     
}


