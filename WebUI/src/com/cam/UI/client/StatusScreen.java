package com.cam.UI.client;

import java.io.IOException;
import java.util.List;

import com.cam.UI.server.EventsForUser;
import com.cam.UI.server.EventsForUserCollection;
import com.cam.UI.server.Logincam;
import com.cam.UI.server.Query;
import com.cam.UI.server.Query.Queryevents;
import com.cam.UI.shared.EventsForUserLocal;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.storage.client.Storage;



public class StatusScreen implements EntryPoint {

  private VerticalPanel mainPanel = new VerticalPanel();
  private FlexTable HistoryTable = new FlexTable();
  private HorizontalPanel addPanel = new HorizontalPanel();
  private TextBox newSymbolTextBox = new TextBox();
  private Button addStockButton = new Button("Add");
  private Label lastUpdatedLabel = new Label();

  /**
   * Entry point method.
   */
  public void onModuleLoad() {
	  final Label errorLabel = new Label();

    // Create table for stock data.
	HistoryTable.setText(0, 0, "Date");
	HistoryTable.setText(0, 1, "Event");
	HistoryTable.setText(0, 1, "Message");
	HistoryTable.setText(0, 2, "Confidance(%)");
    HistoryTable.setText(0, 3, "picture");
    RootPanel.get("HistoryTableContainer").add(HistoryTable); 

    
	  System.out.println("-------------1111111111-----------------");
	 // System.out.println(username);
	  System.out.println("---------------------------------------");
//    Query.Builder builder = new Query.Builder(UrlFetchTransport.getDefaultInstance(), new GsonFactory(), null);
//    Query service = builder.build();
//    try {
//		EventsForUserCollection events = service.queryevents("123456").execute();
//		List<EventsForUser> UserEventsList = events.getItems();
//		for(EventsForUser event: UserEventsList)
//		{
//			HistoryTable.setText(1, 0, event.getDate().toString());
//		}
//
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}//username
		//greetingService.(username, password,
	  GreetingServiceAsync greetingService = ImpSingleton.getInstance().getGreetingServiceAsync();
	  greetingService.GetEventsForUser(
				new AsyncCallback<List<EventsForUserLocal>>() {
					public void onFailure(Throwable caught) {
						
					}

					public void onSuccess(List<EventsForUserLocal> events) {
						int row = 1;
						//List<EventsForUser> eventsForUser = events.getItems();
						for (EventsForUserLocal event:events)
						{
							row++;
							//HistoryTable.setText(row, 0 , event.date.toString());

						}
					}
				})	;
   //String username = Window.Location.getParameter("username");
   
   final Label UserNameLabel = new Label();
 
    // TODO Assemble Add Stock panel.
    // TODO Assemble Main panel.
    // TODO Associate the Main panel with the HTML host page.
    // TODO Move cursor focus to the input box.
   Storage stockStore = null;
	  stockStore = Storage.getLocalStorageIfSupported();
	  String username = stockStore.getItem("username");
	  System.out.println("-------------2222222222-----------------");
	  System.out.println(username);
	  System.out.println("---------------------------------------");
	  UserNameLabel.setText(username);
	   RootPanel.get("usernamecontainer").add(UserNameLabel);
  }



}


