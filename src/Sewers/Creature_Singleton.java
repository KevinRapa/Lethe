package Sewers;

import A_Super.Furniture;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Kevin Rapa
 */
public class Creature_Singleton extends Furniture {
    private static final Creature_Singleton CREATURE = new Creature_Singleton();
    
    private String position = "SEW0";
    private final LinkedList<String> ROOM_QUEUE = new LinkedList<>();
    private final String[] ROOM_LIST = {};
    // ========================================================================
    private Creature_Singleton () {
        super();
        this.searchable = false;

        this.ROOM_QUEUE.addAll(Arrays.asList(ROOM_LIST));
        
        this.description = "";
        this.searchDialog = "";
        this.useDialog = this.actDialog = "You wouldn't think to go near that thing.";

        this.addNameKeys("(?: )?(?: )?(?: )?(?:|)");
        this.addUseKeys(".+");
        this.addActKeys(".+");
    }
    // ======================================================================== 
    /*@Override public String getDescription() {
        
    }
    // ======================================================================== 
    public static boolean checkPlayer() {
        
    }
    // ======================================================================== 
    public static void capturePlayer() {
        
    }
    // ========================================================================
    public static Creature_Singleton getInstance() {
        return CREATURE;
    }
    // ========================================================================
    // ************************************************************************
    // ========================================================================
    private class Creature_Task extends TimerTask {
        @Override public void run() {
            if(Creature_Singleton.checkPlayer()) 
                synchronized (this) {
                    try {
                        this.wait();
                        Creature_Singleton.capturePlayer();
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
        }
    }*/
    // ========================================================================
    // ************************************************************************
    // ========================================================================
}
