package com.server.MMSServer.MMSPage;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletInputStream;
import javax.servlet.http.*;

import com.google.api.services.drive.Drive;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.server.MMSServer.ProcessingUnit.ImageSaver;
import com.server.MMSServer.ProcessingUnit.PMF;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

@SuppressWarnings("serial")
public class MMSServerLocalImageExtract extends HttpServlet {
	private static String CLIENT_ID = "173599204484-57hu1l87du8mpltprmuinkrl244edon2.apps.googleusercontent.com";
	  private static String CLIENT_SECRET = "xlJlPb_7ESo0lOHT4vMhuhnv";

	  private static String REDIRECT_URI = "http://localhost:8888";
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		//resp.sendRedirect("MMSPage.php");
		if(req.getAttribute("n") != null)
		{
			String telephoneNumber = req.getAttribute("n").toString();
		}
		HttpTransport httpTransport = new NetHttpTransport();
		ServletInputStream inputData = req.getInputStream();
		int nRead = req.getContentLength();
		if(nRead > 0)
		{
			byte[] nData = new byte[nRead];
			
			
			inputData.read(nData);
			
			
			ImageSaver img = new ImageSaver();
			
			img.setImageType("Type");
			img.setImage(nData);
			PersistenceManager pm =  PMF.get().getPersistenceManager();
			 try {
	                // Store the image in App Engine's datastore
	                pm.makePersistent(img);
	            } finally {
	                pm.close();
	            }
			String str = new String(nData);
			resp.getWriter().write(str);
		}
		ImageSaver img = new ImageSaver();
		byte[] nData = new byte[1];
		nData[0] = 1;
		img.setImageType("Type");
		img.setImage(nData);
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try {
                // Store the image in App Engine's datastore
                pm.makePersistent(img);
            } finally {
                pm.close();
            }
		//String str = new String(nData);
		/*JsonFactory JSON_FACTORY = new JacksonFactory();
		 
	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	        httpTransport, JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE))
	        .setAccessType("online")
	        .setApprovalPrompt("auto").build();
	    
	    String url = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build();
	    System.out.println("Please open the following URL in your browser then type the authorization code:");
	    System.out.println("  " + url);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String code = br.readLine();
	    
	    com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
	    GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);*/
	    
	    
		
		/*resp.getWriter().write(0);
		resp.getWriter().write(0x8D);
		resp.getWriter().write(0x90);
		resp.getWriter().write(0x92);
		resp.getWriter().write(128);*/
	}
}
