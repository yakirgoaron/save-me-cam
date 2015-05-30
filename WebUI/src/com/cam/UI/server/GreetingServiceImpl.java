package com.cam.UI.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cam.UI.client.GreetingService;
import com.cam.UI.shared.EventsForUserLocal;
import com.cam.UI.shared.FieldVerifier;
import com.google.gwt.dom.builder.shared.QuoteBuilder;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;
/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	private static GreetingServiceImpl greeting;
	private static final Logger logger = Logger.getLogger("GreetingServiceImpl");
	private String username;
	
	public String greetServer(String username, String password) throws IllegalArgumentException {
		String a = "Fail";
		logger.fine("start 1");
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(username)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		username = escapeHtml(username);
		password = escapeHtml(password);
		userAgent = escapeHtml(userAgent);
		
		Logincam.Builder builder = new Logincam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
		Logincam service = builder.build();
		Logincam quote = new Logincam(builder);
		
		String b = "OK";
		try {
			
			quote.login(username, password).execute();
			a = "SUCCESS";
			this.username = username;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			b = e.getMessage() + "<br>";
			b += e.getLocalizedMessage();
			a = "ERROR - User Name or Password is incorrect";
		}
		return (a); /*"Hello, " + b + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like -- "+a+" --  you are using:<br>" + userAgent;*/
	}
	
	public List<EventsForUserLocal> GetEventsForUser()
	{
		Query.Builder builder = new Query.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
	    Query service = builder.build();
	    List<EventsForUserLocal> localArray = new ArrayList<EventsForUserLocal>();
	    try {
			EventsForUserCollection events = service.queryevents(this.username).execute();
			List<EventsForUser> eventsforusers = events.getItems();
			for (EventsForUser event:eventsforusers)
			{
				EventsForUserLocal temp = new EventsForUserLocal();
				temp.date = event.getDate().toString();
				temp.eventtype = event.getEventtype();
				temp.message = event.getMessage();
				temp.uRL = event.getURL();
				temp.confidance = event.getConfidance();
				localArray.add(temp);
			}
			return localArray;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return localArray;
		}//username
	}
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
