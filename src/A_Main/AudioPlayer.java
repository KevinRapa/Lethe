package A_Main;
/**
 * Maps every room to an audio file that will play whenever that room is moved
 * into, and maps various events to sound effects.
 * Tried using mp3 instead, however the mp3s did not loop well.
 * Trying .ogg currently, but there is little support for it.
 * 
 * @author Kevin Rapa
 */
import static A_Main.Id.*;
import static A_Main.Patterns.*;
import java.util.HashMap;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import static A_Main.NameConstants.FILE_SEP;
import static A_Main.NameConstants.WORK_DIR;

public class AudioPlayer {
    public final static String 
            TRKPATH = "ambience" + FILE_SEP,
            FXPATH = "effects" + FILE_SEP,
            EXT = ".mp3";
    
    private static String trackName;
    private static boolean muted = false;
    private static Media currentMusic;
    private static MediaPlayer player;
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="AMBIENCE AND MUSIC"> 
//******************************************************************************    
    private static File 
        nightAmbience =     new File(WORK_DIR, TRKPATH + "nightAmbience" + EXT),
        wavesCrashing =     new File(WORK_DIR, TRKPATH + "wavesCrashing" + EXT),
        spookyInterior =    new File(WORK_DIR, TRKPATH + "spookyWindInterior" + EXT),
        antechamberCustom = new File(WORK_DIR, TRKPATH + "antechamberCustom" + EXT),
        galChoir =          new File(WORK_DIR, TRKPATH + "galChoir" + EXT),
        gal1wCustom =       new File(WORK_DIR, TRKPATH + "gal1wCustom" + EXT),
        gal2wCustom =       new File(WORK_DIR, TRKPATH + "gal2wCustom" + EXT),
        gal3wCustom =       new File(WORK_DIR, TRKPATH + "gal3wCustom" + EXT),
        rotundaCustom =     new File(WORK_DIR, TRKPATH + "rotundaCustom" + EXT),
        ironHallCustom =    new File(WORK_DIR, TRKPATH + "ironHallCustom" + EXT),
        westWingCustom =    new File(WORK_DIR, TRKPATH + "westWingCustom" + EXT),
        dungeonStairs =     new File(WORK_DIR, TRKPATH + "dungeonStairs" + EXT),
        creepyOrgan =       new File(WORK_DIR, TRKPATH + "creepyOrgan" + EXT),
        parlorCustom =      new File(WORK_DIR, TRKPATH + "parlorCustom" + EXT),
        loungeCustom =      new File(WORK_DIR, TRKPATH + "loungeCustom" + EXT),
        marbleHall =        new File(WORK_DIR, TRKPATH + "marbleHall" + EXT),
        workshopCustom =    new File(WORK_DIR, TRKPATH + "workshopCustom" + EXT),
        kitchenCustom =     new File(WORK_DIR, TRKPATH + "kitchenCustom" + EXT),
        libraryCustom =     new File(WORK_DIR, TRKPATH + "libraryCustom" + EXT),
        westBalconyCustom = new File(WORK_DIR, TRKPATH + "westBalconyCustom" + EXT),
        fireplace =         new File(WORK_DIR, TRKPATH + "fire" + EXT),
        backHallCustom =    new File(WORK_DIR, TRKPATH + "backHall" + EXT),
        gardenCustom =      new File(WORK_DIR, TRKPATH + "gardenCustom" + EXT),
        deepSpace =         new File(WORK_DIR, TRKPATH + "deepSpace" + EXT),
        atticCustom =       new File(WORK_DIR, TRKPATH + "atticCustom" + EXT),
        obsCustom =         new File(WORK_DIR, TRKPATH + "obsCustom" + EXT),
        labCustom =         new File(WORK_DIR, TRKPATH + "labCustom" + EXT),
        caves =             new File(WORK_DIR, TRKPATH + "caveLoop" + EXT),
        deepCave =          new File(WORK_DIR, TRKPATH + "caveDistortion.wav"),
        tombs =             new File(WORK_DIR, TRKPATH + "tombCustom" + EXT),
        sewerTunnels =      new File(WORK_DIR, TRKPATH + "sewerHallCustom" + EXT),
        cistern =           new File(WORK_DIR, TRKPATH + "cisternCustom" + EXT),
        aeolianHarp =       new File(WORK_DIR, TRKPATH + "aeolianWindHarp" + EXT),
        prisonCustom =      new File(WORK_DIR, TRKPATH + "prisonCustom" + EXT),
        sewerCogwork =      new File(WORK_DIR, TRKPATH + "sewerCogwork" + EXT),
        sewpCustom =        new File(WORK_DIR, TRKPATH + "sewpCustom" + EXT),
        torcCustom =        new File(WORK_DIR, TRKPATH + "torcCustom" + EXT),
        titleTrack =        new File(WORK_DIR, TRKPATH + "titleTrack" + EXT),
        tbalCustom =        new File(WORK_DIR, TRKPATH + "tbalCustom" + EXT);
    
