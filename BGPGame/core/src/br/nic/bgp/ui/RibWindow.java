package br.nic.bgp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

import br.nic.bgp.Assets;
import br.nic.bgp.WorldController;
import br.nic.bgp.actors.As;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.models.BlocIP4Model;
import br.nic.bgp.models.RouteModel;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class RibWindow extends Table {

	private static final String TAG = RibWindow.class.getName();
			
	final As as;
	private LinkedBlockingQueue< HashMap<BlocIP4Model, RouteModel>> _rib_log_clone;
	Table tabla;
	ScrollPane scroll;

	private float     _conter = 0;

	
	public RibWindow(String lbl, Skin skin, As as) {

		super(skin);
		this.as = as;
		_rib_log_clone = new LinkedBlockingQueue< HashMap<BlocIP4Model, RouteModel>>();
		_rib_log_clone.addAll(as.get_as_instance().get_rib_log());	

		tabla = new Table(Assets.instance.skin);

		scroll = new ScrollPane(tabla);
		super.setSize(400f, 500f);
		setScale(0.70f);
		super.add(scroll);
	}
	
	
	
	@Override
	public void act(float delta) {
		Table tablatemp = new Table();
	
		Label Origem = new Label("ORIGEM", Assets.instance.skin);
		Label Destino = new Label("DESTINO", Assets.instance.skin);
		Label Aspath = new Label("ASPATH", Assets.instance.skin);
		Origem.setColor(Color.GREEN);
		Destino.setColor(Color.GREEN);
		Aspath.setColor(Color.GREEN);
		tablatemp.add(Origem).left().padRight(15f);
		tablatemp.add(Destino).left().padRight(15f);
		tablatemp.add(Aspath).row();
		
		_conter += delta;
		
		tablatemp.setSize(super.getWidth(), super.getHeight());
		if(_conter >= Constants.UPDATE_RATE)
		{
			if(Constants.INITIATED)
			{
				HashMap<BlocIP4Model, RouteModel> temp;
					
					if(!_rib_log_clone.isEmpty())
					{
						try {
							
							temp = _rib_log_clone.take();
							for(BlocIP4Model b : temp.keySet())
							{
						
								RouteModel model = temp.get(b);
								Label torig = new Label(model.get_ORIGEM().get_Full_Addr(), Assets.instance.skin);
								Label tdest = new Label(model.get_DESTINO().get_Full_Addr(), Assets.instance.skin);
								ArrayList<AsModel> aspath =  model.get_ASPATH();
								
								String saspath = "";
								int tempCont = aspath.size();
								tempCont --;
								while(tempCont > -1)
								{
									saspath += aspath.get(tempCont)._ASN + " ";
									
									tempCont --;
								}
								Gdx.app.debug(TAG, saspath);
								Label laspath = new Label(saspath, Assets.instance.skin);
								laspath.setColor(Color.GREEN);
								torig.setColor(Color.GREEN);
								tdest.setColor(Color.GREEN);
								tablatemp.add(torig).left().padRight(15f);
								tablatemp.add(tdest).left().padRight(15f);
								tablatemp.add(laspath).row();
								
							}
						} catch (InterruptedException e) {
							Gdx.app.debug(TAG, "Fila atualização vazia");
							_conter = 0;
						}
						tabla.clear();
				
						tabla = tablatemp;
						tabla.setBounds(super.getX(), super.getY(), super.getWidth(), super.getHeight());
						tabla.setFillParent(true);
						tabla.setTransform(true);
						super.removeActor(tabla);
						super.add(tabla);
				

						
						
						_conter = 0;
					}else{
						_conter = 0;
						Gdx.app.debug(TAG, "Fila atualização vazia");
					}
			
			}
		
		}
	}
}
