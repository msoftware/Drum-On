
package se.tube42.drum.logic;

import java.io.*;

import com.badlogic.gdx.*;
import com.badlogic.gdx.files.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import se.tube42.lib.ks.*;
import se.tube42.lib.tweeny.*;
import se.tube42.lib.item.*;
import se.tube42.lib.service.*;

import static se.tube42.drum.data.Constants.*;

public class ServiceProvider
{

    public static void init()
    {
        StorageService.init("drum.0");
    }

    // ------------------------------------------------
    // StorageService

    public static void flushStorage()
    {
        StorageService.flush();
    }

    public static void save(String key, String data)
    {
        StorageService.save(key, data);
    }

    public static void saveLong(String key, long data)
    {
        StorageService.saveLong(key, data);
    }

    public static void save(String key, int data)
    {
        StorageService.save(key, data);
    }

    public static void save(String key, boolean data)
    {
        StorageService.save(key, data);
    }

    public static String load(String key, String default_)
    {
        return StorageService.load(key, default_);
    }

    public static boolean load(String key, boolean default_)
    {
        return StorageService.load(key, default_);
    }

    public static int load(String key, int default_)
    {
        return StorageService.load(key, default_);
    }

    public static long loadLong(String key, long default_)
    {
        return StorageService.loadLong(key, default_);
    }


    // ------------------------------------------------
    // IOService
    public static InputStream readFile(String name)
    {
        FileHandle fh = Gdx.files.internal(name);
        return fh == null ? null : fh.read();
    }

    // ------------------------------------------------
    // RandomService
    public static float getRandom()
    {
        return RandomService.get();
    }

    public static float getRandom(float min, float max)
    {
        return RandomService.get(min, max);
    }

    public static int getRandomInt(int  max)
    {
        return RandomService.getInt(max);
    }

    public static int getRandomFromDistribution(int [] dist)
    {
        return RandomService.getFromDistribution(dist);
    }


    // ---------------------------------------------------

    public static Job addJob(Job job)
    {
        return JobService.add(job);
    }

    public static Job addMessage(MessageListener ml, long time, int msg)
    {
        return JobService.add(ml, time, msg, 0, null, null);
    }

    public static Job addMessage(MessageListener ml, long time,
              int msg, int data0, Object data1)
    {
        return JobService.add(ml, time, msg, data0, data1, null);
    }
    public static Job addMessage(MessageListener ml, long time,
              int msg, int data0, Object data1, Object sender)
    {
        return JobService.add(ml, time, msg, data0, data1, sender);
    }


    public static void service(long dt)
    {
        JobService.service(dt);
        TweenManager.service( dt);
    }

    // ----------------------------------------------------

    public static void setColorItem(int color, Item rgb,
              float add, float mul, float delay)
    {

        mul /= 255f;
        final float b = ((color >> 0) & 0xFF) * mul + add;
        final float g = ((color >> 8) & 0xFF) * mul + add;
        final float r = ((color >> 16) & 0xFF) * mul + add;

        rgb.set(0, r).configure(delay, null);
        rgb.set(1, g).configure(delay, null);
        rgb.set(2, b).configure(delay, null);
    }


    public static float [] loadSample(String filename, int freq)
          throws IOException
    {
        return SampleService.load(filename, freq, SIMD_WIDTH);
    }

    public static void saveSample(String filename,
              int freq, float [] data)
          throws IOException
    {
        SampleService.write(filename, freq, data);

    }
}
