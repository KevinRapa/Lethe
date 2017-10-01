package A_Super;

import A_Main.*;
import Foyer.LootSack;
import Lichs_Quarters.Lich_Room;

/**
 * @author Kevin Rapa
 */
public class Endg extends Room {
//-----------------------------------------------------------------------------    
    public Endg(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (! Player.hasVisited(Id.COU3) && 
                ! Player.getLastVisited().equals(Id.FOR1)) 
            return "";
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(Id.COU3)) {
            // If player is disobedient at the game's start.
            Player.setOccupies(Id.FOR1);
            return "";
        }
        
        AudioPlayer.playTrack(Id.SOUL);
        GUI.clearDialog();
        GUI.menOut(Menus.ENTER);
        GUI.invOut("");
        GUI.promptOut();
        
        boolean lichDead = ((Lich_Room)Player.getRoomObj(Id.LQU1)).lichIsDead();
        String message, finalMsg;
        int score = Player.getScore(), t = 0, p = Player.getInv().countPhylacteries();
        
        if (Player.hasItem(Names.LOOT_SACK)) {
            LootSack sack = (LootSack)Player.getInv().get(Names.LOOT_SACK);
            p += sack.countPhylacteries();
            t += sack.countTreasures();
        }
        
        if (score >= 19000)
            message = "Your wealth transcends all understanding that "
                    + "exists.";
        else if (score >= 15000)
            message = "You possess the wealth, cunning, and power to overcome "
                    + "any holy or unholy force that dare challenge you.";
        else if (score >= 13000)
            message = "Your wealth is beyond the dreams of avarice and "
                    + "will earn you a divine seat in the afterlife.";
        else if (score >= 11000)
            message = "Your wealth is legendary and would bring a tear to Plutus' eye.";
        else if (score >= 9000)
            message = "Your wealth is nearly insurmountable and would "
                    + "stun any man, woman, and God alike.";
        else if (score >= 7750)
            message = "Your wealth is nearly insurmountable and would "
                    + "stun all men and women alike.";
        else if (score >= 6500)
            message = "You have amassed a grand fortune which will certainly "
                    + "grant you any Earthly desire.";
        else if (score >= 5250)
            message = "You have amassed a grand fortune which instills fear in "
                    + "all kings and queens.";
        else if (score >= 4000)
            message = "Your riches would earn you the respect of many kings.";
        else if (score >= 2750)
            message = "You are a top contender in the hunt for treasure.";
        else if (score >= 1500)
            message = "You're skilled in the hunt for treasure, though "
                    + "you have such a long way to go.";
        else if (score >= 750)
            message = "Your eye for wealth is strong. You will likely have much "
                    + "to pawn off, should you return.";
        else if (score >= 500)
            message = "You abide by your manly ethics to work hard and provide "
                    + "for your family. Although, the thought of wealth visits you frequently.";
        else if (score >= 250)
            message = "You are rich in character, a true fortune to be respected. "
                    + "Material possessions are secondary, of course.";
        else if (score >= 0)
            message = "You have a humble spirit, and long not for possessions.";
        else
            message = "You have eccentric, perplexing tastes.";
        
        if (p > 0)
            message += " Watch yourself, for you hold the soul of a powerful mage, "
                    + "and it may warp you the same way it did him.";
        
        finalMsg = "Evaluation: Your score is " + score + ". You have "
                  + "discovered " + t + " out of 15 legendary treasures" + 
                (lichDead ? " and all 5 of the phylacteries. " : ". ") + message;
        
        GUI.out(finalMsg);
        GUI.promptOut();

        // Exits the game after player types enter.
        Main.eraseGame();
        Main.endGameProcedure();
        System.exit(0);
        
        return "";
    }
//-----------------------------------------------------------------------------
}