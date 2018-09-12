import Events.GUIListener;
import Events.GameOverEvent;
import Events.StarshipMovedEvent;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ControllerUndKI.StarshipController;

public class GUI extends Application implements GUIListener{

    private Stage window;
    private Scene menuScene;
    private Scene gameScene;
    private Button startGameGui;
    private Button returnMenu;
    private StackPane menuLayout;
    private StackPane gameLayout;
    private Label ueberschrift;
    
    public static void main(String[] args) {
		launch(args);
	}
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        // Window 
        window.setScene(menueScene());
        window.setTitle("SpaceInvader");
        window.show();
    }

    private Scene menueScene(){
    	// Shit 
		Map map = new Map();
		map.generate(0);
		Starship s = new Starship(map, map.getField(4, 15), null);
		Game g = new Game(map, s);
		g.addGUIListener(this);
    	// end shit
        //Menu  Buttons
        startGameGui = new Button("Start Game");
        startGameGui.setOnAction(e -> {
            window.setScene(gameScene());
            g.start();
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
        gameLayout.getChildren();
        gameLayout.setAlignment(Pos.CENTER);

        // Game Scene 
        gameScene = new Scene(gameLayout);
        window.setFullScreenExitHint("");
        window.setScene(gameScene);
        window.setFullScreen(true);

        return gameScene;
    }

	@Override
	public void gameOver(GameOverEvent event) {
		System.out.println("Hello im a event!");
		GameOver.endScreen();
	}

	@Override
	public void starshipMoved(StarshipMovedEvent event) {
		System.out.println("GUI Notified");
	}
}
