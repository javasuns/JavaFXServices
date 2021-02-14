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
import javafx.scene.layout.BorderPane;
import javasuns.samples.controller.interfaces.Controller;
import javasuns.samples.model.platform.MultiPlatform;

public class BrowserController extends Controller{

	@FXML
	BorderPane rootPane;

	@FXML
	Button btnGluonSamples, btnGluonPlugin, btnJavasuns;

	@FXML
	protected void initialize() {
		headerController.setHeaderText("Browser");
	} // initialize()

	@FXML
	private void buttonPressed(ActionEvent event) {
		String url = null;
		if(event.getSource() == btnGluonSamples)
			url = "https://gluonhq.com/products/mobile/attach";
		else if(event.getSource() == btnGluonPlugin)
			url = "https://github.com/gluonhq/client-gradle-plugin";
		else if(event.getSource() == btnJavasuns)
			url = "https://github.com/javasuns/JavaFXServices";
		
		MultiPlatform.getInstance().openURL(url);
	} // buttonPressed
	
} // class BrowserController
