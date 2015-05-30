package com.github.mhendred.face4j.response;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mhendred.face4j.exception.FaceClientException;

abstract class AbstractResponse
{
	private static final int NUM_TABS = 2;
	

	
	protected final JSONObject response;
	
	protected AbstractResponse(final String json) throws FaceClientException
	{	
		try 
		{
			response = new JSONObject(json);
			
			
		}
		
		catch (JSONException jex)
		{
			throw new FaceClientException(jex);
		}
	}
	
	@Override
	public String toString ()
	{
		try
		{
			return response.toString(NUM_TABS);
		}
		
		catch (JSONException e)
		{
			return null;
		}
	}
}