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
    public final static String WD = System.getProperty("user.dir"),
                                S = System.getProperty("file.separator");
    private static String trackName;
    private static boolean muted = false;
    private static Clip currentMusic, effectClip;
    
//******************************************************************************
// <editor-fold desc="AMBIENCE AND MUSIC"> 
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
    private static File obsCustom = new File(WD, "ambience" + S + "obsCustom.wav");
    private static File labCustom = new File(WD, "ambience" + S + "labCustom.wav");
    private static File caves = new File(WD, "ambience" + S + "caveLoop.wav");
    private static File deepCave = new File(WD, "ambience" + S + "caveDistortion.wav");
    private static File tombs = new File(WD, "ambience" + S + "tombCustom.wav");
    private static File sewerTunnels = new File(WD, "ambience" + S + "sewerHallCustom.wav");
    private static File cistern = new File(WD, "ambience" + S + "cisternCustom.wav");
    private static File aeolianHarp = new File(WD, "ambience" + S + "aeolianWindHarp.wav");
    private static File prisonCustom = new File(WD, "ambience" + S + "prisonCustom.wav");
    private static File sewerCogwork = new File(WD, "ambience" + S + "sewerCogwork.wav");
    private static File sewpCustom = new File(WD, "ambience" + S + "sewpCustom.wav");
    private static File torcCustom = new File(WD, "ambience" + S + "torcCustom.wav");
    
    private static final HashMap<String, File> TRACKS = new HashMap() {
        // ====================================================================
        {
        putAllTracks(nightAmbience, Id.COU1, Id.COU2, Id.COU3, Id.COU4, Id.COU5, Id.COU6, Id.COU7);
        putAllTracks(spookyWindInterior, Id.FOY1, Id.FOY2, Id.FOY3, Id.FOY4, Id.VEST);
        putAllTracks(wavesCrashing, Id.FOYB, Id.LOOK, Id.FOYC);
        putAllTracks(ironHallCustom, Id.IHA1, Id.IHA2);
        putAllTracks(westWingCustom, Id.WOW1, Id.WOW2, Id.WOW3, Id.SHA1, Id.SHA2, Id.SQUA, 
                                     Id.EOW1, Id.EOW2, Id.EOW4, Id.SHAR, Id.CLOS);
        putAllTracks(galChoir, Id.GAL2, Id.GAL4, Id.GAL5);
        putAllTracks(creepyOrgan, Id.CHS1, Id.CHS3, Id.CHA1, Id.CHA2);
        putAllTracks(parlorCustom, Id.PAR1, Id.PAR2, Id.JHA1, Id.JHA2);
        putAllTracks(marbleHall, Id.MHA1, Id.MHA2, Id.MHA3);
        putAllTracks(loungeCustom, Id.DIN1, Id.DIN2, Id.DRAR);
        putAllTracks(libraryCustom, Id.LIB1, Id.LIB2, Id.LIB3, Id.LIB4, Id.LIB5);
        putAllTracks(backHallCustom, Id.BHA1, Id.BHA2, Id.BHA3);
        putAllTracks(gardenCustom, Id.GAR1, Id.GAR2, Id.GAR3, Id.GAR4);
        putAllTracks(atticCustom, Id.SST1, Id.SST2, Id.ATT1, Id.ATT2);
        putAllTracks(obsCustom, Id.OBS1, Id.OBS2, Id.OBS3);
        putAllTracks(caves, "CT", "CV", Id.MY18);
        putAllTracks(deepCave, Id.MS65, Id.MS66);
        putAllTracks(tombs, Id.TM16, Id.TM66, Id.TM32, Id.AN65, Id.AN55);
        putAllTracks(sewerTunnels, Id.SEW0, Id.SEW1, Id.SEW2, Id.SEW3, Id.SEW4, Id.SEW5);
        putAllTracks(cistern, Id.CIS1, Id.CIS2, Id.CIS3, Id.CIS4);
        putAllTracks(aeolianHarp, Id.OUB1, Id.OU62, Id.AARC);
        putAllTracks(prisonCustom, Id.PRIS, Id.TORC);
        putAllTracks(sewerCogwork, Id.INTR, Id.ESC1, Id.ESC2, Id.ESC3, Id.ESC4, Id.ESC5, Id.ESC6, Id.ARCH);
        putAllTracks(torcCustom, Id.TORC, Id.CRY1, Id.CRY2, Id.CAS1, Id.CS35);
        
        put(Id.GAL1, gal1wCustom);       put(Id.GAL3, gal2wCustom); 
        put(Id.GAL6, gal3wCustom);       put(Id.LABO, labCustom);
        put(Id.KITC, kitchenCustom);     put(Id.DST1, dungeonStairs);
        put(Id.STUD, fireplace);         put(Id.FOYW, antechamberCustom); 
        put(Id.WORK, workshopCustom);    put(Id.ROTU, rotundaCustom);
        put(Id.WBAL, westBalconyCustom); put(Id.COUS, deepSpace);
        put(Id.SEWP, sewpCustom);
        }
        // ====================================================================
        private void putAllTracks(File track, String ... ids) {
            for (String id : ids) 
                put(id, track);
        }
        // ====================================================================
    };
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
        put(17, new File(WD, "effects" + S + "dungeonValve.wav"));
        put(18, new File(WD, "effects" + S + "rotundaRotate.wav"));
        put(19, new File(WD, "effects" + S + "rotundaRotate2.wav"));
        put(20, new File(WD, "effects" + S + "valveTurn.wav"));
        put(21, new File(WD, "effects" + S + "keyClick.wav"));
        put(22, new File(WD, "effects" + S + "keyClick2.wav"));
        put(23, new File(WD, "effects" + S + "keyClick3.wav"));
        put(24, new File(WD, "effects" + S + "dungeonDoor.wav"));
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
        if (ID.matches("C[TV]\\d{2}")) // For caves and catacombs.
            ID = ID.replaceAll("\\d", "");
        
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
            playTrack(Player.getPosId());
    }
//******************************************************************************    
// </editor-fold>
//******************************************************************************
}
