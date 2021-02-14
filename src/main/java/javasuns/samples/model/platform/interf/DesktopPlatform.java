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


import java.net.URI;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import javasuns.samples.Properties;
import javasuns.samples.model.paneltracker.PanelTracker;

public class DesktopPlatform extends Platform {
	
	public double getStatusBarHeight() {
		return 0;
	} // getStatusBarHeight()

	public double getHomeIndicatorHeight() {
			return 0;
	} // getHomeIndicatorHeight()

	public void openURL(String url) {
		try {
			java.awt.Desktop.getDesktop().browse(new URI(url));
		} catch (java.awt.HeadlessException e) {
			PanelTracker.getTracker().showMessage("Open URL is not yet supported for Desktop Native Apps");
		} catch (Exception e) { e.printStackTrace(); }
	} // openURL()

	public HashMap<String, String> getDeviceInfo() {
		if(deviceParams == null) {
			deviceParams = new HashMap<String,String>();

			deviceParams.put("PLATFORM", System.getProperty("os.name"));
			deviceParams.put("MODEL",    System.getProperty("os.arch"));
			deviceParams.put("UUID",     "N/A");
			deviceParams.put("VERSION",       System.getProperty("os.version"));
		} // if
		return deviceParams;
	} // getDeviceInfo()

	public void registerForNotifications() {
		PanelTracker.getTracker().showMessage("This feature is not available for Desktop");
	} // registerForNotifications()

	public void initPrimaryStage(Stage primaryStage) {
		primaryStage.setTitle("JavaFX Services - v" + Properties.version);
		primaryStage.getIcons().add(new Image(DesktopPlatform.class.getResource(
					"/javasuns/samples/image/app_logo.png").toExternalForm()));
		primaryStage.setOnCloseRequest((t) -> { 
			javafx.application.Platform.exit();
			System.exit(0);
		});
	} // initPrimaryStage

	public void shareContent(String text) {
		final ClipboardContent content = new ClipboardContent();
		content.putString(text);
		Clipboard.getSystemClipboard().setContent(content);
		PanelTracker.getTracker().showMessage("Text Copied to Clipboard");
	} // shareContent
} // DesktopPlatform
