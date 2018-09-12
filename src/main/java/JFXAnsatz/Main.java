package JFXAnsatz;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application{
	
		private Stage window;
	    private Scene menuScene;
	    private Scene gameScene;
	    private Button startGameGui;
	    private StackPane menuLayout;
	    private StackPane gameLayout;
	    private Label ueberschrift;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		
//		scene.setOnKeyPressed(e -> {
//            switch (e.getCode()) {
//                case A:
//                    player.moveLeft();
//                    break;
//                case D:
//                    player.moveRight();
//                    break;
//                case W:
//                	player.moveUp();
//                	break;
//                case S:
//                	player.moveDown();
//                	break;
//            }
		
		window = stage;
		window.setScene(menuScene());
        window.setTitle("SpaceInvader");
        window.show();
		
	}
	
	 private Scene menuScene(){

	        //Menu  Buttons
	        startGameGui = new Button("Start Game");
	        startGameGui.setOnAction(e -> {
	        window.setScene(gameScene());
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
	        //Game Layout
	        gameLayout = new StackPane();
	        gameLayout.getChildren().addAll();
	        gameLayout.setBackground(null);
	        //gameLayout.setStyle("-fx-backround-color: #A9A9A9;");
	        gameLayout.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
	        
	        // Game Scene 
	        gameScene = new Scene(gameLayout);
	        window.setFullScreenExitHint("");
	        window.setScene(gameScene);
	        window.setFullScreen(true);

	        return gameScene;
	    }
	 
	    
	    public Scene getMenuScene() {
	    	return menuScene;
	    }
	    
	    public Scene getGameScene() {
	    	return gameScene;
	    }
	    
	    public void setScene(Scene scene) {
	    	window.setScene(scene);
	    }

}