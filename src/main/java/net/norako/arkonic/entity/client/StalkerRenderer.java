package net.norako.arkonic.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.norako.arkonic.Arkonic;
import net.norako.arkonic.entity.custom.StalkerEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StalkerRenderer extends GeoEntityRenderer<StalkerEntity> {
    public StalkerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new StalkerModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureLocation(StalkerEntity instance) {
        return new Identifier(Arkonic.MOD_ID, "textures/entity/sculk/stalker.png");
    }

    @Override
    public RenderLayer getRenderType(StalkerEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
