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
    	 
    	BorderPane root = new BorderPane();//imposto il layout della finestra
    	 
    	// Pannello di sinistra per i pulsanti
        VBox leftPane = createLeftPane();  // 10 pixel di spaziatura tra i pulsanti
         
        //definizioni pulsanti
        Button buttonCycloid = new Button("Cicloide");  
        Button buttonCircle = new Button("Circonferenza");
        Button buttonParabola = new Button("Parabola");
        Button startSimulation = new Button("\u25B6"); // Simbolo di Play (triangolo)
    
        // Aggiungiamo i pulsanti al pannello di sinistra
        leftPane.getChildren().addAll(buttonCycloid, buttonCircle, buttonParabola);

        // Pannello di destra che rileva i click del mouse
        Pane rightPane = new Pane();
        rightPane.setStyle("-fx-background-color: lightgray;"); // Colore di sfondo
        rightPane.setMinSize(300, 300);  // Impostiamo la dimensione minima
        rightPane.setOnMouseClicked(inputManager::getPointClick); // Collegare il gestore del click del mouse
        
        // configurazione del layout
        root.setLeft(leftPane);
        root.setCenter(rightPane);
        
        // Creiamo la scena
        Scene scene = new Scene(root, 600, 400);
        
        // Impostiamo lo stage e mostriamo la finestra
        primaryStage.setTitle("Fall Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private VBox createLeftPane() {
        VBox leftPane = new VBox(10);  // Layout verticale con spaziatura di 10px tra i nodi
        leftPane.setPadding(new Insets(10));  // Imposta un padding interno di 10px
        leftPane.setPrefWidth(200);  // Imposta la larghezza preferita a 200px
        leftPane.setStyle("-fx-border-color: black;");  // Aggiunge un bordo al pannello

        // Creazione dell'etichetta per le istruzioni
        Label instructionsLabel = new Label("Inserisci i punti cliccando\nsul pannello a destra.");
        instructionsLabel.setWrapText(true);  // Consente il testo su più righe

        // Creazione dei pulsanti per resettare i punti e disegnare la spline
        Button resetButton = new Button("Resetta Punti");
        Button drawButton = new Button("Fine Immissione");

        // Salva i pulsanti nei rispettivi campi in modo che possano essere usati in InputManager
        setResetButton(resetButton);
        setDrawButton(drawButton);

        // Allineamento al top e aggiunta dei componenti al pannello di sinistra
        leftPane.setAlignment(Pos.TOP_CENTER);
        leftPane.getChildren().addAll(instructionsLabel, resetButton, drawButton);
        return leftPane;  // Restituisce il pannello configurato
    }

    public static void main(String[] args) {
        launch(args);
    }
}

