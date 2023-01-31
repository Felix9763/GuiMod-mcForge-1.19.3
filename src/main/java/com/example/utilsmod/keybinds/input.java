package com.example.utilsmod.keybinds;

import com.example.utilsmod.UtilsMod;
import com.example.utilsmod.waypoints.WayPointsScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.example.utilsmod.waypoints.WayPointsHandler;
public class input {
    @Mod.EventBusSubscriber(modid = UtilsMod.MODID,value = Dist.CLIENT)
    public static class forgeEvents{
        @SubscribeEvent
        public static void onKeyPressed(InputEvent.Key event){
            if(keys.waypoints.consumeClick()){
                Component line = Component.literal("COORDS:");
                Minecraft.getInstance().setScreen(new WayPointsScreen(Component.literal("WayPointScreen")));

            }
        }

    }
    @Mod.EventBusSubscriber(modid = UtilsMod.MODID,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEventBUS{
        @SubscribeEvent
        public static void OnKeyRegistered(RegisterKeyMappingsEvent event){
            event.register(keys.waypoints);
        }
    }
}
