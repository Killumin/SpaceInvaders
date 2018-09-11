import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class GUI extends Application{

    Stage window;
    Scene menu;
    Button startGameGui;
    StackPane layout;
    Label ueberschrift;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        // Buttons
        startGameGui = new Button("Start Game");
        startGameGui.setOnAction(e -> System.out.println("Hello"));
        
        //Labels
        ueberschrift = new Label();
        ueberschrift.setText("Welcome to SpaceInvaders!");
        
        //Layout
        layout = new StackPane();
        layout.getChildren().addAll(ueberschrift, startGameGui);
        layout.setAlignment(Pos.CENTER);
        
        //Scene 
        menu = new Scene(layout,600,600);

        // Window 
        window.setScene(menu);
        window.setTitle("SpaceInvader");
        window.show();
        
    }

    public void setScene(Scene scene) {
        window.setScene(scene);
    }

    public Scene getScene(){
        return menu;
    }
}
