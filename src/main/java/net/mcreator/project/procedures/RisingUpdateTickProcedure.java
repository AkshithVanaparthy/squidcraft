package net.mcreator.project.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

import java.util.Map;

public class RisingUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double height = 0;
		if (!((world.getBlockState(new BlockPos(1375, 32, -573))).getBlock() == ProjectModBlocks.STARTLAVA.get())) {
			ProjectMod.queueServerWork(100, () -> {
				if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR) {
					if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.AIR) {
						if (y >= 49) {
							world.setBlock(new BlockPos(x + 0, y + 1, z + 0), Blocks.LAVA.defaultBlockState(), 3);
							ProjectMod.queueServerWork(100, () -> {
								{
									BlockPos _bp = new BlockPos(x, y, z);
									BlockState _bs = Blocks.AIR.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
								{
									BlockPos _bp = new BlockPos(x, y + 1, z);
									BlockState _bs = Blocks.AIR.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
								world.setBlock(new BlockPos(x + 0, 31, z + 0), ProjectModBlocks.RISING.get().defaultBlockState(), 3);
								world.setBlock(new BlockPos(1375, 32, -573), ProjectModBlocks.STARTLAVA.get().defaultBlockState(), 3);
							});
						} else {
							world.setBlock(new BlockPos(x + 0, y + 1, z + 0), Blocks.LAVA.defaultBlockState(), 3);
							ProjectMod.queueServerWork(100, () -> {
								world.setBlock(new BlockPos(x + 0, y + 2, z + 0), ProjectModBlocks.RISING.get().defaultBlockState(), 3);
								{
									BlockPos _bp = new BlockPos(x, y, z);
									BlockState _bs = Blocks.AIR.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
								{
									BlockPos _bp = new BlockPos(x, y + 1, z);
									BlockState _bs = Blocks.AIR.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
							});
						}
					} else {
						world.setBlock(new BlockPos(x + 0, y + 1, z + 0), Blocks.LAVA.defaultBlockState(), 3);
						ProjectMod.queueServerWork(100, () -> {
							{
								BlockPos _bp = new BlockPos(x, y, z);
								BlockState _bs = Blocks.AIR.defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
							{
								BlockPos _bp = new BlockPos(x, y + 1, z);
								BlockState _bs = Blocks.AIR.defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
									if (_property != null && _bs.getValue(_property) != null)
										try {
											_bs = _bs.setValue(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlock(_bp, _bs, 3);
							}
						});
					}
				} else {
					world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			});
		}
	}
}
