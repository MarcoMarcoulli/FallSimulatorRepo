package ingdelsw.FallSimulatorProject;

import java.awt.Color;

public class Mass {
	
	private double x;
	private double y;
	
	private double vx;
	private double vy;
	
	private double raggio;
	
	private Color colore;        // Colore del corpo
	
	private double time;
	
	// Metodo per aggiornare la posizione basata su velocità e accelerazione
    public void aggiornaPosizione(double deltaTime) {

        // Aggiornare posizione
        this.x += vx * deltaTime;
        this.y += vy * deltaTime;

        // Incrementa il tempo
        this.time += deltaTime;
    }



	public Mass() {
	}

}
