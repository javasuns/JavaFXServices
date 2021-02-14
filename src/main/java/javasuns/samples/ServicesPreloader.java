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

package javasuns.samples;

import javafx.application.Preloader;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javasuns.samples.model.paneltracker.PanelTracker;
import javasuns.samples.model.platform.MultiPlatform;

public class ServicesPreloader extends Preloader {

	private String cssFile  = getClass().getResource("/javasuns/samples/css/Main.css").toExternalForm();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane scenePane = new AnchorPane();
		scenePane.getStylesheets().add(cssFile);
		
		PreLoader preLoader = getPreloader();
		scenePane.getChildren().add(preLoader);
		primaryStage.setScene(new Scene(scenePane));
		primaryStage.show();
		preLoader.showIndicator();
		
		MultiPlatform.getInstance().initPrimaryStage(primaryStage);
		PanelTracker.init(scenePane);
	} // start()
	
	private PreLoader getPreloader() {

		PreLoader preLoader = new PreLoader();
		
		AnchorPane.setTopAnchor(preLoader, 0.0);
		AnchorPane.setBottomAnchor(preLoader, 0.0);
		AnchorPane.setLeftAnchor(preLoader, 0.0);
		AnchorPane.setRightAnchor(preLoader, 0.0);
		return preLoader;
	} // getPreloader()

	/**********************************************
	 * PreLoader Inner Class
	 **********************************************/
	private class PreLoader extends BorderPane {
		private VBox vbox;

		public PreLoader() {
			vbox = new VBox();
			vbox.getStyleClass().add("preLoader");
			vbox.setMaxWidth(Double.POSITIVE_INFINITY);
			vbox.setMaxHeight(Double.POSITIVE_INFINITY);

			Region rgnLogo = new Region();
			rgnLogo.getStyleClass().add("img_javasuns_logo");
			rgnLogo.getStyleClass().add("size_image_large");
			rgnLogo.setCache(true);
			rgnLogo.setCacheHint(CacheHint.QUALITY);

			vbox.getChildren().add(rgnLogo);

			this.setCenter(vbox);
			this.setMaxWidth(Double.POSITIVE_INFINITY);
		} // Constructor Method

		public void showIndicator() {
			ProgressIndicator prgIndicator = new ProgressIndicator();
			prgIndicator.setStyle("-fx-pref-height: 5em; -fx-pref-width: 5em; -fx-max-height: 5em; -fx-min-height: 5em");
			StackPane centerPane = new StackPane();
			centerPane.getChildren().add(prgIndicator);
			centerPane.setStyle("-fx-padding: 0 0 14em 0;");
			vbox.getChildren().add(centerPane);
			Label pane = new Label("v" + Properties.version);
			pane.setStyle("-fx-text-fill: -fx-main-color");
			pane.setMaxHeight(1.7976931348623157E308);
			pane.setMaxWidth(1.7976931348623157E308);
			pane.setAlignment(Pos.BOTTOM_CENTER);
			vbox.getChildren().add(pane);

			VBox.setVgrow(centerPane, Priority.ALWAYS);
		} // showIndicator()
	} // class PreLoader
} // class ServicesPreloader
