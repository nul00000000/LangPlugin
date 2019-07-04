package org.adamsinventions;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		switch(label) {
		case "encant":
			if(sender.hasPermission("lang.encant"))
				return encant(sender, args);
			else {
				sender.sendMessage("You do not have permission to do that command");
				return true;
			}
		case "attrib":
			if(!sender.hasPermission("lang.attrib")) {
				sender.sendMessage("You do not have permission to do that command");
				return true;
			}
			if(args.length <= 1) {
				return false;
			}
			String[] n = new String[args.length - 1];
			System.arraycopy(args, 1, n, 0, n.length);
			if(args[0].contains("add")) {
				return addattrib(sender, n);
			} else if(args[0].contains("remove")) {
				return removeattrib(sender, n);
			}
			return false;
		case "flyspeed":
			if(!sender.hasPermission("lang.flyspeed")) {
				sender.sendMessage("You do not have permission to do that command");
				return true;
			}
			float a = 0;
			try {
				a = Float.parseFloat(args[0]);
			} catch(NumberFormatException e) {
				sender.sendMessage("That is not a valid number");
				return true;
			} catch(IndexOutOfBoundsException e) {
				return false;
			}
			if(sender instanceof Player) {
				((Player) sender).setFlySpeed(a);
			} else {
				sender.sendMessage("You are not a player!");
				return true;
			}
			return true;
		default:
			return false;
		}
	}
	
	public boolean encant(CommandSender sender, String[] args) {
		Player p = Bukkit.getPlayer(args[0]);
		if(p == null && sender instanceof HumanEntity) {
			ItemMeta i = ((HumanEntity) sender).getInventory().getItemInMainHand().getItemMeta();
			i.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[0])), args.length > 2 ? Integer.parseInt(args[2]) : 1, true);
			((HumanEntity) sender).getInventory().getItemInMainHand().setItemMeta(i);
			return true;
		}
		if(p.getInventory().getItemInMainHand() == null) {
			sender.sendMessage("That boi not holding an item, fam");
			return false;
		}
		ItemMeta i = p.getInventory().getItemInMainHand().getItemMeta();
		i.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[1])), args.length > 2 ? Integer.parseInt(args[2]) : 1, true);
		p.getInventory().getItemInMainHand().setItemMeta(i);
		return true;
	}
	
	public boolean addattrib(CommandSender sender, String[] args) {
		Player p = Bukkit.getPlayer(args[0]);
		int offset = 0;
		if(p == null && sender instanceof Player) {
			p = (Player) sender;
			offset = -1;
		} else {
			sender.sendMessage("Player " + args[0] + " not found");
			return false;
		}
		if(p.getInventory().getItemInMainHand() == null) {
			sender.sendMessage("That boi not holding an item, fam");
			return false;
		}
		Material m = p.getInventory().getItemInMainHand().getType();
		ItemMeta i = p.getInventory().getItemInMainHand().getItemMeta();
		EquipmentSlot es = null;
		if(m == Material.DIAMOND_HELMET) {
			es = EquipmentSlot.HEAD;
		} else if(m == Material.DIAMOND_CHESTPLATE) {
			es = EquipmentSlot.CHEST;
		} else if(m == Material.DIAMOND_LEGGINGS) {
			es = EquipmentSlot.LEGS;
		} else if(m == Material.DIAMOND_BOOTS) {
			es = EquipmentSlot.FEET;
		} else {
			es = EquipmentSlot.HAND;
		}
		i.addAttributeModifier(Attribute.valueOf(args[1 + offset]), new AttributeModifier(UUID.randomUUID(), args[1 + offset], 
				Double.parseDouble(args[2 + offset]), Operation.values()[Integer.parseInt(args[3 + offset])], es));
		p.getInventory().getItemInMainHand().setItemMeta(i);
		return true;
	}
	
	public boolean removeattrib(CommandSender sender, String[] args) {
		Player p = Bukkit.getPlayer(args[0]);
		int offset = 0;
		if(p == null && sender instanceof Player) {
			p = (Player) sender;
			offset = -1;
		}
		if(p.getInventory().getItemInMainHand() == null) {
			sender.sendMessage("That boi not holding an item, fam");
			return false;
		}
		ItemMeta i = p.getInventory().getItemInMainHand().getItemMeta();
		i.removeAttributeModifier(Attribute.valueOf(args[1 + offset]));
		p.getInventory().getItemInMainHand().setItemMeta(i);
		return true;
	}

}
