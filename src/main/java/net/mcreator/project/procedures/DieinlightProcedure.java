package net.mcreator.project.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class DieinlightProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(world instanceof Level _lvl_isPow ? _lvl_isPow.hasNeighborSignal(new BlockPos(1037, 4, -364)) : false)) {
			if (entity.getDeltaMovement().x() != 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(0);
				{
					Entity _ent = entity;
					_ent.teleportTo(1137, 4, (-287));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(1137, 4, (-287), _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SPECTATOR);
			} else if (entity.getDeltaMovement().z() != 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(0);
				{
					Entity _ent = entity;
					_ent.teleportTo(1137, 4, (-287));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(1137, 4, (-287), _ent.getYRot(), _ent.getXRot());
				}
				if (entity instanceof ServerPlayer _player)
					_player.setGameMode(GameType.SPECTATOR);
			}
		}
	}
}
