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

package javasuns.samples.model.paneltracker;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javasuns.samples.controller.popup.MessageController;
import javasuns.samples.controller.service.DeviceInfoController;
import javasuns.samples.controller.service.ServicesController;
import javasuns.samples.controller.service.PushNotificationsController;
import javasuns.samples.controller.service.ShareContentController;
import javasuns.samples.controller.tabs.TabController;
import javasuns.samples.model.paneltracker.fxml.PaneList;

public class PanelTracker {
   private static PanelTracker panelTracker;
   
   private PaneList panelList;
   private AnchorPane scenePane;
   private Pane activeTab;
   
   public static PanelTracker init(AnchorPane scenePane) {
      panelTracker = new PanelTracker(scenePane);
      return panelTracker;
   } // init()

   public static PanelTracker getTracker() {
	if(panelTracker == null) {
	   System.err.println("PanelTracker not initialized!");
	   System.exit(-100);
	} // if
      	return panelTracker;
   } // getTracker()

   private PanelTracker(AnchorPane scenePane) {
   	this.scenePane = scenePane; 
   } // Constructor Method

   // Preloading FXML Panes for better user experience
   public void preLoadPanels() {
   	panelList = new PaneList();
        getMainScreenPane();
        getDeviceInfoPane();
        getBrowserPane();
        getPushNotificationsPane();
        getShareContentPane();
        getMessagePane();
   	panelList.getPane(PaneList.TAB_0);
   } // initBasicPanels()
   
   public void goToTab(int tabNo) {
   	// Do not do anything if already in tab.
   	if(activeTab == panelList.getPane(tabNo))
   	   return;
   	
   	activeTab = panelList.getPane(tabNo);
   	addToScenePane(activeTab);
   } // goToTab()
   
   public void addToScenePane(Parent pane) {
   	Platform.runLater(() -> {
           scenePane.getChildren().add(0,pane);
           AnchorPane.setTopAnchor(pane, 0.0);
           AnchorPane.setBottomAnchor(pane, 0.0);
           AnchorPane.setLeftAnchor(pane, 0.0);
           AnchorPane.setRightAnchor(pane, 0.0);
           scenePane.getChildren().remove(1);
           scenePane.layout();
           scenePane.applyCss();
       });
   } // addToScenePane()
   
   public TabController getActiveTabController() {
   	return panelList.getController(PaneList.TAB_0);
   } // getActiveTabController()
   
   public void goToLoginPane() {
	activeTab = panelList.getPane(PaneList.TAB_0);
	activeTab.getChildren().add(getMainScreenPane());
	addToScenePane(activeTab);
   } // goToLoginPane()
	
   public void showMessage(String message) {
   	Platform.runLater(() -> {
   	   getMessageController().setMessageProperties(message,3,"white","black");
   	   if(!scenePane.getChildren().contains(getMessagePane()))
   	      scenePane.getChildren().add(getMessagePane());
   	   getMessageController().showPopup();
   	});
   } // showMessage()
	
   public Parent getMainScreenPane() { return panelList.getPane(PaneList.SCREEN_A); }
   public ServicesController getMainScreenController() { return panelList.getController(PaneList.SCREEN_A); }
   public Parent getDeviceInfoPane() { return panelList.getPane(PaneList.DEVICE_INFO); } 
   public DeviceInfoController getDeviceInfoController() { return panelList.getController(PaneList.DEVICE_INFO); }
   public Parent getBrowserPane() { return panelList.getPane(PaneList.BROWSER); } 
   public DeviceInfoController getBrowserController() { return panelList.getController(PaneList.BROWSER); }
   public Parent getPushNotificationsPane() { return panelList.getPane(PaneList.NOTIFICATIONS); } 
   public PushNotificationsController getPushNotificationsController() { return panelList.getController(PaneList.NOTIFICATIONS); }
   public Parent getShareContentPane() { return panelList.getPane(PaneList.SHARE_CONTENT); } 
   public ShareContentController getShareContentController() { return panelList.getController(PaneList.SHARE_CONTENT); }
   private Parent getMessagePane() { return panelList.getPane(PaneList.MESSAGE_POPUP); }
   private MessageController getMessageController() { return panelList.getController(PaneList.MESSAGE_POPUP);} 
} // class PanelTracker
