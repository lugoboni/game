package br.nic.bgp.utils;

import java.util.ArrayList;

import br.nic.bgp.models.AsModel;

public class WorldMethods {

	private static double route_id = -1;
	
	public static void INIT_SCENARIO()
	{
		if(!Constants.INITIATED)
		{
			Constants.FIRST_BLOOD.initRoutes();
			Constants.FIRST_BLOOD.sendRoute(Constants.FIRST_BLOOD, new ArrayList<AsModel>());
			Constants.INITIATED = true;
		}
	}
	
	public static double getRouteId()
	{
		route_id++;
		return route_id;
	}
}
