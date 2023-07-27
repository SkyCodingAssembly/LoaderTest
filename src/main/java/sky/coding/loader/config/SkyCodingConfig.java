package sky.coding.loader.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Button;
import cc.polyfrost.oneconfig.config.annotations.DualOption;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import sky.coding.loader.ModInfoGlobal;
import sky.coding.loader.modules.EventHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SkyCodingConfig extends Config {
    public static HashMap<String,String> options = new HashMap<>();
    @DualOption(
            name = "antifuck",
            description = "antifuckable",
            category = "fuck",
            left = "Off",
            right = "On"

    )
    public static boolean antifuck = false;
    @Button(
            name = "Reload Modules",
            text = "Reload",
            description = "This is the button to reload all the external modules.",
            category = "Modules"
    )
    Runnable runnable = () -> {
        try {
            EventHandler.ReloadClasses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    };



    public SkyCodingConfig() {
        super(new Mod("SkyCoding", ModType.SKYBLOCK), ModInfoGlobal.MOD_ID + ".json");
        initialize();
    }
}