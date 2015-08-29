package com.MainServer.ClientIO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.tempuri.OpenAPI;
import org.tempuri.OpenAPISoap;

import com.MainServer.SendMail;
import com.MainServer.DB.Camera;
import com.MainServer.DB.DetectImage;
import com.MainServer.DB.ImageSaver;
import com.MainServer.DB.ProcessRequest;
import com.MainServer.DB.Users;
import com.MainServer.SkiAPI.SkyAPI;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.OutputSettings;

@Api(
	name = "imagecam",
	version = "v1",
	authLevel = AuthLevel.NONE,
	clientIds = {Ids.WEB_CLIENT_ID, Ids.ANDROID_CLIENT_ID, Ids.IOS_CLIENT_ID},
	audiences = {Ids.ANDROID_AUDIENCE}
)
public class ImageProcessAPI {

	@ApiMethod(name = "sendimage", httpMethod = HttpMethod.POST)
	public void SendImage(@Named("ImageKey") Long ImageKey,@Named("number") Long number) throws Exception
	{
	    SkyAPI sky = new SkyAPI();
	    
	    int detection = sky.PicSync("http://5-dot-uplifted-plate-89814.appspot.com/mainserver?key=" + ImageKey);
	    
	    ProcessRequest prc = new ProcessRequest();
	    
	    Camera currUser =  prc.getUserCmaeraByName(number.toString());
	    
	    DetectImage res = prc.SaveImageProcToDB(currUser.getId(), detection, ImageKey);
	   
	    if (detection > 50)
	    {
	    	 prc.SaveEventsToDB(currUser.getId(), "SOMEONE DETECTED !!!!!!",res.getId());
	    	List<Users> temp =prc.getUsersByCamera(currUser.getId());
	    	SendMail.SendMailToUsers("SOMEONE DETECTED !!!!!!", "SOMEONE DETECTED !!!!!!", temp);
	    }
	}
	
	
	@ApiMethod(name = "takeimage", httpMethod = HttpMethod.POST)
	public TempString TakeImage(@Named("CameraName") String CameraName) throws Exception
	{
		OpenAPI a = new OpenAPI();
		
		OpenAPISoap openso =  a.getOpenAPISoap();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
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
	
	public class TempString
	{
		public String url;
	}

}