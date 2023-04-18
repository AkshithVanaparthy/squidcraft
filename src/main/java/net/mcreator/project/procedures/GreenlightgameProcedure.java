package net.mcreator.project.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

import java.util.ArrayList;

public class GreenlightgameProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(new BlockPos(1138, 10, -233), ProjectModBlocks.CHECK.get().defaultBlockState(), 3);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				_ent.teleportTo(1033, 4, (-258));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(1033, 4, (-258), _ent.getYRot(), _ent.getXRot());
			}
			if (entityiterator instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Welcome to Red Light Green Light, walk only when light is green and reach the goal within 3 minutes"), (false));
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:redlight")), SoundSource.MASTER, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:redlight")), SoundSource.MASTER, 100, 1, false);
			}
		}
		ProjectMod.queueServerWork(3600, () -> {
			world.setBlock(new BlockPos(1138, 10, -233), Blocks.AIR.defaultBlockState(), 3);
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
