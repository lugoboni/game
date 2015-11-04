package br.nic.bgp.ui;

import java.util.ArrayList;

import br.nic.bgp.WorldController;
import br.nic.bgp.actors.As;
import br.nic.bgp.actors.Link;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.utils.Constants;
import br.nic.bgp.utils.WorldMethods;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainGUI {
	
	public static final String TAG = MainGUI.class.getName();
	
	private static HorizontalGroup         _menu;
	private static Skin               skin = Constants.SKIN;
	private static List<String>       _menu_main;
	private static String[]           opcoes;
	private static ArrayList<String>  _conexoes;
	private static ArrayList<String>  _conectados;
	private static ScrollPane         _scroll_conect;
	private static int                 status;
	

	public MainGUI()
	{
		opcoes = new String[]{"Start", "Conectar", "Status"};
		_menu_main = new List<String>(skin);
		_menu_main.setItems(opcoes);
		_menu_main.setColor(Color.BLACK);
		
		ScrollPane scroll = new ScrollPane(_menu_main, skin);
		scroll.setColor(Color.LIGHT_GRAY);
		_menu = new HorizontalGroup();
		_menu.addActor(scroll);
		_menu.setPosition(Constants.CAMERA.position.x + 100, Constants.CAMERA.position.y - 300);
		_menu.setSize(500, 400);
		_menu.scaleBy(-0.4f);
		status = 0;
		
		_conexoes = new ArrayList<String>();	
		_conectados = new ArrayList<String>();
		_scroll_conect = null;
		
		_menu_main.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				final List<String> lista = new List<String>(skin);
				
				if(MainGUI._menu_main.getSelected() == "Start")
				{
					WorldMethods.INIT_SCENARIO();
				}
				if(MainGUI._menu_main.getSelected() == "Conectar")
				{
					if(MainGUI.status != 1)
					{
						if(MainGUI.status == 2)
						{

						}						
						
						String[] con = new String[MainGUI._conexoes.size()];
						lista.setItems(MainGUI._conexoes.toArray(con));
						MainGUI._scroll_conect = new ScrollPane(lista, skin);
						lista.addListener(new ClickListener(){
			
							@Override
							public void clicked(InputEvent event, float x, float y) {
						
									update_conectados(lista.getSelected());
									String[] con = new String[MainGUI._conexoes.size()];
		
									Link _to_set = (Link)WorldController.get_current_level().getRoot().findActor("_"+lista.getSelected()+"_"+"1661");
									As from = (As)WorldController.get_current_level().getRoot().findActor(lista.getSelected());
									As to = (As)WorldController.get_current_level().getRoot().findActor("1661");
									_to_set.Init(from.get_as_instance(), to.get_as_instance(), true);
									
									_to_set.get_link_instance().set_addr_a(from.get_as_instance().get_addr_bloc());
									_to_set.get_link_instance().set_addr_b(to.get_as_instance().get_addr_bloc());
									to.get_as_instance().initRoutes();
									
									_to_set.setVisible(true);
									to.get_as_instance().sendRoute(to.get_as_instance(), new ArrayList<AsModel>());
								
									lista.clear();
									lista.setItems(MainGUI._conexoes.toArray(con));
									_to_set.setLabels();
								super.clicked(event, x, y);
								
							}
							
						});
						
						MainGUI._menu.addActorAt(1, MainGUI._scroll_conect);
						MainGUI.status = 1;
			
	
				
					}
					else
					{	
						if(MainGUI.status == 1)
						{
							MainGUI._menu.removeActor(MainGUI._scroll_conect);
							MainGUI.status = 0;
		
						}
					}
					
					
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



	public static void set_conexoes(String[] _conexoes) 
	{
		MainGUI._conexoes.clear();
		for(String s : _conexoes)
		{
			MainGUI._conexoes.add(s);
		}

	}
	
	public static void update_conectados(String conectado)
	{

		MainGUI._conectados.add(conectado);
		MainGUI._conexoes.remove(conectado);
		
		
			
	}

	

	

}
