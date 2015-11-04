package br.nic.bgp.desktop;

import br.nic.bgp.BGPGame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public class DesktopLauncher {
	
	private static boolean rebuildAtlas = true;
	
	public static void main (String[] arg) {
		
		if(rebuildAtlas)
		{
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.duplicatePadding = false;
			
			TexturePacker.process(settings, "assets-raw/images", "../android/assets/images", "bgpgame");
		}
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "BGP GAME";
		config.width = 1080;
		config.height = 720;
		new LwjglApplication(new BGPGame(), config);
	}
}
