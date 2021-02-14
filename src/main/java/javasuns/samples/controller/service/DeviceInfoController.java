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

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javasuns.samples.controller.interfaces.Controller;
import javasuns.samples.model.platform.MultiPlatform;


public class DeviceInfoController extends Controller{

	@FXML
	BorderPane rootPane;

	@FXML
	Label lblPlatform, lblModel, lblUUID, lblVersion;

	@FXML
	protected void initialize() {
		headerController.setHeaderText("Device Info");
		
		lblPlatform.setText(MultiPlatform.getInstance().getDeviceInfo().get("PLATFORM"));
		lblModel.setText(MultiPlatform.getInstance().getDeviceInfo().get("MODEL"));
		lblVersion.setText(MultiPlatform.getInstance().getDeviceInfo().get("VERSION"));
		lblUUID.setText(MultiPlatform.getInstance().getDeviceInfo().get("UUID"));
	} // initialize()
	
} // class DeviceInfoController
