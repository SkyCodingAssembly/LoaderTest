package sky.coding.loader;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import gg.essential.elementa.effects.StencilEffect;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.command.ICommand;
import sky.coding.loader.commands.MainCommand;
import sky.coding.loader.commands.SWQOL;
import sky.coding.loader.config.SkyCodingConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Mod(modid = ModInfoGlobal.MOD_ID, name = ModInfoGlobal.MOD_NAME, version = ModInfoGlobal.VERSION)
public class Main {

    @Mod.Instance(ModInfoGlobal.MOD_ID)
    public static Main INSTANCE;
    public SkyCodingConfig config;
    public static Minecraft mc = Minecraft.getMinecraft();
    public static EntityPlayerSP mcPlayer = mc.thePlayer;
    public static WorldClient mcWorld = mc.theWorld;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        CommandManager.INSTANCE.registerCommand(new MainCommand());
        ClientCommandHandler.instance.registerCommand(new SWQOL());
        List<ICommand> commands = new ArrayList<>();
        List<KeyBinding> keybinds = new ArrayList<>();
        List<Object> registry = new ArrayList<>();
        commands.add(new SWQOL());


        //registry.add(new ModInputHandler());
        keybinds.forEach(ClientRegistry::registerKeyBinding);
        commands.forEach(ClientCommandHandler.instance::registerCommand);
        registry.forEach(MinecraftForge.EVENT_BUS::register);

    }
}
