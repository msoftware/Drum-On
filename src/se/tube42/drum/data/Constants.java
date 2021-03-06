
package se.tube42.drum.data;

public final class Constants
{
    public static final boolean
          DEBUG = false
          ;

    public static final String
          CHARSET = "0123456789%"
          ;

    public static final int
          MAX_TEMPO = 300,
          MIN_TEMPO = 40,
          MAX_VARIATION = 60,
          MIN_VARIATION = 0,
          DEFAULT_VARIATION = 20,

          MAX_VOLUME = 300, // %
          MIN_VOLUME = 0, // %
          SIMD_WIDTH = 4
          ;

    public static final int
          BANKS = 2,
          SELECTORS = 4,
          TOOLS = 4,
          VOICES = 8,
          PADS = 4 * 4
          ;

    public static final int
          TILE_PAD0 = 0,
          TILE_PAD1 = 1,
          TILE_MARKER = 2,
          TILE_BUTTON0 = 4,
          TILE_BUTTON1 = 5
          ;

    public static final int
          DECALS_NUM = 0,
          DECALS_ALPHA = 4
          ;

    public static final int
          ICON_KICK = 0,
          ICON_SNARE = 1,
          ICON_TOM = 2,
          ICON_CLAP = 3,
          ICON_HC = 4,
          ICON_HO = 5,
          ICON_SYMBAL = 6,
          ICON_TICK = 7,
          ICON_A = 8,
          ICON_B = 9,
          ICON_DEL = 10,
          ICON_SETTINGS = 11,
          ICON_PAUSE = 14,
          ICON_PLAY = 15,
          ICON_METRONOME = 16,
          ICON_WAVEFORM = 17,
          ICON_MIX = 18,
          ICON_SEQ = 19,

          ICON_NOTE4 = 20,
          ICON_NOTE8 = 21,
          ICON_NOTE16 = 22,
          ICON_DOT = 23,

          ICON_CRUSH = 24,
          ICON_LPFILTER = 25,
          ICON_ECHO = 26,
          ICON_COMPRESS = 27,

          ICON_VOLUME = 28,
          ICON_VARIATION = 29
          ;

    public final static int
          CHOICE_TEMPO = 0,
          CHOICE_VOLUME = 1,
          CHOICE_VARIATION = 2
          ;

    public final static int
          CHOICE2_COMPRESS = 0
          ;

    // ---------------------------------------
    // samples
    // ---------------------------------------

    public static final String [][] SAMPLES = {
        { "kick2.au", "kick_hard.au", "BD1.au" },
        { "snare2.au", "SD2.au", "snare_supraphonic_hard.au", },
        { "floor_tom2.au", "HITOM4.au" },
        { "tamburin.au", "CLAPS.au" },

        { "side_stick1.au", "CHOICE_BITS_COWBELL.au","RIM.au" },
        { "closed_hat_hard.au", "HIGH_HAT_closed_soft.au", "CLHIHAT2.au" },
        { "semi_open_hat.au", "open_hat4.au", "OPHIHAT2.au" },
        { "ride_centre2.au", "RIDE5.au" },
    };

    public static final float [] DEF_AMPS = {
        1.5f, 1.0f, 0.8f, 0.7f,
        0.8f, 0.5f, 0.5f, 0.5f,
    };

    // ---------------------------------------
    // pads
    // ---------------------------------------

    // ---------------------------------------
    // voices
    // ---------------------------------------
    public static final int [] VOICE_ICONS = {
        ICON_KICK, ICON_SNARE, ICON_TOM, ICON_CLAP,
        ICON_TICK, ICON_HC, ICON_HO, ICON_SYMBAL,
    };


    // ---------------------------------------
    // tools
    // ---------------------------------------
    public static final int [] TOOL_ICONS = {
        // timing
        ICON_NOTE4, ICON_DOT, ICON_METRONOME, -1,

        // sequence
        ICON_PAUSE, ICON_A, ICON_MIX, ICON_DEL,

        // waveform
        ICON_CRUSH, ICON_LPFILTER, ICON_ECHO, ICON_COMPRESS,

        // settings
        ICON_VOLUME, ICON_VARIATION, ICON_COMPRESS, -1
    };

    // ---------------------------------------
    // selectors
    // ---------------------------------------

    public static final int [] SELECTOR_ICONS = {
        ICON_METRONOME, ICON_SEQ, ICON_WAVEFORM, ICON_SETTINGS,
    };


    //

    public static final int
          COLOR_BG = 0x505050,
          COLOR_MARKER = 0xA02032,
          COLOR_VOICES = 0xC29968
          ;

    public static final int [] COLOR_SELECTORS = {
        0x802222,
        0x228022,
        0x222280,
        0x808022,
    };


    /* see
     * http://gamedev.stackexchange.com/questions/46463/is-there-an-optimum-set-of-colors-for-10-players/
     */
    public static final int [] COLOR_PADS  = {
        0x95bf7f,
        0xffdd7f,
        0xf33f7f,
        0xffaebf,
        0xc47f7f,
        0x807f99,
        0x807fc7,
        0xff7fff,
    };

}
