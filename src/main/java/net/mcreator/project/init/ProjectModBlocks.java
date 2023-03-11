
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.project.block.RisingBlock;
import net.mcreator.project.block.RedlightBlock;
import net.mcreator.project.block.LightBlock;
import net.mcreator.project.ProjectMod;

public class ProjectModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectMod.MODID);
	public static final RegistryObject<Block> LIGHT = REGISTRY.register("light", () -> new LightBlock());
	public static final RegistryObject<Block> REDLIGHT = REGISTRY.register("redlight", () -> new RedlightBlock());
	public static final RegistryObject<Block> RISING = REGISTRY.register("rising", () -> new RisingBlock());
}
