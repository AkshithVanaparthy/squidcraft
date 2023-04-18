
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.project.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.project.ProjectMod;

public class ProjectModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ProjectMod.MODID);
	public static final RegistryObject<SoundEvent> LAVA = REGISTRY.register("lava", () -> new SoundEvent(new ResourceLocation("project_", "lava")));
	public static final RegistryObject<SoundEvent> REDLIGHT = REGISTRY.register("redlight", () -> new SoundEvent(new ResourceLocation("project_", "redlight")));
	public static final RegistryObject<SoundEvent> GLASS = REGISTRY.register("glass", () -> new SoundEvent(new ResourceLocation("project_", "glass")));
	public static final RegistryObject<SoundEvent> HILL = REGISTRY.register("hill", () -> new SoundEvent(new ResourceLocation("project_", "hill")));
	public static final RegistryObject<SoundEvent> TAG = REGISTRY.register("tag", () -> new SoundEvent(new ResourceLocation("project_", "tag")));
	public static final RegistryObject<SoundEvent> LIGHTOUT = REGISTRY.register("lightout", () -> new SoundEvent(new ResourceLocation("project_", "lightout")));
	public static final RegistryObject<SoundEvent> PARK = REGISTRY.register("park", () -> new SoundEvent(new ResourceLocation("project_", "park")));
}
