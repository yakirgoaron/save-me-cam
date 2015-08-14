package com.cam.UI.client;

import java.util.List;

import com.cam.UI.shared.EventsForUserLocal;
import com.cam.UI.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.FlexTable;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebUI implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	 
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	public final GreetingServiceAsync greetingService = GWT//changed to public by Nadyush
			.create(GreetingService.class);
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		final Button userButton = new Button("User Page");
		final TextBox nameField = new TextBox();
		final PasswordTextBox passField = new PasswordTextBox();
		nameField.setText("");
		final Label errorLabel = new Label();
		System.out.println("-------------webUI-----------------");
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		ImpSingleton.getInstance().setGreetingServiceAsync(greetingService);
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("passFieldContainer").add(passField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		nameField.setVisibleLength(10);
		passField.setVisibleLength(13);
		
		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {

			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			//	Window.open("NewScreen.html", "_self", ""); 
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String username = nameField.getText();
				String password = passField.getText();
				if (!FieldVerifier.isValidName(username)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(username);
				serverResponseLabel.setText("");
				greetingService.greetServer(username, password,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								errorLabel
										.setText(SERVER_ERROR);
								//serverResponseLabel
								//		.addStyleName("serverResponseLabelError");
								//serverResponseLabel.setHTML(SERVER_ERROR);
								//dialogBox.center();
								//closeButton.setFocus(true);
								sendButton.setEnabled(true);
							}

							public void onSuccess(String result) {
								errorLabel.setText(result);
								if (result.equals("SUCCESS"))
								{
									//Window.open("StatusScreen.html", "_self", "");
									// Save data to sessionStorage
									//Window.Location.assign("StatusScreen.html?username="+nameField.getText());
									 Storage stockStore = null;
									  stockStore = Storage.getLocalStorageIfSupported();
									  stockStore.setItem("usename", nameField.getText());
									  //RootPanel.get().clear();
									  RootPanel.get("nameFieldContainer").clear();
									  RootPanel.get("passFieldContainer").clear();
									  RootPanel.get("sendButtonContainer").clear();
									  RootPanel.get("errorLabelContainer").clear();
									  
									  RootPanel.setVisible(DOM.getElementById("loginTable"), false);
									 
									  StatusScreen(userButton);
									  //MenuScreen();

								}
									else
									errorLabel.setText(result);
							//	serverResponseLabel
							//			.removeStyleName("serverResponseLabelError");
							//	serverResponseLabel.setHTML(result);
							//	dialogBox.center();
							//	closeButton.setFocus(true);
								sendButton.setEnabled(true);
							}
						});
			}
		}

		
		class tempHandler implements ClickHandler{

			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				UserScreen();
			//	Window.open("NewScreen.html", "_self", ""); 
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		tempHandler handler1 = new tempHandler();
		sendButton.addClickHandler(handler);
		userButton.addClickHandler(handler1);
		nameField.addKeyUpHandler(handler);
		passField.addKeyUpHandler(new KeyUpHandler() {

		    @Override
		    public void onKeyUp(KeyUpEvent event) {
		     if(event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
		    	 DomEvent.fireNativeEvent(Document.get().createClickEvent(0, 0, 0, 0, 0,
		    	            false, false, false, false), sendButton);;
		     }
		           }
		    
		});
		
	}

void StatusScreen (Button userButton)
{

		  GreetingServiceAsync greetingService = ImpSingleton.getInstance().getGreetingServiceAsync();
		  greetingService.GetEventsForUser(
					new AsyncCallback<List<EventsForUserLocal>>() {
						public void onFailure(Throwable caught) {
							
						}

						public void onSuccess(List<EventsForUserLocal> events) {
							int row = 1;
							FlexTable eventsTable=new FlexTable();
							eventsTable.setWidth("50em");
							eventsTable.setCellSpacing(5);
							eventsTable.setCellPadding(3);
							eventsTable.setText(0, 0, "Date");
							eventsTable.setText(0, 1, "Event");
							eventsTable.setText(0, 2, "Message");
							eventsTable.setText(0, 3, "Confidance(%)");
							eventsTable.setText(0, 4, "picture");
							
							for (EventsForUserLocal event:events)
							{
								row++;
								eventsTable.setText(row, 0 , event.date.toString());
								eventsTable.setText(row, 1 , event.eventtype);
								eventsTable.setText(row, 2 , event.message);
								
								if (event.confidance != null)
									eventsTable.setText(row, 3 , event.confidance.toString());
								else
									eventsTable.setText(row, 3 , "---");
								
								eventsTable.setText(row, 4 , event.uRL);
							}
							eventsTable.setBorderWidth(5);
							RootPanel.get("HistoryTableContainer").add(eventsTable);
						}
					})	;
		  
		  RootPanel.get("usersButtonContainer").add(userButton);
	  }

void MenuScreen ()
{
	final DisclosurePanel DisclosureMenu = new DisclosurePanel();
	//RootPanel.get("HistoryTableContainer").clear();
	DisclosureMenu.setHeader(new Label ("header"));
	DisclosureMenu.setContent(new Label("Disclosure panel with a specific expand/collapse button"));
	RootPanel.get("DisclosureMenuContainer").add(DisclosureMenu);
}

void UserScreen(){
	
	
}
}
