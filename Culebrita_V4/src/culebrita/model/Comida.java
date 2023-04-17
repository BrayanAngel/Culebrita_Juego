package culebrita.model;

import java.awt.Point;
import java.util.Random;

public class Comida {
    private Point posicion;

    public Comida() {
        nuevaComida();
    }

    public void nuevaComida() {
        Random random = new Random();
        int x = random.nextInt(Culebrita.ANCHO - Culebrita.TAMANIO_CELDA);
        int y = random.nextInt(Culebrita.ALTO - Culebrita.TAMANIO_CELDA);
        posicion = new Point(x, y);
    }
    

    public Point getPosicion() {
        return posicion;
    }

	/**
	 * @return
	 */
	public int getPuntos() {
		    int puntos = 0;
			return puntos;
		}

	/**
	 * 
	 */
	public void mover() {
		// TODO Auto-generated method stub
		
	}
}

