package br.nic.bgp.utils;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import br.nic.bgp.Assets;
import br.nic.bgp.models.AsModel;
import br.nic.bgp.models.LinkModel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FillViewport;

public class Constants {

	public static final float VIEWPORT_WIDTH = 1000;
	
	public static final float VIEWPORT_HEIGHT = 1000;
	
	public static float       ASPECT_RATIO = (float) Gdx.graphics.getHeight()/(float) Gdx.graphics.getWidth();
	
	public static OrthographicCamera CAMERA = new OrthographicCamera(VIEWPORT_WIDTH/2, VIEWPORT_HEIGHT/2);
	
	public static FillViewport VIEWPORT = new FillViewport(VIEWPORT_HEIGHT * ASPECT_RATIO,VIEWPORT_HEIGHT, CAMERA);	
	
	public static final String TEXTURE_ATLAS_OBJECTS = "images/bgpgame.atlas";
	
	public static final String LEVEL_01 ="levels/level-01.png";
	
	public static final String SKIN_FOLDER = "skin/uiskin.json";
	
	public static final float  SCALE  = 0.5f;
	
	public static boolean ENDGAME = false;
	
	public static boolean INITIATED = false;
	
	public static LinkedBlockingQueue<LinkModel> PROPAGATION_QUEUE = new LinkedBlockingQueue<LinkModel>();
	
	public static AsModel FIRST_BLOOD;
	
	public static String CURRENT_STAGE;
	
	public static final float UPDATE_RATE = 1.0f;
	
	public static int lockx, locky;
	
	public static ArrayList<Actor> LATE_ACTORS = new ArrayList<Actor>();
	
	public static final Skin    SKIN = Assets.instance.skin;
	
	public static final int     MAIN_ASN = 1661;
	
	
}
