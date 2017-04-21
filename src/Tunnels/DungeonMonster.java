package Tunnels;

import static java.lang.Math.*;
import static A_Main.Patterns.*;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Main.AudioPlayer;
import A_Super.Direction;
import Strange_Pool.Sewp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
/**
 * This class simulates a creature that roams the halls of the tunnels.
 * 
 * The monster uses a queue to switch rooms at fixed intervals. Every time the
 * player or monster moves, the monster checks for the player. 
 * 
 * The monster does not move if the player is not in the dungeon area.
 * 
 * @see Tunnels.DungeonMonsterFurniture
 * @author Kevin Rapa
 */
public class DungeonMonster {
    //-------------------------------------------------------------------------
    private static enum Volume {
        NONE(0.0), // Not supposed to play.
        VERY_SOFT(0.02),
        SOFT(0.04),
        MEDIUM_SOFT(0.07),
        MEDIUM(0.1),
        MEDIUM_LOUD(0.3),
        LOUD(0.5);

        private final double VOL;
        
        Volume(double vol) {
            this.VOL = vol;
        }
        public double getVol() {
            return this.VOL;
        }
    } 
    //---------------------------------------
    private static String position = Id.SEW0;
    private static final LinkedList<String> ROOM_QUEUE = new LinkedList<String>() {{
        String[] ROOM_LIST = {Id.SEW0, Id.SEW1, Id.SEW2, Id.SEW3, Id.SEW4, Id.SEW5,
                              Id.CIS1, Id.CIS2, Id.CIS3, Id.CIS4, Id.CIS3, Id.CIS2,
                              Id.CIS1, Id.SEW5, Id.SEW4, Id.SEW3, Id.SEW2, Id.SEW1};
        addAll(Arrays.asList(ROOM_LIST));
    }};
    private static Timer timer;
    //-------------------------------------------------------------------------
    public final static void startMovement() {
        timer = new Timer(true);
        timer.schedule(new Creature_Task(), 5000, 5000);
    }
    //-------------------------------------------------------------------------
    private static void move() {
        String temp = Id.areaName(position);
        position = ROOM_QUEUE.peek();
        ROOM_QUEUE.offer(ROOM_QUEUE.poll());
        System.out.println("Monster: " + position);
        
        if (! temp.matches(Id.areaName(position)) && 
            ! NO_SOUND_AREA.matcher(Id.areaName(Player.getPosId())).matches())
            AudioPlayer.playEffect(24);

        Volume vol = determineVolume();
        
        if (vol != Volume.NONE)
            AudioPlayer.playEffect(25, vol.getVol());
    }
    //-------------------------------------------------------------------------
    private static Volume determineVolume() {
        String monstId = Id.areaName(position),
               plyrId = Id.areaName(Player.getPosId());

        if ((monstId.equals("CIS") && ! CISTERN_AREA.matcher(plyrId).matches()) ||
            (monstId.equals("SEW") && ! TUNNEL_AREA.matcher(plyrId).matches()) ||
            (NO_SOUND_AREA.matcher(plyrId).matches())) 
        {
            return Volume.NONE;
        }
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
    //-------------------------------------------------------------------------
    private static double determineProximity() {
        int[] plyrCrd = Player.getPos().getCoords();
        int[] thisCrd = Player.getRoomObj(position).getCoords();

        return sqrt(
                pow(abs(thisCrd[2] - plyrCrd[2]), 2) + 
                    pow(abs(thisCrd[1] - plyrCrd[1]), 2)
        );
    }
    //-------------------------------------------------------------------------
    public static synchronized void checkForPlayer() {
        if (Id.areaName(Player.getPosId()).matches(Id.areaName(position)) 
                && (determineProximity() == 1.0))
            warnPlayer();
        
        if (position.equals(Player.getPosId()))
            capturePlayer();
    }
    //-------------------------------------------------------------------------
    private static void warnPlayer() {
        String result = "That creature is very close! It's directly ";
        int[] plyrCrd = Player.getPos().getCoords();
        int[] thisCrd = Player.getRoomObj(position).getCoords();
        
        if (plyrCrd[1] < thisCrd[1])
            GUI.out(result + Direction.SOUTH + "!");
        else if (plyrCrd[1] > thisCrd[1])            
            GUI.out(result + Direction.NORTH + "!");
        else if (plyrCrd[2] < thisCrd[2])
            GUI.out(result + Direction.EAST + "!");
        else
            GUI.out(result + Direction.WEST + "!");
        
    }
    //-------------------------------------------------------------------------
    public static void capturePlayer() {
        timer.cancel();
        
        Player.setOccupies(Id.INTR);
        captureDialog();
        ((Sewp)Player.getRoomObj(Id.SEWP)).resetAllObjects();
        
        startMovement();
    }
    //-------------------------------------------------------------------------
    public static boolean isInactive() {
        return timer == null;
    }
    //-------------------------------------------------------------------------
    /**
     * Turns the monster around when player climbs the stairs in SEW0.
     * Allows player to escape the creature if cornered in SEW0.
     */
    public static void turnMonsterAround() {
        while (! ROOM_QUEUE.peek().equals(DungeonMonster.position))
            ROOM_QUEUE.offer(ROOM_QUEUE.poll());
        
        ROOM_QUEUE.offer(ROOM_QUEUE.poll());
    }
    //-------------------------------------------------------------------------
    private static void captureDialog() {
        GUI.out("The hideous creature lassos you with its chain and drags "
              + "you back to the tiny untility room. Your items are taken. "
              + "The creature seems too mindless to take your keys though.");
        
        AudioPlayer.playEffect(24);
    }
    //-------------------------------------------------------------------------
    public static String getPos() {
        return position;
    }
    //-------------------------------------------------------------------------
    // ************************************************************************
    //-------------------------------------------------------------------------
    /**
     * Every fixed interval of time, moves the monster, plays a sound, and
     * checks for player.
     */
    private static class Creature_Task extends TimerTask {
        @Override public void run() {
            // Monster only moves if the player is in Z-coordinate 4, the dungeon/tunnel area.
            // Does not move if player is in the vault (Column 8 in map).
            if (Player.getPos().getCoords()[0] == 4 && 
                    Player.getPos().getCoords()[2] < 7) {
                DungeonMonster.move();
                DungeonMonster.checkForPlayer();
            }
        }
    }
    //-------------------------------------------------------------------------
    // ************************************************************************
    //-------------------------------------------------------------------------
}


