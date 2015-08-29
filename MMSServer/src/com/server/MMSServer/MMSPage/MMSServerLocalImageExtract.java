/**
 * A servlet to get an mms message and save it to DB .
 * Also when image is recognize send it to processing
 */

package com.server.MMSServer.MMSPage;

import java.io.IOException;
import java.util.ArrayList;
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
			
			
			// save the data and the ip for recognize location
			ProcessRequest prcUnit = new ProcessRequest();
			prcUnit.SaveImageToDB(telephoneNumber, nData);
			prcUnit.SaveLocationToDB(req.getRemoteAddr());
			
		}
	}
}
