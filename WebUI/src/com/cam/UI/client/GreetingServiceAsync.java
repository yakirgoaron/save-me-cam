package com.cam.UI.client;

import java.util.List;

import com.cam.UI.server.EventsForUserCollection;
import com.cam.UI.shared.EventsForUserLocal;
import com.cam.UI.shared.UsersForCameraLocal;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String username, String password, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	 void GetEventsForUser(AsyncCallback<List<EventsForUserLocal>> callback);
	 void GetUsersForCamera(AsyncCallback<List<UsersForCameraLocal>> callback);
	 void createUser(String name, String phone, String mail, AsyncCallback<String> callback);
	 void DeleteUser(String username, AsyncCallback<String> callback);
	 void TakeImage(AsyncCallback<String> callback);
}
