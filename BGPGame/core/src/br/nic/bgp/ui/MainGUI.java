package br.nic.bgp.ui;

import br.nic.bgp.Assets;
import br.nic.bgp.utils.Constants;
import br.nic.bgp.utils.WorldMethods;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainGUI {
	
	private static HorizontalGroup         _menu;
	private static Skin          skin = Assets.instance.skin;
	private static List<String>  _menu_main;
	private static Table         _menu_secondary;
	private static String[]      opcoes;
	
	
	public MainGUI()
	{
		opcoes = new String[]{"Conexoes", "Rotas", "Atualizar", "Status"};
		_menu_main = new List<String>(skin);
		_menu_main.setItems(opcoes);
		_menu_main.setColor(Color.BLACK);
		_menu_secondary = new Table();
		ScrollPane scroll = new ScrollPane(_menu_main, skin);
		scroll.setColor(Color.LIGHT_GRAY);
		_menu = new HorizontalGroup();
		_menu.addActor(scroll);
		_menu.addActor(_menu_secondary);
		_menu.setPosition(Constants.CAMERA.position.x + 100, Constants.CAMERA.position.y - 300);
		_menu.setSize(500, 400);
		_menu.scaleBy(-0.4f);
		
		_menu_main.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(MainGUI._menu_main.getSelected() == "Atualizar")
				{
					WorldMethods.INIT_SCENARIO();
				}
				super.clicked(event, x, y);
			}
		});
	}


	public static HorizontalGroup get_menu() {
		return _menu;
	}


	public static void set_menu(HorizontalGroup _menu) {
		MainGUI._menu = _menu;
	}



	

}
