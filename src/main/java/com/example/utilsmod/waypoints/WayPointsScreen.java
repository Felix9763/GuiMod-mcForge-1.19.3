package com.example.utilsmod.waypoints;

import com.example.utilsmod.waypoints.buttons.AddButton;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class WayPointsScreen extends Screen {


    public WayPointsScreen(Component p_96550_) {
        super(p_96550_);
    }

    @Override
    protected void init() {
        super.init();
       // addRenderableWidget(new AddButton(this.width/2,this.height/2,50,50, Component.literal("AddButton"),WayPointsScreen::OnAddPress, new Button.CreateNarration().createNarrationMessage(Component.literal("Adding"))));
    }

    @Override
    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
        super.render(p_96562_, p_96563_, p_96564_, p_96565_);
        renderBackground(p_96562_);

    }

    public static void OnAddPress(Button button){
        System.out.println("ADD PRESSED");
    }
}
