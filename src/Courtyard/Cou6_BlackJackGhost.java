package Courtyard;

import Core.GUI;
import Core.Player;
import java.util.HashMap;
import Super.Furniture;
import Super.Room;
import Super.Item;
/**
 * This is an in-game non-player character that plays blackjack with the player.
 * The player may play as many times as her/she wants each encounter, and the
 * player keeps the cards in his/her inventory after no more games are to be played.
 * This NPC is a ghost. The ghost acts as the dealer.
 * 
 * This class was made a demonstration to Next Century Corp. as a pre-interview exercise.
 * 
 * @author Kevin Rapa
 */
public class Cou6_BlackJackGhost extends Furniture {
    private final Player PLYR; // Reference to player for giving cards.
    private boolean firstTime; // If you've spoken to the ghost before.
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou6_BlackJackGhost(String NAME, Player plyr) {
        super(NAME);
        this.searchable = false;
        this.PLYR = plyr;
      
        this.firstTime = true;
        this.searchDialog = "The ghost won't appreciate that.";
        this.interactDialog = "\"Come back if you want to play again!";
        this.description = "Leaning nonchalantely against the castle wall is a\n"
                         + "ghostly figure shuffling what seem to be cards. The apparition\n"
                         + "is garbed in distinctive clothing- a vest and a full-brimmed hat.";
        this.addActKeys("speak", "talk", "converse", "play", "chat");
        this.addNameKeys("ghost", "apparition", "spirit");
    }
/*----------------------------------------------------------------------------*/
    /**
     * Initiates dialog with the ghost player. 
     * The ghost talks to you, then asks you if you would like to play blackjack.
     * @param map A reference to the game map.
     * @param key The action the player typed to interact with this.
     * @return End dialog with the ghost.
     */
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        
        if (this.firstTime) {
            if(this.converse1())
                rep += " Hey why don't you keep those cards? I can make more! Hah!";
            this.firstTime = false;
        }
        else if (this.converse2())
            rep += " Hey why don't you keep those cards? I can make more! Hah!";

        return rep;
    }
