package com.oracle.javafx.scenebuilder.kit.preferences;

import javafx.collections.ObservableList;
import javafx.stage.Screen;
import javafx.stage.Stage;

public record WindowPosition(String windowName, double posX, double posY, double width, double height, boolean isFullscreen, boolean isMaximized) {
	public static WindowPosition forStage(String windowName, Stage stage) {
		return new WindowPosition(windowName, stage.getX(), stage.getY(), stage.getWidth(), stage.getY(), stage.isFullScreen(), stage.isMaximized());
	}
	
	public ObservableList<Screen> getScreens() {
		return Screen.getScreensForRectangle(posX, posY, width, height);
	}
}
