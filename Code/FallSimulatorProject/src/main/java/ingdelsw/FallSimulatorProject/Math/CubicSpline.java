package ingdelsw.FallSimulatorProject.Math;

import java.util.ArrayList;

public class CubicSpline extends Curve {

	private ArrayList<Point> controlPoints; // Punti di controllo
    private Double a, b, c, d; // Coefficienti per ogni segmento cubico
    
	public CubicSpline(ArrayList<Point> p) {
		this.controlPoints = p;
        int n = p.size() - 1;

        a = new ArrayList<>(n);
        b = new ArrayList<>(n);
        c = new ArrayList<>(n);
        d = new ArrayList<>(n);

        calcolaCoefficenti();
	}
	
	private void calcolaCoefficenti() {
        int n = x.size() - 1;
        double[] h = new double[n];
        double[] alpha = new double[n];

        for (int i = 0; i < n; i++) {
            h[i] = x.get(i + 1) - x.get(i);
            alpha[i] = (3 / h[i]) * (y.get(i + 1) - y.get(i));
        }

        double[] l = new double[n + 1];
        double[] mu = new double[n];
        double[] z = new double[n + 1];
        l[0] = 1;
        mu[0] = 0;
        z[0] = 0;

        for (int i = 1; i < n; i++) {
            l[i] = 2 * (x.get(i + 1) - x.get(i - 1)) - h[i - 1] * mu[i - 1];
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i] - h[i - 1] * z[i - 1]) / l[i];
        }

        l[n] = 1;
        z[n] = 0;
        c.add(0.0); // c[n] = 0 per condizioni di bordo naturali

        for (int j = n - 1; j >= 0; j--) {
            c.add(0, z[j] - mu[j] * c.get(0));
            b.add(0, (y.get(j + 1) - y.get(j)) / h[j] - h[j] * (c.get(1) + 2 * c.get(0)) / 3);
            a.add(0, y.get(j));
            d.add(0, (c.get(1) - c.get(0)) / (3 * h[j]));
        }
    }

}
