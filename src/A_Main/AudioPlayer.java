package A_Main;
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
    public final static String WD = System.getProperty("user.dir");
    public final static String S = System.getProperty("file.separator");
    private static String trackName;
    private static boolean muted = false;
    private static Clip currentMusic, effectClip;
    
//******************************************************************************
// <editor-fold desc="AMBIENT TRACKS"> 
//******************************************************************************    
    private static File nightAmbience = new File(WD, "ambience" + S + "nightAmbience.wav");
    private static File wavesCrashing = new File(WD, "ambience" + S + "wavesCrashing.wav");
    private static File spookyWindInterior = new File(WD, "ambience" + S + "spookyWindInterior.wav");
    private static File antechamberCustom = new File(WD, "ambience" + S + "antechamberCustom.wav");
    private static File galChoir = new File(WD, "ambience" + S + "galChoir.wav");
    private static File gal1wCustom = new File(WD, "ambience" + S + "gal1wCustom.wav");
    private static File gal2wCustom = new File(WD, "ambience" + S + "gal2wCustom.wav");
    private static File gal3wCustom = new File(WD, "ambience" + S + "gal3wCustom.wav");
    private static File rotundaCustom = new File(WD, "ambience" + S + "rotundaCustom.wav");
    private static File ironHallCustom = new File(WD, "ambience" + S + "ironHallCustom.wav");
    private static File westWingCustom = new File(WD, "ambience" + S + "westWingCustom.wav");
    private static File dungeonStairs = new File(WD, "ambience" + S + "dungeonStairs.wav");
    private static File creepyOrgan = new File(WD, "ambience" + S + "creepyOrgan.wav");
    private static File parlorCustom = new File(WD, "ambience" + S + "parlorCustom.wav");
    private static File loungeCustom = new File(WD, "ambience" + S + "loungeCustom.wav");
    private static File marbleHall = new File(WD, "ambience" + S + "marbleHall.wav");
    private static File workshopCustom = new File(WD, "ambience" + S + "workshopCustom.wav");
    private static File kitchenCustom = new File(WD, "ambience" + S + "kitchenCustom.wav");
    private static File libraryCustom = new File(WD, "ambience" + S + "libraryCustom.wav");
    private static File westBalconyCustom = new File(WD, "ambience" + S + "westBalconyCustom.wav");
    private static File fireplace = new File(WD, "ambience" + S + "fire.wav");
    private static File backHallCustom = new File(WD, "ambience" + S + "backHall.wav");
    private static File gardenCustom = new File(WD, "ambience" + S + "gardenCustom.wav");
    private static File deepSpace = new File(WD, "ambience" + S + "deepSpace.wav");
    private static File atticCustom = new File(WD, "ambience" + S + "atticCustom.wav");
    
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
        put("JHA1", parlorCustom);         put("JHA2", parlorCustom);
        put("MHA1", marbleHall);           put("MHA2", marbleHall);
        put("MHA3", marbleHall);           put("DIN1", loungeCustom);
        put("DRAR", loungeCustom);         put("DIN2", loungeCustom);
        put("LIB1", libraryCustom);        put("WBAL", westBalconyCustom);
        put("LIB2", libraryCustom);        put("LIB3", libraryCustom);
        put("LIB5", libraryCustom);        put("LIB4", libraryCustom);
        put("BBA1", backHallCustom);       put("BBA2", backHallCustom);
        put("BBA3", backHallCustom);       put("GAR1", gardenCustom);
        put("GAR2", gardenCustom);         put("GAR3", gardenCustom);
        put("GAR4", gardenCustom);         put("GQUA", westWingCustom);
        put("COUS", deepSpace);            put("SST1", atticCustom);
        put("SST2", atticCustom);          put("ATT1", atticCustom);
        put("ATT2", atticCustom);
    }};
//******************************************************************************    
// </editor-fold>
//******************************************************************************
    

//******************************************************************************
// <editor-fold desc="SOUND EFFECTS"> 
//******************************************************************************    
    private static final HashMap<Integer, File> EFFECTS = new HashMap() {{
        put(0,  new File(WD, "effects" + S + "steps.wav"));      
        put(1,  new File(WD, "effects" + S + "inventory.wav"));      
        put(2,  new File(WD, "effects" + S + "pageTurn.wav"));
        put(3,  new File(WD, "effects" + S + "keys.wav"));       
        put(4,  new File(WD, "effects" + S + "doorKnock.wav"));    
        put(5,  new File(WD, "effects" + S + "doorLocking.wav"));
        put(6,  new File(WD, "effects" + S + "wallThump.wav"));  
        put(7,  new File(WD, "effects" + S + "gateSlam.wav"));     
        put(8,  new File(WD, "effects" + S + "doorSlam.wav"));
        put(9,  new File(WD, "effects" + S + "doorClose.wav"));  
        put(10, new File(WD, "effects" + S + "basicClick.wav"));  
        put(11, new File(WD, "effects" + S + "buttonPush.wav"));
        put(12, new File(WD, "effects" + S + "leverPull.wav")); 
        put(13, new File(WD, "effects" + S + "doorUnlock.wav"));  
        put(14, new File(WD, "effects" + S + "woodStairClimb.wav"));
        put(15, new File(WD, "effects" + S + "stoneSteps.wav"));
        put(16, new File(WD, "effects" + S + "ladder.wav"));
        put(17, new File(WD, "effects" + S + "select.wav"));
        put(18, new File(WD, "effects" + S + "rotundaRotate.wav"));
        put(19, new File(WD, "effects" + S + "rotundaRotate2.wav"));
        put(20, new File(WD, "effects" + S + "valveTurn.wav"));
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
        if (! muted && (trackName == null || ! trackName.matches(TRACKS.get(ID).getName())) ) {
            
            if (currentMusic != null)
                stopTrack();
            
            try {
                currentMusic = AudioSystem.getClip();
                currentMusic.open(AudioSystem.getAudioInputStream(TRACKS.get(ID)));
                currentMusic.start();
                currentMusic.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException | UnsupportedAudioFileException | 
                    IOException e) {
                System.out.println(e.getMessage());
            }

            trackName = TRACKS.get(ID).getName(); 
        }
    }
// ============================================================================
    /**
     * Plays sound effects when certain events happen.
     * 
     * @param ID An integer corresponding to a sound effect.
     */
    public static void playEffect(int ID) {
        try {
            effectClip = AudioSystem.getClip();
            effectClip.open(AudioSystem.getAudioInputStream(EFFECTS.get(ID)));
            effectClip.start(); 
        } catch (LineUnavailableException | UnsupportedAudioFileException | 
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
// ============================================================================
    public static void stopTrack() {
        currentMusic.close();
        trackName = null;
    }
// ============================================================================
    public static void muteTrack() {
        muted = ! muted;
        
        if (currentMusic.isActive()) 
            stopTrack();
        else 
            playTrack(Player.getOcc().getID());
    }
//******************************************************************************    
// </editor-fold>
//******************************************************************************
}
