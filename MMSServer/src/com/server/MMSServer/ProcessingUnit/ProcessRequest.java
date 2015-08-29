package com.server.MMSServer.ProcessingUnit;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;

import java.util.Date;
import java.util.List;
public class ProcessRequest 
{
	public boolean SaveImageToDB(String strTelephoneNumber,byte[] picData)
	{
		boolean isSuccess = true;
		ImageSaver img = new ImageSaver();
		
		if(strTelephoneNumber == "SUCCESS")
			img.setImageType("SUCCESS");
		else
			img.setImageType("Type");
		img.setImage(picData);
		img.setTitle(strTelephoneNumber);
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
			 ImageSaver temp = pm.makePersistent(img);
            
            Imagecam.Builder builder = new Imagecam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
            Imagecam service = builder.build();
            Imagecam quote = new Imagecam(builder);
            quote.sendimage(temp.getId(),(long) 123456).execute();
         }
		 catch(Exception e)
		 {
			 isSuccess = false;
		 }
		 finally 
		 {
            pm.close();
         }
		 
		 return isSuccess;
	}
	
	
	public boolean SaveLocationToDB(String IpLocation)
	{
		boolean isSuccess = true;
		LocationSaver locSave = new LocationSaver();
		
		Date date = new Date();
		locSave.setDetectedDate(date);
		locSave.setIpLocation(IpLocation);
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
			 pm.makePersistent(locSave);
         }
		 catch(Exception e)
		 {
			 isSuccess = false;
		 }
		 finally 
		 {
            pm.close();
         }
		 
		 return isSuccess;
	}
}
