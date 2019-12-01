package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class MenuView {
	private static final int H = 600;
	private static final int W = 400;

	private static final double logoSize = W / 2;

	private static final double marging = H / 12;
	private static final double menuXStrat = W / 2;
	private static final double menuYStrat = logoSize + marging;

	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private final String[] menuLabels = { "Play", "Settings", "Exit" };
	private List<MenuButton> menuButtons;

	public MenuView() {
		this.mainPane = new AnchorPane();
		this.mainScene = new Scene(mainPane, W, H);
		this.mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Hez2");
		addBackground();
		addMenuButtons();
		addMenuButtonListner();
		addLogo();
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public void show() {
		mainStage.show();
	}

	private void addBackground() {
		Image backgroundImage = new Image("resources/background2.png", W, H, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}

	private void addMenuButtonListner() {
		menuButtons.get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				mainStage.hide();
				GameView game = new GameView();
//				game.show();
			}
		});
		menuButtons.get(menuButtons.size() - 1).setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				mainStage.hide();
			}
		});

	}

	private void addMenuButtons() {
		menuButtons = new ArrayList<MenuButton>();
		int i = 0;
		for (String label : menuLabels) {
			double x = menuXStrat - MenuButton.getButtonWidth() / 2;
			double y = menuYStrat + (MenuButton.getButtonHeight() / 2 + marging) * (i++);
			System.out.println("x :" + x + " ,y :" + y);
			MenuButton button = new MenuButton(label, x, y);
			menuButtons.add(button);
			mainPane.getChildren().add(button);

		}
		addMenuButtonListner();
	}

	private void addLogo() {
		Image image = new Image("resources/logo.png", logoSize, logoSize, false, true);
		ImageView iv = new ImageView(image);
		iv.setX(W / 2 - logoSize / 2);
		iv.setY(10);
		mainPane.getChildren().add(iv);
	}
}
