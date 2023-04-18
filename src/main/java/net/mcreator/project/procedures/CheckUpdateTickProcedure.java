package net.mcreator.project.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public class CheckUpdateTickProcedure {
	public static void execute(LevelAccessor world) {
		if (world.players().size() == 1) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				{
					Entity _ent = entityiterator;
					_ent.teleportTo(24, 48, 1);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) != 0) {
					if (entityiterator instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(Component.literal("Welcome to Bennett University ,Congrats on winning."), (false));
				}
			}
			world.setBlock(new BlockPos(1138, 10, -233), Blocks.AIR.defaultBlockState(), 3);
		} else {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 0) {
					if (entityiterator instanceof ServerPlayer _player)
						_player.setGameMode(GameType.SPECTATOR);
				}
			}
		}
	}
}
