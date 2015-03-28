package com.server.MMSServer;



import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MMSServerLocalImageExtract extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		//resp.sendRedirect("MMSPage.php");
		if(req.getAttribute("n") != null)
		{
			String telephoneNumber = req.getAttribute("n").toString();
		}
		
		ServletInputStream inputData = req.getInputStream();
		int nRead = req.getContentLength();
		
		if(nRead > 0)
		{
			byte[] nData = new byte[nRead];
			inputData.read(nData);
			
			String str = new String(nData);
			resp.getWriter().write(str);
		}
		/*resp.getWriter().write(0);
		resp.getWriter().write(0x8D);
		resp.getWriter().write(0x90);
		resp.getWriter().write(0x92);
		resp.getWriter().write(128);*/
	}
}
