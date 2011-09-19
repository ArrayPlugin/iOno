package pl.array.bukkit.iono;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AntiTNT extends BlockListener {

	private IOno plugin;
	
	public AntiTNT(IOno instance) {
		this.plugin = instance;
	}
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.isCancelled()) return;
		
		Block block = event.getBlock();
		Player player = event.getPlayer();
		String pl = player.getName();
		Location loc = player.getLocation();
		
		if (block.getType() == Material.TNT) {
			block.setType(Material.AIR);
			plugin.IMessage("Player: " + pl + " try to set TNT in " + loc);
		}
	}
}

