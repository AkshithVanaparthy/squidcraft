
package net.mcreator.project.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.project.init.ProjectModItems;
import net.mcreator.project.init.ProjectModFluids;
import net.mcreator.project.init.ProjectModFluidTypes;
import net.mcreator.project.init.ProjectModBlocks;

public abstract class LavaforrisingFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> ProjectModFluidTypes.LAVAFORRISING_TYPE.get(), () -> ProjectModFluids.LAVAFORRISING.get(), () -> ProjectModFluids.FLOWING_LAVAFORRISING.get())
			.explosionResistance(100f).bucket(() -> ProjectModItems.LAVAFORRISING_BUCKET.get()).block(() -> (LiquidBlock) ProjectModBlocks.LAVAFORRISING.get());

	private LavaforrisingFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LavaforrisingFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LavaforrisingFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
