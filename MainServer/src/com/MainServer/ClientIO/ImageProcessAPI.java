/**
 * Client api for using images
 */
package com.MainServer.ClientIO;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.tempuri.OpenAPI;

import com.MainServer.SendMail;
import com.MainServer.DB.Camera;
import com.MainServer.DB.DetectImage;
import com.MainServer.DB.ProcessRequest;
import com.MainServer.DB.Users;
import com.MainServer.SkiAPI.SkyAPI;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.Named;

@Api(
	name = "imagecam",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class ImageProcessAPI {

	/*
	 * A method for sending a pic for save process and sending mail if detection occure
	 */
	@ApiMethod(name = "sendimage", httpMethod = HttpMethod.POST)
	public void SendImage(@Named("ImageKey") Long ImageKey,@Named("number") Long number) throws Exception
	{
		// create a ski api isntance
	    SkyAPI sky = new SkyAPI();
	    
	    // do algorythim for detecting face
	    int detection = sky.PicSync("http://5-dot-uplifted-plate-89814.appspot.com/mainserver?key=" + ImageKey);
	    
	    // Get the camera and save detection result of the image in the db
	    ProcessRequest prc = new ProcessRequest();
	    Camera currUser =  prc.getUserCmaeraByName(number.toString());
	    DetectImage res = prc.SaveImageProcToDB(currUser.getId(), detection, ImageKey);
	   
	    // if detection is above 50 we found someone
	    if (detection > 50)
	    {
	    	// Save the event that the child was found
	    	prc.SaveEventsToDB(currUser.getId(), "SOMEONE DETECTED !!!!!!",res.getId());
	    	// Get the users and send them all a mail.
	    	List<Users> temp =prc.getUsersByCamera(currUser.getId());
	    	SendMail.SendMailToUsers("SOMEONE DETECTED !!!!!!", "SOMEONE DETECTED !!!!!!", temp);
	    }
	}
	
	// methos for taking an image
	@ApiMethod(name = "takeimage", httpMethod = HttpMethod.POST)
	public TempString TakeImage(@Named("CameraName") String CameraName) throws Exception
	{
		// create an api 
		OpenAPI a = new OpenAPI();
		// send command to take a pic
		org.tempuri.OpenAPISoap openso =  a.getOpenAPISoap();
		openso.sendCommandToDeviceByCmdType("358739050298554", 1);
		
		// wait for the command to finish
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		// get the result of the command and return it to the user
		String reult = openso.getPhotoListByDeviceIDForThreeDays("358739050298554", 1, 1, "");
		JSONObject jObject;
		jObject = new JSONObject(reult);
		JSONArray arr = jObject.getJSONArray("arr");
		JSONObject item  = arr.getJSONObject(0);
		JSONArray arrn = item.getJSONArray("items");
		JSONObject item3  = arrn.getJSONObject(0);
		String urlim = item3.getString("url");
		TempString s = new TempString();
		s.url = urlim;
		return s;
	}
	// uses for return string for some reason cant return plain string
	public class TempString
	{
		public String url;
	}

}