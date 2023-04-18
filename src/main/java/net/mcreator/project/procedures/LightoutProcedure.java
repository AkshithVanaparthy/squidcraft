package net.mcreator.project.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.project.network.ProjectModVariables;
import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

import java.util.ArrayList;

public class LightoutProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(new BlockPos(1138, 10, -233), ProjectModBlocks.CHECK.get().defaultBlockState(), 3);
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				Entity _ent = entityiterator;
				_ent.teleportTo(1024, 4, (-191));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(1024, 4, (-191), _ent.getYRot(), _ent.getXRot());
			}
			if (entityiterator instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Welcome to Lights Out, Kill other players or Survive for 3 minutes in the darkness"), (false));
			if (entityiterator instanceof LivingEntity _entity)
				_entity.setHealth(100);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:lightout")), SoundSource.MASTER, 100, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:lightout")), SoundSource.MASTER, 100, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"effect give @a minecraft:blindness 3600 255 true");
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			ProjectModVariables.MapVariables.get(world).randweapon = Mth.nextInt(RandomSource.create(), 1, 3);
			ProjectModVariables.MapVariables.get(world).syncData(world);
			if (ProjectModVariables.MapVariables.get(world).randweapon == 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.IRON_SWORD);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			if (ProjectModVariables.MapVariables.get(world).randweapon == 2) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			if (ProjectModVariables.MapVariables.get(world).randweapon == 3) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD);
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
					if (entityiterator instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.IRON_SWORD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entityiterator instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.GOLDEN_SWORD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (entityiterator instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Items.DIAMOND_SWORD);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
			} else {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					{
						Entity _ent = entityiterator;
						_ent.teleportTo(24, 48, 1);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		});
	}
}
