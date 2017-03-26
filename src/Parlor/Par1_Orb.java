package Parlor;

import A_Main.GUI;
import A_Super.NonPlayerCharacter;

public class Par1_Orb extends NonPlayerCharacter {
    private boolean woken;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Par1_Orb() {
        super();
        this.woken = false;
        this.searchDialog = "There's nothing hidden here.";
        this.actDialog = "You give the orb a rub with no effect. This is no magical "
                       + "crystal ball as you thought.";
        this.description = "The small glass orb is filled with a smokey gas. "
                         + "The smoke churns slowly inside the orb.";
        this.addActKeys("rub", "feel", "touch");
        this.addNameKeys("(?:small )?(?:glass )?orb");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        
        else if (key.matches(TALK_PATTERN)) {
            if (this.firstTime && this.woken) {
                this.firstTime = false;
                return this.converse1();
            }
            else if (! this.firstTime && this.woken) 
                return this.converse2();
            else 
                return "You mutter a soft 'Hullo?' But hear no response";
        }
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override protected String converse1() {
        
        GUI.out("\"You should ask permission before playing with things that "
              + "aren't yours!\" Shouts the voice...");
        GUI.promptOut();
        
        GUI.out("\"... And so what if I can't even play music anymore? It would "
              + "be music nonetheless, and not that cacophonous symphony of hyenas "
              + "screwing you produced. I'll have you know that I used to be an "
              + "accomplished organist. In fact, I used to play in the chapel, "
              + "in the upper-east wing. That was... quite long ago.\"");
        GUI.promptOut();
        
        GUI.out("\"You thought it would open a way out of here? That's proposterous. "
              + "The architecture here wouldn't allow it. You shouldn't have gotten "
              + "yourself locked in here to begin with. Perhaps if you weren't as "
              + "clumsy as you play...\"");
        GUI.promptOut();
        
        GUI.out("\"It wasn't you? Who else could it be? The original inhabitants of "
              + "this castle died long ago. Who are you anyway?...\"");
        GUI.promptOut();
        
        GUI.out("\"Okay, okay, I'm SORRY for asking. It is none of my business, "
              + "but then again, nothing is, except my work. It just feels nice "
              + "to order people around time and again...\"");
        GUI.promptOut();
        
        GUI.out("\"... Don't worry about it! That's none of your business!...\"");
        GUI.promptOut();
        
        GUI.out("\"NO, of course I don't get bored in here. Though it has been "
              + "... perhaps 500 years since I played? It doesn't matter. I'm "
              + "a musical THEORIST. At my level of experience, the notion of "
              + "creating music to be PLAYED is juvenile fuff. My creations are "
              + "too complex to be understood by playing. But I digress...\"");
        GUI.promptOut();
        
        GUI.out("\"I don't know about any magical barrier. But I'm not surprised "
              + "\"this castle isn't brimming with power. Eurynomos could "
              + "do anything he pleased.");
        GUI.promptOut();     
        
        GUI.out("I requested Eurynomos to bind me here so that "
              + "I could write music and live eternally like him... or so I thought. "
              + "I promised to write music for him as long as he wished to "
              + "keep me alive in this... whatever I'm in. It's actually quite "
              + "nice in here.");
        GUI.promptOut();
        
        GUI.out("\"Anyway, I'm sorry to say that their power is just as a mystery to me. "
              + "Perhaps you could find a way to dispell it, for I am only "
              + "an artisan of sound. But don't touch that enchanting table over "
              + "there! I don't want this whole room charred...\"");
        GUI.promptOut();
        
        return "\"Now, if you don't mind, I would like to get back to writing "
             + "this twelve-hundred part symphony.\"";
    }
/*----------------------------------------------------------------------------*/
    @Override protected String converse2() { 
        return "\"Egh... uhh... I'm not sure... on the shelf over there??? "
              + "Ah! That's what this needs, more bassoons!\"";
    }
/*----------------------------------------------------------------------------*/    
    public boolean woken() {
        return this.woken;
    }
/*----------------------------------------------------------------------------*/ 
    public void wake() {
        this.woken = true;
    }
/*----------------------------------------------------------------------------*/ 
}
