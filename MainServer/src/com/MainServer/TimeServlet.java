package com.MainServer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.*;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tempuri.OpenAPI;
import org.tempuri.OpenAPISoap;

import com.MainServer.DB.ImageSaver;
import com.MainServer.DB.ProcessRequest;

@SuppressWarnings("serial")
public class TimeServlet extends HttpServlet {
	//private static final Logger logger = Logger.getLogger("MainServerServlet");
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("image/jpeg");
		
	
		/*OpenAPI a = new OpenAPI();
		
		OpenAPISoap openso =  a.getOpenAPISoap();
		openso.sendCommandToDeviceByCmdType("358739050298554", 1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		String reult = openso.getPhotoListByDeviceIDForThreeDays("358739050298554", 1, 1, "");
		
		JSONObject jObject;
		try 
		{
			jObject = new JSONObject(reult);
			JSONArray arr = jObject.getJSONArray("arr");
			JSONObject item  = arr.getJSONObject(0);
			JSONArray arrn = item.getJSONArray("items");
			JSONObject item3  = arrn.getJSONObject(0);
			String urlim = item3.getString("url");
			URL url = new URL(urlim);
			InputStream in = new BufferedInputStream(url.openStream());
			int n = 0;
			List<Integer> arrbyte = new ArrayList<>();
			while (-1!=(n=in.read()))
			{
				arrbyte.add(n);
			}
			
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
