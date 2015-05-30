package com.MainServer.ClientIO;

import java.util.logging.Logger;

import com.MainServer.DB.Camera;
import com.MainServer.DB.ProcessRequest;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.Named;

@Api(
	name = "logincam",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class LoginEndPoint {
	@ApiMethod(name = "login", httpMethod = HttpMethod.POST)
	public void login(@Named("user") String user,@Named("password") String password) throws Exception
	{
	    ProcessRequest check = new ProcessRequest();
	    Camera currUser = check.getUserCmaeraByName(user);
	    if(currUser.getPassword().compareTo(password) != 0 ||
	       password.compareTo(currUser.getPassword()) != 0)
	    {
	    	throw new Exception("Invalid Login");
	    }
	    
	}

}
