package net.norako.arkonic;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.norako.arkonic.block.ModBlocks;
import net.norako.arkonic.entity.ModEntities;
import net.norako.arkonic.entity.custom.StalkerEntity;
import net.norako.arkonic.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Arkonic implements ModInitializer {
	public static final String MOD_ID = "arkonic";
	public static final Logger LOGGER = LoggerFactory.getLogger("arkonic");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		GeckoLib.initialize();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.NETHER_BRICK, ModItems.ENDERLING_BRICK);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
			entries.addAfter(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG, ModItems.STALKER_SPAWN_EGG);
		});

		FabricDefaultAttributeRegistry.register(ModEntities.STALKER, StalkerEntity.setAttributes());

		// AttackEntityCallback.EVENT.register(new AttackEntityHandler());
	}
}