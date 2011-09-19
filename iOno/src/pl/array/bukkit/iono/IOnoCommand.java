package pl.array.bukkit.iono;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class IOnoCommand implements CommandExecutor{

	public String lang = "en";
	public Boolean enabled = false;
	public String message;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel,
			String[] arg3) {
		
		if (commandlabel.equalsIgnoreCase("changelog")) {
			if (lang == "pl") {
				sender.sendMessage(ChatColor.GOLD + "--- CHANGELOG ---");
				sender.sendMessage("Wersja 0.3:");
				sender.sendMessage("- Naprawienie komendy /enable");
				sender.sendMessage("--- Dodanie komendy (/tnt) niepozwalaj¹cej na umieszczanie TNT ---");
				sender.sendMessage("- Usuniecie mozliwosci stawiania blokow TNT");
				sender.sendMessage("- Dodanie AutoUpdatera");
				sender.sendMessage("Wersja 0.2:");
				sender.sendMessage("- Optymalizacja kodu pluginu.");
				sender.sendMessage("- Usuniecie komend zmiany jezyka.");
				sender.sendMessage("- Dodanie komendy /changelog");
				sender.sendMessage("- Dodanie nowego jezyka jakim jest Angielski");
				sender.sendMessage("- Usuniecie niektorych bugow");
				sender.sendMessage("Wersja 0.1:");
				sender.sendMessage("- Pierwsze udostepnienie pluginu.");
			}else{
				sender.sendMessage(ChatColor.GOLD + "--- CHANGELOG (EN) ---");
				sender.sendMessage("Version 0.3:");
				sender.sendMessage("- Fix /enable command");
				sender.sendMessage("--- Adding a command (/tnt) that does not allow you to place TNT ---");
				sender.sendMessage("- Removing the possibility of placing blocks of TNT");
				sender.sendMessage("- Added AutoUpdater");
				sender.sendMessage("Version 0.2:");
				sender.sendMessage("- Code optimalization.");
				sender.sendMessage("- Delete command for language change.");
				sender.sendMessage("- Add command /changelog");
				sender.sendMessage("- Add new language to plugin - English");
				sender.sendMessage("- Fix bugs");
				sender.sendMessage("Version 0.1:");
				sender.sendMessage("- Plugin release.");
			}
		}
		
		if (commandlabel.equalsIgnoreCase("day")) {
			if (lang == "pl") {
				if (!sender.isOp()) {
					sender.sendMessage("Musisz posiadac uprawnienia administratora, aby uzyc tej komendy!");

					return true;
				}else{
					PlayerMessage("[iOno] Zmieniono czas na dzien");
					Bukkit.getServer().getWorld("world").setFullTime(14);
			}
				}else{
				if (!sender.isOp()) {
					sender.sendMessage("You must be OP to use this command!");
					return true;
				}else{

					Bukkit.getServer().getWorld("world").setFullTime(14);
					PlayerMessage("[iOno] Time set to day");
			}
			
				
			}
		}
		
/*		if (commandlabel.equalsIgnoreCase("tnt")) {
			if (lang == "pl") {
				if (!sender.isOp()) {
					sender.sendMessage("Musisz posiadac uprawnienia administratora, aby uzyc tej komendy!");
					return true;
				}else{
					PlayerMessage("[iOno] Wlaczono Anty-TNT");
					this.TNT = "allow";
			}
				}else{
				if (!sender.isOp()) {
					sender.sendMessage("You must be OP to use this command!");
					return true;
				}else{
					this.TNT = "allow";
					PlayerMessage("[iOno] Enabled Anti-TNT");
			}
			
				
			}
		}
		*/
		
/*		if (commandlabel.equalsIgnoreCase("info")) {
			if (!sender.isOp()) {
				sender.sendMessage("Musisz posiadac uprawnienia administratora, aby uzyc tej komendy!");
				return true;
			}else{
				Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "--- SERVER INFORMATION ---");
				PlayerMessage("Server Mode: " +Bukkit.getServer().getOnlineMode());
				PlayerMessage("Server IP: " +Bukkit.getServer().getIp() + ": "  +Bukkit.getServer().getPort());
				
			}
		} */
		// Niszczy PlayerMessage(String);
		
		if (commandlabel.equalsIgnoreCase("/help")) {	
			if (!sender.isOp()) {
				sender.sendMessage("Pomoc dostepna tylko dla administratorow.");
				return true;
			}else{
				if (lang == "pl") {
					sender.sendMessage(ChatColor.GOLD + "--- SPIS KOMEND iOno ---");
					sender.sendMessage("/day - Zmienia czas na 14.00");
					sender.sendMessage("/night - Zmienia czas na 0.00");
					sender.sendMessage("/enable - Wlacza plugin, pokazuje informacje");
					sender.sendMessage("//langEN/PL - Set plugin language to English or Polish");
					sender.sendMessage("/r - Przeladowywuje serwer");
					sender.sendMessage("/help - Pokazuje wszystkie dostepne komendy");
					sender.sendMessage(ChatColor.GOLD + "--- PLUGIN NAPISANY PRZEZ ARRAY ---");
				}
				if (lang == "en") {
					
					sender.sendMessage(ChatColor.GOLD + "--- iOno COMMAND LIST ---");
					sender.sendMessage("/day - Set time to 14.00");
					sender.sendMessage("/night - Set time to 0.00");
					sender.sendMessage("/enable - Enabling the plugin");
					sender.sendMessage("//langEN/PL - Set plugin language to English or Polish");
					sender.sendMessage("/r - Reloading the server");
					sender.sendMessage("/help - Show list of all commands");
					sender.sendMessage(ChatColor.GOLD + "--- PLUGIN DEVELOPMENT BY ARRAY ---");
				}	
				
			}
		}	
		
		if (commandlabel.equalsIgnoreCase("night")) {
			if (!sender.isOp()) {
				sender.sendMessage("Musisz posiadac uprawnienia administratora, aby uzyc tej komendy!");
				return true;
			}else{
				
				Bukkit.getServer().getWorld("world").setFullTime(1);

				
			}
		}

		if (commandlabel.equalsIgnoreCase("r")) {
			if (lang == "pl") {
				if (!sender.isOp()) {
					sender.sendMessage("Musisz posiadac uprawnienia adminsitratora, aby uzyc tej komendy!");
				}else{
					Bukkit.getServer().reload();
					PlayerMessage("Serwer zostal przeladowany.");
				}
			}else{
				if (!sender.isOp()) {
					sender.sendMessage("You must be OP to use this command!");
				}else{
					Bukkit.getServer().reload();
					PlayerMessage("Server reload compelete.");
				}
			}
			
		}
		return false;
	}

	private void PlayerMessage(String message) {
		Bukkit.getServer().broadcastMessage(ChatColor.GREEN + message);
	}
	
	public void MessageError(String message) {
		Bukkit.getServer().broadcastMessage(ChatColor.RED + message);
	}
}
/*	private void TurnOn(boolean bolean) {
		if (lang == "pl") {
			if (bolean == true) {
				PlayerMessage("Plugin iOno - wlaczony!");
				PlayerMessage("Gracze: " +Bukkit.getServer().getWorld("world").getPlayers() + " na: " +Bukkit.getServer().getMaxPlayers() + " mozliwych graczy.");
				PlayerMessage("IP serwera: " +Bukkit.getServer().getIp() + ": " +Bukkit.getServer().getPort());
				this.enabled = true;
			}else{
					
				}
		}else{
			if (bolean == true) {
				PlayerMessage("iOno plugin - enabled!");
				PlayerMessage("Players: " +Bukkit.getServer().getWorld("world").getPlayers() + " out of: " +Bukkit.getServer().getMaxPlayers() + " max players.");
				PlayerMessage("Server IP: " +Bukkit.getServer().getIp() + ": " +Bukkit.getServer().getPort());
				this.enabled = true;
			}
		
			
		}
	}
}  */
