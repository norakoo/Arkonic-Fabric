package net.norako.arkonic;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.norako.arkonic.entity.ModEntities;
import net.norako.arkonic.entity.client.StalkerRenderer;

public class ArkonicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.STALKER, StalkerRenderer::new);
    }
}
