package net.norako.arkonic.entity.client;

import net.minecraft.util.Identifier;
import net.norako.arkonic.Arkonic;
import net.norako.arkonic.entity.custom.StalkerEntity;
import software.bernie.geckolib.model.GeoModel;

public class StalkerModel extends GeoModel<StalkerEntity> {
    @Override
    public Identifier getModelResource(StalkerEntity object) {
        return new Identifier(Arkonic.MOD_ID, "geo/stalker.geo.json");
    }

    @Override
    public Identifier getTextureResource(StalkerEntity object) {
        return new Identifier(Arkonic.MOD_ID, "textures/entity/sculk/stalker.png");
    }

    @Override
    public Identifier getAnimationResource(StalkerEntity animatable) {
        return new Identifier(Arkonic.MOD_ID, "animations/stalker.animations.json");
    }
}
