package skycoding.dev.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class GroovyUtils {
    public static boolean isPlayerInGame() {
        Minecraft mc = Minecraft.getMinecraft();
        return mc.thePlayer != null && mc.theWorld != null;
    }
    public static boolean isPlayerInSkyBlock() {
        return true;
    }
    public static void ShowMessageInChat(String prefix,String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(prefix+" "+message));
    }
}
