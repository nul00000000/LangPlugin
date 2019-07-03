package org.adamsinventions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;

public class LangPlugin extends JavaPlugin {
	
	public static FileConfiguration config;
	public static boolean useFlag = true;

	public static StateFlag CAN_USE_BOW = new StateFlag("can-use-bow", true);
	
	@Override
	public void onLoad() {
		FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
		try {
	        registry.register(CAN_USE_BOW);
	    } catch (FlagConflictException e) {
	    	useFlag = false;
	    	this.getLogger().warning("Conflicting can-use-bow region flag. Regions will not be protected against bows");
	    }
	}
	
	@Override
	public void onEnable() {
//		config = this.getConfig();
//		config.addDefault("profitset", new ArrayList<String>());
		Commands com = new Commands();
		this.getCommand("encant").setExecutor(com);
		this.getCommand("attrib").setExecutor(com);
		this.getServer().getPluginManager().registerEvents(new LangListener(), this);
	}

	@Override
	public void onDisable() {
//		this.saveDefaultConfig();
	}
	
}
