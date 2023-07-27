package sky.coding.loader.customclasses

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.Button
import cc.polyfrost.oneconfig.config.annotations.DualOption
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.client.registry.ClientRegistry
import org.lwjgl.input.Keyboard
import sky.coding.loader.Main
import sky.coding.loader.ModInfoGlobal
class SkyCodingConfig extends Config {
    static SkyCodingConfig config
    @DualOption(
            name = "antifuck",
            description = "antifuckable",
            category = "fuck",
            left = "Off",
            right = "On"
    )
    public static boolean antifuck = false
    SkyCodingConfig() {
        super(new Mod("cock", ModType.SKYBLOCK), ModInfoGlobal.MOD_ID + ".json");
        initialize();
    }
}

class test {
    static void SendChatEvent(event) {
        if (event.message.contains("/" + "kys")) {
            SkyCodingConfig.config = new SkyCodingConfig()
            SkyCodingConfig.config.openGui()
            SkyCodingConfig.config.initialize()
            SkyCodingConfig.config.load()
        }
    }
    static void ChatEvent() {
        Minecraft.minecraft.thePlayer.swingItem()
    }
    static void TickEvent() {

    }
    static void RenderEvent() {

    }
    static void GuiOpenEvent() {

    }
    static void InGuiEvent() {

    }
    static void JoinWorldEvent() {

    }
    static void WorldLoadEvent() {

    }
    static void WorldUnloadEvent() {

    }
    static void KeyInput() {
        KeyBinding blah = new KeyBinding("", Keyboard.KEY_N,"EnderFlame");
        ClientRegistry.registerKeyBinding(blah)

    }
}
