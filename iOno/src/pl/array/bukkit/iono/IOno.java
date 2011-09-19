package pl.array.bukkit.iono;



import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import couk.Adamki11s.AutoUpdater.*;
import pl.array.bukkit.iono.IOnoCommand;

public class IOno extends JavaPlugin { 
	
	private Logger log = Logger.getLogger("Minecraft");
	public Configuration config;
	public String configString, welcome, welcomeen, authoren, thanks, author, thanksen;
	public String language = "en";
	public String strin1 = "Plugin IOno zostal odnaleziony!";
	private AntiTNT blocklistener = new AntiTNT(this);
	AUCore core;
	double currentVer = 0.3, currentSubVer = 0;
	public void onEnable() {
    		this.logMessage("[ENABLED]");
    		PluginManager pm = Bukkit.getServer().getPluginManager();
    		getCommand("r").setExecutor(new IOnoCommand());
    		getCommand("day").setExecutor(new IOnoCommand());
    		getCommand("night").setExecutor(new IOnoCommand());
    		getCommand("/help").setExecutor(new IOnoCommand());
    		getCommand("changelog").setExecutor(new IOnoCommand());
    		getCommand("tnt").setExecutor(new IOnoCommand());
    		config = getConfiguration();
    		if(new File("plugins/iOno").exists()){
				new File("plugins/iOno").delete();
				new File("plugins/iOno").mkdir();
			    config = getConfiguration();
			    config.setProperty("welcome", "Plugin iOno zostal odnaleziony!");
			    config.setProperty("loadingerr", "Blad podczas ladowania pluginu IOno lub jego dodatku.");
			    config.setProperty("error", "Nieznany blad! Skontaktuj sie z autorem poprzez forums.bukkit.org");
			    config.setProperty("author", "Plugin zostal stworzony przez Array. Podziekowania dla Adamki11s z bukkit.org");
			    config.setProperty("thanks", "Dziekuje za uzywanie pluginu.");
			    config.setProperty("notop", "Nie jestes administratorem wiec nie mozesz uzyc tej komendy!");
			    config.setProperty("welcomeen", "iOno plugin is found.");
			    config.setProperty("loadingerren", "Error with loading plugin or addons.");
			    config.setProperty("authoren", "Plugin development by Array. Thanks for Adamki11s from bukkit.org");
			    config.setProperty("errorern", "Error! Please visit forums.bukkit.org and contact to Array.");
			    config.setProperty("thanksen", "Thanks for using the plugin.");
			    config.setProperty("notopen", "You are not OP, u can't use this command.");
			    config.setProperty("msg", "Plugin development by Array! Thanks for using.");
			    config.save();
			}else{
			    new File("plugins/iOno").mkdir();
			    config = getConfiguration();
			    config.setProperty("welcome", "Plugin iOno zostal odnaleziony!");
			    config.setProperty("loadingerr", "Blad podczas ladowania pluginu IOno lub jego dodatku.");
			    config.setProperty("error", "Nieznany blad! Skontaktuj sie z autorem poprzez forums.bukkit.org");
			    config.setProperty("author", "Plugin zostal stworzony przez Array. Podziekowania dla Adamki11s z bukkit.org");
			    config.setProperty("thanks", "Dziekuje za uzywanie pluginu.");
			    config.setProperty("notop", "Nie jestes administratorem wiec nie mozesz uzyc tej komendy!");
			    config.setProperty("welcomeen", "iOno plugin is found.");
			    config.setProperty("loadingerren", "Error with loading plugin or addons.");
			    config.setProperty("authoren", "Plugin development by Array. Thanks for Adamki11s from bukkit.org");
			    config.setProperty("errorern", "Error! Please visit forums.bukkit.org and contact to Array.");
			    config.setProperty("thanksen", "Thanks for using the plugin.");
			    config.setProperty("notopen", "You are not OP, u can't use this command.");
			    config.setProperty("msg", "Plugin development by Array! Thanks for using.");
			    config.save();
			}
    		config.save();
    	    config.load();
    	    if (language == "pl") {
    		    welcome = config.getString("welcome");
    		    author = config.getString("author");
    		    this.IMessage(welcome);
    		    this.IMessage(author);
    	    }else {
    		    welcomeen = config.getString("welcomeen");
    		    authoren = config.getString("authoren");
    		    this.IMessage(welcomeen);
    		    this.IMessage(authoren);
    	    }
    		pm.registerEvent(Event.Type.BLOCK_PLACE, this.blocklistener, Priority.Highest, this);
    		pm.registerEvent(Event.Type.BLOCK_BREAK, this.blocklistener, Priority.Highest, this);
			core = new AUCore("http://www.ono-craft.com.pl/update.html", log, "[iOno]");
			if(!core.checkVersion(currentVer, currentSubVer, "iOno")){
		    core.forceDownload("http://ono-craft.com.pl/iOno.jar", "iOno");
         }
	}
	public void onDisable() {
		
	}

	public void logMessage(String msg) {
		// iOno Console Message
		Language(msg);
	}
	
	public void Language(String msg) {
		PluginDescriptionFile pdFile = this.getDescription();
		if (language == "en") {
			this.log.info(pdFile.getName() + " version " + pdFile.getVersion() + " EN :" + msg);
		}else{
			this.log.info(pdFile.getName() + " wersja " + pdFile.getVersion() + " PL :" + msg);
		}
	}
	
	public void IMessage(String msg) {
		// iOno Console Information
		this.log.info("Informacja iOno: " + msg);
	}

}
