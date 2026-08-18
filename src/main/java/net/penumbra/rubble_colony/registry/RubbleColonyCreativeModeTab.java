package net.penumbra.rubble_colony.registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.penumbra.enderscape.Enderscape;
import net.penumbra.enderscape.registry.component.EnderscapeDataComponents;
import net.penumbra.enderscape.registry.item.EnderscapeItems;
import net.penumbra.rubble_colony.RubbleColony;

import java.util.ArrayList;
import java.util.List;

import static net.penumbra.enderscape.registry.item.EnderscapeItems.RUBBLE_SHIELD;

public class RubbleColonyCreativeModeTab {

    public static final List<Identifier> SHIELD_VARIANTS = new ArrayList<>();

    @SuppressWarnings("unused")
    public static final Identifier STONE = createShield("stone"),
            MOSSY_STONE = createShield("mossy_stone"),
            DEEPSLATE = createShield("deepslate"),
            GRANITE = createShield("granite"),
            DIORITE = createShield("diorite"),
            ANDESITE = createShield("andesite"),
            CALCITE = createShield("calcite"),
            TUFF = createShield("tuff"),
            DRIPSTONE = createShield("dripstone"),
            SULFUR = createShield("sulfur"),
            CINNABAR = createShield("cinnabar"),
            SANDSTONE = createShield("sandstone"),
            RED_SANDSTONE = createShield("red_sandstone"),
            NETHERRACK = createShield("netherrack"),
            BLACKSTONE = createShield("blackstone"),
            BASALT = createShield("basalt");

    private static Identifier createShield(String name) {
        Identifier id = RubbleColony.id(name);
        SHIELD_VARIANTS.add(id);
        return id;
    }

    public static ItemStack rubbleShieldVariant(Identifier identifier) {
        return (new ItemStackTemplate(RUBBLE_SHIELD, DataComponentPatch.builder()
                .set(EnderscapeDataComponents.RUBBLE_SHIELD_VARIANT, identifier)
                .set(DataComponents.ITEM_MODEL, RubbleColony.id("rubble_shield"))
                .build())).create();
    }

    static {
        RubbleColony.LOGGER.info("Adding {} Shield Variants to Creative Tabs", SHIELD_VARIANTS.size());
        ResourceKey<CreativeModeTab> enderscape_tab = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Enderscape.id("enderscape"));
        CreativeModeTabEvents.modifyOutputEvent(enderscape_tab).register(output ->
                SHIELD_VARIANTS.forEach(id -> output.insertBefore(EnderscapeItems.RUSTLE_BUCKET, rubbleShieldVariant(id))));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output ->
                SHIELD_VARIANTS.forEach(id -> output.insertBefore(Items.LEATHER_HELMET, rubbleShieldVariant(id))));
    }
}
