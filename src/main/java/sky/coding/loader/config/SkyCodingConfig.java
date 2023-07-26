package sky.coding.loader.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.DualOption;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import sky.coding.loader.ModInfoGlobal;

public class SkyCodingConfig extends Config {
    @DualOption(
            name = "antifuck",
            description = "antifuckable",
            category = "fuck",
            left = "Off",
            right = "On"

    )
    public static boolean antifuck = false;

    public SkyCodingConfig() {
        super(new Mod("SkyCoding", ModType.SKYBLOCK), ModInfoGlobal.MOD_ID + ".json");
        initialize();
    }
}
