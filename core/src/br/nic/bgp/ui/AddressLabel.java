package br.nic.bgp.ui;

import br.nic.bgp.WorldController;
import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class AddressLabel extends Label{
	public static final String TAG = AddressLabel.class.getName();
	
	private boolean type;
	private TextField _new_addr;
	private Window    _window;
	
	public AddressLabel(String text) {
		super(text, Constants.SKIN);
		super.setFontScale(0.40f);
		super.setColor(Color.BLACK);
		
	}
	
	
	public void setType(boolean type) {
		this.type = type;
	}
	
	public void setConfigs()
	{
		setBounds(getX(), getY(), getWidth(), getHeight());
		setTouchable(Touchable.enabled);
		
	}

}
