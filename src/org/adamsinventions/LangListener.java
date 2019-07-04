package org.adamsinventions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.block.data.Levelled;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class LangListener implements Listener {
	
	public final GUIInventory BASE;
	public final GUIInventory FIRE;
	public final GUIInventory WIND;
	public final GUIInventory EARTH;
	public final GUIInventory WATER;
	public final GUIInventory THUNDER;
	public final GUIInventory ICE;
	public final GUIInventory PROFIT;
	public final GUIInventory NATURE;
	public final GUIInventory STRENGTH;
	public final GUIInventory HEALTH;
	public final GUIInventory TELEKINESIS;
	public final GUIInventory TENACITY;
	public final GUIInventory PUNCTURE;
	public final GUIInventory LIGHT;
	public final GUIInventory DARK;
	public final GUIInventory EXPLOSIONS;
	
	@EventHandler
	public void onPickup(EntityPickupItemEvent e) {
		if(e.getEntityType() == EntityType.PLAYER && (e.getItem().getItemStack().getType() == Material.BOW || e.getItem().getItemStack().getType() == 
				Material.DIAMOND_AXE || e.getItem().getItemStack().getType() == Material.DIAMOND_SWORD || e.getItem().getItemStack().getType() == 
				Material.DIAMOND_HELMET || e.getItem().getItemStack().getType() == Material.DIAMOND_CHESTPLATE || e.getItem().getItemStack().getType() == 
				Material.DIAMOND_LEGGINGS || e.getItem().getItemStack().getType() == Material.DIAMOND_BOOTS || e.getItem().getItemStack().getType() == 
				Material.ELYTRA || (((Player) e.getEntity()).getInventory().contains(Material.CROSSBOW) && e.getItem().getItemStack().getType() == 
				Material.CROSSBOW) || (((Player) e.getEntity()).getInventory().contains(Material.TRIDENT) && 
						e.getItem().getItemStack().getType() == Material.TRIDENT))) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		List<String> ler = new ArrayList<>();
		ler.add("Base");
		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta im = boots.getItemMeta();
		im.setUnbreakable(true);
		im.setLore(ler);
		boots.setItemMeta(im);
		p.getInventory().setBoots(boots);
		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		im = leggings.getItemMeta();
		im.setUnbreakable(true);
		im.setLore(ler);
		leggings.setItemMeta(im);
		p.getInventory().setLeggings(leggings);
		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		im = chestplate.getItemMeta();
		im.setUnbreakable(true);
		im.setLore(ler);
		chestplate.setItemMeta(im);
		p.getInventory().setChestplate(chestplate);
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		im = helmet.getItemMeta();
		im.setUnbreakable(true);
		im.setLore(ler);
		helmet.setItemMeta(im);
		p.getInventory().setHelmet(helmet);
		p.getInventory().setStorageContents(BASE.inv.getStorageContents());
	}
	
	public LangListener() {
		BASE = new GUIInventory("Base");
		BASE.setItem(0, Material.DIAMOND_SWORD, "Base Sword", "Base");
		BASE.setItem(1, Material.DIAMOND_AXE, "Base Axe", "Base");
		BASE.setItem(2, Material.BOW, "Base Bow", new Enchantment[] {Enchantment.ARROW_INFINITE}, new int[] {1}, "Base");
		
		FIRE = new GUIInventory("Fire");
		FIRE.setItem(4, Material.MAGMA_CREAM, "Artifact of Fire", "For those who have blazed", "through the children of flame");
		FIRE.setItem(18, Material.DIAMOND_SWORD, "Fire Sword", new Enchantment[] {Enchantment.FIRE_ASPECT}, new int[] {2}, "Fire");
		FIRE.setItem(19, Material.DIAMOND_AXE, "Fire Axe", new Enchantment[] {Enchantment.FIRE_ASPECT}, new int[] {2}, "Fire");
		FIRE.setItem(20, Material.TRIDENT, "Fire Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Fire");
		FIRE.setItem(21, Material.BOW, "Fire Bow", new Enchantment[] {Enchantment.ARROW_FIRE, Enchantment.ARROW_INFINITE}, new int[] {1, 1}, "Fire");
		FIRE.setItem(22, Material.CROSSBOW, "Fire Crossbow", "Fire");
		FIRE.setItem(23, Material.DIAMOND_HELMET, "Fire Helmet", new Enchantment[] {Enchantment.PROTECTION_FIRE}, new int[] {4}, "Fire");
		FIRE.setItem(24, Material.DIAMOND_CHESTPLATE, "Fire Chestplate", new Enchantment[] {Enchantment.PROTECTION_FIRE}, new int[] {4}, "Fire");
		FIRE.setItem(25, Material.DIAMOND_LEGGINGS, "Fire Leggings", new Enchantment[] {Enchantment.PROTECTION_FIRE}, new int[] {4}, "Fire");
		FIRE.setItem(26, Material.DIAMOND_BOOTS, "Fire Boots", new Enchantment[] {Enchantment.PROTECTION_FIRE}, new int[] {4}, "Fire");
		
		WIND = new GUIInventory("Wind");
		ItemStack sord = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = sord.getItemMeta();
		meta.setDisplayName("Wind Sword");
		meta.setLore(Arrays.asList("Wind"));
		meta.setUnbreakable(true);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "GENERIC_MOVEMENT_SPEED", 0.4, 
				Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "GENERIC_ATTACK_DAMAGE", 7, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "GENERIC_ATTACK_SPEED", -2, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND));
		meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		sord.setItemMeta(meta);
		ItemStack trd = new ItemStack(Material.TRIDENT);
		meta = trd.getItemMeta();
		meta.setDisplayName("Wind Trident");
		meta.setLore(Arrays.asList("Wind"));
		meta.setUnbreakable(true);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "GENERIC_MOVEMENT_SPEED", 0.4, 
				Operation.MULTIPLY_SCALAR_1, EquipmentSlot.HAND));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "GENERIC_ATTACK_DAMAGE", 7, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "GENERIC_ATTACK_SPEED", -3, 
				Operation.ADD_NUMBER, EquipmentSlot.HAND));
		meta.addEnchant(Enchantment.LOYALTY, 3, true);
		trd.setItemMeta(meta);
		WIND.setItem(4, Material.PHANTOM_MEMBRANE, "Artifact of Wind", "For those who have soared above", "the winds and gracefully descended");
		WIND.setItem(18, sord);
		WIND.setItem(19, Material.DIAMOND_AXE, "Wind Axe", new Enchantment[] {Enchantment.KNOCKBACK}, new int[] {2}, "Wind");
		WIND.setItem(20, trd);
		WIND.setItem(21, Material.BOW, "Wind Bow", new Enchantment[] {Enchantment.ARROW_KNOCKBACK, Enchantment.ARROW_INFINITE}, new int[] {2, 1}, "Wind");
		WIND.setItem(22, Material.CROSSBOW, "Wind Crossbow", "Wind");
		WIND.setItem(23, Material.DIAMOND_HELMET, "Wind Helmet", new Enchantment[] {Enchantment.PROTECTION_FALL}, new int[] {4}, "Wind");
		WIND.setItem(24, Material.ELYTRA, "Wind Chestplate", new AttributeModifier[] {new AttributeModifier(UUID.randomUUID(), "GENERIC_ARMOR", 8, 
				Operation.ADD_NUMBER, EquipmentSlot.CHEST), new AttributeModifier(UUID.randomUUID(), "GENERIC_ARMOR_TOUGHNESS", 2, Operation.ADD_NUMBER, 
						EquipmentSlot.CHEST)}, "Wind");
		WIND.setItem(25, Material.DIAMOND_LEGGINGS, "Wind Leggings", new Enchantment[] {Enchantment.PROTECTION_FALL}, new int[] {4}, "Wind");
		ItemStack bts = new ItemStack(Material.DIAMOND_BOOTS);
		meta = bts.getItemMeta();
		meta.setDisplayName("Wind Boots");
		meta.setLore(Arrays.asList("Wind"));
		meta.setUnbreakable(true);
		meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(), "GENERIC_MOVEMENT_SPEED", 0.4, 
				Operation.MULTIPLY_SCALAR_1, EquipmentSlot.FEET));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(), "GENERIC_ARMOR", 3, 
				Operation.ADD_NUMBER, EquipmentSlot.FEET));
		meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(), "GENERIC_ARMOR_TOUGHNESS", 2, 
				Operation.ADD_NUMBER, EquipmentSlot.FEET));
		meta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
		bts.setItemMeta(meta);
		WIND.setItem(26, bts);
		
		EARTH = new GUIInventory("Earth");
		EARTH.setItem(4, Material.CLAY_BALL, "Artifact of Earth", "For those who have forced their", "will deep into the Earth");
		EARTH.setItem(18, Material.DIAMOND_SWORD, "Earth Sword", "Earth");
		EARTH.setItem(19, Material.DIAMOND_AXE, "Earth Axe", "Earth");
		EARTH.setItem(20, Material.TRIDENT, "Earth Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Earth");
		EARTH.setItem(21, Material.BOW, "Earth Bow", "Earth");
		EARTH.setItem(22, Material.CROSSBOW, "Earth Crossbow", "Earth");
		EARTH.setItem(23, Material.DIAMOND_HELMET, "Earth Helmet", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.PROTECTION_PROJECTILE},
				new int[] {4, 4}, "Earth");
		EARTH.setItem(24, Material.DIAMOND_CHESTPLATE, "Earth Chestplate", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.PROTECTION_PROJECTILE},
				new int[] {4, 4}, "Earth");
		EARTH.setItem(25, Material.DIAMOND_LEGGINGS, "Earth Leggings", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.PROTECTION_PROJECTILE},
				new int[] {4, 4}, "Earth");
		EARTH.setItem(26, Material.DIAMOND_BOOTS, "Earth Boots", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.PROTECTION_PROJECTILE},
				new int[] {4, 4}, "Earth");
		
		WATER = new GUIInventory("Water");
		WATER.setItem(4, Material.GHAST_TEAR, "Artifact of Water", "For those who have fallen into", "the depths and lived to tell the tale");
		WATER.setItem(18, Material.DIAMOND_SWORD, "Water Sword", new Enchantment[] {Enchantment.DAMAGE_ARTHROPODS}, new int[] {5}, "Water");
		WATER.setItem(19, Material.DIAMOND_AXE, "Water Axe", new Enchantment[] {Enchantment.DAMAGE_ARTHROPODS}, new int[] {5}, "Water");
		WATER.setItem(20, Material.TRIDENT, "Water Trident", new Enchantment[] {Enchantment.RIPTIDE}, new int[] {3}, "Water");
		WATER.setItem(21, Material.BOW, "Water Bow", new Enchantment[] {Enchantment.ARROW_INFINITE}, new int[] {1}, "Water");
		WATER.setItem(22, Material.CROSSBOW, "Water Crossbow", "Water");
		WATER.setItem(23, Material.DIAMOND_HELMET, "Water Helmet", new Enchantment[] {Enchantment.OXYGEN, Enchantment.WATER_WORKER}, new int[] {3, 1}, "Water");
		WATER.setItem(24, Material.DIAMOND_CHESTPLATE, "Water Chestplate", "Water");
		WATER.setItem(25, Material.DIAMOND_LEGGINGS, "Water Leggings", "Water");
		WATER.setItem(26, Material.DIAMOND_BOOTS, "Water Boots", new Enchantment[] {Enchantment.DEPTH_STRIDER}, new int[] {3}, "Water");
		
		THUNDER = new GUIInventory("Thunder");
		THUNDER.setItem(4, Material.GLOWSTONE_DUST, "Artifact of Thunder", "For those who have bolted", "through the lightning");
		THUNDER.setItem(18, Material.DIAMOND_SWORD, "Thunder Sword", new Enchantment[] {Enchantment.DAMAGE_UNDEAD}, new int[] {5}, "Thunder");
		THUNDER.setItem(19, Material.DIAMOND_AXE, "Thunder Axe", "Thunder");
		THUNDER.setItem(20, Material.TRIDENT, "Thunder Trident", new Enchantment[] {Enchantment.LOYALTY, Enchantment.CHANNELING}, new int[] {3, 1}, "Thunder");
		THUNDER.setItem(21, Material.BOW, "Thunder Bow", new Enchantment[] {Enchantment.ARROW_INFINITE}, new int[] {1}, "Thunder");
		THUNDER.setItem(22, Material.CROSSBOW, "Thunder Crossbow", new Enchantment[] {Enchantment.QUICK_CHARGE}, new int[] {3}, "Thunder");
		THUNDER.setItem(23, Material.DIAMOND_HELMET, "Thunder Helmet", new Enchantment[] {Enchantment.PROTECTION_FIRE, Enchantment.PROTECTION_EXPLOSIONS}, 
				new int[] {2, 2}, "Thunder");
		THUNDER.setItem(24, Material.DIAMOND_CHESTPLATE, "Thunder Chestplate", new Enchantment[] {Enchantment.PROTECTION_FIRE, Enchantment.PROTECTION_EXPLOSIONS}, 
				new int[] {2, 2}, "Thunder");
		THUNDER.setItem(25, Material.DIAMOND_LEGGINGS, "Thunder Leggings", new Enchantment[] {Enchantment.PROTECTION_FIRE, Enchantment.PROTECTION_EXPLOSIONS}, 
				new int[] {2, 2}, "Thunder");
		THUNDER.setItem(26, Material.DIAMOND_BOOTS, "Thunder Boots", new Enchantment[] {Enchantment.PROTECTION_FIRE, Enchantment.PROTECTION_EXPLOSIONS}, 
				new int[] {2, 2}, "Thunder");
		
		ICE = new GUIInventory("Ice");
		ICE.setItem(4, Material.IRON_NUGGET, "Artifact of Ice", "For those who have perservered", "through the grasp of frost");
		ICE.setItem(18, Material.DIAMOND_SWORD, "Ice Sword", "Ice");
		ICE.setItem(19, Material.DIAMOND_AXE, "Ice Axe", "Ice");
		ICE.setItem(20, Material.TRIDENT, "Ice Trident", new Enchantment[] {Enchantment.LOYALTY, Enchantment.IMPALING}, new int[] {3, 3}, "Ice");
		ICE.setItem(21, Material.BOW, "Ice Bow", "Ice");
		ICE.setItem(22, Material.CROSSBOW, "Ice Crossbow", "Ice");
		ICE.setItem(23, Material.DIAMOND_HELMET, "Ice Helmet", new Enchantment[] {Enchantment.WATER_WORKER, Enchantment.PROTECTION_PROJECTILE, 
				Enchantment.PROTECTION_ENVIRONMENTAL}, new int[] {1, 2, 2}, "Ice");
		ICE.setItem(24, Material.DIAMOND_CHESTPLATE, "Ice Chestplate", new Enchantment[] {Enchantment.PROTECTION_PROJECTILE, Enchantment.PROTECTION_ENVIRONMENTAL},
				new int[] {2, 2}, "Ice");
		ICE.setItem(25, Material.DIAMOND_LEGGINGS, "Ice Leggings", new Enchantment[] {Enchantment.PROTECTION_PROJECTILE, Enchantment.PROTECTION_ENVIRONMENTAL},
				new int[] {2, 2}, "Ice");
		ICE.setItem(26, Material.DIAMOND_BOOTS, "Ice Boots", new Enchantment[] {Enchantment.FROST_WALKER}, new int[] {2}, "Ice");
		
		PROFIT = new GUIInventory("Profit");
		PROFIT.setItem(4, Material.EMERALD, "Artifact of Profit", "For those who have capitalized", "and profitted immensely");
		PROFIT.setItem(18, Material.DIAMOND_SWORD, "Profit Sword", new Enchantment[] {Enchantment.LOOT_BONUS_MOBS}, new int[] {3}, "Profit");
		PROFIT.setItem(19, Material.DIAMOND_AXE, "Profit Axe", new Enchantment[] {Enchantment.LOOT_BONUS_MOBS}, new int[] {3}, "Profit");
		PROFIT.setItem(20, Material.TRIDENT, "Profit Trident", new Enchantment[] {Enchantment.LOYALTY, Enchantment.LOOT_BONUS_MOBS}, new int[] {3, 3}, "Profit");
		PROFIT.setItem(21, Material.BOW, "Profit Bow", new Enchantment[] {Enchantment.LOOT_BONUS_MOBS, Enchantment.ARROW_INFINITE}, new int[] {3, 1}, "Profit");
		PROFIT.setItem(22, Material.CROSSBOW, "Profit Crossbow", new Enchantment[] {Enchantment.LOOT_BONUS_MOBS}, new int[] {3}, "Profit");
		PROFIT.setItem(23, Material.DIAMOND_HELMET, "Profit Helmet", new Enchantment[] {Enchantment.PROTECTION_PROJECTILE}, new int[] {1}, "Profit");
		PROFIT.setItem(24, Material.DIAMOND_CHESTPLATE, "Profit Chestplate", new Enchantment[] {Enchantment.PROTECTION_EXPLOSIONS}, new int[] {1}, "Profit");
		PROFIT.setItem(25, Material.DIAMOND_LEGGINGS, "Profit Leggings", new Enchantment[] {Enchantment.PROTECTION_FIRE}, new int[] {1}, "Profit");
		PROFIT.setItem(26, Material.DIAMOND_BOOTS, "Profit Boots", new Enchantment[] {Enchantment.PROTECTION_FALL}, new int[] {1}, "Profit");
		
		NATURE = new GUIInventory("Nature");
		NATURE.setItem(4, Material.SLIME_BALL, "Artifact of Nature", "For those who have grown through", "the challenges of stone and magic");
		NATURE.setItem(18, Material.DIAMOND_SWORD, "Nature Sword", "Nature");
		NATURE.setItem(19, Material.DIAMOND_AXE, "Nature Axe", new Enchantment[] {Enchantment.DIG_SPEED, Enchantment.SILK_TOUCH}, new int[] {4, 1}, "Nature");
		NATURE.setItem(20, Material.TRIDENT, "Nature Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Nature");
		NATURE.setItem(21, Material.BOW, "Nature Bow", "Nature");
		NATURE.setItem(22, Material.CROSSBOW, "Nature Crossbow", "Nature");
		NATURE.setItem(23, Material.DIAMOND_HELMET, "Nature Helmet", new Enchantment[] {Enchantment.THORNS, Enchantment.PROTECTION_PROJECTILE}, new int[] {1, 2}, "Nature");
		NATURE.setItem(24, Material.DIAMOND_CHESTPLATE, "Nature Chestplate", new Enchantment[] {Enchantment.THORNS, Enchantment.PROTECTION_PROJECTILE}, new int[] {1, 2}, "Nature");
		NATURE.setItem(25, Material.DIAMOND_LEGGINGS, "Nature Leggings", new Enchantment[] {Enchantment.THORNS, Enchantment.PROTECTION_PROJECTILE}, new int[] {1, 2}, "Nature");
		NATURE.setItem(26, Material.DIAMOND_BOOTS, "Nature Boots", new Enchantment[] {Enchantment.THORNS, Enchantment.PROTECTION_PROJECTILE}, new int[] {1, 2}, "Nature");
		
		STRENGTH = new GUIInventory("Strength");
		STRENGTH.setItem(4, Material.BONE, "Artifact of Strength", "For those who have slain", "a thousand enemies");
		STRENGTH.setItem(18, Material.DIAMOND_SWORD, "Strength Sword", new Enchantment[] {Enchantment.DAMAGE_ALL}, new int[] {5}, "Strength");
		STRENGTH.setItem(19, Material.DIAMOND_AXE, "Strength Axe", new Enchantment[] {Enchantment.DAMAGE_ALL}, new int[] {5}, "Strength");
		STRENGTH.setItem(20, Material.TRIDENT, "Strength Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Strength");
		STRENGTH.setItem(21, Material.BOW, "Strength Bow", new Enchantment[] {Enchantment.ARROW_DAMAGE, Enchantment.ARROW_INFINITE}, new int[] {5, 1}, "Strength");
		STRENGTH.setItem(22, Material.CROSSBOW, "Strength Crossbow", new Enchantment[] {Enchantment.MULTISHOT}, new int[] {1}, "Strength");
		STRENGTH.setItem(23, Material.DIAMOND_HELMET, "Strength Helmet", "Strength");
		STRENGTH.setItem(24, Material.DIAMOND_CHESTPLATE, "Strength Chestplate", "Strength");
		STRENGTH.setItem(25, Material.DIAMOND_LEGGINGS, "Strength Leggings", "Strength");
		STRENGTH.setItem(26, Material.DIAMOND_BOOTS, "Strength Boots", "Strength");
		
		HEALTH = new GUIInventory("Health");
		HEALTH.setItem(4, Material.SUGAR_CANE, "Artifact of Health", "For those who have rejuvinated", "past the brink of death");
		HEALTH.setItem(18, Material.DIAMOND_SWORD, "Health Sword", "Health");
		HEALTH.setItem(19, Material.DIAMOND_AXE, "Health Axe", "Health");
		HEALTH.setItem(20, Material.TRIDENT, "Health Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Health");
		HEALTH.setItem(21, Material.BOW, "Health Bow", "Health");
		HEALTH.setItem(22, Material.CROSSBOW, "Health Crossbow", "Health");
		HEALTH.setItem(23, Material.DIAMOND_HELMET, "Health Helmet", new AttributeModifier[] {new AttributeModifier(UUID.randomUUID(), "GENERIC_MAX_HEALTH", 10, Operation.ADD_NUMBER, EquipmentSlot.HEAD)}, "Health");
		HEALTH.setItem(24, Material.DIAMOND_CHESTPLATE, "Health Chestplate", new AttributeModifier[] {new AttributeModifier(UUID.randomUUID(), "GENERIC_MAX_HEALTH", 10, Operation.ADD_NUMBER, EquipmentSlot.CHEST)}, "Health");
		HEALTH.setItem(25, Material.DIAMOND_LEGGINGS, "Health Leggings", new AttributeModifier[] {new AttributeModifier(UUID.randomUUID(), "GENERIC_MAX_HEALTH", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS)}, "Health");
		HEALTH.setItem(26, Material.DIAMOND_BOOTS, "Health Boots", new AttributeModifier[] {new AttributeModifier(UUID.randomUUID(), "GENERIC_MAX_HEALTH", 10, Operation.ADD_NUMBER, EquipmentSlot.FEET)}, "Health");
		
		TELEKINESIS = new GUIInventory("Telekinesis");
		TELEKINESIS.setItem(4, Material.POPPED_CHORUS_FRUIT, "Artifact of Telekinesis", "For those who have mastered", "composure and psychic abilities");
		TELEKINESIS.setItem(18, Material.DIAMOND_SWORD, "Telekinesis Sword", "Telekinesis");
		TELEKINESIS.setItem(19, Material.DIAMOND_AXE, "Telekinesis Axe", "Telekinesis");
		TELEKINESIS.setItem(20, Material.TRIDENT, "Telekinesis Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Telekinesis");
		TELEKINESIS.setItem(21, Material.BOW, "Telekinesis Bow", new Enchantment[] {Enchantment.ARROW_INFINITE}, new int[] {1}, "Telekinesis");
		TELEKINESIS.setItem(22, Material.CROSSBOW, "Telekinesis Crossbow", "Telekinesis");
		TELEKINESIS.setItem(23, Material.DIAMOND_HELMET, "Telekinesis Helmet", "Telekinesis");
		TELEKINESIS.setItem(24, Material.DIAMOND_CHESTPLATE, "Telekinesis Chestplate", "Telekinesis");
		TELEKINESIS.setItem(25, Material.DIAMOND_LEGGINGS, "Telekinesis Leggings", "Telekinesis");
		TELEKINESIS.setItem(26, Material.DIAMOND_BOOTS, "Telekinesis Boots", "Telekinesis");
		
		TENACITY = new GUIInventory("Tenacity");
		TENACITY.setItem(4, Material.NAUTILUS_SHELL, "Artifact of Tenacity", "For those who have endured", "a thousand blows");
		TENACITY.setItem(18, Material.DIAMOND_SWORD, "Tenacity Sword", "Tenacity");
		TENACITY.setItem(19, Material.DIAMOND_AXE, "Tenacity Axe", "Tenacity");
		TENACITY.setItem(20, Material.TRIDENT, "Tenacity Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Tenacity");
		TENACITY.setItem(21, Material.BOW, "Tenacity Bow", new Enchantment[] {Enchantment.ARROW_INFINITE}, new int[] {1}, "Tenacity");
		TENACITY.setItem(22, Material.CROSSBOW, "Tenacity Crossbow", "Tenacity");
		TENACITY.setItem(23, Material.DIAMOND_HELMET, "Tenacity Helmet", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[] {4}, "Tenacity");
		TENACITY.setItem(24, Material.DIAMOND_CHESTPLATE, "Tenacity Chestplate", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[] {4}, "Tenacity");
		TENACITY.setItem(25, Material.DIAMOND_LEGGINGS, "Tenacity Leggings", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[] {4}, "Tenacity");
		TENACITY.setItem(26, Material.DIAMOND_BOOTS, "Tenacity Boots", new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[] {4}, "Tenacity");
		
		PUNCTURE = new GUIInventory("Puncture");
		PUNCTURE.setItem(4, Material.PRISMARINE_SHARD, "Artifact of Puncture", "For those who have skewered", "the tower of thorns and needles");
		PUNCTURE.setItem(18, Material.DIAMOND_SWORD, "Puncture Sword", new Enchantment[] {Enchantment.SWEEPING_EDGE}, new int[] {3}, "Puncture");
		PUNCTURE.setItem(19, Material.DIAMOND_AXE, "Puncture Axe", new Enchantment[] {Enchantment.DAMAGE_ALL, Enchantment.KNOCKBACK}, new int[] {3, 1}, "Puncture");
		PUNCTURE.setItem(20, Material.TRIDENT, "Puncture Trident", new Enchantment[] {Enchantment.LOYALTY, Enchantment.IMPALING}, new int[] {3, 6}, "Puncture");
		PUNCTURE.setItem(21, Material.BOW, "Puncture Bow", new Enchantment[] {Enchantment.ARROW_INFINITE, Enchantment.ARROW_DAMAGE, Enchantment.ARROW_KNOCKBACK}, new int[] {1, 5, 2}, "Puncture");
		PUNCTURE.setItem(22, Material.CROSSBOW, "Puncture Crossbow", new Enchantment[] {Enchantment.PIERCING}, new int[] {6}, "Puncture");
		PUNCTURE.setItem(23, Material.DIAMOND_HELMET, "Puncture Helmet", new Enchantment[] {Enchantment.THORNS}, new int[] {4}, "Puncture");
		PUNCTURE.setItem(24, Material.DIAMOND_CHESTPLATE, "Puncture Chestplate", new Enchantment[] {Enchantment.THORNS}, new int[] {4}, "Puncture");
		PUNCTURE.setItem(25, Material.DIAMOND_LEGGINGS, "Puncture Leggings", new Enchantment[] {Enchantment.THORNS}, new int[] {4}, "Puncture");
		PUNCTURE.setItem(26, Material.DIAMOND_BOOTS, "Puncture Boots", new Enchantment[] {Enchantment.THORNS}, new int[] {4}, "Puncture");
		
		LIGHT = new GUIInventory("Light");
		LIGHT.setItem(4, Material.SUGAR, "Artifact of Light", "For those who have relinquished", "the spire of spark");
		LIGHT.setItem(18, Material.DIAMOND_SWORD, "Light Sword", "Light");
		LIGHT.setItem(19, Material.DIAMOND_AXE, "Light Axe", "Light");
		LIGHT.setItem(20, Material.TRIDENT, "Light Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Light");
		LIGHT.setItem(21, Material.BOW, "Light Bow", "Light");
		LIGHT.setItem(22, Material.CROSSBOW, "Light Crossbow", "Light");
		LIGHT.setItem(23, Material.DIAMOND_HELMET, "Light Helmet", "Light");
		LIGHT.setItem(24, Material.DIAMOND_CHESTPLATE, "Light Chestplate", "Light");
		LIGHT.setItem(25, Material.DIAMOND_LEGGINGS, "Light Leggings", "Light");
		LIGHT.setItem(26, Material.DIAMOND_BOOTS, "Light Boots", "Light");
		
		DARK = new GUIInventory("Dark");
		DARK.setItem(4, Material.GUNPOWDER, "Artifact of Dark", "For those who have banished", "the vortex of shadows");
		DARK.setItem(18, Material.DIAMOND_SWORD, "Dark Sword", "Dark");
		DARK.setItem(19, Material.DIAMOND_AXE, "Dark Axe", "Dark");
		DARK.setItem(20, Material.TRIDENT, "Dark Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Dark");
		DARK.setItem(21, Material.BOW, "Dark Bow", "Dark");
		DARK.setItem(22, Material.CROSSBOW, "Dark Crossbow", "Dark");
		DARK.setItem(23, Material.DIAMOND_HELMET, "Dark Helmet", "Dark");
		DARK.setItem(24, Material.DIAMOND_CHESTPLATE, "Dark Chestplate", "Dark");
		DARK.setItem(25, Material.DIAMOND_LEGGINGS, "Dark Leggings", "Dark");
		DARK.setItem(26, Material.DIAMOND_BOOTS, "Dark Boots", "Dark");
		
		EXPLOSIONS = new GUIInventory("Explosion");
		EXPLOSIONS.setItem(4, Material.FIREWORK_STAR, "Artifact of Explosion", "For those who have survived", "the night of explosions");
		EXPLOSIONS.setItem(18, Material.DIAMOND_SWORD, "Explosion Sword", "Explosion");
		EXPLOSIONS.setItem(19, Material.DIAMOND_AXE, "Explosion Axe", "Explosion");
		EXPLOSIONS.setItem(20, Material.TRIDENT, "Explosion Trident", new Enchantment[] {Enchantment.LOYALTY}, new int[] {3}, "Explosion");
		EXPLOSIONS.setItem(21, Material.BOW, "Explosion Bow", new Enchantment[] {Enchantment.ARROW_KNOCKBACK}, new int[] {2},  "Explosion");
		EXPLOSIONS.setItem(22, Material.CROSSBOW, "Explosion Crossbow", new Enchantment[] {Enchantment.MULTISHOT}, new int[] {1}, "Explosion");
		EXPLOSIONS.setItem(23, Material.DIAMOND_HELMET, "Explosion Helmet", new Enchantment[] {Enchantment.PROTECTION_EXPLOSIONS}, new int[] {5}, "Explosion");
		EXPLOSIONS.setItem(24, Material.DIAMOND_CHESTPLATE, "Explosion Chestplate", new Enchantment[] {Enchantment.PROTECTION_EXPLOSIONS}, new int[] {5}, "Explosion");
		EXPLOSIONS.setItem(25, Material.DIAMOND_LEGGINGS, "Explosion Leggings", new Enchantment[] {Enchantment.PROTECTION_EXPLOSIONS}, new int[] {5}, "Explosion");
		EXPLOSIONS.setItem(26, Material.DIAMOND_BOOTS, "Explosion Boots", new Enchantment[] {Enchantment.PROTECTION_EXPLOSIONS}, new int[] {5}, "Explosion");
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(e.getItemDrop().getItemStack().getItemMeta().getLore().size() == 1 && !(e.getPlayer().isOp() && e.getPlayer().getGameMode() == GameMode.CREATIVE)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked().getType() == EntityType.BLAZE && e.getRightClicked().getName().contains("Fire")) {
			e.getPlayer().openInventory(FIRE.inv);
		} else if(e.getRightClicked().getType() == EntityType.PHANTOM && e.getRightClicked().getName().contains("Wind")) {
			e.getPlayer().openInventory(WIND.inv);
		} else if(e.getRightClicked().getType() == EntityType.SILVERFISH && e.getRightClicked().getName().contains("Earth")) {
			e.getPlayer().openInventory(EARTH.inv);
		} else if(e.getRightClicked().getType() == EntityType.DROWNED && e.getRightClicked().getName().contains("Water")) {
			e.getPlayer().openInventory(WATER.inv);
		} else if(e.getRightClicked().getType() == EntityType.CREEPER && e.getRightClicked().getName().contains("Thunder")) {
			e.getPlayer().openInventory(THUNDER.inv);
		} else if(e.getRightClicked().getType() == EntityType.STRAY && e.getRightClicked().getName().contains("Ice")) {
			e.getPlayer().openInventory(ICE.inv);
		} else if(e.getRightClicked().getType() == EntityType.VILLAGER && e.getRightClicked().getName().contains("Profit")) {
			e.getPlayer().openInventory(PROFIT.inv);
		} else if(e.getRightClicked().getType() == EntityType.WITCH && e.getRightClicked().getName().contains("Nature")) {
			e.getPlayer().openInventory(NATURE.inv);
		} else if(e.getRightClicked().getType() == EntityType.IRON_GOLEM && e.getRightClicked().getName().contains("Strength")) {
			e.getPlayer().openInventory(STRENGTH.inv);
		} else if(e.getRightClicked().getType() == EntityType.FOX && e.getRightClicked().getName().contains("Health")) {
			e.getPlayer().openInventory(HEALTH.inv);
		} else if(e.getRightClicked().getType() == EntityType.ENDERMAN && e.getRightClicked().getName().contains("Telekinesis")) {
			e.getPlayer().openInventory(TELEKINESIS.inv);
		} else if(e.getRightClicked().getType() == EntityType.SKELETON && e.getRightClicked().getName().contains("Tenacity")) {
			e.getPlayer().openInventory(TENACITY.inv);
		} else if(e.getRightClicked().getType() == EntityType.PILLAGER && e.getRightClicked().getName().contains("Puncture")) {
			e.getPlayer().openInventory(PUNCTURE.inv);
		} else if(e.getRightClicked().getType() == EntityType.VEX && e.getRightClicked().getName().contains("Light")) {
			e.getPlayer().openInventory(LIGHT.inv);
		} else if(e.getRightClicked().getType() == EntityType.WITHER_SKELETON && e.getRightClicked().getName().contains("Dark")) {
			e.getPlayer().openInventory(DARK.inv);
		} else if(e.getRightClicked().getType() == EntityType.CREEPER && e.getRightClicked().getName().contains("Explosion")) {
			e.getPlayer().openInventory(EXPLOSIONS.inv);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(!playerArmorHas(e.getPlayer(), "Light").isEmpty()) {
			if(e.getPlayer().getWorld().getTime() < 14000) {
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 0, false, false, false));
			} else {
				e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
				e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
				e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			}
		} else if(!playerArmorHas(e.getPlayer(), "Dark").isEmpty()) {
			if(e.getPlayer().getWorld().getTime() > 14000) {
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 0, false, false, false));
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 0, false, false, false));
			} else {
				e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
				e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
				e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			}
		}
	}
	
	@EventHandler
	public void onExplode(BlockExplodeEvent e) {
		e.blockList().removeAll(e.blockList());
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof LivingEntity) {
			if(e.getDamager().getType() == EntityType.PLAYER) {
				ItemStack item = ((Player) e.getDamager()).getInventory().getItemInMainHand();
				if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Nature")) {
					if(item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.DIAMOND_AXE || item.getType() == Material.TRIDENT) {
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 2, false, true, true));
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Thunder")) {
					if(item.getType() == Material.DIAMOND_AXE || item.getType() == Material.TRIDENT) {
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 255, false, true, true));
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Earth")) {
					if(item.getType() == Material.DIAMOND_AXE || item.getType() == Material.DIAMOND_SWORD) {
						e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.COBBLESTONE);
						e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().add(new Vector(0, 1, 0))).setType(Material.COBBLESTONE);
					} else if(item.getType() == Material.TRIDENT) {
						e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.CLAY);
						e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().add(new Vector(0, 1, 0))).setType(Material.CLAY);
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Fire")) {
					if(item.getType() == Material.TRIDENT) {
						e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.OBSIDIAN);
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Ice")) {
					if(item.getType() == Material.TRIDENT && e.getEntity() instanceof LivingEntity) {
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 4, false, false, true));
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Telekinesis")) {
					if(item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.DIAMOND_AXE || item.getType() == Material.TRIDENT) {
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 0, false, true, true));
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Explosions")) {
					if(item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.DIAMOND_AXE || item.getType() == Material.TRIDENT) {
						e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 2f);
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Light")) {
					if(item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.DIAMOND_AXE || item.getType() == Material.TRIDENT) {
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, false, true, true));
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 0, false, true, true));
					}
				} else if(item.hasItemMeta() && item.getItemMeta().getLore().get(0).contains("Dark")) {
					if(item.getType() == Material.DIAMOND_SWORD || item.getType() == Material.DIAMOND_AXE || item.getType() == Material.TRIDENT) {
						((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 0, false, true, true));
					}
				}
			} else if(e.getDamager().getType() == EntityType.ARROW) {
				if(e.getDamager().getScoreboardTags().contains("nature")) {
					if(e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).getType() == Material.GRASS 
							|| e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).getType() == Material.AIR) {
						e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.AIR);
						e.getEntity().getWorld().generateTree(e.getEntity().getLocation(), TreeType.TREE);
					}
				} else if(e.getDamager().getScoreboardTags().contains("ice")) {
					e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.ICE);
					e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().add(new Vector(0, 1, 0))).setType(Material.ICE);
				}
			} else if(e.getDamager().getType() == EntityType.TRIDENT) {
				if(e.getDamager().getScoreboardTags().contains("fire")) {
					e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.OBSIDIAN);
				} else if(e.getDamager().getScoreboardTags().contains("earth")) {
					e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.CLAY);
					e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().add(new Vector(0, 1, 0))).setType(Material.CLAY);
				} else if(e.getDamager().getScoreboardTags().contains("ice") && e.getEntity() instanceof LivingEntity) {
					((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 4, false, false, true));
				} else if(e.getDamager().getScoreboardTags().contains("tele") && e.getEntity() instanceof LivingEntity) {
					((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 0, false, false, true));
				} else if(e.getDamager().getScoreboardTags().contains("light") && e.getEntity() instanceof LivingEntity) {
					((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, false, true, true));
					((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 0, false, true, true));
				} else if(e.getDamager().getScoreboardTags().contains("dark") && e.getEntity() instanceof LivingEntity) {
					((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 0, false, true, true));
				}
			}
		}
	}
	
	@EventHandler
	public void onMoveItem(InventoryClickEvent e) {
		if(e.getClickedInventory().getHolder() instanceof GUIInventory) {
			if(!(e.getWhoClicked().isOp() && e.getWhoClicked().getGameMode() == GameMode.CREATIVE)) {
				e.setCancelled(true);
				Material m = e.getCurrentItem().getType();
				Material a = e.getClickedInventory().getItem(4).getType();
				if(a == m) {
					return;
				}
				int slot = e.getWhoClicked().getInventory().first(m);
				int aslot = -1;
				if((aslot = e.getWhoClicked().getInventory().first(a)) == -1 || !e.getWhoClicked().getInventory().getItem(aslot).hasItemMeta() ||
						e.getWhoClicked().getInventory().getItem(aslot).getItemMeta().getLore().size() != 2) {
					e.getWhoClicked().closeInventory();
					e.getWhoClicked().sendMessage("§4§lYou do not have the required Artifact");
					return;
				}
				if(slot == -1) {
					if(m == Material.DIAMOND_HELMET && e.getWhoClicked().getInventory().getHelmet().getItemMeta().hasLore()) {
						ItemStack temp = e.getWhoClicked().getInventory().getHelmet();
						if(temp.getItemMeta().getLore().get(0).contains("Wind")) {
							e.getWhoClicked().removePotionEffect(PotionEffectType.SLOW_FALLING);
						} else if(this.playerArmorHas(e.getWhoClicked(), temp.getItemMeta().getLore().get(0)).size() == 1) {
							if(temp.getItemMeta().getLore().get(0).contains("Water")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.WATER_BREATHING);
							} else if(temp.getItemMeta().getLore().get(0).contains("Fire")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Tenacity")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Light") || temp.getItemMeta().getLore().get(0).contains("Dark")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
							} else if(temp.getItemMeta().getLore().get(0).contains("Strength")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Earth")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.SLOW);
							} else if(temp.getItemMeta().getLore().get(0).contains("Profit")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.LUCK);
							} else if(temp.getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
								((Player) e.getWhoClicked()).setAllowFlight(false);
							}
						}
						
						e.getWhoClicked().getInventory().setHelmet(e.getCurrentItem());
						if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Wind")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Water")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Fire")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Tenacity")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Light") || e.getCurrentItem().getItemMeta().getLore().get(0).contains("Dark")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Strength")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Earth")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Profit")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
							((Player) e.getWhoClicked()).setAllowFlight(true);
							((Player) e.getWhoClicked()).setFlySpeed(0.05f);
						}
					} else if(m == Material.DIAMOND_CHESTPLATE || m == Material.ELYTRA) {
						ItemStack temp = e.getWhoClicked().getInventory().getChestplate();
						if(this.playerArmorHas(e.getWhoClicked(), temp.getItemMeta().getLore().get(0)).size() == 1) {
							if(temp.getItemMeta().getLore().get(0).contains("Water")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.WATER_BREATHING);
							} else if(temp.getItemMeta().getLore().get(0).contains("Fire")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Tenacity")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Light") || temp.getItemMeta().getLore().get(0).contains("Dark")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
							} else if(temp.getItemMeta().getLore().get(0).contains("Strength")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Earth")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.SLOW);
							} else if(temp.getItemMeta().getLore().get(0).contains("Profit")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.LUCK);
							} else if(temp.getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
								((Player) e.getWhoClicked()).setAllowFlight(false);
							}
						}
						
						e.getWhoClicked().getInventory().setChestplate(e.getCurrentItem());
						if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Water")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Fire")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Tenacity")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Light") || e.getCurrentItem().getItemMeta().getLore().get(0).contains("Dark")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Strength")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Earth")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Profit")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
							((Player) e.getWhoClicked()).setAllowFlight(true);
							((Player) e.getWhoClicked()).setFlySpeed(0.05f);
						}
					} else if(m == Material.DIAMOND_LEGGINGS) {
						ItemStack temp = e.getWhoClicked().getInventory().getLeggings();
						if(temp.getItemMeta().getLore().get(0).contains("Wind")) {
							e.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
						} else if(this.playerArmorHas(e.getWhoClicked(), temp.getItemMeta().getLore().get(0)).size() == 1) {
							if(temp.getItemMeta().getLore().get(0).contains("Water")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.WATER_BREATHING);
							} else if(temp.getItemMeta().getLore().get(0).contains("Fire")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Tenacity")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Light") || temp.getItemMeta().getLore().get(0).contains("Dark")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
							} else if(temp.getItemMeta().getLore().get(0).contains("Strength")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Earth")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.SLOW);
							} else if(temp.getItemMeta().getLore().get(0).contains("Profit")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.LUCK);
							} else if(temp.getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
								((Player) e.getWhoClicked()).setAllowFlight(false);
							} 
						}
						
						e.getWhoClicked().getInventory().setLeggings(e.getCurrentItem());
						if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Wind")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Water")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Fire")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Tenacity")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Light") || e.getCurrentItem().getItemMeta().getLore().get(0).contains("Dark")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Strength")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Earth")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Profit")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
							((Player) e.getWhoClicked()).setAllowFlight(true);
							((Player) e.getWhoClicked()).setFlySpeed(0.05f);
						}
					} else if(m == Material.DIAMOND_BOOTS) {
						ItemStack temp = e.getWhoClicked().getInventory().getLeggings();
						if(this.playerArmorHas(e.getWhoClicked(), temp.getItemMeta().getLore().get(0)).size() == 1) {
							if(temp.getItemMeta().getLore().get(0).contains("Water")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.WATER_BREATHING);
							} else if(temp.getItemMeta().getLore().get(0).contains("Fire")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Tenacity")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Light") || temp.getItemMeta().getLore().get(0).contains("Dark")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.NIGHT_VISION);
							} else if(temp.getItemMeta().getLore().get(0).contains("Strength")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							} else if(temp.getItemMeta().getLore().get(0).contains("Earth")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.SLOW);
							} else if(temp.getItemMeta().getLore().get(0).contains("Profit")) {
								e.getWhoClicked().removePotionEffect(PotionEffectType.LUCK);
							} else if(temp.getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
								((Player) e.getWhoClicked()).setAllowFlight(false);
							} 
						}
						
						e.getWhoClicked().getInventory().setBoots(e.getCurrentItem());
						if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Water")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Fire")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Tenacity")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Light") || e.getCurrentItem().getItemMeta().getLore().get(0).contains("Dark")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Strength")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Earth")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Profit")) {
							e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1000000, 4, false, false, false));
						} else if(e.getCurrentItem().getItemMeta().getLore().get(0).contains("Telekinesis") && e.getWhoClicked() instanceof Player) {
							((Player) e.getWhoClicked()).setAllowFlight(true);
							((Player) e.getWhoClicked()).setFlySpeed(0.05f);
						}
					} else {
						e.getWhoClicked().closeInventory();
						e.getWhoClicked().sendMessage("§4§lYou do not have that Weapon!");
						return;
					}
				} else {
					e.getWhoClicked().getInventory().setItem(slot, e.getCurrentItem());
				}
				e.getWhoClicked().getInventory().getItem(aslot).setAmount(e.getWhoClicked().getInventory().getItem(aslot).getAmount() - 1);
				e.getWhoClicked().closeInventory();
				e.getWhoClicked().sendMessage("§a§lYou have successfully upgraded!");
				return;
			} //else {
