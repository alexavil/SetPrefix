package org.setprefix;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	public static main plugin;
	private static final Logger log = Logger.getLogger("Minecraft");
	

	
	  
	
	@Override
	public void onEnable() {
		plugin = this;
		if (getServer().getPluginManager().getPlugin("PermissionsEx") == null) {
			log.severe("ALERT: PEX not found!");
		}
	}
	
	
	@Override
	public void onDisable() {
		
	}
	
    @Override
    public boolean onCommand(CommandSender sender,
            Command command,
            String label,
            String[] args) {
        if (command.getName().equalsIgnoreCase("prefix")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Console can't have a prefix, sadly");
                return true;
            }
            if(!(sender.hasPermission("setprefix.use"))) {
            	sender.sendMessage("[SetPrefix] You do not have permission to do that!");
            	return true;
            }
        	if (args.length == 0) {
        		sender.sendMessage("[SetPrefix] Please specify your new prefix!");
        		return true;
        	}
        	if (args.length == 1) {
        		String player = sender.getName();
        		String prefix = args[0];
        		getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + player + " prefix" + " " + prefix);
        		sender.sendMessage("[SetPrefix] Enjoy your new prefix!");
        		return true;
        	}
        	if (args.length > 1) {
        		sender.sendMessage("[SetPrefix] Too many arguments!");
        	}

        }
        if (command.getName().equalsIgnoreCase("setprefix")) {
        	if(!(sender.hasPermission("setprefix.others"))) {
            	sender.sendMessage("[SetPrefix] You do not have permission to do that!");
            	return true;
        }
        	if (args.length == 0) {
        		sender.sendMessage("[SetPrefix] Please specify a player!");
        		return true;
        	}
        	if (args.length > 1) {
        		String player = args[0];
        		String prefix = args[1];
        		getServer().dispatchCommand(getServer().getConsoleSender(), "pex user " + player + " prefix" + " " + prefix);
        		sender.sendMessage("[SetPrefix] Prefix set!");
        		return true;
        	}
        	if (args.length == 1) {
        		sender.sendMessage("[SetPrefix] Please specify a prefix!");
        		return true;
        	}
        }
        
		return false;
    }

}
    
