package skycoding.dev.utils;

import com.labymedia.ultralight.UltralightJava;
import com.labymedia.ultralight.UltralightLoadException;
import com.labymedia.ultralight.gpu.UltralightGPUDriverNativeUtil;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.FileUtils;
import skycoding.dev.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourceManager {
    public static final File modDir = new File(Minecraft.getMinecraft().mcDataDir, Main.MODID);
    public static final File ultraLightDir = new File(modDir, "ultralight");
    public static final File binDir = new File(ultraLightDir, "bin");

    public static void loadUltralight() throws UltralightLoadException, IOException {
        String link ="https://api.skycoding.dev/ultralight";
        List<String> downloads = new ArrayList<>(Arrays.asList("/bin/AppCore.dll",
                "/bin/gio-2.0-0.dll",
                "/bin/glib-2.0-0.dll",
                "/bin/gmodule-2.0-0.dll",
                "/bin/gobject-2.0-0.dll",
                "/bin/gstreamer-full-1.0.dll",
                "/bin/gthread-2.0-0.dll",
                "/bin/Ultralight.dll",
                "/bin/UltralightCore.dll",
                "/bin/WebCore.dll",

                "/public/index.html",
                "/public/style.css",
                "/public/script.js",

                "/resources/cacert.pem",
                "/resources/icudt67l.dat",
                "/resources/mediaControls.css",
                "/resources/mediaControls.js",
                "/resources/mediaControlsLocalizedStrings.js"
        ));
        FileUtils.cleanDirectory(new File(ultraLightDir,"public"));
        for (String download : downloads) {
            try {
                File check = new File(ultraLightDir + download);
                if (!check.exists()) {
                    FileUtils.copyURLToFile(new URL(link + download), new File(ultraLightDir + download));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        UltralightJava.extractNativeLibrary(binDir.toPath());
        UltralightGPUDriverNativeUtil.extractNativeLibrary(binDir.toPath());
        System.load(new File(binDir.toPath().toFile(), "UltralightCore.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "glib-2.0-0.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "gobject-2.0-0.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "gmodule-2.0-0.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "gio-2.0-0.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "gstreamer-full-1.0.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "WebCore.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "Ultralight.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "ultralight-java-gpu.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "AppCore.dll").toPath().toAbsolutePath().toString());
        System.load(new File(binDir.toPath().toFile(), "ultralight-java.dll").toPath().toAbsolutePath().toString());
    }
}
