package ingdelsw.FallSimulatorProject;

import ingdelsw.FallSimulatorProject.Math.Point;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class InputManager {
	
	private ArrayList<Point> points;
	
	// Costruttore per inizializzare la lista
    public InputManager() {
        points = new ArrayList<>();
    }
    
    public void getPointClick(MouseEvent event) {
    	
    	// Ottenere le coordinate del click
        double x = event.getX();
        double y = event.getY();
        
        if(!points.isEmpty())
        {
        	// Verifica che la coordinata Y del secondo punto sia maggiore
            if (y > points.get(0).getY()) 
            	points.add(new Point(x,y)); // Aggiungi il secondo punto alla lista
            else System.out.println("Il punto deve avere quota inferiore al punto di partenza");
        }
        else if(points.size()>1)
        {
        	if (x > points.get(0).getX()&& x < points.get(1).getX()) 
            	points.add(new Point(x,y)); // Aggiungi il secondo punto alla lista
            else System.out.println("Il punto deve avere quota inferiore al punto di partenza");
        	
        }
        else points.add(new Point(x,y)); // Aggiungi il primo punto alla lista
    }
    
    // Metodo per ottenere la lista di punti
    public ArrayList<Point> getPoints() {
        return points;
    }
	

}
