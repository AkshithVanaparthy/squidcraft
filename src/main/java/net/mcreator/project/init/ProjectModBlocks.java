
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import org.lwjgl.system.windows.POINT;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.project.block.WinningBlock;
import net.mcreator.project.block.WalkBlock;
import net.mcreator.project.block.TagblockBlock;
import net.mcreator.project.block.StartlavaBlock;
import net.mcreator.project.block.StartBlock;
import net.mcreator.project.block.RisinglavablockBlock;
import net.mcreator.project.block.RisingBlock;
import net.mcreator.project.block.RedlightBlock;
import net.mcreator.project.block.PointBlock;
import net.mcreator.project.block.ParkourblockBlock;
import net.mcreator.project.block.LightoutblockBlock;
import net.mcreator.project.block.LightBlock;
import net.mcreator.project.block.LavaforrisingBlock;
import net.mcreator.project.block.KingofhillblockBlock;
import net.mcreator.project.block.InviBlock;
import net.mcreator.project.block.GreenlightBlock;
import net.mcreator.project.block.GlassbridgeblockBlock;
import net.mcreator.project.block.FinishlightBlock;
import net.mcreator.project.block.EasyBlock;
import net.mcreator.project.block.CheckBlock;
import net.mcreator.project.ProjectMod;

public class ProjectModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectMod.MODID);
	public static final RegistryObject<Block> LIGHT = REGISTRY.register("light", () -> new LightBlock());
	public static final RegistryObject<Block> REDLIGHT = REGISTRY.register("redlight", () -> new RedlightBlock());
	public static final RegistryObject<Block> RISING = REGISTRY.register("rising", () -> new RisingBlock());
	public static final RegistryObject<Block> START = REGISTRY.register("start", () -> new StartBlock());
	public static final RegistryObject<Block> INVI = REGISTRY.register("invi", () -> new InviBlock());
	public static final RegistryObject<Block> POINT = REGISTRY.register("point", () -> new PointBlock());
	public static final RegistryObject<Block> FINISHLIGHT = REGISTRY.register("finishlight", () -> new FinishlightBlock());
	public static final RegistryObject<Block> WALK = REGISTRY.register("walk", () -> new WalkBlock());
	public static final RegistryObject<Block> STARTLAVA = REGISTRY.register("startlava", () -> new StartlavaBlock());
	public static final RegistryObject<Block> WINNING = REGISTRY.register("winning", () -> new WinningBlock());
	public static final RegistryObject<Block> CHECK = REGISTRY.register("check", () -> new CheckBlock());
	public static final RegistryObject<Block> EASY = REGISTRY.register("easy", () -> new EasyBlock());
	public static final RegistryObject<Block> GREENLIGHT = REGISTRY.register("greenlight", () -> new GreenlightBlock());
	public static final RegistryObject<Block> GLASSBRIDGEBLOCK = REGISTRY.register("glassbridgeblock", () -> new GlassbridgeblockBlock());
	public static final RegistryObject<Block> KINGOFHILLBLOCK = REGISTRY.register("kingofhillblock", () -> new KingofhillblockBlock());
	public static final RegistryObject<Block> TAGBLOCK = REGISTRY.register("tagblock", () -> new TagblockBlock());
	public static final RegistryObject<Block> LIGHTOUTBLOCK = REGISTRY.register("lightoutblock", () -> new LightoutblockBlock());
	public static final RegistryObject<Block> RISINGLAVABLOCK = REGISTRY.register("risinglavablock", () -> new RisinglavablockBlock());
	public static final RegistryObject<Block> PARKOURBLOCK = REGISTRY.register("parkourblock", () -> new ParkourblockBlock());
	public static final RegistryObject<Block> LAVAFORRISING = REGISTRY.register("lavaforrising", () -> new LavaforrisingBlock());
}
