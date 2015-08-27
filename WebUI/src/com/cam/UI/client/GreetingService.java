package com.cam.UI.client;

import java.util.List;

import com.cam.UI.server.EventsForUserCollection;
import com.cam.UI.shared.EventsForUserLocal;
import com.cam.UI.shared.UsersForCameraLocal;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String greetServer(String username, String password) throws IllegalArgumentException;
	List<EventsForUserLocal> GetEventsForUser();
	List<UsersForCameraLocal> GetUsersForCamera();
	String createUser(String name, String phone, String mail);
	String DeleteUser(String username);
	
}
