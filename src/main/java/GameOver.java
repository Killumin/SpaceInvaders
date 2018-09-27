//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//public class GameOver {
//	
//
//    public static void endScreen() {
//        // Window
//        Stage window = new Stage();
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle("Game Over!");
//
//        // Labels
//
//        // Buttons
//        GUI test;
//        test = new GUI();
//        Button retry = new Button("Retry!");
//        Button menu = new Button("Back to Menu!");
//        Button close = new Button("Close (for now !!)");
//        retry.setOnAction(e -> test.setScene(test.getGameScene()));
//        menu.setOnAction(e-> test.setScene(test.getMenuScene()));
//        close.setOnAction(e -> window.close());
//
//        // Layout
//        VBox layout = new VBox(20);
//        layout.getChildren().addAll(retry,menu,close);
//        layout.setAlignment(Pos.BASELINE_CENTER);
//
//        // Scene 
//        Scene scene = new Scene(layout,600,600);
//        window.setScene(scene);
//        window.showAndWait();
//    }
//
//}
