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


import java.util.HashMap;

import javafx.stage.Stage;

public abstract class Platform {

	protected HashMap<String, String> deviceParams;

	public abstract double getStatusBarHeight();
	
	public abstract double getHomeIndicatorHeight();

	public abstract void openURL(String url);

	public abstract HashMap<String, String> getDeviceInfo();

	public abstract void registerForNotifications();

	public abstract void initPrimaryStage(Stage primaryStage);

	public abstract void shareContent(String text);
	
} // Multiplatform
