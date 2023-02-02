package com.example.utilsmod.waypoints.screens;

import com.example.utilsmod.waypoints.WayPointsHandler;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.io.FileNotFoundException;

import static com.example.utilsmod.waypoints.WayPointsHandler.ReadFile;

public class WayPointsScreen extends Screen {

    public WayPointsScreen(Component p_96550_) {
        super(p_96550_);
    }

    @Override
    protected void init() {
        super.init();
        try {ReadFile();} catch (FileNotFoundException e) {}
        addRenderableWidget(new Button.Builder(Component.translatable("Add WayPoint"),WayPointsScreen::OnAddPress).bounds(this.width/2 - 50,this.height/2 - 9,100,18).build());
    }

    private static void OnAddPress(Button button) {
        Minecraft.getInstance().setScreen(new AddButtonScreen(Component.literal("ADD WAYPOINT")));
    }

    @Override
    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
        super.render(p_96562_, p_96563_, p_96564_, p_96565_);

    }
}
