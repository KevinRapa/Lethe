package Hades;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;

/**
 * @author Kevin Rapa
 */
public class Hades extends Room {
    private final String END_DIALOG;
// ============================================================================    
    public Hades(String name, String ID) {
        super(name, ID);
        this.description= 
                "You are outside a large gateway, on which is inscribed " +
              "\"Abandon every hope, all ye who enter here.\" " +
              "The gate is open; through it you can see a desolation, "
            + "with a pile of mangled corpses in one corner. Thousands "
            + "of voices, lamenting some hideous fate, can be heard. " +
              "The way through the gate is barred by evil spirits, "
            + "who jeer at your attempts to pass.";
        
        this.END_DIALOG = 
                "An echoing voice thunders through the crimson skies. It\n" +
                "is directed at you. \"Another adventurer comes! Welcome\n" +
                "to the land of the dead, where you may spend life eternal\n" +
                "among your intrepid kindred. Judgement awaits, and you \n" +
                "shall be judged not by your cunning and intellect, but\n" +
                "by the fruits of them, for only the wealthy live\n" +
                "comfortably here...\"";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.EAST)
            return "Some invisible force prevents you from passing through the gate.";
        else
            return bumpIntoWall();
    }
// ============================================================================
    @Override public String triggeredEvent() {
        GUI.roomOut(STD_RM_OUT);
        
        GUI.clearDialog();
        GUI.descOut(END_DIALOG);
        GUI.menOut("\n\nPress enter...");
        GUI.promptOut();
        
        GUI.descOut(calculateScore(Player.getScore()));
        GUI.promptOut();
        
        GUI.toMainMenu();
        Player.describeRoom();
        
        return STD_RM_OUT;
    }
// ============================================================================
    private String calculateScore(int score) {
        if (score >= 13200)
            return 
                "\"You are drenched in greed, my son. Undaunted by risk, " +
                "in pursuit of only the unquenchable thirst for wealth. " +
                "You are a master adventurer; a true idol among idols, surpassing even me. " +
                "You shall live comfortably for all eternity in Tartarus, "
              + "in constant labor with frequent coffee breaks.\"";
        if (score >= 10000)
            return 
                "\"You are drenched in greed, my son. Undaunted by risk,\n" +
                "in pursuit of only the unquenchable thirst for wealth.\n" +
                "You are a master adventurer; a true idol among idols,\n" +
                "except among me, for I have traveled to these lands\n" +
                "before, and even back. You shall live comfortably for\n" +
                "all eternity in Tartarus, with\n" +
                "in constant labor with occassional coffee breaks.\"";
        if (score >= 5700)
            return 
                "\"You have the true spirit of an adventurer, yet you\n" +
                "also lived as a prisoner, and ultimately strayed from\n" +
                "your path to freedom to embrace death's cold grasp.\n" +
                "You have moderate wealth, impressive to many, but not\n" +
                "to all. You will be sent to live eternally in the\n" +
                "flaming river Phlegethon with other aspired adventurers,\n" +
                "interrupted occassionally with short breaks for leisurely\n" +
                "activities.\"";
        if (score >= 1000)
            return 
                "\"You have the true spirit of an adventurer, yet you\n" +
                "also lived as a prisoner, and ultimately strayed from\n" +
                "your path to freedom to embrace death's cold grasp.\n" +
                "You have some wealth, impressive to the commonfolk,\n" +
                "Yet deserve not to live amongst kings. You will be\n" +
                "sent to live eternally in the flaming river Phlegethon\n" +
                "with opportunities to earn credits, supposing you wish\n" +
                "to vacation from hellfire a couple times a month.\"";
        if (score >= 0)
            return 
                "\"Your wealth is sparse, and your accomplishments\n" +
                "laughable. Though perhaps you have a good spirit\n" +
                "and the sound ethics of a hard worker, you will\n" +
                "be forgotten eventually and fade into obscurity.\n" +
                "You shall be sent to Lethe, where you will spend\n" +
                "forever swimming in a state of dementia.\"";
        else 
            return
                "\"Your wealth is null, and your accomplishments\n" +
                "laughable. Though perhaps you have a good spirit\n" +
                "and the sound ethics of a hard worker, you will\n" +
                "be forgotten and fade into obscurity. You shall \n" +
                "be sent Cocytus, so that you may swim in\n" +
                "lamentation for all eternity.\"";
    }
// ============================================================================
}