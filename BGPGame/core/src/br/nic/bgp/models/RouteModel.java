package br.nic.bgp.models;

import java.util.ArrayList;

import br.nic.bgp.utils.WorldMethods;



public class RouteModel implements Cloneable{
	
	private double         _id;
	private BlocIP4Model   _DESTINO;
	private AsModel        _NEXTHOP;
	private ArrayList<AsModel> _ASPATH;
	private BlocIP4Model   _ORIGEM;
	private int       _WEIGHT = 100;
	private int       _LOCAL_PREFERENCE = 100;
	private int       _ROUTER_ID = 0;
	private boolean   _ativa;

	
	public RouteModel(){
		this._id = WorldMethods.getRouteId();
		this._ativa = true;
		this._ASPATH = new ArrayList<AsModel>();
	}
	public RouteModel(BlocIP4Model dest){
		this._DESTINO = dest;
		this._ativa = true;
		this._ASPATH = new ArrayList<AsModel>();
	}
	
	
	public void insertASPATH(AsModel as)
	{
		this._ASPATH.add(as);
		
	}
	

	
	
	public BlocIP4Model get_DESTINO() {
		return _DESTINO;
	}
	public void set_DESTINO(BlocIP4Model _DESTINO) {
		this._DESTINO = _DESTINO;
	}
	public AsModel get_NEXTHOP() {
		return _NEXTHOP;
	}
	public void set_NEXTHOP(AsModel _NEXTHOP) {
		this._NEXTHOP = _NEXTHOP;
	}
	public ArrayList<AsModel> get_ASPATH() {
		return _ASPATH;
	}
	public void set_ASPATH(ArrayList<AsModel> _ASPATH) {
		this._ASPATH = _ASPATH;
	}
	public BlocIP4Model get_ORIGEM() {
		return _ORIGEM;
	}
	public void set_ORIGEM(BlocIP4Model _ORIGEM) {
		this._ORIGEM = _ORIGEM;
	}
	public int get_WEIGHT() {
		return _WEIGHT;
	}
	public void set_WEIGHT(int _WEIGHT) {
		this._WEIGHT = _WEIGHT;
	}
	public int get_LOCAL_PREFERENCE() {
		return _LOCAL_PREFERENCE;
	}
	public void set_LOCAL_PREFERENCE(int _LOCAL_PREFERENCE) {
		this._LOCAL_PREFERENCE = _LOCAL_PREFERENCE;
	}
	public int get_ROUTER_ID() {
		return _ROUTER_ID;
	}
	public void set_ROUTER_ID(int _ROUTER_ID) {
		this._ROUTER_ID = _ROUTER_ID;
	}
	public boolean is_ativa() {
		return _ativa;
	}
	public void set_ativa(boolean _ativa) {
		this._ativa = _ativa;
	}
	@Override
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	public boolean isAtiva() {
		return _ativa;
	}
	public void setAtiva(boolean ativa) {
		this._ativa = ativa;
	}
	
	public double get_id() {
		return _id;
	}

	public void decreWeight()
	{
		this._WEIGHT--;
	}
	
	
}
