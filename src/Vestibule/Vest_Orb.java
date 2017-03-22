package Vestibule;

import A_Main.GUI;
import A_Main.Menus;
import A_Super.NonPlayerCharacter;
/**
 * @author Kevin Rapa
 */
public class Vest_Orb extends NonPlayerCharacter {
    // ========================================================================
    public Vest_Orb () {
        super();
        
        this.description = 
                "It's a dusty glass orb on the desk in the corner. "
             + "There's some sort of light coming from within. Did "
             + "this thing speak to you? Suddenly, a voice speaks- "
             + "\"Is staring at things a hobby of yours? Aren't you "
             + "going to say anything to me?\"";
        this.actDialog = 
                "You extend your hand out to grab the auspicious orb. A voice\n"
              + "then speaks before you reach it. \"Hey you! Do not taint my\n"
              + "window from this prison with your dirty hands. Say something\n"
              + "to me damn you!\"";
        this.searchDialog = 
                "You can't seem to find anything out of the "
                + "ordinary. Suddenly, a voice speaks-\n"
                + "\"Is staring at things a hobby of yours? "
                + "Aren't you going to say anything to me?\"";

        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:dusty )?(?:glass )?orb");
    }
    // ======================================================================== 
    @Override public String interact(String key) {       
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        else if (key.matches(GETPATTERN))
            return this.actDialog;
        else if (this.firstTime)
            return converse1();
        else
            return converse2();
    }
    // ========================================================================     
    @Override protected String converse1() {
        GUI.menOut(Menus.ENTER);
        GUI.out("You open your mouth and utter a \"hullo\".");
        GUI.promptOut();

        GUI.out("\"Yes, hello. Thank you for coming over and talking to me. Others " +
                "seem to startle so easily, and I must guide them over here like " +
                "a small child...\"");
        GUI.promptOut();
        
        GUI.out("\"I... really don't think I could help you with that. It was " +
                "your choice to enter this room. Frankly, I don't quite know " +
                "where I am, or how long I've been in here.\"");
        GUI.promptOut();
        
        GUI.out("\"I'm afraid that doesn't help my good man; there are many tall " +
                "rooms with fireplaces here. Everybody who wanders here tells " +
                "me something very similar. Seems so many get lost in the forest " +
                "and expect some assistance here. Someone should be down " +
                "sometime to assist, as someone always does, and I assume they " +
                "just find their way home safely.\"");
        GUI.promptOut();
        
        GUI.out("\"... You're telling me you were invited here? Do you remember " +
                "an invitation? How unusual. Most visit here vacuous and " +
                "confused. I was hoping you'd be different.\"");
        GUI.promptOut();
        
        GUI.out("\"Well, I suppose I'm not too different. I feel fine, though " +
                "I must say that I'm quite ignorant of my situation. All I " +
                "remember is that my name is Rhadamanthus and that I studied " +
                "here. I have two brothers... Eurynomos and Asterion, but I " +
                "do not know their state. One or the other should be coming " +
                "to assist at some point, but you picked an inconvenient " +
                "time to visit.\"");
        GUI.promptOut();
        
        GUI.out("\"Ah, well... I lived with my two parents here- Tyre and " +
                "Europa. But after they were gone, supported by their " +
                "wealth and success, we turned our attention to magical " +
                "study in order to help this kingdom and achieve their " +
                "success. Hmph... I forgot I knew that.\"");
        GUI.promptOut();
        
        return "\"Beyond that... I have only nebulous fragments of " +
                "memory. I remember a discovery. I remember journey. " +
                "But beyond that is a haze. Perhaps you could look " +
                "around if you can figure out that door... I feel " +
                "tired though. I'm sure you can find something to help you out.\"";
    }
    // ========================================================================     
    @Override protected String converse2() {
        return "I'm sure you can find something to help you out.";
    }
    // ========================================================================   
    @Override public String moveIt() {
        return "\"I am not a mere household decoration!\" The orb speaks. \"Be respectful and talk to me!\"";
    }
    // ========================================================================   
}


