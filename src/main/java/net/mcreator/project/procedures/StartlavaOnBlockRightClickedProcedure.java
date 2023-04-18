package net.mcreator.project.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.project.ProjectMod;

import java.util.ArrayList;

public class StartlavaOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("The lava starts rising in 20 seconds."), (false));
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:lava")), SoundSource.MASTER, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:lava")), SoundSource.MASTER, 100, 1, false);
			}
		}
		ProjectMod.queueServerWork(400, () -> {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			ProjectMod.queueServerWork(2400, () -> {
				if (world.players().size() > 1) {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo(1186, 4, (-167));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(1186, 4, (-167), _ent.getYRot(), _ent.getXRot());
						}
					}
				} else {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo(24, 48, 1);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
			});
		});
	}
}
