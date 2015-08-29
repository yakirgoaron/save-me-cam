/**
 * SKI biometry API for face detection login and run
 */
package com.MainServer.SkiAPI;

import java.util.logging.Logger;

import com.github.mhendred.face4j.DefaultFaceClient;
import com.github.mhendred.face4j.FaceClient;
import com.github.mhendred.face4j.exception.FaceClientException;
import com.github.mhendred.face4j.exception.FaceServerException;
import com.github.mhendred.face4j.model.Face;
import com.github.mhendred.face4j.model.Photo;

public class SkyAPI 
{
	private static final Logger logger = Logger.getLogger("SkyAPI");
	/**
	 * Your SkyBiometry API key
	 */
	protected static final String API_KEY = "c2e6df034e4e4dce8162f57e4dd07b5a";
	
	/**
	 * Your SkyBiometry API secret
	 */
	protected static final String API_SEC = "914b6529f9804c6386c985ba446a4c20";

	/**
	 * A url of a photo with faces in it
	 */
	protected static final String URL_WITH_FACES = "http://seedmagazine.com/images/uploads/attractive_article.jpg";

	/**
	 * Your SkyBiometry API namespace
	 */
	protected static final String NAMESPACE = "bla";

	/**
	 * user id to recognize
	 */
	protected static final String USER_ID = "miribendor1@" + NAMESPACE;
	
	
	public int PicSync(String URLPic) throws FaceClientException, FaceServerException
	{
		//FaceClient faceClient = new DefaultFaceClient(API_KEY, API_SEC);
		FaceClient faceClient = new DefaultFaceClient(API_KEY, API_SEC);
		
    	/**
    	 * First we detect some faces in a url. This URL has a single face, So we get back one
    	 * Photo object with one Face object in it.
    	 * 
    	 * You can pass more than one URL (comma delimited String) or you can pass an image file    
    	 * 
    	 * @see https://www.skybiometry.com/Documentation#faces/detect
    	 * @see https://www.skybiometry.com/Documentation#faces/recognize
    	 */
		try
		{
	    	Photo photo = faceClient.recognize(URLPic, "all@" + NAMESPACE).get(0);
	    	
	    	int sum = 0;
	    	int numface = 0;
	    	logger.fine("------------------------------------------------");
	    	for (Face face : photo.getFaces())
	    	{
	    		sum += face.getFaceConfidence();
	    		++numface;
	    		logger.fine("-----------------------"+sum+"-------------------------");
	    		logger.fine("-----------------------"+numface+"-------------------------");

	    	}
	    	logger.fine("------------------------------------------------");
	    	return sum/numface;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
