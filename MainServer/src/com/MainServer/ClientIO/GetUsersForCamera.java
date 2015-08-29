/**
 * This is part of end point api this will use for login to the system.
 */
package com.MainServer.ClientIO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.MainServer.DB.Camera;
import com.MainServer.DB.ProcessRequest;
import com.MainServer.DB.Users;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.Named;

@Api(
	name = "users",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class GetUsersForCamera {

	/*
	 *  this method get users by the camera name.
	 */
	@ApiMethod(name = "getusers", httpMethod = HttpMethod.POST)
	public List<User> GetUsers(@Named("userName") String userName) throws Exception
	{

		List<User> UsersCam = new ArrayList<User>();
		// Get the camera from the DB.
	    ProcessRequest check = new ProcessRequest();
	    Camera user = check.getUserCmaeraByName(userName);
	    // check that we found it.
	    if(user != null)
	    {
	    	// Get all the users that are connected to the camera
		    List<Users> usersDB = check.getUsersByCamera(user.getId());
		    if(usersDB != null)
		    {
		    	// Iterate akk the found user and convert the data for return.
			    for (Iterator<Users> iterator = usersDB.iterator(); iterator.hasNext();)
			    {
			    	if(iterator != null)
			    	{
			    		Users usr = (Users) iterator.next();
			    		User userTemp = new User();
						userTemp.Name = usr.getName();
						userTemp.Mail = usr.getMail();
						userTemp.Number = usr.getNumber();
						UsersCam.add(userTemp);
			    	}
				}
		    }
	    }
	    // return the data for the user
	    return UsersCam;
	}
	 /*
	  * this method delete a user from a specific cam by username
	  */
	@ApiMethod(name = "deleteuser", httpMethod = HttpMethod.POST)
	public void DeleteUser(@Named("CameraName") String camName,@Named("UserName") String UserName) throws Exception
	{
	    ProcessRequest check = new ProcessRequest();
	    // check the camera exsists
	    Camera user = check.getUserCmaeraByName(camName);
	    if(user != null)
	    {
	    	//query the camera from the DB 
		    List<Users> usersDB = check.getUsersByCamera(user.getId());
		    // check we found one
		    if(usersDB != null)
		    {
		    	// iterate all the users that are in the DB
			    for (Iterator<Users> iterator = usersDB.iterator(); iterator.hasNext();)
			    {
			    	if(iterator != null)
			    	{
			    		// Delete the user that has the same name as we got.
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
	// a user class for communication with the client.
	public class User
	{
		public String Name;
		public String Mail;
		public String Number;
	}

}