package ingdelsw.FallSimulatorProject.Math;

public class Point {
	
	protected double x,y; //coordinate punto

	public Point(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    
    // Metodo equals per confrontare due punti
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point altroPunto = (Point) obj;
        return Double.compare(altroPunto.x, x) == 0 &&
               Double.compare(altroPunto.y, y) == 0;
    }
    
    public double distance(Point otherPoint) {
        double deltaX = otherPoint.getX() - this.x;
        double deltaY = otherPoint.getY() - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
    
    

}