    private static final HashMap<String, Media> TRACKS = 
            new HashMap<String, Media>() {
        // ====================================================================
        {
        putAllTracks(nightAmbience, COU1, COU2, COU3, COU4, COU5, COU6, COU7, COU8);
        putAllTracks(spookyInterior, FOY1, FOY2, FOY3, FOY4, VEST);
        putAllTracks(wavesCrashing, FOYB, LOOK, FOYC);
        putAllTracks(ironHallCustom, IHA1, IHA2);
        putAllTracks(westWingCustom, WOW1, WOW2, WOW3, SHA1, SHA2, SQUA, 
                                     EOW1, EOW2, EOW4, SHAR, CLOS);
        putAllTracks(galChoir, GAL2, GAL4, GAL5);
        putAllTracks(creepyOrgan, CHS1, CHS3, CHA1, CHA2);
        putAllTracks(parlorCustom, PAR1, PAR2, JHA1, JHA2);
        putAllTracks(marbleHall, MHA1, MHA2, MHA3);
        putAllTracks(loungeCustom, DIN1, DIN2, DRAR);
        putAllTracks(libraryCustom, LIB1, LIB2, LIB3, LIB4, LIB5);
        putAllTracks(backHallCustom, BHA1, BHA2, BHA3);
        putAllTracks(gardenCustom, GAR1, GAR2, GAR3, GAR4);
        putAllTracks(atticCustom, SST1, SST2, ATT1, ATT2);
        putAllTracks(obsCustom, OBS1, OBS2, OBS3);
        putAllTracks(caves, "CT", "CV", Id.MY18);
        putAllTracks(deepCave, MS65, MS66);
        putAllTracks(tombs, TM16, TM66, TM32, AN65, AN55, VAUE);
        putAllTracks(sewerTunnels, SEW0, SEW1, SEW2, SEW3, SEW4, SEW5);
        putAllTracks(cistern, CIS1, CIS2, CIS3, CIS4);
        putAllTracks(aeolianHarp, OUB1, OU62, AARC);
        putAllTracks(prisonCustom, PRIS, TORC);
        putAllTracks(sewerCogwork, INTR, ESC1, ESC2, ESC3, ESC4, ESC5, ESC6, DKCH);
        putAllTracks(torcCustom, TORC, CRY1, CRY2, CAS1, CS35);
        putAllTracks(titleTrack, BLS1, BLS2, TOW1, TOW2, LQU1, LQU2, SOUL, ENDG);
        putAllTracks(antechamberCustom, FOYW, VAUE, VAU1, VAU2); 
        
        put(GAL1, new Media(gal1wCustom.toURI().toString()));         
        put(GAL3, new Media(gal2wCustom.toURI().toString()));     
        put(GAL6, new Media(gal3wCustom.toURI().toString()));             
        put(LABO, new Media(labCustom.toURI().toString()));    
        put(KITC, new Media(kitchenCustom.toURI().toString()));          
        put(DST1, new Media(dungeonStairs.toURI().toString()));    
        put(STUD, new Media(fireplace.toURI().toString()));              
        put(TBAL, new Media(tbalCustom.toURI().toString()));    
        put(WORK, new Media(workshopCustom.toURI().toString()));         
        put(ROTU, new Media(rotundaCustom.toURI().toString()));    
        put(WBAL, new Media(westBalconyCustom.toURI().toString()));     
        put(COUS, new Media(deepSpace.toURI().toString()));    
        put(SEWP, new Media(sewpCustom.toURI().toString()));           
        }
        // ====================================================================
        private void putAllTracks(File track, String ... ids) {
            for (String id : ids) 
                put(id, new Media(track.toURI().toString()));
        }
        // ====================================================================
    };
    
//******************************************************************************    
// </editor-fold>
//******************************************************************************
    

//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="SOUND EFFECTS"> 
//******************************************************************************    
    private static final File[] EFFECTS = {
        new File(WORK_DIR, FXPATH + "steps" + EXT),         // 0
        new File(WORK_DIR, FXPATH + "inventory" + EXT),     // 1
        new File(WORK_DIR, FXPATH + "pageTurn" + EXT),      // 2
        new File(WORK_DIR, FXPATH + "keys" + EXT),          // 3
        new File(WORK_DIR, FXPATH + "doorKnobJiggle" + EXT),// 4   
        new File(WORK_DIR, FXPATH + "doorLocking" + EXT),   // 5
        new File(WORK_DIR, FXPATH + "wallThump" + EXT),     // 6
        new File(WORK_DIR, FXPATH + "gateSlam" + EXT),      // 7
        new File(WORK_DIR, FXPATH + "doorSlam" + EXT),      // 8
        new File(WORK_DIR, FXPATH + "doorClose" + EXT),     // 9
        new File(WORK_DIR, FXPATH + "basicClick" + EXT),    // 10
        new File(WORK_DIR, FXPATH + "buttonPush" + EXT),    // 11
        new File(WORK_DIR, FXPATH + "leverPull" + EXT),     // 12
        new File(WORK_DIR, FXPATH + "doorUnlock" + EXT),    // 13
        new File(WORK_DIR, FXPATH + "woodStairClimb" + EXT),// 14
        new File(WORK_DIR, FXPATH + "stoneSteps" + EXT),    // 15
        new File(WORK_DIR, FXPATH + "ladder" + EXT),        // 16
        new File(WORK_DIR, FXPATH + "dungeonValve" + EXT),  // 17
        new File(WORK_DIR, FXPATH + "rotundaRotate" + EXT), // 18
        new File(WORK_DIR, FXPATH + "rotundaRotate2" + EXT),// 19
        new File(WORK_DIR, FXPATH + "valveTurn" + EXT),     // 20
        new File(WORK_DIR, FXPATH + "keyClick" + EXT),      // 21
        new File(WORK_DIR, FXPATH + "keyClick2" + EXT),     // 22
        new File(WORK_DIR, FXPATH + "keyClick3" + EXT),     // 23
        new File(WORK_DIR, FXPATH + "dungeonDoor" + EXT),   // 24
        new File(WORK_DIR, FXPATH + "monster" + EXT),       // 25
        new File(WORK_DIR, FXPATH + "windowOpening" + EXT), // 26
        new File(WORK_DIR, FXPATH + "keyDrop" + EXT),       // 27
        new File(WORK_DIR, FXPATH + "foyGateSwitch" + EXT), // 28
        new File(WORK_DIR, FXPATH + "sparkles" + EXT),      // 29
        new File(WORK_DIR, FXPATH + "rocksCrumbling" + EXT),// 30
        new File(WORK_DIR, FXPATH + "ladderFalling" + EXT), // 31
        new File(WORK_DIR, FXPATH + "enchantPop" + EXT),    // 32
        new File(WORK_DIR, FXPATH + "handDrill" + EXT),     // 33
        new File(WORK_DIR, FXPATH + "digging" + EXT),       // 34
        new File(WORK_DIR, FXPATH + "metalPing" + EXT),     // 35
        new File(WORK_DIR, FXPATH + "hoseClimb" + EXT),     // 36
        new File(WORK_DIR, FXPATH + "galleryStatue" + EXT), // 37
        new File(WORK_DIR, FXPATH + "galleryGears" + EXT),  // 38
        new File(WORK_DIR, FXPATH + "fireDouse" + EXT),     // 39
        new File(WORK_DIR, FXPATH + "stairFlatten" + EXT),  // 40
        new File(WORK_DIR, FXPATH + "woodSliding" + EXT),   // 41
        new File(WORK_DIR, FXPATH + "waterScoop" + EXT),    // 42
        new File(WORK_DIR, FXPATH + "medallionClick" + EXT),// 43
        new File(WORK_DIR, FXPATH + "totemTurn" + EXT),     // 44
        new File(WORK_DIR, FXPATH + "bunsenBurner" + EXT),  // 45
        new File(WORK_DIR, FXPATH + "zombieMoan" + EXT),    // 46
        new File(WORK_DIR, FXPATH + "metalLadder" + EXT),   // 47
        new File(WORK_DIR, FXPATH + "grateMove" + EXT),     // 48
        new File(WORK_DIR, FXPATH + "teleportZap" + EXT),   // 49
        new File(WORK_DIR, FXPATH + "concreteBlock" + EXT), // 50
        new File(WORK_DIR, FXPATH + "concreteShort" + EXT), // 51
        new File(WORK_DIR, FXPATH + "atticNoise" + EXT),    // 52
        new File(WORK_DIR, FXPATH + "piano" + EXT),         // 53
        new File(WORK_DIR, FXPATH + "harp" + EXT),          // 54
        new File(WORK_DIR, FXPATH + "doorKnock" + EXT)      // 55
    };
    
