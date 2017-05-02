package A_Main;
/**
 * Maps every room to an audio file that will play whenever that room is moved
 * into, and maps various events to sound effects.
 * 
 * @author Kevin Rapa
 */
import static A_Main.Names.SEP;
import static A_Main.Names.W_DIR;
import static A_Main.Names.DATA;
import static A_Main.Id.*;
import static A_Main.Patterns.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javax.swing.JButton;

import java.util.HashMap;
import java.io.File;

public class AudioPlayer {
    public final static String 
            TPTH = DATA + SEP + "ambience" + SEP, // Filepath for ambience.
            EPTH = DATA + SEP + "effects" + SEP,  // Filepath for effects.
            EXT = ".mp3";                         // Audio file extension.
    
    private static String trackName;
    private static boolean 
            trackMuted = false,
            effectsMuted = false;
    private static Media currentMusic;
    private static MediaPlayer currentPlayer;
    
    /* 
        Because the faux keyboard key sounds are played so frequently, 
        media players should be reserved just for the key sounds.
        Each sounds gets three media players which rotate playing every time a
        key is pressed in order to handle the typing speed. The media players
        are indexed by a byte which alternates between 0, 1, and 2 using a
        bitmask and XOR operation.
    */ 
    private static final MediaPlayer[][] KEY_PLAYERS = new MediaPlayer[3][3];
    
    // Zero. Determines which of two players to play for each sound.
    private static byte playerAlternator = 0x0;  
    
    // One, three, two. XOR's playerAlternator between 1, 2, and 0
    // 0 ^ 1 = 1
    // 1 ^ 3 = 2
    // 2 ^ 2 = 0
    private static final byte[] XOR_MASKS = {0x1, 0x3, 0x2};    
//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="AMBIENCE AND MUSIC"> 
//******************************************************************************    
    private static File 
        nightAmbience =  new File(W_DIR, TPTH + "nightAmbience" + EXT),
        wavesCrashing =  new File(W_DIR, TPTH + "wavesCrashing" + EXT),
        spookyInterior = new File(W_DIR, TPTH + "spookyWindInterior" + EXT),
        antechamber =    new File(W_DIR, TPTH + "antechamberCustom" + EXT),
        galChoir =       new File(W_DIR, TPTH + "galChoir" + EXT),
        gal1wCustom =    new File(W_DIR, TPTH + "gal1wCustom" + EXT),
        gal2wCustom =    new File(W_DIR, TPTH + "gal2wCustom" + EXT),
        gal3wCustom =    new File(W_DIR, TPTH + "gal3wCustom" + EXT),
        rotundaCustom =  new File(W_DIR, TPTH + "rotundaCustom" + EXT),
        ironHallCustom = new File(W_DIR, TPTH + "ironHallCustom" + EXT),
        westWingCustom = new File(W_DIR, TPTH + "westWingCustom" + EXT),
        dungeonStairs =  new File(W_DIR, TPTH + "dungeonStairs" + EXT),
        creepyOrgan =    new File(W_DIR, TPTH + "creepyOrgan" + EXT),
        parlorCustom =   new File(W_DIR, TPTH + "parlorCustom" + EXT),
        loungeCustom =   new File(W_DIR, TPTH + "loungeCustom" + EXT),
        marbleHall =     new File(W_DIR, TPTH + "marbleHall" + EXT),
        workshopCustom = new File(W_DIR, TPTH + "workshopCustom" + EXT),
        kitchenCustom =  new File(W_DIR, TPTH + "kitchenCustom" + EXT),
        libraryCustom =  new File(W_DIR, TPTH + "libraryCustom" + EXT),
        westBalcony =    new File(W_DIR, TPTH + "westBalconyCustom" + EXT),
        fireplace =      new File(W_DIR, TPTH + "fire" + EXT),
        backHallCustom = new File(W_DIR, TPTH + "backHall" + EXT),
        gardenCustom =   new File(W_DIR, TPTH + "gardenCustom" + EXT),
        deepSpace =      new File(W_DIR, TPTH + "deepSpace" + EXT),
        atticCustom =    new File(W_DIR, TPTH + "atticCustom" + EXT),
        obsCustom =      new File(W_DIR, TPTH + "obsCustom" + EXT),
        labCustom =      new File(W_DIR, TPTH + "labCustom" + EXT),
        caves =          new File(W_DIR, TPTH + "caveLoop" + EXT),
        deepCave =       new File(W_DIR, TPTH + "caveDistortion.wav"),
        tombs =          new File(W_DIR, TPTH + "tombCustom" + EXT),
        sewerTunnels =   new File(W_DIR, TPTH + "sewerHallCustom" + EXT),
        cistern =        new File(W_DIR, TPTH + "cisternCustom" + EXT),
        aeolianHarp =    new File(W_DIR, TPTH + "aeolianWindHarp" + EXT),
        prisonCustom =   new File(W_DIR, TPTH + "prisonCustom" + EXT),
        sewerCogwork =   new File(W_DIR, TPTH + "sewerCogwork" + EXT),
        sewpCustom =     new File(W_DIR, TPTH + "sewpCustom" + EXT),
        torcCustom =     new File(W_DIR, TPTH + "torcCustom" + EXT),
        endTrack =       new File(W_DIR, TPTH + "endTrack" + EXT),
        tbalCustom =     new File(W_DIR, TPTH + "tbalCustom" + EXT),
        hadesTrack =     new File(W_DIR, TPTH + "hell" + EXT),
        titleTrack =     new File(W_DIR, TPTH + "titleTrack" + EXT);
    
