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

package javasuns.samples.controller.header;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javasuns.samples.controller.interfaces.Controller;

public class HeaderController extends Controller {

	@FXML
	HBox headerPane;

	@FXML
	Label lblTitle;

	@FXML
	Button btnBack;

	@FXML
	protected void initialize() {
		addTopPadding(headerPane);
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
			super.goToPreviousPane();
		
	} // handleButtonAction

	public void setHeaderText(String text) {
		lblTitle.setText(text);
	} // setHeaderText()
	
	public void hideBackButton() {
		btnBack.setVisible(false);
		btnBack.setDisable(true);
	}
	
	public void showBackButton() {
		btnBack.setDisable(false);
		btnBack.setVisible(true);
	}

} // class HeaderController
