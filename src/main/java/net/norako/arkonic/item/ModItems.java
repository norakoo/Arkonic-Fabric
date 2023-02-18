package net.norako.arkonic.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonic.Arkonic;
import net.norako.arkonic.entity.ModEntities;

public class ModItems {
    public static final Item ENDERLING_BRICK = registerItem("enderling_brick",
            new Item(new FabricItemSettings()));

    public static final Item STALKER_SPAWN_EGG = registerItem("stalker_spawn_egg",
            new SpawnEggItem(ModEntities.STALKER, 0x477583, 0x049599,
                    new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Arkonic.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Arkonic.LOGGER.info("Registering Mod Items for " + Arkonic.MOD_ID);
    }
}
