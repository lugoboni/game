package br.nic.bgp;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class BGPGame extends ApplicationAdapter {
	
	public static final String TAG = BGPGame.class.getName();
	
	private WorldController world_controller;
	private WorldRenderer   world_renderer;
	private boolean pause;
	

	
	@Override
	public void create () {

		
		Gdx.app.setLogLevel(Application.LOG_DEBUG);		
		
		//carregando assets
		
		Assets.instance.init(new AssetManager());
		
		world_controller = new WorldController();
		world_renderer   = new WorldRenderer(world_controller);
		
		pause = false;
	}

	@Override
	public void render () {

		
		if(!pause)
		{
			world_controller.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(0.93f, 0.6f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world_renderer.render();
	}
	
	@Override
	public void resize(int width, int height)
	{
		world_renderer.resize(width, height);
	}
	
	@Override
	public void dispose()
	{
		world_renderer.dispose();
		Assets.instance.dispose();
	}
	
	public void pause()
	{
		pause = true;
	}
	
	public void resume()
	{
		pause = false;
	}
}
