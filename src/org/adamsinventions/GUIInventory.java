package org.adamsinventions;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIInventory implements InventoryHolder {
	
	public final Inventory inv;
	
	public GUIInventory(String title) {
		inv = Bukkit.createInventory(this, 27, "Upgrade to " + title);
	}
	
	@Override
	public Inventory getInventory() {
		return inv;
	}
	
	public void setItem(int slot, Material m, String name, String... lore) {
		ItemStack item = new ItemStack(m, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		inv.setItem(slot, item);
	}
	
	public void setItem(int slot, Material m, String name, AttributeModifier[] attributes, String... lore) {
		ItemStack item = new ItemStack(m, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		meta.setUnbreakable(true);
		for(AttributeModifier am : attributes) {
			meta.addAttributeModifier(Attribute.valueOf(am.getName()), am);
		}
		item.setItemMeta(meta);
		inv.setItem(slot, item);
	}
	
	public void setItem(int slot, Material m, String name, Enchantment[] enchantments, int[] levels, String... lore) {
		ItemStack item = new ItemStack(m, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lore));
		meta.setUnbreakable(true);
		for(int i = 0; i < levels.length; i++) {
			meta.addEnchant(enchantments[i], levels[i], true);
		}
		item.setItemMeta(meta);
		inv.setItem(slot, item);
	}
	
	public void setItem(int slot, ItemStack item) {
		inv.setItem(slot, item);
	}

}
