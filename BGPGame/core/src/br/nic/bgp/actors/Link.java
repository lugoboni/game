package br.nic.bgp.actors;

import br.nic.bgp.Assets;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.models.LinkModel;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Link extends Image{
	private final String TAG = As.class.getName();

	
	private LinkModel _link_instance;
	private float     _conter = 0;
	private Assets.OpLink oplink;
	
	public Link(Assets.OpLink l, AsModel a, AsModel b)
	{
	
		super(Assets.instance.blackLink.getRegion(l));
		oplink = l;
		Init(a, b);
	}
	
	public void Init(AsModel a, AsModel b)
	{
		Gdx.app.log(TAG, "Entrou Link constructor");
		this._link_instance = new LinkModel(a, b);
		a.insertNewLink(_link_instance);
		b.insertNewLink(_link_instance);
		Gdx.app.log(TAG, "Entrou Link constructor 2 " + this._link_instance.get_nodo_a()._ASN);
		
		
	}
	
	@Override
	public void act(float delta) {
		if(!Constants.PROPAGATION_QUEUE.isEmpty())
		{
			if(Constants.PROPAGATION_QUEUE.element() == _link_instance )
			{
				
				super.setDrawable(new TextureRegionDrawable(Assets.instance.redLink.getRegion(oplink)));
				_conter += delta;
				
				if(_conter >= Constants.UPDATE_RATE)
				{
					super.setDrawable(new TextureRegionDrawable(Assets.instance.blackLink.getRegion(oplink)));
					_conter = 0;
					Constants.PROPAGATION_QUEUE.remove();
					
				}
				
			}
		}else
		{
			
			super.setDrawable(new TextureRegionDrawable(Assets.instance.blackLink.getRegion(oplink)));
		}
	
	}
	
	public LinkModel get_link_instance() {
		return _link_instance;
	}
	
	
}
