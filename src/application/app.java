package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class app extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        MenuView menu = new MenuView();
        menu.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Ended");
    }

}

