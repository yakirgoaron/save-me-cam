/**
 * Request for DB services
 */
package com.server.MMSServer.ProcessingUnit;
import java.util.Date;

import javax.jdo.PersistenceManager;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;
public class ProcessRequest 
{
	// Save an raw image data to DB
	public boolean SaveImageToDB(String strTelephoneNumber,byte[] picData)
	{
		boolean isSuccess = true;
		ImageSaver img = new ImageSaver();
		
		img.setImage(picData);
		img.setTitle(strTelephoneNumber);
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
			 ImageSaver temp = pm.makePersistent(img);
            
            Imagecam.Builder builder = new Imagecam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
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
	
	// Save location to DB
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
