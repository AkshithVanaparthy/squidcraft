package net.mcreator.project.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.project.init.ProjectModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(1137, 4, (-287));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(1137, 4, (-287), _ent.getYRot(), _ent.getXRot());
		}
		if (entity instanceof Player _player)
			_player.getInventory().clearContent();
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("Point");
			if (_so == null)
				_so = _sc.addObjective("Point", ObjectiveCriteria.DUMMY, Component.literal("Point"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.getLevel().getScoreboard();
			Objective _so = _sc.getObjective("Light");
			if (_so == null)
				_so = _sc.addObjective("Light", ObjectiveCriteria.DUMMY, Component.literal("Light"), ObjectiveCriteria.RenderType.INTEGER);
			_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
		}
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.ADVENTURE);
		world.setBlock(new BlockPos(1137, 4, -284), ProjectModBlocks.EASY.get().defaultBlockState(), 3);
	}
}
