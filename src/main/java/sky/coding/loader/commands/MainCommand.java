package sky.coding.loader.commands;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import sky.coding.loader.ModInfoGlobal;

@Command(value = ModInfoGlobal.MOD_ID,description = "Access the "+ ModInfoGlobal.MOD_NAME + " GUI.", aliases = {"skycode","skycoding"})
public class MainCommand {
    @Main
    private static void main() {
        sky.coding.loader.Main.INSTANCE.config.openGui();
    }
}
