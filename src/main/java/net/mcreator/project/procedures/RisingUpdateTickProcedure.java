package net.mcreator.project.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

public class RisingUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double height = 0;
		ProjectMod.queueServerWork(100, () -> {
			if (y >= 49) {
				world.setBlock(new BlockPos(x + 0, y + 1, z + 0), Blocks.LAVA.defaultBlockState(), 3);
				ProjectMod.queueServerWork(100, () -> {
					world.setBlock(new BlockPos(x + 0, y + 2, z + 0), Blocks.AIR.defaultBlockState(), 3);
				});
			} else {
				world.setBlock(new BlockPos(x + 0, y + 1, z + 0), Blocks.LAVA.defaultBlockState(), 3);
				ProjectMod.queueServerWork(100, () -> {
					world.setBlock(new BlockPos(x + 0, y + 2, z + 0), ProjectModBlocks.RISING.get().defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				});
			}
		});
	}
}
