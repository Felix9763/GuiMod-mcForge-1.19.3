package com.example.utilsmod.waypoints.screens;

import com.example.utilsmod.waypoints.WayPointsHandler;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;
import java.util.ArrayList;

public class AddButtonScreen extends Screen {


    protected AddButtonScreen(Component p_96550_) {
        super(p_96550_);
    }

    public Xeditbox xE = new Xeditbox(Minecraft.getInstance().font,this.width/2 - 10,this.height/2 - 10,20,20,Component.literal("XBox"));
    public Yeditbox yE = new Yeditbox(Minecraft.getInstance().font,this.width/2,this.height/2 - 10,20,20,Component.literal("YBox"));
    public Zeditbox zE = new Zeditbox(Minecraft.getInstance().font,this.width/2 + 10,this.height/2 - 10,20,20,Component.literal("ZBox"));


    @Override
    protected void init() {
        super.init();
        addRenderableWidget(xE);
        addRenderableWidget(yE);
        addRenderableWidget(zE);

        addRenderableWidget(new Button.Builder(Component.translatable("Add WayPoint"), button -> OnConfirmPress(button)).bounds(this.width/2 - 50,this.height/2 - 9,100,18).build());;
    }

    private void OnConfirmPress(Button button){
        ArrayList<Integer> coordsorter = new ArrayList<>();
        int x = Integer.parseInt(xE.getValue());
        int y = Integer.parseInt(yE.getValue());
        int z = Integer.parseInt(zE.getValue());
        coordsorter.add(x);
        coordsorter.add(y);
        coordsorter.add(z);

        Minecraft.getInstance().player.displayClientMessage(Component.literal(xE.getValue()),false);

    }

    @Override
    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
        super.render(p_96562_, p_96563_, p_96564_, p_96565_);

    }




    public static class Xeditbox extends EditBox{


        public Xeditbox(Font p_94114_, int p_94115_, int p_94116_, int p_94117_, int p_94118_, Component p_94119_) {
        super(p_94114_, p_94115_, p_94116_, p_94117_, p_94118_, p_94119_);
        }
        @Override
        public String getValue() {
        return super.getValue();
        }
    }

    public static class Yeditbox extends EditBox{


        public Yeditbox(Font p_94114_, int p_94115_, int p_94116_, int p_94117_, int p_94118_, Component p_94119_) {
            super(p_94114_, p_94115_, p_94116_, p_94117_, p_94118_, p_94119_);
        }
        @Override
        public String getValue() {
            return super.getValue();
        }
    }

    public static class Zeditbox extends EditBox{


        public Zeditbox(Font p_94114_, int p_94115_, int p_94116_, int p_94117_, int p_94118_, Component p_94119_) {
            super(p_94114_, p_94115_, p_94116_, p_94117_, p_94118_, p_94119_);
        }
        @Override
        public String getValue() {
            return super.getValue();
        }
    }
}
