package com.cam.UI.server;

import java.io.IOException;
import java.util.logging.Logger;

import com.cam.UI.client.GreetingService;
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
	private static final Logger logger = Logger.getLogger("GreetingServiceImpl");
	public String greetServer(String input) throws IllegalArgumentException {
		String a = "Fail";
		logger.fine("start 1");
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		logger.fine("new 1");
		Logincam.Builder builder = new Logincam.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
		logger.fine("new 2");
		Logincam service = builder.build();
		logger.fine("new 3");
		Logincam quote = new Logincam(builder);
		logger.fine("new 4");
		String b = "OK";
		try {
			logger.fine("new 5");
			quote.login(input, "123").execute();
			a = "SUCCESS";
			logger.fine("new 6");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			b = e.getMessage() + "<br>";
			b += e.getLocalizedMessage();
			a = "EXECPTION";
		}
		return "Hello, " + b + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like -- "+a+" --  you are using:<br>" + userAgent;
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
