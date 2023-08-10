package skycoding.dev;
import com.labymedia.ultralight.UltralightRenderer;
import com.labymedia.ultralight.javascript.JavascriptEvaluationException;
import net.minecraft.command.ICommand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import skycoding.dev.commands.OpenGui;
import skycoding.dev.commands.ReloadModules;
import skycoding.dev.commands.SWQOL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import skycoding.dev.modules.EventHandler;
import skycoding.dev.ultralight.HTMLGui;
import skycoding.dev.ultralight.UltraLight;
import skycoding.dev.utils.ResourceManager;


import java.util.ArrayList;
import java.util.List;

import static skycoding.dev.Main.*;
import static skycoding.dev.utils.GroovyUtils.isPlayerInGame;


@Mod(modid = MODID, name = MODNAME, version = VERSION)
public class Main {
    public static final String MODID = "skycoding";
    public static final String MODNAME = "SkyCoding";
    public static final String VERSION = "0.0.1";
    public static Minecraft mc = Minecraft.getMinecraft();
    public static EntityPlayerSP mcPlayer = mc.thePlayer;
    public static WorldClient mcWorld = mc.theWorld;
    public static HTMLGui HTMLGui;
    public static UltralightRenderer renderer;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws JavascriptEvaluationException {
        UltraLight.init();
        renderer = UltraLight.getRenderer();
        List<ICommand> commands = new ArrayList<>();
        List<Object> registry = new ArrayList<>();
        commands.add(new SWQOL());
        registry.add(this);
        commands.add(new OpenGui());
        commands.add(new ReloadModules());
        registry.add(new EventHandler());
        commands.forEach(ClientCommandHandler.instance::registerCommand);
        registry.forEach(MinecraftForge.EVENT_BUS::register);

    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        renderer.update();
        renderer.render();
        if (isPlayerInGame()) {
            if (Keyboard.isKeyDown(54) && Minecraft.getMinecraft().currentScreen == null) {
                if (HTMLGui != null) {
                    Minecraft.getMinecraft().displayGuiScreen(HTMLGui);
                }
            }
        }
    }
}
