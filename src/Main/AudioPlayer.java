package Main;
/**
 * Maps every room to an audio file that will play whenever that room is moved
 * into, and maps various events to sound effects.
 * 
 * @author Kevin Rapa
 */
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    private static Thread audioThread;
    private static String currentTrack;
    private static Clip currentClip;
    
//******************************************************************************
// <editor-fold desc="AMBIENT TRACKS"> 
//******************************************************************************    
    private static File nightAmbience = new File("nightAmbience.wav");
    private static File wavesCrashing = new File("wavesCrashing.wav");
    private static File spookyWindInterior = new File("spookyWindInterior.wav");
    private static File antechamberCustom = new File("antechamberCustom.wav");
    private static File galChoir = new File("galChoir.wav");
    private static File gal1wCustom = new File("gal1wCustom.wav");
    private static File gal2wCustom = new File("gal2wCustom.wav");
    private static File gal3wCustom = new File("gal3wCustom.wav");
    private static File rotundaCustom = new File("rotundaCustom.wav");
    private static File ironHallCustom = new File("ironHallCustom.wav");
    private static File westWingCustom = new File("westWingCustom.wav");
    private static File dungeonStairs = new File("dungeonStairs.wav");
    private static File creepyOrgan = new File("creepyOrgan.wav");
    private static File parlorCustom = new File("parlorCustom.wav");
    private static File loungeCustom = new File("loungeCustom.wav");
    private static File marbleHall = new File("marbleHall.wav");
    private static File workshopCustom = new File("workshopCustom.wav");
    private static File kitchenCustom = new File("kitchenCustom.wav");
    private static File libraryCustom = new File("libraryCustom.wav");
    private static File westBalconyCustom = new File("westBalconyCustom.wav");
    private static File fireplace = new File("fire.wav");
    
    private static final HashMap<String, File> TRACKS = new HashMap() {{
        put("COU1", nightAmbience);        put("COU2", nightAmbience);
        put("COU3", nightAmbience);        put("COU4", nightAmbience);
        put("COU5", nightAmbience);        put("COU6", nightAmbience);
        put("FOY1", spookyWindInterior);   put("FOY2", spookyWindInterior);
        put("FOY3", spookyWindInterior);   put("FOY4", spookyWindInterior);
        put("COU7", nightAmbience);        put("VEST", spookyWindInterior);
        put("FOYB", wavesCrashing);        put("FOYC", wavesCrashing);
        put("LOOK", wavesCrashing);        put("STUD", fireplace);
        put("FOYW", antechamberCustom);    put("WORK", workshopCustom);
        put("GAL2", galChoir);             put("GAL4", galChoir);
        put("GAL1", gal1wCustom);          put("GAL3", gal2wCustom);
        put("GAL6", gal3wCustom);          put("ROTU", rotundaCustom);
        put("IHA1", ironHallCustom);       put("IHA2", ironHallCustom);
        put("WOW1", westWingCustom);       put("WOW2", westWingCustom);
        put("WOW3", westWingCustom);       put("SHA1", westWingCustom);
        put("SHA2", westWingCustom);       put("SQUA", westWingCustom);
        put("EOW1", westWingCustom);       put("EOW2", westWingCustom);  
        put("EOW4", westWingCustom);       put("KITC", kitchenCustom);
        put("SHAR", westWingCustom);       put("DST1", dungeonStairs);
        put("CHS1", creepyOrgan);          put("CHS3", creepyOrgan);
        put("CHA1", creepyOrgan);          put("CHA2", creepyOrgan);
        put("PAR1", parlorCustom);         put("PAR2", parlorCustom);
        put("MHA1", marbleHall);           put("MHA2", marbleHall);
        put("MHA3", marbleHall);           put("DIN1", loungeCustom);
        put("DRAR", loungeCustom);         put("DIN2", loungeCustom);
        put("LIB1", libraryCustom);        put("WBAL", westBalconyCustom);
        put("LIB2", libraryCustom);        put("LIB3", libraryCustom);
        put("LIB5", libraryCustom);        put("LIB4", libraryCustom);
        
    }};
