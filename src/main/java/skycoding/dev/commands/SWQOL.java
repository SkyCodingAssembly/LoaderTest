package skycoding.dev.commands;

import com.labymedia.ultralight.javascript.JavascriptEvaluationException;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import skycoding.dev.Main;
import skycoding.dev.ultralight.HTMLGui;
import skycoding.dev.ultralight.opengl.js.JavaScriptBridge;

import java.io.File;
import java.util.*;

import static skycoding.dev.Main.mc;

public class SWQOL extends CommandBase {

    public String getCommandName() {
        return "no";
    }

    public List<String> getCommandAliases() {
        return Arrays.asList("no", "no2");
    }

    public String getCommandUsage(ICommandSender sender) {
        return "no";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            try {
                Collection<File> libs = JavaScriptBridge.getPages();
                for (File lib : libs) {
                    System.out.println(lib.getName());
                }
                Main.HTMLGui = new HTMLGui(Main.renderer, "file://ultralight/public/index.html", mc.displayWidth, mc.displayHeight);
            } catch (JavascriptEvaluationException e) {
                throw new RuntimeException(e);
            }
        }
    }
}