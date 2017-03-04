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
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    public final static String 
            WD = System.getProperty("user.dir"),
            S = System.getProperty("file.separator"),
            TRKPATH = "ambience" + S,
            FXPATH = "effects" + S,
            EXT = ".wav";
    
    private static String trackName;
    private static boolean muted = false;
    private static Clip currentMusic, effectClip;
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="AMBIENCE AND MUSIC"> 
//******************************************************************************    
    private static File 
        nightAmbience =     new File(WD, TRKPATH + "nightAmbience.wav"),
        wavesCrashing =     new File(WD, TRKPATH + "wavesCrashing.wav"),
        spookyInterior =    new File(WD, TRKPATH + "spookyWindInterior.wav"),
        antechamberCustom = new File(WD, TRKPATH + "antechamberCustom.wav"),
        galChoir =          new File(WD, TRKPATH + "galChoir.wav"),
        gal1wCustom =       new File(WD, TRKPATH + "gal1wCustom.wav"),
        gal2wCustom =       new File(WD, TRKPATH + "gal2wCustom.wav"),
        gal3wCustom =       new File(WD, TRKPATH + "gal3wCustom.wav"),
        rotundaCustom =     new File(WD, TRKPATH + "rotundaCustom.wav"),
        ironHallCustom =    new File(WD, TRKPATH + "ironHallCustom.wav"),
        westWingCustom =    new File(WD, TRKPATH + "westWingCustom.wav"),
        dungeonStairs =     new File(WD, TRKPATH + "dungeonStairs.wav"),
        creepyOrgan =       new File(WD, TRKPATH + "creepyOrgan.wav"),
        parlorCustom =      new File(WD, TRKPATH + "parlorCustom.wav"),
        loungeCustom =      new File(WD, TRKPATH + "loungeCustom.wav"),
        marbleHall =        new File(WD, TRKPATH + "marbleHall.wav"),
        workshopCustom =    new File(WD, TRKPATH + "workshopCustom.wav"),
        kitchenCustom =     new File(WD, TRKPATH + "kitchenCustom.wav"),
        libraryCustom =     new File(WD, TRKPATH + "libraryCustom.wav"),
        westBalconyCustom = new File(WD, TRKPATH + "westBalconyCustom.wav"),
        fireplace =         new File(WD, TRKPATH + "fire.wav"),
        backHallCustom =    new File(WD, TRKPATH + "backHall.wav"),
        gardenCustom =      new File(WD, TRKPATH + "gardenCustom.wav"),
        deepSpace =         new File(WD, TRKPATH + "deepSpace.wav"),
        atticCustom =       new File(WD, TRKPATH + "atticCustom.wav"),
        obsCustom =         new File(WD, TRKPATH + "obsCustom.wav"),
        labCustom =         new File(WD, TRKPATH + "labCustom.wav"),
        caves =             new File(WD, TRKPATH + "caveLoop.wav"),
        deepCave =          new File(WD, TRKPATH + "caveDistortion.wav"),
        tombs =             new File(WD, TRKPATH + "tombCustom.wav"),
        sewerTunnels =      new File(WD, TRKPATH + "sewerHallCustom.wav"),
        cistern =           new File(WD, TRKPATH + "cisternCustom.wav"),
        aeolianHarp =       new File(WD, TRKPATH + "aeolianWindHarp.wav"),
        prisonCustom =      new File(WD, TRKPATH + "prisonCustom.wav"),
        sewerCogwork =      new File(WD, TRKPATH + "sewerCogwork.wav"),
        sewpCustom =        new File(WD, TRKPATH + "sewpCustom.wav"),
        torcCustom =        new File(WD, TRKPATH + "torcCustom.wav"),
        titleTrack =        new File(WD, TRKPATH + "titleTrack.wav"),
        tbalCustom =        new File(WD, TRKPATH + "tbalCustom.wav");
    
    private static final HashMap<String, File> TRACKS = 
            new HashMap<String, File>() {
        // ====================================================================
        {
        putAllTracks(nightAmbience, COU1, COU2, COU3, COU4, COU5, COU6, COU7);
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
        
        put(GAL1, gal1wCustom);         put(GAL3, gal2wCustom); 
        put(GAL6, gal3wCustom);         put(LABO, labCustom);
        put(KITC, kitchenCustom);       put(DST1, dungeonStairs);
        put(STUD, fireplace);           put(TBAL, tbalCustom);
        put(WORK, workshopCustom);      put(ROTU, rotundaCustom);
        put(WBAL, westBalconyCustom);   put(COUS, deepSpace);
        put(SEWP, sewpCustom);        
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
// <editor-fold defaultstate="collapsed" desc="SOUND EFFECTS"> 
//******************************************************************************    
    private static final File[] EFFECTS = {
        new File(WD, FXPATH + "steps.wav"),         // 0
        new File(WD, FXPATH + "inventory.wav"),     // 1
        new File(WD, FXPATH + "pageTurn.wav"),      // 2
        new File(WD, FXPATH + "keys.wav"),          // 3
        new File(WD, FXPATH + "doorKnobJiggle.wav"),// 4   
        new File(WD, FXPATH + "doorLocking.wav"),   // 5
        new File(WD, FXPATH + "wallThump.wav"),     // 6
        new File(WD, FXPATH + "gateSlam.wav"),      // 7
        new File(WD, FXPATH + "doorSlam.wav"),      // 8
        new File(WD, FXPATH + "doorClose.wav"),     // 9
        new File(WD, FXPATH + "basicClick.wav"),    // 10
        new File(WD, FXPATH + "buttonPush.wav"),    // 11
        new File(WD, FXPATH + "leverPull.wav"),     // 12
        new File(WD, FXPATH + "doorUnlock.wav"),    // 13
        new File(WD, FXPATH + "woodStairClimb.wav"),// 14
        new File(WD, FXPATH + "stoneSteps.wav"),    // 15
        new File(WD, FXPATH + "ladder.wav"),        // 16
        new File(WD, FXPATH + "dungeonValve.wav"),  // 17
        new File(WD, FXPATH + "rotundaRotate.wav"), // 18
        new File(WD, FXPATH + "rotundaRotate2.wav"),// 19
        new File(WD, FXPATH + "valveTurn.wav"),     // 20
        new File(WD, FXPATH + "keyClick.wav"),      // 21
        new File(WD, FXPATH + "keyClick2.wav"),     // 22
        new File(WD, FXPATH + "keyClick3.wav"),     // 23
        new File(WD, FXPATH + "dungeonDoor.wav"),   // 24
        new File(WD, FXPATH + "monster.wav"),       // 25
        new File(WD, FXPATH + "windowOpening.wav"), // 26
        new File(WD, FXPATH + "keyDrop.wav"),       // 27
        new File(WD, FXPATH + "foyGateSwitch.wav"), // 28
        new File(WD, FXPATH + "sparkles.wav"),      // 29
        new File(WD, FXPATH + "rocksCrumbling.wav"),// 30
        new File(WD, FXPATH + "ladderFalling.wav"), // 31
        new File(WD, FXPATH + "enchantPop.wav"),    // 32
        new File(WD, FXPATH + "handDrill.wav"),     // 33
        new File(WD, FXPATH + "digging.wav"),       // 34
        new File(WD, FXPATH + "metalPing.wav"),     // 35
        new File(WD, FXPATH + "hoseClimb.wav"),     // 36
        new File(WD, FXPATH + "galleryStatue.wav"), // 37
        new File(WD, FXPATH + "galleryGears.wav"),  // 38
        new File(WD, FXPATH + "fireDouse.wav"),     // 39
        new File(WD, FXPATH + "stairFlatten.wav"),  // 40
        new File(WD, FXPATH + "woodSliding.wav"),   // 41
        new File(WD, FXPATH + "waterScoop.wav"),    // 42
        new File(WD, FXPATH + "medallionClick.wav"),// 43
        new File(WD, FXPATH + "totemTurn.wav"),     // 44
        new File(WD, FXPATH + "bunsenBurner.wav"),  // 45
        new File(WD, FXPATH + "zombieMoan.wav"),    // 46
        new File(WD, FXPATH + "metalLadder.wav"),   // 47
        new File(WD, FXPATH + "grateMove.wav"),     // 48
        new File(WD, FXPATH + "teleportZap.wav"),   // 49
        new File(WD, FXPATH + "concreteBlock.wav"), // 50
        new File(WD, FXPATH + "concreteShort.wav"), // 51
        new File(WD, FXPATH + "atticNoise.wav"),    // 52
        new File(WD, FXPATH + "piano.wav"),         // 53
        new File(WD, FXPATH + "harp.wav"),          // 54
        new File(WD, FXPATH + "doorKnock.wav")      // 55
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
        if (CAVES_CATACOMB.matcher(ID).matches()) // For caves and catacombs.
            ID = DIGIT.matcher(ID).replaceAll("");

        if (! muted && (
                trackName == null || 
                ! trackName.equals(TRACKS.get(ID).getName())
                )) 
        {
            if (currentMusic != null)
                stopTrack();
            
            try {
                currentMusic = AudioSystem.getClip();
                currentMusic.open(AudioSystem.getAudioInputStream(TRACKS.get(ID)));
                currentMusic.start();
                currentMusic.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException | 
                        UnsupportedAudioFileException | 
                            IOException e) 
            {
                System.out.println(e.getMessage());
            }
            
            trackName = TRACKS.get(ID).getName(); 
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
            effectClip = AudioSystem.getClip();
            effectClip.open(AudioSystem.getAudioInputStream(EFFECTS[ID]));
            effectClip.start(); 
        } catch (LineUnavailableException | 
                    UnsupportedAudioFileException | 
                        IOException e) {
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
    public static void playEffect(int ID, int volume) {
        try {
            effectClip = AudioSystem.getClip();
            effectClip.open(AudioSystem.getAudioInputStream(EFFECTS[ID]));

            ((FloatControl)effectClip.getControl(FloatControl.Type.MASTER_GAIN))
                    .setValue(volume);

            effectClip.start();
        } catch (LineUnavailableException | 
                    UnsupportedAudioFileException | 
                        IOException e) 
        {
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
