package br.nic.bgp.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

import br.nic.bgp.utils.Constants;

import com.badlogic.gdx.Gdx;



public class AsModel{

	public static final String TAG = AsModel.class.getName();
	public  final int                                               _ASN;
	private BlocIP4Model                                            _addr_bloc;
	private ArrayList<LinkModel>                                    _links;
	private HashMap<BlocIP4Model, RouteModel>                       _adj_rib_in;
	private HashMap<BlocIP4Model, RouteModel>                       _rib;
	private HashMap<Integer, Integer>                               _polices;
	public HashMap<Integer, Integer> get_polices() {
		return _polices;
	}


	public void set_polices(HashMap<Integer, Integer> _polices) {
		this._polices = _polices;
	}


	private boolean                                                 _first;
	private boolean                                                 _updated;
	private LinkedBlockingQueue< HashMap<BlocIP4Model, RouteModel>> _rib_log;
	
	
	public AsModel(int asn)
	{
		this._ASN = asn;
		this._links =  new ArrayList<LinkModel>();
		this._adj_rib_in = new HashMap<BlocIP4Model, RouteModel>();
		this._rib = new HashMap<BlocIP4Model, RouteModel>();
		this._polices = new HashMap<Integer, Integer>();
		this._first = true;
		this._updated = false;
		this._rib_log = new LinkedBlockingQueue< HashMap<BlocIP4Model, RouteModel>>();
		
	}
	
	
	public boolean publishAddr(String net, AsModel neighboor)
	{
		String[] temp = net.split("/");
		
		for(LinkModel l : this._links)
		{
			if(l.getNeighboor(this) == neighboor)
			{
				
				if(_addr_bloc.isFromBloc(temp[0]))
				{
					l.setAddr(this, new BlocIP4Model(net));
				
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void sendRoute(AsModel as, ArrayList<AsModel> in_list)
	{
		
			HashMap<BlocIP4Model, RouteModel> copy = (HashMap<BlocIP4Model, RouteModel>)this._rib.clone();
			

			for(LinkModel l : this._links)
			{
				if(l.getNeighboor(this)._ASN!= as._ASN)
				{
					Gdx.app.debug(TAG, "Veio de " + this._ASN + " Para " + l.getNeighboor(this)._ASN);
					Constants.PROPAGATION_QUEUE.add(l);
					l.getNeighboor(this).receiveRoute(copy, in_list);
				}
			}
		
	}
	
	public void receiveRoute(HashMap<BlocIP4Model, RouteModel> received, ArrayList<AsModel> in_list)
	{
		if(in_list.contains(this))
		{
			
		}
		else
		{		
			in_list.add(this);
			for(BlocIP4Model key : received.keySet())
			{
				this._adj_rib_in.put(key, received.get(key));
			}
		
			this.constructRib();
			this.sendRoute(this, in_list);
		}

	}
	
	@SuppressWarnings("unchecked")
	public void constructRib()
	{
		if(!this._rib.isEmpty())
		{
		
			for(BlocIP4Model key : this._adj_rib_in.keySet())
			{
				BlocIP4Model key2 = this.searchRouteRib(key);
				RouteModel received = this._adj_rib_in.get(key);
				if(key2 != null)
				{
					if(!received.get_ASPATH().contains(this))
					{
						if(received.get_DESTINO().get_Full_Addr() == this._rib.get(key2).get_DESTINO().get_Full_Addr())
						{
							if(received.get_ROUTER_ID() == this._rib.get(key2).get_ROUTER_ID())
							{								
								if(received.get_LOCAL_PREFERENCE() > this._rib.get(key2).get_LOCAL_PREFERENCE())
								{
									this._rib.remove(key2);
									received.get_ASPATH().add(this);
									received.decreWeight();
									this._rib.put(key,received);
									this._rib_log.add((HashMap<BlocIP4Model, RouteModel>)this._rib.clone());
								}
								else
								{
									if(received.get_LOCAL_PREFERENCE() == this._rib.get(key2).get_LOCAL_PREFERENCE())
									{
										if(received.get_ASPATH().get(0) == this && this._rib.get(key2).get_ASPATH().get(0) != this)
										{
											this._rib.remove(key2);
											received.get_ASPATH().add(this);
											received.decreWeight();
											this._rib.put(key,received);
											this._rib_log.add((HashMap<BlocIP4Model, RouteModel>)this._rib.clone());
										}
										else
										{
											if(received.get_WEIGHT() > this._rib.get(key2).get_WEIGHT())
											{
												this._rib.remove(key2);
												received.get_ASPATH().add(this);
												received.decreWeight();
												this._rib.put(key,received);
												this._rib_log.add((HashMap<BlocIP4Model, RouteModel>)this._rib.clone());
											}
											else
											{
												if(received.get_WEIGHT() == this._rib.get(key2).get_WEIGHT())
												{
													if(received.get_ROUTER_ID() > this._rib.get(key2).get_ROUTER_ID())
													{
														this._rib.remove(key2);
														received.get_ASPATH().add(this);
														received.decreWeight();
														this._rib.put(key,received);
														this._rib_log.add((HashMap<BlocIP4Model, RouteModel>)this._rib.clone());
													}
												}
											}
										}
									}
								}										
							}
						}
					}
				}
				else
				{
					received.get_ASPATH().add(this);
					received.decreWeight();
					this._rib.put(key,received);
					this._rib_log.add((HashMap<BlocIP4Model, RouteModel>)this._rib.clone());
				}
			}			
		}
		else
		{
			this._rib.putAll(this._adj_rib_in);
		}
			
	}
		
	public void initRoutes()
	{
		if(this._first)
		{
			this._first = false;
			
			for(LinkModel l : this._links)
			{
				RouteModel r = new RouteModel();
				r.set_ORIGEM(l.get_my_addr(this));
				r.set_DESTINO(l.getNeighAddr(this));
				r.get_ASPATH().add(this);
				this._rib.put(r.get_DESTINO(), r);
			}
			
			for(LinkModel l : this._links)
			{
				l.getNeighboor(this).initRoutes();
			}
			
		}

	}
	
	public BlocIP4Model searchRouteRib(BlocIP4Model r)
	{
		for(BlocIP4Model key : this._rib.keySet())
		{
			if(r.get_Full_Addr() == key.get_Full_Addr())
			{
				return key;
			}
		}
		return null;
	}
	
	public void insertNewLink(LinkModel l)
	{
		this._links.add(l);
	}
	

	public void set_addr_bloc(BlocIP4Model bloc)
	{
		this._addr_bloc = bloc;
	}


	public boolean is_updated() {
		return _updated;
	}


	public void set_updated(boolean _updated) {
		this._updated = _updated;
	}


	public HashMap<BlocIP4Model, RouteModel> get_rib() {
		return _rib;
	}


	public LinkedBlockingQueue<HashMap<BlocIP4Model, RouteModel>> get_rib_log() {
		return _rib_log;
	}


	public void cleanRibLog()
	{
		this._rib_log.clear();
	}

	
	public BlocIP4Model get_addr_bloc() {
		return _addr_bloc;
	}
	
	public ArrayList<LinkModel> get_links() {
		return _links;
	}
}

