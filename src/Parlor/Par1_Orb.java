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
        this.actDialog = "You give the orb a rub with no effect. This is no magical\n"
                       + "crystal ball as you thought.";
        this.description = "The small glass orb is filled with a smokey gas.\n"
                         + "The smoke churns slowly inside the orb.";
        this.addActKeys("rub", "feel", "touch");
        this.addNameKeys("(?:small )?(?:glass )?orb");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.matches("[stc]\\w+")) {
            if (this.firstTime && this.woken) {
                this.converse1();
                this.firstTime = false;
                return "";
            }
            else if (! this.firstTime && this.woken) {
                this.converse2();
                return "";
            }
            else 
                return "You mutter a soft 'Hullo?' But hear no response";
        }
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override protected<Void> Void converse1() {
        
        GUI.out("\"You should ask permission before playing with things that\n"
              + "aren't yours!\" Shouts the voice...");
        GUI.promptOut();
        
        GUI.out("\"... And so what if I can't even play music anymore? It would\n"
              + "be music nonetheless, and not that cacophonous symphony of hyenas\n"
              + "screwing you produced. I'll have you know that I used to be an\n"
              + "accomplished organist. In fact, I used to play in the chapel,\n"
              + "in the upper-east wing. That was... quite long ago.\"");
        GUI.promptOut();
        
        GUI.out("\"You thought it would open a way out of here? That's proposterous.\n"
              + "The architecture here wouldn't allow it. You shouldn't have gotten\n"
              + "yourself locked in here to begin with. Perhaps if you weren't as\n"
              + "clumsy as you play...\"");
        GUI.promptOut();
        
        GUI.out("\"It wasn't you? Who else could it be? Erik is asleep now.\n"
              + "Who are you anyway?...\"");
        GUI.promptOut();
        
        GUI.out("\"Okay, okay, I'm SORRY for asking. It is none of my business,\n"
              + "but then again, nothing is, except my work. It just feels nice\n"
              + "to order people around time and again...\"");
        GUI.promptOut();
        
        GUI.out("\"... Don't worry about it! That's none of your business!...\"");
        GUI.promptOut();
        
        GUI.out("\"NO, of course I don't get bored in here. Though it has been\n"
              + "... perhaps 300 years since I played? It doesn't matter. I'm\n"
              + "a musical THEORIST. At my level of experience, the notion of\n"
              + "creating music to be PLAYED is juvenile fuff. My creations are\n"
              + "too complex to be understood by playing. But I digress...\"");
        GUI.promptOut();
        
        GUI.out("\"I don't know about any magical barrier. But recently this\n"
              + "room has been modified into a enchantery of sorts. In fact,\n"
              + "that fireplace is the first thing Erik enchanted after he\n"
              + "discovered magic. He outgrew frivolous magic like that though,\n"
              + "and focused on it's more functional aspects...\"");
        GUI.promptOut();
        
        GUI.out("\"Perhaps you could find a way to dispell it, for I am only\n"
              + "an artisan of sound. But don't touch that enchanting table over\n"
              + "there! I don't want this whole room charred...\"");
        GUI.promptOut();
        
        GUI.out("\"Now, if you don't mind, I would like to get back to writing\n"
                + "this twelve-hundred part symphony.\"");
        GUI.promptOut();
        
        return null;
    }
/*----------------------------------------------------------------------------*/
    @Override protected<Void> Void converse2() {
        GUI.out("\"Egh... uhh... I'm not sure... on the shelf over there???\n"
              + "Ah! That's what this needs, more bassoons!\"");
        
        return null;
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
