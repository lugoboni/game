package br.nic.bgp.actors;

import br.nic.bgp.Assets;
import br.nic.bgp.WorldController;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.models.LinkModel;
import br.nic.bgp.ui.AddressLabel;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Link extends Image{
	private final String TAG = As.class.getName();

	/**
	 * _orientacao
	 * 	1 - vertical
	 *  2 - horizontal
	 *  3 - diagonal esquerda alta
	 *  4 - diagonal esquerda baixa
	 */
	private LinkModel _link_instance;
	private float     _conter = 0;
	private Assets.OpLink oplink;
	private AddressLabel     _adda;
	private AddressLabel     _addb;
	private As        _nodo_a;
	private As        _nodo_b;
	private int       _orientacao; 
	private boolean   _main;
	private TextField _new_addr;
	private Window    _window;
	
	public Link(Assets.OpLink l, As a, As b, int orientacao)
	{
	
		super(Assets.instance.blackLink.getRegion(l));
		oplink = l;
		this._nodo_a = a;
		this._nodo_b = b; 
		this._orientacao = orientacao;
		this._main = false;
		Init(a.get_as_instance(), b.get_as_instance(), false);
	}
	
	public Link(Assets.OpLink l, int orientacao,  As a, As b)
	{
		super(Assets.instance.blackLink.getRegion(l));
		this._orientacao = orientacao;
		oplink = l;
		this._nodo_a = a;
		this._nodo_b = b; 
	}
	
	public void Init(AsModel a, AsModel b, boolean main)
	{
		this._main = main;
		Gdx.app.log(TAG, "Entrou Link constructor");
		this._link_instance = new LinkModel(a, b);

		a.insertNewLink(_link_instance);
		b.insertNewLink(_link_instance);
		Gdx.app.log(TAG, "Entrou Link constructor 2 " + this._link_instance.get_nodo_a()._ASN);
		
		setBounds(getX(), getY(), getWidth(), getHeight());
		setTouchable(Touchable.enabled);
		setName("_"+String.valueOf(_link_instance.get_nodo_a()._ASN)+"_"+String.valueOf(_link_instance.get_nodo_b()._ASN));

		
		addListener(new InputListener(){
			boolean touched = false;
			@Override
			public void enter(InputEvent event, float x, float y, int pointer,
					Actor fromActor) {
				switch(_orientacao){
				case 1:
					Gdx.app.debug(TAG, "1");

					Link.this._adda.setPosition((Link.this._nodo_a.getX() +Link.this._nodo_a.getWidth() - Link.this._adda.getWidth()) * Constants.SCALE, Link.this._nodo_a.getY()  * Constants.SCALE - 10);
					Link.this._addb.setPosition(Link.this._nodo_b.getX() * Constants.SCALE, Link.this._nodo_b.getY()   * Constants.SCALE - 10);
				
					break;
				case 2:
					Gdx.app.debug(TAG, "2");
					_adda.setPosition(Link.this.getX() * Constants.SCALE + 2, (Link.this.getY() + Link.this.getHeight()) * Constants.SCALE - 20);
					_addb.setPosition(Link.this.getX() * Constants.SCALE + 2, Link.this.getY() * Constants.SCALE - 5);
					break;
				case 3:
					Gdx.app.debug(TAG, "3");
					_adda.setPosition((Link.this._nodo_a.getX() + Link.this._nodo_a.getWidth() - Link.this.getWidth())* Constants.SCALE,  Link.this._nodo_a.getY()* Constants.SCALE - 10);
					_addb.setPosition((Link.this.getX() + Link.this.getWidth()) * Constants.SCALE, Link.this.getY() * Constants.SCALE - 10);
					break;
				case 4:
					Gdx.app.debug(TAG, "4");
					_adda.setPosition(Link.this.getX() * Constants.SCALE,  Link.this.getY()  * Constants.SCALE - 10);
					_addb.setPosition((Link.this.getX() + Link.this.getWidth()) * Constants.SCALE, (Link.this.getY() + Link.this.getHeight())* Constants.SCALE - 10);
					break;
				default:
					Gdx.app.debug(TAG, "default");
					Link.this._adda.setPosition(Link.this._nodo_a.getX() * Constants.SCALE, Link.this._nodo_a.getY() * Constants.SCALE - 10);
					Link.this._addb.setPosition(Link.this._nodo_b.getX() * Constants.SCALE, Link.this._nodo_b.getY() * Constants.SCALE - 10);
					break;
				}
				
				WorldController.get_current_level().addActor(Link.this._adda);
				WorldController.get_current_level().addActor(Link.this._addb);
				super.enter(event, x, y, pointer, fromActor);
			}
			
			@Override
			public void exit(InputEvent event, float x, float y, int pointer,
					Actor toActor) {
				if(!touched)
				{WorldController.get_current_level().getRoot().removeActor(Link.this._adda);
				WorldController.get_current_level().getRoot().removeActor(Link.this._addb);
				}
				super.exit(event, x, y, pointer, toActor);
			}
			
			
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
					touched = true;
				return super.touchDown(event, x, y, pointer, button);
			}
			
		});
		
		
		
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
	
	public void set_adda(AddressLabel _adda) {
		this._adda = _adda;
	}
	
	public void set_addb(AddressLabel _addb) {
		this._addb = _addb;
	}
	
	public void setLabels()
	{
		String a = _link_instance.get_addr_a().get_Full_Addr();
		String b = _link_instance.get_addr_b().get_Full_Addr();
		_adda = new AddressLabel(a);
		_addb = new AddressLabel(b);
		if(this._main)
		{
			
		
			_addb.setConfigs();
			this._window  = new Window("Insira o novo endereco", Constants.SKIN);
			TextButton button   = new TextButton("Atualizar", Constants.SKIN);
			TextButton cancelar = new TextButton("Cancelar", Constants.SKIN);
			Table      tabla_up    = new Table();
			Table      tabla_down  = new Table();
			Table      tabla       = new Table();
			
			
			this._new_addr = new TextField("xxx.xxx.xxx.xxx/xx", Constants.SKIN);
			this._new_addr.setFillParent(true);

			tabla_up.add(this._new_addr).expand().fill();
			tabla_down.add(button).expand().fill();		
			tabla_down.add(cancelar).expand().fill();
			tabla.add(tabla_up).expand().fill().row();
			tabla.add(tabla_down).expand().fill();
			this._window.add(tabla);
			this._window.setColor(Color.LIGHT_GRAY);
			this._window.setVisible(false);
			this._window.setSize(200, 100);
			this._window.scaleBy(-Constants.SCALE);
			_addb.addListener(new InputListener(){
				@Override
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					Gdx.app.debug(TAG, "tocou");
					WorldController.get_current_level().addActor(Link.this._window);
					Link.this._window.setPosition(Constants.CAMERA.position.x, Constants.CAMERA.position.y);
					Link.this._window.setVisible(true);
					return super.touchDown(event, x, y, pointer, button);
				}
			});
			
			cancelar.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					WorldController.get_current_level().getRoot().removeActor(Link.this._window);
					super.clicked(event, x, y);
				}
			});
			
			button.addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					if(Link.this._new_addr.getText().matches("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}/[0-9]{1,2}"))
					{
						
						_addb.setText(Link.this._new_addr.getText());
						WorldController.get_current_level().getRoot().removeActor(Link.this._window);
					
					}
					super.clicked(event, x, y);
				}
			});
			
		}
		
	}
}
