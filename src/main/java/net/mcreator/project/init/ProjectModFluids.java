
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.project.fluid.LavaforrisingFluid;
import net.mcreator.project.fluid.InviFluid;
import net.mcreator.project.ProjectMod;

public class ProjectModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, ProjectMod.MODID);
	public static final RegistryObject<FlowingFluid> INVI = REGISTRY.register("invi", () -> new InviFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_INVI = REGISTRY.register("flowing_invi", () -> new InviFluid.Flowing());
	public static final RegistryObject<FlowingFluid> LAVAFORRISING = REGISTRY.register("lavaforrising", () -> new LavaforrisingFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LAVAFORRISING = REGISTRY.register("flowing_lavaforrising", () -> new LavaforrisingFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(INVI.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_INVI.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LAVAFORRISING.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LAVAFORRISING.get(), RenderType.translucent());
		}
	}
}
