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
	name = "query",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class QueryEventsEndPoint {

	@ApiMethod(name = "queryevents", httpMethod = HttpMethod.POST)
	public List<EventsForUser> SendImage(@Named("userName") String userName) throws Exception
	{
		List<EventsForUser> eventUsers = new ArrayList();
	    ProcessRequest check = new ProcessRequest();
	    Camera user = check.getUserCmaeraByName(userName);
	    if(user != null)
	    {
		    List<Events> eventsDB = check.getEventsByUser(user.getId());
		    if(eventsDB != null)
		    {
			    for (Iterator iterator = eventsDB.iterator(); iterator.hasNext();)
			    {
			    	if(iterator != null)
			    	{
						Events events = (Events) iterator.next();
						EventsForUser userTemp = new EventsForUser();
						userTemp.date = events.getDate();
						userTemp.eventtype = events.getTypeId() != null ? events.getTypeId().toString() : "";
						userTemp.message = events.getMessage();
						DetectImage imageData = check.getDetectImageByUserAndImage(events.getImageID());
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
	    return eventUsers;
	}
	public class EventsForUser
	{
		public Date date;
		public String eventtype;
		public String message;
		public Double confidance;
		public String URL;	
	}

}