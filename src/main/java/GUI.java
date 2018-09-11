import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class GUI extends Application{

    Stage window;
    Scene menuScene;
    Scene gameScene;
    Button startGameGui;
    Button returnMenu;
    StackPane menuLayout;
    StackPane gameLayout;
    Label ueberschrift;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        // Window 
        window.setScene(menueScene());
        window.setTitle("SpaceInvader");
        window.show();
    }

    private Scene menueScene(){
        //Menu  Buttons
        startGameGui = new Button("Start Game");
        startGameGui.setOnAction(e -> {
            window.setScene(gameScene());
            GameOver.endScreen();
        });
             
        //Menu Labels
        ueberschrift = new Label();
        ueberschrift.setText("Welcome to SpaceInvaders!");


        //Menu Layout
        menuLayout = new StackPane();
        menuLayout.getChildren().addAll(ueberschrift, startGameGui);
        menuLayout.setAlignment(Pos.CENTER);

        // Menu Scene 
        int width = 600;
        menuScene = new Scene(menuLayout, width, width);

        return menuScene;
    }

    
    private Scene gameScene(){
        //Game Button 
        //returnMenu = new Button("Return to Menu!");
        //returnMenu.setOnAction(e -> window.setScene(menuScene));

        //Game Layout
        gameLayout = new StackPane();
        //gameLayout.getChildren().add(returnMenu);
        //gameLayout.setAlignment(Pos.BOTTOM_CENTER);

        // Game Scene 
        gameScene = new Scene(gameLayout);
        window.setFullScreenExitHint("");
        window.setScene(gameScene);
        window.setFullScreen(true);

        return gameScene;
    }
}
