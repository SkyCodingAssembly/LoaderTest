package sky.coding.loader.modules;

import cc.polyfrost.oneconfig.events.event.ChatSendEvent;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import sky.coding.loader.events.SendChatMessageEvent;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    public static List<GroovyObject> events = new ArrayList<>();
    public static void ReloadClasses() throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        events.clear();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        File directorypath = new File("./config/SkyCoding");
        String[] contents = directorypath.list();
        if (contents != null) {
            for (String content : contents) {
                if (content.contains(".groovy")) {
                    Class<?> groovyClass = groovyClassLoader.parseClass(new File("./config/SkyCoding/" + content));
                    GroovyObject groovyObject = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();
                    events.add(groovyObject);
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Loaded "+ content.replace(".groovy","")));
                }
            }
        }
    }
    @SubscribeEvent
    public void onSendChat(SendChatMessageEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("ChatSendEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("ChatEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("TickEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("RenderEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("GuiOpenEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void inGui(GuiScreenEvent.BackgroundDrawnEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("InGuiEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("JoinWorldEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void onWorldEventLoad(WorldEvent.Load event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("WorldLoadEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void onWorldEventUnload(WorldEvent.Unload event) {
        if (!events.isEmpty()) {
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("WorldUnloadEvent", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (!events.isEmpty()) {
            KeyBinding blah = new KeyBinding("", Keyboard.KEY_N,"EnderFlame");
            for (GroovyObject groovyObject : events) {
                try {
                    groovyObject.invokeMethod("KeyInput", new Object[]{event});
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
