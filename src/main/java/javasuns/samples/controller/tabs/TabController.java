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

package javasuns.samples.controller.tabs;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javasuns.samples.controller.interfaces.Controller;
import javasuns.samples.support.animations.TabAnimation;

public class TabController extends Controller{

	@FXML
	AnchorPane tabPane;

	public void setPane(Parent pane) {
		Platform.runLater(() -> TabAnimation.playSwitchPaneIn(tabPane, (Pane) pane));
	} // setPane()

	public void goToPreviousPane() {
		Platform.runLater(() -> TabAnimation.playSwitchPaneOut(getShowingPane()));
	} // goToPreviousPane()
	
	private Pane getShowingPane() {
		return (Pane) tabPane.getChildren().get(tabPane.getChildren().size()-1);
	} // getShowingPane()

} // class TabController
