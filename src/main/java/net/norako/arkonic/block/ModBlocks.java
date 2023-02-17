package net.norako.arkonic.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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

    public static final Block CRACKED_ENDERLING_BRICKS = registerBlock("cracked_enderling_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.CRACKED_NETHER_BRICKS)), ItemGroups.BUILDING_BLOCKS);

    public static final Block ENDERLING_BRICK_STAIRS = registerBlock("enderling_brick_stairs",
            new StairsBlock(ModBlocks.ENDERLING_BRICKS.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_STAIRS)), ItemGroups.BUILDING_BLOCKS);

    public static final Block ENDERLING_BRICK_SLAB = registerBlock("enderling_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_SLAB)), ItemGroups.BUILDING_BLOCKS);

    public static final Block ENDERLING_BRICK_WALL = registerBlock("enderling_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_WALL)), ItemGroups.BUILDING_BLOCKS);

    public static final Block ENDERLING_BRICK_FENCE = registerBlock("enderling_brick_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.NETHER_BRICK_FENCE)), ItemGroups.BUILDING_BLOCKS);

    public static final Block CHISELED_ENDERLING_BRICKS = registerBlock("chiseled_enderling_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHISELED_NETHER_BRICKS)), ItemGroups.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Arkonic.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Arkonic.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
            entries.addAfter(Blocks.RED_NETHER_BRICK_WALL, ModBlocks.ENDERLING_BRICKS);
            entries.addAfter(ModBlocks.ENDERLING_BRICKS, ModBlocks.CRACKED_ENDERLING_BRICKS);
            entries.addAfter(ModBlocks.CRACKED_ENDERLING_BRICKS, ModBlocks.ENDERLING_BRICK_STAIRS);
            entries.addAfter(ModBlocks.ENDERLING_BRICK_STAIRS, ModBlocks.ENDERLING_BRICK_SLAB);
            entries.addAfter(ModBlocks.ENDERLING_BRICK_SLAB, ModBlocks.ENDERLING_BRICK_WALL);
            entries.addAfter(ModBlocks.ENDERLING_BRICK_WALL, ModBlocks.ENDERLING_BRICK_FENCE);
            entries.addAfter(ModBlocks.ENDERLING_BRICK_FENCE, ModBlocks.CHISELED_ENDERLING_BRICKS);
        });
        return item;
    }

    public static void registerModBlocks() {
        Arkonic.LOGGER.info("Registering ModBlocks for " + Arkonic.MOD_ID);
    }
}
