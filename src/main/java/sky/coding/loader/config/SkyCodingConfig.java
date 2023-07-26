package sky.coding.loader.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Button;
import cc.polyfrost.oneconfig.config.annotations.DualOption;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.libs.checker.units.qual.C;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;
import sky.coding.loader.ModInfoGlobal;
import sky.coding.loader.customclassloader.CustomClassLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class SkyCodingConfig extends Config {
    @DualOption(
            name = "antifuck",
            description = "antifuckable",
            category = "fuck",
            left = "Off",
            right = "On"

    )
    public static boolean antifuck = false;

    @Button(
            name = "Test Button",
            text = "Click To Reset",
            category = "CUM",
            subcategory = "Loot Tracker",
            size = 2

    )
    Runnable runnable = () -> {
        try {
            GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
            Class<?> groovyClass = groovyClassLoader.parseClass(new File("C:/Users/Ender/Desktop/classes/Test.groovy"));
            GroovyObject groovyObject = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
            groovyObject.invokeMethod("Testing", null);
        } catch (IOException e) {
            System.out.println(e.getCause());
        } catch (InvocationTargetException e) {
            System.out.println(e.getCause());
        } catch (InstantiationException e) {
            System.out.println(e.getCause());
        } catch (IllegalAccessException e) {
            System.out.println(e.getCause());
        } catch (NoSuchMethodException e) {
            System.out.println(e.getCause());
        }
    };

    public SkyCodingConfig() {
        super(new Mod("SkyCoding", ModType.SKYBLOCK), ModInfoGlobal.MOD_ID + ".json");
        initialize();
    }
}
