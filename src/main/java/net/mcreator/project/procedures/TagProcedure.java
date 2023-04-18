package net.mcreator.project.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.project.init.ProjectModItems;
import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

import java.util.ArrayList;

public class TagProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(new BlockPos(1138, 10, -233), ProjectModBlocks.CHECK.get().defaultBlockState(), 3);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				_ent.teleportTo(1263, 6, (-735));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(1263, 6, (-735), _ent.getYRot(), _ent.getXRot());
			}
			if (entityiterator instanceof LivingEntity _entity)
				_entity.setHealth(100);
			if (entityiterator instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Welcome to Tag, At the end of 3 minutes players with the stick in their inventory will be eliminated."), (false));
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:tag")), SoundSource.MASTER, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:tag")), SoundSource.MASTER, 100, 1, false);
			}
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (Mth.nextInt(RandomSource.create(), 0, 1) == 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ProjectModItems.TAGG.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
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
					if (entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ProjectModItems.TAGG.get())) : false) {
						if (entityiterator instanceof ServerPlayer _player)
							_player.setGameMode(GameType.SPECTATOR);
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
