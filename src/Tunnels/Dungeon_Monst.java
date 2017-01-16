package Tunnels;

import A_Main.AudioPlayer;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static A_Main.AudioPlayer.S;
import static A_Main.AudioPlayer.WD;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import Strange_Pool.Sewp;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * This class simulates a creature that roams the halls of the tunnels.
 * 
 * The monster uses a queue to switch rooms at fixed intervals. Every time the
 * player or monster moves, the monster checks for the player. 
 * 
 * The monster does not move if the player is not in the dungeon area.
 * 
 * @author Kevin Rapa
 */
public class Dungeon_Monst {
    // ========================================================================
    private static enum Volume {
        NONE("none", -50),
        VERY_SOFT("verySoft", -40),
        SOFT("soft", -30),
        MEDIUM_SOFT("mediumSoft", -20),
        MEDIUM("medium", -15),
        MEDIUM_LOUD("mediumLoud", -10),
        LOUD("loud", 0);

        private final String TEST;
        private final int VOL;
        // ==========================================
        Volume(String test, int vol) {
            this.TEST = test;
            this.VOL = vol;
        }
        @Override public String toString() {
            return this.TEST;
        }
        // ==========================================
        public int getVol() {
            return this.VOL;
        }
    } 
    protected static final File FOOTSTEPS = new File(WD, "effects" + S + "monster.wav");
    protected static Clip clip;

    private static String position = Id.SEW0;
    private static final LinkedList<String> COORD_QUEUE = new LinkedList() {{
        String[] ROOM_LIST = {Id.SEW0, Id.SEW1, Id.SEW2, Id.SEW3, Id.SEW4, Id.SEW5,
                              Id.CIS1, Id.CIS2, Id.CIS3, Id.CIS4, Id.CIS3, Id.CIS2,
                              Id.CIS1, Id.SEW5, Id.SEW4, Id.SEW3, Id.SEW2, Id.SEW1};
        addAll(Arrays.asList(ROOM_LIST));
    }};
    private static Timer timer;
    // ========================================================================
    public final static void startMovement() {
        timer = new Timer(true);
        
        timer.schedule(new Creature_Task(), 3500, 3500);
    }
    // ========================================================================
    private static void move() {
        String temp = position.substring(0, 3);
        position = COORD_QUEUE.peek();
        COORD_QUEUE.offer(COORD_QUEUE.poll());
        System.out.println("Monster: "+position);
        if (! temp.matches(position.substring(0, 3)))
            AudioPlayer.playEffect(24);

        playFootsteps();
    }
    // ========================================================================
    private static void playFootsteps() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(FOOTSTEPS));

            ((FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN))
                    .setValue(determineVolume().getVol());

            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | 
                 IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    // ========================================================================
    private static Volume determineVolume() {
        String monstId = position.substring(0, 3),
               plyrId = Player.getPosId().substring(0, 3);

        if ((monstId.matches("CIS") && ! plyrId.matches("OUB|AAR|CIS")) ||
                (monstId.matches("SEW") && ! plyrId.matches("SEW|PRI|INT")) ||
                    (plyrId.matches("TOR|CRY|DKC")))
            return Volume.NONE;

        else if (Player.getPos().isAdjacent(position)) { 
            if (monstId.equals(plyrId)) 
                return Volume.LOUD;
            else
                return Volume.MEDIUM_LOUD;
        }

        else {
            double d = determineProximity();

            if (monstId.equals(plyrId)) {
                if (d <= 1.9)
                    return Volume.MEDIUM_LOUD;
                else if (d > 1.9 && d <= 2.2)
                    return Volume.MEDIUM;
                else if (d > 2.2 && d <= 3.5)
                    return Volume.MEDIUM_SOFT;
                else
                    return Volume.SOFT;
            } 
            else {
                if (d <= 2.0)
                    return Volume.MEDIUM_SOFT;
                else if (d > 2.0 && d <= 3.0)
                    return Volume.SOFT;
                else
                    return Volume.VERY_SOFT;
            }
        }
    }
    // ========================================================================
    private static double determineProximity() {
        int[] plyrCrd = Player.getPos().getCoords();
        int[] thisCrd = Player.getRoomObj(position).getCoords();

        return sqrt(
                pow(abs(thisCrd[2] - plyrCrd[2]), 2) + 
                    pow(abs(thisCrd[1] - plyrCrd[1]), 2)
        );
    }
    // ========================================================================
    public static synchronized void checkForPlayer() {
        if (position.equals(Player.getPosId()))
            capturePlayer();
    }
    // ========================================================================
    public static void capturePlayer() {
        timer.cancel();
        
        Player.setOccupies(Id.INTR);
        captureDialog();
        ((Sewp)Player.getRoomObj(Id.SEWP)).resetAllObjects();
        
        startMovement();
    }
    // ========================================================================
    public static boolean isInactive() {
        return timer == null;
    }
    // ========================================================================
    private static void captureDialog() {
        GUI.out("The hideous creature lassos you with its chain and drags\n"
              + "you back to the tiny untility room. Your items are taken.\n"
              + "The creature seems too mindless to take your keys though.");
        
        AudioPlayer.playEffect(24);
    }
    // ========================================================================
    public static String getPos() {
        return position;
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    /**
     * Every fixed interval of time, moves the monster, plays a sound, and
     * checks for player.
     */
    private static class Creature_Task extends TimerTask {
        @Override public void run() {
            // Monster only moves if the player is in Z-coordinate 4, the dungeon/tunnel area.
            // Does not move if player is in the vault (Column 8 in map).
            if (Player.getPos().getCoords()[0] == 4 && 
                    Player.getPos().getCoords()[1] < 7) {
                Dungeon_Monst.move();
                Dungeon_Monst.checkForPlayer();
            }
        }
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}


