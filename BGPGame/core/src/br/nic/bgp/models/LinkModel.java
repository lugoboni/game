package br.nic.bgp.models;

import com.badlogic.gdx.Gdx;




public class LinkModel {
	
	public static final String TAG = LinkModel.class.getName();
	private AsModel                 _nodo_a;
	private AsModel                 _nodo_b;
	private BlocIP4Model            _addr_a;
	private BlocIP4Model            _addr_b;
	private boolean                 _moving;
	
	
	
	public LinkModel(AsModel a, AsModel b)
	{
		this._nodo_a = a;
		this._nodo_b = b;
		this._moving = false;
		Gdx.app.log(TAG, "Entrou LinkModel constructor ");

		
	}

	public boolean isThere(AsModel as)
	{
		if(this._nodo_a._ASN == as._ASN || this._nodo_b._ASN == as._ASN) return true;
		return false;
	}
	
	public void setAddr(AsModel as, BlocIP4Model ip)
	{
		if(this._nodo_a == as) this._addr_a = ip;
		if(this._nodo_b == as) this._addr_b = ip;
	}
	
	public BlocIP4Model getNeighAddr(AsModel as)
	{
		Gdx.app.log(TAG, "getNeigh " + (this._nodo_a == as));
		if(this._nodo_a == as) return this._addr_b;
		if(this._nodo_b == as) return this._addr_a;
		
		return null;
	}
	
	public AsModel getNeighboor(AsModel as)
	{
		
		if(this._nodo_a == as) return this._nodo_b;
		if(this._nodo_b == as) return this._nodo_a;
		
		return null;
	}
	
	public AsModel get_nodo_a() {
		return _nodo_a;
	}

	public void set_nodo_a(AsModel _nodo_a) {
		this._nodo_a = _nodo_a;
		this._nodo_a.insertNewLink(this);
	}

	public AsModel get_nodo_b() {
		return _nodo_b;
		
	}

	public void set_nodo_b(AsModel _nodo_b) {
		this._nodo_b = _nodo_b;
		this._nodo_b.insertNewLink(this);
	}

	public BlocIP4Model get_addr_a() {
		return _addr_a;
	}

	public void set_addr_a(BlocIP4Model _addr_a) {
		this._addr_a = _addr_a;
	}

	public BlocIP4Model get_addr_b() {
		return _addr_b;
	}

	public void set_addr_b(BlocIP4Model _addr_b) {
		this._addr_b = _addr_b;
	}
	
	public BlocIP4Model get_my_addr(AsModel me)
	{
		if(me == this._nodo_a) return this._addr_a;
		else
			if(me == this._nodo_b) return this._addr_b;
			else return null;
		
	}

	public boolean is_moving() {
		return _moving;
	}

	public void set_moving(boolean _moving) {
				
		this._moving = _moving;
		
		
	}
	
	
}
