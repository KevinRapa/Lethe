package Cistern;

import A_Main.GUI;
import A_Super.NonPlayerCharacter;
/**
 * @author Kevin Rapa
 */
public class Cis5_FigureNPC extends NonPlayerCharacter {
    // ========================================================================
    public Cis5_FigureNPC () {
        super();
        
        this.description = "The tall figure stands at least 7 feet and is fully "
                + "dressed in a black robe. It holds a tall straight staff "
                + "topped with a red jewel, and its face is hidden. It stands, "
                + "silent with its attention to you, but stays passive.";
        this.actDialog = "\"Death beckons you with its grim implement.\n"
                       + "Embrace its cold grasp and speak 'It is I, friend,\n"
                       + "welcome me' before its front door, and you will be\n"
                       + "invited into its kingdom.\"";
        this.searchDialog = "How very rude that would be.";
        this.useDialog = "\"I need not possessions!\" the figure screeches.";

        this.addNameKeys("(?:black )?(?:cloaked )?(?:figure|person)", "him|it|her");
        this.addUseKeys(ANYTHING);
    }
    // ========================================================================   
    @Override public String interact(String key) {   
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        else if (firstTime)
            return this.converse1();
        else
            return this.converse2();
    }
    // ========================================================================     
    @Override protected String converse1() {
        GUI.menOut("Press enter...");
        GUI.out("You feel out of breath and can't muster any words. For "
                + "a moment, you and the figure stand in silence. Suddenly, "
                + "the figure brings its other hand to its staff and leans "
                + "toward to slightly.");
        GUI.promptOut();
        
        GUI.out("The black cloaked figure speaks a verse to you in a hideous voice:");
        GUI.promptOut();
        
        GUI.out(actDialog);
        GUI.promptOut();
        
        return "You have not much a taste for riddles, "
                + "but you have no intent of asking its meaning.";
    }
    // ========================================================================     
    @Override protected String converse2() {
        GUI.menOut("Press enter...");
        GUI.out("The black cloaked figure speaks a verse to you in a hideous voice:");
        GUI.promptOut();
        
        return actDialog;
    }
}


