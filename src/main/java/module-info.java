module javasuns.samples {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.web;
	requires transitive javafx.graphics;
	requires jdk.jsobject;
	requires java.desktop;
	
	// Gluon Attach Services
	requires com.gluonhq.attach.browser;
	requires com.gluonhq.attach.device;
	requires com.gluonhq.attach.pushnotifications;
	requires com.gluonhq.attach.runtimeargs;
	requires com.gluonhq.attach.share;
	requires com.gluonhq.attach.statusbar;
	requires com.gluonhq.attach.util;
	
	// Required to start a JavaFX Application
	opens   javasuns.samples to javafx.graphics;
	exports javasuns.samples to javafx.graphics;
	
	// FXML Resources
	exports javasuns.samples.controller to javafx.fxml;
	opens   javasuns.samples.controller to javafx.fxml;
	
	exports javasuns.samples.controller.tabs to javafx.fxml;
	opens   javasuns.samples.controller.tabs to javafx.fxml;
	
	exports javasuns.samples.controller.header to javafx.fxml;
	opens   javasuns.samples.controller.header to javafx.fxml;
	
	exports javasuns.samples.controller.service to javafx.fxml;
	opens   javasuns.samples.controller.service to javafx.fxml;
	
	exports javasuns.samples.controller.interfaces to javafx.fxml;
	opens   javasuns.samples.controller.interfaces to javafx.fxml;
	
	exports javasuns.samples.model.paneltracker.fxml to javafx.fxml;
	opens   javasuns.samples.model.paneltracker.fxml to javafx.fxml;
	
	exports javasuns.samples.controller.popup to javafx.fxml;
	opens   javasuns.samples.controller.popup to javafx.fxml;
}