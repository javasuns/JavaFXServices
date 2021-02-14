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

package javasuns.samples.model.platform;

import javasuns.samples.model.platform.interf.DesktopPlatform;
import javasuns.samples.model.platform.interf.MobilePlatform;
import javasuns.samples.model.platform.interf.Platform;

public abstract class MultiPlatform {
	
	private static Platform multiPlatform;
	
	public static Platform getInstance() {
		if(multiPlatform == null) {
			if(isDesktop())
				multiPlatform = new DesktopPlatform();
			else if(isIOS() || isAndroid())
				multiPlatform = new MobilePlatform();
		} // if
		return multiPlatform;
	} // getInstance()
	
	static {
		platform = System.getProperty("javafx.platform","desktop").toUpperCase();
	}
	
	private static String platform;
	private static boolean isAndroid() { return platform.equals("ANDROID"); }
	private static boolean isDesktop() { return platform.equals("DESKTOP"); }
	private static boolean isIOS() { return platform.equals("IOS"); }
} // Multiplatform
