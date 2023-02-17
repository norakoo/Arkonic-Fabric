package net.norako.arkonic.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norako.arkonic.Arkonic;

public class ModItems {
    public static final Item ENDERLING_BRICK = registerItem("enderling_brick",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Arkonic.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, ENDERLING_BRICK);
    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
            entries.addAfter(Items.NETHER_BRICK, item);
        });
    }

    public static void registerModItems(){
        Arkonic.LOGGER.info("Registering Mod Items for " + Arkonic.MOD_ID);

        addItemsToItemGroup();
    }
}
