package ingdelsw.FallSimulatorProject.Math;

public abstract class Curve {
	
	// Metodo astratto per calcolare un punto sulla curva dato un parametro t
	public abstract Point calcolaPunto(double t);
	
	// Metodo per ottenere la lunghezza della curva 
    public abstract double lunghezza();
	
	public Curve() {
		
	}

}
