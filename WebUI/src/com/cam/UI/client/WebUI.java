package com.cam.UI.client;

import java.util.List;

import com.cam.UI.shared.EventsForUserLocal;
import com.cam.UI.shared.FieldVerifier;
import com.cam.UI.shared.UsersForCameraLocal;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
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
	public Label Header;
	FlexTable usersTable;
	int rowIndex;
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Header = new Label("Save Me Cam Login Page");
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
		RootPanel.get("HeaderContainer").add(Header);
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
		RootPanel.setVisible(DOM.getElementById("NewUserTable"), false);
		
		DOM.getElementById("BodyContainer").setClassName("Login");
		
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
									//TODO remove comment
//									Label CamName = new Label("Hello "+nameField.getText());
									Label CamName = new Label("Hello "+"CohenCam");
									
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
									  RootPanel.get("CamNameContainer").add(CamName);
									  
									  RootPanel.setVisible(DOM.getElementById("loginTable"), false);
									 
									  DOM.getElementById("BodyContainer").removeClassName("Login");
									  //DOM.setStyleAttribute(RootPanel.get("BodyContainer").getElement(), "class", " ");
									  MenuScreen();
									  StatusScreen();
									  

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

void StatusScreen ()
{	
	ClearScreen();
	
	Header.setText("Save Me Cam - Events");
		  GreetingServiceAsync greetingService = ImpSingleton.getInstance().getGreetingServiceAsync();
		  greetingService.GetEventsForUser(
					new AsyncCallback<List<EventsForUserLocal>>() {
						public void onFailure(Throwable caught) {
							
						}

						public void onSuccess(List<EventsForUserLocal> events) {
							int row = 1;
							final FlexTable eventsTable=new FlexTable();
							eventsTable.setWidth("50em");
							eventsTable.setCellSpacing(5);
							eventsTable.setCellPadding(3);
							eventsTable.setText(0, 0, "Date");
							//eventsTable.setText(0, 1, "Event");
							eventsTable.setText(0, 1, "Message");
							eventsTable.setText(0, 2, "Confidance(%)");
							eventsTable.setText(0, 3, "picture");
							
							eventsTable.getRowFormatter().setStyleName(
						            0,"FlexTable-Header");
						    
							for (EventsForUserLocal event:events)
							{
								row++;
								eventsTable.setText(row, 0 , event.date.toString());
								//eventsTable.setText(row, 1 , event.eventtype);
								eventsTable.setText(row, 1 , event.message);
								
								if (event.confidance != null)
									eventsTable.setText(row, 2 , event.confidance.toString());
								else
									eventsTable.setText(row, 2 , "---");
								
								//urlAnchor = new Anchor("show picture", event.uRL);
								eventsTable.setWidget(row, 3, new Anchor("view picture", false, event.uRL, "_blank"));								
							}
							eventsTable.setBorderWidth(5);
							RootPanel.get("HistoryTableContainer").add(eventsTable);
						}
					})	;
	  }

void MenuScreen ()
{
//	final DisclosurePanel DisclosureMenu = new DisclosurePanel();
//	//RootPanel.get("HistoryTableContainer").clear();
//	DisclosureMenu.setHeader(new Label ("header"));
//	DisclosureMenu.setContent(new Label("Disclosure panel with a specific expand/collapse button"));
//	RootPanel.get("DisclosureMenuContainer").add(DisclosureMenu);
	
	 // Create a menu bar
	   MenuBar menu = new MenuBar();
	   menu.setAutoOpen(true);
	  // menu.setWidth("200px");
	   menu.setAnimationEnabled(true);
	   
	   
	   menu.addItem("Events", new Command() {
		      @Override
		      public void execute() {
		         StatusScreen();
		      }
		   });
	   menu.addSeparator();
	   menu.addItem("Users", new Command() {
		      @Override
		      public void execute() {
		         UserScreen();
		      }
		   });
	   menu.addSeparator();
	   menu.addItem("Cam Status", new Command() {
		      @Override
		      public void execute() {
		         CamStatusScreen();
		      }
		   });

	   
	   //add the menu to the root panel
	   RootPanel.get("MenuContainer").add(menu);
}


		
		