    private static final HashMap<String, Media> TRACKS = 
            new HashMap<String, Media>() {
        //---------------------------------------------------------------------
        {
        putAllTracks(nightAmbience,  COU1, COU2, COU3, COU4, COU5, COU6, ENDG,
                                     COU7, COU8, FOR1, FOR2, FOR3, FOR4, FOR5);
        putAllTracks(spookyInterior, FOY1, FOY2, FOY3, FOY4, VEST);
        putAllTracks(wavesCrashing,  FOYB, LOOK, FOYC);
        putAllTracks(ironHallCustom, IHA1, IHA2);
        putAllTracks(westWingCustom, WOW1, WOW2, WOW3, SHA1, SHA2, SQUA, 
                                     EOW1, EOW2, EOW4, SHAR, CLOS);
        putAllTracks(galChoir,       GAL2, GAL4, GAL5);
        putAllTracks(creepyOrgan,    CHS1, CHS3, CHA1, CHA2);
        putAllTracks(parlorCustom,   PAR1, PAR2, JHA1, JHA2);
        putAllTracks(marbleHall,     MHA1, MHA2, MHA3);
        putAllTracks(loungeCustom,   DIN1, DIN2, DRAR);
        putAllTracks(libraryCustom,  LIB1, LIB2, LIB3, LIB4, LIB5);
        putAllTracks(backHallCustom, BHA1, BHA2, BHA3);
        putAllTracks(gardenCustom,   GAR1, GAR2, GAR3, GAR4);
        putAllTracks(atticCustom,    SST1, SST2, ATT1, ATT2);
        putAllTracks(obsCustom,      OBS1, OBS2, OBS3);
        putAllTracks(caves,          "CT", "CV", Id.MY18);
        putAllTracks(deepCave,       MS65, MS66);
        putAllTracks(tombs,          TM16, TM66, TM32, AN65, AN55, VAUE);
        putAllTracks(sewerTunnels,   SEW0, SEW1, SEW2, SEW3, SEW4, SEW5);
        putAllTracks(cistern,        CIS1, CIS2, CIS3, CIS4, CIS5, CEL6);
        putAllTracks(aeolianHarp,    OUB1, OU62, AARC);
        putAllTracks(prisonCustom,   PRIS, TORC);
        putAllTracks(sewerCogwork,   INTR, ESC1, ESC2, ESC3, ESC4, ESC5, 
                                     ESC6, DKCH);
        putAllTracks(torcCustom,     TORC, CRY1, CRY2, CAS1, CS35);
        putAllTracks(endTrack,       BLS1, BLS2, TOW1, TOW2, LQU1, LQU2, 
                                     SOUL);
        putAllTracks(antechamber,    FOYW, VAUE, VAU1, VAU2); 
        putAllTracks(rotundaCustom,  ROTU, CEL1, CEL2, CEL3, CEL4, CEL5);
        
        securePut(HADS, hadesTrack);    securePut(GAL1, gal1wCustom);         
        securePut(GAL3, gal2wCustom);   securePut(GAL6, gal3wCustom);             
        securePut(LABO, labCustom);     securePut(KITC, kitchenCustom);          
        securePut(DST1, dungeonStairs); securePut(STUD, fireplace);              
        securePut(TBAL, tbalCustom);    securePut(WORK, workshopCustom);     
        securePut(WBAL, westBalcony);   securePut(COUS, deepSpace);    
        securePut(SEWP, sewpCustom);    securePut(TITL, titleTrack);
        }
        //---------------------------------------------------------------------
        private void securePut(String id, File f) {
            put(id, f.exists() ? new Media(f.toURI().toString()) : null);
        }
        //---------------------------------------------------------------------
        private void putAllTracks(File track, String ... ids) {
            if (! track.exists())
                for (String id : ids) 
                    put(id, null);
            else         
                for (String id : ids) 
                    put(id, new Media(track.toURI().toString()));
        }
        //---------------------------------------------------------------------
    };
    
//******************************************************************************    
// </editor-fold>
//******************************************************************************
    

//******************************************************************************
// <editor-fold defaultstate="collapsed" desc="SOUND EFFECTS"> 
//******************************************************************************    
    private static final Media[] EFFECTS = {
        getNewMedia("steps"),          getNewMedia("inventory"),      // 0  1
        getNewMedia("pageTurn"),       getNewMedia("keys"),           // 2  3
        getNewMedia("doorKnobJiggle"), getNewMedia("doorLocking"),    // 4  5
        getNewMedia("wallThump"),      getNewMedia("gateSlam"),       // 6  7
        getNewMedia("doorSlam"),       getNewMedia("doorClose"),      // 7  9
        getNewMedia("basicClick"),     getNewMedia("buttonPush"),     // 10 11
        getNewMedia("leverPull"),      getNewMedia("doorUnlock"),     // 12 13
        getNewMedia("woodStairClimb"), getNewMedia("stoneSteps"),     // 14 15
        getNewMedia("ladder"),         getNewMedia("dungeonValve"),   // 16 17
        getNewMedia("rotundaRotate"),  getNewMedia("rotundaRotate2"), // 18 19
        getNewMedia("valveTurn"),      getNewMedia("keyClick"),       // 20 21
        getNewMedia("keyClick2"),      getNewMedia("keyClick3"),      // 22 23
        getNewMedia("dungeonDoor"),    getNewMedia("monster"),        // 24 25
        getNewMedia("windowOpening"),  getNewMedia("keyDrop"),        // 26 27
        getNewMedia("foyGateSwitch"),  getNewMedia("sparkles"),       // 28 29
        getNewMedia("rocksCrumbling"), getNewMedia("ladderFalling"),  // 30 31
        getNewMedia("enchantPop"),     getNewMedia("handDrill"),      // 32 33
        getNewMedia("digging"),        getNewMedia("metalPing"),      // 34 35
        getNewMedia("hoseClimb"),      getNewMedia("galleryStatue"),  // 36 37
        getNewMedia("galleryGears"),   getNewMedia("fireDouse"),      // 38 39
        getNewMedia("stairFlatten"),   getNewMedia("woodSliding"),    // 40 41
        getNewMedia("waterScoop"),     getNewMedia("medallionClick"), // 42 43
        getNewMedia("totemTurn"),      getNewMedia("bunsenBurner"),   // 44 45
        getNewMedia("zombieMoan"),     getNewMedia("metalLadder"),    // 46 47
        getNewMedia("grateMove"),      getNewMedia("teleportZap"),    // 48 49
        getNewMedia("concreteBlock"),  getNewMedia("concreteShort"),  // 50 51
        getNewMedia("atticNoise"),     getNewMedia("piano"),          // 52 53
        getNewMedia("harp"),           getNewMedia("doorKnock")       // 54 55
    };
    
