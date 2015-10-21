package br.nic.bgp.actors;



import br.nic.bgp.Assets;
import br.nic.bgp.WorldController;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.ui.RibWindow;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

public class As extends Image {
	
	private final String TAG = As.class.getName();
	private boolean      _touched;
	private ScrollPane scroll;
	private AsModel _as_instance;
	private boolean _lock;


	
	public As(int asn)
	{	
		super(Assets.instance.asTextures.getRegion(asn));
		Init(asn);
		this._touched = false;
		this._lock    = false;
	
	}
	
	private void Init(int asn)
	{
		
		this._as_instance = new AsModel(asn);
		setBounds(getX(), getY(), getWidth(), getHeight());

		setTouchable(Touchable.enabled);
		setName(String.valueOf(asn));


		addListener(new InputListener(){

			@Override
			public void exit(InputEvent event, float x, float y, int pointer,
					Actor toActor) {
				//WorldController.get_current_level().getRoot().removeActor(As.this.scroll);
				if(Constants.INITIATED)
				{
					if(!As.this._lock)
					{
						As.this.scroll.setVisible(false);
				
					}
				}
				super.exit(event, x, y, pointer, toActor);
			}
			@Override
			public void enter(InputEvent event, float x, float y, int pointer,
					Actor fromActor) {
				Gdx.app.log(TAG, "Touched "+_as_instance._ASN);
				if(!Constants.INITIATED)
				{
				
				}
				else
				{
					if(As.this._touched)
					{
						As.this.scroll.setVisible(true);
					}
					else
					{
						RibWindow window = new RibWindow( "RIB", Assets.instance.skin,As.this);
						As.this.scroll = new ScrollPane(window, Assets.instance.skin);
						As.this.scroll.setSize(450, 150);
						As.this.scroll.setColor(Color.BLACK);
						As.this.scroll.setPosition(Constants.CAMERA.position.x, Constants.CAMERA.position.y);
						As.this.scroll.setScale(0.40f);
						WorldController.get_current_level().getRoot().addActor(As.this.scroll);
						As.this._touched = true;
					
					}
				}
				
				
			}
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(As.this._lock)
				{
					As.this._lock = false;
				}else
				{
					if(!As.this._lock)
						As.this._lock = true;
				}
				return super.touchDown(event, x, y, pointer, button);
			}
		});
				
	}
	

	public AsModel get_as_instance() {
		return _as_instance;
	}

}
