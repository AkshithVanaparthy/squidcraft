package net.mcreator.project.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;

public class EaseProcedure {
	public static void execute(LevelAccessor world) {
		if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) >= 2) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				{
					Entity _ent = entityiterator;
					_ent.teleportTo(1156, 4, (-167));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(1156, 4, (-167), _ent.getYRot(), _ent.getXRot());
				}
			}
		} else {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("You need atleast 2 players to play the game."), (false));
			}
		}
	}
}
