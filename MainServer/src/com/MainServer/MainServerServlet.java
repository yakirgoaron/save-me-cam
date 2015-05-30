package com.MainServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.*;

import org.apache.commons.lang3.ArrayUtils;

import com.MainServer.ClientIO.ImageProcessAPI;
import com.MainServer.DB.ImageSaver;
import com.MainServer.DB.ProcessRequest;
import com.MainServer.SkiAPI.SkyAPI;

@SuppressWarnings("serial")
public class MainServerServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger("MainServerServlet");
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("image/jpeg");
		
		
		if(req.getParameter("key") != null)
		{
			ProcessRequest check = new ProcessRequest();
	    	ImageSaver image = check.getImageSaverByKey(req.getParameter("key").toString());
	    	if(image != null)
	    	{
		    	List<Byte> pic = new ArrayList<Byte>();
		    	boolean writedata = false;
			 	for (int i = 0; i < image.getImage().length; i++) 
				{
					if(i < image.getImage().length && image.getImage()[i] == -1 && image.getImage()[i+1] == -40)
						writedata = true;
			
					if(writedata)
						pic.add(image.getImage()[i]);
					
					if(i > 0 &&  image.getImage()[i-1] == -1 &&  image.getImage()[i] == -39)
						writedata = false;
					 
				}
			 	byte[] picArraybyte;
			 	
				Byte[] array = pic.toArray(new Byte[pic.size()]);
				picArraybyte = ArrayUtils.toPrimitive(array);
				
				for (int i = 0; i < picArraybyte.length; i++) {
					resp.getOutputStream().write(picArraybyte[i]);
				} 
				
	    	}
			 
		}
		else
		{
			
		}
		
	}
}