    private static final Media[] MEDIA = new Media[EFFECTS.length];
    
    static {
        for (int i = 0; i < MEDIA.length; i++) {
            MEDIA[i] = new Media(EFFECTS[i].toURI().toString());
        }
    }
    
//******************************************************************************    
// </editor-fold>
//******************************************************************************
    
 
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="METHODS"> 
//******************************************************************************
    /**
     * Stops the current track and starts a new one if the room
     * if the player entered is mapped to a different track OR if
     * the current track is null (i.e. the game has just started).
     * 
     * @param ID A room ID.
     */
    public static void playTrack(String ID) {
        if (CAVES_CAT_P.matcher(ID).matches()) // For caves and catacombs.
            ID = DIGIT.matcher(ID).replaceAll("");

        if (! muted && 
                (trackName == null || ! trackName.equals(TRACKS.get(ID).getSource()))) 
        {
            if (currentMusic != null)
                stopTrack();

            try {    
                currentMusic = TRACKS.get(ID);
                player = new MediaPlayer(currentMusic);
                player.setCycleCount(MediaPlayer.INDEFINITE);
                player.play();

                trackName = TRACKS.get(ID).getSource(); 
            }
            catch (MediaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
// ============================================================================
    /**
     * Plays sound effects when certain events happen at a specified volume.
     * 
     * @param ID An integer corresponding to a sound effect.
     */
    public static void playEffect(int ID) {
        try {
            MediaPlayer p = new MediaPlayer(MEDIA[ID]);
            p.setOnEndOfMedia(() -> p.dispose());
            p.play();
        }
        catch (MediaException e) {
            System.out.println(e.getMessage());
        }
    }
// ============================================================================
    /**
     * Plays sound effects when certain events happen.
     * 
     * @param ID An integer corresponding to a sound effect.
     * @param volume Volume at which to adjust the effect.
     */
    public static void playEffect(int ID, double volume) {
        try {
            MediaPlayer p = new MediaPlayer(MEDIA[ID]);
            p.setVolume(volume);
            p.setOnEndOfMedia(() -> p.dispose());
            p.play();
        }
        catch (MediaException e) {
            System.out.println(e.getMessage());
        }
    }
// ============================================================================
    public static void stopTrack() {
        player.stop();
        player.dispose();
        trackName = null;
    }
// ============================================================================
    public static void muteTrack() {
        muted = ! muted;
        
        if (muted) {
            player.setVolume(0.0);
        }
        else {
            player.setVolume(1.0);
        }
    }
//******************************************************************************    
// </editor-fold>
//******************************************************************************
}
