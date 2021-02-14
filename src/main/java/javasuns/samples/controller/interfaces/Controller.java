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

package javasuns.samples.controller.interfaces;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javasuns.samples.controller.header.HeaderController;
import javasuns.samples.model.paneltracker.PanelTracker;
import javasuns.samples.model.platform.MultiPlatform;

public abstract class Controller {
	
	@FXML
	protected HeaderController headerController;

	public void goToPreviousPane() {
		PanelTracker.getTracker().getActiveTabController().goToPreviousPane();
	}

	protected void addTopPadding(Region pane) {
		pane.setPadding(
				new Insets(MultiPlatform.getInstance().getStatusBarHeight(), 0, 0, 0));
	} // addTopPadding()

	protected void addBottomPadding(Region pane) {
		pane.setPadding(
				new Insets(0, 0, MultiPlatform.getInstance().getHomeIndicatorHeight(), 0));
	} // addBottomPadding()
} // abstract class Controller

