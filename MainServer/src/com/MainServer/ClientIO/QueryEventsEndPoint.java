/**
 * A class for client api that is connected to events
 */
package com.MainServer.ClientIO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.MainServer.DB.Camera;
import com.MainServer.DB.DetectImage;
import com.MainServer.DB.Events;
import com.MainServer.DB.ProcessRequest;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.Named;

@Api(
	name = "query",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class QueryEventsEndPoint {

	/*
	 * Method for query events by user
	 */
	@ApiMethod(name = "queryevents", httpMethod = HttpMethod.POST)
	public List<EventsForUser> QueryEvents(@Named("userName") String userName) throws Exception
	{
		
		List<EventsForUser> eventUsers = new ArrayList<EventsForUser>();
	    ProcessRequest check = new ProcessRequest();
	    // get the camera 	
	    Camera user = check.getUserCmaeraByName(userName);
	    if(user != null)
	    {
	    	// get all the events by the user
		    List<Events> eventsDB = check.getEventsByUser(user.getId());
		    if(eventsDB != null)
		    {
		    	// go over the events
			    for (Iterator<Events> iterator = eventsDB.iterator(); iterator.hasNext();)
			    {
			    	if(iterator != null)
			    	{
			    		// convert the event to seralize object and add it to the list.
						Events events = (Events) iterator.next();
						EventsForUser userTemp = new EventsForUser();
						userTemp.date = events.getDate();
						userTemp.eventtype = events.getTypeId() != null ? events.getTypeId().toString() : "";
						userTemp.message = events.getMessage();
						DetectImage imageData = check.getDetectImageByUserAndImage(events.getImageID());
						// create a link for the image
						if(imageData != null)
						{
							userTemp.URL = "http://5-dot-uplifted-plate-89814.appspot.com/mainserver?key="+imageData.getimageSaverId();
							userTemp.confidance =  (double)imageData.getdetection();
						}
						eventUsers.add(userTemp);
			    	}
				}
		    }
	    }
	    // return the list
	    return eventUsers;
	}
	// a class for return data
	public class EventsForUser
	{
		public Date date;
		public String eventtype;
		public String message;
		public Double confidance;
		public String URL;	
	}

}