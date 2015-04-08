package com.server.MMSServer.ServerCommunication;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.server.MMSServer.ProcessingUnit.ImageSaver;
import com.server.MMSServer.ProcessingUnit.ProcessRequest;

@Api(name = "imagemanager")
public class MMSCommunication {
	
	@ApiMethod(name = "scores.get") 
	public ImageSaver get(@Named("Title") String Title) 
	{
		ProcessRequest request = new ProcessRequest();
	    
	    return request.getImageSaverByTitle(Title);
	  }
}
