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

package javasuns.samples.controller.popup;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javasuns.samples.controller.interfaces.Controller;

public class MessageController extends Controller {

	@FXML
	private StackPane stackPane;

	@FXML
	private VBox dialogPane;

	@FXML
	private Label lblMessage;

	private Duration defaultDuration = Duration.millis(800);
	private SequentialTransition seqT;
	private PauseTransition pt;
	private FadeTransition ftIN, ftOUT;
	private int pauseTime;


	@FXML
	protected void initialize() {
		addTopPadding(stackPane);
		ftIN = new FadeTransition(defaultDuration, dialogPane);
		ftIN.setFromValue(0);
		ftIN.setToValue(1.0);
		pt = new PauseTransition(Duration.millis(pauseTime));
		ftOUT = new FadeTransition(defaultDuration, dialogPane);
		ftOUT.setToValue(0);
		ftOUT.setOnFinished((event) -> {
				hideMessagePane();
		});
		seqT = new SequentialTransition(ftIN, pt, ftOUT);
		seqT.setCycleCount(1);
	} // initialize

	public void setMessageProperties(String text, double seconds, String bColor, String fColor) {
		lblMessage.setText(text);
		lblMessage.setStyle("-fx-text-fill: " + (fColor == null  ? " black" : fColor) +
								  "; -fx-background-color: " + (bColor == null ? " white;" : bColor));
		pt.setDelay(Duration.millis(seconds * 1000));
		ftIN.setDuration(defaultDuration);
		ftOUT.setDuration(defaultDuration);
	} // setMessageProperties()

	private void hideMessagePane() {
		if(stackPane.getParent() == null)
			return;
		((Pane) stackPane.getParent()).getChildren().remove(stackPane);
		seqT.stop();
	} // hideMessagePane()

	public void showPopup() {
		seqT.play();
	} // showMessage()

} // class MessageController
