package net.mcreator.project.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;

public class RisinglavaProcedure {
	public static void execute(LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				_ent.teleportTo(1375, 32, (-578));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(1375, 32, (-578), _ent.getYRot(), _ent.getXRot());
			}
			if (entityiterator instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Welcome to rising lava, Get to top orange platform before the lava reaches you. Click on the pink block infront to start."), (false));
		}
	}
}
