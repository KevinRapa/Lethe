package A_Main;
/**
 * Maps every room to an audio file that will play whenever that room is moved
 * into, and maps various events to sound effects.
 * 
 * @author Kevin Rapa
 */
import static A_Main.Id.*;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
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
    private static File titleTrack = new File(WD, "ambience" + S + "titleTrack.wav");
    private static File tbalCustom = new File(WD, "ambience" + S + "tbalCustom.wav");
    
    private static final HashMap<String, File> TRACKS = new HashMap() {
        // ====================================================================
        {
        putAllTracks(nightAmbience, COU1, COU2, COU3, COU4, COU5, COU6, COU7);
        putAllTracks(spookyWindInterior, FOY1, FOY2, FOY3, FOY4, VEST);
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
        
        put(GAL1, gal1wCustom);       put(GAL3, gal2wCustom); 
        put(GAL6, gal3wCustom);       put(LABO, labCustom);
        put(KITC, kitchenCustom);     put(DST1, dungeonStairs);
        put(STUD, fireplace);         put(TBAL, tbalCustom);
        put(WORK, workshopCustom);    put(ROTU, rotundaCustom);
        put(WBAL, westBalconyCustom); put(COUS, deepSpace);
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
// <editor-fold desc="SOUND EFFECTS"> 
//******************************************************************************    
    private static final ArrayList<File> EFFECTS = new ArrayList() {{
        add(new File(WD, "effects" + S + "steps.wav"));         // 0
        add(new File(WD, "effects" + S + "inventory.wav"));     // 1
        add(new File(WD, "effects" + S + "pageTurn.wav"));      // 2
        add(new File(WD, "effects" + S + "keys.wav"));          // 3
        add(new File(WD, "effects" + S + "doorKnobJiggle.wav"));// 4   
        add(new File(WD, "effects" + S + "doorLocking.wav"));   // 5
        add(new File(WD, "effects" + S + "wallThump.wav"));     // 6
        add(new File(WD, "effects" + S + "gateSlam.wav"));      // 7
        add(new File(WD, "effects" + S + "doorSlam.wav"));      // 8
        add(new File(WD, "effects" + S + "doorClose.wav"));     // 9
        add(new File(WD, "effects" + S + "basicClick.wav"));    // 10
        add(new File(WD, "effects" + S + "buttonPush.wav"));    // 11
        add(new File(WD, "effects" + S + "leverPull.wav"));     // 12
        add(new File(WD, "effects" + S + "doorUnlock.wav"));    // 13
        add(new File(WD, "effects" + S + "woodStairClimb.wav"));// 14
        add(new File(WD, "effects" + S + "stoneSteps.wav"));    // 15
        add(new File(WD, "effects" + S + "ladder.wav"));        // 16
        add(new File(WD, "effects" + S + "dungeonValve.wav"));  // 17
        add(new File(WD, "effects" + S + "rotundaRotate.wav")); // 18
        add(new File(WD, "effects" + S + "rotundaRotate2.wav"));// 19
        add(new File(WD, "effects" + S + "valveTurn.wav"));     // 20
        add(new File(WD, "effects" + S + "keyClick.wav"));      // 21
        add(new File(WD, "effects" + S + "keyClick2.wav"));     // 22
        add(new File(WD, "effects" + S + "keyClick3.wav"));     // 23
        add(new File(WD, "effects" + S + "dungeonDoor.wav"));   // 24
        add(new File(WD, "effects" + S + "monster.wav"));       // 25
        add(new File(WD, "effects" + S + "windowOpening.wav")); // 26
        add(new File(WD, "effects" + S + "keyDrop.wav"));       // 27
        add(new File(WD, "effects" + S + "foyGateSwitch.wav")); // 28
        add(new File(WD, "effects" + S + "sparkles.wav"));      // 29
        add(new File(WD, "effects" + S + "rocksCrumbling.wav"));// 30
        add(new File(WD, "effects" + S + "ladderFalling.wav")); // 31
        add(new File(WD, "effects" + S + "enchantPop.wav"));    // 32
        add(new File(WD, "effects" + S + "handDrill.wav"));     // 33
        add(new File(WD, "effects" + S + "digging.wav"));       // 34
        add(new File(WD, "effects" + S + "metalPing.wav"));     // 35
        add(new File(WD, "effects" + S + "hoseClimb.wav"));     // 36
        add(new File(WD, "effects" + S + "galleryStatue.wav")); // 37
        add(new File(WD, "effects" + S + "galleryGears.wav"));  // 38
        add(new File(WD, "effects" + S + "fireDouse.wav"));     // 39
        add(new File(WD, "effects" + S + "stairFlatten.wav"));  // 40
        add(new File(WD, "effects" + S + "woodSliding.wav"));   // 41
        add(new File(WD, "effects" + S + "waterScoop.wav"));    // 42
        add(new File(WD, "effects" + S + "medallionClick.wav"));// 43
        add(new File(WD, "effects" + S + "totemTurn.wav"));     // 44
        add(new File(WD, "effects" + S + "bunsenBurner.wav"));  // 45
        add(new File(WD, "effects" + S + "zombieMoan.wav"));    // 46
        add(new File(WD, "effects" + S + "metalLadder.wav"));   // 47
        add(new File(WD, "effects" + S + "grateMove.wav"));     // 48
        add(new File(WD, "effects" + S + "teleportZap.wav"));   // 49
        add(new File(WD, "effects" + S + "concreteBlock.wav")); // 50
        add(new File(WD, "effects" + S + "concreteShort.wav")); // 51
        add(new File(WD, "effects" + S + "atticNoise.wav"));    // 52
        add(new File(WD, "effects" + S + "piano.wav"));         // 53
        add(new File(WD, "effects" + S + "harp.wav"));          // 54
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
     * Plays sound effects when certain events happen at a specified volume.
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
    /**
     * Plays sound effects when certain events happen.
     * 
     * @param ID An integer corresponding to a sound effect.
     * @param volume Volume at which to adjust the effect.
     */
    public static void playEffect(int ID, int volume) {
        try {
            effectClip = AudioSystem.getClip();
            effectClip.open(AudioSystem.getAudioInputStream(EFFECTS.get(ID)));

            ((FloatControl)effectClip.getControl(FloatControl.Type.MASTER_GAIN))
                    .setValue(volume);

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
