/**
 * A servlet to get an mms message and save it to DB .
 * Also when image is recognize send it to processing
 */

package com.server.MMSServer.MMSPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.MMSServer.ProcessingUnit.ProcessRequest;

@SuppressWarnings("serial")
public class MMSServerLocalImageExtract extends HttpServlet 
{
	private static final Logger logger = Logger.getLogger("MMSServerLocalImageExtract");
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
	
		String telephoneNumber = "";

		ServletInputStream inputData = req.getInputStream();
		int nRead = req.getContentLength();
		if(nRead > 0)
		{
			// read all post data for save
			byte[] nData = new byte[nRead];
			inputData.read(nData);
			ArrayList<Integer> array = new ArrayList<Integer>();
			for (int i = 0; i < nData.length; i++) {
				array.add(new Integer(nData[i]));
			}
			String Country = req.getHeader("X-AppEngine-Country");
			String Region = req.getHeader("X-AppEngine-Region");
			String City = req.getHeader("X-AppEngine-City");
			String CityLatLong = req.getHeader("X-AppEngine-CityLatLong");
			String[] data = CityLatLong.split(",");
			int locx = Integer.parseInt(data[0]);
			int locy = Integer.parseInt(data[1]);
			
			
			for (Enumeration itr=req.getHeaderNames(); itr.hasMoreElements();) {
			    String headerName = (String)itr.nextElement();
			    logger.fine("Name = " + headerName);
			    logger.fine("value = " + req.getHeader(headerName));
			}
			
			// save the data and the ip for recognize location
			ProcessRequest prcUnit = new ProcessRequest();
			long image = prcUnit.SaveImageToDB(telephoneNumber, nData,locx,locy);
			if(image != 0 )
				prcUnit.SaveLocationToDB(Country,Region,City,locx,locy,image );
			
		}
	}
}
