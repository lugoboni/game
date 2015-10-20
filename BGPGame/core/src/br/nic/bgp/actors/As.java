package br.nic.bgp.actors;



import br.nic.bgp.Assets;
import br.nic.bgp.WorldController;
import br.nic.bgp.levels.Level_01;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.models.BlocIP4Model;
import br.nic.bgp.models.RouteModel;
import br.nic.bgp.ui.RibWindow;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class As extends Image {
	
	private final String TAG = As.class.getName();
	private boolean      _touched;
	private ScrollPane scroll;
	private AsModel _as_instance;
	
	

	
	public As(int asn)
	{	
		super(Assets.instance.asTextures.getRegion(asn));
		Init(asn);
		this._touched = false;
	
	}
	
	private void Init(int asn)
	{
		
		this._as_instance = new AsModel(asn);
		setBounds(getX(), getY(), getWidth(), getHeight());

		setTouchable(Touchable.enabled);
		setName(String.valueOf(asn));
		
		addListener(new ClickListener(){
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log(TAG, "Touched "+_as_instance._ASN);
				if(!Constants.INITIATED)
				{
				
				}
				else
				{
					
					if(!As.this._touched)
					{
						RibWindow window = new RibWindow( "RIB", Assets.instance.skin,As.this);
						As.this.scroll = new ScrollPane(window, Assets.instance.skin);
						As.this.scroll.setSize(400, 300);
						As.this.scroll.setColor(Color.BLACK);
						As.this.scroll.setPosition(As.this.getX() + As.this.getWidth(), As.this.getY());
						As.this.scroll.setScale(0.70f);
						WorldController.get_current_level().getRoot().addActor(As.this.scroll);
						As.this._touched = true;
					}
					else
					{
						WorldController.get_current_level().getRoot().removeActor(As.this.scroll);
						As.this._touched = false;
					}
				}
				
				
			}
		});
				
	}
	
	


	
	

	

	public AsModel get_as_instance() {
		return _as_instance;
	}

}
