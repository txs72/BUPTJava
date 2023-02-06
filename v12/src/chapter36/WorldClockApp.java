package chapter36;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WorldClockApp extends Application {     
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(new WorldClockControl(), 450, 350);
    primaryStage.setTitle("WorldClockApp"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
