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

package javasuns.samples.controller.service;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javasuns.samples.controller.interfaces.Controller;
import javasuns.samples.model.paneltracker.PanelTracker;


public class ServicesController extends Controller{

	@FXML
	GridPane rootPane;
	
	@FXML
	Button btnDeviceInfo, btnBrowse, btnPushNotifications, btnShareContent;

	@FXML
	private void buttonPressed(ActionEvent event) {
		if(event.getSource() == btnDeviceInfo)
			PanelTracker.getTracker().getActiveTabController().setPane(PanelTracker.getTracker().getDeviceInfoPane());
		else if(event.getSource() == btnBrowse)
			PanelTracker.getTracker().getActiveTabController().setPane(PanelTracker.getTracker().getBrowserPane());
		else if(event.getSource() == btnPushNotifications)
			PanelTracker.getTracker().getActiveTabController().setPane(PanelTracker.getTracker().getPushNotificationsPane());
		else if(event.getSource() == btnShareContent) 
			PanelTracker.getTracker().getActiveTabController().setPane(PanelTracker.getTracker().getShareContentPane());
	} // buttonPressed
	
} // class ServicesController
