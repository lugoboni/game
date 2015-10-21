package br.nic.bgp.levels;

import br.nic.bgp.Assets;
import br.nic.bgp.actors.As;
import br.nic.bgp.actors.Link;
import br.nic.bgp.models.BlocIP4Model;
import br.nic.bgp.ui.MainGUI;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Level_01 extends Stage {
	
	private As _22548;
	private As _53208;
	private As _10417;
	private As _10715;
	private As _1916;
	private As _262742;
	private Link _22548_53208;
	private Link _22548_10417;
	private Link _22548_10715;
	private Link _22548_1916;
	private Link _1916_53208;
	private Link _10715_53208;
	private Link _262742_10417;
	private Link _262742_10715;
	private static Group grupo;

	public Level_01(Viewport view) {
		super(view);
		
		Init();
	}

	public void Init()
	{
		this._22548 = new As(22548);
		this._53208 = new As(53208);
		this._10417 = new As(10417);
		this._10715 = new As(10715);
		this._1916  = new As(1916);
		this._262742= new As(262742);
		
		Constants.FIRST_BLOOD = this._22548.get_as_instance();
		
		this._22548_53208  = new Link(Assets.OpLink._22548_53208, this._22548.get_as_instance(), this._53208.get_as_instance());
		this._10715_53208  = new Link(Assets.OpLink._10715_53208, this._10715.get_as_instance(), this._53208.get_as_instance());
		this._22548_10417  = new Link(Assets.OpLink._22548_10417, this._22548.get_as_instance(), this._10417.get_as_instance());
		this._22548_10715  = new Link(Assets.OpLink._22548_10715, this._22548.get_as_instance(), this._10715.get_as_instance());
		this._22548_1916   = new Link(Assets.OpLink._22548_1916, this._22548.get_as_instance(), this._1916.get_as_instance());
		this._262742_10417 = new Link(Assets.OpLink._262742_10417, this._262742.get_as_instance(), this._10417.get_as_instance());
		this._262742_10715 = new Link(Assets.OpLink._262742_10715, this._262742.get_as_instance(), this._10715.get_as_instance());
		this._1916_53208   = new Link(Assets.OpLink._1916_53208, this._1916.get_as_instance(), this._53208.get_as_instance());
		
		setConfig();
			
		grupo = new Group();
		
		grupo.addActor(_22548);
		grupo.addActor(_53208);
		grupo.addActor(_10417);
		grupo.addActor(_10715);		
		grupo.addActor(_1916);		
		grupo.addActor(_262742);
		
		grupo.addActor(_22548_10417);
		grupo.addActor(_22548_10715);
		grupo.addActor(_22548_1916);
		grupo.addActor(_262742_10417);
		grupo.addActor(_262742_10715);
		grupo.addActor(_1916_53208);
		grupo.addActor(_10715_53208);
		grupo.addActor(_22548_53208);
		
		grupo.setSize(300, 400);
		
		this.addActor(grupo);
		grupo.scaleBy(-0.5f);
		
		
		Gdx.app.log("teste", ""+_22548.get_as_instance()._ASN);
		
		
		this._22548.setPosition(Constants.VIEWPORT.getWorldWidth()/2, Constants.VIEWPORT.getWorldHeight()/2);
		
		this._22548_53208.setX(this._22548.getWidth()/2 + this._22548.getX());
		this._22548_53208.setY(- this._22548_53208.getHeight() + 12f + this._22548.getY());
		
		this._53208.setX(this._22548.getX());
		this._53208.setY(this._22548.getY() - this._22548_53208.getHeight() - this._53208.getHeight() + 22f);
		
		this._22548_10417.setPosition(this._22548.getX() + (this._22548.getWidth()/2),
										this._22548.getY() + this._22548.getHeight() - 13f);
		this._10417.setPosition(this._22548.getX(), this._22548_10417.getY() + this._22548_10417.getHeight() - 13f);
		
		this._22548_1916.setPosition(this._22548.getX() - this._22548_1916.getWidth() + 5f, 
									this._22548.getY() - this._22548_1916.getHeight() + 15f);
		
		this._22548_10715.setPosition(this._22548.getX() - this._22548_10715.getWidth() + 3f,
										this._22548.getY() + this._22548.getHeight()/2);		
		
		this._1916_53208.setPosition(this._53208.getX() - this._1916_53208.getWidth() + 3f,
										this._53208.getY() + this._53208.getHeight()/2);
		
		this._1916.setPosition(this._1916_53208.getX() - this._1916.getWidth() + 5f, 
								this._53208.getY());
		
		this._10715_53208.setPosition(this._53208.getX() - this._10715_53208.getWidth() + 4f, 
										this._53208.getY() + this._53208.getHeight() - 12f);
		
		this._10715.setPosition(this._1916.getX() + 4f, this._10715_53208.getY() + this._10715_53208.getHeight() - 14f);
		
		this._262742_10715.setPosition(this._10715.getX() + this._10715.getWidth()/2,
								this._10715.getY() + this._10715.getHeight() - 12f);
		
		this._262742.setPosition(this._10715.getX(), this._262742_10715.getY() + this._262742_10715.getHeight() - 13f);
		
		this._262742_10417.setPosition(this._262742.getX() + this._262742.getWidth() - 5f, 
										this._262742.getY() + this._262742.getHeight()/2);
		
		
		this._22548.setBounds(this._22548.getX(), this._22548.getY(), this._22548.getWidth(), this._22548.getHeight());
		this._53208.setBounds(this._53208.getX(), this._53208.getY(), this._53208.getWidth(), this._53208.getHeight());
		this._10417.setBounds(this._10417.getX(), this._10417.getY(), this._10417.getWidth(), this._10417.getHeight());
		this._10715.setBounds(this._10715.getX(), this._10715.getY(), this._10715.getWidth(), this._10715.getHeight());
		this._1916.setBounds(this._1916.getX(), this._1916.getY(), this._1916.getWidth(), this._1916.getHeight());
		this._262742.setBounds(this._262742.getX(), this._262742.getY(), this._262742.getWidth(), this._262742.getHeight());
		
		
		new MainGUI();
		super.addActor(MainGUI.get_menu());
		
		
		Gdx.input.setInputProcessor(this);
	}
	
	public void setConfig()
	{
		this._22548.get_as_instance().set_addr_bloc(new BlocIP4Model("200.160.6.0/20"));
		this._22548.get_as_instance().publishAddr("200.160.6.0/20", this._53208.get_as_instance());
		this._22548.get_as_instance().publishAddr("200.160.6.0/20", this._10417.get_as_instance());
		this._22548.get_as_instance().publishAddr("200.160.6.0/20", this._10715.get_as_instance());
		this._22548.get_as_instance().publishAddr("200.160.6.0/20", this._1916.get_as_instance());
		
		this._53208.get_as_instance().set_addr_bloc(new BlocIP4Model("186.56.6.0/20"));
		this._53208.get_as_instance().publishAddr("186.56.6.0/20", this._22548.get_as_instance());
		this._53208.get_as_instance().publishAddr("186.56.6.0/20", this._1916.get_as_instance());
		this._53208.get_as_instance().publishAddr("186.56.6.0/20", this._10715.get_as_instance());
		
		this._10417.get_as_instance().set_addr_bloc(new BlocIP4Model("135.160.5.0/20"));
		this._10417.get_as_instance().publishAddr("135.160.5.0/20", this._22548.get_as_instance());
		this._10417.get_as_instance().publishAddr("135.160.5.0/20", this._22548.get_as_instance());
		this._10417.get_as_instance().publishAddr("135.160.5.127/21", this._262742.get_as_instance());
		
		this._10715.get_as_instance().set_addr_bloc(new BlocIP4Model("201.6.5.0/20"));
		this._10715.get_as_instance().publishAddr("201.6.5.0/21", this._22548.get_as_instance());
		this._10715.get_as_instance().publishAddr("201.6.5.127/21", this._53208.get_as_instance());
		this._10715.get_as_instance().publishAddr("201.6.5.127/21", this._262742.get_as_instance());
		
		this._1916.get_as_instance().set_addr_bloc(new BlocIP4Model("150.150.9.0/20"));
		this._1916.get_as_instance().publishAddr("150.150.9.0/20", this._22548.get_as_instance());
		this._1916.get_as_instance().publishAddr("150.150.9.0/20", this._53208.get_as_instance());
		
		this._262742.get_as_instance().set_addr_bloc(new BlocIP4Model("177.9.4.0/20"));
		this._262742.get_as_instance().publishAddr("177.9.4.0/20", this._10417.get_as_instance());
		this._262742.get_as_instance().publishAddr("177.9.4.127/21", this._10715.get_as_instance());
		
	}

	public static Group getGrupo() {
		return grupo;
	}

	public static void insertActor(Actor actor)
	{
		getGrupo().addActor(actor);
	}
	

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		Constants.lockx = screenX;
		Constants.locky = screenY;
		return super.mouseMoved(screenX, screenY);
	}

	@Override
	public void act(float delta) {
		if(Constants.lockx >= (Gdx.graphics.getWidth() - 20))
		{
			Constants.CAMERA.translate(2, 0, 0);
			
		}
		if(Constants.lockx <= 10)
		{
			Constants.CAMERA.translate(-2, 0, 0);
		}
		if(Constants.locky >= (Gdx.graphics.getHeight() - 20))
		{
			Constants.CAMERA.translate(0, -2, 0);
		}
		if(Constants.locky <= 10)
		{
			Constants.CAMERA.translate(0, 2, 0);
		}
		
		MainGUI.get_menu().setPosition(Constants.CAMERA.position.x + 100, Constants.CAMERA.position.y - 300);
		super.act(delta);
	}	
	
}
