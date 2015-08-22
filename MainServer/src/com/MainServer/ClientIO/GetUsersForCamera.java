package com.MainServer.ClientIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.MainServer.DB.Camera;
import com.MainServer.DB.DetectImage;
import com.MainServer.DB.Events;
import com.MainServer.DB.ImageSaver;
import com.MainServer.DB.ProcessRequest;
import com.MainServer.DB.Users;
import com.MainServer.SkiAPI.SkyAPI;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.OutputSettings;

@Api(
	name = "users",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class GetUsersForCamera {

	@ApiMethod(name = "getusers", httpMethod = HttpMethod.POST)
	public List<User> GetUsers(@Named("userName") String userName) throws Exception
	{
		List<User> eventUsers = new ArrayList();
	    ProcessRequest check = new ProcessRequest();
	    Camera user = check.getUserCmaeraByName(userName);
	    if(user != null)
	    {
		    List<Users> usersDB = check.getUsersByCamera(user.getId());
		    if(usersDB != null)
		    {
			    for (Iterator iterator = usersDB.iterator(); iterator.hasNext();)
			    {
			    	if(iterator != null)
			    	{
			    		Users usr = (Users) iterator.next();
			    		User userTemp = new User();
						userTemp.Name = usr.getName();
						userTemp.Mail = usr.getMail();
						userTemp.Number = usr.getNumber();
						eventUsers.add(userTemp);
			    	}
				}
		    }
	    }
	    return eventUsers;
	}
	
	@ApiMethod(name = "deleteuser", httpMethod = HttpMethod.POST)
	public void DeleteUser(@Named("CameraName") String camName,@Named("UserName") String UserName) throws Exception
	{
	    ProcessRequest check = new ProcessRequest();
	    Camera user = check.getUserCmaeraByName(camName);
	    if(user != null)
	    {
		    List<Users> usersDB = check.getUsersByCamera(user.getId());
		    if(usersDB != null)
		    {
			    for (Iterator iterator = usersDB.iterator(); iterator.hasNext();)
			    {
			    	if(iterator != null)
			    	{
			    		Users usr = (Users) iterator.next();
			    		if(usr.getName().compareToIgnoreCase(UserName) == 0)
			    		{
			    			check.DeleteUserByCamera(usr);
			    		}
			    	}
				}
		    }
	    }
	}
	public class User
	{
		public String Name;
		public String Mail;
		public String Number;
	}

}