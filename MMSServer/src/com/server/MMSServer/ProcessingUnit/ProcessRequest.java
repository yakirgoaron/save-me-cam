/**
 * Request for DB services
 */
package com.server.MMSServer.ProcessingUnit;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;



import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;
public class ProcessRequest 
{
	// Save an raw image data to DB
	public long SaveImageToDB(String strTelephoneNumber,byte[] picData,double locx,double locy)
	{
		long imageID = 0;
		ImageSaver img = new ImageSaver();
		
		img.setImage(picData);
		img.setTitle(strTelephoneNumber);
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
			 ImageSaver temp = pm.makePersistent(img);
			 imageID = temp.getId(); 
			 LocationSaver loc =  GetLastLocationFromDB();
			 //DetectImage dect = getDetectImageByUserAndImage(loc.getImageID());
			 if(loc == null)
			 {
				 Imagecam.Builder builder = new Imagecam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
	             Imagecam quote = new Imagecam(builder);
	             quote.sendimage(temp.getId(),(long) 123456).execute(); 
			 }
			 if( (loc.getLocX() < (locx+0.0001) || loc.getLocX() > (locx-0.0001)) && 
  			     (loc.getLocY() < (locy+0.0001) || loc.getLocY() > (locy-0.0001)) )
			 {
				Imagecam.Builder builder = new Imagecam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
             	Imagecam quote = new Imagecam(builder);
             	quote.sendimage(temp.getId(),(long) 123456).execute();
			 }
             
         }
		 catch(Exception e)
		 {
			 imageID = 0;
		 }
		 finally 
		 {
            pm.close();
         }
		 
		 return imageID;
	}
	
	// Get detected image by the id
	public DetectImage getDetectImageByUserAndImage(Long ImageId)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//search rly one by the detected image
	    Query query = pm.newQuery(DetectImage.class, "imageSaverId == ImageIDParam");
	    query.declareParameters("Long ImageIDParam");
	    query.setRange(0, 1);

	    try {
	        List<DetectImage> results = (List<DetectImage>) query.execute(ImageId);
	        // If the results list is non-empty, return the first (and only)
            // result
	        if (results.iterator().hasNext()) {
	            
	            return results.get(0);
	        }
	    } finally {
	        query.closeAll();
	        pm.close();
	    }

	    return null;
	}
	
	
	// Get last location
	public LocationSaver GetLastLocationFromDB()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// query by key return only 1 result
		Query query = pm.newQuery(LocationSaver.class);
	    query.setRange(0, 1);
	    query.setOrdering("LocDate");

	    try {
	        List<LocationSaver> results = (List<LocationSaver>) query.execute();

            // If the results list is non-empty, return the first (and only)
            // result
	        if (results.iterator().hasNext()) {
	            return results.get(0);
	        }
	    } finally {
	        query.closeAll();
	        pm.close();
	    }

		 
		 return null;
	}
	
	// Save location to DB
	public boolean SaveLocationToDB(String Country,String Region,String City,double locx,double locy,long image)
	{
		boolean isSuccess = true;
		LocationSaver locSave = new LocationSaver();
		locSave.setCountry(City);
		locSave.setRegion(City);
		locSave.setCity(City);
		locSave.setLocX(locx);
		locSave.setLocY(locy);
		locSave.setLocDate(new Date());
		locSave.setImageID(image);
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
