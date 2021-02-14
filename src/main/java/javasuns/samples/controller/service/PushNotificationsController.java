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

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javasuns.samples.controller.interfaces.Controller;
import javasuns.samples.model.platform.MultiPlatform;


public class PushNotificationsController extends Controller{

	@FXML
	BorderPane rootPane;

	@FXML
	Button btnEnable;
	
	@FXML
	Label lblReadMore, lblToken;
	
	@FXML
	VBox vBoxToken;
	
	private static final String pushNotificationsURL = "https://docs.gluonhq.com/samples/pushnotes/#_sending_a_push_notification";

	@FXML
	protected void initialize() {
		headerController.setHeaderText("Push Notifications");
		vBoxToken.managedProperty().bind(vBoxToken.visibleProperty());
		vBoxToken.visibleProperty().bind(Bindings.isNotEmpty(lblToken.textProperty()));
		
		lblReadMore.setOnMousePressed((event) -> {
			MultiPlatform.getInstance().openURL(pushNotificationsURL);	
		});
		
		btnEnable.setOnAction((event) ->
			MultiPlatform.getInstance().registerForNotifications());
	} // initialize()
	
	public void setToken(String token) {
		lblToken.setText(token);
		System.err.println(lblToken.getText());
	} // setToken()
	
} // class PushNotificationsController
