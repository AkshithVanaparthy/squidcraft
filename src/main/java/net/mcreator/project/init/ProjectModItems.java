
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.project.item.CustomItem;
import net.mcreator.project.ProjectMod;

public class ProjectModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectMod.MODID);
	public static final RegistryObject<Item> CUSTOM_HELMET = REGISTRY.register("custom_helmet", () -> new CustomItem.Helmet());
	public static final RegistryObject<Item> CUSTOM_CHESTPLATE = REGISTRY.register("custom_chestplate", () -> new CustomItem.Chestplate());
	public static final RegistryObject<Item> CUSTOM_LEGGINGS = REGISTRY.register("custom_leggings", () -> new CustomItem.Leggings());
	public static final RegistryObject<Item> CUSTOM_BOOTS = REGISTRY.register("custom_boots", () -> new CustomItem.Boots());
	public static final RegistryObject<Item> LIGHT = block(ProjectModBlocks.LIGHT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> REDLIGHT = block(ProjectModBlocks.REDLIGHT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> RISING = block(ProjectModBlocks.RISING, CreativeModeTab.TAB_MISC);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
