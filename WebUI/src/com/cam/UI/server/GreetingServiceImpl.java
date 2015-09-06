package com.cam.UI.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cam.UI.client.GreetingService;
import com.cam.UI.shared.EventsForUserLocal;
import com.cam.UI.shared.FieldVerifier;
import com.cam.UI.shared.UsersForCameraLocal;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	private static final Logger logger = Logger.getLogger("GreetingServiceImpl");
	private String cameraName;
	
	/*
	 * LoginCam - used to login to system with camera name and password
	 * @see com.cam.UI.client.GreetingService#LoginCam(java.lang.String, java.lang.String)
	 */
	public String LoginCam(String username, String password) throws IllegalArgumentException {
		String a;
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(username)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		// Escape data from the client to avoid cross-site script vulnerabilities.
		username = escapeHtml(username);
		password = escapeHtml(password);
		
		Logincam.Builder builder = new Logincam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
		Logincam quote = new Logincam(builder);
		try {
			
			// request from server to login with camera user
			quote.login(username, password).execute();
			a = "SUCCESS";
			this.cameraName = username;
			
		} catch (IOException e) {
			a = "ERROR - User Name or Password is incorrect";
		}
		return (a); 
	}
	
	/*
	 * CreateUser - this function is used to create a new user in the system
	 * @see com.cam.UI.client.GreetingService#CreateUser(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String CreateUser(String name, String phone, String mail) throws IllegalArgumentException {
		String a;

		// Escape data from the client to avoid cross-site script vulnerabilities.
		name = escapeHtml(name);
		phone = escapeHtml(phone);
		mail = escapeHtml(mail);
		
		Logincam.Builder builder = new Logincam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
		Logincam quote = new Logincam(builder);
		try {
			// request from server to create a new user
			quote.createuser(this.cameraName, name, mail, phone).execute();
			a = "User Added successfully!";
			
		} catch (IOException e) {
			a = "ERROR - User Name or Password is incorrect";
		}
		return (a); 
	}
	
	/*
	 * GetEventsForUser - used for getting all camera events 
	 * @see com.cam.UI.client.GreetingService#GetEventsForUser()
	 */
	public List<EventsForUserLocal> GetEventsForUser()
	{
		Query.Builder builder = new Query.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
	    Query service = builder.build();
	    List<EventsForUserLocal> localArray = new ArrayList<EventsForUserLocal>();
	    try {
	    	// request from server all events for camera
			EventsForUserCollection events = service.queryevents(this.cameraName).execute();
			List<EventsForUser> eventsforusers = events.getItems();
			
			if (eventsforusers != null) 
			{
				for (EventsForUser event:eventsforusers)
				{
					EventsForUserLocal temp = new EventsForUserLocal();
					temp.date = event.getDate().toString();
					temp.eventtype = event.getEventtype();
					temp.message = event.getMessage();
					temp.uRL = event.getURL();
					temp.confidance = event.getConfidance();
					localArray.add(temp);
				}
			}
			return localArray;

		} catch (IOException e) {
			e.printStackTrace();
			return localArray;
		}
	}
	
	/* 
	 * GetUsersForCamera - used to getting all users registered for camera
	 * @see com.cam.UI.client.GreetingService#GetUsersForCamera()
	 */
	public List<UsersForCameraLocal> GetUsersForCamera()
	{
		Users.Builder builder = new Users.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
	    Users service = builder.build();
	    List<UsersForCameraLocal> localArray = new ArrayList<UsersForCameraLocal>();
	    try {
	    	// request from server to get all users for camera
			UserCollection users = service.getusers(this.cameraName).execute();

			List<User> usersforcamera = users.getItems();
			for (User user:usersforcamera)
			{
				UsersForCameraLocal temp = new UsersForCameraLocal();
				temp.name = user.getName();
				temp.phone = user.getNumber();
				temp.mail = user.getMail();
				localArray.add(temp);
			}
			return localArray;

		} catch (IOException e) {
			e.printStackTrace();
			return localArray;
		}
	}
	
	/*
	 * DeleteUser - used to delete existsing user from camera users
	 * @see com.cam.UI.client.GreetingService#DeleteUser(java.lang.String)
	 */
	public String DeleteUser(String user)
	{
		String a;

		Users.Builder builder = new Users.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
	    Users service = builder.build();
	    
	    user = escapeHtml(user);
	   
	    try {
	    	
	    	// delete an existsing user for camera
			service.deleteuser(this.cameraName, user).execute();
			a = "User Deleted successfully!";			
		} catch (IOException e) {
			a = "ERROR - problem deleting user";
		}
	    
	    return (a);
	}
	
	/*
	 * TakeImage - used for getting a real-time picture from the camera
	 * @see com.cam.UI.client.GreetingService#TakeImage()
	 */
	public String TakeImage()
	{
		String a;

		Imagecam.Builder builder = new Imagecam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
	    Imagecam service = builder.build();

	    try {
	    	// requesting from server to take a picture from camera and send url
			TempString img = service.takeimage(this.cameraName).execute();
			System.out.println(img.getUrl());
			return (img.getUrl());			
		} catch (IOException e) {
			a = "ERROR - problem at taking picture";
		}
	    
	    return (a);
	}
	
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
