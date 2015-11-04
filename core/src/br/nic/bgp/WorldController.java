package br.nic.bgp;

import br.nic.bgp.levels.Level_01;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class WorldController{
	
	public static final String TAG = WorldController.class.getName();
	
	private static Stage _current_level;
	
	public WorldController(){
		init();
	}
	
	public void init()
	{
		
		WorldController.setLevel01();
		
		Gdx.input.setInputProcessor(WorldController.get_current_level());
	}
	
	public void update(float delta_time)
	{
		_current_level.act(delta_time);
	}
	

	public static Stage get_current_level() {
		return _current_level;
	}
	
	public static void set_current_level(Stage _current_level) {
		WorldController._current_level = _current_level;
	}
	
	public static void setLevel01()
	{
		WorldController.set_current_level(new Level_01(Constants.VIEWPORT));
		Constants.CURRENT_STAGE = Level_01.TAG;
	}
	

	

}
