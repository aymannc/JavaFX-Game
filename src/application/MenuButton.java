package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MenuButton extends Button {
    private static final int BUTTON_HEIGHT = 45;
    private static final int BUTTON_WIDTH = 190;
    private final String FONT_PATH = "src/resources/Tomorrow-Regular.ttf";
    private final String RELEASED_STYLE = "-fx-text-fill: white;-fx-background-image:url('/resources/red_button01.png')";
    private final String CLICKED_STYLE = "-fx-text-fill: white;-fx-background-image:url('/resources/red_button02.png')";

    public static int getButtonHeight() {
        return BUTTON_HEIGHT;
    }

    public static int getButtonWidth() {
        return BUTTON_WIDTH;
    }

    public MenuButton(String string, double x, double y) {
        setText(string);
        setButtonFont();
        setPrefHeight(BUTTON_HEIGHT);
        setPrefWidth(BUTTON_WIDTH);
        setButtonReleasedStyle();
        initializeButtonListners();
        setLayoutX(x);
        setLayoutY(y);
    }

    private void setButtonFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            setFont(Font.font("arial", 23));
        }
    }

    private void setButtonClickedStyle() {
        setStyle(CLICKED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleasedStyle() {
        setStyle(RELEASED_STYLE);
        setPrefHeight(50);
        setLayoutY(getLayoutY() - 4);
    }

    private void initializeButtonListners() {

        setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setButtonClickedStyle();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setButtonReleasedStyle();
            }
        });
    }
}
