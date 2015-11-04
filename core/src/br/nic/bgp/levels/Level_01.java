package br.nic.bgp.levels;

import java.util.ArrayList;

import br.nic.bgp.Assets;
import br.nic.bgp.actors.As;
import br.nic.bgp.actors.Link;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.models.BlocIP4Model;
import br.nic.bgp.ui.MainGUI;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Level_01 extends Stage {
	
	public static final String TAG = Level_01.class.getName();
	
	private static As _22548;
	private static As _53208;
	private static As _10417;
	private static As _10715;
	private static As _1916;
	private static As _262742;
	private static As _1661;
	private static Link _22548_53208;
	private static Link _22548_10417;
	private static Link _22548_10715;
	private static Link _22548_1916;
	private static Link _1916_53208;
	private static Link _10715_53208;
	private static Link _262742_10417;
	private static Link _262742_10715;
	private static Link _10417_1661;
	private static Link _22548_1661;
	private static Link _53208_1661;
	private static Group grupo;

	public Level_01(Viewport view) {
		super(view);
		
		Init();
	}

	public void Init()
	{
		_22548 = new As(22548);
		_53208 = new As(53208);
		_10417 = new As(10417);
		_10715 = new As(10715);
		_1916  = new As(1916);
		_262742= new As(262742);
		_1661  = new As(1661);
		
		_22548.setName("22548");
		_53208.setName("53208");
		_10417.setName("10417");
		_10715.setName("10715");
		_1916.setName("1916");
		_262742.setName("262742");
		_1661.setName("1661");
		
		Constants.FIRST_BLOOD = _22548.get_as_instance();
		
		_22548_53208  = new Link(Assets.OpLink._22548_53208, _22548, _53208, 2);
		_10715_53208  = new Link(Assets.OpLink._10715_53208, _10715, _53208, 3);
		_22548_10417  = new Link(Assets.OpLink._22548_10417, _10417, _22548, 2);
		_22548_10715  = new Link(Assets.OpLink._22548_10715, _10715, _22548, 1);
		_22548_1916   = new Link(Assets.OpLink._22548_1916, _22548,  _1916, 4);
		_262742_10417 = new Link(Assets.OpLink._262742_10417, _262742, _10417, 1);
		_262742_10715 = new Link(Assets.OpLink._262742_10715, _262742, _10715, 2);
		_1916_53208   = new Link(Assets.OpLink._1916_53208, _1916, _53208, 1);
		_10417_1661   = new Link(Assets.OpLink._10417_1661, 3, _10417, _1661);
		_22548_1661   = new Link(Assets.OpLink._22548_1661, 1, _22548, _1661);
		_53208_1661   = new Link(Assets.OpLink._53208_1661, 4, _53208, _1661);
		
		
		_22548_53208.setName("_22548_53208");
		_10715_53208.setName("_10715_53208");
		_22548_10417.setName("_22548_10417");
		_22548_10715.setName("_22548_10715");
		_22548_1916.setName("_22548_1916");
		_262742_10417.setName("_262742_10417");
		_262742_10715.setName("_262742_10715");
		_1916_53208.setName("_1916_53208");
		_10417_1661.setName("_10417_1661");
		_22548_1661.setName("_22548_1661");
		_53208_1661.setName("_53208_1661");
		
		_10417_1661.setVisible(false);
		_22548_1661.setVisible(false);
		_53208_1661.setVisible(false);
		
		setConfig();
			
		grupo = new Group();
		
		grupo.addActor(_22548);
		grupo.addActor(_53208);
		grupo.addActor(_10417);
		grupo.addActor(_10715);		
		grupo.addActor(_1916);		
		grupo.addActor(_262742);
		grupo.addActor(_1661);
		
		grupo.addActor(_22548_10417);
		grupo.addActor(_22548_10715);
		grupo.addActor(_22548_1916);
		grupo.addActor(_262742_10417);
		grupo.addActor(_262742_10715);
		grupo.addActor(_1916_53208);
		grupo.addActor(_10715_53208);
		grupo.addActor(_22548_53208);
		grupo.addActor(_10417_1661);
		grupo.addActor(_22548_1661);
		grupo.addActor(_53208_1661);
		
		grupo.setSize(300, 400);
		
		this.addActor(grupo);
		grupo.scaleBy(-Constants.SCALE);
		
		
		Gdx.app.log("teste", ""+_22548.get_as_instance()._ASN);
		
		
		_22548.setPosition(Constants.VIEWPORT.getWorldWidth()/2, Constants.VIEWPORT.getWorldHeight()/2);
		
		_22548_53208.setX(_22548.getWidth()/2 + _22548.getX());
		_22548_53208.setY(- _22548_53208.getHeight() + 12f + _22548.getY());
		
		_53208.setX(_22548.getX());
		_53208.setY(_22548.getY() - _22548_53208.getHeight() - _53208.getHeight() + 22f);
		
		_22548_10417.setPosition(_22548.getX() + (_22548.getWidth()/2),
										_22548.getY() + _22548.getHeight() - 13f);
		_10417.setPosition(_22548.getX(), _22548_10417.getY() + _22548_10417.getHeight() - 13f);
		
		_22548_1916.setPosition(_22548.getX() - _22548_1916.getWidth() + 5f, 
									_22548.getY() - _22548_1916.getHeight() + 15f);
		
		_22548_10715.setPosition(_22548.getX() - _22548_10715.getWidth() + 3f,
										_22548.getY() + _22548.getHeight()/2);		
		
		_1916_53208.setPosition(_53208.getX() - _1916_53208.getWidth() + 3f,
										_53208.getY() + _53208.getHeight()/2);
		
		_1916.setPosition(_1916_53208.getX() - _1916.getWidth() + 5f, 
								_53208.getY());
		
		_10715_53208.rotateBy(48);
		_10715_53208.setPosition(_53208.getX() - _10715_53208.getWidth() + 5f, 
										_53208.getY() + _53208.getHeight() - 15f);
		
		
		
		_10715.setPosition(_1916.getX() + 6f, (float) (_10715_53208.getY() + (_10715_53208.getHeight() * Math.sin(Math.toRadians(44))) - 15f));
		
		_262742_10715.setPosition(_10715.getX() + _10715.getWidth()/2,
								_10715.getY() + _10715.getHeight() - 12f);
		
		_262742.setPosition(_10715.getX(), _262742_10715.getY() + _262742_10715.getHeight() - 13f);
		
		_262742_10417.setPosition(_262742.getX() + _262742.getWidth() - 5f, 
										_262742.getY() + _262742.getHeight()/2);
		
		_22548_1661.setPosition(_22548.getX()+_22548.getWidth() - 6, _22548.getY() + _22548.getHeight()/2);
		
		_10417_1661.setPosition(_10417.getX() + _10417.getWidth() -6, _10417.getY() - _10417.getHeight()/2 - 11);
		
		_53208_1661.setPosition(_53208.getX() + _53208.getWidth() - 6, _53208.getY()+_53208.getHeight() - 12);
		
		_1661.setPosition(_22548_1661.getX() + _22548_1661.getWidth() - 4, _22548_1661.getY() - _1661.getHeight()/2);
		
		_22548.setBounds(_22548.getX(), _22548.getY(), _22548.getWidth(), _22548.getHeight());
		_53208.setBounds(_53208.getX(), _53208.getY(), _53208.getWidth(), _53208.getHeight());
		_10417.setBounds(_10417.getX(), _10417.getY(), _10417.getWidth(), _10417.getHeight());
		_10715.setBounds(_10715.getX(), _10715.getY(), _10715.getWidth(), _10715.getHeight());
		_1916.setBounds(_1916.getX(), _1916.getY(), _1916.getWidth(), _1916.getHeight());
		_262742.setBounds(_262742.getX(), _262742.getY(), _262742.getWidth(), _262742.getHeight());
		
		_10715_53208.setLabels();
		_1916_53208.setLabels();
		_22548_10417.setLabels();
		_22548_10715.setLabels();
		_22548_1916.setLabels();
		_22548_53208.setLabels();
		_262742_10417.setLabels();
		_262742_10715.setLabels();
		
		new MainGUI();
		MainGUI.set_conexoes(new String[]{"53208", "22548", "10417"});
		super.addActor(MainGUI.get_menu());
		addLates();
		
		Gdx.input.setInputProcessor(this);
	}
	
	public void setConfig()
	{
		_22548.get_as_instance().set_addr_bloc(new BlocIP4Model("200.160.6.0/20"));
		_22548.get_as_instance().publishAddr("200.160.6.0/20", _53208.get_as_instance());
		_22548.get_as_instance().publishAddr("200.160.6.0/20", _10417.get_as_instance());
		_22548.get_as_instance().publishAddr("200.160.6.0/20", _10715.get_as_instance());
		_22548.get_as_instance().publishAddr("200.160.6.0/20", _1916.get_as_instance());
		
		_53208.get_as_instance().set_addr_bloc(new BlocIP4Model("186.56.6.0/20"));
		_53208.get_as_instance().publishAddr("186.56.6.0/20", _22548.get_as_instance());
		_53208.get_as_instance().publishAddr("186.56.6.0/20", _1916.get_as_instance());
		_53208.get_as_instance().publishAddr("186.56.6.0/20", _10715.get_as_instance());
		
		_10417.get_as_instance().set_addr_bloc(new BlocIP4Model("135.160.5.0/20"));
		_10417.get_as_instance().publishAddr("135.160.5.0/20", _22548.get_as_instance());
		_10417.get_as_instance().publishAddr("135.160.5.0/20", _22548.get_as_instance());
		_10417.get_as_instance().publishAddr("135.160.5.127/21", _262742.get_as_instance());
		
		_10715.get_as_instance().set_addr_bloc(new BlocIP4Model("201.6.5.0/20"));
		_10715.get_as_instance().publishAddr("201.6.5.0/21", _22548.get_as_instance());
		_10715.get_as_instance().publishAddr("201.6.5.127/21", _53208.get_as_instance());
		_10715.get_as_instance().publishAddr("201.6.5.127/21", _262742.get_as_instance());
		
		_1916.get_as_instance().set_addr_bloc(new BlocIP4Model("150.150.9.0/20"));
		_1916.get_as_instance().publishAddr("150.150.9.0/20", _22548.get_as_instance());
		_1916.get_as_instance().publishAddr("150.150.9.0/20", _53208.get_as_instance());
		
		_262742.get_as_instance().set_addr_bloc(new BlocIP4Model("177.9.4.0/20"));
		_262742.get_as_instance().publishAddr("177.9.4.0/20", _10417.get_as_instance());
		_262742.get_as_instance().publishAddr("177.9.4.127/21", _10715.get_as_instance());
		
		
		_1661.get_as_instance().set_addr_bloc(new BlocIP4Model("233.105.8.0/20"));	
		
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
	

	public static void setAddr(String addr, String to)
	{
		if(to == "53208")
		{
			boolean pub =_1661.get_as_instance().publishAddr(addr, _53208.get_as_instance());
			if(!pub)
			{
				Window erro = new Window("", Constants.SKIN);
				erro.add("ENDERECO NAO PODE SER ADICIONADO");
				erro.setPosition(Constants.CAMERA.position.x, Constants.CAMERA.position.y);
			}
		}
		if(to == "22548")
		{
			boolean pub =_1661.get_as_instance().publishAddr(addr, _22548.get_as_instance());
			if(!pub)
			{
				Window erro = new Window("", Constants.SKIN);
				erro.add("ENDERECO NAO PODE SER ADICIONADO");
				erro.setPosition(Constants.CAMERA.position.x, Constants.CAMERA.position.y);
			}
		}
		if(to == "10417")
		{
			boolean pub =_1661.get_as_instance().publishAddr(addr, _10417.get_as_instance());
			if(!pub)
			{
				Window erro = new Window("", Constants.SKIN);
				erro.add("ENDERECO NAO PODE SER ADICIONADO");
				erro.setPosition(Constants.CAMERA.position.x, Constants.CAMERA.position.y);
			}
		}
	}
	
	private void addLates()
	{
		for(Actor a : Constants.LATE_ACTORS)
		{
			super.addActor(a);
		}
		
		Constants.LATE_ACTORS.clear();
	}
	public As get_22548() {
		return _22548;
	}

	public As get_53208() {
		return _53208;
	}

	public As get_10417() {
		return _10417;
	}

	public As get_10715() {
		return _10715;
	}

	public As get_1916() {
		return _1916;
	}

	public As get_262742() {
		return _262742;
	}

	public As get_1661() {
		return _1661;
	}

	public Link get_22548_53208() {
		return _22548_53208;
	}

	public Link get_22548_10417() {
		return _22548_10417;
	}

	public Link get_22548_10715() {
		return _22548_10715;
	}

	public Link get_22548_1916() {
		return _22548_1916;
	}

	public Link get_1916_53208() {
		return _1916_53208;
	}

	public Link get_10715_53208() {
		return _10715_53208;
	}

	public Link get_262742_10417() {
		return _262742_10417;
	}

	public Link get_262742_10715() {
		return _262742_10715;
	}

	public Link get_10417_1661() {
		return _10417_1661;
	}

	public Link get_22548_1661() {
		return _22548_1661;
	}

	public Link get_53208_1661() {
		return _53208_1661;
	}
	
	public void lvlAddActor(Actor actor)
	{
		this.addActor(actor);
	}
}
