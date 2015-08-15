package com.server.MMSServer.ProcessingUnit;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;

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
	
	
	public ImageSaver getImageSaverByTitle(String title)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// Search for any Movie object with the passed-in title; limit the number
	    // of results returned to 1 since there should be at most one movie with
	    // a given title
	    Query query = pm.newQuery(ImageSaver.class, "title == titleParam");
	    query.declareParameters("String titleParam");
	    query.setRange(0, 1);

	    try {
	        List<ImageSaver> results = (List<ImageSaver>) query.execute(title);
	        if (results.iterator().hasNext()) {
	            // If the results list is non-empty, return the first (and only)
	            // result
	            return results.get(0);
	        }
	    } finally {
	        query.closeAll();
	        pm.close();
	    }

	    return null;
	}
}
