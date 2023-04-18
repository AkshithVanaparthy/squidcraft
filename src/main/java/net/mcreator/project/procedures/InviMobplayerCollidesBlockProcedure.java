package net.mcreator.project.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class InviMobplayerCollidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setSecondsOnFire(15);
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SPECTATOR);
	}
}
