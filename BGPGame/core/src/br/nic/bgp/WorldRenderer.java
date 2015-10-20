package br.nic.bgp;


import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRenderer implements Disposable {

	public static final String TAG = WorldRenderer.class.getName();
	
	private WorldController    world_controller;
	private SpriteBatch        batch;


	public WorldRenderer(WorldController controller)
	{
		world_controller = controller;

		init();
	}
	
	
	public void init()
	{
		batch = new SpriteBatch();
	}
	
	public void render()
	{
		Constants.CAMERA.update();
		
		batch.setProjectionMatrix(Constants.CAMERA.combined);
		batch.begin();
		
		world_controller.update(Gdx.graphics.getDeltaTime());
		WorldController.get_current_level().draw();			
		batch.end();
		
	}
	
	public void resize(int width, int height)
	{
		//Constants.CAMERA.viewportWidth = (Constants.VIEWPORT_HEIGHT/height) * width;
		Constants.VIEWPORT.update(width, height,true);
	}
	
	@Override
	public void dispose()
	{
		batch.dispose();
		WorldController.get_current_level().dispose();
	}
	
}
