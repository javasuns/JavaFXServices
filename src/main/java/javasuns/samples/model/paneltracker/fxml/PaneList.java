/*
 * Copyright (C) 2021-2022 BlackJackFX 
 * Giannos Hadjipanayis
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package javasuns.samples.model.paneltracker.fxml;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javasuns.samples.controller.interfaces.Controller;

public class PaneList {

   HashMap<Integer,Pane> panes = new HashMap<Integer,Pane>();
   HashMap<Pane,Controller> panesController = new HashMap<Pane,Controller>();

   public static final int TAB_0	 = -1,
                           PRELOADER     =  0,
			   SCREEN_A      =  1,
		  	   DEVICE_INFO   =  2,
			   BROWSER       =  3,
			   NOTIFICATIONS =  4,
			   SHARE_CONTENT =  5,
			   MESSAGE_POPUP =  6;

   public synchronized Pane getPane(int id) {
      	Pane pane = panes.get(id);
      	if(pane == null) {
   	   initPane(id);
   	   pane = panes.get(id);
      	}
	return pane;
   } // getPane()

   @SuppressWarnings("unchecked")
   public <T> T getController(int id) {
	return (T) panesController.get(getPane(id));
   } // getController()

   private void initPane(int id) {
   	String fxmlPath = "";
   	try {
   		switch (id) {
   			case SCREEN_A:      fxmlPath = "/javasuns/samples/view/MainScreen.fxml"; break;
   			case TAB_0:         fxmlPath = "/javasuns/samples/view/tabs/Tab.fxml"; break;
   			case DEVICE_INFO:   fxmlPath = "/javasuns/samples/view/service/DeviceInfo.fxml"; break;
   			case BROWSER:       fxmlPath = "/javasuns/samples/view/service/Browser.fxml"; break;
   			case NOTIFICATIONS: fxmlPath = "/javasuns/samples/view/service/PushNotifications.fxml"; break;
   			case SHARE_CONTENT: fxmlPath = "/javasuns/samples/view/service/ShareContent.fxml"; break;
   			case MESSAGE_POPUP: fxmlPath = "/javasuns/samples/view/popup/Message.fxml"; break;
   		} // switch

   		Pane pane = getPaneFromFXML(fxmlPath);
   		panes.put(id, pane);
   		panesController.put(pane, getPaneController());
   	} catch (IOException e) {e.printStackTrace();}
   }

   Controller paneController;

   @SuppressWarnings("unchecked")
	private <T> T getPaneController() {
   	return (T) paneController;
   }

   private <T> Pane getPaneFromFXML(String url) throws IOException {
	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));

	Pane pane = fxmlLoader.load();
	paneController = fxmlLoader.getController();

	AnchorPane.setTopAnchor(pane, 0.0);
	AnchorPane.setBottomAnchor(pane, 0.0);
	AnchorPane.setLeftAnchor(pane, 0.0);
	AnchorPane.setRightAnchor(pane, 0.0);

	fxmlLoader = null;
	return pane;
   } // getPaneFromFXML
} // class PanelList
