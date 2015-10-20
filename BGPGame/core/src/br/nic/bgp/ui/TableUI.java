package br.nic.bgp.ui;

import br.nic.bgp.Assets;
import br.nic.bgp.utils.WorldMethods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TableUI{
	
	public static final String TAG = TableUI.class.getName();

	private Skin        skin;
	private Table      _menu;
	public static TableUI _instance = new TableUI();
	
	private TableUI(){}
	
	
	
	public void init()
	{

		this.skin = Assets.instance.skin;
		_menu = new Table();
		TextButton botao = new TextButton("START SCENARIO", skin);

		TextField opcao = new TextField("START SCENARIO", skin);
		opcao.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				WorldMethods.INIT_SCENARIO();
				_menu.setVisible(false);
			}
		});
		_menu.setDebug(true);
		this._menu.add(opcao);
		botao.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				WorldMethods.INIT_SCENARIO();
				_menu.setVisible(false);
				
			}
		});
		_menu.setPosition(800, 50);
		_menu.setSize(300, 100);
	}
	/*
	public Window newTableWindow(As as)
	{
		
		Label rib = new Label("NETWORK    " + "NEXTHOP    " + "LOC PREF    " + "PATH   ", Assets.instance.skin);
		final Window window = new Window("RIB", Assets.instance.skin);
		window.add(rib).row();
		

		window.setPosition( as.getX(), as.getY());
		window.setVisible(true);
	
		Button close = new Button(Assets.instance.skin);
		window.add(close).top().left().row();

		window.setSize(300, 500);
		window.scaleBy(-0.3f);
		
		
		
		window.setVisible(true);
		
		close.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				WorldController.get_current_level().getRoot().removeActor(window);
				
			}
		});
		return window;
		
	}*/

	public Table get_menu() {
		return _menu;
	}

	
	
}
