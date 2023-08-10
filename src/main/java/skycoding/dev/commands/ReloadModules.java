package skycoding.dev.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import skycoding.dev.modules.EventHandler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class ReloadModules extends CommandBase {

    public String getCommandName() {
        return "skyreload";
    }

    public List<String> getCommandAliases() {
        return Arrays.asList("SR", "skyload","SkyReload","SkyLoad","sr");
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/" + "skyreload";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
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
        }
    }
}

