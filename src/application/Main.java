package application;

import java.io.File;
import java.io.IOException;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import application.SimpleFileTreeItem;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	private double xOffset = 500;
	private double yOffset = 0;

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) {
		
		Rectangle2D pSB = Screen.getPrimary().getVisualBounds();
		double height = pSB.getHeight();
		double width = pSB.getWidth();
		
		double sceneWidth = width / 4.0;
		double sceneHeight = height * 0.9;
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		BorderPane root = new BorderPane();

		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});

		final ContextMenu cm = new ContextMenu();
		MenuItem menu1 = new MenuItem("First Menu");
		Menu menu = new Menu("Second Menu ");
		MenuItem submenu = new MenuItem("First Sub Menu");
		MenuItem submenu1 = new MenuItem("Second Sub Menu");
		MenuItem menu3 = new MenuItem("Third Menu");
		cm.getItems().add(menu1);
		cm.getItems().add(menu);
		menu.getItems().add(submenu);
		menu.getItems().add(submenu1);
		cm.getItems().add(menu3);
		cm.getStyleClass().add("myCm");
		cm.setStyle("-fx-background-color: rgba(1, 1, 1, 1); -fx-background-radius: 0;");
		cm.setOpacity(0.8);

		String OS = System.getProperty("os.name");
		String username = System.getProperty("user.name");

		System.out.println("detected OS = " + OS);

		String path = "/home/leo-kogler/";

		if (OS.equals("Linux")) {
			path = "/home/" + username;
		} else if (OS.equals("Windows")) {
			path = "C:/Users/" + username;
		}

		try {
			TreeView<File> fileView = new TreeView<File>(new SimpleFileTreeItem(new File(path)));
			fileView.getStyleClass().add("myTree");
			fileView.setStyle("-fx-background-color: rgba(1, 1, 1, 1); -fx-background-radius: 0;");

			fileView.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					xOffset = event.getSceneX();
					yOffset = event.getSceneY();
					cm.hide();
				}
			});
			fileView.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					primaryStage.setX(event.getScreenX() - xOffset);
					primaryStage.setY(event.getScreenY() - yOffset);
				}
			});

			fileView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					if (e.getButton() == MouseButton.SECONDARY) {

						// cm.setX(e.getSceneX());
						// cm.setX(e.getSceneX());
						// String string = fileView.getChildrenUnmodifiable();
						System.out.println("Desired Click");

						SimpleFileTreeItem selectedItem = (SimpleFileTreeItem) fileView.getSelectionModel()
								.getSelectedItem();
						if (selectedItem != null) {
							String pathString = selectedItem.getValue().toString();
							System.out.println("stringPath : " + pathString);
							StringSelection stringSelection = new StringSelection(pathString);
							Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
							clpbrd.setContents(stringSelection, null);

							try {
								if (OS.equals("Linux")) {
									
									String command = "thunar " + pathString;
									
									Runtime.getRuntime().exec(command);

								} else if (OS.equals("Windows")) {

									Runtime.getRuntime().exec("explorer.exe /select," + pathString);
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

						cm.show(root, e.getScreenX(), e.getScreenY());
					} else {
						System.out.println("No right click");
					}
					e.consume();
				}
			});

			root.setCenter(fileView);
		} catch (Exception e) {
			System.out.println(e);
		}

		Scene scene = new Scene(root, sceneWidth, sceneHeight, Color.rgb(0, 0, 0, 1));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setX(width - sceneWidth - 20.0);
		primaryStage.setY(-10.0);
		primaryStage.setScene(scene);
		primaryStage.setOpacity(0.6);
		primaryStage.show();
	}
}