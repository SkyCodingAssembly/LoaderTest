package skycoding.dev.commands;

import com.labymedia.ultralight.javascript.JavascriptEvaluationException;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import skycoding.dev.Main;
import skycoding.dev.modules.EventHandler;
import skycoding.dev.ultralight.HTMLGui;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static skycoding.dev.Main.mc;

public class OpenGui extends CommandBase {

    public String getCommandName() {
        return "skycoding";
    }

    public List<String> getCommandAliases() {
        return Arrays.asList("skycode", "sky","sc");
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/" + "skycoding";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
            try {
                Main.HTMLGui = new HTMLGui(Main.renderer, "file://ultralight/public/index.html", mc.displayWidth, mc.displayHeight);
                mc.displayGuiScreen(Main.HTMLGui);
            } catch (JavascriptEvaluationException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

