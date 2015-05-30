package com.cam.UI.client;

import com.cam.UI.server.GreetingServiceImpl;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class ImpSingleton {
	private static ImpSingleton instance = null;
	private  GreetingServiceAsync Implinstance = null;
	protected ImpSingleton (){}
	public static ImpSingleton getInstance(){
		if (instance == null)
		{
			instance = new ImpSingleton();
		}
		return instance;
		
	}
	
	 void setGreetingServiceAsync(GreetingServiceAsync instance)
	{
		Implinstance = instance;
	}

	 GreetingServiceAsync getGreetingServiceAsync	()
	{
		return Implinstance;
	}
	
}