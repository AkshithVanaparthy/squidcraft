
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.project.world.features.InviFeatureFeature;
import net.mcreator.project.ProjectMod;

@Mod.EventBusSubscriber
public class ProjectModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, ProjectMod.MODID);
	public static final RegistryObject<Feature<?>> INVI_FEATURE = REGISTRY.register("invi_feature", InviFeatureFeature::new);
}
