package net.norako.arkonic.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonic.Arkonic;

public class ModBlocks {
    public static final Block ENDERLING_BRICKS = registerBlock("enderling_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS)), ItemGroups.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Arkonic.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Arkonic.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
            entries.addAfter(Blocks.CHISELED_NETHER_BRICKS, item);
        });
        return item;
    }

    public static void registerModBlocks() {
        Arkonic.LOGGER.info("Registering ModBlocks for " + Arkonic.MOD_ID);
    }
}
