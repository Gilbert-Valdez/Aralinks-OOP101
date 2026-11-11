package aralinks;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Load the fonts once, before any screen uses them
        for (String weight : List.of("SemiBold", "Bold", "ExtraBold", "Black")) {
            Font.loadFont(App.class.getResourceAsStream("/fonts/Nunito-" + weight + ".ttf"), 14);
        }

        // 2. A tiny test screen: logo, Sparty, a title and a button
        ImageView logo = image("/logo/aralinks-logo.png", 260);
        ImageView sparty = image("/mascot/sparty-waving.png", 160);

        Label title = new Label("Find a peer tutor. Share what you know.");
        title.getStyleClass().add("title");

        Button login = new Button("LOG IN");
        login.getStyleClass().add("btn-primary");
        login.setOnAction(e -> {
            title.setText("It works! 🎉");
            sparty.setImage(new Image(App.class.getResourceAsStream("/mascot/sparty-cheering.png")));
        });

        VBox root = new VBox(18, logo, sparty, title, login);
        root.setAlignment(Pos.CENTER);

        // 3. Put it in a window, attach the stylesheet, set the icon
        Scene scene = new Scene(root, 900, 620);
        scene.getStylesheets().add(App.class.getResource("/aralinks.css").toExternalForm());
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/logo/aralinks-app-icon.png")));
        stage.setTitle("AraLinks");
        stage.setScene(scene);
        stage.show();
    }

    /** Loads a picture from src/main/resources and scales it to the given width. */
    private static ImageView image(String path, double width) {
        ImageView view = new ImageView(new Image(App.class.getResourceAsStream(path)));
        view.setFitWidth(width);
        view.setPreserveRatio(true);
        return view;
    }

    public static void main(String[] args) {
        launch(args);
    }
}