//******************************************************************************    
// </editor-fold>
//******************************************************************************
    

//******************************************************************************
// <editor-fold desc="SOUND EFFECTS"> 
//******************************************************************************    
    private static File invOpen = new File("inventory.wav");
    private static File steps = new File("steps.wav");
    private static File pageTurn = new File("pageTurn.wav");
    private static File keys = new File("keys.wav");
    private static File doorLock = new File("doorLocking.wav");
    private static File doorKnock = new File("doorKnock.wav");
    private static File wallThump = new File("wallThump.wav");
    private static File gateSlam = new File("gateSlam.wav");
    private static File doorSlam = new File("doorSlam.wav");
    private static File doorClose = new File("doorClose.wav");
    private static File basicClick = new File("basicClick.wav");
    private static File buttonPush = new File("buttonPush.wav");
    private static File leverPull = new File("leverPull.wav");
    private static File doorUnlock = new File("doorUnlock.wav");
    private static File woodStairs = new File("woodStairClimb.wav");
    private static File stoneSteps = new File("stoneSteps.wav");
    private static File ladder = new File("ladder.wav");
    
    private static final HashMap<Integer, File> EFFECTS = new HashMap() {{
        put(0, steps);      put(1, invOpen);      put(2, pageTurn);
        put(3, keys);       put(4, doorKnock);    put(5, doorLock);
        put(6, wallThump);  put(7, gateSlam);     put(8, doorSlam);
        put(9, doorClose);  put(10, basicClick);  put(11, buttonPush);
        put(12, leverPull); put(13, doorUnlock);  put(14, woodStairs);
        put(15, stoneSteps);put(16, ladder);
    }};
//******************************************************************************    
// </editor-fold>
//******************************************************************************
    
 
//******************************************************************************
// <editor-fold desc="METHODS"> 
//******************************************************************************   
    /**
     * Stops the current track and starts a new one if the room
     * if the player entered is mapped to a different track OR if
     * the current track is null (i.e. the game has just started).
     * 
     * @param ID A room ID.
     */
    public static void playTrack(String ID) {
        if (currentTrack == null || ! currentTrack.matches(TRACKS.get(ID).getName())) {
            
            if (currentClip != null)
                stopTrack();
            
            // Creates a new thread that will run the ambient track.
            audioThread = new Thread() {
                // ----------------------------------------
                @Override public void run() {
                    try {
                        currentClip = AudioSystem.getClip();
                        currentClip.open(AudioSystem.getAudioInputStream(TRACKS.get(ID)));
                        currentClip.start();

                        while(this.isAlive())
                            currentClip.loop(1);

                    } catch (LineUnavailableException | UnsupportedAudioFileException | 
                             IOException e) {
                        System.out.println(e.getMessage());
                    }
                }  
                // ----------------------------------------
            };

            currentTrack = TRACKS.get(ID).getName();
            audioThread.setDaemon(true);
            audioThread.start();  
        }
    }
// ============================================================================
    /**
     * Plays sound effects when certain events happen.
     * 
     * @param ID An integer corresponding to a sound effect.
     */
    public static void playEffect(int ID) {
        Thread effect = new Thread() {
                // ================================================
                // Creates a new thread that will run the ambient track.
                @Override public void run() {
                    try {
                        Clip effectClip = AudioSystem.getClip();
                        effectClip.open(AudioSystem.getAudioInputStream(EFFECTS.get(ID)));
                        effectClip.start(); 
                    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                // ================================================    
            };
        
        effect.start();
    }
// ============================================================================
    public static void stopTrack() {
        currentClip.close();
        audioThread.interrupt();
    }
//******************************************************************************    
// </editor-fold>
//******************************************************************************
}
