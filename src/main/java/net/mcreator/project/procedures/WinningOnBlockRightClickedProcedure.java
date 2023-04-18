package net.mcreator.project.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class WinningOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("Light");
			if (_so == null)
				_so = _sc.addObjective("Light", ObjectiveCriteria.DUMMY, Component.literal("Light"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Welcome to Bennett University ,Congrats on winning."), (false));
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				_ent.teleportTo(24, 48, 1);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
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
	}
}
