
package net.mcreator.project.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.project.procedures.InviMobplayerCollidesBlockProcedure;
import net.mcreator.project.procedures.InviBlockAddedProcedure;
import net.mcreator.project.init.ProjectModFluids;

public class InviBlock extends LiquidBlock {
	public InviBlock() {
		super(() -> ProjectModFluids.INVI.get(), BlockBehaviour.Properties.of(Material.LAVA).strength(100f).noCollission().noLootTable());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		InviBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		InviMobplayerCollidesBlockProcedure.execute(entity);
	}
}
