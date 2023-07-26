package sky.coding.loader.commands;

import sky.coding.loader.Main;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.util.*;

public class SWQOL extends CommandBase {

    public String getCommandName() {
        return sky.coding.loader.ModInfoGlobal.MOD_ID;
    }

    public List<String> getCommandAliases() {
        return Arrays.asList(sky.coding.loader.ModInfoGlobal.MOD_ID, "");
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/" + sky.coding.loader.ModInfoGlobal.MOD_ID;
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length == 0) {
        }
    }
}