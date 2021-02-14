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

package javasuns.samples.support.animations;



import java.util.concurrent.atomic.AtomicBoolean;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TabAnimation {

	private static Timeline animation;
	private static Duration speed = Duration.millis(300);
	private static Parent animatingNode;
	private static AtomicBoolean  animating = new AtomicBoolean (false);
	
	private static Interpolator easeOut = new Interpolator() {
		protected double curve(double t) { return (t == 1.0) ? 1.0 : 1 - Math.pow(2.0, -10 * t); }
	};

	static {
		animation = new Timeline();
		addFinishedAction((event) -> {
			synchronized(animating) {
				animating.set(false);
				animating.notifyAll();
			}
		});
	} // static

	public static void playSwitchPaneIn(Pane tabPane, Pane child) {
		// Ignore if there is a running animation 
		if(animating.get())
			return;
		
		animatingNode = child;
		tabPane.getChildren().add(animatingNode);
		animatingNode.translateXProperty().set(tabPane.getWidth());
		animation.getKeyFrames().clear();
		animation.getKeyFrames().add(new KeyFrame(speed, new KeyValue(animatingNode.translateXProperty(), 0, easeOut)));

		playAnimation();
	} // playSwitchPaneIn()

	// Play node OUT transition and then remove it from its parent.
	public static void playSwitchPaneOut(Parent child) {
		// Ignore if there is a running animation 
		if(animating.get())
			return;
		
		animation.getKeyFrames().clear();
		animation.getKeyFrames().add(new KeyFrame(speed, removeNodeFromParent, new KeyValue(child.translateXProperty(),child.getScene().getWidth(), easeOut)));
		animatingNode = child;
		playAnimation();
	} // playSwitchPaneOut()

	public static void addFinishedAction(EventHandler<ActionEvent> eventHandler) {
		animation.setOnFinished(eventHandler);
	} // addFinishedAction()

	private static void playAnimation() {
			animation.play();
			synchronized(animating) {
				animating.set(true);
			}
	} // playAnimation()

	private final static EventHandler<ActionEvent> removeNodeFromParent = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent arg0) {
			DoubleProperty dp = (DoubleProperty) ((KeyValue) ((KeyFrame) (arg0.getSource())).getValues().toArray()[0]).getTarget();
			Node child = (Pane) dp.getBean();
			Pane tabPane = ((Pane)child.getParent());
			tabPane.getChildren().remove(child);
		} // handle()
	};
	
} // TabAnimation
