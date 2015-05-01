package com.server.MMSServer.MMSPage;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

import com.server.MMSServer.ProcessingUnit.ProcessRequest;

@SuppressWarnings("serial")
public class MMSServerLocalImageExtract extends HttpServlet 
{
	private static final Logger logger = Logger.getLogger("MMSServerLocalImageExtract");
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		//resp.sendRedirect("MMSPage.php");
		logger.fine("param read");
		if(req.getAttribute("n") != null)
		{
			String telephoneNumber = req.getAttribute("n").toString();
		
			logger.fine("post read");
			ServletInputStream inputData = req.getInputStream();
			int nRead = req.getContentLength();
			if(nRead > 0)
			{
				byte[] nData = new byte[nRead];
				
				
				inputData.read(nData);
				logger.fine( "save");
				ProcessRequest prcUnit = new ProcessRequest();
				/*boolean isSuccess = prcUnit.SaveImageToDB(telephoneNumber, nData);
				if(isSuccess)
				{
					logger.fine("return");
					resp.getWriter().write(0);
					resp.getWriter().write(0x8D);
					resp.getWriter().write(0x90);
					resp.getWriter().write(0x92);
					resp.getWriter().write(128);
				}*/
			}
		}
		// redirect or send an error
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.fine(req.getAttributeNames().toString());
		Enumeration attrs =  req.getAttributeNames();
		while(attrs.hasMoreElements()) {
			logger.fine(attrs.nextElement().toString());
		}
		logger.fine("param read");
		/*if(req.getAttribute("n") != null)
		{*/
			String telephoneNumber = "";//req.getAttribute("n").toString();
		
			logger.fine("post read");
						
			
			ServletInputStream inputData = req.getInputStream();
			int nRead = req.getContentLength();
			if(nRead > 0)
			{
				byte[] nData = new byte[nRead];
				inputData.read(nData);
				ArrayList<Integer> array = new ArrayList<Integer>();
				for (int i = 0; i < nData.length; i++) {
					/*if(nData[i] == 0xFF)
						telephoneNumber = "SUCCESS";*/
					array.add(new Integer(nData[i]));
				}
				String temp = new String(nData,"unicode");
				
				logger.fine( "save");
				ProcessRequest prcUnit = new ProcessRequest();
				boolean isSuccess = prcUnit.SaveImageToDB(telephoneNumber, array);
				if(isSuccess)
				{
					logger.fine("return");
					resp.getWriter().write(0);
					resp.getWriter().write(0x8D);
					resp.getWriter().write(0x90);
					resp.getWriter().write(0x92);
					resp.getWriter().write(128);
				}
			}
		/*}*/
	}
}
