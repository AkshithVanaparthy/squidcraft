
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import org.lwjgl.system.windows.POINT;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.project.item.TaggItem;
import net.mcreator.project.item.LavaforrisingItem;
import net.mcreator.project.item.InviItem;
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
	public static final RegistryObject<Item> START = block(ProjectModBlocks.START, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> INVI_BUCKET = REGISTRY.register("invi_bucket", () -> new InviItem());
	public static final RegistryObject<Item> POINT = block(ProjectModBlocks.POINT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FINISHLIGHT = block(ProjectModBlocks.FINISHLIGHT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> WALK = block(ProjectModBlocks.WALK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> STARTLAVA = block(ProjectModBlocks.STARTLAVA, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAGG = REGISTRY.register("tagg", () -> new TaggItem());
	public static final RegistryObject<Item> WINNING = block(ProjectModBlocks.WINNING, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CHECK = block(ProjectModBlocks.CHECK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> EASY = block(ProjectModBlocks.EASY, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GREENLIGHT = block(ProjectModBlocks.GREENLIGHT, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> GLASSBRIDGEBLOCK = block(ProjectModBlocks.GLASSBRIDGEBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> KINGOFHILLBLOCK = block(ProjectModBlocks.KINGOFHILLBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TAGBLOCK = block(ProjectModBlocks.TAGBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LIGHTOUTBLOCK = block(ProjectModBlocks.LIGHTOUTBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> RISINGLAVABLOCK = block(ProjectModBlocks.RISINGLAVABLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> PARKOURBLOCK = block(ProjectModBlocks.PARKOURBLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> LAVAFORRISING_BUCKET = REGISTRY.register("lavaforrising_bucket", () -> new LavaforrisingItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
