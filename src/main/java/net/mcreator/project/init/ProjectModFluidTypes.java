
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.project.fluid.types.LavaforrisingFluidType;
import net.mcreator.project.fluid.types.InviFluidType;
import net.mcreator.project.ProjectMod;

public class ProjectModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ProjectMod.MODID);
	public static final RegistryObject<FluidType> INVI_TYPE = REGISTRY.register("invi", () -> new InviFluidType());
	public static final RegistryObject<FluidType> LAVAFORRISING_TYPE = REGISTRY.register("lavaforrising", () -> new LavaforrisingFluidType());
}
