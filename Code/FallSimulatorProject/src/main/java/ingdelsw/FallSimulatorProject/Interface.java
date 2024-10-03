package ingdelsw.FallSimulatorProject;

import java.awt.Label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application {
    
    // Gestore degli input utente, responsabile della gestione dei clic e dell'interazione con la GUI
    private InputManager inputManager;
    
    @Override
    public void start(Stage primaryStage) {
    	
    	// Creare il gestore di input
        InputManager inputManager = new InputManager();
    	 
    	BorderPane borderPane = new BorderPane();//imposto il layout della finestra
    	 
    	// Pannello di sinistra per i pulsanti
        VBox leftPanel = new VBox(20);  // 10 pixel di spaziatura tra i pulsanti
         
        //definizioni pulsanti
        Button buttonCycloid = new Button("Cicloide");  
        Button buttonCircle = new Button("Circonferenza");
        Button buttonParabola = new Button("Parabola");
        Button startSimulation = new Button("\u25B6"); // Simbolo di Play (triangolo)
    
        // Aggiungiamo i pulsanti al pannello di sinistra
        leftPanel.getChildren().addAll(buttonCycloid, buttonCircle, buttonParabola);

        // Pannello di destra che rileva i click del mouse
        Pane rightPanel = new Pane();
        rightPanel.setStyle("-fx-background-color: lightgray;"); // Colore di sfondo
        rightPanel.setMinSize(300, 300);  // Impostiamo la dimensione minima
        rightPanel.setOnMouseClicked(inputManager::getPointClick); // Collegare il gestore del click del mouse
        
        // configurazione del layout
        borderPane.setLeft(leftPanel);
        borderPane.setCenter(rightPanel);
        
        // Creiamo la scena
        Scene scene = new Scene(borderPane, 600, 400);
        
        // Impostiamo lo stage e mostriamo la finestra
        primaryStage.setTitle("Fall Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

