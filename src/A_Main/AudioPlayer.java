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
import static A_Main.NameConstants.SEP;
import static A_Main.NameConstants.W_DIR;

public class AudioPlayer {
    public final static String 
            TPTH = "ambience" + SEP,
            EPTH = "effects" + SEP,
            EXT = ".mp3";
    
    private static String trackName;
    private static boolean muted = false;
    private static Media currentMusic;
    private static MediaPlayer player;
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="AMBIENCE AND MUSIC"> 
//******************************************************************************    
    private static File 
        nightAmbience =     new File(W_DIR, TPTH + "nightAmbience" + EXT),
        wavesCrashing =     new File(W_DIR, TPTH + "wavesCrashing" + EXT),
        spookyInterior =    new File(W_DIR, TPTH + "spookyWindInterior" + EXT),
        antechamberCustom = new File(W_DIR, TPTH + "antechamberCustom" + EXT),
        galChoir =          new File(W_DIR, TPTH + "galChoir" + EXT),
        gal1wCustom =       new File(W_DIR, TPTH + "gal1wCustom" + EXT),
        gal2wCustom =       new File(W_DIR, TPTH + "gal2wCustom" + EXT),
        gal3wCustom =       new File(W_DIR, TPTH + "gal3wCustom" + EXT),
        rotundaCustom =     new File(W_DIR, TPTH + "rotundaCustom" + EXT),
        ironHallCustom =    new File(W_DIR, TPTH + "ironHallCustom" + EXT),
        westWingCustom =    new File(W_DIR, TPTH + "westWingCustom" + EXT),
        dungeonStairs =     new File(W_DIR, TPTH + "dungeonStairs" + EXT),
        creepyOrgan =       new File(W_DIR, TPTH + "creepyOrgan" + EXT),
        parlorCustom =      new File(W_DIR, TPTH + "parlorCustom" + EXT),
        loungeCustom =      new File(W_DIR, TPTH + "loungeCustom" + EXT),
        marbleHall =        new File(W_DIR, TPTH + "marbleHall" + EXT),
        workshopCustom =    new File(W_DIR, TPTH + "workshopCustom" + EXT),
        kitchenCustom =     new File(W_DIR, TPTH + "kitchenCustom" + EXT),
        libraryCustom =     new File(W_DIR, TPTH + "libraryCustom" + EXT),
        westBalconyCustom = new File(W_DIR, TPTH + "westBalconyCustom" + EXT),
        fireplace =         new File(W_DIR, TPTH + "fire" + EXT),
        backHallCustom =    new File(W_DIR, TPTH + "backHall" + EXT),
        gardenCustom =      new File(W_DIR, TPTH + "gardenCustom" + EXT),
        deepSpace =         new File(W_DIR, TPTH + "deepSpace" + EXT),
        atticCustom =       new File(W_DIR, TPTH + "atticCustom" + EXT),
        obsCustom =         new File(W_DIR, TPTH + "obsCustom" + EXT),
        labCustom =         new File(W_DIR, TPTH + "labCustom" + EXT),
        caves =             new File(W_DIR, TPTH + "caveLoop" + EXT),
        deepCave =          new File(W_DIR, TPTH + "caveDistortion.wav"),
        tombs =             new File(W_DIR, TPTH + "tombCustom" + EXT),
        sewerTunnels =      new File(W_DIR, TPTH + "sewerHallCustom" + EXT),
        cistern =           new File(W_DIR, TPTH + "cisternCustom" + EXT),
        aeolianHarp =       new File(W_DIR, TPTH + "aeolianWindHarp" + EXT),
        prisonCustom =      new File(W_DIR, TPTH + "prisonCustom" + EXT),
        sewerCogwork =      new File(W_DIR, TPTH + "sewerCogwork" + EXT),
        sewpCustom =        new File(W_DIR, TPTH + "sewpCustom" + EXT),
        torcCustom =        new File(W_DIR, TPTH + "torcCustom" + EXT),
        titleTrack =        new File(W_DIR, TPTH + "titleTrack" + EXT),
        tbalCustom =        new File(W_DIR, TPTH + "tbalCustom" + EXT);
    
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
    private static final Media[] MEDIA = {
        new Media(new File(W_DIR, EPTH + "steps" + EXT).toURI().toString()),         // 0
        new Media(new File(W_DIR, EPTH + "inventory" + EXT).toURI().toString()),     // 1
        new Media(new File(W_DIR, EPTH + "pageTurn" + EXT).toURI().toString()),      // 2
        new Media(new File(W_DIR, EPTH + "keys" + EXT).toURI().toString()),          // 3
        new Media(new File(W_DIR, EPTH + "doorKnobJiggle" + EXT).toURI().toString()),// 4   
        new Media(new File(W_DIR, EPTH + "doorLocking" + EXT).toURI().toString()),   // 5
        new Media(new File(W_DIR, EPTH + "wallThump" + EXT).toURI().toString()),     // 6
        new Media(new File(W_DIR, EPTH + "gateSlam" + EXT).toURI().toString()),      // 7
        new Media(new File(W_DIR, EPTH + "doorSlam" + EXT).toURI().toString()),      // 8
        new Media(new File(W_DIR, EPTH + "doorClose" + EXT).toURI().toString()),     // 9
        new Media(new File(W_DIR, EPTH + "basicClick" + EXT).toURI().toString()),    // 10
        new Media(new File(W_DIR, EPTH + "buttonPush" + EXT).toURI().toString()),    // 11
        new Media(new File(W_DIR, EPTH + "leverPull" + EXT).toURI().toString()),     // 12
        new Media(new File(W_DIR, EPTH + "doorUnlock" + EXT).toURI().toString()),    // 13
        new Media(new File(W_DIR, EPTH + "woodStairClimb" + EXT).toURI().toString()),// 14
        new Media(new File(W_DIR, EPTH + "stoneSteps" + EXT).toURI().toString()),    // 15
        new Media(new File(W_DIR, EPTH + "ladder" + EXT).toURI().toString()),        // 16
        new Media(new File(W_DIR, EPTH + "dungeonValve" + EXT).toURI().toString()),  // 17
        new Media(new File(W_DIR, EPTH + "rotundaRotate" + EXT).toURI().toString()), // 18
        new Media(new File(W_DIR, EPTH + "rotundaRotate2" + EXT).toURI().toString()),// 19
        new Media(new File(W_DIR, EPTH + "valveTurn" + EXT).toURI().toString()),     // 20
        new Media(new File(W_DIR, EPTH + "keyClick" + EXT).toURI().toString()),      // 21
        new Media(new File(W_DIR, EPTH + "keyClick2" + EXT).toURI().toString()),     // 22
        new Media(new File(W_DIR, EPTH + "keyClick3" + EXT).toURI().toString()),     // 23
        new Media(new File(W_DIR, EPTH + "dungeonDoor" + EXT).toURI().toString()),   // 24
        new Media(new File(W_DIR, EPTH + "monster" + EXT).toURI().toString()),       // 25
        new Media(new File(W_DIR, EPTH + "windowOpening" + EXT).toURI().toString()), // 26
        new Media(new File(W_DIR, EPTH + "keyDrop" + EXT).toURI().toString()),       // 27
        new Media(new File(W_DIR, EPTH + "foyGateSwitch" + EXT).toURI().toString()), // 28
        new Media(new File(W_DIR, EPTH + "sparkles" + EXT).toURI().toString()),      // 29
        new Media(new File(W_DIR, EPTH + "rocksCrumbling" + EXT).toURI().toString()),// 30
        new Media(new File(W_DIR, EPTH + "ladderFalling" + EXT).toURI().toString()), // 31
        new Media(new File(W_DIR, EPTH + "enchantPop" + EXT).toURI().toString()),    // 32
        new Media(new File(W_DIR, EPTH + "handDrill" + EXT).toURI().toString()),     // 33
        new Media(new File(W_DIR, EPTH + "digging" + EXT).toURI().toString()),       // 34
        new Media(new File(W_DIR, EPTH + "metalPing" + EXT).toURI().toString()),     // 35
        new Media(new File(W_DIR, EPTH + "hoseClimb" + EXT).toURI().toString()),     // 36
        new Media(new File(W_DIR, EPTH + "galleryStatue" + EXT).toURI().toString()), // 37
        new Media(new File(W_DIR, EPTH + "galleryGears" + EXT).toURI().toString()),  // 38
        new Media(new File(W_DIR, EPTH + "fireDouse" + EXT).toURI().toString()),     // 39
        new Media(new File(W_DIR, EPTH + "stairFlatten" + EXT).toURI().toString()),  // 40
        new Media(new File(W_DIR, EPTH + "woodSliding" + EXT).toURI().toString()),   // 41
        new Media(new File(W_DIR, EPTH + "waterScoop" + EXT).toURI().toString()),    // 42
        new Media(new File(W_DIR, EPTH + "medallionClick" + EXT).toURI().toString()),// 43
        new Media(new File(W_DIR, EPTH + "totemTurn" + EXT).toURI().toString()),     // 44
        new Media(new File(W_DIR, EPTH + "bunsenBurner" + EXT).toURI().toString()),  // 45
        new Media(new File(W_DIR, EPTH + "zombieMoan" + EXT).toURI().toString()),    // 46
        new Media(new File(W_DIR, EPTH + "metalLadder" + EXT).toURI().toString()),   // 47
        new Media(new File(W_DIR, EPTH + "grateMove" + EXT).toURI().toString()),     // 48
        new Media(new File(W_DIR, EPTH + "teleportZap" + EXT).toURI().toString()),   // 49
        new Media(new File(W_DIR, EPTH + "concreteBlock" + EXT).toURI().toString()), // 50
        new Media(new File(W_DIR, EPTH + "concreteShort" + EXT).toURI().toString()), // 51
        new Media(new File(W_DIR, EPTH + "atticNoise" + EXT).toURI().toString()),    // 52
        new Media(new File(W_DIR, EPTH + "piano" + EXT).toURI().toString()),         // 53
        new Media(new File(W_DIR, EPTH + "harp" + EXT).toURI().toString()),          // 54
        new Media(new File(W_DIR, EPTH + "doorKnock" + EXT).toURI().toString())      // 55
    };
    
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

        if (trackName == null || ! trackName.equals(TRACKS.get(ID).getSource())) 
        {
            if (currentMusic != null)
                stopTrack();

            try {    
                currentMusic = TRACKS.get(ID);
                player = new MediaPlayer(currentMusic);
                player.setCycleCount(MediaPlayer.INDEFINITE);
                
                if (muted)
                    player.setVolume(0.0);
                
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
    public static void toggleMute() {
        muted = ! muted;
        
        if (muted)
            player.setVolume(0.0);
        else
            player.setVolume(1.0);
    }
//******************************************************************************    
// </editor-fold>
//******************************************************************************
}
