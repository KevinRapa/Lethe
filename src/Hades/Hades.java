package Hades;

import A_Main.GUI;
import A_Main.Menus;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Item;
import A_Super.Room;

/**
 * @author Kevin Rapa
 */
public class Hades extends Room {
    private final String END_DIALOG;
    private final Item TYPHOS;
// ============================================================================    
    public Hades(String name, String ID, Item typhos) {
        super(name, ID);
        
        this.TYPHOS = typhos;
        this.END_DIALOG = 
                "An echoing voice thunders through the crimson skies. It " +
                "is directed at you. \"Another adventurer comes! Welcome " +
                "to the land of the dead, where you may spend life eternal " +
                "among your intrepid kindred. Judgement awaits, and you " +
                "shall be judged not by your cunning and intellect, but " +
                "by the fruits of them, for only the wealthy live " +
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
        if (! Player.hasVisited(ID)) {
            GUI.roomOut(STD_RM_OUT);
            GUI.clearDialog();
            GUI.descOut(END_DIALOG);
            GUI.menOut(Menus.ENTER);
            GUI.promptOut();

            GUI.descOut(calculateScore(Player.getScore()));
            GUI.promptOut();

            GUI.toMainMenu();
            Player.describeRoom();
        }
        
        return STD_RM_OUT;
    }
// ============================================================================
    private String calculateScore(int score) {
        if (score >= 15000) {
            return 
                "\"You are drenched in greed, my son. Undaunted by risk, " +
                "in pursuit of only the unquenchable thirst for wealth. " +
                "You are a master adventurer; a true idol among idols, "
              + "surpassing even me. You shall live comfortably for all "
              + "eternity in Tartarus, in constant labor with frequent "
              + "coffee breaks.\"";
        }
        if (score >= 13500)
            return 
                "\"You are drenched in greed, my son. Undaunted by risk, " +
                "in pursuit of only the unquenchable thirst for wealth. " +
                "You are a master adventurer; a true idol among idols, " +
                "except among me, for I have traveled to these lands " +
                "before, and even back. You shall live comfortably for " +
                "all eternity in Tartarus, in constant labor with "
              + "occasional coffee breaks.\"";
        if (score >= 10000)
            return 
                "\"You have the true spirit of an adventurer, yet you " +
                "also lived as a prisoner, and ultimately strayed from " +
                "your path to freedom to embrace death's cold grasp. " +
                "You have moderate wealth, impressive to many, but not " +
                "to all. You will be sent to live eternally in the " +
                "flaming river Phlegethon with other aspired adventurers, " +
                "interrupted occasionally with short breaks for leisurely " +
                "activities.\"";
        if (score >= 5000)
            return 
                "\"You have the true spirit of an adventurer, yet you " +
                "also lived as a prisoner, and ultimately strayed from " +
                "your path to freedom to embrace death's cold grasp. " +
                "You have some wealth, impressive to the commonfolk, " +
                "Yet deserve not to live amongst kings. You will be " +
                "sent to live eternally in the flaming river Phlegethon " +
                "with opportunities to earn credits, supposing you wish " +
                "to vacation from hellfire a couple times a month.\"";
        if (score >= 0)
            return 
                "\"Your wealth is sparse, and your accomplishments " +
                "laughable. Though perhaps you have a good spirit " +
                "and the sound ethics of a hard worker, you will " +
                "be forgotten eventually and fade into obscurity. " +
                "You shall be sent to Lethe, where you will spend " +
                "forever swimming in a state of dementia.\"";
        else 
            return
                "\"Your wealth is null, and your accomplishments " +
                "laughable. Though perhaps you have a good spirit " +
                "and the sound ethics of a hard worker, you will " +
                "be forgotten and fade into obscurity. You shall " +
                "be sent Cocytus, where you shall swim in " +
                "lamentation for all eternity.\"";
    }
// ============================================================================
}