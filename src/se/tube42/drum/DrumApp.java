package se.tube42.drum;

import com.badlogic.gdx.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;

import se.tube42.lib.tweeny.*;
import se.tube42.lib.ks.*;
import se.tube42.lib.scene.*;
import se.tube42.lib.util.*;
import se.tube42.lib.service.*;


import se.tube42.drum.view.*;
import se.tube42.drum.logic.*;
import se.tube42.drum.audio.*;
import se.tube42.drum.data.*;
import static se.tube42.drum.data.Constants.*;

public class DrumApp extends BaseApp
{

    public DrumApp()
    {

    }


    public void onCreate(SceneManager mgr, Item bgc)
    {
    	ServiceProvider.init();


        // set size before loading assets
        onResize(World.sw, World.sh);

        World.bgc = bgc;
        load_assets();

        // update size once more
        onResize(World.sw, World.sh);

        // create mixer
        World.prog = new Program(DEF_AMPS);
        World.seq = new Sequencer(World.prog);
        final DeviceOutput dev = new DeviceOutput();
        World.mixer = new Mixer(dev);

        // set the default amps


        World.scene_drum = new DrumScene();
        World.scene_choice = new ChoiceScene();
        World.scene_choice2 = new Choice2Scene();
        World.mgr = mgr;

        World.mgr.setScene(World.scene_drum);

    	// TEMP until we fix the code handling back:
		Gdx.input.setCatchBackKey(false);

        // start the mixer!
        World.mixer.start();

    }


    public void onUpdate(float dt, long dtl)
    {
        ServiceProvider.service(dtl); // this will update job manager, tween manager and so on
    }

    public void onResize(int w, int h)
    {
        World.ui_scale = Math.max(1, Math.min(World.sw / 200, World.sh / 300));
        World.ui_gap = Math.min(32, 4 * World.ui_scale);

        final int s1 = ~1 & (int)Math.min( World.sw / 4, World.sh / 8);
        final int s2 = ~(8 * World.ui_scale - 1) & (int)(s1 * 0.98f);
        World.tile_stripe = s1;
        World.tile_size = s2;
        World.tile_x0 = ((int)(World.sw - s1 * 4 + s1 - s2)) / 2;
        World.tile_y0 = ((int)(World.sh - s1 * 8 + s1 - s2)) / 2;

        System.out.println("RESIZE " + w + "x" + h + " -> " +
                  World.ui_scale + ":" + World.ui_gap);
    }

    // ----------------------------------------------

    private void load_assets()
    {
        int ascale = World.ui_scale;
        if(ascale == 3) ascale = 2;
        if(ascale > 4)  ascale = 4;

        String aname = "" + ascale;
        System.out.println("USING " + aname);


        Texture tmp;
        tmp = AssetService.load(aname + "/tiles.png", true);
        World.tex_tiles = AssetService.divide(tmp, 4, 2);

        tmp = AssetService.load(aname + "/icons.png", true);
        World.tex_icons = AssetService.divide(tmp, 4, 8);

        tmp = AssetService.load(aname + "/decals.png", true);
        World.tex_decals = AssetService.divide(tmp, 4, 2);

        tmp = AssetService.load(aname + "/rect.png", false);
        World.tex_rect = new TextureRegion[1];
        World.tex_rect[0] = new TextureRegion(tmp);


        World.font = AssetService.createFonts(
                  "fonts/Roboto-Regular.ttf",
                  CHARSET, ascale * 16)[0];

        try {
            World.sounds = new Sample[VOICES];
            for(int i = 0; i < VOICES ; i++) {
                final int vcount = SAMPLES[i].length;
                final float [][] data = new float[vcount][];
                for(int j = 0; j < vcount; j++) {
                    data[j] = ServiceProvider.loadSample(
                              "samples/" + SAMPLES[i][j], World.freq);
                }

                World.sounds[i] = new Sample(data);
            }

        } catch(Exception e) {
            System.err.println("ERROR " + e);
            System.err.flush();
            System.exit(20);
        }
    }

    /*
    @Override public void pause()
    {
        World.mixer.stop();
        super.pause();
    }

    @Override public void resume()
    {
        World.mixer.start();
    }
    */
    public void dispose()
    {
        System.out.println("Disposing...\n");
        World.mixer.dispose();
        super.dispose();
    }
}

