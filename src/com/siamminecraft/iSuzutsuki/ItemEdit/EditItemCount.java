package com.siamminecraft.iSuzutsuki.ItemEdit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class EditItemCount implements CommandExecutor{

	ItemEditPlugin pl;
	public EditItemCount(ItemEditPlugin pl){
		this.pl=pl;
		pl.getCommand("itemedit").setExecutor(this);
	}
	public boolean onCommand(CommandSender cs,Command cmd,String label,String[] args){
		try{
		if(args[0].equalsIgnoreCase("set"))
		{
			if(args.length != 2)return false;
			if(!(cs instanceof Player) || !cs.hasPermission("itemedit.unlimited")){ cs.sendMessage("Error. Not enough permissions"); return true;}
			Player p = (Player)cs;
			ItemStack item = p.getItemInHand();
			if(item == null){p.sendMessage("Error! Empty hand."); return true;}
			item.setAmount(Integer.parseInt(args[1]));
			p.sendMessage(ChatColor.GREEN+"Edited item count");
			return true;
		}
		if(args[0].equalsIgnoreCase("add"))
		{
			if(args.length != 2)return false;
			if(!(cs instanceof Player) || !cs.hasPermission("itemedit.unlimited")){ cs.sendMessage("Error. Not enough permissions"); return true;}
			Player p = (Player)cs;
			ItemStack item = p.getItemInHand();
			if(item == null){p.sendMessage("Error! Empty hand."); return true;}
			item.setAmount(item.getAmount()+Integer.parseInt(args[1]));
			p.sendMessage(ChatColor.GREEN+"Edited item count");
			return true;
		}
		}catch(Exception ex){
			cs.sendMessage("Error: "+ex+" "+ex.getMessage());
			return true;
		}
		return false;
	}
}