//				if(e.getClickedInventory() == PROFIT) {
//					Bukkit.broadcastMessage("Profit, that is " + e.getCursor().toString());
//				}
//				if(e.getCurrentItem() == null) {
//					StringBuilder a = new StringBuilder();
//					a.append(e.getSlot() + ",");
//					a.append(arg0)
//					((ArrayList<String>) LangPlugin.config.get("profitset")).add(e.getCursor());
//				}
//			}
		}
		
		if(((e.getInventory().getType() != InventoryType.CRAFTING && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasLore() && 
				e.getCurrentItem().getItemMeta().getLore().size() == 1) || e.getSlotType() == SlotType.ARMOR) && !(e.getWhoClicked().isOp() 
				&& e.getWhoClicked().getGameMode() == GameMode.CREATIVE)) {
			e.setCancelled(true);
			return;
		}
		if(e.getCurrentItem().getType() == Material.BOW && e.getCurrentItem().getItemMeta().getLore().get(0).contains("Wind") && 
				e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot() && !playerArmorHas(e.getWhoClicked(), "Wind")
				.contains(Material.DIAMOND_LEGGINGS)) {
			e.getWhoClicked().removePotionEffect(PotionEffectType.JUMP);
		}
		if(e.getCursor().getType() == Material.BOW && e.getCursor().getItemMeta().getLore().get(0).contains("Wind") && 
				e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot()) {
			e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2, false, false, false));
		}
		if(e.getCurrentItem().getType() == Material.TRIDENT && e.getCurrentItem().getItemMeta().getLore().get(0).contains("Water") && 
				e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot() && playerArmorHas(e.getWhoClicked(), "Water").isEmpty()) {
			e.getWhoClicked().removePotionEffect(PotionEffectType.WATER_BREATHING);
		}
		if(e.getCursor().getType() == Material.TRIDENT && e.getCursor().getItemMeta().getLore().get(0).contains("Water") && 
				e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot()) {
			e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0, false, false, false));
		}
		if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getLore().get(0).contains("Strength") && e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot() 
				&& playerArmorHas(e.getWhoClicked(), "Strength").isEmpty()) {
			e.getWhoClicked().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
		if(e.getCursor().hasItemMeta() && e.getCursor().getItemMeta().getLore().get(0).contains("Strength") && e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot()) {
			e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1, false, false, false));
		}
		if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getLore().get(0).contains("Tenacity") && e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot() 
				&& playerArmorHas(e.getWhoClicked(), "Tenacity").isEmpty()) {
			e.getWhoClicked().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		}
		if(e.getCursor().hasItemMeta() && e.getCursor().getItemMeta().getLore().get(0).contains("Tenacity") && e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot()) {
			e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1, false, false, false));
		}
		if((e.getCurrentItem().getType() == Material.DIAMOND_AXE || e.getCurrentItem().getType() == Material.DIAMOND_SWORD || 
				e.getCurrentItem().getType() == Material.TRIDENT) && e.getCurrentItem().getItemMeta().getLore().get(0).contains("Health")
				&& e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot() && playerArmorHas(e.getWhoClicked(), "Health").isEmpty()) {
			e.getWhoClicked().removePotionEffect(PotionEffectType.REGENERATION);
		}
		if(e.getCursor().hasItemMeta() && e.getCursor().getItemMeta().getLore().get(0).contains("Health") && e.getSlot() == e.getWhoClicked().getInventory().getHeldItemSlot()) {
			e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1, false, false, false));
		}
	}
	
	private ArrayList<Material> playerArmorHas(HumanEntity p, String s) {
		ArrayList<Material> hasWind = new ArrayList<>();
		if(p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta().getLore().get(0).contains(s))
			hasWind.add(Material.DIAMOND_HELMET);
		if(p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getItemMeta().getLore().get(0).contains(s))
			hasWind.add(Material.DIAMOND_CHESTPLATE);
		if(p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getItemMeta().getLore().get(0).contains(s))
			hasWind.add(Material.DIAMOND_LEGGINGS);
		if(p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().getLore().get(0).contains(s))
			hasWind.add(Material.DIAMOND_BOOTS);
		return hasWind;
	}
	
	@EventHandler
	public void onHeld(PlayerItemHeldEvent e) {
		if(e.getPlayer().getInventory().getItem(e.getNewSlot()) == null && !playerArmorHas(e.getPlayer(), "Wind").contains(Material.DIAMOND_LEGGINGS)) {
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
		} if(e.getPlayer().getInventory().getItem(e.getNewSlot()) == null && playerArmorHas(e.getPlayer(), "Water").isEmpty()) {
			e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
		} if(e.getPlayer().getInventory().getItem(e.getNewSlot()) == null && playerArmorHas(e.getPlayer(), "Strength").isEmpty()) {
			e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		} if(e.getPlayer().getInventory().getItem(e.getNewSlot()) == null && playerArmorHas(e.getPlayer(), "Tenacity").isEmpty()) {
			e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		}
		
		if(e.getPlayer().getInventory().getItem(e.getNewSlot()).getType() == Material.BOW && e.getPlayer().getInventory().getItem(e.getNewSlot())
				.getItemMeta().getLore().get(0).contains("Wind")) {
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2, false, false, false));
		} if((e.getPlayer().getInventory().getItem(e.getNewSlot()).getType() != Material.BOW || !e.getPlayer().getInventory().getItem(e.getNewSlot())
				.getItemMeta().getLore().get(0).contains("Wind")) && !playerArmorHas(e.getPlayer(), "Wind").contains(Material.DIAMOND_LEGGINGS)) {
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
		} 
		
		if(e.getPlayer().getInventory().getItem(e.getNewSlot()).getType() == Material.TRIDENT && e.getPlayer().getInventory().getItem(e.getNewSlot())
				.getItemMeta().getLore().get(0).contains("Water")) {
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000, 0, false, false, false));
		} if((e.getPlayer().getInventory().getItem(e.getNewSlot()).getType() != Material.TRIDENT || !e.getPlayer().getInventory().getItem(e.getNewSlot())
				.getItemMeta().getLore().get(0).contains("Water")) && playerArmorHas(e.getPlayer(), "Water").isEmpty()) {
			e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
		}
		
		if(e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLore().get(0).contains("Tenacity")) {
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1, false, false, false));
		} else if(playerArmorHas(e.getPlayer(), "Tenacity").isEmpty()) {
			e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		}
		
		if(e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLore().get(0).contains("Strength")) {
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1, false, false, false));
		} else if(playerArmorHas(e.getPlayer(), "Strength").isEmpty()) {
			e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
	}
	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		ProtectedRegion[] rs = new ProtectedRegion[1];
		WorldGuard.getInstance().getPlatform().getRegionContainer().get(new BukkitWorld(e.getEntity().getWorld())).getApplicableRegions(BlockVector3.at(e.getEntity().getLocation().getBlockX(), e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ())).getRegions().toArray(rs);
		for(ProtectedRegion pr : rs) {
			if(pr == null) {
				continue;
			}
			if(LangPlugin.useFlag && pr.getFlag(LangPlugin.CAN_USE_BOW) != null && pr.getFlag(LangPlugin.CAN_USE_BOW) == StateFlag.State.DENY && !(e.getEntityType() == 
					EntityType.PLAYER && e.getEntity().isOp() && ((Player) e.getEntity()).getGameMode() == GameMode.CREATIVE)) {
				return;
			}
		}
		if(e.getEntityType() == EntityType.ARROW) {
			if(e.getEntity().getScoreboardTags().contains("thunder")) {
				e.getEntity().getWorld().strikeLightning(e.getEntity().getLocation());
			} else if(e.getEntity().getScoreboardTags().contains("fire")) {
				e.getEntity().getWorld().getBlockAt(e.getHitBlock().getLocation().add(e.getHitBlockFace().getDirection())).setType(Material.FIRE);
			} else if(e.getHitEntity() == null && e.getEntity().getScoreboardTags().contains("earth")) {
				e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.COBBLESTONE);
				e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation().add(0, 1, 0)).setType(Material.COBBLESTONE);
			} else if(e.getHitEntity() == null && e.getEntity().getScoreboardTags().contains("ice")) {
				e.getEntity().getWorld().getBlockAt(e.getHitBlock().getLocation().add(e.getHitBlockFace().getDirection())).setType(Material.SNOW);
			} else if(e.getHitEntity() == null && e.getEntity().getScoreboardTags().contains("water")) {
				e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.WATER);
				Levelled b = (Levelled) e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).getBlockData();
				b.setLevel(8);
				e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setBlockData(b);
			} else if(e.getHitEntity() == null && e.getEntity().getScoreboardTags().contains("health") && (e.getEntity().getWorld().getBlockAt(e.getEntity().
					getLocation()).getType() == Material.AIR || e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).getType() == Material.GRASS)) {
				e.getEntity().getWorld().getBlockAt(e.getEntity().getLocation()).setType(Material.SWEET_BERRY_BUSH);
			} else if(e.getEntity().getScoreboardTags().contains("explo")) {
				e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 2f);
			} else if(e.getEntity().getScoreboardTags().contains("light")) {
				e.getEntity().getWorld().getBlockAt(e.getHitBlock().getLocation().add(e.getHitBlockFace().getDirection())).setType(Material.GLOWSTONE);
			} else if(e.getEntity().getScoreboardTags().contains("dark")) {
				if(e.getHitBlock().getType() == Material.GLOWSTONE) {
					e.getHitBlock().setType(Material.AIR);
					e.getEntity().getWorld().dropItemNaturally(e.getHitBlock().getLocation(), new ItemStack(Material.GLOWSTONE_DUST, 6));
				}
			}
		} else if(e.getEntityType() == EntityType.TRIDENT) {
			if(e.getEntity().getScoreboardTags().contains("explo")) {
				e.getEntity().setInvulnerable(true);
				e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 2f);
			}
		}
	}
	
	@EventHandler
	public void onProjectileShoot(ProjectileLaunchEvent e) {
		ProtectedRegion[] rs = new ProtectedRegion[1];
		WorldGuard.getInstance().getPlatform().getRegionContainer().get(new BukkitWorld(e.getEntity().getWorld())).getApplicableRegions(BlockVector3.at(e.getEntity().getLocation().getBlockX(), e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ())).getRegions().toArray(rs);
		for(ProtectedRegion pr : rs) {
			if(pr == null) {
				continue;
			}
			if(LangPlugin.useFlag && pr.getFlag(LangPlugin.CAN_USE_BOW) == StateFlag.State.DENY && !(e.getEntity().getShooter() instanceof Player
					&& ((Player) e.getEntity().getShooter()).isOp() && ((Player) e.getEntity().getShooter()).getGameMode() == GameMode.CREATIVE)) {
				e.setCancelled(true);
				return;
			}
		}
		
		if(e.getEntityType() == EntityType.TRIDENT && ((Trident) e.getEntity()).getShooter() instanceof Player) {
			ItemStack trident = ((Player) ((Trident) e.getEntity()).getShooter()).getInventory().getItemInMainHand();
			if(trident.getItemMeta().getLore().get(0).contains("Fire")) {
				e.getEntity().addScoreboardTag("fire");
			} else if(trident.getItemMeta().getLore().get(0).contains("Earth")) {
				e.getEntity().addScoreboardTag("earth");
			} else if(trident.getItemMeta().getLore().get(0).contains("Ice")) {
				e.getEntity().addScoreboardTag("ice");
			} else if(trident.getItemMeta().getLore().get(0).contains("Telekinesis")) {
				e.getEntity().addScoreboardTag("tele");
			} else if(trident.getItemMeta().getLore().get(0).contains("Explosions")) {
				e.getEntity().addScoreboardTag("explo");
			} else if(trident.getItemMeta().getLore().get(0).contains("Light")) {
				e.getEntity().addScoreboardTag("light");
			} else if(trident.getItemMeta().getLore().get(0).contains("Dark")) {
				e.getEntity().addScoreboardTag("dark");
			}
		} 
	}
	
	@EventHandler
	public void onShoot(EntityShootBowEvent e) {
		ProtectedRegion[] rs = new ProtectedRegion[1];
		WorldGuard.getInstance().getPlatform().getRegionContainer().get(new BukkitWorld(e.getEntity().getWorld())).getApplicableRegions(BlockVector3.at(e.getEntity().getLocation().getBlockX(), e.getEntity().getLocation().getBlockY(), e.getEntity().getLocation().getBlockZ())).getRegions().toArray(rs);
		for(ProtectedRegion pr : rs) {
			if(pr == null) {
				continue;
			}
			if(LangPlugin.useFlag && pr.getFlag(LangPlugin.CAN_USE_BOW) != null && pr.getFlag(LangPlugin.CAN_USE_BOW) == StateFlag.State.DENY && !(e.getEntityType() == 
					EntityType.PLAYER && e.getEntity().isOp() && ((Player) e.getEntity()).getGameMode() == GameMode.CREATIVE)) {
				e.setCancelled(true);
				return;
			}
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Nature")) {
			e.getProjectile().addScoreboardTag("nature");
		}
		if(e.getBow().getType() == Material.CROSSBOW && e.getBow().getItemMeta().getLore().get(0).contains("Wind")) {
			e.getProjectile().addPassenger(e.getEntity());
		} 
		if(e.getBow().getType() == Material.BOW && e.getBow().getItemMeta().getLore().get(0).contains("Thunder")) {
			e.getProjectile().addScoreboardTag("thunder");
		}
		if(e.getBow().getType() == Material.CROSSBOW && e.getBow().getItemMeta().getLore().get(0).contains("Fire")) {
			e.getProjectile().addScoreboardTag("fire");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Earth")) {
			e.getProjectile().addScoreboardTag("earth");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Ice")) {
			e.getProjectile().addScoreboardTag("ice");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Water")) {
			e.getProjectile().addScoreboardTag("water");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Health")) {
			e.getProjectile().addScoreboardTag("health");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Telekinesis")) {
			e.getProjectile().setGravity(false);
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Explosions")) {
			e.getProjectile().addScoreboardTag("explo");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Light")) {
			e.getProjectile().addScoreboardTag("light");
		}
		if(e.getBow().getItemMeta().getLore().get(0).contains("Dark")) {
			e.getProjectile().addScoreboardTag("dark");
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()) {
			List<String> ler = new ArrayList<>();
			ler.add("Base");
			ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
			ItemMeta im = boots.getItemMeta();
			im.setUnbreakable(true);
			im.setLore(ler);
			boots.setItemMeta(im);
			p.getInventory().setBoots(boots);
			ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
			im = leggings.getItemMeta();
			im.setLore(ler);
			im.setUnbreakable(true);
			leggings.setItemMeta(im);
			p.getInventory().setLeggings(leggings);
			ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
			im = chestplate.getItemMeta();
			im.setLore(ler);
			chestplate.setItemMeta(im);
			p.getInventory().setChestplate(chestplate);
			ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
			im = helmet.getItemMeta();
			im.setUnbreakable(true);
			im.setLore(ler);
			helmet.setItemMeta(im);
			p.getInventory().setHelmet(helmet);
			p.getInventory().setStorageContents(BASE.inv.getStorageContents());
		}
	}

}