    static {
        // Sets up 3 media players for each faux keyboard sound. 
        for (int sound = 0; sound <= 2; sound++) {
            for (int i = 0; i <= 2; i++) {
                try {
                    KEY_PLAYERS[sound][i] = new MediaPlayer(EFFECTS[sound + 21]);
                }
                catch (NullPointerException e) {
                    System.err.println(e.getMessage());
                    KEY_PLAYERS[sound][i] = null;
                }
            }
        }
        // Sets them each to stop once their track ends.
        for (MediaPlayer[] playerList : KEY_PLAYERS) {
            for (MediaPlayer mPlayer : playerList)
                if (mPlayer != null)
                    mPlayer.setOnEndOfMedia(() -> mPlayer.stop());
        }
    }
    
    private static Media getNewMedia(String file) {
        File f = new File(W_DIR, EPTH + file + EXT);
        return f.exists() ? new Media(f.toURI().toString()) : null;
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
        if (CAVES_CAT_P.matcher(ID).matches()) 
            // For caves and catacombs. Removes final 2 digits so 
            // they all map To the same track.
            ID = SINGLE_DIGIT_P.matcher(ID).replaceAll("");

        Media newMedia = TRACKS.get(ID);
        
        // Switches music only if new area has different associated soundtrack.
        if (trackName == null || 
                (newMedia != null && ! trackName.equals(newMedia.getSource()))
            ) 
        {
            if (currentMusic != null)
                stopTrack();

            try {    
                currentMusic = newMedia;
                currentPlayer = new MediaPlayer(currentMusic);
                currentPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                
                if (trackMuted)
                    currentPlayer.setVolume(0.0);
                
                currentPlayer.play();

                trackName = newMedia.getSource(); 
            }
            catch (MediaException | NullPointerException e) {
                System.err.println(e.getMessage());
            }
        }
    }
//-----------------------------------------------------------------------------
    /**
     * Plays sound effects when certain events happen at a specified volume.
     * 
     * @param ID An integer corresponding to a sound effect.
     */
    public static void playEffect(int ID) {
        if (! effectsMuted) {
            try {
                MediaPlayer p = new MediaPlayer(EFFECTS[ID]);
                p.setOnEndOfMedia(() -> p.dispose());
                p.play();
            }
            catch (MediaException | NullPointerException e) {
                System.err.println(e.getMessage());
            }
        }
    }
//-----------------------------------------------------------------------------
    /**
     * Plays sound effects when certain events happen.
     * 
     * @param ID An integer corresponding to a sound effect.
     * @param volume Volume at which to adjust the effect.
     */
    public static void playEffect(int ID, double volume) {
        if (! effectsMuted) {
            try {
                MediaPlayer p = new MediaPlayer(EFFECTS[ID]);
                p.setVolume(volume);
                p.setOnEndOfMedia(() -> p.dispose());
                p.play();
            }
            catch (MediaException | NullPointerException e) {
                System.err.println(e.getMessage());
            }
        }
    }
//-----------------------------------------------------------------------------
    /**
     * Specifically for the faux key sounds. 
     * Better handles the sounds being played in quick succession.
     * @param ID 0, 1, or 2. Indexes into the 2D media player array and
     * corresponds to the key sound to play.
     */
    public static void playKeySound(int ID) {
        if (ID == -1) return;
        
        try {
            (KEY_PLAYERS[ID][playerAlternator]).play();
            playerAlternator ^= XOR_MASKS[playerAlternator];
        }
        catch (MediaException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
//-----------------------------------------------------------------------------
    public static void stopTrack() {
        currentPlayer.stop();
        currentPlayer.dispose();
        trackName = null;
    }
//-----------------------------------------------------------------------------
    /**
     * Disposes key sound players when the game ends.
     */
    public static void disposeKeyPlayers() {
        for (MediaPlayer[] mList : KEY_PLAYERS)
            for (MediaPlayer mPlayer : mList) {
                mPlayer.stop();
                mPlayer.dispose();
            }
    }
//-----------------------------------------------------------------------------
    public static void toggleMute(JButton b) {
        if (! trackMuted && ! effectsMuted) {
            trackMuted = true;
            b.setText("Mute II");
            GUI.out("Muted all ambience.");
        }
        else if (trackMuted && ! effectsMuted) {
            effectsMuted = true;
            b.setText("Mute III");
            GUI.out("Muted everything.");
        }
        else if (trackMuted && effectsMuted) {
            trackMuted = false;
            b.setText("Unmute");
            GUI.out("Muted all sound effects.");
        }
        else {
            effectsMuted = false;
            b.setText("Mute");
            GUI.out("Unmuted.");
        }
        currentPlayer.setVolume(trackMuted ? 0.0 : 1.0);
    }
//******************************************************************************    
// </editor-fold>
//******************************************************************************
}
