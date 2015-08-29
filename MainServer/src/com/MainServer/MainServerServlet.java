/**
 * Main server servlet use to display an image in the DB as HTML . 
 * The reading of the image is by Key .
 */
package com.MainServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;

import com.MainServer.DB.ImageSaver;
import com.MainServer.DB.ProcessRequest;

@SuppressWarnings("serial")
public class MainServerServlet extends HttpServlet {
	
	/*
	 * doGet for servlet getting the key of the pic and reading it for html display
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("image/jpeg");
		
		// check supply key
		if(req.getParameter("key") != null)
		{
			ProcessRequest check = new ProcessRequest();
	    	ImageSaver image = check.getImageSaverByKey(req.getParameter("key").toString());
	    	// Check that image was found
	    	if(image != null)
	    	{
		    	List<Byte> pic = new ArrayList<Byte>();
		    	boolean writedata = false;
		    	// Go through the data of the image and bring only the image
		    	// Could have extra data that is not needed
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
				// write the picture to the response
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
