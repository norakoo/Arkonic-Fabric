package net.norako.arkonic;

import net.fabricmc.api.ModInitializer;

import net.norako.arkonic.block.ModBlocks;
import net.norako.arkonic.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arkonic implements ModInitializer {
	public static final String MOD_ID = "arkonic";
	public static final Logger LOGGER = LoggerFactory.getLogger("arkonic");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}