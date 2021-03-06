
package se.tube42.drum.data;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

import se.tube42.lib.item.*;
import se.tube42.lib.util.*;
import se.tube42.lib.scene.*;
import se.tube42.lib.tweeny.*;

import se.tube42.drum.view.*;
import se.tube42.drum.logic.*;
import se.tube42.drum.audio.*;
import static se.tube42.drum.data.Constants.*;

public final class World extends UIC
{
    // prefered configuration. this is filled by platform code
    public static int freq = 44100;
    public static int samples = 512;

    // UI
    public static int ui_scale, ui_gap;
    public static int tile_stripe, tile_size, tile_x0, tile_y0;

    // assets
    public static BitmapFont font;
    public static TextureRegion []tex_rect;
    public static TextureRegion []tex_tiles;
    public static TextureRegion []tex_icons;
    public static TextureRegion []tex_decals;

    // misc
    public static SceneManager mgr;
	public static Item bgc; // background color
    public static DrumScene scene_drum;
    public static ChoiceScene scene_choice;
    public static Choice2Scene scene_choice2;

    // world
    public static BaseItem [] tiles;
    public static PadItem [] tile_pads;
    public static VoiceItem [] tile_voices;
    public static PressItem [] tile_tools;
    public static PressItem [] tile_selectors;

    // public static TileItem []tiles;
    public static MarkerItem marker;

    public static TempoDetector td = new TempoDetector();
    public static Program prog;
    public static Sequencer seq;
    public static Mixer mixer;
    public static Sample [] sounds;
}
