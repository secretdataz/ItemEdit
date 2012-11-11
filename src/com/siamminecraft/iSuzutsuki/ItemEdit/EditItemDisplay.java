package com.siamminecraft.iSuzutsuki.ItemEdit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.siamminecraft.iSuzutsuki.SiamminecraftAPI.Item.NamedItemStack;

public class EditItemDisplay implements CommandExecutor{

	ItemEditPlugin pl;
	public EditItemDisplay(ItemEditPlugin pl)
	{
		this.pl = pl;
		pl.getCommand("itemname").setExecutor(this);
		pl.getCommand("addlore").setExecutor(this);
		pl.getCommand("clearlore").setExecutor(this);
		pl.getCommand("displayhand").setExecutor(this);
	}
	public boolean onCommand(CommandSender cs,Command cmd,String l,String[] args)
	{
		try
		{
		if(cmd.getName().equalsIgnoreCase("itemname"))
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
			p.setItemInHand(nstack.setName(replaceColors(str.toString())).getItemStack());
			p.sendMessage(ChatColor.GREEN+"Edited item name");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("addlore"))
		{
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
			p.setItemInHand(nstack.addLore(replaceColors(str.toString())).getItemStack());
			p.sendMessage(ChatColor.GREEN+"Added item lore");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("clearlore"))
		{
			if(!(cs instanceof Player) || !cs.hasPermission("itemedit.displayedit")){ cs.sendMessage("Error. Not enough permissions"); return true;}
			Player p = (Player)cs;		
			ItemStack item = p.getItemInHand();
			if(item == null){p.sendMessage("Error! Empty hand."); return true;}
			NamedItemStack nstack = new NamedItemStack(item);
			p.setItemInHand(nstack.setLore().getItemStack());
			p.sendMessage(ChatColor.GREEN+"Cleared item lore");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("displayhand"))
		{
			if(!(cs instanceof Player) || !cs.hasPermission("itemedit.displayedit")){ cs.sendMessage("Error. Not enough permissions"); return true;}
			Player p = (Player)cs;		
			ItemStack item = p.getItemInHand();
			if(item == null){p.sendMessage("Error! Empty hand."); return true;}
			p.sendMessage(item.toString());
			return true;
		}
		}
		catch(Exception e)
		{
			cs.sendMessage("Error: "+e+" "+e.getMessage());
			return true;
		}
		return false;
	}
    public static String replaceColors(String string)
    {
    	return string.replaceAll("(?i)&([a-k0-9])", "\u00A7$1");
    }
}
