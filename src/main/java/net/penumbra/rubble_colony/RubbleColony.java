package net.penumbra.rubble_colony;

import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.penumbra.rubble_colony.registry.RubbleColonyCreativeModeTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubbleColony implements ModInitializer {
	public static final String MOD_ID = "rubble_colony";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Reflection.initialize(
				RubbleColonyCreativeModeTab.class
		);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
