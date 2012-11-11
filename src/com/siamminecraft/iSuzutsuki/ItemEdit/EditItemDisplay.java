package com.siamminecraft.iSuzutsuki.ItemEdit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.siamminecraft.iSuzutsuki.SiamminecraftAPI.Item.NamedItemStack;

public class EditItemDisplay implements CommandExecutor{

	public boolean onCommand(CommandSender cs,Command cmd,String l,String[] args)
	{
		if(args.length<1)return false;
		if(!(cs instanceof Player) || !cs.hasPermission("itemedit.displayedit")){ cs.sendMessage("Error. Not enough permissions"); return true;}
		Player p = (Player)cs;		
		ItemStack item = p.getItemInHand();
		if(item == null){p.sendMessage("Error! Empty hand."); return true;}
		NamedItemStack nstack = new NamedItemStack(item);
		StringBuilder str = new StringBuilder();
		for(String s : args)
		{
			str.append(s).append(" ");
		}
		p.setItemInHand(nstack.setName(str.toString()).getItemStack());
		p.sendMessage(ChatColor.GREEN+"Edited item name");
		return true;
	}
}
