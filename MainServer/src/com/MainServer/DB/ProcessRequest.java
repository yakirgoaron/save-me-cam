/**
 * Request for DB services
 */
package com.MainServer.DB;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
public class ProcessRequest 
{
	// Saves image to DB
	public boolean SaveImageToDB(String strTelephoneNumber,byte[] picData)
	{
		boolean isSuccess = true;
		ImageSaver img = new ImageSaver();
		
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
	// save an image detection to db and returns the object created
	public DetectImage SaveImageProcToDB(Long CameraId,int detection , Long ImageId)
	{
		DetectImage img = new DetectImage();
		DetectImage res = null;
		img.setuserID(CameraId);
		img.setimageSaverId(ImageId);
		img.seDetection(detection);
	
		
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
			 res = pm.makePersistent(img);
         }
		 catch(Exception e)
		 {
			 res = null;
		 }
		 finally 
		 {
            pm.close();
         }
		 
		 return res;
	}
	
	// save an event to the DB.
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
	
	// save an user to the DB.
	public boolean SaveUserToDB(Long CameraId,String Name,String Mail, String Number)
	{
		boolean isSuccess = true;
		Users user = new Users();
		
		user.setCameraID(CameraId);
		user.setMail(Mail);
		user.setName(Name);
		user.setNumber(Number);
	
		
		PersistenceManager pm =  PMF.get().getPersistenceManager();
		 try 
		 {
            pm.makePersistent(user);
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
	
	
	
	// Get image save by key
	public ImageSaver getImageSaverByKey(String key)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// query by key return only 1 result
		Query query = pm.newQuery(ImageSaver.class, "key == " + key);
	    query.setRange(0, 1);

	    try {
	        List<ImageSaver> results = (List<ImageSaver>) query.execute(key);

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
	
	// Get camera user by the number
	public Camera getUserCmaeraByName(String number)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		// query and return only 1 result
	    Query query = pm.newQuery(Camera.class, "Number == numberParam");
	    query.declareParameters("String numberParam");
	    query.setRange(0, 1);

	    try {
	        List<Camera> results = (List<Camera>) query.execute(number);

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
	
	// Get detected image by the id
	public DetectImage getDetectImageByUserAndImage(Long ImageId)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//search nly one by the detected image
	    Query query = pm.newQuery(DetectImage.class, "key == ImageIDParam");
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
	
	
	// Get all the events by a user
	public List<Events> getEventsByUser(Long user)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    Query query = pm.newQuery(Events.class, "UserID == " + user);

	    try {
	        List<Events> results = (List<Events>) query.execute(user);
	        results.size();

            // If the results list is non-empty, return the first (and only)
            // result
	        if (results.iterator().hasNext()) {
	            return results;
	        }
	    } finally {
	        query.closeAll();
	        pm.close();
	    }

	    return null;
	}
	// Get all the users by a camera
	public List<Users> getUsersByCamera(Long CameraID)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    Query query = pm.newQuery(Users.class, "CameraID == numberParam");
	    query.declareParameters("Long numberParam");


	    try {
	        List<Users> results = (List<Users>) query.execute(CameraID);
	        results.size();

            // If the results list is non-empty, return the first (and only)
            // result
	        if (results.iterator().hasNext()) {
	            return results;
	        }
	    } finally {
	        query.closeAll();
	        pm.close();
	    }

	    return null;
	}
	
	// delete a user that is connected to a camera
	public void DeleteUserByCamera(Users user)
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Users.class, "key == "+ user.getId());
		
		query.setRange(0, 1);

	    try 
	    {
	    	 List<Users> results = (List<Users>) query.execute(user.getId().toString());
	         // If the results list is non-empty, return the first (and only)
	         // result
	    	 if (results.iterator().hasNext()) 
	    	 {
	    		 pm.deletePersistent(results.iterator().next());
		     }
	    } 
	    finally 
	    {

	        pm.close();
	    }
	}
}
