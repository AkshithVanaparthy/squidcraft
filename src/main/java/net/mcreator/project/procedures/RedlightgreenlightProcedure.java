package net.mcreator.project.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
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
import net.minecraft.client.Minecraft;

import net.mcreator.project.network.ProjectModVariables;
import net.mcreator.project.init.ProjectModItems;
import net.mcreator.project.init.ProjectModBlocks;
import net.mcreator.project.ProjectMod;

import java.util.ArrayList;

public class RedlightgreenlightProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) >= 3) {
			world.setBlock(new BlockPos(1138, 10, -233), ProjectModBlocks.CHECK.get().defaultBlockState(), 3);
			world.setBlock(new BlockPos(1137, 4, -284), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(1139, 4, -284), Blocks.AIR.defaultBlockState(), 3);
			if (world.players().size() == 1) {
				{
					Entity _ent = entity;
					_ent.teleportTo(24, 48, 1);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
				}
			} else {
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
					if (world.players().size() == 1) {
						{
							Entity _ent = entity;
							_ent.teleportTo(24, 48, 1);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
						}
					} else {
						for (Entity entityiterator : new ArrayList<>(world.players())) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(1331, 21, (-275));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(1331, 21, (-275), _ent.getYRot(), _ent.getXRot());
							}
							if (entityiterator instanceof Player _player && !_player.level.isClientSide())
								_player.displayClientMessage(Component.literal("Welcome to Glass Bridge,reach to the finish line by guessing the safe platforms."), (false));
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
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:glass")), SoundSource.MASTER, 100, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:glass")), SoundSource.MASTER, 100, 1, false);
							}
						}
						ProjectModVariables.MapVariables.get(world).lop = 1327;
						ProjectModVariables.MapVariables.get(world).syncData(world);
						ProjectModVariables.MapVariables.get(world).lopz = -291;
						ProjectModVariables.MapVariables.get(world).syncData(world);
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
						for (int index0 = 0; index0 < (int) (8); index0++) {
							if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
								world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
								world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop + 1, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
								ProjectModVariables.MapVariables.get(world).lopz = ProjectModVariables.MapVariables.get(world).lopz - 6;
								ProjectModVariables.MapVariables.get(world).syncData(world);
							} else {
								world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop + 7, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
								world.setBlock(new BlockPos(ProjectModVariables.MapVariables.get(world).lop + 8, 21, ProjectModVariables.MapVariables.get(world).lopz), ProjectModBlocks.INVI.get().defaultBlockState(), 3);
								ProjectModVariables.MapVariables.get(world).lopz = ProjectModVariables.MapVariables.get(world).lopz - 6;
								ProjectModVariables.MapVariables.get(world).syncData(world);
							}
						}
						ProjectMod.queueServerWork(3600, () -> {
							if (world.players().size() == 1) {
								{
									Entity _ent = entity;
									_ent.teleportTo(24, 48, 1);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
								}
							} else {
								for (Entity entityiterator : new ArrayList<>(world.players())) {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo(829, 13, (-458));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport(829, 13, (-458), _ent.getYRot(), _ent.getXRot());
									}
									if (entityiterator instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(Component.literal("Welcome to King Of The Hill , Stay on the top platform to earn points,the least points player loses after 3 minutes"), (false));
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:hill")), SoundSource.MASTER, 100, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:hill")), SoundSource.MASTER, 100, 1, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"scoreboard objectives setdisplay sidebar Point");
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
								ProjectMod.queueServerWork(3600, () -> {
									if (world.players().size() == 1) {
										{
											Entity _ent = entity;
											_ent.teleportTo(24, 48, 1);
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
										}
									} else {
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
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"scoreboard objectives setdisplay sidebar");
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:tag")), SoundSource.MASTER, 100, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("project_:tag")), SoundSource.MASTER, 100, 1, false);
											}
										}
										ProjectModVariables.MapVariables.get(world).hill = 2147483647;
										ProjectModVariables.MapVariables.get(world).syncData(world);
										for (Entity entityiterator : new ArrayList<>(world.players())) {
											if (new Object() {
												public int getScore(String score, Entity _ent) {
													Scoreboard _sc = _ent.getLevel().getScoreboard();
													Objective _so = _sc.getObjective(score);
													if (_so != null)
														return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
													return 0;
												}
											}.getScore("Point", entityiterator) < ProjectModVariables.MapVariables.get(world).hill) {
												ProjectModVariables.MapVariables.get(world).hill = new Object() {
													public int getScore(String score, Entity _ent) {
														Scoreboard _sc = _ent.getLevel().getScoreboard();
														Objective _so = _sc.getObjective(score);
														if (_so != null)
															return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
														return 0;
													}
												}.getScore("Point", entityiterator);
												ProjectModVariables.MapVariables.get(world).syncData(world);
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
											}.getScore("Point", entityiterator) == ProjectModVariables.MapVariables.get(world).hill) {
												if (entityiterator instanceof ServerPlayer _player)
													_player.setGameMode(GameType.SPECTATOR);
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
											if (world.players().size() == 1) {
												{
													Entity _ent = entity;
													_ent.teleportTo(24, 48, 1);
													if (_ent instanceof ServerPlayer _serverPlayer)
														_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
												}
											} else {
												for (Entity entityiterator : new ArrayList<>(world.players())) {
													{
														Entity _ent = entityiterator;
														_ent.teleportTo(1137, 4, (-287));
														if (_ent instanceof ServerPlayer _serverPlayer)
															_serverPlayer.connection.teleport(1137, 4, (-287), _ent.getYRot(), _ent.getXRot());
													}
													if (entity instanceof Player _player && !_player.level.isClientSide())
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
												for (Entity entityiterator : new ArrayList<>(world.players())) {
													if (entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ProjectModItems.TAGG.get())) : false) {
														if (entityiterator instanceof ServerPlayer _player)
															_player.setGameMode(GameType.SPECTATOR);
													}
												}
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "effect clear @a");
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
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
													if (world.players().size() == 1) {
														{
															Entity _ent = entity;
															_ent.teleportTo(24, 48, 1);
															if (_ent instanceof ServerPlayer _serverPlayer)
																_serverPlayer.connection.teleport(24, 48, 1, _ent.getYRot(), _ent.getXRot());
														}
													} else {
														for (Entity entityiterator : new ArrayList<>(world.players())) {
															{
																Entity _ent = entityiterator;
																_ent.teleportTo(1375, 32, (-578));
																if (_ent instanceof ServerPlayer _serverPlayer)
																	_serverPlayer.connection.teleport(1375, 32, (-578), _ent.getYRot(), _ent.getXRot());
															}
															if (entityiterator instanceof Player _player && !_player.level.isClientSide())
																_player.displayClientMessage(Component.literal("Welcome to rising lava, Get to top orange platform before the lava reaches you. Click on the pink block infront to start."), (false));
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
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"effect give @a minecraft:night_vision 9999 254 true");
													}
												});
											}
										});
									}
								});
							}
						});
					}
				});
			}
		} else {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("You need atleast 3 players to play the game."), (false));
			}
		}
	}
}
