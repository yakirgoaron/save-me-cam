package com.MainServer.DB;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;


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
            pm.makePersistent(img);
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
	
	public boolean SaveImageProcToDB(Long CameraId,int detection , Long ImageId)
	{
		boolean isSuccess = true;
		DetectImage img = new DetectImage();
		
		img.setuserID(CameraId);
		img.setimageSaverId(ImageId);
		img.seDetection(detection);
	
		
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
            pm.makePersistent(img);
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
	
	public boolean SaveEventsToDB(Long CameraId,String Message ,Long imageId)
	{
		boolean isSuccess = true;
		Events eve = new Events();
		
		eve.setUserID(CameraId);
		eve.setMessage(Message);
		eve.setImageID(imageId);
		eve.setDate(new Date());
	
		
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
            pm.makePersistent(eve);
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
	
	
	
	
	public ImageSaver getImageSaverByKey(String key)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		// Search for any Movie object with the passed-in title; limit the number
	    // of results returned to 1 since there should be at most one movie with
	    // a given title
	    //Query query = pm.newQuery(ImageSaver.class, "key == 5695159920492544");
		Query query = pm.newQuery(ImageSaver.class, "key == " + key);
	    //query.declareParameters("String titleParam");
	    query.setRange(0, 1);

	    try {
	        List<ImageSaver> results = (List<ImageSaver>) query.execute(key);
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
	

	public Camera getUserCmaeraByName(String number)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// Search for any Movie object with the passed-in title; limit the number
	    // of results returned to 1 since there should be at most one movie with
	    // a given title
	    Query query = pm.newQuery(Camera.class, "Number == numberParam");
	    query.declareParameters("String numberParam");
	    query.setRange(0, 1);

	    try {
	        List<Camera> results = (List<Camera>) query.execute(number);
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
	
	
	public DetectImage getDetectImageByUserAndImage(Long ImageId)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// Search for any Movie object with the passed-in title; limit the number
	    // of results returned to 1 since there should be at most one movie with
	    // a given title
	    Query query = pm.newQuery(DetectImage.class, "key == ImageIDParam");
	    query.declareParameters("Long ImageIDParam");
	    query.setRange(0, 1);

	    try {
	        List<DetectImage> results = (List<DetectImage>) query.execute(ImageId);
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
	
	
	
	public List<Events> getEventsByUser(Long user)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// Search for any Movie object with the passed-in title; limit the number
	    // of results returned to 1 since there should be at most one movie with
	    // a given title
	    Query query = pm.newQuery(Events.class, "UserID == " + user);
	    //query.declareParameters("String numberParam");
	    query.setRange(0, 1);

	    try {
	        List<Events> results = (List<Events>) query.execute(user);
	        if (results.iterator().hasNext()) {
	            // If the results list is non-empty, return the first (and only)
	            // result
	            return results;
	        }
	    } finally {
	        query.closeAll();
	        pm.close();
	    }

	    return null;
	}
}
