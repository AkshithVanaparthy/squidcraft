package net.mcreator.project.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.project.network.ProjectModVariables;
import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

import java.util.ArrayList;

public class GlassbridgeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				_ent.teleportTo(1331, 21, (-275));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(1331, 21, (-275), _ent.getYRot(), _ent.getXRot());
			}
			if (entityiterator instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Welcome to Glass Bridge,reach to the finish line by guessing the safe platforms."), (false));
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:glass")), SoundSource.MASTER, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:glass")), SoundSource.MASTER, 100, 1, false);
			}
		}
		ProjectModVariables.MapVariables.get(world).lop = 1327;
		ProjectModVariables.MapVariables.get(world).syncData(world);
		ProjectModVariables.MapVariables.get(world).lopz = -291;
		ProjectModVariables.MapVariables.get(world).syncData(world);
		for (int index0 = 0; index0 < (int) (8); index0++) {
			if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
				world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
				world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop + 1, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
				ProjectModVariables.MapVariables.get(world).lopz = ProjectModVariables.MapVariables.get(world).lopz - 6;
				ProjectModVariables.MapVariables.get(world).syncData(world);
			} else {
				world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop + 7, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
				world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop + 8, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
				ProjectModVariables.MapVariables.get(world).lopz = ProjectModVariables.MapVariables.get(world).lopz - 6;
				ProjectModVariables.MapVariables.get(world).syncData(world);
			}
		}
		ProjectMod.queueServerWork(3600, () -> {
			if (world.players().size() > 1) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					{
						Entity _ent = entityiterator;
						_ent.teleportTo(1156, 4, (-167));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(1156, 4, (-167), _ent.getYRot(), _ent.getXRot());
					}
				}
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (new Object() {
						public int getScore(String score, Entity _ent) {
							Scoreboard _sc = _ent.getLevel().getScoreboard();
							Objective _so = _sc.getObjective(score);
							if (_so != null)
								return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
							return 0;
						}
					}.getScore("Light", entityiterator) == 0) {
						if (entityiterator instanceof ServerPlayer _player)
							_player.setGameMode(GameType.SPECTATOR);
					}
				}
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					{
						Entity _ent = entityiterator;
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective("Light");
						if (_so == null)
							_so = _sc.addObjective("Light", ObjectiveCriteria.DUMMY, Component.literal("Light"), ObjectiveCriteria.RenderType.INTEGER);
						_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
					}
				}
				if (world.players().size() == 1) {
					{
						Entity _ent = entity;
						_ent.teleportTo(24, 48, 1);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		});
	}
}
