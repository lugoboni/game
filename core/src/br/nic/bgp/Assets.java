package br.nic.bgp;

import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable, AssetErrorListener {
	
	public static final String TAG = Assets.class.getName();
	
	public static final Assets instance = new Assets();
	
	private AssetManager assetManager;
	
	public AsTextures asTextures;
	
	public Skin skin;
	
	public blackLink blackLink;
	
	public redLink redLink;
	
	private Assets(){}
	
	
	public void init(AssetManager manager)
	{
		this.assetManager = manager;
		
		assetManager.setErrorListener(this);
		
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		
		assetManager.finishLoading();
		
		
		
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
		
		skin = new Skin(Gdx.files.internal(Constants.SKIN_FOLDER));
		
		asTextures = new AsTextures(atlas);
		
		blackLink = new blackLink(atlas);
		
		redLink = new redLink(atlas);
		
	}
	
	@Override
	public void dispose()
	{
		assetManager.dispose();
	}
	
	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error(TAG, "Couldn't load asset '" +
			asset.fileName + "'", (Exception)throwable);
	}
	
	
	public class AsTextures {
		public final AtlasRegion as22548;
		public final AtlasRegion as53208;
		public final AtlasRegion as262742;
		public final AtlasRegion as10417;
		public final AtlasRegion as10715;
		public final AtlasRegion as1916;
		public final AtlasRegion as1661;
		
		public AsTextures(TextureAtlas atlas)
		{
			as22548  = atlas.findRegion("22548");
			as53208  = atlas.findRegion("53208");
			as262742 = atlas.findRegion("262742");
			as10715  = atlas.findRegion("10715");
			as10417  = atlas.findRegion("10417");
			as1916   = atlas.findRegion("1916");
			as1661   = atlas.findRegion("1661");
			
		}
		
		public AtlasRegion getRegion(int asn)
		{
			Gdx.app.debug(TAG, ""+asn);
			switch (asn){
				case 22548:
					Gdx.app.log(TAG, "entrou 22548");
					return this.as22548;
				case 53208:
					return this.as53208;
				case 262742:
					return this.as262742;
				case 10715:
					return this.as10715;
				case 10417:
					return this.as10417;
				case 1916:
					return this.as1916;
				case 1661:
					return this.as1661;
				default:
					Gdx.app.log(TAG, "nao encontrou texture region");
					return null;
			}
		}
	}

	public class blackLink {
		private final AtlasRegion _22548_53208;
		private final AtlasRegion _22548_10417;
		private final AtlasRegion _22548_1916;
		private final AtlasRegion _22548_10715;
		private final AtlasRegion _1916_53208;
		private final AtlasRegion _10715_53208;
		private final AtlasRegion _262742_10417;
		private final AtlasRegion _262742_10715;
		private final AtlasRegion _22548_1661;
		private final AtlasRegion _10417_1661;
		private final AtlasRegion _53208_1661;
		
		public blackLink(TextureAtlas atlas)
		{
			
			_22548_53208  = atlas.findRegion("22548-53208");
			_22548_10417  = atlas.findRegion("10417-22548");
			_22548_1916   = atlas.findRegion("1916-22548");
			_22548_10715  = atlas.findRegion("10715-22548");
			_1916_53208   = atlas.findRegion("1916-53208");
			_10715_53208  = atlas.findRegion("10715-53208");
			_262742_10417 = atlas.findRegion("262742-10417");
			_262742_10715 = atlas.findRegion("262742-10715");
			_22548_1661   = atlas.findRegion("22548-1661");
			_10417_1661   = atlas.findRegion("10417-1661");
			_53208_1661   = atlas.findRegion("53208-1661");
		}
		
		public 	AtlasRegion getRegion(OpLink link)
		{
			
			switch (link){
				case _22548_53208:
					return this._22548_53208;
				case _22548_10417:
					return this._22548_10417;
				case _22548_1916:
					return this._22548_1916;
				case _22548_10715:
					return this._22548_10715;
				case _1916_53208:
					return this._1916_53208;
				case _10715_53208:
					return this._10715_53208;
				case _262742_10417:
					return this._262742_10417;
				case _262742_10715:
					return this._262742_10715;
				case _22548_1661:
					return this._22548_1661;
				case _10417_1661:
					return this._10417_1661;
				case _53208_1661:
					return this._53208_1661;
				
				default:
					Gdx.app.log(TAG, "nao encontrou texture region " + link.name());
					return null;				
				
			}
		}
	}
	
	public class redLink {
		private final AtlasRegion _22548_53208;
		private final AtlasRegion _22548_10417;
		private final AtlasRegion _22548_1916;
		private final AtlasRegion _22548_10715;
		private final AtlasRegion _1916_53208;
		private final AtlasRegion _10715_53208;
		private final AtlasRegion _262742_10417;
		private final AtlasRegion _262742_10715;
		private final AtlasRegion _22548_1661;
		private final AtlasRegion _10417_1661;
		private final AtlasRegion _53208_1661;
		
		public redLink(TextureAtlas atlas)
		{
			_22548_53208  = atlas.findRegion("r22548-53208");
			_22548_10417  = atlas.findRegion("r10417-22548");
			_22548_1916   = atlas.findRegion("r1916-22548");
			_22548_10715  = atlas.findRegion("r10715-22548");
			_1916_53208   = atlas.findRegion("r1916-53208");
			_10715_53208  = atlas.findRegion("r10715-53208");
			_262742_10417 = atlas.findRegion("r262742-10417");
			_262742_10715 = atlas.findRegion("r262742-10715");
			_22548_1661   = atlas.findRegion("r22548-1661");
			_10417_1661   = atlas.findRegion("r10417-1661");
			_53208_1661   = atlas.findRegion("r53208-1661");
		}
		
		public 	AtlasRegion getRegion(OpLink link)
		{
			switch (link){
				case _22548_53208:
					return this._22548_53208;
				case _22548_10417:
					return this._22548_10417;
				case _22548_1916:
					return this._22548_1916;
				case _22548_10715:
					return this._22548_10715;
				case _1916_53208:
					return this._1916_53208;
				case _10715_53208:
					return this._10715_53208;
				case _262742_10417:
					return this._262742_10417;
				case _262742_10715:
					return this._262742_10715;
				case _22548_1661:
					return this._22548_1661;
				case _10417_1661:
					return this._10417_1661;
				case _53208_1661:
					return this._53208_1661;
				default:
					Gdx.app.log(TAG, "nao encontrou texture region " + link.name());
					return null;
		}
			
		}
	}
	

	public enum OpLink{
		_22548_53208,
		_22548_10417,
		_22548_1916,
		_22548_10715,
		_1916_53208,
		_10715_53208,
		_262742_10417,
		_262742_10715,
		_22548_1661,
		_10417_1661,
		_53208_1661;
	}

}
