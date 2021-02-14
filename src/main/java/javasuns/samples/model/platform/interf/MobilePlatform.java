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

package javasuns.samples.model.platform.interf;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import com.gluonhq.attach.browser.BrowserService;
import com.gluonhq.attach.device.DeviceService;
import com.gluonhq.attach.pushnotifications.PushNotificationsService;
import com.gluonhq.attach.share.ShareService;
import com.gluonhq.attach.statusbar.StatusBarService;
import com.gluonhq.attach.util.Services;

import javafx.stage.Screen;
import javafx.stage.Stage;
import javasuns.samples.model.paneltracker.PanelTracker;

public class MobilePlatform extends Platform {
	
   public double getStatusBarHeight() {
	Services.get(StatusBarService.class).ifPresent(service -> {
	    System.err.println(service);
	});
	return 20;
   } // getStatusBarHeight()

   public double getHomeIndicatorHeight() {
	return 20;
   } // getHomeIndicatorHeight()

   public void openURL(String url) {
	Services.get(BrowserService.class).ifPresent(service -> {
	    try {
		service.launchExternalBrowser(url);
	    } catch (IOException | URISyntaxException e) { e.printStackTrace();}
	});
   } // openURL()

   public HashMap<String, String> getDeviceInfo() {
	if(deviceParams == null) {
	    deviceParams = new HashMap<String,String>();
			
	    Services.get(DeviceService.class).ifPresent(service -> {
		deviceParams.put("PLATFORM",    service.getPlatform());
		deviceParams.put("MODEL",       service.getModel());
		deviceParams.put("UUID",        service.getUuid());
		deviceParams.put("VERSION",          service.getVersion());
	    });
	} // if
	return deviceParams;
   } // getDeviceInfo()

   public void registerForNotifications() {
	PushNotificationsService.create().ifPresent(service -> {
	     service.tokenProperty().addListener((observable, oldValue, newValue) -> {
	 	if (newValue != null) {
		    String deviceToken = newValue;
		    PanelTracker.getTracker().getPushNotificationsController().setToken(deviceToken);
	     	} // if
	     });
	     service.register();
	});
   } // registerForNotifications

   public void initPrimaryStage(Stage primaryStage) {
	primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
	primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
   } // initPrimaryStage()

   public void shareContent(String text) {
	Services.get(ShareService.class).ifPresent(service -> service.share(text));
   } // shareContent
	
} // MobilePlatform