void UserScreen()
{
	ClearScreen();
	
	final Button NewUserButton = new Button("Add New User");	
	final Button DeleteUserButton = new Button("Delete Selected User");	
	RootPanel.get("UserAddButtonContainer").add(NewUserButton);	
	RootPanel.get("UserDeleteButtonContainer").add(DeleteUserButton);
	DeleteUserButton.setEnabled(false);
	Header.setText("Save Me Cam - User Management");
	
	greetingService.GetUsersForCamera(
				new AsyncCallback<List<UsersForCameraLocal>>() {
					public void onFailure(Throwable caught) {
						
					}

					public void onSuccess(List<UsersForCameraLocal> users) {
						
						int row = 1;
						usersTable = new FlexTable();
						usersTable.setWidth("50em");
						usersTable.setCellSpacing(5);
						usersTable.setCellPadding(3);
						usersTable.setText(row, 0, "Name");
						usersTable.setText(row, 1, "Phone Number");
						usersTable.setText(row, 2, "Mail");
						
						for (UsersForCameraLocal user:users)
						{
							row++;
							usersTable.setText(row, 0 , user.name);
							usersTable.setText(row, 1 , user.phone);
							usersTable.setText(row, 2 , user.mail);								
						}
						usersTable.setBorderWidth(5);
						RootPanel.get("UserTableContainer").add(usersTable);

						usersTable.addClickHandler(	//Create a handler for the sendButton and nameField
								new  ClickHandler(){
									/**
									 * Fired when the user clicks on the sendButton.
									 */
									public void onClick(ClickEvent event) {
										
										Cell src = usersTable.getCellForEvent(event);
							            rowIndex = src.getRowIndex();
							            System.out.println("row!!!" + rowIndex);
							            
							            for(int row=1; row < usersTable.getRowCount(); row++)
							            {
							            	usersTable.getRowFormatter().removeStyleName(row, "SelectedRow");
							            }
							            
							            //we won`t select the header
							            if (rowIndex > 1) 
							            {
							            	usersTable.getRowFormatter().addStyleName(rowIndex, "SelectedRow");
							            	DeleteUserButton.setEnabled(true);
							            }
							            else
							            {
							            	DeleteUserButton.setEnabled(false);
							            }
									}
								});						
					}
					
				})	;

	//Create a handler for the sendButton and nameField
		class AddNewUserHandler implements ClickHandler{
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				NewUserScreen();
				NewUserButton.setEnabled(false);
			//	Window.open("NewScreen.html", "_self", ""); 
			}
		}
		
		//Create a handler for the sendButton and nameField
		class DeleteUserHandler implements ClickHandler{
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				DeleteUser();
				DeleteUserButton.setEnabled(false);
			//	Window.open("NewScreen.html", "_self", ""); 
			}
		}
	
	AddNewUserHandler NewUserHandler = new AddNewUserHandler();
	NewUserButton.addClickHandler(NewUserHandler);
	
	DeleteUserHandler UserHandler = new DeleteUserHandler();
	DeleteUserButton.addClickHandler(UserHandler);
} 

void NewUserScreen()
{
	
	final Button AddUserButton = new Button("Add User");
	System.out.println("NewUserScreen");
	final TextBox UserNameField = new TextBox();
	final TextBox UserPhoneField = new TextBox();
	final TextBox UserMailField = new TextBox();
	final Label NewUserErrorLabel = new Label();
	RootPanel.get("NewUserNameFieldContainer").add(UserNameField);
	RootPanel.get("NewUserPhoneFieldContainer").add(UserPhoneField);
	RootPanel.get("NewUserMailFieldContainer").add(UserMailField);
	RootPanel.get("NewUserAddButtonContainer").add(AddUserButton);
	RootPanel.get("NewUserErrorLabelContainer").add(NewUserErrorLabel);

	RootPanel.setVisible(DOM.getElementById("NewUserTable"), true);
	
	//Create a handler for the sendButton and nameField
		class NewUserHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNewUserToServer();
			//	Window.open("NewScreen.html", "_self", ""); 
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNewUserToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNewUserToServer() {
				// First, we validate the input.
				NewUserErrorLabel.setText("");
				String userName = UserNameField.getText();
				String userPhone = UserPhoneField.getText();
				String userMail = UserMailField.getText();
				if (!FieldVerifier.isValidName(userName)) {
					NewUserErrorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				AddUserButton.setEnabled(false);
				greetingService.createUser(userName, userPhone, userMail,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								NewUserErrorLabel
										.setText(SERVER_ERROR);
								AddUserButton.setEnabled(true);
							}

							public void onSuccess(String result) {
								NewUserErrorLabel.setText(result);
									
									UserNameField.setText("");
									UserPhoneField.setText("");
									UserMailField.setText("");
									NewUserErrorLabel.setText(result);

								AddUserButton.setEnabled(true);
								UserScreen();
							}
						});
			}
		}
		
		NewUserHandler UserHandler = new NewUserHandler();
		AddUserButton.addClickHandler(UserHandler);
}

void DeleteUser()
{
	String username = usersTable.getText(rowIndex, 0);
	System.out.println(username);
	greetingService.DeleteUser(username,
			new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					System.out.println("fail");
				}

				public void onSuccess(String result) {
					UserScreen();
					System.out.println("success");
				}
			});
	
}

void CamStatusScreen()
{
	ClearScreen();
	
	final Button CurrentPic = new Button("Show current situation image from car");
	RootPanel.get("CurrPicButtonContainer").add(CurrentPic);
	
	class PicHandler implements ClickHandler{

		/**
		 * Fired when the user clicks on the sendButton.
		 */
		public void onClick(ClickEvent event) {			
				TakeImage();
		}
		
		private void TakeImage()
		{
	      
	      greetingService.TakeImage(
					new AsyncCallback<String>() {
						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user
//							NewUserErrorLabel
//									.setText(SERVER_ERROR);
//							AddUserButton.setEnabled(true);
						}

						public void onSuccess(String result) {
							Image image = new Image();
							
							RootPanel.get("PictureContainer").clear();
					      //set image source
					      //image.setUrl("empty-carseats.jpg");
							image.setUrl(result);
							System.out.println("pic "+ result);
					      image.setSize("240px", "240px");
					      // Add image to the root panel.
					      VerticalPanel panel = new VerticalPanel();
					      panel.add(image);

					      RootPanel.get("PictureContainer").add(panel);
						}
					});
		}
	}
	
	PicHandler temph = new PicHandler();
	CurrentPic.addClickHandler(temph);
	
}

public void ClearScreen()
{
	RootPanel.get("UserAddButtonContainer").clear();
	RootPanel.get("UserDeleteButtonContainer").clear();
	RootPanel.get("HistoryTableContainer").clear();
	RootPanel.get("UserTableContainer").clear();
	RootPanel.get("CurrPicButtonContainer").clear();
	RootPanel.setVisible(DOM.getElementById("NewUserTable"), false);
	RootPanel.get("PictureContainer").clear();
}
}