/*----------------------------------------------------------------------------*/
    /**
     * Starts dialog with the ghost.
     * Returns true or false, if the player has played the ghost at least once.
     */
    private boolean converse1() {
        GUI.menOut("\n\n<enter> Continue...");
        GUI.out("You approach the apparition loitering in the courtyard. Before\n"
              + "you can accost it, its mouth opens to speak...");
        GUI.promptOut();
        
        GUI.out("The ghost speaks in a heavy Australian accent. \"Finally!\n"
              + "Another soul to play. It has been a while since I've\n"
              + "seen anyone to play cards with. Would you like to play? It's\n"
              + "called blackjack...\"");
        GUI.promptOut();
        
        GUI.out("\"... well not at all! ... Does it look like I need money in\n"
              + "my state? Come on stranger, yes or no....\"");
        GUI.menOut("<'yes'>\n<'no'>");
        
        return this.askToPlay();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Starts dialog with the ghost after he has be talked to a second time.
     * Returns true or false, if the player has played the ghost at least once.
     */
    private boolean converse2() {
        GUI.out("Back to play?");
        return this.askToPlay();
    }
/*----------------------------------------------------------------------------*/
    /**
     * Asks the player if he/she would like to play a game of blackjack.
     * After each game, if the player wants to play again, the cards are
     * cleared from the player's inventory. If not, the player keeps the cards.
     */
    private boolean askToPlay() {
        String ans;
        boolean played = false; // If the player has played at least once.
        
        do {
            GUI.menOut("<'yes'>\n<'no'>");
            ans = GUI.promptOut();
            
            if (ans.matches("yes")) {
                played = true;
                this.PLYR.getINV().remove("card"); // Removes all cards from player inventory.
                GUI.clearDialog();
                this.playCards(); // Starts the game. 
            }
            GUI.invOut("You are carrying:\n" + this.PLYR.getINV());
            
        } while (! ans.matches("no"));
        
        GUI.clearDialog();
        
        return played;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * The main algorithm for the blackjack game.
     * Game outcomes are mapped to by integers which display after each game.
     * The first integer is 1 if the outcome happens immediately or 2 otherwise.
     * The second represents the ghost (1), player (2), or both (3).
     * The third represents the reason- bust (1), blackjack (2), or score (3).
     * 
     * A new deck is made for each game. The NPC is a ghost, and thus uses ghost
     * cards, so more are made by the ghost. The benefit of this is that the
     * player may keep the cards and use them for something later, perhaps.
     * 
     * If a player busts, the game also prints how many points that player is over.
     * Whatever the ghost draws is printed in the console (For testing).
     */
    private void playCards() {
        HashMap<Integer, String> results = new HashMap();
        
        results.put(121, "You busted already? % too many! Loser! ... Want to play again?");
        results.put(111, "I busted already? % too many! My luck has gone with the wind tonight... Want to play again?");
        results.put(131, "Huh... we both busted. House always wins though! ... Want to play again?");
        results.put(112, "Hah! I have blackjack already. I win... Want to play again?");
        results.put(132, "We both got blackjack... So a tie, how boring... Want to play again?");
        results.put(212, "Blackjack! I win... Want to play again?");
        results.put(211, "Agh... % too far over. I lose... Want to play again?");
        results.put(233, "Hm... a tie. How boring... Want to play again?");
        results.put(223, "You won. Good luck, mate, you need it tonight... Want to play again?");
        results.put(213, "Looks like I won, mate, fair and square... Want to play again?");
        results.put(221, "Looks like you busted! % too many! ... Want to play again?");
        Card plyrCard1, plyrCard2; // References so they can be removed later.
        int ghostVal = 0, yourVal = 0; // The scores.
        Deck deck = new Deck();
        deck.shuffle();
        
        // Deals the initial two cards to the ghost.
        ghostVal += this.evalHit(deck.draw(), ghostVal) + this.evalHit(deck.draw(), ghostVal);
        
        // Deals the initial two cards to the player and calculates the score.
        plyrCard1 = deck.draw();
        plyrCard2 = deck.draw();
        this.PLYR.getINV().add(plyrCard1);
        this.PLYR.getINV().add(plyrCard2);
        // The two commands below must be on separate lines, or starting with
        // two aces will bust the player. See evalHit() method. 
        yourVal += this.evalHit(plyrCard1, yourVal); 
        yourVal += this.evalHit(plyrCard2, yourVal);
        GUI.invOut("You are carrying:\n" + this.PLYR.getINV());   
        
        //<editor-fold desc="Test Cases"> ===================================
        // Uncomment any of these and choose 'stand' during the game.
        
        //ghostVal = 21;
        //yourVal = 0;
        
        //ghostVal = 17;
        //yourVal = 20;
        
        //ghostVal = 17;
        //yourVal = 17;
        
        //ghostVal = 19;
        //yourVal = 18;
        
        //ghostVal = 21;
        //yourVal = 21;
        
        //ghostVal = 0;
        //yourVal = 500;
        System.out.println("\nGhost's starting score: " + ghostVal);
        //</editor-fold> =====================================================
        
        if (this.bust(yourVal) || this.bust(ghostVal)) {
            // Checks if either player busts immediately.
            if (this.bust(yourVal) && this.bust(ghostVal))
                GUI.out(results.get(131));
            else if (this.bust(yourVal))
                GUI.out(results.get(121).replaceFirst("%", String.valueOf(yourVal - 21)));
            else
                GUI.out(results.get(111).replaceFirst("%", String.valueOf(ghostVal - 21)));
            return;
        }
        if (this.blackJack(ghostVal)) {
            // Checks if the dealer gets a blackJack immediately.
            int val = this.blackJack(yourVal) ? 132 : 112; // Checks you too.
            GUI.out(results.get(val));
            
            return;
        }
        
        yourVal = this.playerTurn(yourVal, deck); // You take your turn.
        
        // Evaluates if you have busted immediately or got a blackjack.
        if (this.bust(yourVal)) {
            GUI.out(results.get(221).replaceFirst("%", String.valueOf(yourVal - 21)));
            return;
        }
        
        ghostVal = this.ghostTurn(yourVal, ghostVal, deck); // Ghost takes turn.
        
        // Evaluates if the dealer busted immediately or got a blackjack.
        if (this.blackJack(ghostVal)) {
            GUI.out(results.get(212));
            return;
        }
        else if (this.bust(ghostVal)) {
            GUI.out(results.get(211).replaceFirst("%", String.valueOf(ghostVal - 21)));
            return;
        }
        
        // Compares the players' scores of nothing special happened.
        int val = (yourVal == ghostVal) ? 233 : 
                  ((ghostVal > yourVal) ? 213 : 223);
        
        GUI.out(results.get(val));
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * This method lets you hit as many times as he/she likes, or stands.
     * @param num The player's current score.
     * @param deck A reference to the Deck object.
     * @return The player's new current score.
     */
    private int playerTurn(int num, Deck deck) {
        int score = num;
        Card current;
        String ans;
        
        do {
            GUI.menOut("Your total is " + score + ".\n" +
                       "Would you like to hit or stand?\n"
                     + "<'hit'>\n<'stand'>");
            ans = GUI.promptOut();
            
            if (ans.matches("[hH]it")) {
                current = deck.draw();
                this.PLYR.getINV().add((Item) current);
                GUI.invOut("You are carrying:\n" + this.PLYR.getINV());
                score += this.evalHit(current, score);
                
                if (this.bust(score)) // Forces a stay if player busts.
                    ans = "stand";
            }
            else if (! ans.matches("[sS](?:tand:tay)")) // Accepts 'stand' or 'stay'.
                GUI.out("You gotta say 'hit', 'stand', or 'stay', mate.");
            
        } while (! ans.matches("stand|stay"));
        
        return score;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * The ghost hits as many times as possible until busting or over 17.
     * @param plyrNum Your current score.
     * @param ghostNum The ghost's current score.
     * @param deck A reference to the Deck object.
     * @return The ghost's new score.
     */
    private int ghostTurn(int plyrScore, int ghostNum, Deck deck) {
        int ghostScore = ghostNum;
        
        if (ghostScore < plyrScore)
            while (ghostScore < plyrScore && ghostScore < 17) {
                Card card = deck.draw();
                ghostScore += this.evalHit(card, ghostScore);
                System.out.println("Ghost draws a " + card + "\nGhost new score: " + ghostScore + 
                                   " Player current score: " + plyrScore); //FOR TESTING
            }
        return ghostScore;
    }
/*----------------------------------------------------------------------------*/     
    /**
     * Evaluates a hit action by calculating the new score.
     * @param card A Card object.
     * @param score a current score.
     * @return The new score for the player who hit.
     */
    private int evalHit(Card card, int score) {
        if (card.getVal() == 1)
            return (score + 11 <= 21) ? 11 : 1;
        else
            return card.getVal();
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * Checks if a bust has occurred.
     * @param score A current score.
     * @return If the score is over 21.
     */
    private boolean bust(int score) {
        return score > 21;
    }
/*----------------------------------------------------------------------------*/ 
    /**
     * Checks if a blackjack has occurred.
     * @param score A current score.
     * @return If the score equals 21.
     */
    private boolean blackJack(int score) {
        return score == 21;
    }
/*----------------------------------------------------------------------------*/
    /**
     * Checks if this is the first time the player has interacted with the ghost.
     * @return If the player has never interacted with the ghost before.
     */
    public boolean firstTime() {
        return this.firstTime;
    }
/*----------------------------------------------------------------------------*/    
}