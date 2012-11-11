package com.siamminecraft.iSuzutsuki.ItemEdit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemEditPlugin extends JavaPlugin{

	EditItemCount eic;
	EditItemDisplay eid;
	public void onEnable(){
		eic = new EditItemCount(this);
		eid = new EditItemDisplay(this);
	}
}
